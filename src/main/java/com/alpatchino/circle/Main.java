package com.alpatchino.circle;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by patri on 22/09/2017.
 */
public class Main {

    public static void main(){
        Circle circle = Circle.of(2, 4);
    }
}

class Circle {

    // avoid using primitives
    @NotNull
    Integer radius;
    @NotNull
    Integer area;

    // stops the constructor being called from anywhere
    protected Circle(Integer radius, Integer area){
        this.radius = radius;
        this.area = area;
    }

    /**
     * Static factory methods are cleaner and safer while also leaving room
     * for custom validation. If this is the only way to create a Circle
     * object, then we ensure that all Circle objects in our system are valid.
     * <p>
     * If someone decides to create a circle with no radius, then the exception
     * will be thrown here instead of later when you are using it, which is harder
     * to debug. Objects need to take responsibility for validation, as it stops
     * repetition and potential errors from propagating.
     * <p>
     * @param radius in meters, must be positive non-zero integers
     * @param area in meters², must be positive non-zero integers
     * @return Circle
     * @exception NullPointerException on invalid @params
     * @see NullPointerException (related class example)
     */
    public static Circle of(Integer radius, Integer area){
        // google guice
        checkNotNull(radius, area);
        checkArgument(radius > 0 && area > 0);
        return new Circle(radius, area);
    }

}

