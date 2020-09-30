package com.pocpostgres.demo.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class UserReq {
        @NotNull
        private Integer id;

        @NotEmpty
        private String name;

        @NotNull
        private Integer age;

        @NotNull
        private BigDecimal money;

        @NotEmpty
        @Valid
        private List<Role> roles;
}
