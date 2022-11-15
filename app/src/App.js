import React, { useEffect, useState } from 'react';
import './App.css';

const App = () => {

  const [teams, setTeams] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('api/teams/getall')
      .then(response => response.json())
      .then(data => {
        setTeams(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="App">
      
        <div className="container">
          <h1>Team List</h1>
          <ul className='list-group'>
          {teams.map(team =>
            <li className='list-group-item' key={team.id}>
              <h3>Team: {team.name}</h3>
              <p>Win Count: {team.winCount}</p>
              <p>Lose Count: {team.loseCount}</p>
            </li>
          )}
          </ul>
          
        </div>
    </div>
  );
}

export default App;