package a2.k.a.f;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AdapterViewItemClickEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class b extends Observable<AdapterViewItemClickEvent> {
    public final AdapterView<?> a;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemClickListener {
        public final AdapterView<?> b;
        public final Observer<? super AdapterViewItemClickEvent> c;

        public a(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super AdapterViewItemClickEvent> observer) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = adapterView;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnItemClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
            Intrinsics.checkParameterIsNotNull(adapterView, "parent");
            if (!isDisposed()) {
                this.c.onNext(new AdapterViewItemClickEvent(adapterView, view, i, j));
            }
        }
    }

    public b(@NotNull AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super AdapterViewItemClickEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnItemClickListener(aVar);
        }
    }
}
