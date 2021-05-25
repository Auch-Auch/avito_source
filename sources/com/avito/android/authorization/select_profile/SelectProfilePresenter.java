package com.avito.android.authorization.select_profile;

import com.avito.android.remote.model.registration.ProfileSocial;
import com.avito.android.util.Kundle;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "", "Lcom/avito/android/authorization/select_profile/SelectProfileView;", "view", "", "attachView", "(Lcom/avito/android/authorization/select_profile/SelectProfileView;)V", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface SelectProfilePresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/authorization/select_profile/SelectProfilePresenter$Router;", "", "", "leaveScreen", "()V", "", "Lcom/avito/android/remote/model/registration/ProfileSocial;", "social", "openSelectSocial", "(Ljava/util/List;)V", "", "login", "openLogin", "(Ljava/lang/String;)V", "openCompleteRegistration", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void leaveScreen();

        void openCompleteRegistration();

        void openLogin(@NotNull String str);

        void openSelectSocial(@NotNull List<ProfileSocial> list);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull SelectProfileView selectProfileView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
