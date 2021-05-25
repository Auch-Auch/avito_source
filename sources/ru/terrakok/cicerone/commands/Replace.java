package ru.terrakok.cicerone.commands;

import ru.terrakok.cicerone.Screen;
public class Replace implements Command {
    public Screen a;

    public Replace(Screen screen) {
        this.a = screen;
    }

    public Screen getScreen() {
        return this.a;
    }
}
