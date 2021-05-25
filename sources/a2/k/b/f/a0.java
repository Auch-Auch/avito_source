package a2.k.b.f;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@RequiresApi(21)
public final class a0 extends Observable<MenuItem> {
    public final Toolbar a;

    public static final class a extends MainThreadDisposable implements Toolbar.OnMenuItemClickListener {
        public final Toolbar b;
        public final Observer<? super MenuItem> c;

        public a(@NotNull Toolbar toolbar, @NotNull Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull(toolbar, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = toolbar;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnMenuItemClickListener(null);
        }

        @Override // android.widget.Toolbar.OnMenuItemClickListener
        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return false;
            }
            this.c.onNext(menuItem);
            return true;
        }
    }

    public a0(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.a = toolbar;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnMenuItemClickListener(aVar);
        }
    }
}
