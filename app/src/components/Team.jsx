import React, { Component } from "react";
class Team extends Component {
  addWin = (id, team) => {
    fetch("api/teams/update?id=" + id, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: {
        winCount: team.winCount + 1,
        loseCount: team.loseCount,
      },
    });
  };
  addLose = (id, team) => {
    console.log("api/teams/update?id=" + id);

    fetch("api/teams/update?id=" + id, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: {
        winCount: team.winCount,
        loseCount: team.loseCount - 1,
      },
    });
  };
  render() {
    const { teamData } = this.props;
    const add = this.addWin(teamData.id, teamData);
    const lose = this.addLose(teamData.id, teamData);
    return (
      <React.Fragment>
        <li className="list-group-item" key={teamData.id}>
          <h3>Team: {teamData.name}</h3>
          <p>Win Count: {teamData.winCount}</p>
          <p>Lose Count: {teamData.loseCount}</p>
          <button className="btn btn-success" onClick={add}>
            Add Win
          </button>
          <button className="btn btn-danger" onClick={lose}>
            AddLose
          </button>
        </li>
      </React.Fragment>
    );
  }
}

export default Team;
