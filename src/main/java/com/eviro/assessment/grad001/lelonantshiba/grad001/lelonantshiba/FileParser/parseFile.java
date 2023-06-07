package com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.FileParser;

import au.com.bytecode.opencsv.CSVReader;
import com.eviro.assessment.grad001.lelonantshiba.grad001.lelonantshiba.Model.AccountHolderModel;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class parseFile implements FileParser{



   public List<String> data = new ArrayList<>();

   public List<AccountHolderModel> accounts = new ArrayList<>();

   public String dataForm;

    public void parseCSV(File csvFile) {
        /**
         * This method parses the CSV file line by line then extracts the data needed and creates an entity which will then
         * be added to a list. This list is what is used to add the information into the Account Profile database.
         */
        try {
            CSVReader reader = new CSVReader(new FileReader(csvFile));

            int firstLine = 0;
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null){
                if (firstLine == 0){
                    firstLine++;
                    continue;
                }

               AccountHolderModel accountHolderModel = new AccountHolderModel();
               accountHolderModel.setId(firstLine);
               accountHolderModel.setName(nextLine[0]);
               accountHolderModel.setSurname(nextLine[1]);
               dataForm = nextLine[2];
               String data = createImageLink(convertCSVDataToImage(nextLine[3])).toString();
               accountHolderModel.setHttpImageLink(data);
               accounts.add(accountHolderModel);

               firstLine++;
               }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public File convertCSVDataToImage(String base64ImageData) {
        /**
         * This method first checks for the image format specified in csv file that the base64Image should be converted to
         * then converts it into that Image format.
         */
//        String filedir = "/home/lolothemisfit/Documents/grad001.lelonantshiba/src/main/java/com/eviro/assessment/grad001/lelonantshiba/grad001/lelonantshiba/CSVFile/";
        String path = "";
        if (dataForm.equals("image/jpeg")){
            path = "Image.jpeg";
        }else{
            path = "Image.png";
        }

        File file = new File(path);
        try ( FileOutputStream fos = new FileOutputStream(file); ) {
            byte[] decoder = Base64.getDecoder().decode(base64ImageData);

            fos.write(decoder);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    @Override
    public URI createImageLink(File fileImage) {
        /**
         * This method converts the Image into a URI link.
         */
        URI uri = fileImage.toURI();


        return uri;
    }
}
