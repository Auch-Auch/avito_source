package a2.k.a.a;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class g extends Observable<MenuItem> {
    public final Toolbar a;

    public static final class a extends MainThreadDisposable implements Toolbar.OnMenuItemClickListener {
        public final Toolbar b;
        public final Observer<? super MenuItem> c;

        public a(@NotNull Toolbar toolbar, @NotNull Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = toolbar;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnMenuItemClickListener(null);
        }

        @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return true;
            }
            this.c.onNext(menuItem);
            return true;
        }
    }

    public g(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.a = toolbar;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnMenuItemClickListener(aVar);
        }
    }
}
