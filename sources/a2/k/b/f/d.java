package a2.k.b.f;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.jakewharton.rxbinding4.widget.AdapterViewItemLongClickEvent;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class d extends Observable<AdapterViewItemLongClickEvent> {
    public final AdapterView<?> a;
    public final Function1<AdapterViewItemLongClickEvent, Boolean> b;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {
        public final AdapterView<?> b;
        public final Observer<? super AdapterViewItemLongClickEvent> c;
        public final Function1<AdapterViewItemLongClickEvent, Boolean> d;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding4.widget.AdapterViewItemLongClickEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super AdapterViewItemLongClickEvent> observer, @NotNull Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            this.b = adapterView;
            this.c = observer;
            this.d = function1;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnItemLongClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
            Intrinsics.checkParameterIsNotNull(adapterView, "parent");
            if (isDisposed()) {
                return false;
            }
            AdapterViewItemLongClickEvent adapterViewItemLongClickEvent = new AdapterViewItemLongClickEvent(adapterView, view, i, j);
            try {
                if (!this.d.invoke(adapterViewItemLongClickEvent).booleanValue()) {
                    return false;
                }
                this.c.onNext(adapterViewItemLongClickEvent);
                return true;
            } catch (Exception e) {
                this.c.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding4.widget.AdapterViewItemLongClickEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull AdapterView<?> adapterView, @NotNull Function1<? super AdapterViewItemLongClickEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = adapterView;
        this.b = function1;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super AdapterViewItemLongClickEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer, this.b);
            observer.onSubscribe(aVar);
            this.a.setOnItemLongClickListener(aVar);
        }
    }
}
