package com.kbe.storage.unit.service;

import com.kbe.storage.models.entities.Product;
import com.kbe.storage.repositories.ProductRepository;
import com.kbe.storage.services.CsvImportService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvImportServiceTest {

    private ProductRepository repository = Mockito.mock(ProductRepository.class);

    private CsvImportService service;

    private String filename = "test.csv";

    private List<Product> products;

    @BeforeEach
    void createCSV() throws IOException {
        ArrayList<Product> temp = new ArrayList<>();

        temp.add(new Product(4, "name", new BigDecimal("100.99"), "manufacturer", new BigDecimal("23.5"),
                "black", 144, new BigDecimal("3.2"), 1, "HDMI, USB", "4k"));
        temp.add(new Product(5, "name2", new BigDecimal("550.99"), "manufacturer2", new BigDecimal("27.5"),
                "white", 60, new BigDecimal("4.5"), 5, "HDMI, VGA", "Ultra HD"));

        products = temp;
        service = new CsvImportService(repository);

        String path = System.getProperty("java.io.tmpdir");
        File file = new File(path, filename);

        FileWriter fileWriter = new FileWriter(file);
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(fileWriter, CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"id", "name", "priceEuro", "manufacturer", "displaySizeInches", "color",
                "refreshRateHz", "weightKg", "reactionTimeMs", "displayInterface", "resolution"};
        String[] nameMapping = {"id", "name", "priceEuro", "manufacturer", "displaySizeInches", "color",
                "refreshRateHz", "weightKg", "reactionTimeMs", "displayInterface", "resolution"};

        csvBeanWriter.writeHeader(csvHeader);

        for(Product product : products){
            csvBeanWriter.write(product, nameMapping);
        }
        csvBeanWriter.close();
    }

    @AfterEach
    void deleteCSV(){
        String path = System.getProperty("java.io.tmpdir");
        File file = new File(path, filename);
        file.delete();
    }

    @Test
    void importCsvTest(){
        when(repository.saveAll(any())).thenReturn(products);
        List<Product> importedProducts = service.readCsvFromFolder(filename).getBody();
        assertThat(products.size() == importedProducts.size());
        assertThat(products.get(0).equals(importedProducts.get(0)));
        assertThat(products.get(1).equals(importedProducts.get(1)));
    }
}
