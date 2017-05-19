




let socket = StatusSocket('ws://localhost:8080');

socket.receive(function(status){
    console.warn(status);
});

console.log(document.getElementById('#humidity'));

let humidityView = HumidityStatusView(document.querySelector('#humidity'));