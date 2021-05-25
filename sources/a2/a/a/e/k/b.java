package a2.a.a.e.k;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b<T> implements MaybeOnSubscribe<String> {
    public final /* synthetic */ AccountManagerStorage a;
    public final /* synthetic */ Account b;

    public static final class a implements Cancellable {
        public final /* synthetic */ AccountManagerFuture a;

        public a(AccountManagerFuture accountManagerFuture) {
            this.a = accountManagerFuture;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            AccountManagerFuture accountManagerFuture = this.a;
            Intrinsics.checkNotNullExpressionValue(accountManagerFuture, "future");
            if (!accountManagerFuture.isCancelled()) {
                this.a.cancel(true);
            }
        }
    }

    /* renamed from: a2.a.a.e.k.b$b  reason: collision with other inner class name */
    public static final class C0003b extends Lambda implements Function1<AccountManagerFuture<Bundle>, Unit> {
        public final /* synthetic */ MaybeEmitter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0003b(MaybeEmitter maybeEmitter) {
            super(1);
            this.a = maybeEmitter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AccountManagerFuture<Bundle> accountManagerFuture) {
            AccountManagerFuture<Bundle> accountManagerFuture2 = accountManagerFuture;
            Intrinsics.checkNotNullParameter(accountManagerFuture2, "future");
            Bundle result = accountManagerFuture2.getResult();
            String string = result != null ? result.getString("authtoken") : null;
            boolean z = false;
            if (string != null) {
                if (string.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                MaybeEmitter maybeEmitter = this.a;
                Intrinsics.checkNotNull(string);
                maybeEmitter.onSuccess(string);
            } else {
                this.a.onComplete();
            }
            return Unit.INSTANCE;
        }
    }

    public b(AccountManagerStorage accountManagerStorage, Account account) {
        this.a = accountManagerStorage;
        this.b = account;
    }

    @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter<String> maybeEmitter) {
        maybeEmitter.setCancellable(new a(this.a.e.getAuthToken(this.b, SessionContract.SESSION, (Bundle) null, false, (AccountManagerCallback<Bundle>) new i(new C0003b(maybeEmitter)), AccountManagerStorage.access$getHandler$p(this.a))));
    }
}
