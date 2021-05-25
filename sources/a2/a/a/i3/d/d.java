package a2.a.a.i3.d;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenter;
import com.avito.android.user_adverts.tab_screens.UserAdvertsListPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<DeepLink> {
    public final /* synthetic */ UserAdvertsListPresenterImpl a;

    public d(UserAdvertsListPresenterImpl userAdvertsListPresenterImpl) {
        this.a = userAdvertsListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        UserAdvertsListPresenter.Router router = this.a.e;
        if (router != null) {
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            router.followDeepLink(deepLink2);
        }
    }
}
