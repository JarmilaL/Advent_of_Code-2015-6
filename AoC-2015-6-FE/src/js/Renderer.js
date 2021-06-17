
export default class Renderer {

    renderInputPage = () => {
        document.querySelector('.input').style.display = 'flex';
        document.querySelector('.lights').style.display = 'none';
        document.querySelector(".background").classList.toggle("snow");
        document.querySelector(".header").style.display = "block";
        document.querySelector(".info").style.display = "block";
        const bgLights = document.querySelector('.backgroundLights');
        bgLights.style.visibility = 'hidden';
        bgLights.style.opacity = '0';
    };

    renderResultPage = (number, message1, message2) => {
        document.querySelector('.input').style.display = 'none';
        document.querySelector('.lights').style.display = 'flex';
        document.querySelector(".background").classList.toggle("snow");
        document.querySelector(".header").style.display = "none";
        document.querySelector(".info").style.display = "none";
        document.querySelector(".message-part1").innerText = message1;
        if (message2 != null) {
            document.querySelector(".message-part2").innerText = message2;
        }

        const bgLights = document.querySelector('.backgroundLights');
        bgLights.style.visibility = 'visible';
        bgLights.style.opacity = '0.7';
        document.querySelector('.result').innerText = number.toLocaleString();  // 'cs-CZ'
    };
}