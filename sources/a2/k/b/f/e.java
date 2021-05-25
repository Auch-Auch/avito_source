package a2.k.b.f;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class e extends Observable<Integer> {
    public final AdapterView<?> a;
    public final Function0<Boolean> b;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {
        public final AdapterView<?> b;
        public final Observer<? super Integer> c;
        public final Function0<Boolean> d;

        public a(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super Integer> observer, @NotNull Function0<Boolean> function0) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            Intrinsics.checkParameterIsNotNull(function0, "handled");
            this.b = adapterView;
            this.c = observer;
            this.d = function0;
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
            try {
                if (!this.d.invoke().booleanValue()) {
                    return false;
                }
                this.c.onNext(Integer.valueOf(i));
                return true;
            } catch (Exception e) {
                this.c.onError(e);
                dispose();
                return false;
            }
        }
    }

    public e(@NotNull AdapterView<?> adapterView, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        Intrinsics.checkParameterIsNotNull(function0, "handled");
        this.a = adapterView;
        this.b = function0;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Integer> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer, this.b);
            observer.onSubscribe(aVar);
            this.a.setOnItemLongClickListener(aVar);
        }
    }
}
