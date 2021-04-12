

const start = () => {
    const input = getInput();
    const instructions = transformInput(input);
    const arrayOfObjects = instructions.map(item => makeObject(item));
    sendPostRequest(arrayOfObjects);
};

const getInput = () => {
    const textarea = document.querySelector(".textarea");
    const input = textarea.value;
    textarea.value = '';

    return input;
};

const transformInput = input => {
    const arrayOfStringsInstructions = input.split("\n");
    const arrayOfInstructionsParts = arrayOfStringsInstructions.map(instructionString => instructionString.split(' '))  // Split string into words
            .map(instructionParts => {
                if (instructionParts.includes("turn")) { // Get rid of unnecessary word turn from 'turn on' and 'turn of' => all arrays have the same length
                    instructionParts.shift();
                }
                instructionParts.splice(instructionParts.indexOf('through'), 1); // Get rid of unnecessary word 'through'
                return instructionParts;
            }).map(instructionParts => {
                instructionParts[1] = instructionParts[1].split(',');   // Transform coordinates into more usable form (123,456 => [123, 456])
                instructionParts[2] = instructionParts[2].split(',');
                return instructionParts;
            });

    return arrayOfInstructionsParts;
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
    fetch('http://localhost/5000', {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(arrayOfObjects)
    }).then(response => response.json())
        .then(data => {
            console.log(data);
        })
};

document.querySelector(".button").addEventListener('click', start);