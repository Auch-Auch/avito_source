package a2.l.a.v.a;

import androidx.annotation.NonNull;
import com.my.target.nativeads.factories.NativeViewsFactory;
import com.my.target.nativeads.views.NativeAdView;
import com.my.target.nativeads.views.PromoCardRecyclerView;
import com.my.target.nativeads.views.PromoCardView;
public class a extends PromoCardRecyclerView.PromoCardAdapter {
    public final /* synthetic */ NativeAdView e;

    public a(NativeAdView nativeAdView) {
        this.e = nativeAdView;
    }

    @Override // com.my.target.nativeads.views.PromoCardRecyclerView.PromoCardAdapter
    @NonNull
    public PromoCardView getPromoCardView() {
        return NativeViewsFactory.getNativeAdCardView(this.e.getContext());
    }
}
