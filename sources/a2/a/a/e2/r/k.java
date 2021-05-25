package a2.a.a.e2.r;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.PublishDetailsPresenterImpl$deepLinkClickListener$1;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public k(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        PublishDetailsPresenterImpl$deepLinkClickListener$1 publishDetailsPresenterImpl$deepLinkClickListener$1 = this.a.n;
        Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
        publishDetailsPresenterImpl$deepLinkClickListener$1.onDeepLinkClick(deepLink2);
    }
}
