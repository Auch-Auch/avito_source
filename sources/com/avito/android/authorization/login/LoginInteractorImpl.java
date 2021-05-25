package com.avito.android.authorization.login;

import com.avito.android.account.AccountInteractor;
import com.avito.android.account.Credentials;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.model.CodeInfo;
import com.avito.android.code_confirmation.model.ConfirmedCodeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\tJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0011\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/authorization/login/LoginInteractorImpl;", "Lcom/avito/android/authorization/login/LoginInteractor;", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "", "login", Preference.PASSWORD, "suggestKey", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/LoginResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "id", "src", "Lcom/avito/android/code_confirmation/model/CodeInfo;", "requestCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "code", "Lcom/avito/android/code_confirmation/model/ConfirmedCodeInfo;", "sendCode", "Lcom/avito/android/account/AccountInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", AuthSource.BOOKING_ORDER, "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "<init>", "(Lcom/avito/android/account/AccountInteractor;Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginInteractorImpl implements LoginInteractor, CodeConfirmationInteractor {
    public final AccountInteractor a;
    public final CodeConfirmationInteractor b;

    @Inject
    public LoginInteractorImpl(@NotNull AccountInteractor accountInteractor, @NotNull CodeConfirmationInteractor codeConfirmationInteractor) {
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        this.a = accountInteractor;
        this.b = codeConfirmationInteractor;
    }

    @Override // com.avito.android.authorization.login.LoginInteractor
    @NotNull
    public Observable<LoginResult> login(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        Observable<LoginResult> observable = InteropKt.toV2(this.a.login(new Credentials.PasswordCredentials(str, str2), str3)).flatMap(LoginInteractorImpl$login$$inlined$toTyped$1.INSTANCE).firstOrError().toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "flatMap { state ->\n     …tOrError().toObservable()");
        return observable;
    }

    @Override // com.avito.android.code_confirmation.RequestCodeInteractor
    @NotNull
    public Observable<CodeInfo> requestCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.b.requestCode(str, str2);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationInteractor
    @NotNull
    public Observable<ConfirmedCodeInfo> sendCode(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "login");
        Intrinsics.checkNotNullParameter(str2, "code");
        return this.b.sendCode(str, str2, str3);
    }
}
