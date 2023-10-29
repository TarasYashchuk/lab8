package sweets;

import sweets.candies.caramel.*;
import sweets.candies.chocolatecandy.*;
import sweets.candies.marmalade.*;
import sweets.candies.popsicles.*;
import sweets.other.chocolatebars.*;
import sweets.other.cookies.*;
import sweets.other.gingerbread.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Sweets {

    private String name;

    private double weight;

    private double sugarContent;

    public Sweets(String name, double weight, double sugarContent){
        this.weight = weight;
        this.name = name;
        this.sugarContent = sugarContent;
    }
    public String getName(){
        return name;
    }

    public double getSugarContent(){
        return sugarContent;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweets = (Sweets) o;
        return Double.compare(sweets.weight, weight) == 0 &&
                Double.compare(sweets.sugarContent, sugarContent) == 0 &&
                Objects.equals(name, sweets.name);
    }
}