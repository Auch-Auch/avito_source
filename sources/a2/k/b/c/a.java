package a2.k.b.c;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<Unit> {
    public final SwipeRefreshLayout a;

    /* renamed from: a2.k.b.c.a$a  reason: collision with other inner class name */
    public static final class C0096a extends MainThreadDisposable implements SwipeRefreshLayout.OnRefreshListener {
        public final SwipeRefreshLayout b;
        public final Observer<? super Unit> c;

        public C0096a(@NotNull SwipeRefreshLayout swipeRefreshLayout, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = swipeRefreshLayout;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
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

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0096a aVar = new C0096a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnRefreshListener(aVar);
        }
    }
}
