package com.yaskovskyi.task5.model;

import lombok.Data;

@Data
public class GameTech {

    private Tic type;
    private Integer coordinateX;
    private Integer coordinateY;
    private String gameId;

}
