$(document).ready(function () {
    const salesChartCanvas = document.getElementById('allPurchases');
    const organizationId = document.getElementById('organizationId').value;
    let salesChart = null;

    let doughnutPieOptions = {
        responsive: true,
        animation: {
            animateScale: true,
            animateRotate: true
        }
    };


    function updateChart() {
        if (salesChart) {
            salesChart.destroy();
        }

        $.ajax({
            url: `http://192.168.43.33:8082/api/organizations/diagram/${20}`,
            method: 'GET',
            dataType: 'json',
            success: function (response) {
                const data = response.data;
                const months = data.map(item => item.status);
                const sales = data.map(item => item.count);

                const chartData = {
                    labels: months,
                    datasets: [{
                        label: 'Все тендера',
                        data: sales,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.5)',
                            'rgba(54, 162, 235, 0.5)',
                            'rgba(255, 206, 86, 0.5)',
                            'rgba(75, 192, 192, 0.5)',
                            'rgba(153, 102, 255, 0.5)',
                            'rgba(255, 159, 64, 0.5)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1,
                    }],
                };

                salesChart = new Chart(salesChartCanvas, {
                    type: 'doughnut',
                    data: chartData,
                    options: doughnutPieOptions,
                });
            },

            error: function (error) {
                alert("Произошла ошибка при загрузке данных. Попробуйте перезагрузить страницу");
            },
        });
    }

    updateChart();
});
