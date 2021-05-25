package a2.a.a.e.k;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.util.preferences.ProfileContract;
import io.reactivex.rxjava3.functions.Action;
public final class d implements Action {
    public final /* synthetic */ AccountManagerStorage a;
    public final /* synthetic */ Account b;
    public final /* synthetic */ ProfileInfo c;

    public d(AccountManagerStorage accountManagerStorage, Account account, ProfileInfo profileInfo) {
        this.a = accountManagerStorage;
        this.b = account;
        this.c = profileInfo;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        AccountManager accountManager = this.a.e;
        Account account = this.b;
        ProfileContract profileContract = ProfileContract.INSTANCE;
        accountManager.setUserData(account, profileContract.getID(), this.c.getUserId());
        this.a.e.setUserData(this.b, profileContract.getNAME(), this.c.getName());
        this.a.e.setUserData(this.b, profileContract.getEMAIL(), this.c.getEmail());
        this.a.e.setUserData(this.b, profileContract.getIMAGE(), this.c.getImage());
    }
}
