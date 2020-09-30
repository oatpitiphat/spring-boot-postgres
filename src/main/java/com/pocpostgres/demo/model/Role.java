package com.pocpostgres.demo.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Role {
    @NotEmpty
    private String name;
    @NotNull
    private String desc;
}
