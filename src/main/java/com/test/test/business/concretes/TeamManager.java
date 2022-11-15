package com.test.test.business.concretes;

import com.test.test.business.abstracts.TeamService;
import com.test.test.business.requests.CreateTeamRequest;
import com.test.test.business.responses.GetAllTeamsResponse;
import com.test.test.dataAccess.abstracts.TeamRepository;
import com.test.test.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamManager implements TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamManager (TeamRepository teamRepository){
        super();
        this.teamRepository = teamRepository;
    }

    @Override
    public List<GetAllTeamsResponse> getAll() {
        List<Team> teams = teamRepository.findAll();
        List<GetAllTeamsResponse> teamsResponses = new ArrayList<GetAllTeamsResponse>();
        for (Team team : teams) {
            GetAllTeamsResponse getAllTeamsResponse = new GetAllTeamsResponse();

            getAllTeamsResponse.setId(team.getId());
            getAllTeamsResponse.setName(team.getName());
            getAllTeamsResponse.setLoseCount(team.getLoseCount());
            getAllTeamsResponse.setWinCount(team.getWinCount());

            teamsResponses.add(getAllTeamsResponse);
        }
        return teamsResponses;
    }

    @Override
    public void add(CreateTeamRequest createTeamRequest) {
        Team team = new Team();
        team.setName(createTeamRequest.getName());
        teamRepository.save(team);
    }

    @Override
    public void delete(int id) {
        teamRepository.deleteById(id);
    }
}
