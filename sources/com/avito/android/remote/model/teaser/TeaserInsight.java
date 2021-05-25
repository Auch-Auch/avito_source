package com.avito.android.remote.model.teaser;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/teaser/TeaserInsight;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/teaser/TeaserStatus;", "component2", "()Lcom/avito/android/remote/model/teaser/TeaserStatus;", "text", "status", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/teaser/TeaserStatus;)Lcom/avito/android/remote/model/teaser/TeaserInsight;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "Lcom/avito/android/remote/model/teaser/TeaserStatus;", "getStatus", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/teaser/TeaserStatus;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TeaserInsight implements Parcelable {
    public static final Parcelable.Creator<TeaserInsight> CREATOR = new Creator();
    @SerializedName("status")
    @NotNull
    private final TeaserStatus status;
    @SerializedName("text")
    @NotNull
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TeaserInsight> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TeaserInsight createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new TeaserInsight(parcel.readString(), (TeaserStatus) Enum.valueOf(TeaserStatus.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TeaserInsight[] newArray(int i) {
            return new TeaserInsight[i];
        }
    }

    public TeaserInsight(@NotNull String str, @NotNull TeaserStatus teaserStatus) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(teaserStatus, "status");
        this.text = str;
        this.status = teaserStatus;
    }

    public static /* synthetic */ TeaserInsight copy$default(TeaserInsight teaserInsight, String str, TeaserStatus teaserStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teaserInsight.text;
        }
        if ((i & 2) != 0) {
            teaserStatus = teaserInsight.status;
        }
        return teaserInsight.copy(str, teaserStatus);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final TeaserStatus component2() {
        return this.status;
    }

    @NotNull
    public final TeaserInsight copy(@NotNull String str, @NotNull TeaserStatus teaserStatus) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(teaserStatus, "status");
        return new TeaserInsight(str, teaserStatus);
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
        if (!(obj instanceof TeaserInsight)) {
            return false;
        }
        TeaserInsight teaserInsight = (TeaserInsight) obj;
        return Intrinsics.areEqual(this.text, teaserInsight.text) && Intrinsics.areEqual(this.status, teaserInsight.status);
    }

    @NotNull
    public final TeaserStatus getStatus() {
        return this.status;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        TeaserStatus teaserStatus = this.status;
        if (teaserStatus != null) {
            i = teaserStatus.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("TeaserInsight(text=");
        L.append(this.text);
        L.append(", status=");
        L.append(this.status);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.text);
        parcel.writeString(this.status.name());
    }
}
