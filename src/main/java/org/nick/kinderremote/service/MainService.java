package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.util.abstractInheritance.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.nick.kinderremote.util.state.PackageClassMapBuilder.serviceClassNameMap;

@Service
public class MainService {

    Map<String, Method> methods = new HashMap();
    Map<String, ServiceAbstract> services = new HashMap<>();
    ObjectMapper objectMaper;

    private final CatService catService;
    private final ProdService prodService;

//    ActionRegistry<Function> registry = new ActionRegistry<>();

    private final ApplicationContext context;

    @Autowired
    public MainService(CatService catService, ProdService prodService, ApplicationContext context) {

        this.catService = catService;
        this.prodService = prodService;
        this.services.put("catService", catService);
        this.services.put("prodService", prodService);
        this.context = context;
    }



        /**
         * Получить класс, метод
         * Инвок с аргументами
         * Сформировать и вернуть строковый Джейсонированный Респонс
         */
    public String dispatcher(HtRequest request) throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> servClassName = serviceClassNameMap.get(request.getServiceName());

//        Method meth = servClassName.getDeclaredMethod("getById");
//        System.out.println("Meth " + meth);

        Method[] declaredMethods = servClassName.getDeclaredMethods();

        System.out.println("Methods Array iteration - getName");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }


        System.out.println("==== servClassName Methods =====");

        for (Method declaredMethod : declaredMethods) {
            System.out.println("-------");
            System.out.println(declaredMethod.toString());
            System.out.println("Name "+declaredMethod.getName());
            methods.put(declaredMethod.getName(), declaredMethod);
        }
        System.out.println("---- Methods ----");
        methods.entrySet().forEach(System.out::println);


//        Построить мапку для сопоставления метода с длинным именем с коротким именем запроса
//        Или дописать в запросе метода недостающую часть имени
        Method requestedMethod = methods.get(request.getMethodName());
        System.out.println("========= requestedMethod =========");
        System.out.println(requestedMethod);


        Object bean = context.getBean(servClassName);

        Object invoke = requestedMethod.invoke(bean, request);
        System.out.println("--->>> invoke.toString() <<<----");
        System.out.println(invoke.toString());

//        System.out.println("----> Services <------");
//        services.entrySet().forEach(System.out::println);
        return new ObjectMapper().writeValueAsString(invoke);
    }
}
