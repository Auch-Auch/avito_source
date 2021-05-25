package a2.a.a.b.i.b;

import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl;
import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView;
import com.avito.android.error_helper.ErrorHelper;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

    public d(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
        this.a = socialRegistrationSuggestsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        SocialRegistrationSuggestsView socialRegistrationSuggestsView = this.a.a;
        if (socialRegistrationSuggestsView != null) {
            ErrorHelper errorHelper = this.a.m;
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            socialRegistrationSuggestsView.showError(errorHelper.recycle(th2));
        }
    }
}
