package a2.a.a.l;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
public final class c<T> implements ObservableOnSubscribe<LoadingState<? super DeepLink>> {
    public final /* synthetic */ d a;
    public final /* synthetic */ Throwable b;

    public c(d dVar, Throwable th) {
        this.a = dVar;
        this.b = th;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<com.avito.android.util.LoadingState<com.avito.android.deep_linking.links.DeepLink>>] */
    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<LoadingState<? super DeepLink>> observableEmitter) {
        this.a.a.f.trackPhoneLoadError();
        observableEmitter.onNext(new LoadingState.Error(this.a.a.e.convert(this.b)));
        observableEmitter.onError(this.b);
    }
}
