package com.avito.android.advert.item.marketplace_delivery;

import com.avito.android.location.FileLocation;
import com.avito.android.location.FileLocationKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorageImpl;", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryStorage;", "Lcom/avito/android/remote/model/Location;", "location", "()Lcom/avito/android/remote/model/Location;", "", "saveLocation", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "preferences", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceDeliveryStorageImpl implements MarketplaceDeliveryStorage {
    public final Gson a = new Gson();
    public final Preferences b;

    @Inject
    public MarketplaceDeliveryStorageImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.b = preferences;
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage
    @Nullable
    public Location location() {
        String string = this.b.getString(MarketplaceDeliveryStorageKt.KEY_MARKETPLACE_USER_LOCATION);
        if (string == null) {
            return null;
        }
        try {
            FileLocation fileLocation = (FileLocation) this.a.fromJson(string, (Class<Object>) FileLocation.class);
            if (fileLocation == null) {
                return null;
            }
            Location location = FileLocationKt.toLocation(fileLocation);
            if (location.getId().length() > 0) {
                return location;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage
    public void saveLocation(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.b.putString(MarketplaceDeliveryStorageKt.KEY_MARKETPLACE_USER_LOCATION, this.a.toJson(FileLocationKt.toFileLocation(location, System.currentTimeMillis())));
    }
}
