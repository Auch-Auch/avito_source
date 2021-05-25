package com.avito.android.account.account_manager;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.os.Handler;
import android.os.HandlerThread;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.BlockingAccountStorageInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileInfo;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.LoopersKt;
import com.avito.android.util.preferences.ProfileContract;
import com.avito.android.util.preferences.SessionContract;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002IJB\u0017\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010?\u001a\u00020<¢\u0006\u0004\bG\u0010HJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J#\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\t2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u001d\u0010/\u001a\u00020+8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R%\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003008\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103R%\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003008\u0006@\u0006¢\u0006\f\n\u0004\b\n\u00101\u001a\u0004\b5\u00103R\u001d\u0010;\u001a\u000607R\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\f\u00108\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u001a8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006K"}, d2 = {"Lcom/avito/android/account/account_manager/AccountManagerStorage;", "Lcom/avito/android/account/AccountStorageInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lorg/funktionale/option/Option;", "Landroid/accounts/Account;", AuthSource.SEND_ABUSE, "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Session;", SessionContract.SESSION, "", "d", "(Landroid/accounts/Account;Lcom/avito/android/remote/model/Session;)V", AuthSource.BOOKING_ORDER, "()Landroid/accounts/Account;", "Lcom/avito/android/remote/model/ProfileInfo;", "c", "(Landroid/accounts/Account;)Lcom/avito/android/remote/model/ProfileInfo;", "getProfileInfo", "()Lcom/avito/android/remote/model/ProfileInfo;", "getSession", "()Lcom/avito/android/remote/model/Session;", "", "isAuthorized", "()Z", "profileInfo", "authorized", "", ChannelContext.Item.USER_ID, "profile", "Lio/reactivex/rxjava3/core/Completable;", "save", "(Lcom/avito/android/remote/model/ProfileInfo;Lcom/avito/android/remote/model/Session;)Lio/reactivex/rxjava3/core/Completable;", "Lkotlin/Function0;", "retrieveSessionFunction", "saveSessionBlocking", "(Lkotlin/jvm/functions/Function0;)V", "clearAccount", "()Lio/reactivex/rxjava3/core/Completable;", "clearCache", "()V", "Lcom/avito/android/account/BlockingAccountStorageInteractor;", "toBlocking", "()Lcom/avito/android/account/BlockingAccountStorageInteractor;", "Landroid/os/Handler;", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "getProfileChanges", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "profileChanges", "getSessionChanges", "sessionChanges", "Lcom/avito/android/account/account_manager/AccountManagerStorage$BlockingAccountManagerStorage;", "Lcom/avito/android/account/account_manager/AccountManagerStorage$BlockingAccountManagerStorage;", "getBlocking", "()Lcom/avito/android/account/account_manager/AccountManagerStorage$BlockingAccountManagerStorage;", "blocking", "Lcom/avito/android/util/BuildInfo;", "f", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "getCurrentUserId", "()Ljava/lang/String;", "currentUserId", "Landroid/accounts/AccountManager;", "e", "Landroid/accounts/AccountManager;", "accountManager", "<init>", "(Landroid/accounts/AccountManager;Lcom/avito/android/util/BuildInfo;)V", "BlockingAccountManagerStorage", "Exception", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public final class AccountManagerStorage implements AccountStorageInteractor {
    public final Lazy a = t6.c.lazy(c.a);
    @NotNull
    public final BlockingAccountManagerStorage b = new BlockingAccountManagerStorage();
    @NotNull
    public final PublishRelay<Option<Account>> c;
    @NotNull
    public final PublishRelay<Option<Account>> d;
    public final AccountManager e;
    public final BuildInfo f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/account/account_manager/AccountManagerStorage$BlockingAccountManagerStorage;", "Lcom/avito/android/account/BlockingAccountStorageInteractor;", "Lcom/avito/android/remote/model/ProfileInfo;", "getProfile", "()Lcom/avito/android/remote/model/ProfileInfo;", "", "getUserId", "()Ljava/lang/String;", "getSession", "getPushToken", "getRefreshToken", "", "isAuthorized", "()Z", "<init>", "(Lcom/avito/android/account/account_manager/AccountManagerStorage;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public final class BlockingAccountManagerStorage implements BlockingAccountStorageInteractor {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public BlockingAccountManagerStorage() {
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        @Nullable
        public ProfileInfo getProfile() {
            ProfileInfo profileInfo = AccountManagerStorage.this.getProfileInfo();
            if (!Intrinsics.areEqual(profileInfo, ProfileInfo.Companion.getNULL())) {
                return profileInfo;
            }
            return null;
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        @Nullable
        public String getPushToken() {
            Account b = AccountManagerStorage.this.b();
            if (b != null) {
                return AccountManagerStorage.access$getPushToken(AccountManagerStorage.this, b);
            }
            return null;
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        @Nullable
        public String getRefreshToken() {
            Account b = AccountManagerStorage.this.b();
            if (b != null) {
                return AccountManagerStorage.access$getRefreshToken(AccountManagerStorage.this, b);
            }
            return null;
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        @Nullable
        public String getSession() {
            if (LoopersKt.isMainThread()) {
                Account b = AccountManagerStorage.this.b();
                if (b != null) {
                    return AccountManagerStorage.this.e.peekAuthToken(b, SessionContract.SESSION);
                }
                return null;
            }
            Account b2 = AccountManagerStorage.this.b();
            if (b2 != null) {
                return AccountManagerStorage.this.e.blockingGetAuthToken(b2, SessionContract.SESSION, false);
            }
            return null;
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        @Nullable
        public String getUserId() {
            return AccountManagerStorage.this.getCurrentUserId();
        }

        @Override // com.avito.android.account.BlockingAccountStorageInteractor
        public boolean isAuthorized() {
            return AccountManagerStorage.this.isAuthorized();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/account/account_manager/AccountManagerStorage$Exception;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "<init>", "(Ljava/lang/String;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
    public static final class Exception extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Exception(@NotNull String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "message");
        }
    }

    public static final class a<T> implements ObservableOnSubscribe<Option<? extends Account>> {
        public final /* synthetic */ AccountManagerStorage a;

        /* renamed from: com.avito.android.account.account_manager.AccountManagerStorage$a$a  reason: collision with other inner class name */
        public static final class C0128a implements Cancellable {
            public final /* synthetic */ a a;
            public final /* synthetic */ OnAccountsUpdateListener b;

            public C0128a(a aVar, OnAccountsUpdateListener onAccountsUpdateListener) {
                this.a = aVar;
                this.b = onAccountsUpdateListener;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.e.removeOnAccountsUpdatedListener(this.b);
            }
        }

        public static final class b implements OnAccountsUpdateListener {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            public b(a aVar, ObservableEmitter observableEmitter) {
                this.a = aVar;
                this.b = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.accounts.OnAccountsUpdateListener
            public final void onAccountsUpdated(Account[] accountArr) {
                this.b.onNext(OptionKt.toOption(this.a.a.b()));
            }
        }

        public a(AccountManagerStorage accountManagerStorage) {
            this.a = accountManagerStorage;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [io.reactivex.rxjava3.core.ObservableEmitter<org.funktionale.option.Option<android.accounts.Account>>] */
        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Option<? extends Account>> observableEmitter) {
            b bVar = new b(this, observableEmitter);
            this.a.e.addOnAccountsUpdatedListener(bVar, AccountManagerStorage.access$getHandler$p(this.a), false);
            observableEmitter.setCancellable(new C0128a(this, bVar));
        }
    }

    public static final class b<T, R> implements Function<Option<? extends Account>, Boolean> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Boolean apply(Option<? extends Account> option) {
            return Boolean.valueOf(option.orNull() != null);
        }
    }

    public static final class c extends Lambda implements Function0<Handler> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("AccountManager");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    }

    public static final class d<T, R> implements Function<Option<? extends Account>, ProfileInfo> {
        public final /* synthetic */ AccountManagerStorage a;

        public d(AccountManagerStorage accountManagerStorage) {
            this.a = accountManagerStorage;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ProfileInfo apply(Option<? extends Account> option) {
            ProfileInfo c;
            Account account = (Account) option.orNull();
            return (account == null || (c = this.a.c(account)) == null) ? ProfileInfo.Companion.getNULL() : c;
        }
    }

    public static final class e<T> implements MaybeOnSubscribe<Account> {
        public final /* synthetic */ AccountManagerStorage a;

        public e(AccountManagerStorage accountManagerStorage) {
            this.a = accountManagerStorage;
        }

        @Override // io.reactivex.rxjava3.core.MaybeOnSubscribe
        public final void subscribe(MaybeEmitter<Account> maybeEmitter) {
            Account b = this.a.b();
            if (b == null) {
                maybeEmitter.onComplete();
            } else {
                maybeEmitter.onSuccess(b);
            }
        }
    }

    public static final class f<T, R> implements Function<Account, CompletableSource> {
        public final /* synthetic */ AccountManagerStorage a;
        public final /* synthetic */ ProfileInfo b;
        public final /* synthetic */ Session c;

        public f(AccountManagerStorage accountManagerStorage, ProfileInfo profileInfo, Session session) {
            this.a = accountManagerStorage;
            this.b = profileInfo;
            this.c = session;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(Account account) {
            Account account2 = account;
            AccountManagerStorage accountManagerStorage = this.a;
            Intrinsics.checkNotNullExpressionValue(account2, BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
            return Completable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Completable[]{AccountManagerStorage.access$save(accountManagerStorage, account2, this.b), AccountManagerStorage.access$save(this.a, account2, this.c)}));
        }
    }

    public static final class g<T, R> implements Function<Option<? extends Account>, ObservableSource<? extends Session>> {
        public final /* synthetic */ AccountManagerStorage a;

        public g(AccountManagerStorage accountManagerStorage) {
            this.a = accountManagerStorage;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Session> apply(Option<? extends Account> option) {
            Account account = (Account) option.orNull();
            if (account != null) {
                return AccountManagerStorage.access$getSession(this.a, account).map(new a2.a.a.e.k.h(this, account)).toObservable();
            }
            Observable just = Observable.just(Session.Companion.getNULL());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class h<T, R> implements Function<Option<? extends Account>, String> {
        public final /* synthetic */ AccountManagerStorage a;

        public h(AccountManagerStorage accountManagerStorage) {
            this.a = accountManagerStorage;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Option<? extends Account> option) {
            Account account = (Account) option.orNull();
            String access$getUserId = account != null ? AccountManagerStorage.access$getUserId(this.a, account) : null;
            return access$getUserId != null ? access$getUserId : "";
        }
    }

    public AccountManagerStorage(@NotNull AccountManager accountManager, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(accountManager, "accountManager");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.e = accountManager;
        this.f = buildInfo;
        PublishRelay<Option<Account>> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
        PublishRelay<Option<Account>> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.d = create2;
    }

    public static final Handler access$getHandler$p(AccountManagerStorage accountManagerStorage) {
        return (Handler) accountManagerStorage.a.getValue();
    }

    public static final String access$getPushToken(AccountManagerStorage accountManagerStorage, Account account) {
        return accountManagerStorage.e.getUserData(account, SessionContract.PUSH_TOKEN);
    }

    public static final String access$getRefreshToken(AccountManagerStorage accountManagerStorage, Account account) {
        return accountManagerStorage.e.getPassword(account);
    }

    public static final Maybe access$getSession(AccountManagerStorage accountManagerStorage, Account account) {
        Objects.requireNonNull(accountManagerStorage);
        Maybe create = Maybe.create(new a2.a.a.e.k.b(accountManagerStorage, account));
        Intrinsics.checkNotNullExpressionValue(create, "Maybe.create { emitter -…}\n            }\n        }");
        return create;
    }

    public static final String access$getUserId(AccountManagerStorage accountManagerStorage, Account account) {
        return accountManagerStorage.e.getUserData(account, ProfileContract.INSTANCE.getID());
    }

    public static final Completable access$save(AccountManagerStorage accountManagerStorage, Account account, ProfileInfo profileInfo) {
        Objects.requireNonNull(accountManagerStorage);
        if (profileInfo != null) {
            Completable doOnComplete = Completable.fromAction(new a2.a.a.e.k.d(accountManagerStorage, account, profileInfo)).doOnComplete(new a2.a.a.e.k.e(accountManagerStorage));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "Completable.fromAction {…etAccount().toOption()) }");
            return doOnComplete;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }

    public final Observable<Option<Account>> a() {
        Observable<Option<Account>> startWithItem = Observable.create(new a(this)).startWithItem(OptionKt.toOption(b()));
        Intrinsics.checkNotNullExpressionValue(startWithItem, "Observable.create<Option…(getAccount().toOption())");
        return startWithItem;
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Observable<Boolean> authorized() {
        Observable<R> distinctUntilChanged = a().map(b.a).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "accountChanges()\n       …  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    public final Account b() {
        Account[] accountsByType = this.e.getAccountsByType(this.f.getApplicationPackageId());
        if (accountsByType != null) {
            return (Account) ArraysKt___ArraysKt.firstOrNull(accountsByType);
        }
        return null;
    }

    public final ProfileInfo c(Account account) {
        AccountManager accountManager = this.e;
        ProfileContract profileContract = ProfileContract.INSTANCE;
        return new ProfileInfo(accountManager.getUserData(account, profileContract.getID()), this.e.getUserData(account, profileContract.getNAME()), this.e.getUserData(account, profileContract.getEMAIL()), this.e.getUserData(account, profileContract.getIMAGE()));
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Completable clearAccount() {
        Completable create = Completable.create(new a2.a.a.e.k.c(this, this.e, b()));
        Intrinsics.checkNotNullExpressionValue(create, "Completable.create { emi…}\n            }\n        }");
        return create;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    public void clearCache() {
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Single<Boolean> currentAuthorized() {
        return AccountStorageInteractor.DefaultImpls.currentAuthorized(this);
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Maybe<ProfileInfo> currentProfileInfo() {
        return AccountStorageInteractor.DefaultImpls.currentProfileInfo(this);
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Maybe<Session> currentSession() {
        return AccountStorageInteractor.DefaultImpls.currentSession(this);
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Maybe<String> currentUserId() {
        return AccountStorageInteractor.DefaultImpls.currentUserId(this);
    }

    public final void d(Account account, Session session) {
        this.e.setUserData(account, SessionContract.PUSH_TOKEN, session.getPushToken());
        this.e.setPassword(account, session.getRefreshToken());
        this.e.setAuthToken(account, SessionContract.SESSION, session.getSession());
    }

    @NotNull
    public final BlockingAccountManagerStorage getBlocking() {
        return this.b;
    }

    @Override // com.avito.android.account.AccountStateProvider
    @Nullable
    public String getCurrentUserId() {
        Account b2 = b();
        if (b2 != null) {
            return this.e.getUserData(b2, ProfileContract.INSTANCE.getID());
        }
        return null;
    }

    @NotNull
    public final PublishRelay<Option<Account>> getProfileChanges() {
        return this.c;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public ProfileInfo getProfileInfo() {
        Account b2 = b();
        return b2 != null ? c(b2) : ProfileInfo.Companion.getNULL();
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @Nullable
    public Session getSession() {
        String session;
        if (b() == null || (session = this.b.getSession()) == null) {
            return null;
        }
        return new Session(session, this.b.getRefreshToken(), this.b.getPushToken());
    }

    @NotNull
    public final PublishRelay<Option<Account>> getSessionChanges() {
        return this.d;
    }

    @Override // com.avito.android.account.AccountStateProvider
    public boolean isAuthorized() {
        return b() != null;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Observable<ProfileInfo> profileInfo() {
        Observable<R> distinctUntilChanged = a().mergeWith(this.c).map(new d(this)).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "accountChanges()\n       …  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r4 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r2 != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r1 = r4;
     */
    @Override // com.avito.android.account.AccountStorageInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Completable save(@org.jetbrains.annotations.Nullable com.avito.android.remote.model.ProfileInfo r7, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.Session r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x000e
            if (r8 != 0) goto L_0x000e
            io.reactivex.rxjava3.core.Completable r7 = io.reactivex.rxjava3.core.Completable.complete()
            java.lang.String r8 = "Completable.complete()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        L_0x000e:
            com.avito.android.account.account_manager.AccountManagerStorage$e r0 = new com.avito.android.account.account_manager.AccountManagerStorage$e
            r0.<init>(r6)
            io.reactivex.rxjava3.core.Maybe r0 = io.reactivex.rxjava3.core.Maybe.create(r0)
            r1 = 0
            r2 = 1
            r3 = 0
            if (r7 == 0) goto L_0x0032
            java.lang.String r4 = r7.getEmail()
            if (r4 == 0) goto L_0x0032
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x002a
            r5 = 1
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            if (r5 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r4 = r1
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            if (r7 == 0) goto L_0x0045
            java.lang.String r4 = r7.getName()
            if (r4 == 0) goto L_0x0045
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            if (r2 == 0) goto L_0x0045
        L_0x0044:
            r1 = r4
        L_0x0045:
            if (r1 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            java.lang.String r1 = "Avito"
        L_0x004a:
            a2.a.a.e.k.a r2 = new a2.a.a.e.k.a
            r2.<init>(r6, r8, r1)
            io.reactivex.rxjava3.core.Maybe r1 = io.reactivex.rxjava3.core.Maybe.create(r2)
            java.lang.String r2 = "Maybe.create { emitter -…        }\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxjava3.core.Maybe r0 = r0.switchIfEmpty(r1)
            com.avito.android.account.account_manager.AccountManagerStorage$f r1 = new com.avito.android.account.account_manager.AccountManagerStorage$f
            r1.<init>(r6, r7, r8)
            io.reactivex.rxjava3.core.Completable r7 = r0.flatMapCompletable(r1)
            java.lang.String r8 = "Maybe.create<Account> { …          )\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.account.account_manager.AccountManagerStorage.save(com.avito.android.remote.model.ProfileInfo, com.avito.android.remote.model.Session):io.reactivex.rxjava3.core.Completable");
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    public void saveSessionBlocking(@NotNull Function0<Session> function0) {
        Intrinsics.checkNotNullParameter(function0, "retrieveSessionFunction");
        Account b2 = b();
        Session invoke = function0.invoke();
        if (invoke != null && b2 != null) {
            d(b2, invoke);
        }
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public Observable<Session> session() {
        Observable<R> distinctUntilChanged = a().mergeWith(this.d).flatMap(new g(this)).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "accountChanges()\n       …  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    @Override // com.avito.android.account.AccountStorageInteractor
    @NotNull
    public BlockingAccountStorageInteractor toBlocking() {
        return this.b;
    }

    @Override // com.avito.android.account.AccountStateProvider
    @NotNull
    public Observable<String> userId() {
        Observable<R> distinctUntilChanged = a().map(new h(this)).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "accountChanges()\n       …  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    public static final Completable access$save(AccountManagerStorage accountManagerStorage, Account account, Session session) {
        Objects.requireNonNull(accountManagerStorage);
        if (session != null) {
            Completable doOnComplete = Completable.fromAction(new a2.a.a.e.k.f(accountManagerStorage, account, session)).doOnComplete(new a2.a.a.e.k.g(accountManagerStorage));
            Intrinsics.checkNotNullExpressionValue(doOnComplete, "Completable.fromAction {…etAccount().toOption()) }");
            return doOnComplete;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }
}
