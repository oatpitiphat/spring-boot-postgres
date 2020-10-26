package com.pocpostgres.demo.service;

import com.pocpostgres.demo.model.BudgetStructure;
import com.pocpostgres.demo.repository.BudgetStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class BudgetStructureService {
    @Autowired
    BudgetStructureRepository budgetStructureRepository;

    @Autowired
    EntityManager entityManager;

    public List<BudgetStructure> getAll() {
        return budgetStructureRepository.findAll();
    }

    public BudgetStructure save(BudgetStructure model) {

        model.setIsDeleted(false);
        return budgetStructureRepository.save(model);
    }

    public List<BudgetStructure> getList() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("    *");
        sql.append("FROM ");
        sql.append("	dbo.budget_structure ");
        sql.append("WHERE ");
        sql.append("	budget_structure_id  = 8 ");
        sql.append("	AND is_deleted = false");

        Query query = entityManager.createNativeQuery(sql.toString(), BudgetStructure.class);
        List<BudgetStructure> list = query.getResultList();

        return list;
    }
}
