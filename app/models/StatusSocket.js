


function StatusSocket(url = 'ws://echo.websocket.org'){
    let socket = new WebSocket(url);
    socket.onopen = () => console.info('Socket Open: ' + url); 
    socket.onclose = () => console.error('Socket Closed: ' + url); 
    socket.onmessage = (message) => console.log( message.data );
    
    return {
        send : (message) => { socket.send(message) },
        receive : (callback) => { 
            socket.onmessage = function received(message){
                callback( JSON.parse(message.data) );
            } 
        },
    };
}