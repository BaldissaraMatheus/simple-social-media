// function toggleReplyContainer() {
//     var x = document.getElementById("myDIV");

//     if (x.style.display === "none") {
//       x.style.display = "block";
//     } else {
//       x.style.display = "none";
//     }
//   }

function toggleReplyContainer(el) {
    const replyContainer = el.parentNode.parentNode.childNodes[5].childNodes[1];
    replyContainer.classList.toggle('display-none');
}