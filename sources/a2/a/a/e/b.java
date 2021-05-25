package a2.a.a.e;

import com.avito.android.account.AccountInteractorImpl;
import com.avito.android.remote.model.SocialAuthResult;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ AccountInteractorImpl.f a;
    public final /* synthetic */ SocialAuthResult b;

    public b(AccountInteractorImpl.f fVar, SocialAuthResult socialAuthResult) {
        this.a = fVar;
        this.b = socialAuthResult;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        AccountInteractorImpl.access$storeLoginSuggest(this.a.a, ((SocialAuthResult.Ok) this.b).getAuthResult().getProfile().getUserHashId(), null, this.a.b.getSocialNetworkType(), ((SocialAuthResult.Ok) this.b).getAuthResult().getProfile().getSocialId());
    }
}
