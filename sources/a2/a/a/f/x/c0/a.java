package a2.a.a.f.x.c0;

import com.avito.android.advert.item.spare_parts.SparePartsPresenterImpl;
import com.avito.android.advert.item.spare_parts.SparePartsView;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<LoadingState<? super SparePartsResponse>> {
    public final /* synthetic */ SparePartsPresenterImpl a;

    public a(SparePartsPresenterImpl sparePartsPresenterImpl) {
        this.a = sparePartsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super SparePartsResponse> loadingState) {
        LoadingState<? super SparePartsResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            SparePartsView sparePartsView = this.a.a;
            if (sparePartsView != null) {
                sparePartsView.showLoading();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
            this.a.d = (SparePartsResponse) loaded.getData();
            this.a.a((SparePartsResponse) loaded.getData());
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.e = true;
            SparePartsView sparePartsView2 = this.a.a;
            if (sparePartsView2 != null) {
                sparePartsView2.hide();
            }
        }
    }
}
