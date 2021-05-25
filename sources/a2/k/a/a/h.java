package a2.k.a.a;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class h extends Observable<Unit> {
    public final Toolbar a;

    public static final class a extends MainThreadDisposable implements View.OnClickListener {
        public final Toolbar b;
        public final Observer<? super Unit> c;

        public a(@NotNull Toolbar toolbar, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(toolbar, "toolbar");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = toolbar;
            this.c = observer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setNavigationOnClickListener(null);
        }
    }

    public h(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.a = toolbar;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setNavigationOnClickListener(aVar);
        }
    }
}
