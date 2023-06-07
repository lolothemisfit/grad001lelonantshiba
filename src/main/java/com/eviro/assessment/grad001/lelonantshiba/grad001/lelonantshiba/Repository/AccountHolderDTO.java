package com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Repository;


import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Model.AccountHolderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderDTO extends JpaRepository<AccountHolderModel, Integer> {


}

