package com.avito.android.location_list;

import android.os.Bundle;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ)\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00060\u00052\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00060\u00052\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\u00060\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H&¢\u0006\u0004\b\u0018\u0010\u0017J#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u001a\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/avito/android/location_list/LocationListInteractor;", "", "", "lat", MessageBody.Location.LONGITUDE, "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/Location;", "getNearestLocation", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "searchQuery", "", "getSearchLocations", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/os/Bundle;", "getState", "()Landroid/os/Bundle;", "getUsedLocations", "(Ljava/lang/String;)Ljava/util/List;", "parent", "getChildrenLocations", "(Lcom/avito/android/remote/model/Location;)Lio/reactivex/Observable;", "getTopLocations", "()Lio/reactivex/Observable;", "getTopLocation", "locationId", "getLocation", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListInteractor {
    @NotNull
    Observable<LoadingState<List<Location>>> getChildrenLocations(@NotNull Location location);

    @NotNull
    Observable<LoadingState<Location>> getLocation(@NotNull String str);

    @NotNull
    Observable<LoadingState<Location>> getNearestLocation(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<List<Location>>> getSearchLocations(@NotNull String str);

    @NotNull
    Bundle getState();

    @NotNull
    Observable<LoadingState<Location>> getTopLocation();

    @NotNull
    Observable<LoadingState<List<Location>>> getTopLocations();

    @Nullable
    List<Location> getUsedLocations(@NotNull String str);
}
