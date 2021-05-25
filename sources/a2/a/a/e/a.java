package a2.a.a.e;

import com.avito.android.account.AccountInteractorImpl;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Action;
public final class a implements Action {
    public final /* synthetic */ AccountInteractorImpl.c a;
    public final /* synthetic */ LoadingState b;

    public a(AccountInteractorImpl.c cVar, LoadingState loadingState) {
        this.a = cVar;
        this.b = loadingState;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        AccountInteractorImpl.access$storeLoginSuggest(this.a.a, ((AuthResult) ((LoadingState.Loaded) this.b).getData()).getProfile().getUserHashId(), null, this.a.b, ((AuthResult) ((LoadingState.Loaded) this.b).getData()).getProfile().getSocialId());
    }
}
