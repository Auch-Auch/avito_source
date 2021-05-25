package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.bundles.vas_union.VasUnionFragment;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: w1  reason: default package */
public final class w1<T> implements Observer<DeepLink> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public w1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(DeepLink deepLink) {
        int i = this.a;
        if (i == 0) {
            DeepLink deepLink2 = deepLink;
            PaidServicesRouter paidServicesRouter = ((VasUnionFragment) this.b).d;
            if (paidServicesRouter != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "deeplink");
                paidServicesRouter.navigate(deepLink2);
            }
        } else if (i == 1) {
            DeepLink deepLink3 = deepLink;
            DeepLinkIntentFactory deepLinkIntentFactory$vas_bundles_release = ((VasUnionFragment) this.b).getDeepLinkIntentFactory$vas_bundles_release();
            Intrinsics.checkNotNullExpressionValue(deepLink3, "deeplink");
            ((VasUnionFragment) this.b).startActivity(deepLinkIntentFactory$vas_bundles_release.getIntent(deepLink3));
        } else if (i == 2) {
            DeepLink deepLink4 = deepLink;
            if (deepLink4 instanceof NoMatchLink) {
                PaidServicesRouter paidServicesRouter2 = ((VasUnionFragment) this.b).d;
                if (paidServicesRouter2 != null) {
                    PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter2, null, 1, null);
                    return;
                }
                return;
            }
            PaidServicesRouter paidServicesRouter3 = ((VasUnionFragment) this.b).d;
            if (paidServicesRouter3 != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink4, "deeplink");
                paidServicesRouter3.navigate(deepLink4);
            }
        } else {
            throw null;
        }
    }
}
