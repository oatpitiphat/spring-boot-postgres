package com.pocpostgres.demo.service;

import com.pocpostgres.demo.model.BudgetStructure;
import com.pocpostgres.demo.repository.BudgetStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetStructureService {
    @Autowired
    BudgetStructureRepository budgetStructureRepository;

    public List<BudgetStructure> getAll() {
        return budgetStructureRepository.findAll();
    }

    public BudgetStructure save(BudgetStructure model) {
        model.setIsDeleted(false);
        return budgetStructureRepository.save(model);
    }
}
