package org.nick.kinderremote.util.funcif;
@FunctionalInterface
public interface FuncSuplier<T> extends AbstractIf{
    T get();
}
