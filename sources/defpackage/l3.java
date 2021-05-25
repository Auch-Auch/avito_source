package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivity;
/* compiled from: java-style lambda group */
/* renamed from: l3  reason: default package */
public final class l3<T> implements Observer<DeepLink> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public l3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(DeepLink deepLink) {
        int i = this.a;
        if (i == 0) {
            DeepLink deepLink2 = deepLink;
            if (deepLink2 != null) {
                ((MyAdvertDetailsActivity) this.b).showSellerCalendar(deepLink2);
            }
        } else if (i == 1) {
            DeepLink deepLink3 = deepLink;
            if (deepLink3 != null) {
                ((MyAdvertDetailsActivity) this.b).openDeepLink(deepLink3);
            }
        } else {
            throw null;
        }
    }
}
