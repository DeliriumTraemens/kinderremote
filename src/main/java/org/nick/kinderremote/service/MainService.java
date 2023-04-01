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
    public Object dispatcher(HtRequest request) throws JsonProcessingException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//      TODO: axios methods in Front must be reformatted to avoid lowercasing of serviceName in request
        String serviceName3 = request.getServiceName();
        serviceName3=serviceName3.substring(0, 1).toLowerCase()+serviceName3.substring(1);

        Object newBean = context.getBean(serviceName3);

        Class<?> serviceClassFromContext = newBean.getClass();

        Method method = serviceClassFromContext.getMethod(request.getMethodName(), HtRequest.class);

        return method.invoke(newBean, request).toString();
//        return result;

//=============Old Code Section below

//        Class<?> servClassName = serviceClassNameMap.get(request.getServiceName());
//        System.out.println("========ServClassName==========");
//        System.out.println(servClassName.getName());
//        Object bean = context.getBean(servClassName);
//
//        Method[] declaredMethods = servClassName.getDeclaredMethods();
//
//
//        for (Method declaredMethod : declaredMethods) {
//            methodsMap.put(declaredMethod.getName(), declaredMethod);
//        }
//
//        Method requestedMethod = methodsMap.get(request.getMethodName());
//        Object invoke = requestedMethod.invoke(bean, request);

//        return invoke.toString();



    }

    public String dispatcher2(HtRequest request) throws InvocationTargetException, IllegalAccessException {
        Class<?> classBean = (Class<?>) context.getBean(request.getServiceName());
//        classBean.getName()
        Map<String, Method> beanMethodsMap = new HashMap();
        Method[] declaredMethods = classBean.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            beanMethodsMap.put(declaredMethod.getName(), declaredMethod);
        }
        Method requestedMethod = beanMethodsMap.get(request.getMethodName());
        String response = requestedMethod.invoke(classBean, request).toString();
        return response;
    }


}
