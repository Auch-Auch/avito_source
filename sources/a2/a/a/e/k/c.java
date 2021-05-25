package a2.a.a.e.k;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Build;
import android.os.Bundle;
import com.avito.android.account.account_manager.AccountManagerStorage;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
public final class c implements CompletableOnSubscribe {
    public final /* synthetic */ AccountManagerStorage a;
    public final /* synthetic */ AccountManager b;
    public final /* synthetic */ Account c;

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

    public static final class b<V> implements AccountManagerCallback<Bundle> {
        public final /* synthetic */ CompletableEmitter a;

        public b(CompletableEmitter completableEmitter) {
            this.a = completableEmitter;
        }

        @Override // android.accounts.AccountManagerCallback
        public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            this.a.onComplete();
        }
    }

    /* renamed from: a2.a.a.e.k.c$c  reason: collision with other inner class name */
    public static final class C0004c<V> implements AccountManagerCallback<Boolean> {
        public final /* synthetic */ CompletableEmitter a;

        public C0004c(CompletableEmitter completableEmitter) {
            this.a = completableEmitter;
        }

        @Override // android.accounts.AccountManagerCallback
        public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
            this.a.onComplete();
        }
    }

    public c(AccountManagerStorage accountManagerStorage, AccountManager accountManager, Account account) {
        this.a = accountManagerStorage;
        this.b = accountManager;
        this.c = account;
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public final void subscribe(CompletableEmitter completableEmitter) {
        AccountManagerFuture accountManagerFuture;
        Account account = this.c;
        if (account == null) {
            completableEmitter.onComplete();
            return;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            accountManagerFuture = this.b.removeAccount(account, null, new b(completableEmitter), AccountManagerStorage.access$getHandler$p(this.a));
        } else {
            accountManagerFuture = this.b.removeAccount(account, new C0004c(completableEmitter), AccountManagerStorage.access$getHandler$p(this.a));
        }
        completableEmitter.setCancellable(new a(accountManagerFuture));
    }
}
