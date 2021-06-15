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
        form.querySelector("textarea").value = '';
        start(formData);

    });

    const againButton = document.querySelector(".lights button");
    againButton.addEventListener('click', new Renderer().renderInputPage);

};

const start = async input => {
    // TODO: validace vstupu
    const inputHandler = new InputHandler();
    const arrayOfObjects = inputHandler.createObjectsFromInput(input);

    const renderer = new Renderer();
    renderer.renderResultPage(await new Fetcher().fetchLightsCount(arrayOfObjects));
};

init();
