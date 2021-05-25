package com.avito.android.authorization.change_password;

import com.avito.android.util.Kundle;
import com.avito.android.util.preferences.Preference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordPresenter;", "", "Lcom/avito/android/authorization/change_password/ChangePasswordView;", "view", "", "attachView", "(Lcom/avito/android/authorization/change_password/ChangePasswordView;)V", "Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface ChangePasswordPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordPresenter$Router;", "", "", "leaveScreen", "()V", "", Preference.PASSWORD, "openLogin", "(Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void openLogin(@NotNull String str);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull ChangePasswordView changePasswordView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
