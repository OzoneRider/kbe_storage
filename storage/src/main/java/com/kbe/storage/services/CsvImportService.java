package com.kbe.storage.services;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.repositories.ProductRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
@CommonsLog
public class CsvImportService {

    @Autowired
    private ProductRepository productRepository;

    private final String CSV_FILENAME = "products.csv";

    public List<Product> readCsvFromFolder() {
        String path = System.getProperty("java.io.tmpdir");
        File file = new File(path, CSV_FILENAME);

        try{
            ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);
            final String[] headers = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();

            Product product;
            List<Product> productList = new ArrayList<>();
            while((product = beanReader.read(Product.class, headers, processors)) != null){
                productList.add(product);
            }
            return productRepository.saveAll(productList);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    private CellProcessor[] getProcessors(){

        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseInt()), // productId
                new NotNull(), // name
                new NotNull(new ParseBigDecimal()), // priceEuro
                new NotNull(), // manufacturer
                new NotNull(new ParseBigDecimal()), // displaySizeInches
                new NotNull(), // color
                new NotNull(new ParseInt()), // refreshRateHz
                new NotNull(new ParseBigDecimal()), // weightKg
                new NotNull(new ParseInt()), // reactionTimeMs
                new NotNull(), // displayInterface
                new NotNull() // resolution
        };
        return processors;
    }
}
