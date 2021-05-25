package a2.a.a.q3.f;

import androidx.lifecycle.Observer;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<DeepLink> {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public e(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        DeepLinkIntentFactory deepLinkIntentFactory = this.a.getDeepLinkIntentFactory();
        Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
        this.a.startActivity(deepLinkIntentFactory.getIntent(deepLink2));
    }
}
