package com.cashonline.apirest.controllers.dto;

import java.io.Serializable;
import java.util.List;

//DTO file to show pagination
public class LoanResponseDto implements Serializable {

//    Attributes:
    private List<ItemDto> items;
    private PagingDto paging;

//    Builders:
    public LoanResponseDto() {
    }

    public LoanResponseDto(List<ItemDto> items, PagingDto paging) {
        this.items = items;
        this.paging = paging;
    }

//    Getter and Setter:
    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public PagingDto getPaging() {
        return paging;
    }

    public void setPaging(PagingDto paging) {
        this.paging = paging;
    }

    private static final long serialVersionUID = 1L;

}
