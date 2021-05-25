package a2.a.a.e.k;

import android.accounts.Account;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.remote.model.Session;
import io.reactivex.rxjava3.functions.Action;
public final class f implements Action {
    public final /* synthetic */ AccountManagerStorage a;
    public final /* synthetic */ Account b;
    public final /* synthetic */ Session c;

    public f(AccountManagerStorage accountManagerStorage, Account account, Session session) {
        this.a = accountManagerStorage;
        this.b = account;
        this.c = session;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.d(this.b, this.c);
    }
}
