package com.avito.android.authorization.complete_registration;

import com.avito.android.authorization.smart_lock.ResolvableResult;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter;", "", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;", "view", "", "attachView", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;)V", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;)V", "detachRouter", "()V", "detachView", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Router", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface CompleteRegistrationPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationPresenter$Router;", "", "", "completeRegistration", "()V", "leaveScreen", "Lcom/avito/android/authorization/smart_lock/ResolvableResult;", "status", "resolveResult", "(Lcom/avito/android/authorization/smart_lock/ResolvableResult;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void completeRegistration();

        void leaveScreen();

        void resolveResult(@NotNull ResolvableResult resolvableResult);
    }

    void attachRouter(@NotNull Router router);

    void attachView(@NotNull CompleteRegistrationView completeRegistrationView);

    void detachRouter();

    void detachView();

    @NotNull
    Kundle onSaveState();
}
