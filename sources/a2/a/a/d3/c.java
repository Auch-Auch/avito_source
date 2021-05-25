package a2.a.a.d3;

import com.avito.android.suggest_locations.SuggestLocationsPresenterImpl;
import com.avito.android.suggest_locations.SuggestLocationsResult;
import com.avito.android.suggest_locations.SuggestLocationsView;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<SuggestLocationsResult> {
    public final /* synthetic */ SuggestLocationsPresenterImpl a;

    public c(SuggestLocationsPresenterImpl suggestLocationsPresenterImpl) {
        this.a = suggestLocationsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SuggestLocationsResult suggestLocationsResult) {
        SuggestLocationsResult suggestLocationsResult2 = suggestLocationsResult;
        if (suggestLocationsResult2 instanceof SuggestLocationsResult.Ok) {
            SuggestLocationsResult.Ok ok = (SuggestLocationsResult.Ok) suggestLocationsResult2;
            this.a.f = ok.getFullMatchLocation();
            this.a.g = ok.getData();
            SuggestLocationsView suggestLocationsView = this.a.a;
            if (suggestLocationsView != null) {
                suggestLocationsView.updateLocations(ok.getData());
            }
        } else if (suggestLocationsResult2 instanceof SuggestLocationsResult.NetworkError) {
            SuggestLocationsView suggestLocationsView2 = this.a.a;
            if (suggestLocationsView2 != null) {
                suggestLocationsView2.showNetworkError();
            }
        } else if (suggestLocationsResult2 instanceof SuggestLocationsResult.Error) {
            SuggestLocationsView suggestLocationsView3 = this.a.a;
            if (suggestLocationsView3 != null) {
                suggestLocationsView3.showError();
            }
        } else {
            boolean z = suggestLocationsResult2 instanceof SuggestLocationsResult.SilentError;
        }
    }
}
