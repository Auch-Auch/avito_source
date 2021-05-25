package a2.a.a.e.k;

import com.avito.android.account.account_manager.AccountManagerStorage;
import io.reactivex.rxjava3.functions.Action;
import org.funktionale.option.OptionKt;
public final class g implements Action {
    public final /* synthetic */ AccountManagerStorage a;

    public g(AccountManagerStorage accountManagerStorage) {
        this.a = accountManagerStorage;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.getSessionChanges().accept(OptionKt.toOption(this.a.b()));
    }
}
