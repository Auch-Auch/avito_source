package com.avito.android.authorization.reset_password;

import com.avito.android.remote.model.ResetPasswordResult;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordInteractor;", "", "", "login", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/ResetPasswordResult;", "resetPassword", "(Ljava/lang/String;)Lio/reactivex/Observable;", "loginResetPasswordForPhone", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface ResetPasswordInteractor {
    @NotNull
    Observable<ResetPasswordResult> loginResetPasswordForPhone(@NotNull String str);

    @NotNull
    Observable<ResetPasswordResult> resetPassword(@NotNull String str);
}
