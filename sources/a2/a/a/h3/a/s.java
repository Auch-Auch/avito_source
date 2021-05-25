package a2.a.a.h3.a;

import com.avito.android.remote.model.CloseReasonsResponse;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import com.avito.android.user_advert.soa_with_price.events.ItemClosePopupOpenEvent;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
import org.reactivestreams.Publisher;
public final class s<T, R> implements Function<LoadingState<? super CloseReasonsResponse>, Publisher<? extends Unit>> {
    public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
    public final /* synthetic */ String b;

    public s(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
        this.a = myAdvertDetailsPresenterImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Publisher<? extends Unit> apply(LoadingState<? super CloseReasonsResponse> loadingState) {
        LoadingState<? super CloseReasonsResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            MyAdvertDetailsPresenterImpl.access$hideProgressForSecondaryContent(this.a);
            this.a.C.track(new ItemClosePopupOpenEvent(this.b));
            MyAdvertRouter myAdvertRouter = this.a.a;
            if (myAdvertRouter != null) {
                myAdvertRouter.openSoaWithPriceBottomSheet(this.b, ((CloseReasonsResponse) ((LoadingState.Loaded) loadingState2).getData()).getCloseReasons());
            }
            return Flowable.empty();
        } else if (!(loadingState2 instanceof LoadingState.Error)) {
            return Flowable.empty();
        } else {
            MyAdvertDetailsPresenterImpl.access$hideProgressForSecondaryContent(this.a);
            this.a.O.trackDeactivateAdvertLoadingError();
            return Flowable.fromCallable(new r(this, loadingState2));
        }
    }
}
