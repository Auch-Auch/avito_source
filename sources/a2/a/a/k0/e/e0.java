package a2.a.a.k0.e;

import com.avito.android.delivery.summary.DeliveryRdsSummaryViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
public final class e0<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ DeliveryRdsSummaryViewModelImpl a;

    public e0(DeliveryRdsSummaryViewModelImpl deliveryRdsSummaryViewModelImpl) {
        this.a = deliveryRdsSummaryViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
        LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            DeliveryRdsSummaryViewModelImpl.access$showProgress(this.a);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryRdsSummaryViewModelImpl.access$onValidationResultLoaded(this.a, (Map) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.h(((LoadingState.Error) loadingState2).getError());
        }
    }
}
