
export default class Fetcher {

    fetchLightsCount = async arrayOfObjects => {

        const numberOfLights = await fetch('http://localhost:5000/', {
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
}