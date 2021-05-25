package com.jakewharton.rxbinding3.view;

import a2.b.a.a.a;
import android.view.MenuItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/jakewharton/rxbinding3/view/MenuItemActionViewCollapseEvent;", "Lcom/jakewharton/rxbinding3/view/MenuItemActionViewEvent;", "Landroid/view/MenuItem;", "component1", "()Landroid/view/MenuItem;", "menuItem", "copy", "(Landroid/view/MenuItem;)Lcom/jakewharton/rxbinding3/view/MenuItemActionViewCollapseEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/view/MenuItem;", "getMenuItem", "<init>", "(Landroid/view/MenuItem;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
public final class MenuItemActionViewCollapseEvent extends MenuItemActionViewEvent {
    @NotNull
    public final MenuItem a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuItemActionViewCollapseEvent(@NotNull MenuItem menuItem) {
        super(null);
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        this.a = menuItem;
    }

    public static /* synthetic */ MenuItemActionViewCollapseEvent copy$default(MenuItemActionViewCollapseEvent menuItemActionViewCollapseEvent, MenuItem menuItem, int i, Object obj) {
        if ((i & 1) != 0) {
            menuItem = menuItemActionViewCollapseEvent.getMenuItem();
        }
        return menuItemActionViewCollapseEvent.copy(menuItem);
    }

    @NotNull
    public final MenuItem component1() {
        return getMenuItem();
    }

    @NotNull
    public final MenuItemActionViewCollapseEvent copy(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        return new MenuItemActionViewCollapseEvent(menuItem);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof MenuItemActionViewCollapseEvent) && Intrinsics.areEqual(getMenuItem(), ((MenuItemActionViewCollapseEvent) obj).getMenuItem());
        }
        return true;
    }

    @Override // com.jakewharton.rxbinding3.view.MenuItemActionViewEvent
    @NotNull
    public MenuItem getMenuItem() {
        return this.a;
    }

    public int hashCode() {
        MenuItem menuItem = getMenuItem();
        if (menuItem != null) {
            return menuItem.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MenuItemActionViewCollapseEvent(menuItem=");
        L.append(getMenuItem());
        L.append(")");
        return L.toString();
    }
}
