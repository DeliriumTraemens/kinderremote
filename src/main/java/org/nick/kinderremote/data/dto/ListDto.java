package org.nick.kinderremote.data.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListDto<T> {
    private List<T> data = new ArrayList<>();
    private int currentPage;
    private int totalPages;
    private String httpStatus;
//    cons

    public ListDto(List<T> data, int currentPage, int totalPages, String httpStatus) {
        this.data = data;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.httpStatus = httpStatus;
    }
//    GetSet

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
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
        if (!(o instanceof ListDto)) return false;
        ListDto<?> listDto = (ListDto<?>) o;
        return getCurrentPage() == listDto.getCurrentPage() &&
                getTotalPages() == listDto.getTotalPages() &&
                getData().equals(listDto.getData()) &&
                Objects.equals(getHttpStatus(), listDto.getHttpStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getCurrentPage(), getTotalPages(), getHttpStatus());
    }
}
