package a2.a.a.l;

import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Throwable, ObservableSource<? extends LoadingState<? super DeepLink>>> {
    public final /* synthetic */ AsyncPhonePresenterImpl a;

    public d(AsyncPhonePresenterImpl asyncPhonePresenterImpl) {
        this.a = asyncPhonePresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends LoadingState<? super DeepLink>> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "error");
        return Observable.create(new c(this, th2));
    }
}
