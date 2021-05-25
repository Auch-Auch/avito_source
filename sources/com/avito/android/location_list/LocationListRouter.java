package com.avito.android.location_list;

import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/location_list/LocationListRouter;", "", "", "finish", "()V", "Lcom/avito/android/remote/model/Location;", "location", "showLocationConfirmDialog", "(Lcom/avito/android/remote/model/Location;)V", "showLocationSettings", "showApplicationPermissionsSettings", "location-list_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListRouter {
    void finish();

    void showApplicationPermissionsSettings();

    void showLocationConfirmDialog(@Nullable Location location);

    void showLocationSettings();
}
