package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.nick.kinderremote.data.entity.Catalog;
import org.nick.kinderremote.data.projections.CatIdNameViev;
import org.nick.kinderremote.data.projections.CatalogProjIf;
import org.nick.kinderremote.repository.CatalogRepo;
import org.nick.kinderremote.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository catRepo;
    private final CatalogRepo catalogRepo;

    @Autowired
    public CategoryService(CategoryRepository catRepo, CatalogRepo catalogRepo) {
        this.catRepo = catRepo;
        this.catalogRepo = catalogRepo;
    }

    public String getAllCatalog() {
        ObjectMapper mapper = new ObjectMapper();
        List<CatIdNameViev> catalog = catalogRepo.buildCatalogView();

        String sCatalog= null;
        try {
            sCatalog = mapper.writeValueAsString(catalog);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sCatalog;
    }

    public Catalog catalog() {
//        System.out.println(catalogRepo.findAll());
        return catalogRepo.findById(30L).get();
    }



    @SneakyThrows
    public String getCatalog2() {
        ObjectMapper mapper = new ObjectMapper();
        List<CatalogProjIf> catalog2 = catRepo.bildOtherCatalog();
        String result = mapper.writeValueAsString(catalog2);
        return result;
    }
    @SneakyThrows
    public String getRazvitie() {
        ObjectMapper mapper = new ObjectMapper();

        CatalogProjIf razvitie=  catRepo.findProjById(1151L);
        return  mapper.writeValueAsString(razvitie);
    }

    @SneakyThrows
    public String categoryById(Long id){
        CatalogProjIf catById = catRepo.findcatbyid(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(catById);
    }
}
