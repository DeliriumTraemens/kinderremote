package org.nick.kinderremote.util.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class PackageClassMapBuilder {
    private static final String SCANNED_PAKAGE = "org.nick.kinderremote.service";

    @Autowired
    private PackageClassScanner packageScanner;
        public static Map<String, Class<?>> serviceClassNameMap =new HashMap<>();
//        public static Map<String, Class<?>> serviceMethodNameMap =new HashMap<>();

    @Bean
    public List<Class<?>> classList(){
//        System.out.println("==================+++++================");
//        System.out.println("==================+++++================");
//        packageScanner.find(SCANNED_PAKAGE).forEach(System.out::println);
        return packageScanner.find(SCANNED_PAKAGE);
    }

    @Bean
//    public Map<String, Class<?>> classMap(){
    public void classMap(){
        List<Class<?>> classes = packageScanner.find(SCANNED_PAKAGE);

        for (Class<?> aClass : classes) {
            String name = aClass.getName().replace(SCANNED_PAKAGE+".", "");
            System.out.println("Map name=================>> " + name);
//            String name2=name.replace("Service","Serv");
            serviceClassNameMap.put(name, aClass);
        }

        System.out.println("----==== serviceClassNameMap.entrySet() =====---------");
        serviceClassNameMap.entrySet().forEach(System.out::println);

        // Далее создаем мапку методов для каждого класса из serviceClassNameMap

//        return map;
    }
}
