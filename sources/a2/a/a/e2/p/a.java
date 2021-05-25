package a2.a.a.e2.p;

import com.avito.android.publish.cpa_tariff.CpaTariffViewModel;
import com.avito.android.remote.model.TypedResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<TypedResult<Object>> {
    public final /* synthetic */ CpaTariffViewModel a;

    public a(CpaTariffViewModel cpaTariffViewModel) {
        this.a = cpaTariffViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<Object> typedResult) {
        TypedResult<Object> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            this.a.g.setValue(CpaTariffViewModel.RoutingAction.BackWithToast.INSTANCE);
            this.a.j.trackCpaRequestSuccess();
        } else if (typedResult2 instanceof TypedResult.OfError) {
            this.a.f.setValue(new CpaTariffViewModel.ScreenEvents.CreateTariffRequestError(((TypedResult.OfError) typedResult2).getError().getMessage()));
        }
    }
}
