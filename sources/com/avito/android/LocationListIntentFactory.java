package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/LocationListIntentFactory;", "", "Lcom/avito/android/remote/model/Location;", "location", "Landroid/content/Intent;", "defaultLocationIntent", "(Lcom/avito/android/remote/model/Location;)Landroid/content/Intent;", "", "showWholeLocations", "hasSearchArea", "", "categoryId", "trackLocationEvents", "locationIntent", "(Lcom/avito/android/remote/model/Location;ZZLjava/lang/String;Z)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface LocationListIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent locationIntent$default(LocationListIntentFactory locationListIntentFactory, Location location, boolean z, boolean z2, String str, boolean z3, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str = null;
                }
                return locationListIntentFactory.locationIntent(location, z, z2, str, (i & 16) != 0 ? false : z3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: locationIntent");
        }
    }

    @NotNull
    Intent defaultLocationIntent(@Nullable Location location);

    @NotNull
    Intent locationIntent(@Nullable Location location, boolean z, boolean z2, @Nullable String str, boolean z3);
}
