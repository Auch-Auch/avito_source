package a2.a.a.j0;

import com.avito.android.deep_linking.DeepLinkingPresenterImpl;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import io.reactivex.functions.Consumer;
public final class g<T> implements Consumer<SavedLocationInteractor.AnalyticsInfoLocation> {
    public final /* synthetic */ DeepLinkingPresenterImpl a;
    public final /* synthetic */ String b;

    public g(DeepLinkingPresenterImpl deepLinkingPresenterImpl, String str) {
        this.a = deepLinkingPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SavedLocationInteractor.AnalyticsInfoLocation analyticsInfoLocation) {
        this.a.d.trackLocationStorageRequested(analyticsInfoLocation.getStorageInfo(), LocationSource.LOCATION_FROM_DEEPLINK, this.b);
    }
}
