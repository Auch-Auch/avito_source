package a2.a.a.f2.a.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryFragment;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PublishAdvertsHistoryFragment a;
    public final /* synthetic */ String b;

    public a(PublishAdvertsHistoryFragment publishAdvertsHistoryFragment, String str) {
        this.a = publishAdvertsHistoryFragment;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        this.a.getExtraInfoClickedListener().onExtraLinkClicked(this.b);
        PublishAdvertsHistoryFragment publishAdvertsHistoryFragment = this.a;
        Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
        PublishAdvertsHistoryFragment.access$openDeeplink(publishAdvertsHistoryFragment, deepLink2);
    }
}
