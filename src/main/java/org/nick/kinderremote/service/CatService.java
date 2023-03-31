package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.entity.Catalog;
import org.nick.kinderremote.repository.CatalogRepo;
import org.nick.kinderremote.util.abstractInheritance.ServiceAbstract;
import org.nick.kinderremote.util.repoServiceUtil.RepoService;
import org.nick.kinderremote.util.state.CatalogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Optional;

@Service
public class CatService extends ServiceAbstract implements RepoService {

    private final CatalogRepo catRepo;
    ObjectMapper objectMapper;
    @Autowired
    CatalogUtil cu;

    @Autowired
    public CatService(CatalogRepo catRepo) {
        this.catRepo = catRepo;
    }



    public String initialData(HtRequest request) throws IOException {
        ObjectInputStream catalogObjectInputStream = cu.getCatalogObjectInputStream();
//        getInitialProductsList()
        return "";
    }


    @Cacheable("catalog")
    @Override
    public String getAll(HtRequest request) throws IOException, ClassNotFoundException {
//        CategoryList
//        ProdList - may be "random"


        ObjectInputStream ois = cu.getCatalogObjectInputStream();

        return (String) ois.readObject();

    }

    @Override
    public String getById(HtRequest request) throws JsonProcessingException {
        Optional<Catalog> byId = catRepo.findById(request.getCatId());
        Catalog catalog = byId.get();
        return new ObjectMapper().writeValueAsString(catalog);
    }

    @Override
    public String editHierarchy(HtRequest request) {
        return "The Hierarchy will be replaced!!!";
    }

    @Override
    public String editById(HtRequest request) {
        return null;
    }

    @Override
    public String delete(HtRequest request) {
        return null;
    }

    @Override
    public String createNew(HtRequest request) {
        return null;
    }
}
