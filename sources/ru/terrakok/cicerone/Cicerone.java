package ru.terrakok.cicerone;

import ru.terrakok.cicerone.BaseRouter;
public class Cicerone<T extends BaseRouter> {
    public T a;

    public Cicerone(T t) {
        this.a = t;
    }

    public static Cicerone<Router> create() {
        return create(new Router());
    }

    public NavigatorHolder getNavigatorHolder() {
        return this.a.a;
    }

    public T getRouter() {
        return this.a;
    }

    public static <T extends BaseRouter> Cicerone<T> create(T t) {
        return new Cicerone<>(t);
    }
}
