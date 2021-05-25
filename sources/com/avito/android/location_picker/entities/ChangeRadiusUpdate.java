package com.avito.android.location_picker.entities;

import a2.b.a.a.a;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchRadius;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u000b¨\u0006&"}, d2 = {"Lcom/avito/android/location_picker/entities/ChangeRadiusUpdate;", "", "", "Lcom/avito/android/remote/model/SearchRadius;", "component1", "()Ljava/util/List;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "component2", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "", "component3", "()Ljava/lang/Long;", "searchRadiusList", "mapBounds", "distanceInMeters", "copy", "(Ljava/util/List;Lcom/avito/android/avito_map/AvitoMapBounds;Ljava/lang/Long;)Lcom/avito/android/location_picker/entities/ChangeRadiusUpdate;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getSearchRadiusList", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapBounds;", "getMapBounds", "c", "Ljava/lang/Long;", "getDistanceInMeters", "<init>", "(Ljava/util/List;Lcom/avito/android/avito_map/AvitoMapBounds;Ljava/lang/Long;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ChangeRadiusUpdate {
    @NotNull
    public final List<SearchRadius> a;
    @Nullable
    public final AvitoMapBounds b;
    @Nullable
    public final Long c;

    public ChangeRadiusUpdate(@NotNull List<SearchRadius> list, @Nullable AvitoMapBounds avitoMapBounds, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(list, "searchRadiusList");
        this.a = list;
        this.b = avitoMapBounds;
        this.c = l;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.location_picker.entities.ChangeRadiusUpdate */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeRadiusUpdate copy$default(ChangeRadiusUpdate changeRadiusUpdate, List list, AvitoMapBounds avitoMapBounds, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            list = changeRadiusUpdate.a;
        }
        if ((i & 2) != 0) {
            avitoMapBounds = changeRadiusUpdate.b;
        }
        if ((i & 4) != 0) {
            l = changeRadiusUpdate.c;
        }
        return changeRadiusUpdate.copy(list, avitoMapBounds, l);
    }

    @NotNull
    public final List<SearchRadius> component1() {
        return this.a;
    }

    @Nullable
    public final AvitoMapBounds component2() {
        return this.b;
    }

    @Nullable
    public final Long component3() {
        return this.c;
    }

    @NotNull
    public final ChangeRadiusUpdate copy(@NotNull List<SearchRadius> list, @Nullable AvitoMapBounds avitoMapBounds, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(list, "searchRadiusList");
        return new ChangeRadiusUpdate(list, avitoMapBounds, l);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeRadiusUpdate)) {
            return false;
        }
        ChangeRadiusUpdate changeRadiusUpdate = (ChangeRadiusUpdate) obj;
        return Intrinsics.areEqual(this.a, changeRadiusUpdate.a) && Intrinsics.areEqual(this.b, changeRadiusUpdate.b) && Intrinsics.areEqual(this.c, changeRadiusUpdate.c);
    }

    @Nullable
    public final Long getDistanceInMeters() {
        return this.c;
    }

    @Nullable
    public final AvitoMapBounds getMapBounds() {
        return this.b;
    }

    @NotNull
    public final List<SearchRadius> getSearchRadiusList() {
        return this.a;
    }

    public int hashCode() {
        List<SearchRadius> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        AvitoMapBounds avitoMapBounds = this.b;
        int hashCode2 = (hashCode + (avitoMapBounds != null ? avitoMapBounds.hashCode() : 0)) * 31;
        Long l = this.c;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChangeRadiusUpdate(searchRadiusList=");
        L.append(this.a);
        L.append(", mapBounds=");
        L.append(this.b);
        L.append(", distanceInMeters=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
