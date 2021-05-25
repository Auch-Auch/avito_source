package com.avito.android.analytics.inhouse_transport;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR$\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsStorageImpl;", "Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "", "storageFileName", "", "saveStorageFileName", "(Ljava/lang/String;)V", "Lcom/avito/android/util/preferences/Preferences;", "c", "Lcom/avito/android/util/preferences/Preferences;", "prefUtils", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "fileName", AuthSource.BOOKING_ORDER, "dirtyName", "", "value", "isDirty", "()Z", "setDirty", "(Z)V", "getStorageFileName", "()Ljava/lang/String;", "analyticsName", "<init>", "(Lcom/avito/android/util/preferences/Preferences;Ljava/lang/String;)V", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public final class InHouseAnalyticsStorageImpl implements InHouseAnalyticsSettingsStorage {
    public final String a;
    public final String b;
    public final Preferences c;

    public InHouseAnalyticsStorageImpl(@NotNull Preferences preferences, @NotNull String str) {
        Intrinsics.checkNotNullParameter(preferences, "prefUtils");
        Intrinsics.checkNotNullParameter(str, "analyticsName");
        this.c = preferences;
        this.a = a.c3(str, "_event_storage_file_name");
        this.b = a.c3(str, "_event_storage_is_dirty");
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage
    @Nullable
    public String getStorageFileName() {
        return this.c.getString(this.a);
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage
    public boolean isDirty() {
        return this.c.getBoolean(this.b, false);
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage
    public void saveStorageFileName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "storageFileName");
        this.c.putString(this.a, str);
    }

    @Override // com.avito.android.analytics.inhouse_transport.InHouseAnalyticsSettingsStorage
    public void setDirty(boolean z) {
        this.c.putBoolean(this.b, z);
    }
}
