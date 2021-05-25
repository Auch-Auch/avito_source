package com.avito.android.social.apple;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.apple.AppleAuthPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/social/apple/AppleAuthPresenterImpl;", "Lcom/avito/android/social/apple/AppleAuthPresenter;", "Lcom/avito/android/social/apple/AppleAuthView;", "view", "", "attachView", "(Lcom/avito/android/social/apple/AppleAuthView;)V", "Lcom/avito/android/social/apple/AppleAuthPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social/apple/AppleAuthPresenter$Router;)V", "detachView", "()V", "detachRouter", "loadAuthPage", AuthSource.BOOKING_ORDER, "Lcom/avito/android/social/apple/AppleAuthPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/social/apple/AppleAuthView;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class AppleAuthPresenterImpl implements AppleAuthPresenter {
    public AppleAuthView a;
    public AppleAuthPresenter.Router b;
    public final Features c;

    @Inject
    public AppleAuthPresenterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = features;
    }

    public static final void access$onAuthResult(AppleAuthPresenterImpl appleAuthPresenterImpl, AppleAuthResult appleAuthResult) {
        AppleAuthPresenter.Router router = appleAuthPresenterImpl.b;
        if (router != null) {
            router.sendResult(appleAuthResult);
        }
    }

    public static final void access$onCloseScreen(AppleAuthPresenterImpl appleAuthPresenterImpl) {
        AppleAuthPresenter.Router router = appleAuthPresenterImpl.b;
        if (router != null) {
            router.sendResult(null);
        }
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter
    public void attachRouter(@NotNull AppleAuthPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter
    public void attachView(@NotNull AppleAuthView appleAuthView) {
        Intrinsics.checkNotNullParameter(appleAuthView, "view");
        this.a = appleAuthView;
        appleAuthView.setCloseAction(new Function0<Unit>(this) { // from class: com.avito.android.social.apple.AppleAuthPresenterImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                AppleAuthPresenterImpl.access$onCloseScreen((AppleAuthPresenterImpl) this.receiver);
                return Unit.INSTANCE;
            }
        });
        appleAuthView.setRefreshAction(new Function0<Unit>(this) { // from class: com.avito.android.social.apple.AppleAuthPresenterImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ((AppleAuthPresenterImpl) this.receiver).loadAuthPage();
                return Unit.INSTANCE;
            }
        });
        appleAuthView.setAuthCallback(new Function1<AppleAuthResult, Unit>(this) { // from class: com.avito.android.social.apple.AppleAuthPresenterImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(AppleAuthResult appleAuthResult) {
                AppleAuthResult appleAuthResult2 = appleAuthResult;
                Intrinsics.checkNotNullParameter(appleAuthResult2, "p1");
                AppleAuthPresenterImpl.access$onAuthResult((AppleAuthPresenterImpl) this.receiver, appleAuthResult2);
                return Unit.INSTANCE;
            }
        });
        loadAuthPage();
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.social.apple.AppleAuthPresenter
    public void loadAuthPage() {
        AppleAuthView appleAuthView = this.a;
        if (appleAuthView != null) {
            Uri parse = Uri.parse(this.c.getApiUrl().invoke());
            Intrinsics.checkNotNullExpressionValue(parse, "apiUrl");
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            StringBuilder W = a2.b.a.a.a.W("https://appleid.apple.com/auth/authorize", "?client_id=service.ru.avito.app", "&scope=name%20email", "&response_mode=form_post", "&response_type=code");
            W.append(a2.b.a.a.a.f("&redirect_uri=", scheme, "://", authority, "/web/1/profile/info/social/redirect"));
            W.append("&state=2908");
            String sb = W.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n        …)\n            .toString()");
            appleAuthView.loadUrl(sb, new AppleAuthRequestConfig("ru.avito://1/social_redirect", "2908"));
        }
    }
}
