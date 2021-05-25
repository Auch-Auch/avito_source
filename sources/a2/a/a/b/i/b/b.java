package a2.a.a.b.i.b;

import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

    public b(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
        this.a = socialRegistrationSuggestsPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        SocialRegistrationSuggestsView socialRegistrationSuggestsView = this.a.a;
        if (socialRegistrationSuggestsView != null) {
            socialRegistrationSuggestsView.hideProgress();
        }
    }
}
