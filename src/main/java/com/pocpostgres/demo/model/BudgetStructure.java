package com.pocpostgres.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "budget_structure", schema = "dbo")
public class BudgetStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_structure_id")
    @JsonProperty("BudgetStructureID")
    private Integer BudgetStructureID;

    @NotEmpty
    @Column(name = "budget_structure_name")
    @JsonProperty("BudgetStructureName")
    private String BudgetStructureName;

    @NotEmpty
    @Column(name = "budget_structure_desc")
    @JsonProperty("BudgetStructureDesc")
    private String BudgetStructureDesc;

    @Column(name = "is_deleted")
    @JsonProperty("IsDeleted")
    private Boolean IsDeleted;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "budget_structure_id")
    @JsonProperty("BudgetElements")
    private List<BudgetElement> BudgetElements;
}
