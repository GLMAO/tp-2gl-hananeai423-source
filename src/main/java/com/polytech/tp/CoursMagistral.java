package com.polytech.tp;

public class CoursMagistral extends CoursDecorator {
     public CoursMagistral(ICours cours) {
        //TODO: Implémenter le reste ...
         super(cours);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        
        return coursDecorated.getDescription()+" (Magistral)";
    }

    @Override
    public double getDuree() {
        // TODO Auto-generated method stub
        
        return coursDecorated.getDuree();
    };
}
