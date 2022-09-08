package org.nick.kinderremote.util.state;

import java.util.Arrays;
import java.util.List;

public class StartState {
    public static String initString = "State String Odnako!!!";
    public static List<String> staticList = Arrays.asList("First", "Second", "Third");
    public StartState() {
        System.out.println(staticList.toString());
    }

//    public static void setInitString(String initString) {
//        StartState.initString = initString;
//    }
}
