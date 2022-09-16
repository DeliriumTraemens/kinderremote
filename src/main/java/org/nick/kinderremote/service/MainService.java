package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.util.ActionRegistry;
import org.nick.kinderremote.util.state.PackageClassMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

@Service
public class MainService {

    ObjectMapper objectMaper;

    private final CatService catService;

    ActionRegistry<Function> registry = new ActionRegistry<>();

    @Autowired
    public MainService(CatService catService) {

        this.catService = catService;
    }



    public String dispatcher(HtRequest request) throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        ObjectMapper mapper = new ObjectMapper();
        /**
         * Получить класс, метод
         * Инвок с аргументами
         * Сформировать и вернуть строковый Джейсонированный Респонс
         * */
        Class<?> servClassName = PackageClassMapBuilder.serviceClassNameMap.get(request.getServiceName());
        Method declaredMethod = servClassName.getMethod(request.getMethodName());
        System.out.println("=======>>>========= " + declaredMethod.toString());
//        AnnotatedType annotatedReturnType = declaredMethod.getAnnotatedReturnType();
//        Object invokationResult = declaredMethod.invoke(servClassName.newInstance(), request);
        return new ObjectMapper().writeValueAsString(declaredMethod.toString());
    }
}
