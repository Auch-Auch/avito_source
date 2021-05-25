package com.avito.android.permissions;

import a2.a.a.u1.d;
import a2.a.a.u1.e;
import android.view.View;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.snackbar.proxy.SnackbarProxyKt;
import com.avito.android.util.Logs;
import com.avito.android.util.SnackBarCallbackObservable;
import com.avito.android.util.rx3.Singles;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/avito/android/permissions/LocationPermissionDialogPresenterImpl;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "subscriber", "setSubscriber", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;)V", "detachRouter", "()V", "detachSubscriber", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscriberChangeLocation", "()Lio/reactivex/rxjava3/disposables/Disposable;", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriberNotPermissionGranted", "(Landroid/view/View;)Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/core/Single;", "", "requestLocation", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SnackBarCallbackObservable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/SnackBarCallbackObservable;", "locationPermissionSnackBarObservable", "c", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "Lcom/avito/android/permissions/LocationPermissionProvider;", "e", "Lcom/avito/android/permissions/LocationPermissionProvider;", "locationPermissionProvider", "Lkotlin/Lazy;", "Lcom/google/android/material/snackbar/Snackbar;", "d", "Lkotlin/Lazy;", "snackbar", AuthSource.BOOKING_ORDER, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "<init>", "(Lcom/avito/android/permissions/LocationPermissionProvider;)V", "permissions_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPermissionDialogPresenterImpl implements LocationPermissionDialogPresenter {
    public final SnackBarCallbackObservable a = new SnackBarCallbackObservable();
    public LocationPermissionDialogPresenter.Router b;
    public LocationPermissionDialogPresenter.Subscriber c;
    public Lazy<? extends Snackbar> d;
    public final LocationPermissionProvider e;

    public static final class a<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Boolean> apply(Boolean bool) {
            return Singles.toSingle(bool);
        }
    }

    public static final class b<T> implements Consumer<Boolean> {
        public final /* synthetic */ LocationPermissionDialogPresenterImpl a;

        public b(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl) {
            this.a = locationPermissionDialogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "permissionsGranted");
            if (bool2.booleanValue()) {
                LocationPermissionDialogPresenter.Router router = this.a.b;
                if (router != null) {
                    router.findLocation();
                    return;
                }
                return;
            }
            LocationPermissionDialogPresenter.Subscriber subscriber = this.a.c;
            if (subscriber != null) {
                subscriber.onNotPermissionGranted();
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ LocationPermissionDialogPresenterImpl a;

        public c(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl) {
            this.a = locationPermissionDialogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            LocationPermissionDialogPresenter.Subscriber subscriber = this.a.c;
            if (subscriber != null) {
                subscriber.onLocationNotFound(th2.getMessage());
            }
            Logs.error(th2);
        }
    }

    @Inject
    public LocationPermissionDialogPresenterImpl(@NotNull LocationPermissionProvider locationPermissionProvider) {
        Intrinsics.checkNotNullParameter(locationPermissionProvider, "locationPermissionProvider");
        this.e = locationPermissionProvider;
    }

    public static final /* synthetic */ Lazy access$getSnackbar$p(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl) {
        Lazy<? extends Snackbar> lazy = locationPermissionDialogPresenterImpl.d;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbar");
        }
        return lazy;
    }

    public static final void access$showSnackbar(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl, View view) {
        Objects.requireNonNull(locationPermissionDialogPresenterImpl);
        Lazy<? extends Snackbar> lazy = t6.c.lazy(new a2.a.a.u1.a(locationPermissionDialogPresenterImpl, view));
        locationPermissionDialogPresenterImpl.d = lazy;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("snackbar");
        }
        SnackbarProxyKt.showSnackbar((Snackbar) lazy.getValue());
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    public void attachRouter(@NotNull LocationPermissionDialogPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    public void detachSubscriber() {
        this.c = null;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    @NotNull
    public Single<Boolean> requestLocation() {
        if (this.e.isPermissionGranted()) {
            return Singles.toSingle(Boolean.TRUE);
        }
        Single<R> flatMap = this.e.isPermissionsGrantedDialog().flatMap(a.a);
        Intrinsics.checkNotNullExpressionValue(flatMap, "locationPermissionProvid…flatMap { it.toSingle() }");
        return flatMap;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    public void setSubscriber(@NotNull LocationPermissionDialogPresenter.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.c = subscriber;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    @NotNull
    public Disposable subscriberChangeLocation() {
        Disposable subscribe = requestLocation().toObservable().subscribe(new b(this), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "requestLocation()\n      …ror(error)\n            })");
        return subscribe;
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter
    @NotNull
    public CompositeDisposable subscriberNotPermissionGranted(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Disposable subscribe = this.e.isRequestRationale().toObservable().subscribe(new a2.a.a.u1.b(this, view), new a2.a.a.u1.c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "locationPermissionProvid…ror(error)\n            })");
        Disposable subscribe2 = this.a.callbackObservable().subscribe(new d(this), e.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "locationPermissionSnackB…          }\n            )");
        return new CompositeDisposable(subscribe, subscribe2);
    }
}
