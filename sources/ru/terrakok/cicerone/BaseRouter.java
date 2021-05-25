package ru.terrakok.cicerone;

import a7.d.a.a;
import ru.terrakok.cicerone.commands.Command;
public abstract class BaseRouter {
    public a a = new a();

    public void executeCommands(Command... commandArr) {
        a aVar = this.a;
        Navigator navigator = aVar.a;
        if (navigator != null) {
            navigator.applyCommands(commandArr);
        } else {
            aVar.b.add(commandArr);
        }
    }
}
