package com.avito.android.location;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/location/SavedLocation;", "", "Lcom/avito/android/remote/model/Location;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "location", "", "c", "Z", "getForcedByUser", "()Z", "setForcedByUser", "(Z)V", "forcedByUser", AuthSource.BOOKING_ORDER, "getActual", "actual", "<init>", "(Lcom/avito/android/remote/model/Location;ZZ)V", "user-location_release"}, k = 1, mv = {1, 4, 2})
public final class SavedLocation {
    @NotNull
    public final Location a;
    public final boolean b;
    public boolean c;

    public SavedLocation(@NotNull Location location, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.a = location;
        this.b = z;
        this.c = z2;
    }

    public final boolean getActual() {
        return this.b;
    }

    public final boolean getForcedByUser() {
        return this.c;
    }

    @NotNull
    public final Location getLocation() {
        return this.a;
    }

    public final void setForcedByUser(boolean z) {
        this.c = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SavedLocation(Location location, boolean z, boolean z2, int i, j jVar) {
        this(location, z, (i & 4) != 0 ? false : z2);
    }
}
