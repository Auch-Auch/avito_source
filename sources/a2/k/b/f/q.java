package a2.k.b.f;

import android.widget.SearchView;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.jakewharton.rxbinding4.widget.SearchViewQueryTextEvent;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class q extends InitialValueObservable<SearchViewQueryTextEvent> {
    public final SearchView a;

    public static final class a extends MainThreadDisposable implements SearchView.OnQueryTextListener {
        public final SearchView b;
        public final Observer<? super SearchViewQueryTextEvent> c;

        public a(@NotNull SearchView searchView, @NotNull Observer<? super SearchViewQueryTextEvent> observer) {
            Intrinsics.checkParameterIsNotNull(searchView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = searchView;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnQueryTextListener(null);
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "s");
            if (isDisposed()) {
                return false;
            }
            this.c.onNext(new SearchViewQueryTextEvent(this.b, str, false));
            return true;
        }

        @Override // android.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "query");
            if (isDisposed()) {
                return false;
            }
            this.c.onNext(new SearchViewQueryTextEvent(this.b, str, true));
            return true;
        }
    }

    public q(@NotNull SearchView searchView) {
        Intrinsics.checkParameterIsNotNull(searchView, "view");
        this.a = searchView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public SearchViewQueryTextEvent getInitialValue() {
        SearchView searchView = this.a;
        CharSequence query = searchView.getQuery();
        Intrinsics.checkExpressionValueIsNotNull(query, "view.query");
        return new SearchViewQueryTextEvent(searchView, query, false);
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super SearchViewQueryTextEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            this.a.setOnQueryTextListener(aVar);
            observer.onSubscribe(aVar);
        }
    }
}
