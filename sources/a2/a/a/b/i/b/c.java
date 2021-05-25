package a2.a.a.b.i.b;

import com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsPresenterImpl;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<LoadingState<? super AuthResult>> {
    public final /* synthetic */ SocialRegistrationSuggestsPresenterImpl a;

    public c(SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl) {
        this.a = socialRegistrationSuggestsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super AuthResult> loadingState) {
        LoadingState<? super AuthResult> loadingState2 = loadingState;
        SocialRegistrationSuggestsPresenterImpl socialRegistrationSuggestsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "state");
        SocialRegistrationSuggestsPresenterImpl.access$handleState(socialRegistrationSuggestsPresenterImpl, loadingState2);
    }
}
