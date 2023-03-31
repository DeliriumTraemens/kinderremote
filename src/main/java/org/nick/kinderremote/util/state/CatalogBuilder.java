package org.nick.kinderremote.util.state;

import org.nick.kinderremote.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Пустышка?
 * */

@Configuration
public class CatalogBuilder {
    private final CatalogRepo catRepo;
    @Autowired
    public CatalogBuilder(CatalogRepo catRepo) {
        this.catRepo = catRepo;
    }

//    @Bean
//    public void catalogMaker() throws IOException {
//        Optional<Catalog> byId = catRepo.findById(30L);
//        Catalog catalog = byId.get();
//
//        FileOutputStream fos = new FileOutputStream("catalogString.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//
////        ObjectMapper mapper = new ObjectMapper();
////        String s = mapper.writeValueAsString(catalog);
//        System.out.println(catalog);
//        String catalogString = "written Catalog";
//        oos.writeObject(catalogString);
//        oos.close();
//    }

}
