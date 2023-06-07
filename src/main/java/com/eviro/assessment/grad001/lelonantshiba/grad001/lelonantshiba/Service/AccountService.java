package com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Service;

import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.FileParser.parseFile;
import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Model.AccountHolderModel;
import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Repository.AccountHolderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.http.HttpHeaders;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountHolderDTO accountHolderDTO;
    parseFile parseFile = new parseFile();

    public List<AccountHolderModel> saveUser(){
        parseFile.parseCSV(new File("/home/lolothemisfit/Documents/grad001.lelonantshiba/src/main/java/com/eviro/assessment/grad001/lelonantshiba/grad001/lelonantshiba/CSVFile/1672815113084-GraduateDev_AssessmentCsv_Ref003.csv"));
        return accountHolderDTO.saveAll(parseFile.accounts);
    }

    public String getHttpImageLink(String name, String surname){
        String[] path = new String[0];
       for (AccountHolderModel accountHolderModel : parseFile.accounts){
           if (accountHolderModel.getName().equals(name) && accountHolderModel.getSurname().equals(surname)){
               path = accountHolderModel.getHttpImageLink().split(":");
           }
       }
       String httpImageLink = path[1];
       return httpImageLink;
    }
}
