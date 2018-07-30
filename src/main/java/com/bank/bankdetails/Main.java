package com.bank.bankdetails;

import com.bank.bankdetails.reader.CSVFileReader;

import java.io.IOException;
import java.sql.SQLException;

import static com.bank.bankdetails.reader.CSVFileReader.importDataFromCSV;
import static com.bank.bankdetails.reader.CSVFileReader.readDataFromDB;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        importDataFromCSV("sample.csv");
        System.out.println(readDataFromDB("10040000"));
    }
}
