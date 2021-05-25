package com.avito.android.location;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location/SavedLocationMigrationHelperImpl;", "Lcom/avito/android/location/SavedLocationMigrationHelper;", "", "migrateFrom2to3version", "()V", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/util/preferences/Preferences;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/preferences/Preferences;", "prefs", "<init>", "(Lcom/avito/android/util/preferences/Preferences;)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class SavedLocationMigrationHelperImpl implements SavedLocationMigrationHelper {
    @NotNull
    public final Gson a = new Gson();
    public final Preferences b;

    public SavedLocationMigrationHelperImpl(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        this.b = preferences;
    }

    @NotNull
    public final Gson getGson() {
        return this.a;
    }

    @Override // com.avito.android.location.SavedLocationMigrationHelper
    public void migrateFrom2to3version() {
        String string = this.b.getString(Preference.LOCATION_JSON);
        if (string != null) {
            try {
                FileLocation fileLocation = (FileLocation) this.a.fromJson(string, (Class<Object>) FileLocation.class);
                if (fileLocation != null) {
                    Preferences preferences = this.b;
                    preferences.putInt(Preference.LOCATION_VERSION, 3);
                    preferences.putString(LocationSource.LOCATION_FROM_LIST.getValue(), this.a.toJson(fileLocation));
                }
            } catch (Throwable unused) {
            }
        }
        this.b.remove(Preference.LOCATION_JSON);
    }
}
