package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.teaser.ReportLink;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/AutotekaTeaserGallery;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/teaser/ReportLink;", "component3", "()Lcom/avito/android/remote/model/teaser/ReportLink;", "title", MessengerShareContentUtility.SUBTITLE, "reportLink", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/teaser/ReportLink;)Lcom/avito/android/remote/model/AutotekaTeaserGallery;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/teaser/ReportLink;", "getReportLink", "Ljava/lang/String;", "getTitle", "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/teaser/ReportLink;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserGallery implements Parcelable {
    public static final Parcelable.Creator<AutotekaTeaserGallery> CREATOR = new Creator();
    @SerializedName("reportLink")
    @NotNull
    private final ReportLink reportLink;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaTeaserGallery> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserGallery createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AutotekaTeaserGallery(parcel.readString(), parcel.readString(), (ReportLink) parcel.readParcelable(AutotekaTeaserGallery.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserGallery[] newArray(int i) {
            return new AutotekaTeaserGallery[i];
        }
    }

    public AutotekaTeaserGallery(@NotNull String str, @NotNull String str2, @NotNull ReportLink reportLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(reportLink2, "reportLink");
        this.title = str;
        this.subtitle = str2;
        this.reportLink = reportLink2;
    }

    public static /* synthetic */ AutotekaTeaserGallery copy$default(AutotekaTeaserGallery autotekaTeaserGallery, String str, String str2, ReportLink reportLink2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autotekaTeaserGallery.title;
        }
        if ((i & 2) != 0) {
            str2 = autotekaTeaserGallery.subtitle;
        }
        if ((i & 4) != 0) {
            reportLink2 = autotekaTeaserGallery.reportLink;
        }
        return autotekaTeaserGallery.copy(str, str2, reportLink2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final ReportLink component3() {
        return this.reportLink;
    }

    @NotNull
    public final AutotekaTeaserGallery copy(@NotNull String str, @NotNull String str2, @NotNull ReportLink reportLink2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(reportLink2, "reportLink");
        return new AutotekaTeaserGallery(str, str2, reportLink2);
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
        if (!(obj instanceof AutotekaTeaserGallery)) {
            return false;
        }
        AutotekaTeaserGallery autotekaTeaserGallery = (AutotekaTeaserGallery) obj;
        return Intrinsics.areEqual(this.title, autotekaTeaserGallery.title) && Intrinsics.areEqual(this.subtitle, autotekaTeaserGallery.subtitle) && Intrinsics.areEqual(this.reportLink, autotekaTeaserGallery.reportLink);
    }

    @NotNull
    public final ReportLink getReportLink() {
        return this.reportLink;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ReportLink reportLink2 = this.reportLink;
        if (reportLink2 != null) {
            i = reportLink2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaTeaserGallery(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", reportLink=");
        L.append(this.reportLink);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.reportLink, i);
    }
}
