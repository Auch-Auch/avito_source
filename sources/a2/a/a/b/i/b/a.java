package a2.a.a.b.i.b;

import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

    public a(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
        this.a = socialRegistrationSuggestsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        SocialRegistrationSuggestsView socialRegistrationSuggestsView = this.a.a;
        if (socialRegistrationSuggestsView != null) {
            socialRegistrationSuggestsView.showProgress();
        }
    }
}
