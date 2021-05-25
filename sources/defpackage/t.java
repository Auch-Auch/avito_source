package defpackage;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.paid_services.routing.PaidServicesRouter;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: t  reason: default package */
public final class t<T> implements Observer<DeepLink> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public t(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(DeepLink deepLink) {
        int i = this.a;
        if (i == 0) {
            DeepLink deepLink2 = deepLink;
            DeepLinkIntentFactory deepLinkIntentFactory = ((PerformanceVasFragment) this.b).getDeepLinkIntentFactory();
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            ((PerformanceVasFragment) this.b).startActivity(deepLinkIntentFactory.getIntent(deepLink2));
        } else if (i == 1) {
            DeepLink deepLink3 = deepLink;
            PaidServicesRouter access$getRouter$p = PerformanceVasFragment.access$getRouter$p((PerformanceVasFragment) this.b);
            Intrinsics.checkNotNullExpressionValue(deepLink3, "it");
            access$getRouter$p.navigate(deepLink3);
        } else {
            throw null;
        }
    }
}
