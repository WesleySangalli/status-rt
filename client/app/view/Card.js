
function Card(image=null, title='Título', body=null, footer=null){
	let template = `<div class="card-height-indicator"></div>
        <div class="card-content">
            <div class="card-image">
                <img src="${image}" width="100%" height="300px" alt="Loading image...">
                <h3 class="card-image-headline">${ title }</h3>
            </div>
            <div class="card-body">
                ${ typeof body == 'string' ? body : body.outerHTML }
            </div>
            <footer class="card-footer">
                ${ typeof footer == 'string' ? footer : footer.outerHTML }
            </footer>
        </div>`;
    let card = document.createElement('div');
    card.setAttribute('class','card'); 
    card.innerHTML = template; 
    return card;
}

