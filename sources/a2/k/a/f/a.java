package a2.k.a.f;

import android.widget.AbsListView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AbsListViewScrollEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<AbsListViewScrollEvent> {
    public final AbsListView a;

    /* renamed from: a2.k.a.f.a$a  reason: collision with other inner class name */
    public static final class C0093a extends MainThreadDisposable implements AbsListView.OnScrollListener {
        public int b;
        public final AbsListView c;
        public final Observer<? super AbsListViewScrollEvent> d;

        public C0093a(@NotNull AbsListView absListView, @NotNull Observer<? super AbsListViewScrollEvent> observer) {
            Intrinsics.checkParameterIsNotNull(absListView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.c = absListView;
            this.d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.c.setOnScrollListener(null);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(@NotNull AbsListView absListView, int i, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(absListView, "absListView");
            if (!isDisposed()) {
                this.d.onNext(new AbsListViewScrollEvent(this.c, this.b, i, i2, i3));
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(@NotNull AbsListView absListView, int i) {
            Intrinsics.checkParameterIsNotNull(absListView, "absListView");
            this.b = i;
            if (!isDisposed()) {
                AbsListView absListView2 = this.c;
                this.d.onNext(new AbsListViewScrollEvent(absListView2, i, absListView2.getFirstVisiblePosition(), this.c.getChildCount(), this.c.getCount()));
            }
        }
    }

    public a(@NotNull AbsListView absListView) {
        Intrinsics.checkParameterIsNotNull(absListView, "view");
        this.a = absListView;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super AbsListViewScrollEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0093a aVar = new C0093a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnScrollListener(aVar);
        }
    }
}
