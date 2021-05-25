package a2.a.a.k0.e.h0;

import com.avito.android.delivery.summary.change_contacts.DeliveryRdsEditContactsViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
public final class c<T> implements Consumer<LoadingState<? super Map<String, ? extends String>>> {
    public final /* synthetic */ DeliveryRdsEditContactsViewModelImpl a;

    public c(DeliveryRdsEditContactsViewModelImpl deliveryRdsEditContactsViewModelImpl) {
        this.a = deliveryRdsEditContactsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Map<String, ? extends String>> loadingState) {
        LoadingState<? super Map<String, ? extends String>> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            DeliveryRdsEditContactsViewModelImpl.access$onValidationResultLoaded(this.a, (Map) ((LoadingState.Loaded) loadingState2).getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            DeliveryRdsEditContactsViewModelImpl.access$showError(this.a, ((LoadingState.Error) loadingState2).getError());
        }
    }
}
