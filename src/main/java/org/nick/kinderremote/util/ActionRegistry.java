package org.nick.kinderremote.util;

import java.util.concurrent.ConcurrentSkipListMap;

public class ActionRegistry<T>{
    public ConcurrentSkipListMap<String, T> map = new ConcurrentSkipListMap<>();
    public void add(final String actionName, final T behaveFunc ){
        this.assertContainsNameNot(actionName);
        ActionRegistry.assertArgNotNull(behaveFunc);
        this.map.put(actionName, behaveFunc);
    }

    public T get(final String actionName){
        this.assertContainsName(actionName);
        return this.map.get(actionName);
    }

    public void replace(final String actionName, final T behaveFunc){
        this.assertContainsName(actionName);
        ActionRegistry.assertArgNotNull(behaveFunc);
        this.map.put(actionName, behaveFunc);
    }

    public void remove(final String actionName){
        this.assertContainsName(actionName);
        this.map.remove(actionName);
    }

    //Checks
    protected static void assertArgNotNull(final Object arg){
        if( (arg instanceof String) && !"".equals(arg) ) {
            return;
        }
        if( arg != null) {
            return;
        }
        throw new RuntimeException("Пустой аргумент");
    }

    protected void assertMapNotNull(){
        if( this.map == null) throw new RuntimeException("Отсутствует Map");
    }

    public boolean contains (final String actionName){
        ActionRegistry.assertArgNotNull(actionName);
        this.assertMapNotNull();
        return this.map.containsKey(actionName) && (this.map.get(actionName) != null);
    }

    protected void assertContainsName(final String actionName){
        ActionRegistry.assertArgNotNull(actionName);
        this.assertMapNotNull();
        if ( !this.contains(actionName)){
            throw new RuntimeException("Способность \"" +actionName+ "\" не зарегистрирована");
        }
    }

    protected void assertContainsNameNot(final String actionName){
        ActionRegistry.assertArgNotNull(actionName);
        this.assertMapNotNull();
        if(this.contains(actionName)){
            throw new RuntimeException("Способность \"" +actionName+ "\" уже зарегистрирована");
        }
    }
}
