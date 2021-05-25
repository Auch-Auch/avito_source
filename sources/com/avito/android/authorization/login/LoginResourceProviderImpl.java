package com.avito.android.authorization.login;

import android.content.res.Resources;
import com.avito.android.authorization.R;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/authorization/login/LoginResourceProviderImpl;", "Lcom/avito/android/authorization/login/LoginResourceProvider;", "", "login", "hiddenEmailText", "(Ljava/lang/String;)Ljava/lang/String;", "hiddenPhoneText", "resetPasswordViaCodeText", "resetPasswordViaLinkText", "verifyPhoneText", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "codeConfirmationResourceProvider", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginResourceProviderImpl implements LoginResourceProvider {
    public final Resources a;
    public final CodeConfirmationResourceProvider b;

    @Inject
    public LoginResourceProviderImpl(@NotNull Resources resources, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "codeConfirmationResourceProvider");
        this.a = resources;
        this.b = codeConfirmationResourceProvider;
    }

    @Override // com.avito.android.authorization.login.LoginResourceProvider
    @NotNull
    public String hiddenEmailText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        String string = this.a.getString(R.string.hidden_email_text, LoginResourceProviderKt.maskIfNeeded(str));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…xt, login.maskIfNeeded())");
        return string;
    }

    @Override // com.avito.android.authorization.login.LoginResourceProvider
    @NotNull
    public String hiddenPhoneText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        String string = this.a.getString(R.string.hidden_phone_text, LoginResourceProviderKt.maskIfNeeded(str));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…xt, login.maskIfNeeded())");
        return string;
    }

    @Override // com.avito.android.authorization.login.LoginResourceProvider
    @NotNull
    public String resetPasswordViaCodeText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        return this.b.codeSent(LoginResourceProviderKt.maskIfNeeded(str));
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordResourceProvider
    @NotNull
    public String resetPasswordViaLinkText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        String string = this.a.getString(R.string.link_sent_text, LoginResourceProviderKt.maskIfNeeded(str));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…xt, login.maskIfNeeded())");
        return string;
    }

    @Override // com.avito.android.authorization.login.LoginResourceProvider
    @NotNull
    public String verifyPhoneText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        return this.b.codeSent(str);
    }
}
