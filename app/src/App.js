import React, { useEffect, useState } from 'react';
import './App.css';
import Teams from './components/Teams';

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
          <Teams teams={teams}/>
        </div>
    </div>
  );
}

export default App;