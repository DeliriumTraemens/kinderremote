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
    private PackageClassScanner scanner;
        public static Map<String, Class<?>> map=new HashMap<>();

    @Bean
    public List<Class<?>> classList(){
        System.out.println("==================+++++================");
        System.out.println("==================+++++================");
        scanner.find(SCANNED_PAKAGE).forEach(System.out::println);
        return scanner.find(SCANNED_PAKAGE);
    }

    @Bean
//    public Map<String, Class<?>> classMap(){
    public void classMap(){
        List<Class<?>> classes = scanner.find(SCANNED_PAKAGE);
        for (Class<?> aClass : classes) {
            String name = aClass.getName().replace("org.nick.kinderremote.service.", "");
            String name2=name.replace("Service","Serv");
            map.put(name2, aClass);
        }

        System.out.println("----=========---------");
        map.entrySet().forEach(System.out::println);

//        return map;
    }
}
