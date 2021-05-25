package a2.k.a.d;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.MenuItemActionViewCollapseEvent;
import com.jakewharton.rxbinding3.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding3.view.MenuItemActionViewExpandEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<MenuItemActionViewEvent> {
    public final MenuItem a;
    public final Function1<MenuItemActionViewEvent, Boolean> b;

    /* renamed from: a2.k.a.d.a$a  reason: collision with other inner class name */
    public static final class MenuItem$OnActionExpandListenerC0091a extends MainThreadDisposable implements MenuItem.OnActionExpandListener {
        public final MenuItem b;
        public final Function1<MenuItemActionViewEvent, Boolean> c;
        public final Observer<? super MenuItemActionViewEvent> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding3.view.MenuItemActionViewEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public MenuItem$OnActionExpandListenerC0091a(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItemActionViewEvent, Boolean> function1, @NotNull Observer<? super MenuItemActionViewEvent> observer) {
            Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = menuItem;
            this.c = function1;
            this.d = observer;
        }

        public final boolean a(MenuItemActionViewEvent menuItemActionViewEvent) {
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke(menuItemActionViewEvent).booleanValue()) {
                    return false;
                }
                this.d.onNext(menuItemActionViewEvent);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnActionExpandListener(null);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            return a(new MenuItemActionViewCollapseEvent(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            return a(new MenuItemActionViewExpandEvent(menuItem));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding3.view.MenuItemActionViewEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItemActionViewEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = menuItem;
        this.b = function1;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super MenuItemActionViewEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            MenuItem$OnActionExpandListenerC0091a aVar = new MenuItem$OnActionExpandListenerC0091a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnActionExpandListener(aVar);
        }
    }
}
