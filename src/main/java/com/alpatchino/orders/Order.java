package com.alpatchino.orders;

import com.google.common.collect.ImmutableList;
import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by patri on 22/09/2017.
 *
 * Taken from https://www.youtube.com/watch?v=uOrk8mZmjaM
 *
 * Classes should have high immutability, no mutable state as you'd eliminate nulls
 */
@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private OrderNumber number;

    @ElementCollection // replaces @OneToMany/OneToOne as OrdemItem is not @Entity
    private List<OrderItem> items = new ArrayList<>();

    protected Order(){

    }

    private Order(OrderNumber number){
        this.number = number;
    }

    public static Order of(Integer number){
        checkNotNull(number);
        checkArgument(number > 0);
        return new Order();
    }

    // think about getters and setters, don't expose everything
    // getId() could be useful for logging but you shouldn't print
    // primary keys

    // user will need to see order number
    public OrderNumber getNumber(){
        return number;
    }

    // no one should mess with the items so getter only
    public List<OrderItem> getItems(){
        // if someones tries to change the list then throws UnsupportedOperationException
        return ImmutableList.copyOf(items);
    }

    // this is the only entry point to the list
    public void addItem(OrderItem item){
        checkNotNull(item);
        if(items.contains(item)){
            // custom logic for dealing with duplicates
        }
        items.add(item);
    }

    public int getAmountOfItems(){
        return items.size();
    }

    public BigDecimal getTotalOfItems(){
        return items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



}
