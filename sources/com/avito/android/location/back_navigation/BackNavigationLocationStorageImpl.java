package com.avito.android.location.back_navigation;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR2\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/location/back_navigation/BackNavigationLocationStorageImpl;", "Lcom/avito/android/location/back_navigation/BackNavigationLocationStorage;", "", "key", "Lcom/avito/android/remote/model/Location;", "location", "", "setLocation", "(Ljava/lang/String;Lcom/avito/android/remote/model/Location;)V", "getLocationForSearch", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Location;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", AuthSource.SEND_ABUSE, "Ljava/util/HashMap;", "locations", "<init>", "()V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class BackNavigationLocationStorageImpl implements BackNavigationLocationStorage {
    public final HashMap<String, Location> a = new HashMap<>();

    @Override // com.avito.android.location.back_navigation.BackNavigationLocationStorage
    @Nullable
    public Location getLocationForSearch(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.get(str);
    }

    @Override // com.avito.android.location.back_navigation.BackNavigationLocationStorage
    public void setLocation(@NotNull String str, @NotNull Location location) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(location, "location");
        this.a.put(str, location);
    }
}
