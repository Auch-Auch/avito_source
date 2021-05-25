package com.avito.android.location_list;

import android.app.Application;
import android.content.Intent;
import com.avito.android.LocationListIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/location_list/LocationListIntentFactoryImpl;", "Lcom/avito/android/LocationListIntentFactory;", "Lcom/avito/android/remote/model/Location;", "location", "Landroid/content/Intent;", "defaultLocationIntent", "(Lcom/avito/android/remote/model/Location;)Landroid/content/Intent;", "", "showWholeLocations", "hasSearchArea", "", "categoryId", "trackLocationEvents", "locationIntent", "(Lcom/avito/android/remote/model/Location;ZZLjava/lang/String;Z)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "location-list_release"}, k = 1, mv = {1, 4, 2})
public final class LocationListIntentFactoryImpl implements LocationListIntentFactory {
    public final Application a;

    @Inject
    public LocationListIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.LocationListIntentFactory
    @NotNull
    public Intent defaultLocationIntent(@Nullable Location location) {
        return LocationListIntentFactory.DefaultImpls.locationIntent$default(this, location, true, false, null, false, 16, null);
    }

    @Override // com.avito.android.LocationListIntentFactory
    @NotNull
    public Intent locationIntent(@Nullable Location location, boolean z, boolean z2, @Nullable String str, boolean z3) {
        return LocationListActivityKt.createLocationListIntent(this.a, location, z, z2, str, z3);
    }
}
