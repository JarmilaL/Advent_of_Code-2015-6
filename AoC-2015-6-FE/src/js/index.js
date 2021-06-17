import '../css/style.css';
import InputHandler from "./InputHandler";
import Renderer from "./Renderer";
import Fetcher from "./Fetcher";

const init = () => {
    const form = document.querySelector("form");
    form.addEventListener('submit', event => {
        event.preventDefault();

        const formDataObject = new FormData(event.target);
        const formData = formDataObject.get("textarea");
        const option = formDataObject.get("option");
        console.log(option);
        form.querySelector("textarea").value = '';
        start(formData, option);

    });

    const againButton = document.querySelector(".lights button");
    againButton.addEventListener('click', new Renderer().renderInputPage);

};

const start = async (input, option) => {
    // TODO: validace vstupu
    const inputHandler = new InputHandler();
    const arrayOfObjects = inputHandler.createObjectsFromInput(input);

    const renderer = new Renderer();
    if (option === "old") {
        renderer.renderResultPage(await new Fetcher().fetchLightsCount(arrayOfObjects), "There are", "lights lit on your christmas decoration.");
    } else {
        renderer.renderResultPage(await new Fetcher().fetchBrightness(arrayOfObjects), "Total Brightness of your lights is");
    }

};

init();
