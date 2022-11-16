import React, { Component } from "react";
class Team extends Component {
  state = {
    name: "asd",
    winCount: 10,
  };
  render() {
    const { teamData } = this.props;
    return (
      <React.Fragment>
        <li className="list-group-item" key={teamData.id}>
          <h3>Team: {teamData.name}</h3>
          <p>Win Count: {teamData.winCount}</p>
          <p>Lose Count: {teamData.loseCount}</p>
        </li>
      </React.Fragment>
    );
  }
}

export default Team;
