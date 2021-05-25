package a2.a.a.h3.a;

import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class w<T> implements Consumer<LoadingState<? super Object>> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

    public w(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        this.a = myAdvertDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Object> loadingState) {
        LoadingState<? super Object> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.g = 8;
            MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl = this.a;
            MyAdvertDetailsPresenterImpl.h(myAdvertDetailsPresenterImpl, null, myAdvertDetailsPresenterImpl.G.getDraftDeleteConfirmation(), false, null, 9);
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.d(((LoadingState.Error) loadingState2).getError());
        }
    }
}
