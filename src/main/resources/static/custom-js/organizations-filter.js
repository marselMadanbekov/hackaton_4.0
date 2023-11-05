document.addEventListener('DOMContentLoaded', function () {
    const activateDeactivateButton = document.getElementById('organizations-filter-form');

    activateDeactivateButton.addEventListener("submit", function (e) {
        e.preventDefault();
        let url = '/organizations/by-filters?';

        let name = document.getElementById("name").value;
        let inn = document.getElementById("inn").value;
        let okpo = document.getElementById("okpo").value;
        let registration_number = document.getElementById("registration_number").value;
        let legal_address = document.getElementById("legal_address").value;

        if (name != null && name !== '')
            url += 'name=' + name +'&';
        if (inn != null && inn !== '')
            url += 'inn=' + inn  +'&';
        if (okpo != null && okpo !== '')
            url += 'okpo=' + okpo  +'&';
        if (registration_number != null && registration_number !== '')
            url += 'registration_number=' + registration_number  +'&';
        if (legal_address != null && legal_address !== '')
            url += 'legal_address=' + legal_address  +'&';

        window.location.href = url;

    })
});
