package com.avito.android.account;

import com.avito.android.Features;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Session;
import com.avito.android.util.Logs;
import com.avito.android.util.preferences.Preferences;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/account/AccountStorageMigrationManager;", "", "", "migrate", "()V", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/account/account_manager/AccountManagerStorage;", "c", "Lcom/avito/android/account/account_manager/AccountManagerStorage;", "accountManagerStorage", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/account/AccountStorageInteractor;", "d", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/Features;Lcom/avito/android/account/account_manager/AccountManagerStorage;Lcom/avito/android/account/AccountStorageInteractor;)V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
public class AccountStorageMigrationManager {
    public final Preferences a;
    public final Features b;
    public final AccountManagerStorage c;
    public final AccountStorageInteractor d;

    public static final class a<T, R> implements Function<Session, CompletableSource> {
        public final /* synthetic */ AccountStorageMigrationManager a;

        public a(AccountStorageMigrationManager accountStorageMigrationManager) {
            this.a = accountStorageMigrationManager;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0042  */
        @Override // io.reactivex.rxjava3.functions.Function
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.reactivex.rxjava3.core.CompletableSource apply(com.avito.android.remote.model.Session r7) {
            /*
                r6 = this;
                com.avito.android.remote.model.Session r7 = (com.avito.android.remote.model.Session) r7
                com.avito.android.account.AccountStorageMigrationManager r0 = r6.a
                com.avito.android.account.AccountStorageInteractor r0 = com.avito.android.account.AccountStorageMigrationManager.access$getAccountStorageInteractor$p(r0)
                com.avito.android.account.AccountStorageMigrationManager r1 = r6.a
                com.avito.android.account.account_manager.AccountManagerStorage r1 = com.avito.android.account.AccountStorageMigrationManager.access$getAccountManagerStorage$p(r1)
                com.avito.android.remote.model.ProfileInfo r1 = r1.getProfileInfo()
                java.lang.String r2 = r1.getUserId()
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0027
                int r2 = r2.length()
                if (r2 <= 0) goto L_0x0022
                r2 = 1
                goto L_0x0023
            L_0x0022:
                r2 = 0
            L_0x0023:
                if (r2 == 0) goto L_0x0027
                r2 = 1
                goto L_0x0028
            L_0x0027:
                r2 = 0
            L_0x0028:
                r5 = 0
                if (r2 == 0) goto L_0x002c
                goto L_0x002d
            L_0x002c:
                r1 = r5
            L_0x002d:
                java.lang.String r2 = r7.getSession()
                if (r2 == 0) goto L_0x003f
                int r2 = r2.length()
                if (r2 <= 0) goto L_0x003b
                r2 = 1
                goto L_0x003c
            L_0x003b:
                r2 = 0
            L_0x003c:
                if (r2 == 0) goto L_0x003f
                r3 = 1
            L_0x003f:
                if (r3 == 0) goto L_0x0042
                goto L_0x0043
            L_0x0042:
                r7 = r5
            L_0x0043:
                io.reactivex.rxjava3.core.Completable r7 = r0.save(r1, r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.account.AccountStorageMigrationManager.a.apply(java.lang.Object):java.lang.Object");
        }
    }

    public static final class b<T> implements Consumer<Disposable> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            StringBuilder L = a2.b.a.a.a.L("Start migration to ");
            L.append(this.a);
            Logs.verbose$default("AccountStorageMigration", L.toString(), null, 4, null);
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            StringBuilder L = a2.b.a.a.a.L("Finish migration to ");
            L.append(this.a);
            Logs.verbose$default("AccountStorageMigration", L.toString(), null, 4, null);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            StringBuilder L = a2.b.a.a.a.L("Failure migration to ");
            L.append(this.a);
            Logs.error$default("AccountStorageMigration", L.toString(), null, 4, null);
        }
    }

    public AccountStorageMigrationManager(@NotNull Preferences preferences, @NotNull Features features, @NotNull AccountManagerStorage accountManagerStorage, @NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(accountManagerStorage, "accountManagerStorage");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        this.a = preferences;
        this.b = features;
        this.c = accountManagerStorage;
        this.d = accountStorageInteractor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    @android.annotation.SuppressLint({"CheckResult"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void migrate() {
        /*
            r9 = this;
            com.avito.android.util.preferences.Preferences r0 = r9.a
            java.lang.String r1 = "account_manager_last_state"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            com.avito.android.Features r3 = r9.b
            com.avito.android.toggle.Feature r3 = r3.getAccountManager()
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 0
            if (r0 != r3) goto L_0x0025
            r0 = 4
            java.lang.String r1 = "AccountStorageMigration"
            java.lang.String r2 = "Skip AccountStorage migration"
            com.avito.android.util.Logs.verbose$default(r1, r2, r4, r0, r4)
            return
        L_0x0025:
            com.avito.android.util.preferences.Preferences r0 = r9.a
            r0.putBoolean(r1, r3)
            if (r3 == 0) goto L_0x002f
            java.lang.String r0 = "AccountManager"
            goto L_0x0031
        L_0x002f:
            java.lang.String r0 = "AccountStorage"
        L_0x0031:
            if (r3 == 0) goto L_0x0085
            com.avito.android.account.account_manager.AccountManagerStorage r1 = r9.c
            r1.clearCache()
            com.avito.android.account.account_manager.AccountManagerStorage r1 = r9.c
            io.reactivex.rxjava3.core.Completable r1 = r1.clearAccount()
            com.avito.android.account.account_manager.AccountManagerStorage r3 = r9.c
            com.avito.android.account.AccountStorageInteractor r5 = r9.d
            com.avito.android.remote.model.ProfileInfo r5 = r5.getProfileInfo()
            java.lang.String r6 = r5.getUserId()
            r7 = 1
            if (r6 == 0) goto L_0x005a
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x0055
            r6 = 1
            goto L_0x0056
        L_0x0055:
            r6 = 0
        L_0x0056:
            if (r6 == 0) goto L_0x005a
            r6 = 1
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            if (r6 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r5 = r4
        L_0x005f:
            com.avito.android.account.AccountStorageInteractor r6 = r9.d
            com.avito.android.remote.model.Session r6 = r6.getSession()
            if (r6 == 0) goto L_0x0079
            java.lang.String r8 = r6.getSession()
            if (r8 == 0) goto L_0x0079
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0075
            r8 = 1
            goto L_0x0076
        L_0x0075:
            r8 = 0
        L_0x0076:
            if (r8 == 0) goto L_0x0079
            r2 = 1
        L_0x0079:
            if (r2 == 0) goto L_0x007c
            r4 = r6
        L_0x007c:
            io.reactivex.rxjava3.core.Completable r2 = r3.save(r5, r4)
            io.reactivex.rxjava3.core.Completable r1 = r1.andThen(r2)
            goto L_0x00a7
        L_0x0085:
            com.avito.android.account.AccountStorageInteractor r1 = r9.d
            r1.clearCache()
            com.avito.android.account.AccountStorageInteractor r1 = r9.d
            io.reactivex.rxjava3.core.Completable r1 = r1.clearAccount()
            com.avito.android.account.account_manager.AccountManagerStorage r2 = r9.c
            io.reactivex.rxjava3.core.Maybe r2 = r2.currentSession()
            io.reactivex.rxjava3.core.Single r2 = r2.toSingle()
            com.avito.android.account.AccountStorageMigrationManager$a r3 = new com.avito.android.account.AccountStorageMigrationManager$a
            r3.<init>(r9)
            io.reactivex.rxjava3.core.Completable r2 = r2.flatMapCompletable(r3)
            io.reactivex.rxjava3.core.Completable r1 = r1.andThen(r2)
        L_0x00a7:
            com.avito.android.account.AccountStorageMigrationManager$b r2 = new com.avito.android.account.AccountStorageMigrationManager$b
            r2.<init>(r0)
            io.reactivex.rxjava3.core.Completable r1 = r1.doOnSubscribe(r2)
            com.avito.android.account.AccountStorageMigrationManager$c r2 = new com.avito.android.account.AccountStorageMigrationManager$c
            r2.<init>(r0)
            com.avito.android.account.AccountStorageMigrationManager$d r3 = new com.avito.android.account.AccountStorageMigrationManager$d
            r3.<init>(r0)
            r1.subscribe(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.account.AccountStorageMigrationManager.migrate():void");
    }
}
