function toggleReplyContainer(el) {
    const replyContainer = el.parentNode.parentNode.childNodes[5].childNodes[1];
    replyContainer.classList.toggle('display-none');
}

function toggleIconStyle(el) {
    el.classList.toggle('far');
    el.classList.toggle('fas');
}