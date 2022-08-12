package org.nick.kinderremote.service;

import org.nick.kinderremote.util.funcif.AbstractIf;
import org.nick.kinderremote.util.funcif.FuncFunction;
import org.nick.kinderremote.util.funcif.FuncSuplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Function;

//@Service
public class TestService {
    @Autowired
    CategoryService catService;
    Function<String, Long> func = null;
    ConcurrentSkipListMap<String, AbstractIf > mapp = new ConcurrentSkipListMap<>();
    List<AbstractIf > list1 = new ArrayList<>();
    //    AbstractIf cat=new FuncFunction<Long,String>();
    FuncFunction<Long, String> funcFuncCatalog = catService::categoryById;
    FuncSuplier<String> supplyCatalog = catService::getCatalog2;
//    Consumer

    public TestService() {
//        AbstractIf byId = this.supplyCatalog;
//        AbstractIf supCat = this.funcFuncCatalog;
//        list1.add(funcFuncCatalog);
//        this.mapp.put("ById", byId);
//        this.mapp.put("SupCat", supCat);
    }

    //    UnaryOperator<Long> func = (t)->TrainService.getById(t);

}

