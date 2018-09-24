package com.company;

import World.World;

public class Main
{
    // TODO: Create a 2 dimensional array for the world. put the players in the center and let them fight
    // TODO?: Implement character archetypes, like bold, cowardice and neutral
    // TODO?: Chose new route based on archetype and possible registered event
    // TODO?: Set a travel goal and Use A* to navigate.
    // TODO: Spawn items across the battlefield
    // TODO: Hunger damage? Finding food will reset this timer
    // TODO: Rethink crafting and finish crafting in general
    // TODO: Make battleSystem (Dungeons and dragons)
    // TODO: Console app to cycle through days. Default half day jumps or specify to skip more

    public static void main(String[] args)
    {   // runs the loop to play the game
        World.getInstance().start();
    }
}

