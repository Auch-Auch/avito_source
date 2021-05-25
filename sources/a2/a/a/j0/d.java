package a2.a.a.j0;

import com.avito.android.deep_linking.AppLinkPresenterImpl;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<SavedLocationInteractor.AnalyticsInfoLocation> {
    public final /* synthetic */ AppLinkPresenterImpl a;
    public final /* synthetic */ String b;

    public d(AppLinkPresenterImpl appLinkPresenterImpl, String str) {
        this.a = appLinkPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SavedLocationInteractor.AnalyticsInfoLocation analyticsInfoLocation) {
        this.a.k.trackLocationStorageRequested(analyticsInfoLocation.getStorageInfo(), LocationSource.LOCATION_FROM_EXTERNAL_LINK, this.b);
    }
}
