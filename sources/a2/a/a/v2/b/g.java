package a2.a.a.v2.b;

import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.hotels.HotelsSearchResult;
import com.avito.android.short_term_rent.hotels.HotelsView;
import com.avito.android.short_term_rent.hotels.HotelsViewModel;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<TypedResult<HotelsSearchResult>> {
    public final /* synthetic */ HotelsViewModel a;

    public g(HotelsViewModel hotelsViewModel) {
        this.a = hotelsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(TypedResult<HotelsSearchResult> typedResult) {
        HotelsView hotelsView;
        TypedResult<HotelsSearchResult> typedResult2 = typedResult;
        if (typedResult2 instanceof TypedResult.OfResult) {
            this.a.g.postValue(new HotelsViewModel.RoutingAction.OpenDeepLink(((HotelsSearchResult) ((TypedResult.OfResult) typedResult2).getResult()).getDeeplink()));
        } else if ((typedResult2 instanceof TypedResult.OfError) && (hotelsView = this.a.c) != null) {
            hotelsView.showErrorInSnackBar(((TypedResult.OfError) typedResult2).getError().getMessage());
        }
        HotelsView hotelsView2 = this.a.c;
        if (hotelsView2 != null) {
            hotelsView2.stopLoading();
        }
    }
}
