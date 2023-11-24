package com.example.pms.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Products {
    private Collection<Product> products = new ArrayList<Product>();
}
