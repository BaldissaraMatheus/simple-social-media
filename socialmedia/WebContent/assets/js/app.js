function toggleReplyContainer(el) {
    const replyContainer = el.parentNode.parentNode.childNodes[5].childNodes[1];
    replyContainer.classList.toggle('display-none');
}

function toggleIconStyle(el) {
    if (el.classList.contains('fas') && !el.classList.contains('fa-comment-alt')) {
    	el.classList.toggle('fa-heart');
    	el.classList.toggle('fa-heart-broken');
    
    } else {
        el.classList.toggle('far');
        el.classList.toggle('fas');
    } 
}