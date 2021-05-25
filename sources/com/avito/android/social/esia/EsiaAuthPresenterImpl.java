package com.avito.android.social.esia;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.esia.EsiaAuthPresenter;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/social/esia/EsiaAuthPresenterImpl;", "Lcom/avito/android/social/esia/EsiaAuthPresenter;", "Lcom/avito/android/social/esia/EsiaAuthView;", "view", "", "attachView", "(Lcom/avito/android/social/esia/EsiaAuthView;)V", "Lcom/avito/android/social/esia/EsiaAuthPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/social/esia/EsiaAuthPresenter$Router;)V", "detachView", "()V", "detachRouter", "onBackPressed", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", AuthSource.BOOKING_ORDER, "Lcom/avito/android/social/esia/EsiaAuthPresenter$Router;", "Lcom/avito/android/social/esia/EsiaAuthView;", "<init>", "(Lcom/avito/android/Features;)V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class EsiaAuthPresenterImpl implements EsiaAuthPresenter {
    public EsiaAuthView a;
    public EsiaAuthPresenter.Router b;
    public final Features c;

    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ EsiaAuthPresenterImpl a;

        public c(EsiaAuthPresenterImpl esiaAuthPresenterImpl) {
            this.a = esiaAuthPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            EsiaAuthPresenterImpl.access$onCloseScreen(this.a);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    @Inject
    public EsiaAuthPresenterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = features;
    }

    public static final void access$onAuthResult(EsiaAuthPresenterImpl esiaAuthPresenterImpl, EsiaAuthResult esiaAuthResult) {
        EsiaAuthPresenter.Router router = esiaAuthPresenterImpl.b;
        if (router != null) {
            router.sendResult(esiaAuthResult);
        }
    }

    public static final void access$onCloseScreen(EsiaAuthPresenterImpl esiaAuthPresenterImpl) {
        EsiaAuthPresenter.Router router = esiaAuthPresenterImpl.b;
        if (router != null) {
            router.sendResult(null);
        }
    }

    public final void a() {
        EsiaAuthView esiaAuthView = this.a;
        if (esiaAuthView != null) {
            Uri parse = Uri.parse(this.c.getApiUrl().invoke());
            Intrinsics.checkNotNullExpressionValue(parse, "apiUrl");
            String scheme = parse.getScheme();
            String authority = parse.getAuthority();
            String builder = new Uri.Builder().scheme(scheme).authority(authority).appendPath("web").appendPath("1").appendPath("profile").appendPath("info").appendPath("social").appendPath("redirect").appendPath("esia").appendQueryParameter("state", a2.b.a.a.a.I2("UUID.randomUUID().toString()")).toString();
            Intrinsics.checkNotNullExpressionValue(builder, "Uri.Builder()\n          …)\n            .toString()");
            esiaAuthView.loadUrl(builder, new EsiaAuthConfig("ru.avito://1/social_redirect"));
        }
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter
    public void attachRouter(@NotNull EsiaAuthPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter
    public void attachView(@NotNull EsiaAuthView esiaAuthView) {
        Intrinsics.checkNotNullParameter(esiaAuthView, "view");
        this.a = esiaAuthView;
        esiaAuthView.setRefreshAction(new Function0<Unit>(this) { // from class: com.avito.android.social.esia.EsiaAuthPresenterImpl.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ((EsiaAuthPresenterImpl) this.receiver).a();
                return Unit.INSTANCE;
            }
        });
        esiaAuthView.setAuthCallback(new Function1<EsiaAuthResult, Unit>(this) { // from class: com.avito.android.social.esia.EsiaAuthPresenterImpl.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(EsiaAuthResult esiaAuthResult) {
                EsiaAuthResult esiaAuthResult2 = esiaAuthResult;
                Intrinsics.checkNotNullParameter(esiaAuthResult2, "p1");
                EsiaAuthPresenterImpl.access$onAuthResult((EsiaAuthPresenterImpl) this.receiver, esiaAuthResult2);
                return Unit.INSTANCE;
            }
        });
        a();
        esiaAuthView.getButtonClicks().subscribe(new c(this), d.a);
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter
    public void detachView() {
        this.a = null;
    }

    @Override // com.avito.android.social.esia.EsiaAuthPresenter
    public void onBackPressed() {
        EsiaAuthView esiaAuthView = this.a;
        if (esiaAuthView != null ? esiaAuthView.canGoBack() : false) {
            EsiaAuthView esiaAuthView2 = this.a;
            if (esiaAuthView2 != null) {
                esiaAuthView2.goBack();
                return;
            }
            return;
        }
        EsiaAuthPresenter.Router router = this.b;
        if (router != null) {
            router.sendResult(null);
        }
    }
}
