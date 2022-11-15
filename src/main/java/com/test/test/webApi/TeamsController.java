package com.test.test.webApi;

import com.test.test.business.abstracts.TeamService;
import com.test.test.business.requests.CreateTeamRequest;
import com.test.test.business.requests.UpdateTeamRequest;
import com.test.test.business.responses.GetAllTeamsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/teams")
public class TeamsController {
    private TeamService teamService;

    @Autowired
    public TeamsController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping(path = "/getall")
    public List<GetAllTeamsResponse> getAll(){
        return teamService.getAll();
    }

    @PostMapping(path = "/add")
    public void add(@RequestBody() CreateTeamRequest createTeamRequest){
        this.teamService.add(createTeamRequest);
    }

    @DeleteMapping(path ="/delete")
    public void delete(@RequestParam("id")int id){
        this.teamService.delete(id);
    }

    @PutMapping(path ="/update")
    public void update(@RequestParam("id")int id, @RequestBody()UpdateTeamRequest updateTeamRequest){
        this.teamService.update(id, updateTeamRequest);
    }
}
