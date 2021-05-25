package ru.terrakok.cicerone;
public abstract class Screen {
    public String screenKey = getClass().getCanonicalName();

    public String getScreenKey() {
        return this.screenKey;
    }
}
