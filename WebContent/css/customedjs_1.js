jQuery(function () {
    var myId;
    var myUrl = $('#myUrl').val();
    myId = getId(myUrl);

    $('#myCode').html('<iframe style="display:block; margin:auto;" width="560" height="315" src="//www.youtube.com/embed/' + myId + '" frameborder="0" allowfullscreen></iframe>');
});


function getId(url) {
    var regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
    var match = url.match(regExp);

    if (match && match[2].length == 11) {
        return match[2];
    } else {
        return 'error';
    }
}

var $star_rating = $('.star-rating .fa');

var SetRatingStar = function () {
    return $star_rating.each(function () {
        if (parseInt($star_rating.siblings('input.rating-value').val()) >= parseInt($(this).data('rating'))) {
            return $(this).removeClass('fa-star-o').addClass('fa-star');
        } else {
            return $(this).removeClass('fa-star').addClass('fa-star-o');
        }
    });
};

$star_rating.on('click', function () {
    $star_rating.siblings('input.rating-value').val($(this).data('rating'));
    return SetRatingStar();
});

SetRatingStar();
$(document).ready(function () {

});


// Get the modal
var modal = document.getElementById('myModal');

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById('myimg');
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function () {
    modal.style.display = "block";
    modalImg.src = this.src;
    captionText.innerHTML = this.alt;
}
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function showalert() {
    alert("You have already voted once. New rating will be updated");
}





