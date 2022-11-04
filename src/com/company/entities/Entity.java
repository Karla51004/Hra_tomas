package com.company.entities;

import com.company.Map.GameLocation;
import com.company.items.Food;
import com.company.items.Potion;

public interface Entity {
    void fight();
    void defend();
    void dodge();
    void escape();
    void heal(Potion potion);
    void eat(Food food);
    void moveTo(GameLocation gameLocation);
    void talkTo(Entity entity);
    void sleep();




}
