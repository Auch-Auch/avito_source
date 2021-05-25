package a2.a.a.b2;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.model.Action;
import io.reactivex.functions.Consumer;
public final class e0<T> implements Consumer<CardItem.LfPackagesCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public e0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.LfPackagesCardItem lfPackagesCardItem) {
        DeepLink deepLink;
        UserProfilePresenter.Router router;
        Action action = lfPackagesCardItem.getAction();
        if (action != null && (deepLink = action.getDeepLink()) != null && (router = this.a.b) != null) {
            router.followDeepLink(deepLink);
        }
    }
}
