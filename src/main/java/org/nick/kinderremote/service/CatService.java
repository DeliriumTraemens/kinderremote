package org.nick.kinderremote.service;

import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.repository.CatalogRepo;
import org.nick.kinderremote.util.repoServiceUtil.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatService implements RepoService {

    private final CatalogRepo catRepo;

    @Autowired
    public CatService(CatalogRepo catRepo) {
        this.catRepo = catRepo;
    }



    @Override
    public String getAll(HtRequest request) {
        return null;
    }

    @Override
    public String getById(HtRequest request) {
        return null;
    }

    @Override
    public String editHierarchy(HtRequest request) {
        return null;
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
