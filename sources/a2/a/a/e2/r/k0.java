package a2.a.a.e2.r;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class k0<T> implements Consumer<DeepLink> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public k0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        PublishDetailsPresenter.Router router = this.a.g;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "deepLink");
            router.openDeepLink(deepLink2);
        }
    }
}
