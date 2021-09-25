package com.candyshop.storage.entity;

import com.candyshop.candycrud.entity.Candy;
import lombok.Data;

@Data
public class Storage {
    Candy item;
    Long quantity;
    Long reserved;

}
