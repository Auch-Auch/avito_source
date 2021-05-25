package defpackage;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.Observer;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.advert.item.AdvertDetailsRouter;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartner;
import com.avito.android.util.Uris;
import com.facebook.share.internal.ShareConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: d  reason: default package */
public final class d<T> implements Observer<Uri> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public d(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Uri uri) {
        int i = this.a;
        if (i == 0) {
            Uri uri2 = uri;
            Context context = ((AdvertDetailsFragment) this.b).getContext();
            if (context != null && !Uris.isNullOrEmpty(uri2)) {
                AdvertDetailsFragment.access$openUri((AdvertDetailsFragment) this.b, context, uri2);
            }
        } else if (i == 1) {
            Uri uri3 = uri;
            if (uri3 != null) {
                AdvertDetailsFragment.access$getAdvertDetailsRouter$p((AdvertDetailsFragment) this.b).showCreditPartnerScreen(CreditPartner.SRAVNI, uri3, ((AdvertDetailsFragment) this.b).getCreditBrokerAnalyticsInteractor().getSession());
            }
        } else if (i == 2) {
            Uri uri4 = uri;
            if (!Uris.isNullOrEmpty(uri4)) {
                AdvertDetailsRouter access$getAdvertDetailsRouter$p = AdvertDetailsFragment.access$getAdvertDetailsRouter$p((AdvertDetailsFragment) this.b);
                CreditPartner creditPartner = CreditPartner.TINKOFF;
                Intrinsics.checkNotNullExpressionValue(uri4, ShareConstants.MEDIA_URI);
                access$getAdvertDetailsRouter$p.showCreditPartnerScreen(creditPartner, uri4, ((AdvertDetailsFragment) this.b).getCreditBrokerAnalyticsInteractor().getSession());
            }
        } else {
            throw null;
        }
    }
}
