package a2.a.a.b2;

import com.avito.android.analytics.event.PasswordChangeClickEvent;
import com.avito.android.analytics.event.PasswordSettingClickEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.deep_linking.links.PasswordSettingLink;
import com.avito.android.deep_linking.links.SessionsListLink;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class s<T> implements Consumer<DeepLink> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public s(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        if (deepLink2 instanceof PasswordChangeLink) {
            this.a.M.track(new PasswordChangeClickEvent());
            UserProfilePresenter.Router router = this.a.b;
            if (router != null) {
                router.openPasswordActionDeeplink(deepLink2);
            }
        } else if (deepLink2 instanceof PasswordSettingLink) {
            this.a.M.track(new PasswordSettingClickEvent());
            UserProfilePresenter.Router router2 = this.a.b;
            if (router2 != null) {
                router2.openPasswordActionDeeplink(deepLink2);
            }
        } else if (deepLink2 instanceof SessionsListLink) {
            UserProfilePresenter.Router router3 = this.a.b;
            if (router3 != null) {
                router3.openSessionsListScreen(((SessionsListLink) deepLink2).getSource());
            }
        } else {
            UserProfilePresenter.Router router4 = this.a.b;
            if (router4 != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "deeplink");
                router4.followDeepLink(deepLink2);
            }
        }
    }
}
