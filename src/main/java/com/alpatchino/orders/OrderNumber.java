package com.alpatchino.orders;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by patri on 22/09/2017.
 *
 * Taken from: https://www.youtube.com/watch?v=uOrk8mZmjaM
 */
public class OrderNumber implements Serializable, Formattable {

    private final Integer value;

    // final on value forces to have constructor
    private OrderNumber(Integer value){
        this.value = value;
    }

    public static OrderNumber of(Integer value){
        checkNotNull(value);
        checkArgument(value > 0);
        return new OrderNumber(value);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof OrderNumber){
            OrderNumber other = (OrderNumber) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.value);
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        // pretty printing
        formatter.format("%d", value);
    }
}
