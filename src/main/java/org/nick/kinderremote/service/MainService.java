package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
import org.nick.kinderremote.util.ActionRegistry;
import org.nick.kinderremote.util.state.PackageClassMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class MainService {

    Map<String, Method> methods = new HashMap();

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
        Method[] declaredMethods = servClassName.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.toString());
            methods.put(declaredMethod.getName()
                    .replace("java.lang.String org.nick.kinderremote.service.CatService.",""),declaredMethod);
        }

        for (Map.Entry<String, Method> stringMethodEntry : methods.entrySet()) {
            Method value = stringMethodEntry.getValue();
            value.getName();
            String stringValue = value.toString();
            AnnotatedType annotatedReturnType = value.getAnnotatedReturnType();
            System.out.println("----<<>>---");
            System.out.println("Name -> "+value.getName());
            System.out.println("StringValue -> "+stringValue);
            System.out.println("AnnotationType -> "+annotatedReturnType);
        }


//        System.out.println("==============<<<Methods map>>>=============");
//        methods.entrySet().forEach(System.out::println);

//        Построить мапку для сопоставления метода с длинным именем с коротким именем запроса
//        Или дописать в запросе метода недостающую часть имени
        Method requestedMethod = methods.get(request.getMethodName());
        Object invoke = requestedMethod.invoke(catService, request);
        System.out.println("--->>><<<----");
        System.out.println(invoke.toString());
        return new ObjectMapper().writeValueAsString(invoke);
    }
}
