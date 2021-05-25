package com.avito.android.advert_core.phone_request;

import a2.a.a.g.j.a;
import a2.a.a.g.j.b;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenterImpl;", "Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "Lcom/avito/android/advert_core/phone_request/PhoneRequestView;", "view", "", "attachView", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestView;)V", "Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;", "router", "attachRouter", "(Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;)V", "detachView", "()V", "detachRouter", "onPhoneCallConfirmed", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "makeCallSafely", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "onDialogCanceled", "onDialogDismiss", "onAuthSuccess", "Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkAnalyticsInteractor;", "d", "Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkAnalyticsInteractor;", "analyticsInteractor", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/phone_request/PhoneRequestRouter;", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "c", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "f", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/phone_request/PhoneRequestView;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/advert_core/phone_request/PhoneRequestDeepLinkAnalyticsInteractor;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/async_phone/AsyncPhonePresenter;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneRequestPresenterImpl implements PhoneRequestPresenter {
    public PhoneRequestRouter a;
    public PhoneRequestView b;
    public final PhoneRequestLink c;
    public final PhoneRequestDeepLinkAnalyticsInteractor d;
    public final DeepLinkIntentFactory e;
    public final AsyncPhonePresenter f;

    @Inject
    public PhoneRequestPresenterImpl(@NotNull PhoneRequestLink phoneRequestLink, @NotNull PhoneRequestDeepLinkAnalyticsInteractor phoneRequestDeepLinkAnalyticsInteractor, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull AsyncPhonePresenter asyncPhonePresenter) {
        Intrinsics.checkNotNullParameter(phoneRequestLink, "link");
        Intrinsics.checkNotNullParameter(phoneRequestDeepLinkAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        this.c = phoneRequestLink;
        this.d = phoneRequestDeepLinkAnalyticsInteractor;
        this.e = deepLinkIntentFactory;
        this.f = asyncPhonePresenter;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void attachRouter(@NotNull PhoneRequestRouter phoneRequestRouter) {
        Intrinsics.checkNotNullParameter(phoneRequestRouter, "router");
        this.a = phoneRequestRouter;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void attachView(@NotNull PhoneRequestView phoneRequestView) {
        Intrinsics.checkNotNullParameter(phoneRequestView, "view");
        this.b = phoneRequestView;
        this.f.attachView(phoneRequestView);
        this.f.loadPhoneLink(this.c, this.b, new a(this), new b(this));
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void detachView() {
        this.b = null;
        this.f.detachView();
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void makeCallSafely(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intent intent = this.e.getIntent(phoneLink);
        if (intent != null) {
            try {
                PhoneRequestRouter phoneRequestRouter = this.a;
                if (phoneRequestRouter != null) {
                    phoneRequestRouter.startActivity(intent);
                }
                this.d.trackSuccessOpenDialer();
            } catch (ActivityNotFoundException unused) {
                PhoneRequestView phoneRequestView = this.b;
                if (phoneRequestView != null) {
                    phoneRequestView.showToast(R.string.cant_do_call);
                }
                this.d.trackFailedOpenDialer();
            }
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void onAuthSuccess() {
        this.f.loadPhoneLink(this.c, this.b, new a(this), new b(this));
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void onDialogCanceled() {
        PhoneRequestRouter phoneRequestRouter = this.a;
        if (phoneRequestRouter != null) {
            phoneRequestRouter.leaveScreen();
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void onDialogDismiss() {
        PhoneRequestRouter phoneRequestRouter = this.a;
        if (phoneRequestRouter != null) {
            phoneRequestRouter.leaveScreen();
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestPresenter
    public void onPhoneCallConfirmed() {
        this.d.trackPhoneConfirmed();
    }
}
