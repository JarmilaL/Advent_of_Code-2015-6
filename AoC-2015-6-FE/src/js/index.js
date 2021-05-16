import '../css/style.css';

const start = input => {
    alert("tu jsem");
    // TODO: validace vstupu
    const instructions = transformInput(input);
    const arrayOfObjects = instructions.map(item => makeObject(item));
    sendPostRequest(arrayOfObjects);
};

// const getInput = () => {
//     const textarea = document.querySelector(".textarea");
//     const input = textarea.value;
//     textarea.value = '';
//
//     return input;
// };

const transformInput = input => {
    const arrayOfStringInstructions = input.split("\n");
    const arrayOfInstructionParts = arrayOfStringInstructions.map(instructionString => instructionString.split(' '))  // Split string into words
            .map(instructionParts => {
                if (instructionParts.includes("turn")) { // Get rid of unnecessary word turn from 'turn on' and 'turn of' => all arrays have the same length
                    instructionParts.shift();            // 'turn' is always on index 0.
                }
                instructionParts.splice(instructionParts.indexOf('through'), 1); // Get rid of unnecessary word 'through'
                return instructionParts;
            }).map(instructionParts => {
                instructionParts[1] = instructionParts[1].split(',');   // Transform coordinates into more usable form (123,456 => [123, 456])
                instructionParts[2] = instructionParts[2].split(',');
                return instructionParts;
            });

    return arrayOfInstructionParts;
};

const makeObject = array => {
    return {
        instruction: array[0],
        pointAx: array[1][0],
        pointAy: array[1][1],
        pointBx: array[2][0],
        pointBy: array[2][1]
    }
};

const sendPostRequest = arrayOfObjects => {

    console.log(arrayOfObjects);

    //fetch('http://localhost:5000/').then(response => response.json()).then(data => console.log(data));

    // fetch('http://localhost:5000/', {
    //     method: "POST",
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'text/plain'
    //     },
    //     body: JSON.stringify(arrayOfObjects)
    // }).then(response => response.json())
    //     .then(data => {
    //         console.log(data);
    //     })

    fetch('http://localhost:5000/', {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(arrayOfObjects)
    }).then(response => response.json())
        .then(data => {
            console.log(data);
        })


};

const form = document.querySelector("form");
form.addEventListener('submit', event => {
    event.preventDefault();

    const formDataObject = new FormData(event.target);
    const formData = formDataObject.get("textarea");
    form.querySelector("textarea").value = '';
    start(formData);

});