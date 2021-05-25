package a2.a.a.n2;

import com.avito.android.remote.model.CaseText;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.serp.Serp;
import com.avito.android.serp.SerpInlineFilters;
import com.avito.android.serp.SerpPage;
import com.avito.android.serp.SerpParams;
import com.avito.android.serp.SerpPresenterImpl;
import com.avito.android.serp.SerpPresenterView;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class u<T> implements Consumer<LoadingState<? super Serp>> {
    public final /* synthetic */ SerpPresenterImpl a;
    public final /* synthetic */ String b;

    public u(SerpPresenterImpl serpPresenterImpl, String str) {
        this.a = serpPresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super Serp> loadingState) {
        String locationId;
        SerpPresenterView serpPresenterView;
        LoadingState<? super Serp> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            if (this.a.j()) {
                if (!(this.a.t) && this.a.h.isEmpty()) {
                    SerpPresenterView serpPresenterView2 = this.a.a;
                    if (serpPresenterView2 != null) {
                        serpPresenterView2.showProgress();
                    }
                    SerpPresenterImpl.access$fillSkeleton(this.a);
                }
            } else if (!(this.a.t) && this.a.F.isEmpty() && (serpPresenterView = this.a.a) != null) {
                serpPresenterView.showProgress();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            Serp serp = (Serp) ((LoadingState.Loaded) loadingState2).getData();
            if (serp instanceof SerpPage) {
                SerpPresenterImpl serpPresenterImpl = this.a;
                SerpPresenterImpl.access$onSerpPageLoaded(serpPresenterImpl, (SerpPage) serp, serpPresenterImpl.k.getPage(), this.b);
            } else if (serp instanceof SerpParams) {
                this.a.j = ((SerpParams) serp).getSerpParameters();
                this.a.I();
                SerpPresenterView serpPresenterView3 = this.a.a;
                if (serpPresenterView3 != null) {
                    serpPresenterView3.setDisplayType(SerpDisplayTypeKt.orDefault(this.a.u));
                }
            } else if (serp instanceof SerpInlineFilters) {
                this.a.f0.setInlineFilters(((SerpInlineFilters) serp).getInlineFilters());
                this.a.y();
            }
            SearchParams h = this.a.h();
            if (h != null && (locationId = h.getLocationId()) != null) {
                SerpPresenterImpl.access$saveLocationForSearch(this.a, new Location(locationId, new CaseText(), false, false, false, false, null, false, null, null, 1020, null));
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            SerpPresenterImpl.access$onSerpPageResultFailedToLoad(this.a, ((LoadingState.Error) loadingState2).getError(), this.a.k.getPage());
        }
    }
}
