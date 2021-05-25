package a2.k.b.a;

import androidx.appcompat.widget.SearchView;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class f extends InitialValueObservable<CharSequence> {
    public final SearchView a;

    public static final class a extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        public final SearchView b;
        public final Observer<? super CharSequence> c;

        public a(@NotNull SearchView searchView, @NotNull Observer<? super CharSequence> observer) {
            Intrinsics.checkParameterIsNotNull(searchView, "searchView");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = searchView;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnQueryTextListener(null);
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "s");
            if (isDisposed()) {
                return false;
            }
            this.c.onNext(str);
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "query");
            return false;
        }
    }

    public f(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        this.a = searchView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public CharSequence getInitialValue() {
        return this.a.getQuery();
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super CharSequence> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnQueryTextListener(aVar);
        }
    }
}
