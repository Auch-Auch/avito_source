package com.avito.android.location_list;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/Location;", "selectedLocation", "", "showWholeLocations", "hasSearchArea", "", "categoryId", "trackLocationEvents", "Landroid/content/Intent;", "createLocationListIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/Location;ZZLjava/lang/String;Z)Landroid/content/Intent;", "location-list_release"}, k = 2, mv = {1, 4, 2})
public final class LocationListActivityKt {
    @NotNull
    public static final Intent createLocationListIntent(@NotNull Context context, @Nullable Location location, boolean z, boolean z2, @Nullable String str, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent putExtra = new Intent(context, LocationListActivity.class).putExtra("location", location).putExtra("show_whole_locations", z).putExtra("has_search_area", z2).putExtra("extra_category_id", str).putExtra("track_location_events", z3);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…NTS, trackLocationEvents)");
        return putExtra;
    }

    public static /* synthetic */ Intent createLocationListIntent$default(Context context, Location location, boolean z, boolean z2, String str, boolean z3, int i, Object obj) {
        return createLocationListIntent(context, location, z, z2, str, (i & 32) != 0 ? false : z3);
    }
}
