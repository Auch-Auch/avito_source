package a2.a.a.b2;

import com.avito.android.analytics.event.UserRatingDetailsOpenEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.UserRatingDetailsLink;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.model.ProfileRating;
import com.avito.android.remote.model.ProfileRatingAction;
import com.avito.android.remote.model.user_profile.UserProfileResult;
import io.reactivex.functions.Consumer;
import java.util.Map;
public final class c0<T> implements Consumer<CardItem.InfoCardItem> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public c0(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CardItem.InfoCardItem infoCardItem) {
        ProfileRatingAction action;
        DeepLink deepLink;
        UserProfileResult userProfileResult;
        Map<String, String> analytics;
        String str;
        ProfileRating rating = infoCardItem.getRating();
        if (rating != null && (action = rating.getAction()) != null && (deepLink = action.getDeepLink()) != null) {
            if (!(!(deepLink instanceof UserRatingDetailsLink) || (userProfileResult = this.a.e) == null || (analytics = userProfileResult.getAnalytics()) == null || (str = analytics.get("rating")) == null)) {
                this.a.M.track(new UserRatingDetailsOpenEvent(str));
            }
            UserProfilePresenter.Router router = this.a.b;
            if (router != null) {
                router.followDeepLink(deepLink);
            }
        }
    }
}
