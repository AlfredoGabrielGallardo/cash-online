package com.cashonline.apirest.controllers.dto;

import java.io.Serializable;

//DTO file to show pagination
public class ItemDto implements Serializable {

//    Attributes:
    private Integer id;
    private Integer total;
    private Integer userId;

//    Builders:
    public ItemDto() {
    }

    public ItemDto(Integer id, Integer total, Integer userId) {
        this.id = id;
        this.total = total;
        this.userId = userId;
    }

//    Getter and Setter:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;

}
