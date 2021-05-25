package com.avito.android.authorization.login;

import com.avito.android.authorization.reset_password.ResetPasswordResourceProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/login/LoginResourceProvider;", "Lcom/avito/android/authorization/reset_password/ResetPasswordResourceProvider;", "", "login", "hiddenEmailText", "(Ljava/lang/String;)Ljava/lang/String;", "hiddenPhoneText", "resetPasswordViaCodeText", "verifyPhoneText", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginResourceProvider extends ResetPasswordResourceProvider {
    @NotNull
    String hiddenEmailText(@NotNull String str);

    @NotNull
    String hiddenPhoneText(@NotNull String str);

    @NotNull
    String resetPasswordViaCodeText(@NotNull String str);

    @NotNull
    String verifyPhoneText(@NotNull String str);
}
