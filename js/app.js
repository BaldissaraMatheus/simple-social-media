const loadTemplates = (parent) => {
    const items = parent.querySelectorAll('[template]');

    items.forEach(item => {

        const template = item.getAttribute('template');

        fetch(template)

            .then((response) => {
                return response.text();
            })
            .then(content => {
                item.innerHTML = content;

                loadTemplates(item);
            })
    });
}

const onWindowsLoaded = () => {
    console.log('windows loaded');
}

window.onload = onWindowsLoaded;