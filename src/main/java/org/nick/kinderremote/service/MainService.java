package org.nick.kinderremote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nick.kinderremote.data.dto.HtRequest;
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

    Map<String, Method> methodsMap = new HashMap();
//    Map<String, ServiceAbstract> services = new HashMap<>();
    ObjectMapper objectMaper;

//    private final CatService catService;
//    private final ProdService prodService;

//    ActionRegistry<Function> registry = new ActionRegistry<>();

    private final ApplicationContext context;

    @Autowired
    public MainService(ApplicationContext context) {
        this.context = context;
    }



        /**
         * Получить класс, метод
         * Инвок с аргументами
         * Сформировать и вернуть строковый Джейсонированный Респонс
         */
    public String dispatcher(HtRequest request) throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> servClassName = serviceClassNameMap.get(request.getServiceName());

        Object bean = context.getBean(servClassName);

        System.out.println("BEAN IS "+bean.toString());
        Method[] declaredMethods = servClassName.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            methodsMap.put(declaredMethod.getName(), declaredMethod);
        }

        Method requestedMethod = methodsMap.get(request.getMethodName());

        Object invoke = requestedMethod.invoke(bean, request);
        return invoke.toString();
    }
    public String dispatcher2(HtRequest request) throws InvocationTargetException, IllegalAccessException {
        Class<?> classBean = (Class<?>) context.getBean(request.getServiceName());
//        classBean.getName()
        Map<String, Method> beanMethodsMap = new HashMap();
        Method[] declaredMethods = classBean.getDeclaredMethods();
        for(Method declaredMethod: declaredMethods){
            beanMethodsMap.put(declaredMethod.getName(), declaredMethod);
        }
        Method requestedMethod = beanMethodsMap.get(request.getMethodName());
        String response = requestedMethod.invoke(classBean, request).toString();
        return response;
    }



}
