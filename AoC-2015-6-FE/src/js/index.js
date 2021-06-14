import '../css/style.css';
import InputHandler from "./InputHandler";
import Renderer from "./Renderer";
import Fetcher from "./Fetcher";

const start = input => {
    alert("tu jsem");
    // TODO: validace vstupu
    const inputHandler = new InputHandler();
    const arrayOfObjects = inputHandler.createObjectsFromInput(input);

    const renderer = new Renderer();
    renderer.renderResult(new Fetcher().fetchLightsCount(arrayOfObjects));
};


const form = document.querySelector("form");
form.addEventListener('submit', event => {
    event.preventDefault();

    const formDataObject = new FormData(event.target);
    const formData = formDataObject.get("textarea");
    form.querySelector("textarea").value = '';
    start(formData);

});