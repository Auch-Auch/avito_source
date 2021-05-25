package a2.k.a.d;

import android.view.MenuItem;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends Observable<Unit> {
    public final MenuItem a;
    public final Function1<MenuItem, Boolean> b;

    public static final class a extends MainThreadDisposable implements MenuItem.OnMenuItemClickListener {
        public final MenuItem b;
        public final Function1<MenuItem, Boolean> c;
        public final Observer<? super Unit> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.MenuItem, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItem, Boolean> function1, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = menuItem;
            this.c = function1;
            this.d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnMenuItemClickListener(null);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke(this.b).booleanValue()) {
                    return false;
                }
                this.d.onNext(Unit.INSTANCE);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.MenuItem, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull MenuItem menuItem, @NotNull Function1<? super MenuItem, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = menuItem;
        this.b = function1;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnMenuItemClickListener(aVar);
        }
    }
}
