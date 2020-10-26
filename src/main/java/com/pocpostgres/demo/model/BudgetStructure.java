package com.pocpostgres.demo.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "budget_structure", schema = "dbo")
public class BudgetStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_structure_id")
    private Integer budgetStructureID;

    @NotEmpty
    @Column(name = "budget_structure_name")
    private String budgetStructureName;

    @NotEmpty
    @Column(name = "budget_structure_desc")
    private String budgetStructureDesc;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "budget_structure_id")
    private List<BudgetElement> budgetElements;
}
