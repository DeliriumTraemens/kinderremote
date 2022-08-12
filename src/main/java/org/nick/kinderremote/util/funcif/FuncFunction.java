package org.nick.kinderremote.util.funcif;
@FunctionalInterface
public interface FuncFunction <T, R> extends AbstractIf{
    R apply(T t);
}
