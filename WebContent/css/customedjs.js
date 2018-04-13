

jQuery(function () {
    var message = document.getElementById("message").value;
    if (message == null) {
        jQuery('#test').click();
    }

});

function calculatebmi() {
    var height = document.getElementById("height").value;
    var weight = document.getElementById("weight").value;
    document.getElementById("bmivalue").value = weight / (height * height);
}

            // Get the modal
var modal = document.getElementById('login');
var modal1 = document.getElementById('bmi');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    else if(event.target == modal1) {
        modal1.style.display = "none";
    }
}

function val(){
    if((frm.phonenumber.value).length <10){
        alert("Phone number should be minimum 10 digits!");
        frm.phonenumber.focus();
        return false;
    }
    
    return true;
}

