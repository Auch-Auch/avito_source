package a7.d.a;

import java.util.LinkedList;
import java.util.Queue;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Command;
public class a implements NavigatorHolder {
    public Navigator a;
    public Queue<Command[]> b = new LinkedList();

    @Override // ru.terrakok.cicerone.NavigatorHolder
    public void removeNavigator() {
        this.a = null;
    }

    @Override // ru.terrakok.cicerone.NavigatorHolder
    public void setNavigator(Navigator navigator) {
        this.a = navigator;
        while (!this.b.isEmpty() && navigator != null) {
            Command[] poll = this.b.poll();
            Navigator navigator2 = this.a;
            if (navigator2 != null) {
                navigator2.applyCommands(poll);
            } else {
                this.b.add(poll);
            }
        }
    }
}
