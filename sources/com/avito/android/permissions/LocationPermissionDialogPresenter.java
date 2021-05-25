package com.avito.android.permissions;

import android.view.View;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u001a\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "", "Lio/reactivex/rxjava3/core/Single;", "", "requestLocation", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "router", "", "attachRouter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;)V", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "subscriber", "setSubscriber", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;)V", "detachRouter", "()V", "detachSubscriber", "Lio/reactivex/rxjava3/disposables/Disposable;", "subscriberChangeLocation", "()Lio/reactivex/rxjava3/disposables/Disposable;", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriberNotPermissionGranted", "(Landroid/view/View;)Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Router", "Subscriber", "permissions_release"}, k = 1, mv = {1, 4, 2})
public interface LocationPermissionDialogPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "", "", "findLocation", "()V", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void findLocation();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "", "", "onClickLocationSnackbar", "()V", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public interface Subscriber {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static /* synthetic */ void onLocationNotFound$default(Subscriber subscriber, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    subscriber.onLocationNotFound(str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onLocationNotFound");
            }
        }

        void onClickLocationSnackbar();

        void onLocationNotFound(@Nullable String str);

        void onNotPermissionGranted();
    }

    void attachRouter(@NotNull Router router);

    void detachRouter();

    void detachSubscriber();

    @NotNull
    Single<Boolean> requestLocation();

    void setSubscriber(@NotNull Subscriber subscriber);

    @NotNull
    Disposable subscriberChangeLocation();

    @NotNull
    CompositeDisposable subscriberNotPermissionGranted(@NotNull View view);
}
