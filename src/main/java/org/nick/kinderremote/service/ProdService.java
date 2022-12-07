package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Hibernate;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.data.dto.ManufacturerCardDto;
import org.nick.kinderremote.data.dto.ProductByIdWithManufacturerList;
import org.nick.kinderremote.data.projections.ManProjIf;
import org.nick.kinderremote.data.projections.ProdCardManIf;
import org.nick.kinderremote.data.projections.ProdCardProjIf;
import org.nick.kinderremote.repository.ProductRepository;
import org.nick.kinderremote.util.abstractInheritance.ServiceAbstract;
import org.nick.kinderremote.util.repoServiceUtil.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProdService extends ServiceAbstract implements RepoService {
    ObjectMapper mapper;

    private final ProductRepository prodRepo;
    @Autowired
    public ProdService(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    ////--METHODS--///

    @Override
    public String getAll(HtRequest request) {
        return "It's a ProdReposervice";
    }

    @Override
    public String getById(HtRequest request) {
        return "Prod Service By Id";
    }

    public String getByCategoryId(HtRequest request) {
//        To return: paged productList
        int requestedPage = request.getRequestedPage();

        return "Something ";
    }

    public String getInitialProductsList(HtRequest request) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.findAndRegisterModules();
        Pageable pageRequest = PageRequest.of(0, 5);
//        Возможно тут не пейджебл , просто Лимит -- ТУТ РАНДОМ -- ПЕЙДЖ НАХ НЕ НУЖЕН
//        May be first form a categoryList
        Set<ProdCardProjIf> initialProductList=prodRepo.getInitialProductList();
//        List<Long> collectID = initialProductList.stream().map(t -> t.getId()).sorted().collect(Collectors.toList());
//        List<Product> allById = prodRepo.findAllById(collectID);
//        allById.forEach(System.out::println);
//        String response = new ObjectMapper().writeValueAsString(initialProductList);
//        return new ObjectMapper().writeValueAsString(initialProductList);
        return mapper.writeValueAsString(initialProductList);
    }

    // TEST
    public String getInitialProducts(HtRequest request) throws JsonProcessingException {
        Set<ProdCardManIf> initProdWithManufacturer = prodRepo.getInitialProductListWithManufacturer();

        return new ObjectMapper().writeValueAsString(initProdWithManufacturer);
//        return "new ObjectMapper().writeValueAsString(initProdWithManufacturer)";
    }
    // TEST END

//Select Products by Click on the Category Browser
    public String getProdByCatId(HtRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Long catId = request.getСatId();

        Pageable pageRequest = PageRequest.of(0, 14);
        Page<ProdCardProjIf> productsPaged = prodRepo.findProductsByCatId(catId, pageRequest);

        List<ProdCardProjIf> content = productsPaged.getContent();
        Set<ManProjIf> collectMan = content.stream().distinct().map(p -> p.getManufacturer()).collect(Collectors.toSet());

        Set<ManufacturerCardDto> manufacturerUnproxedSet = new HashSet<>();

        for (ManProjIf manProjIf : collectMan) {
            ManProjIf unproxy1 = ( ManProjIf) Hibernate.unproxy(manProjIf);

            ManufacturerCardDto card = new ManufacturerCardDto(unproxy1.getId(), unproxy1.getName(), unproxy1.getImage());
            manufacturerUnproxedSet.add(card);
        }

                                //------------Working---------
        ProductByIdWithManufacturerList transferContainer = new ProductByIdWithManufacturerList(content, manufacturerUnproxedSet);
        String responseContainer = mapper.writeValueAsString(transferContainer);

        return responseContainer;
    }

    public String getProdByManId(HtRequest request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Set<ProdCardManIf> productListByManufacturer = prodRepo.getProductListByManufacturer(request.getManId(), request.getСatId());
        String productList = mapper.writeValueAsString(productListByManufacturer);
        return productList;
    }

    @Override
    public String editHierarchy(HtRequest request) {
        return "Return Product Hierarchy";
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
