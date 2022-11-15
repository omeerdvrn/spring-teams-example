package com.test.test.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTeamsResponse {
    private int id;
    private String name;
    private int winCount;
    private int loseCount;
}
