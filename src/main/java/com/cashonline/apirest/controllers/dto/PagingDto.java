package com.cashonline.apirest.controllers.dto;

import java.io.Serializable;

//DTO file to show pagination
public class PagingDto implements Serializable {

//    Attributes:
    private Integer page;
    private Integer size;
    private Integer total;

//    Builders:
    public PagingDto() {
    }

    public PagingDto(Integer page, Integer size, Integer total) {
        this.page = page;
        this.size = size;
        this.total = total;
    }

//    Getter and Setter:
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    private static final long serialVersionUID = 1L;

}
