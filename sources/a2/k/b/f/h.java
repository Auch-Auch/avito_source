package a2.k.b.f;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.jakewharton.rxbinding4.widget.AdapterViewItemClickEvent;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class h extends Observable<AdapterViewItemClickEvent> {
    public final AutoCompleteTextView a;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemClickListener {
        public final AutoCompleteTextView b;
        public final Observer<? super AdapterViewItemClickEvent> c;

        public a(@NotNull AutoCompleteTextView autoCompleteTextView, @NotNull Observer<? super AdapterViewItemClickEvent> observer) {
            Intrinsics.checkParameterIsNotNull(autoCompleteTextView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = autoCompleteTextView;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
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

    public h(@NotNull AutoCompleteTextView autoCompleteTextView) {
        Intrinsics.checkParameterIsNotNull(autoCompleteTextView, "view");
        this.a = autoCompleteTextView;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super AdapterViewItemClickEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnItemClickListener(aVar);
        }
    }
}
