package a2.a.a.l;

import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhoneView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class f<T, R> implements Function<Throwable, ObservableSource<? extends Unit>> {
    public final /* synthetic */ AsyncPhonePresenterImpl.b a;

    public f(AsyncPhonePresenterImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Unit> apply(Throwable th) {
        Observable<Unit> showPhoneLoadError;
        Observable<Unit> doOnNext;
        AsyncPhoneView asyncPhoneView = this.a.a.a;
        return (asyncPhoneView == null || (showPhoneLoadError = asyncPhoneView.showPhoneLoadError()) == null || (doOnNext = showPhoneLoadError.doOnNext(new e(this))) == null) ? Observable.empty() : doOnNext;
    }
}
