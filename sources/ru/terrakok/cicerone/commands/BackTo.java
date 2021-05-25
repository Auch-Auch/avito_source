package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;
public class BackTo implements Command {
    public Screen a;

    public BackTo(Screen screen) {
        this.a = screen;
    }

    public Screen getScreen() {
        return this.a;
    }
}
