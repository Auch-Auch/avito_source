package a2.a.a.h3.a;

import com.avito.android.remote.model.CloseReasonsResponse;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractorImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Function;
public final class a<T, R> implements Function<CloseReasonsResponse, LoadingState<? super CloseReasonsResponse>> {
    public final /* synthetic */ MyAdvertDetailsInteractorImpl a;

    public a(MyAdvertDetailsInteractorImpl myAdvertDetailsInteractorImpl) {
        this.a = myAdvertDetailsInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public LoadingState<? super CloseReasonsResponse> apply(CloseReasonsResponse closeReasonsResponse) {
        CloseReasonsResponse closeReasonsResponse2 = closeReasonsResponse;
        this.a.b = closeReasonsResponse2;
        return new LoadingState.Loaded(closeReasonsResponse2);
    }
}
