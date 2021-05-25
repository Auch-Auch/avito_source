package com.avito.android.deep_linking;

import a2.a.a.j0.d;
import a2.g.r.g;
import android.net.Uri;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.LocationOwnerLink;
import com.avito.android.deep_linking.remote.AppLink;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/deep_linking/AppLinkPresenterImpl;", "Lcom/avito/android/deep_linking/AppLinkPresenter;", "Lcom/avito/android/deep_linking/AppLinkView;", "view", "", "attachView", "(Lcom/avito/android/deep_linking/AppLinkView;)V", "Lcom/avito/android/deep_linking/AppLinkRouter;", "router", "attachRouter", "(Lcom/avito/android/deep_linking/AppLinkRouter;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "referrerUri", "setDeepLinkUriParams", "(Landroid/net/Uri;Landroid/net/Uri;)V", "detachRouter", "()V", "detachView", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "k", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/AppLinkView;", "Lcom/avito/android/deep_linking/AppLinkRouter;", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "requestDisposable", "", g.a, "Z", "isUriParamsInitialized", "d", "viewDisposable", "Lcom/avito/android/deep_linking/AppLinkInteractor;", "h", "Lcom/avito/android/deep_linking/AppLinkInteractor;", "appLinkInteractor", "Lcom/avito/android/location/SavedLocationInteractor;", "j", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "f", "Landroid/net/Uri;", "Lcom/avito/android/deep_linking/AdjustReattributionInteractor;", "l", "Lcom/avito/android/deep_linking/AdjustReattributionInteractor;", "adjustReattributionInteractor", "e", "<init>", "(Lcom/avito/android/deep_linking/AppLinkInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lcom/avito/android/deep_linking/AdjustReattributionInteractor;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppLinkPresenterImpl implements AppLinkPresenter {
    public AppLinkRouter a;
    public AppLinkView b;
    public Disposable c;
    public Disposable d;
    public Uri e;
    public Uri f;
    public boolean g;
    public final AppLinkInteractor h;
    public final SchedulersFactory i;
    public final SavedLocationInteractor j;
    public final LocationAnalyticsInteractor k;
    public final AdjustReattributionInteractor l;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AppLinkPresenterImpl a;
        public final /* synthetic */ Uri b;

        public a(AppLinkPresenterImpl appLinkPresenterImpl, Uri uri) {
            this.a = appLinkPresenterImpl;
            this.b = uri;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            AppLinkPresenterImpl appLinkPresenterImpl = this.a;
            appLinkPresenterImpl.a(this.b, appLinkPresenterImpl.f);
        }
    }

    public static final class b<T> implements Consumer<AppLink> {
        public final /* synthetic */ AppLinkPresenterImpl a;
        public final /* synthetic */ Uri b;

        public b(AppLinkPresenterImpl appLinkPresenterImpl, Uri uri) {
            this.a = appLinkPresenterImpl;
            this.b = uri;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AppLink appLink) {
            String locationId;
            AppLink appLink2 = appLink;
            LocationOwnerLink locationOwnerLink = null;
            DeepLink deepLink = appLink2 != null ? appLink2.getDeepLink() : null;
            if (deepLink instanceof LocationOwnerLink) {
                locationOwnerLink = deepLink;
            }
            LocationOwnerLink locationOwnerLink2 = locationOwnerLink;
            if (!(locationOwnerLink2 == null || (locationId = locationOwnerLink2.getLocationId()) == null)) {
                AppLinkPresenterImpl.access$trackLocation(this.a, locationId);
            }
            AppLinkPresenterImpl.access$openDeepLink(this.a, appLink2.getDeepLink(), this.b);
        }
    }

    @Inject
    public AppLinkPresenterImpl(@NotNull AppLinkInteractor appLinkInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @NotNull AdjustReattributionInteractor adjustReattributionInteractor) {
        Intrinsics.checkNotNullParameter(appLinkInteractor, "appLinkInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(adjustReattributionInteractor, "adjustReattributionInteractor");
        this.h = appLinkInteractor;
        this.i = schedulersFactory;
        this.j = savedLocationInteractor;
        this.k = locationAnalyticsInteractor;
        this.l = adjustReattributionInteractor;
    }

    public static final void access$openDeepLink(AppLinkPresenterImpl appLinkPresenterImpl, DeepLink deepLink, Uri uri) {
        appLinkPresenterImpl.l.startReattribution(uri);
        AppLinkRouter appLinkRouter = appLinkPresenterImpl.a;
        if (appLinkRouter != null) {
            appLinkRouter.close();
            if (deepLink == null || !appLinkRouter.openDeepLink(deepLink)) {
                appLinkRouter.openUri(uri);
            }
        }
    }

    public static final void access$showError(AppLinkPresenterImpl appLinkPresenterImpl, Throwable th) {
        Objects.requireNonNull(appLinkPresenterImpl);
        if (th instanceof TypedResultException) {
            AppLinkView appLinkView = appLinkPresenterImpl.b;
            if (appLinkView != null) {
                appLinkView.showError(((TypedResultException) th).getMessage());
                return;
            }
            return;
        }
        AppLinkView appLinkView2 = appLinkPresenterImpl.b;
        if (appLinkView2 != null) {
            appLinkView2.showError();
        }
    }

    public static final void access$trackLocation(AppLinkPresenterImpl appLinkPresenterImpl, String str) {
        InteropKt.toV2(SavedLocationInteractor.DefaultImpls.wrappedLocation$default(appLinkPresenterImpl.j, null, false, 3, null)).subscribeOn(appLinkPresenterImpl.i.io()).observeOn(appLinkPresenterImpl.i.mainThread()).subscribe(new d(appLinkPresenterImpl, str), new a2.a.a.j0.c(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.j0.e
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
    }

    public final void a(Uri uri, Uri uri2) {
        AppLinkView appLinkView = this.b;
        if (appLinkView != null) {
            appLinkView.showLoading();
        }
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        String uri3 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
        this.c = this.h.getAppLink(uri3, String.valueOf(uri2)).observeOn(this.i.mainThread()).subscribe(new b(this, uri), new a2.a.a.j0.c(new Function1<Throwable, Unit>(this) { // from class: com.avito.android.deep_linking.AppLinkPresenterImpl.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Throwable th2 = th;
                Intrinsics.checkNotNullParameter(th2, "p1");
                AppLinkPresenterImpl.access$showError((AppLinkPresenterImpl) this.receiver, th2);
                return Unit.INSTANCE;
            }
        }));
    }

    @Override // com.avito.android.deep_linking.AppLinkPresenter
    public void attachRouter(@NotNull AppLinkRouter appLinkRouter) {
        Intrinsics.checkNotNullParameter(appLinkRouter, "router");
        if (this.g) {
            Uri uri = this.e;
            if (uri != null) {
                this.a = appLinkRouter;
                a(uri, this.f);
                return;
            }
            appLinkRouter.close();
        }
    }

    @Override // com.avito.android.deep_linking.AppLinkPresenter
    public void attachView(@NotNull AppLinkView appLinkView) {
        Intrinsics.checkNotNullParameter(appLinkView, "view");
        Uri uri = this.e;
        if (uri != null) {
            this.b = appLinkView;
            Disposable disposable = this.d;
            if (disposable != null) {
                disposable.dispose();
            }
            this.d = appLinkView.getRefreshes().observeOn(this.i.mainThread()).subscribe(new a(this, uri));
        }
    }

    @Override // com.avito.android.deep_linking.AppLinkPresenter
    public void detachRouter() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
        this.a = null;
    }

    @Override // com.avito.android.deep_linking.AppLinkPresenter
    public void detachView() {
        this.b = null;
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
    }

    @Override // com.avito.android.deep_linking.AppLinkPresenter
    public void setDeepLinkUriParams(@Nullable Uri uri, @Nullable Uri uri2) {
        this.e = uri;
        this.f = uri2;
        this.g = true;
    }
}
