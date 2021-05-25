package com.avito.android.authorization.account_manager;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.authorization.auth.AuthActivityKt;
import com.avito.android.authorization.auth.OldAuthActivityKt;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.util.Logs;
import com.avito.android.util.Throwables;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u0015\u001a\u00020\u001d¢\u0006\u0004\b0\u00101JE\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u001b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/avito/android/authorization/account_manager/AvitoAccountAuthenticator;", "Landroid/accounts/AbstractAccountAuthenticator;", "Landroid/accounts/AccountAuthenticatorResponse;", CommonKt.EXTRA_RESPONSE, "", "accountType", "authTokenType", "", "requiredFeatures", "Landroid/os/Bundle;", "options", "addAccount", "(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "editProperties", "(Landroid/accounts/AccountAuthenticatorResponse;Ljava/lang/String;)Landroid/os/Bundle;", "Landroid/accounts/Account;", BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT, "updateCredentials", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "confirmCredentials", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;Landroid/os/Bundle;)Landroid/os/Bundle;", "features", "hasFeatures", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;[Ljava/lang/String;)Landroid/os/Bundle;", "getAuthTokenLabel", "(Ljava/lang/String;)Ljava/lang/String;", "getAuthToken", "getAccountRemovalAllowed", "(Landroid/accounts/AccountAuthenticatorResponse;Landroid/accounts/Account;)Landroid/os/Bundle;", "Lcom/avito/android/Features;", "e", "Lcom/avito/android/Features;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/accounts/AccountManager;", AuthSource.BOOKING_ORDER, "Landroid/accounts/AccountManager;", "accountManager", "Lcom/avito/android/preferences/TokenStorage;", "d", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/remote/ProfileApi;", "c", "Lcom/avito/android/remote/ProfileApi;", "api", "<init>", "(Landroid/content/Context;Landroid/accounts/AccountManager;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/Features;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoAccountAuthenticator extends AbstractAccountAuthenticator {
    public final Context a;
    public final AccountManager b;
    public final ProfileApi c;
    public final TokenStorage d;
    public final Features e;

    public static final class a<T, R> implements Function<SuccessResult, Boolean> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(SuccessResult successResult) {
            Intrinsics.checkNotNullParameter(successResult, "it");
            return Boolean.TRUE;
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (!Throwables.isAuthProblem(th2)) {
                Logs.error("AccountManager", "Could't logout. API error", th2);
            }
        }
    }

    public static final class c<T, R> implements Function<Throwable, Boolean> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvitoAccountAuthenticator(@NotNull Context context, @NotNull AccountManager accountManager, @NotNull ProfileApi profileApi, @NotNull TokenStorage tokenStorage, @NotNull Features features) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountManager, "accountManager");
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = context;
        this.b = accountManager;
        this.c = profileApi;
        this.d = tokenStorage;
        this.e = features;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle addAccount(@NotNull AccountAuthenticatorResponse accountAuthenticatorResponse, @NotNull String str, @Nullable String str2, @Nullable String[] strArr, @NotNull Bundle bundle) {
        Intent intent;
        Intrinsics.checkNotNullParameter(accountAuthenticatorResponse, CommonKt.EXTRA_RESPONSE);
        Intrinsics.checkNotNullParameter(str, "accountType");
        Intrinsics.checkNotNullParameter(bundle, "options");
        Account[] accountsByType = this.b.getAccountsByType(str);
        Intrinsics.checkNotNullExpressionValue(accountsByType, "accountManager.getAccountsByType(accountType)");
        Account account = (Account) ArraysKt___ArraysKt.firstOrNull(accountsByType);
        if (account != null) {
            String str3 = account.name;
            Intrinsics.checkNotNullExpressionValue(str3, "currentAccount.name");
            String str4 = account.type;
            Intrinsics.checkNotNullExpressionValue(str4, "currentAccount.type");
            Bundle bundle2 = new Bundle();
            bundle2.putString("authAccount", str3);
            bundle2.putString("accountType", str4);
            return bundle2;
        } else if (!bundle.containsKey("authAccount") || !bundle.containsKey("accountType")) {
            if (this.e.getAuthAsFragment().invoke().booleanValue()) {
                intent = AuthActivityKt.createAuthIntent$default(this.a, null, AuthSource.TEST_6, null, 10, null);
            } else {
                intent = OldAuthActivityKt.createOldAuthIntent$default(this.a, null, AuthSource.TEST_6, null, 10, null);
            }
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("intent", intent);
            return bundle3;
        } else {
            Account account2 = new Account(bundle.getString("authAccount"), bundle.getString("accountType"));
            this.b.addAccountExplicitly(account2, null, null);
            String str5 = account2.name;
            Intrinsics.checkNotNullExpressionValue(str5, "createdAccount.name");
            String str6 = account2.type;
            Intrinsics.checkNotNullExpressionValue(str6, "createdAccount.type");
            Bundle bundle4 = new Bundle();
            bundle4.putString("authAccount", str5);
            bundle4.putString("accountType", str6);
            return bundle4;
        }
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle confirmCredentials(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle editProperties(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable String str) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @NotNull
    public Bundle getAccountRemovalAllowed(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @NotNull Account account) {
        Intrinsics.checkNotNullParameter(account, BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
        Boolean bool = (Boolean) InteropKt.toV2(this.c.logoutLegacy(this.d.getGcmToken())).firstOrError().map(a.a).doOnError(b.a).onErrorReturn(c.a).blockingGet();
        Intrinsics.checkNotNullExpressionValue(bool, "isSuccess");
        boolean booleanValue = bool.booleanValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", booleanValue);
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if ((r0.length() > 0) != false) goto L_0x002b;
     */
    @Override // android.accounts.AbstractAccountAuthenticator
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle getAuthToken(@org.jetbrains.annotations.NotNull android.accounts.AccountAuthenticatorResponse r8, @org.jetbrains.annotations.NotNull android.accounts.Account r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull android.os.Bundle r11) {
        /*
            r7 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "account"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "authTokenType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            android.accounts.AccountManager r0 = r7.b
            java.lang.String r0 = r0.peekAuthToken(r9, r10)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002a
            int r3 = r0.length()
            if (r3 <= 0) goto L_0x0026
            r3 = 1
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            if (r3 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            if (r1 == 0) goto L_0x003b
            android.os.Bundle r9 = new android.os.Bundle
            r9.<init>()
            java.lang.String r10 = "authtoken"
            r9.putString(r10, r0)
            r8.onResult(r9)
            return r9
        L_0x003b:
            java.lang.String r3 = r9.type
            java.lang.String r9 = "account.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            java.lang.String[] r5 = new java.lang.String[r2]
            r1 = r7
            r2 = r8
            r4 = r10
            r6 = r11
            android.os.Bundle r8 = r1.addAccount(r2, r3, r4, r5, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.account_manager.AvitoAccountAuthenticator.getAuthToken(android.accounts.AccountAuthenticatorResponse, android.accounts.Account, java.lang.String, android.os.Bundle):android.os.Bundle");
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public String getAuthTokenLabel(@Nullable String str) {
        return "Avito";
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle hasFeatures(@Nullable AccountAuthenticatorResponse accountAuthenticatorResponse, @Nullable Account account, @Nullable String[] strArr) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", false);
        return bundle;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    @Nullable
    public Bundle updateCredentials(@NotNull AccountAuthenticatorResponse accountAuthenticatorResponse, @NotNull Account account, @Nullable String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(accountAuthenticatorResponse, CommonKt.EXTRA_RESPONSE);
        Intrinsics.checkNotNullParameter(account, BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
        return null;
    }
}
