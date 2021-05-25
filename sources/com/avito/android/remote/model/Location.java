package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\b\b\u0018\u0000 O2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001OBm\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0019\u0012\b\b\u0002\u0010,\u001a\u00020\f\u0012\b\b\u0002\u0010-\u001a\u00020\f\u0012\b\b\u0002\u0010.\u001a\u00020\f\u0012\b\b\u0002\u0010/\u001a\u00020\f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u00101\u001a\u00020\f\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\fHÆ\u0003¢\u0006\u0004\b \u0010\u001dJ\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b$\u0010\u001dJ\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b(\u0010)Jz\u00104\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020\f2\b\b\u0002\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u00020\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010!2\b\b\u0002\u00101\u001a\u00020\f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010%2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b4\u00105R\u001c\u00108\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\f\u0012\u0004\b6\u00107\u001a\u0004\b\u0006\u0010\u0010R\u0019\u0010.\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b.\u00109\u001a\u0004\b:\u0010\u001dR$\u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010;\u001a\u0004\b<\u0010)\"\u0004\b=\u0010>R\u0019\u0010,\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u00109\u001a\u0004\b?\u0010\u001dR\u001b\u00100\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010@\u001a\u0004\bA\u0010#R\u001b\u00102\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010B\u001a\u0004\bC\u0010'R\"\u00101\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u00109\u001a\u0004\bD\u0010\u001d\"\u0004\bE\u0010FR\u0019\u0010-\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u00109\u001a\u0004\bG\u0010\u001dR\u0019\u0010+\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010H\u001a\u0004\bI\u0010\u001bR\u001c\u0010*\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bK\u0010\u0010R\u0019\u0010/\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00109\u001a\u0004\bL\u0010\u001d¨\u0006P"}, d2 = {"Lcom/avito/android/remote/model/Location;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Entity;", "", "", "nameCase", "getName", "(I)Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "Lcom/avito/android/remote/model/CaseText;", "component2", "()Lcom/avito/android/remote/model/CaseText;", "component3", "()Z", "component4", "component5", "component6", "Lcom/avito/android/remote/model/SimpleLocation;", "component7", "()Lcom/avito/android/remote/model/SimpleLocation;", "component8", "Lcom/avito/android/remote/model/Coordinates;", "component9", "()Lcom/avito/android/remote/model/Coordinates;", "component10", "()Ljava/lang/Boolean;", "id", "names", "hasMetro", "hasChildren", "hasDirections", "hasDistricts", "parent", "forcedByUser", "coordinates", "forcedLocationForRecommendation", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;ZZZZLcom/avito/android/remote/model/SimpleLocation;ZLcom/avito/android/remote/model/Coordinates;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/Location;", "getName$annotations", "()V", "name", "Z", "getHasDirections", "Ljava/lang/Boolean;", "getForcedLocationForRecommendation", "setForcedLocationForRecommendation", "(Ljava/lang/Boolean;)V", "getHasMetro", "Lcom/avito/android/remote/model/SimpleLocation;", "getParent", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "getForcedByUser", "setForcedByUser", "(Z)V", "getHasChildren", "Lcom/avito/android/remote/model/CaseText;", "getNames", "Ljava/lang/String;", "getId", "getHasDistricts", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/CaseText;ZZZZLcom/avito/android/remote/model/SimpleLocation;ZLcom/avito/android/remote/model/Coordinates;Ljava/lang/Boolean;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Location implements Parcelable, Entity<String> {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Location> CREATOR = Parcels.creator(Location$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Coordinates coordinates;
    private boolean forcedByUser;
    @Nullable
    private Boolean forcedLocationForRecommendation;
    private final boolean hasChildren;
    private final boolean hasDirections;
    private final boolean hasDistricts;
    private final boolean hasMetro;
    @NotNull
    private final String id;
    @NotNull
    private final CaseText names;
    @Nullable
    private final SimpleLocation parent;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/Location$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/Location;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public Location(@NotNull String str, @NotNull CaseText caseText, boolean z, boolean z2, boolean z3, boolean z4, @Nullable SimpleLocation simpleLocation, boolean z5, @Nullable Coordinates coordinates2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        this.id = str;
        this.names = caseText;
        this.hasMetro = z;
        this.hasChildren = z2;
        this.hasDirections = z3;
        this.hasDistricts = z4;
        this.parent = simpleLocation;
        this.forcedByUser = z5;
        this.coordinates = coordinates2;
        this.forcedLocationForRecommendation = bool;
    }

    public static /* synthetic */ Location copy$default(Location location, String str, CaseText caseText, boolean z, boolean z2, boolean z3, boolean z4, SimpleLocation simpleLocation, boolean z5, Coordinates coordinates2, Boolean bool, int i, Object obj) {
        return location.copy((i & 1) != 0 ? location.getId() : str, (i & 2) != 0 ? location.names : caseText, (i & 4) != 0 ? location.hasMetro : z, (i & 8) != 0 ? location.hasChildren : z2, (i & 16) != 0 ? location.hasDirections : z3, (i & 32) != 0 ? location.hasDistricts : z4, (i & 64) != 0 ? location.parent : simpleLocation, (i & 128) != 0 ? location.forcedByUser : z5, (i & 256) != 0 ? location.coordinates : coordinates2, (i & 512) != 0 ? location.forcedLocationForRecommendation : bool);
    }

    public static /* synthetic */ void getName$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final Boolean component10() {
        return this.forcedLocationForRecommendation;
    }

    @NotNull
    public final CaseText component2() {
        return this.names;
    }

    public final boolean component3() {
        return this.hasMetro;
    }

    public final boolean component4() {
        return this.hasChildren;
    }

    public final boolean component5() {
        return this.hasDirections;
    }

    public final boolean component6() {
        return this.hasDistricts;
    }

    @Nullable
    public final SimpleLocation component7() {
        return this.parent;
    }

    public final boolean component8() {
        return this.forcedByUser;
    }

    @Nullable
    public final Coordinates component9() {
        return this.coordinates;
    }

    @NotNull
    public final Location copy(@NotNull String str, @NotNull CaseText caseText, boolean z, boolean z2, boolean z3, boolean z4, @Nullable SimpleLocation simpleLocation, boolean z5, @Nullable Coordinates coordinates2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(caseText, "names");
        return new Location(str, caseText, z, z2, z3, z4, simpleLocation, z5, coordinates2, bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Location)) {
            return Intrinsics.areEqual(((Location) obj).getId(), getId());
        }
        return false;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    public final boolean getForcedByUser() {
        return this.forcedByUser;
    }

    @Nullable
    public final Boolean getForcedLocationForRecommendation() {
        return this.forcedLocationForRecommendation;
    }

    public final boolean getHasChildren() {
        return this.hasChildren;
    }

    public final boolean getHasDirections() {
        return this.hasDirections;
    }

    public final boolean getHasDistricts() {
        return this.hasDistricts;
    }

    public final boolean getHasMetro() {
        return this.hasMetro;
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getName() {
        String name;
        CaseText caseText = this.names;
        return (caseText == null || (name = caseText.getName()) == null) ? "" : name;
    }

    @NotNull
    public final CaseText getNames() {
        return this.names;
    }

    @Nullable
    public final SimpleLocation getParent() {
        return this.parent;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getId().hashCode() + 31;
    }

    public final void setForcedByUser(boolean z) {
        this.forcedByUser = z;
    }

    public final void setForcedLocationForRecommendation(@Nullable Boolean bool) {
        this.forcedLocationForRecommendation = bool;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Location[");
        L.append(getId());
        L.append(", ");
        L.append(getName());
        L.append(']');
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getId());
        parcel.writeParcelable(this.names, i);
        ParcelsKt.writeBool(parcel, this.hasMetro);
        ParcelsKt.writeBool(parcel, this.hasChildren);
        ParcelsKt.writeBool(parcel, this.hasDirections);
        ParcelsKt.writeBool(parcel, this.hasDistricts);
        parcel.writeParcelable(this.parent, i);
        ParcelsKt.writeBool(parcel, this.forcedByUser);
        ParcelsKt.writeNullableValue(parcel, this.coordinates);
        ParcelsKt.writeNullableValue(parcel, this.forcedLocationForRecommendation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Location(String str, CaseText caseText, boolean z, boolean z2, boolean z3, boolean z4, SimpleLocation simpleLocation, boolean z5, Coordinates coordinates2, Boolean bool, int i, j jVar) {
        this(str, caseText, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? null : simpleLocation, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? null : coordinates2, (i & 512) != 0 ? null : bool);
    }

    @Override // com.avito.android.remote.model.Entity
    @NotNull
    public String getId() {
        return this.id;
    }

    @Nullable
    public final String getName(int i) {
        return this.names.getName(i);
    }
}
