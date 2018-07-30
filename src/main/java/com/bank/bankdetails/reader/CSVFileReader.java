package com.bank.bankdetails.reader;

import com.bank.bankdetails.model.Bank;
import com.bank.bankdetails.repository.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ajay on 7/27/2018.
 */
public class CSVFileReader {
    private static final String RESOURCE_FILE_PATH = "src/main/resources/";

    public static void importDataFromCSV(String filename) throws IOException, SQLException {

        Path pathToFile = Paths.get(RESOURCE_FILE_PATH + filename).toAbsolutePath();
        Map<String, String> attributeValueList = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                attributeValueList.put(attributes[0], attributes[1]);
                line = br.readLine();
            }
        }


        Bank bank = new Bank(attributeValueList.get("name"),
                attributeValueList.get("Postbank"),
                attributeValueList.get("Eurocity"),
                attributeValueList.get("Commerzbank"),
                attributeValueList.get("Raiffeisenbank"));
        Database.save(bank);

    }

    public static String readDataFromDB(String bankIdentifier) throws SQLException {
        final Bank bank = Database.fetchData(bankIdentifier);
        return bank.getName();
    }

}
