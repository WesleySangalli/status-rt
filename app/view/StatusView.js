

//Behavior
const DOMValueUpdater = (obj) => ({
    updateValue: () => { console.log(obj.element) }
})


function HumidityStatusView(humidityDOM){
    let obj = {
        element : humidityDOM
    }

    return Object.assign(obj, DOMValueUpdater(obj));
}