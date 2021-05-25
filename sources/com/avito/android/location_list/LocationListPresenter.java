package com.avito.android.location_list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0005H&¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0005H&¢\u0006\u0004\b\"\u0010\t¨\u0006#"}, d2 = {"Lcom/avito/android/location_list/LocationListPresenter;", "Lcom/avito/android/location_list/LocationListener;", "Lcom/avito/android/location_list/LocationConfirmListener;", "Lcom/avito/android/location_list/LocationListView;", "listView", "", "handleAttachView", "(Lcom/avito/android/location_list/LocationListView;)V", "handleOnShow", "()V", "handleOnHide", "Landroid/os/Bundle;", "getState", "()Landroid/os/Bundle;", "Landroid/app/Activity;", "activity", "findLocation", "(Landroid/app/Activity;)V", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "handleDetach", "Lcom/avito/android/location_list/LocationListRouter;", "router", "handleAttachRouter", "(Lcom/avito/android/location_list/LocationListRouter;)V", "handleDetachRouter", "Landroid/content/Context;", "context", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "sendScreenExitAfterCoordinatesResolve", "subscribeOnNotPermissionGranted", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListPresenter extends LocationListener, LocationConfirmListener {
    void findLocation(@NotNull Activity activity);

    @NotNull
    Bundle getState();

    void handleAttachRouter(@NotNull LocationListRouter locationListRouter);

    void handleAttachView(@NotNull LocationListView locationListView);

    void handleDetach();

    void handleDetachRouter();

    void handleOnHide();

    void handleOnShow();

    void onLocationNotFound(@Nullable String str);

    void registerLocationReceiver(@NotNull Context context);

    void sendScreenExitAfterCoordinatesResolve();

    void subscribeOnNotPermissionGranted();

    void unregisterLocationReceiver(@NotNull Context context);
}
