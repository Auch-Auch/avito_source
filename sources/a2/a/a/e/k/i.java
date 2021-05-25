package a2.a.a.e.k;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
public final class i implements AccountManagerCallback {
    public final /* synthetic */ Function1 a;

    public i(Function1 function1) {
        this.a = function1;
    }

    @Override // android.accounts.AccountManagerCallback
    public final /* synthetic */ void run(AccountManagerFuture accountManagerFuture) {
        Intrinsics.checkNotNullExpressionValue(this.a.invoke(accountManagerFuture), "invoke(...)");
    }
}
