package org.nick.kinderremote.util.state;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.entity.Catalog;
import org.nick.kinderremote.repository.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Optional;

@Service
public class CatalogUtil {
    private final CatalogRepo catRepo;
    @Autowired
    public CatalogUtil(CatalogRepo catRepo) {
        this.catRepo = catRepo;
    }

    public void makeCatalog() throws IOException {
        Optional<Catalog> byId = catRepo.findById(30L);
        Catalog catalog = byId.get();
        String stringCatalog = new ObjectMapper().writeValueAsString(catalog);
        FileOutputStream fos = new FileOutputStream("catalogString.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(catalog);
//        System.out.println(catalog);
//        String catalogString = "written Catalog";
        oos.writeObject(stringCatalog);
        oos.close();
    }

    public String getStringCatalogFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("catalogString.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (String) ois.readObject();
    }

    public ObjectInputStream getCatalogObjectInputStream() throws IOException {
        FileInputStream fis = new FileInputStream("catalogString.bin");
        return new ObjectInputStream(fis);
    }
}
