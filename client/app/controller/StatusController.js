function StatusController(statusSocket, humidityElement, temperatureElement) {
    let obj = {
        statusSocket,
        humidityElement,
        temperatureElement
    }

    statusSocket.receive(function(status) {
        obj.temperatureElement.updateHTML(status['temperature'])
        obj.humidityElement.updateHTML(status['humidity'])
    });

    return {};
}