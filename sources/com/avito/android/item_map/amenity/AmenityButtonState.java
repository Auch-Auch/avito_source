package com.avito.android.item_map.amenity;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.item_map.remote.model.AmenityPin;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJH\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010*R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b-\u0010.R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010,\u001a\u0004\b\u0010\u0010\u0004\"\u0004\b0\u0010.R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b5\u0010.¨\u00068"}, d2 = {"Lcom/avito/android/item_map/amenity/AmenityButtonState;", "Landroid/os/Parcelable;", "", "component1", "()Z", "Lcom/avito/android/item_map/amenity/ButtonViewState;", "component2", "()Lcom/avito/android/item_map/amenity/ButtonViewState;", "component3", "component4", "", "Lcom/avito/android/item_map/remote/model/AmenityPin;", "component5", "()Ljava/util/List;", "isStartOnStart", "viewState", "isLoading", "isLoaded", "cachedPins", "copy", "(ZLcom/avito/android/item_map/amenity/ButtonViewState;ZZLjava/util/List;)Lcom/avito/android/item_map/amenity/AmenityButtonState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/item_map/amenity/ButtonViewState;", "getViewState", "setViewState", "(Lcom/avito/android/item_map/amenity/ButtonViewState;)V", AuthSource.SEND_ABUSE, "Z", "setStartOnStart", "(Z)V", "c", "setLoading", "e", "Ljava/util/List;", "getCachedPins", "d", "setLoaded", "<init>", "(ZLcom/avito/android/item_map/amenity/ButtonViewState;ZZLjava/util/List;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
public final class AmenityButtonState implements Parcelable {
    public static final Parcelable.Creator<AmenityButtonState> CREATOR = new Creator();
    public boolean a;
    @NotNull
    public ButtonViewState b;
    public boolean c;
    public boolean d;
    @NotNull
    public final List<AmenityPin> e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AmenityButtonState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityButtonState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            boolean z = parcel.readInt() != 0;
            ButtonViewState buttonViewState = (ButtonViewState) Enum.valueOf(ButtonViewState.class, parcel.readString());
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AmenityPin) parcel.readParcelable(AmenityButtonState.class.getClassLoader()));
                readInt--;
            }
            return new AmenityButtonState(z, buttonViewState, z2, z3, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AmenityButtonState[] newArray(int i) {
            return new AmenityButtonState[i];
        }
    }

    public AmenityButtonState() {
        this(false, null, false, false, null, 31, null);
    }

    public AmenityButtonState(boolean z, @NotNull ButtonViewState buttonViewState, boolean z2, boolean z3, @NotNull List<AmenityPin> list) {
        Intrinsics.checkNotNullParameter(buttonViewState, "viewState");
        Intrinsics.checkNotNullParameter(list, "cachedPins");
        this.a = z;
        this.b = buttonViewState;
        this.c = z2;
        this.d = z3;
        this.e = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.item_map.amenity.AmenityButtonState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AmenityButtonState copy$default(AmenityButtonState amenityButtonState, boolean z, ButtonViewState buttonViewState, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = amenityButtonState.a;
        }
        if ((i & 2) != 0) {
            buttonViewState = amenityButtonState.b;
        }
        if ((i & 4) != 0) {
            z2 = amenityButtonState.c;
        }
        if ((i & 8) != 0) {
            z3 = amenityButtonState.d;
        }
        if ((i & 16) != 0) {
            list = amenityButtonState.e;
        }
        return amenityButtonState.copy(z, buttonViewState, z2, z3, list);
    }

    public final boolean component1() {
        return this.a;
    }

    @NotNull
    public final ButtonViewState component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @NotNull
    public final List<AmenityPin> component5() {
        return this.e;
    }

    @NotNull
    public final AmenityButtonState copy(boolean z, @NotNull ButtonViewState buttonViewState, boolean z2, boolean z3, @NotNull List<AmenityPin> list) {
        Intrinsics.checkNotNullParameter(buttonViewState, "viewState");
        Intrinsics.checkNotNullParameter(list, "cachedPins");
        return new AmenityButtonState(z, buttonViewState, z2, z3, list);
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
        if (!(obj instanceof AmenityButtonState)) {
            return false;
        }
        AmenityButtonState amenityButtonState = (AmenityButtonState) obj;
        return this.a == amenityButtonState.a && Intrinsics.areEqual(this.b, amenityButtonState.b) && this.c == amenityButtonState.c && this.d == amenityButtonState.d && Intrinsics.areEqual(this.e, amenityButtonState.e);
    }

    @NotNull
    public final List<AmenityPin> getCachedPins() {
        return this.e;
    }

    @NotNull
    public final ButtonViewState getViewState() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean z = this.a;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        ButtonViewState buttonViewState = this.b;
        int i6 = 0;
        int hashCode = (i5 + (buttonViewState != null ? buttonViewState.hashCode() : 0)) * 31;
        boolean z2 = this.c;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode + i7) * 31;
        boolean z3 = this.d;
        if (!z3) {
            i = z3 ? 1 : 0;
        }
        int i11 = (i10 + i) * 31;
        List<AmenityPin> list = this.e;
        if (list != null) {
            i6 = list.hashCode();
        }
        return i11 + i6;
    }

    public final boolean isLoaded() {
        return this.d;
    }

    public final boolean isLoading() {
        return this.c;
    }

    public final boolean isStartOnStart() {
        return this.a;
    }

    public final void setLoaded(boolean z) {
        this.d = z;
    }

    public final void setLoading(boolean z) {
        this.c = z;
    }

    public final void setStartOnStart(boolean z) {
        this.a = z;
    }

    public final void setViewState(@NotNull ButtonViewState buttonViewState) {
        Intrinsics.checkNotNullParameter(buttonViewState, "<set-?>");
        this.b = buttonViewState;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AmenityButtonState(isStartOnStart=");
        L.append(this.a);
        L.append(", viewState=");
        L.append(this.b);
        L.append(", isLoading=");
        L.append(this.c);
        L.append(", isLoaded=");
        L.append(this.d);
        L.append(", cachedPins=");
        return a.w(L, this.e, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeString(this.b.name());
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d ? 1 : 0);
        Iterator n0 = a.n0(this.e, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((AmenityPin) n0.next(), i);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmenityButtonState(boolean z, ButtonViewState buttonViewState, boolean z2, boolean z3, List list, int i, j jVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? ButtonViewState.UNPRESSED : buttonViewState, (i & 4) != 0 ? false : z2, (i & 8) == 0 ? z3 : false, (i & 16) != 0 ? new ArrayList() : list);
    }
}
