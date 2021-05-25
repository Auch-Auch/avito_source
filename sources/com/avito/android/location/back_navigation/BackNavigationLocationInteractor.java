package com.avito.android.location.back_navigation;

import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "", "", "key", "Lcom/avito/android/remote/model/Location;", "location", "", "setLocation", "(Ljava/lang/String;Lcom/avito/android/remote/model/Location;)V", "getLocation", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Location;", "user-location_release"}, k = 1, mv = {1, 4, 2})
public interface BackNavigationLocationInteractor {
    @Nullable
    Location getLocation(@NotNull String str);

    void setLocation(@NotNull String str, @NotNull Location location);
}
