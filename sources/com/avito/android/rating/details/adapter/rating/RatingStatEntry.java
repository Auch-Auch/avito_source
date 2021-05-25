package com.avito.android.rating.details.adapter.rating;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/RatingStatEntry;", "Landroid/os/Parcelable;", "", "component1", "()I", "", "component2", "()F", "", "component3", "()Ljava/lang/String;", "rating", "counterProgress", "title", "copy", "(IFLjava/lang/String;)Lcom/avito/android/rating/details/adapter/rating/RatingStatEntry;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "F", "getCounterProgress", AuthSource.SEND_ABUSE, "I", "getRating", "c", "Ljava/lang/String;", "getTitle", "<init>", "(IFLjava/lang/String;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingStatEntry implements Parcelable {
    public static final Parcelable.Creator<RatingStatEntry> CREATOR = new Creator();
    public final int a;
    public final float b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RatingStatEntry> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingStatEntry createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RatingStatEntry(parcel.readInt(), parcel.readFloat(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingStatEntry[] newArray(int i) {
            return new RatingStatEntry[i];
        }
    }

    public RatingStatEntry(int i, float f, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = i;
        this.b = f;
        this.c = str;
    }

    public static /* synthetic */ RatingStatEntry copy$default(RatingStatEntry ratingStatEntry, int i, float f, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ratingStatEntry.a;
        }
        if ((i2 & 2) != 0) {
            f = ratingStatEntry.b;
        }
        if ((i2 & 4) != 0) {
            str = ratingStatEntry.c;
        }
        return ratingStatEntry.copy(i, f, str);
    }

    public final int component1() {
        return this.a;
    }

    public final float component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final RatingStatEntry copy(int i, float f, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        return new RatingStatEntry(i, f, str);
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
        if (!(obj instanceof RatingStatEntry)) {
            return false;
        }
        RatingStatEntry ratingStatEntry = (RatingStatEntry) obj;
        return this.a == ratingStatEntry.a && Float.compare(this.b, ratingStatEntry.b) == 0 && Intrinsics.areEqual(this.c, ratingStatEntry.c);
    }

    public final float getCounterProgress() {
        return this.b;
    }

    public final int getRating() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i1 = a.i1(this.b, this.a * 31, 31);
        String str = this.c;
        return i1 + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RatingStatEntry(rating=");
        L.append(this.a);
        L.append(", counterProgress=");
        L.append(this.b);
        L.append(", title=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
        parcel.writeString(this.c);
    }
}
