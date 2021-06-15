
export default class Renderer {

    renderInputPage = () => {
        document.querySelector('.input').style.display = 'flex';
        document.querySelector('.lights').style.display = 'none';
        document.querySelector('.backgroundLights').style.visibility = 'hidden';
    };

    renderResultPage = numberOfLights => {
        document.querySelector('.input').style.display = 'none';
        document.querySelector('.lights').style.display = 'flex';
        document.querySelector('.backgroundLights').style.visibility = 'visible';
        document.querySelector('.result').innerText = numberOfLights.toLocaleString();  // 'cs-CZ'
    };
}