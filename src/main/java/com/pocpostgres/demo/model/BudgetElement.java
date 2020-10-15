package com.pocpostgres.demo.model;

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
    private Integer budgetElementID;

    @Column(name = "budget_structure_id")
    private Integer budgetStructureID;

    @NotEmpty
    @Column(name = "budget_element_code")
    private String budgetElementCode;

    @Column(name = "budget_element_desc")
    private String budgetElementDesc;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
