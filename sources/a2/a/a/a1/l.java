package a2.a.a.a1;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class l<T> implements Consumer<LoadingState<? super DeepLink>> {
    public final /* synthetic */ HomePresenterImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SearchParams c;

    public l(HomePresenterImpl homePresenterImpl, String str, SearchParams searchParams) {
        this.a = homePresenterImpl;
        this.b = str;
        this.c = searchParams;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super DeepLink> loadingState) {
        LoadingState<? super DeepLink> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            HomePresenterImpl.access$searchByDeeplink(this.a, (DeepLink) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            HomePresenterImpl.access$searchByQuery(this.a, this.b, this.c);
        }
    }
}
