// add hovered class to selected list item
let list = document.querySelectorAll(".navigation li");

function activeLink() {
    list.forEach((item) => {
        item.classList.remove("hovered");
    });
    this.classList.add("hovered");
}

list.forEach((item) => item.addEventListener("mouseover", activeLink));

// Menu Toggle
let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
    navigation.classList.toggle("active");
    main.classList.toggle("active");
};


    document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("DashboardF").style.display = 'inline-block';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
});

    document.getElementById("DashboardForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'inline-block';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
});

    document.getElementById("CarForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'inline-block';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
});
    document.getElementById("CustomerForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'inline-block';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
});
    document.getElementById("DriverForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'inline-block';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'none';
});
    document.getElementById("CarRentalForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'inline-block';
    document.getElementById("PaymentF").style.display = 'none';
});
    document.getElementById("PaymentForm").addEventListener('click', function () {
    document.getElementById("DashboardF").style.display = 'none';
    document.getElementById("CarF").style.display = 'none';
    document.getElementById("CustomerF").style.display = 'none';
    document.getElementById("DriverF").style.display = 'none';
    document.getElementById("CarRentalF").style.display = 'none';
    document.getElementById("PaymentF").style.display = 'inline-block';
});

