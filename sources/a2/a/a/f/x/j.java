package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class j<T> implements Consumer<LoadingState<? super AutotekaTeaserResponse>> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;

    public j(AdvertDetailsPresenterImpl advertDetailsPresenterImpl) {
        this.a = advertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super AutotekaTeaserResponse> loadingState) {
        LoadingState<? super AutotekaTeaserResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.o = ((AutotekaTeaserResponse) ((LoadingState.Loaded) loadingState2).getData()).getResult();
        }
    }
}
