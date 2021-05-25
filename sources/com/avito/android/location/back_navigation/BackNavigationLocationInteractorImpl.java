package com.avito.android.location.back_navigation;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractorImpl;", "Lcom/avito/android/location/back_navigation/BackNavigationLocationInteractor;", "", "key", "Lcom/avito/android/remote/model/Location;", "location", "", "setLocation", "(Ljava/lang/String;Lcom/avito/android/remote/model/Location;)V", "getLocation", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Location;", "Lcom/avito/android/location/back_navigation/BackNavigationLocationStorage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/location/back_navigation/BackNavigationLocationStorage;", "backNavigationLocationStorage", "<init>", "(Lcom/avito/android/location/back_navigation/BackNavigationLocationStorage;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class BackNavigationLocationInteractorImpl implements BackNavigationLocationInteractor {
    public final BackNavigationLocationStorage a;

    @Inject
    public BackNavigationLocationInteractorImpl(@NotNull BackNavigationLocationStorage backNavigationLocationStorage) {
        Intrinsics.checkNotNullParameter(backNavigationLocationStorage, "backNavigationLocationStorage");
        this.a = backNavigationLocationStorage;
    }

    @Override // com.avito.android.location.back_navigation.BackNavigationLocationInteractor
    @Nullable
    public Location getLocation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.a.getLocationForSearch(str);
    }

    @Override // com.avito.android.location.back_navigation.BackNavigationLocationInteractor
    public void setLocation(@NotNull String str, @NotNull Location location) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(location, "location");
        this.a.setLocation(str, location);
    }
}
