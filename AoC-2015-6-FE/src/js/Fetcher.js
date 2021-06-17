
export default class Fetcher {

    fetchLightsCount = async arrayOfObjects => {

        const numberOfLights = await fetch('http://localhost:5000/lights', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(arrayOfObjects)
        }).then(response => response.json())
            .then(data => {
                return data;
            });

        return numberOfLights;
    };

    fetchBrightness = async arrayOfObjects => {
        const totalBrightness = await fetch('http://localhost:5000/brightness', {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(arrayOfObjects)
        }).then(response => response.json())
            .then(data => {
            return data;
        });

        return totalBrightness;
    }
}