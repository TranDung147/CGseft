
function temperatureConverter(valNum, target) {
    valNum = parseFloat(valNum);
    if (target === 'celsius') {
        document.getElementById("outputFahrenheit").innerHTML = (valNum * 1.8) + 32;
    } else {
        document.getElementById("outputCelsius").innerHTML = (valNum-32) / 1.8;
    }

}
