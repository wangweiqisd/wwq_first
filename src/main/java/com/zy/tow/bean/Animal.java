package com.zy.tow.bean;

public class Animal {
    private Integer weight;
    private Integer height;
    private String name;

    public Animal(Integer weight, Integer height, String name) {
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "weight=" + weight +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
