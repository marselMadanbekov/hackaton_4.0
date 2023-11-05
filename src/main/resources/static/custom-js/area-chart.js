$(document).ready(function () {
    const salesChartCanvas = document.getElementById('areaChart');
    const prevMonthButton = document.getElementById('prevMonthButtonArea');
    const nextMonthButton = document.getElementById('nextMonthButtonArea');
    const organizationId = document.getElementById('organizationId').value;
    let month = 0;
    let salesChart = null;



    prevMonthButton.addEventListener('click', function (e) {
        e.preventDefault();
        month += 1;
        updateChart();
    });

    nextMonthButton.addEventListener('click', function (e) {
        e.preventDefault();
        if (month > 0) {
            month -= 1;
            updateChart();
        } else {
            alert("Следующие месяцы недоступны");
        }
    });


    function updateChart() {
        if (salesChart) {
            salesChart.destroy();
        }

        $.ajax({
            url: `http://192.168.43.33:8082/api/organizations/success/graphic/${20}?month=` + month,
            method: 'GET',
            dataType: 'json',
            success: function (response) {
                const data = response.data;
                const months = data.map(item => item.month);
                const sales = data.map(item => item.sum_price);

                const chartData = {
                    labels: months,
                    datasets: [{
                        label: 'Успешно завершенные',
                        data: sales,
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1,
                        fill: true
                    }],
                };

                salesChart = new Chart(salesChartCanvas, {
                    type: 'line',
                    data: chartData,
                    options: {
                        responsive: true,
                        scales: {
                            y: {
                                beginAtZero: true,
                            },
                        },
                    },
                });
            },

            error: function (error) {
                alert("Произошла ошибка при загрузке данных. Попробуйте перезагрузить страницу");
            },
        });
    }

    updateChart();
});
