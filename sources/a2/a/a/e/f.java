package a2.a.a.e;

import com.avito.android.account.AccountInteractorImpl;
import com.avito.android.remote.model.LinkedSocial;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.Profile;
import io.reactivex.rxjava3.functions.Action;
public final class f implements Action {
    public final /* synthetic */ AccountInteractorImpl.l a;
    public final /* synthetic */ LoginResult b;

    public f(AccountInteractorImpl.l lVar, LoginResult loginResult) {
        this.a = lVar;
        this.b = loginResult;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        Profile profile = ((LoginResult.Ok) this.b).getAuthResult().getProfile();
        AccountInteractorImpl accountInteractorImpl = this.a.a;
        String userHashId = profile.getUserHashId();
        String str = null;
        String str2 = profile.getLinkedSocial() == null ? this.a.b : null;
        LinkedSocial linkedSocial = profile.getLinkedSocial();
        String type = linkedSocial != null ? linkedSocial.getType() : null;
        LinkedSocial linkedSocial2 = profile.getLinkedSocial();
        if (linkedSocial2 != null) {
            str = linkedSocial2.getSocialUserId();
        }
        AccountInteractorImpl.access$storeLoginSuggest(accountInteractorImpl, userHashId, str2, type, str);
    }
}
