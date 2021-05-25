package a2.a.a.g2.b.k;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.publish.deal_stage.DealStagePresenter;
import com.avito.android.rating.publish.deal_stage.DealStagePresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<DeepLink> {
    public final /* synthetic */ DealStagePresenterImpl a;

    public c(DealStagePresenterImpl dealStagePresenterImpl) {
        this.a = dealStagePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        DealStagePresenter.Router router = this.a.b;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
