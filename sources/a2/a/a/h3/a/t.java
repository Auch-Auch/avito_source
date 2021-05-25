package a2.a.a.h3.a;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class t<T> implements Consumer<LoadingState<? super SuccessResult>> {
    public final /* synthetic */ v a;

    public t(v vVar) {
        this.a = vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super SuccessResult> loadingState) {
        LoadingState<? super SuccessResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.a.O.trackDeleteAdvertLoading();
            this.a.a.O.startDeleteAdvertDraw();
            this.a.a.g = 8;
            MyAdvertDetailsPresenterImpl.h(this.a.a, null, ((SuccessResult) ((LoadingState.Loaded) loadingState2).getData()).getMessage(), false, null, 9);
            this.a.a.O.trackDeleteAdvertDraw();
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.a.O.trackDeleteAdvertLoadingError();
            this.a.a.O.startDeleteAdvertDraw();
            this.a.a.d(((LoadingState.Error) loadingState2).getError());
            this.a.a.O.trackDeleteAdvertDrawError();
        }
    }
}
