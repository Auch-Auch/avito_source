package com.avito.android.advert_core.phone_request;

import com.avito.android.deep_linking.links.PhoneLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "", "", "onPhoneCallConfirmed", "()V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "makeCallSafely", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "onDialogCanceled", "onDialogDismiss", "onAuthSuccess", "Lcom/avito/android/advert_core/phone_request/PhoneRequestView;", "view", "attachView", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestView;)V", "Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;", "router", "attachRouter", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;)V", "detachView", "detachRouter", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneRequestPresenter {
    void attachRouter(@NotNull PhoneRequestRouter phoneRequestRouter);

    void attachView(@NotNull PhoneRequestView phoneRequestView);

    void detachRouter();

    void detachView();

    void makeCallSafely(@NotNull PhoneLink phoneLink);

    void onAuthSuccess();

    void onDialogCanceled();

    void onDialogDismiss();

    void onPhoneCallConfirmed();
}
