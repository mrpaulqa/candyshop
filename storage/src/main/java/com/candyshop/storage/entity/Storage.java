package com.candyshop.storage.entity;


import lombok.Data;

import java.util.List;

@Data
public class Storage {
    Long id;
    Candy item;
    Long quantity;
    Long reserved;
    List<Candy> candyList;

}
