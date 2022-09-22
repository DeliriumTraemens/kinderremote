//package org.nick.kinderremote.service;
//
//import org.nick.kinderremote.data.dto.HtRequest;
//import org.nick.kinderremote.repository.CatalogRepo;
//import org.nick.kinderremote.util.abstractInheritance.ServiceAbstract;
//import org.nick.kinderremote.util.repoServiceUtil.RepoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CatService extends ServiceAbstract implements RepoService {
//
//    private final CatalogRepo catRepo;
//
//    @Autowired
//    public CatService(CatalogRepo catRepo) {
//        this.catRepo = catRepo;
//    }
//
//
//
//    @Override
//    public String getAll(HtRequest request) {
//        return "Got!!! org.nick.kinderremote.service.CatService.getAll Method received Fuck!!!";
//    }
//
//    @Override
//    public String getById(HtRequest request) {
//        return "Youuuu! The CatId "+request.getСatId()+" will be replaced";
//    }
//
//    @Override
//    public String editHierarchy(HtRequest request) {
//        return "The Hierarchy will be replaced!!!";
//    }
//
//    @Override
//    public String editById(HtRequest request) {
//        return null;
//    }
//
//    @Override
//    public String delete(HtRequest request) {
//        return null;
//    }
//
//    @Override
//    public String createNew(HtRequest request) {
//        return null;
//    }
//}
