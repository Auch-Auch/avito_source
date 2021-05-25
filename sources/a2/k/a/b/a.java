package a2.k.a.b;

import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.view.ViewScrollChangeEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<ViewScrollChangeEvent> {
    public final NestedScrollView a;

    /* renamed from: a2.k.a.b.a$a  reason: collision with other inner class name */
    public static final class C0089a extends MainThreadDisposable implements NestedScrollView.OnScrollChangeListener {
        public final NestedScrollView b;
        public final Observer<? super ViewScrollChangeEvent> c;

        public C0089a(@NotNull NestedScrollView nestedScrollView, @NotNull Observer<? super ViewScrollChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(nestedScrollView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = nestedScrollView;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) null);
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(@NotNull NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            Intrinsics.checkParameterIsNotNull(nestedScrollView, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(new ViewScrollChangeEvent(this.b, i, i2, i3, i4));
            }
        }
    }

    public a(@NotNull NestedScrollView nestedScrollView) {
        Intrinsics.checkParameterIsNotNull(nestedScrollView, "view");
        this.a = nestedScrollView;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super ViewScrollChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0089a aVar = new C0089a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnScrollChangeListener(aVar);
        }
    }
}
