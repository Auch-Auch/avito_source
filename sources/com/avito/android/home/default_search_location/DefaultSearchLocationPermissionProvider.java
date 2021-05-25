package com.avito.android.home.default_search_location;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.funktionale.option.Option;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/home/default_search_location/DefaultSearchLocationPermissionProvider;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lorg/funktionale/option/Option;", "", "permissionStream", "()Lio/reactivex/rxjava3/core/Observable;", "", "sendEventFromFirstRun", "()V", "sendScreenExitAfterCoordinatesResolve", "getSendingUserCoordinates", "()Z", "setSendingUserCoordinates", "(Z)V", "sendingUserCoordinates", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface DefaultSearchLocationPermissionProvider {
    boolean getSendingUserCoordinates();

    @NotNull
    Observable<Option<Boolean>> permissionStream();

    void sendEventFromFirstRun();

    void sendScreenExitAfterCoordinatesResolve();

    void setSendingUserCoordinates(boolean z);
}
