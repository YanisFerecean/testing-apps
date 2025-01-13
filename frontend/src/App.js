// src/App.js
import React, { useState, useEffect } from 'react';

function App() {
    const [persons, setPersons] = useState([]);

    useEffect(() => {
        // Make an HTTP GET request using fetch
        fetch('http://localhost:8080/persons')
            .then(response => {
                // Check if the response is okay (status 200-299)
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // Parse JSON data from the response
            })
            .then(data => {
                setPersons(data); // Update state with the fetched data
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    return (
        <div>
            <h1>Persons</h1>
            <ul>
                {persons.map(person => (
                    <li key={person.id}>{person.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default App;
