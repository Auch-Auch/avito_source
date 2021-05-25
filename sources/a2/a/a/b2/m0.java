package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import io.reactivex.functions.Consumer;
public final class m0<T> implements Consumer<CardItem.ReviewsCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public m0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.ReviewsCardItem reviewsCardItem) {
        CardItem.ReviewsCardItem reviewsCardItem2 = reviewsCardItem;
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(reviewsCardItem2.getAction().getDeepLink());
        }
    }
}
