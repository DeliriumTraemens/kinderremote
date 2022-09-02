package org.nick.kinderremote.util.repoServiceUtil;

import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.service.CommonService;

import java.util.function.BiConsumer;
import java.util.function.Function;

public enum CatServiceEnum {
    GETALL("GetAll", CommonService::getAll),
    GETBYID("GetById", CommonService::getById),
    EDITIERARCHY("EditHierarchy", CommonService::editHierarchy),
    EDITBYID("EditById", CommonService::editById),
    CREATENEW("CreateNew", CommonService::createNew),
    DELETE("DeleteById",CommonService::delete);

    public String name;
//    public Function<String, HtRequest> func;
    public Function<HtRequest,String> func;

    CatServiceEnum(final String name, final Function<HtRequest,String> func) {
        this.name = name;
        this.func = func;
    }

    public void SendTo(final BiConsumer<String, Function<HtRequest,String>> api){
        api.accept(this.name, this.func);
    }
}
