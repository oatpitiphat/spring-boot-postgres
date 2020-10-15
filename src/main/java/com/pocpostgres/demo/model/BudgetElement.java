package com.pocpostgres.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "budget_element", schema = "dbo")
public class BudgetElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_element_id")
    @JsonProperty("BudgetElementID")
    private Integer BudgetElementID;

    @Column(name = "budget_structure_id")
    @JsonProperty("BudgetStructureID")
    private Integer BudgetStructureID;

    @NotEmpty
    @Column(name = "budget_element_code")
    @JsonProperty("BudgetElementCode")
    private String BudgetElementCode;

    @Column(name = "budget_element_desc")
    @JsonProperty("BudgetElementDesc")
    private String BudgetElementDesc;

    @Column(name = "is_deleted")
    @JsonProperty("IsDeleted")
    private Boolean IsDeleted;
}
