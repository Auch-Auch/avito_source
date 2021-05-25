package com.avito.android.authorization.complete_registration;

import com.avito.android.remote.model.AuthResult;
import com.avito.android.util.preferences.Preference;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationInteractor;", "", "", "hash", "name", Preference.PASSWORD, "Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/AuthResult;", "register", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface CompleteRegistrationInteractor {
    @NotNull
    Observable<AuthResult> register(@NotNull String str, @NotNull String str2, @NotNull String str3);
}
