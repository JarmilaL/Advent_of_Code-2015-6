
export default class InputHandler {

    createObjectsFromInput = input => {
        const instructions = this.transformInput(input);
        const arrayOfObjects = instructions.map(item => this.makeObject(item));
        return arrayOfObjects;
    };

    transformInput = input => {
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

    makeObject = array => {
        return {
            instruction: array[0],
            pointAx: array[1][0],
            pointAy: array[1][1],
            pointBx: array[2][0],
            pointBy: array[2][1]
        }
    };
}