package com.test.test.business.abstracts;

import com.test.test.business.requests.CreateTeamRequest;
import com.test.test.business.requests.UpdateTeamRequest;
import com.test.test.business.responses.GetAllTeamsResponse;

import java.util.List;

public interface TeamService {
    List<GetAllTeamsResponse> getAll();
    void add(CreateTeamRequest createTeamRequest);
    void delete(int id);
    void update(int id, UpdateTeamRequest updateTeamRequest);
}
