import React, { Component } from "react";
import Team from "./Team";
class Teams extends Component {
  state = {};
  render() {
    const { teams } = this.props;
    return (
      <React.Fragment>
        <div>
          <h1>Team List</h1>
          <ul className="list-group">
            {teams.map((team) => (
              <Team teamData={team} />
            ))}
          </ul>
        </div>
      </React.Fragment>
    );
  }
}

export default Teams;
