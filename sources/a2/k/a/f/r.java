package a2.k.a.f;

import android.widget.SearchView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class r extends InitialValueObservable<CharSequence> {
    public final SearchView a;

    public static final class a extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        public final SearchView b;
        public final Observer<? super CharSequence> c;

        public a(@NotNull SearchView searchView, @NotNull Observer<? super CharSequence> observer) {
            Intrinsics.checkParameterIsNotNull(searchView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = searchView;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnQueryTextListener(null);
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "s");
            if (isDisposed()) {
                return false;
            }
            this.c.onNext(str);
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "query");
            return false;
        }
    }

    public r(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        this.a = searchView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public CharSequence getInitialValue() {
        return this.a.getQuery();
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super CharSequence> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnQueryTextListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}
