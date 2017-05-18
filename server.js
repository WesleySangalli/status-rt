'use strict'
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });

wss.on('connection', function connection(ws) {
    ws.on('message', function incoming(message) {
        console.log('received: %s', message);
    });

    let interval = setInterval(function(){
        if(ws.readyState === WebSocket.OPEN){

            ws.send(JSON.stringify([{ 
                    category:"temperature", 
                    value: Math.random()
                },
                { 
                    category:"humidity", 
                    value: Math.random()
                }])
            );
        }


    }, 1500);
});