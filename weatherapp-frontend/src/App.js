import React, { useState } from 'react';

function App() {
  const [city, setCity] = useState('');
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState('');

  const fetchWeather = async (e) => {
    if (e) e.preventDefault();
    setError('');
    setWeather(null);
    if (!city) {
      setError('Please enter a city name');
      return;
    }
    try {
      const response = await fetch(`/api/weather?city=${city}`);
      if (!response.ok) {
        throw new Error('Failed to Fetch:City Not Found');
      }
      const data = await response.json();
      setWeather(data);
    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <div className="app-container">
      <h1>Weather App</h1>
      {/* Form wrapper yahan add karein */}
      <form className="input-group" onSubmit={fetchWeather}>
        <input
          type="text"
          placeholder="Enter city name"
          value={city}
          onChange={e => setCity(e.target.value)}
        />
        <button type="submit">Get Weather</button>
      </form>

      {error && <p className="error">{error}</p>}

      {weather && (
        <div className="weather-card">
          <h2>{weather.cityName}</h2>
          <p>Temperature: {weather.main.temp} °C</p>
          <p>Humidity: {weather.main.humidity} %</p>
          <p>Condition: {weather.weather[0].description}</p>
          <p>
          <img
           src={`https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png`}
                 alt={weather.weather[0].description}
          />
          </p>
          


        </div>
      )}
    </div>
  );
}

export default App;
