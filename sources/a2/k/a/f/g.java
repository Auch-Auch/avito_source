package a2.k.a.f;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.AdapterViewItemSelectionEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewNothingSelectionEvent;
import com.jakewharton.rxbinding3.widget.AdapterViewSelectionEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class g extends InitialValueObservable<AdapterViewSelectionEvent> {
    public final AdapterView<?> a;

    public static final class a extends MainThreadDisposable implements AdapterView.OnItemSelectedListener {
        public final AdapterView<?> b;
        public final Observer<? super AdapterViewSelectionEvent> c;

        public a(@NotNull AdapterView<?> adapterView, @NotNull Observer<? super AdapterViewSelectionEvent> observer) {
            Intrinsics.checkParameterIsNotNull(adapterView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = adapterView;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnItemSelectedListener(null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@NotNull AdapterView<?> adapterView, @Nullable View view, int i, long j) {
            Intrinsics.checkParameterIsNotNull(adapterView, "parent");
            if (!isDisposed()) {
                this.c.onNext(new AdapterViewItemSelectionEvent(adapterView, view, i, j));
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@NotNull AdapterView<?> adapterView) {
            Intrinsics.checkParameterIsNotNull(adapterView, "parent");
            if (!isDisposed()) {
                this.c.onNext(new AdapterViewNothingSelectionEvent(adapterView));
            }
        }
    }

    public g(@NotNull AdapterView<?> adapterView) {
        Intrinsics.checkParameterIsNotNull(adapterView, "view");
        this.a = adapterView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public AdapterViewSelectionEvent getInitialValue() {
        int selectedItemPosition = this.a.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return new AdapterViewNothingSelectionEvent(this.a);
        }
        return new AdapterViewItemSelectionEvent(this.a, this.a.getSelectedView(), selectedItemPosition, this.a.getSelectedItemId());
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super AdapterViewSelectionEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnItemSelectedListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}
