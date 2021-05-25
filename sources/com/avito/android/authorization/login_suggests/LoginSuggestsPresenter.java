package com.avito.android.authorization.login_suggests;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter;", "", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;", "view", "", "attachView", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;)V", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface LoginSuggestsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsPresenter$Router;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "social", "socialId", "closeWithSocial", "(Ljava/lang/String;Ljava/lang/String;)V", "login", "closeWithLogin", "(Ljava/lang/String;)V", "closeWithCommon", "()V", "close", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void close();

        void closeWithCommon();

        void closeWithLogin(@NotNull String str);

        void closeWithSocial(@NotNull String str, @Nullable String str2);

        void followDeepLink(@NotNull DeepLink deepLink);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull LoginSuggestsView loginSuggestsView);

    void detachRouter();

    void detachView();

    void onBackPressed();

    @NotNull
    Kundle onSaveState();
}
