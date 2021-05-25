package a2.a.a.e.k;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.remote.model.Session;
import com.avito.android.util.preferences.SessionContract;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements MaybeOnSubscribe<Account> {
    public final /* synthetic */ AccountManagerStorage a;
    public final /* synthetic */ Session b;
    public final /* synthetic */ String c;

    /* renamed from: a2.a.a.e.k.a$a  reason: collision with other inner class name */
    public static final class C0002a implements Cancellable {
        public final /* synthetic */ AccountManagerFuture a;

        public C0002a(AccountManagerFuture accountManagerFuture) {
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
        public final /* synthetic */ a a;
        public final /* synthetic */ MaybeEmitter b;

        public b(a aVar, MaybeEmitter maybeEmitter) {
            this.a = aVar;
            this.b = maybeEmitter;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.MaybeEmitter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.accounts.AccountManagerCallback
        public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            Account b2 = this.a.a.b();
            if (b2 != null) {
                this.b.onSuccess(b2);
            } else {
                this.b.onComplete();
            }
        }
    }

    public a(AccountManagerStorage accountManagerStorage, Session session, String str) {
        this.a = accountManagerStorage;
        this.b = session;
        this.c = str;
    }

    @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter<Account> maybeEmitter) {
        if (this.b == null) {
            maybeEmitter.onComplete();
        }
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", this.c);
        bundle.putString("accountType", this.a.f.getApplicationPackageId());
        maybeEmitter.setCancellable(new C0002a(this.a.e.addAccount(this.a.f.getApplicationPackageId(), SessionContract.SESSION, new String[0], bundle, null, new b(this, maybeEmitter), AccountManagerStorage.access$getHandler$p(this.a))));
    }
}
