document.addEventListener('DOMContentLoaded', function () {
    const activateDeactivateButton = document.getElementById('purchases-filter-form');

    activateDeactivateButton.addEventListener("submit", function (e) {
        e.preventDefault();
        let categoryId = document.getElementById("category").value;
        window.location.href = '/purchases/by-filters?categoryId=' + categoryId;
    })
});
