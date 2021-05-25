package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.bundles.ui.VasBundlesFragment;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: d3  reason: default package */
public final class d3<T> implements Observer<DeepLink> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public d3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(DeepLink deepLink) {
        int i = this.a;
        if (i == 0) {
            DeepLink deepLink2 = deepLink;
            PaidServicesRouter paidServicesRouter = ((VasBundlesFragment) this.b).c;
            if (paidServicesRouter != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "deeplink");
                paidServicesRouter.navigate(deepLink2);
            }
        } else if (i == 1) {
            DeepLink deepLink3 = deepLink;
            PaidServicesRouter paidServicesRouter2 = ((VasBundlesFragment) this.b).c;
            if (paidServicesRouter2 != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink3, "deeplink");
                paidServicesRouter2.navigate(deepLink3);
            }
        } else if (i == 2) {
            DeepLink deepLink4 = deepLink;
            if (deepLink4 instanceof NoMatchLink) {
                PaidServicesRouter paidServicesRouter3 = ((VasBundlesFragment) this.b).c;
                if (paidServicesRouter3 != null) {
                    PaidServicesRouter.DefaultImpls.finishFlow$default(paidServicesRouter3, null, 1, null);
                    return;
                }
                return;
            }
            PaidServicesRouter paidServicesRouter4 = ((VasBundlesFragment) this.b).c;
            if (paidServicesRouter4 != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink4, "deeplink");
                paidServicesRouter4.navigate(deepLink4);
            }
        } else {
            throw null;
        }
    }
}
