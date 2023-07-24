// home
const carousel = document.querySelector('.carousel');
const items = carousel.querySelectorAll('.carousel__item');


carousel.parentNode.insertBefore(prevBtn, carousel);
carousel.parentNode.insertBefore(nextBtn, carousel.nextSibling);

let scrollPosition = 0;
const itemWidth = items[0].offsetWidth + parseInt(window.getComputedStyle(items[0]).marginRight);

function handlePrevClick() {
    if (scrollPosition > 0) {
        scrollPosition -= itemWidth;
        carousel.scroll({
            left: scrollPosition,
            behavior: 'smooth'
        });
    }
}

function handleNextClick() {
    if (scrollPosition < (carousel.scrollWidth - carousel.offsetWidth)) {
        scrollPosition += itemWidth;
        carousel.scroll({
            left: scrollPosition,
            behavior: 'smooth'
        });
    }
}

prevBtn.addEventListener('click', handlePrevClick);
nextBtn.addEventListener('click', handleNextClick);

//change password
function submitForm() {
    var oldPassword = document.getElementById("old-password").value;
    var newPassword = document.getElementById("new-password").value;
    var confirmPassword = document.getElementById("confirm-password").value;
    if (oldPassword.trim() === "") {
        document.getElementById("error-old-password").innerHTML = "Please enter old password";
        return false;
    } else {
        document.getElementById("error-old-password").innerHTML = "";
    }
    if (oldPassword !== "${sessionScope.currUser.password}") {
        document.getElementById("error-old-password").innerHTML = "Old password is not correct";
        return false;
    } else {
        document.getElementById("error-old-password").innerHTML = "";
    }
    if (newPassword.length < 6) {
        document.getElementById("error-new-password").innerHTML = "Password must be greater than 6 characters";
        return false;
    } else {
        document.getElementById("error-new-password").innerHTML = "";
    }
    if (confirmPassword !== newPassword) {
        document.getElementById("error-confirm-password").innerHTML = "Confirm password not same as password";
        return false;
    } else {
        document.getElementById("error-confirm-password").innerHTML = "";
    }
    return true;
}