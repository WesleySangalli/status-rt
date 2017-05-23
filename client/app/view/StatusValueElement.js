const DOMValueUpdater = (element) => ({
    updateHTML: (value) => { 
    	element.innerHTML = value; 
    }
})

function StatusValueElement(element){
    let obj = { element }
    return Object.assign(obj, DOMValueUpdater(obj.element));
}
