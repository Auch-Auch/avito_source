package com.avito.android.item_visibility_tracker;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/item_visibility_tracker/TrackKey;", "Landroid/os/Parcelable;", "Ljava/lang/Class;", "component1", "()Ljava/lang/Class;", "", "component2", "()J", "itemClass", "itemId", "copy", "(Ljava/lang/Class;J)Lcom/avito/android/item_visibility_tracker/TrackKey;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/Class;", "getItemClass", AuthSource.BOOKING_ORDER, "J", "getItemId", "<init>", "(Ljava/lang/Class;J)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class TrackKey implements Parcelable {
    public static final Parcelable.Creator<TrackKey> CREATOR = new Creator();
    @NotNull
    public final Class<?> a;
    public final long b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TrackKey> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TrackKey createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TrackKey((Class) parcel.readSerializable(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TrackKey[] newArray(int i) {
            return new TrackKey[i];
        }
    }

    public TrackKey(@NotNull Class<?> cls, long j) {
        Intrinsics.checkNotNullParameter(cls, "itemClass");
        this.a = cls;
        this.b = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.item_visibility_tracker.TrackKey */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackKey copy$default(TrackKey trackKey, Class cls, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = trackKey.a;
        }
        if ((i & 2) != 0) {
            j = trackKey.b;
        }
        return trackKey.copy(cls, j);
    }

    @NotNull
    public final Class<?> component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    @NotNull
    public final TrackKey copy(@NotNull Class<?> cls, long j) {
        Intrinsics.checkNotNullParameter(cls, "itemClass");
        return new TrackKey(cls, j);
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
        if (!(obj instanceof TrackKey)) {
            return false;
        }
        TrackKey trackKey = (TrackKey) obj;
        return Intrinsics.areEqual(this.a, trackKey.a) && this.b == trackKey.b;
    }

    @NotNull
    public final Class<?> getItemClass() {
        return this.a;
    }

    public final long getItemId() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Class<?> cls = this.a;
        return ((cls != null ? cls.hashCode() : 0) * 31) + c.a(this.b);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TrackKey(itemClass=");
        L.append(this.a);
        L.append(", itemId=");
        return a.l(L, this.b, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.a);
        parcel.writeLong(this.b);
    }
}
