package a2.a.a.e.k;

import android.accounts.Account;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.remote.model.Session;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<String, Session> {
    public final /* synthetic */ AccountManagerStorage.g a;
    public final /* synthetic */ Account b;

    public h(AccountManagerStorage.g gVar, Account account) {
        this.a = gVar;
        this.b = account;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Session apply(String str) {
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        return new Session(str2, AccountManagerStorage.access$getRefreshToken(this.a.a, this.b), AccountManagerStorage.access$getPushToken(this.a.a, this.b));
    }
}
