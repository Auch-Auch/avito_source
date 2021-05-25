package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;
public class Forward implements Command {
    public Screen a;

    public Forward(Screen screen) {
        this.a = screen;
    }

    public Screen getScreen() {
        return this.a;
    }
}
