package a2.a.a.g.a;

import android.view.View;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import com.avito.android.deep_linking.links.DeepLink;
public final class a implements View.OnClickListener {
    public final /* synthetic */ AdvertDetailsFlatViewImpl a;
    public final /* synthetic */ DeepLink b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public a(AdvertDetailsFlatViewImpl advertDetailsFlatViewImpl, DeepLink deepLink, String str, String str2) {
        this.a = advertDetailsFlatViewImpl;
        this.b = deepLink;
        this.c = str;
        this.d = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AdvertDetailsFlatsListener advertDetailsFlatsListener = this.a.g;
        if (advertDetailsFlatsListener != null) {
            advertDetailsFlatsListener.onFlatsClick(this.d, this.c, this.b);
        }
    }
}
