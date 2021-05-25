package l6.b.c.a;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
public abstract class a {
    public final Context a;
    public SimpleArrayMap<SupportMenuItem, MenuItem> b;
    public SimpleArrayMap<SupportSubMenu, SubMenu> c;

    public a(Context context) {
        this.a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.b == null) {
            this.b = new SimpleArrayMap<>();
        }
        MenuItem menuItem2 = this.b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.a, supportMenuItem);
        this.b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu b(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.c == null) {
            this.c = new SimpleArrayMap<>();
        }
        SubMenu subMenu2 = this.c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        e eVar = new e(this.a, supportSubMenu);
        this.c.put(supportSubMenu, eVar);
        return eVar;
    }
}
