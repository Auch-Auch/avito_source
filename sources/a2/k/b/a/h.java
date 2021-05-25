package a2.k.b.a;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
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

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setNavigationOnClickListener(null);
        }
    }

    public h(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.a = toolbar;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setNavigationOnClickListener(aVar);
        }
    }
}
