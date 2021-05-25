package a2.k.a.c;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<Unit> {
    public final SwipeRefreshLayout a;

    /* renamed from: a2.k.a.c.a$a  reason: collision with other inner class name */
    public static final class C0090a extends MainThreadDisposable implements SwipeRefreshLayout.OnRefreshListener {
        public final SwipeRefreshLayout b;
        public final Observer<? super Unit> c;

        public C0090a(@NotNull SwipeRefreshLayout swipeRefreshLayout, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = swipeRefreshLayout;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnRefreshListener(null);
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }
    }

    public a(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "view");
        this.a = swipeRefreshLayout;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0090a aVar = new C0090a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnRefreshListener(aVar);
        }
    }
}
