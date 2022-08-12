package org.nick.kinderremote.data.dto;

import java.util.Objects;

public class SingleDto <T>{
    private T data;
    private String httpStatus;

//    Cons

    public SingleDto(T data, String httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
    }

//    GetSet

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

//    EqHc

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleDto)) return false;
        SingleDto<?> singleDto = (SingleDto<?>) o;
        return getData().equals(singleDto.getData()) &&
                Objects.equals(getHttpStatus(), singleDto.getHttpStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getHttpStatus());
    }
}
