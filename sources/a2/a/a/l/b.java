package a2.a.a.l;

import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<LoadingState<? super DeepLink>> {
    public final /* synthetic */ AsyncPhonePresenterImpl a;

    public b(AsyncPhonePresenterImpl asyncPhonePresenterImpl) {
        this.a = asyncPhonePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super DeepLink> loadingState) {
        if (loadingState instanceof LoadingState.Loaded) {
            this.a.f.trackPhoneLoaded();
        }
    }
}
