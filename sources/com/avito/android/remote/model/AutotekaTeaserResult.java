package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.teaser.ReportLink;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JV\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0016\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0016\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u0010\u000fR\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b1\u0010\u0004R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\u0012R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u00104\u001a\u0004\b5\u0010\t¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/AutotekaTeaserResult;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/model/teaser/ReportLink;", "component4", "()Lcom/avito/android/remote/model/teaser/ReportLink;", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "component5", "()Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "Lcom/avito/android/remote/model/AutotekaTeaserGallery;", "component6", "()Lcom/avito/android/remote/model/AutotekaTeaserGallery;", "title", "subTitle", "insights", "reportLink", "cpo", "gallery", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/teaser/ReportLink;Lcom/avito/android/remote/model/AutotekaCpoTeaser;Lcom/avito/android/remote/model/AutotekaTeaserGallery;)Lcom/avito/android/remote/model/AutotekaTeaserResult;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/teaser/ReportLink;", "getReportLink", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "getCpo", "getSubTitle", "Lcom/avito/android/remote/model/AutotekaTeaserGallery;", "getGallery", "Ljava/util/List;", "getInsights", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/teaser/ReportLink;Lcom/avito/android/remote/model/AutotekaCpoTeaser;Lcom/avito/android/remote/model/AutotekaTeaserGallery;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserResult implements Parcelable {
    public static final Parcelable.Creator<AutotekaTeaserResult> CREATOR = new Creator();
    @SerializedName("cpo")
    @Nullable
    private final AutotekaCpoTeaser cpo;
    @SerializedName("galleryInsight")
    @Nullable
    private final AutotekaTeaserGallery gallery;
    @SerializedName("insights")
    @NotNull
    private final List<TeaserInsight> insights;
    @SerializedName("reportLink")
    @NotNull
    private final ReportLink reportLink;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subTitle;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaTeaserResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((TeaserInsight) parcel.readParcelable(AutotekaTeaserResult.class.getClassLoader()));
                readInt--;
            }
            return new AutotekaTeaserResult(readString, readString2, arrayList, (ReportLink) parcel.readParcelable(AutotekaTeaserResult.class.getClassLoader()), parcel.readInt() != 0 ? AutotekaCpoTeaser.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AutotekaTeaserGallery.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserResult[] newArray(int i) {
            return new AutotekaTeaserResult[i];
        }
    }

    public AutotekaTeaserResult(@NotNull String str, @NotNull String str2, @NotNull List<TeaserInsight> list, @NotNull ReportLink reportLink2, @Nullable AutotekaCpoTeaser autotekaCpoTeaser, @Nullable AutotekaTeaserGallery autotekaTeaserGallery) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(list, "insights");
        Intrinsics.checkNotNullParameter(reportLink2, "reportLink");
        this.title = str;
        this.subTitle = str2;
        this.insights = list;
        this.reportLink = reportLink2;
        this.cpo = autotekaCpoTeaser;
        this.gallery = autotekaTeaserGallery;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.AutotekaTeaserResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutotekaTeaserResult copy$default(AutotekaTeaserResult autotekaTeaserResult, String str, String str2, List list, ReportLink reportLink2, AutotekaCpoTeaser autotekaCpoTeaser, AutotekaTeaserGallery autotekaTeaserGallery, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autotekaTeaserResult.title;
        }
        if ((i & 2) != 0) {
            str2 = autotekaTeaserResult.subTitle;
        }
        if ((i & 4) != 0) {
            list = autotekaTeaserResult.insights;
        }
        if ((i & 8) != 0) {
            reportLink2 = autotekaTeaserResult.reportLink;
        }
        if ((i & 16) != 0) {
            autotekaCpoTeaser = autotekaTeaserResult.cpo;
        }
        if ((i & 32) != 0) {
            autotekaTeaserGallery = autotekaTeaserResult.gallery;
        }
        return autotekaTeaserResult.copy(str, str2, list, reportLink2, autotekaCpoTeaser, autotekaTeaserGallery);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subTitle;
    }

    @NotNull
    public final List<TeaserInsight> component3() {
        return this.insights;
    }

    @NotNull
    public final ReportLink component4() {
        return this.reportLink;
    }

    @Nullable
    public final AutotekaCpoTeaser component5() {
        return this.cpo;
    }

    @Nullable
    public final AutotekaTeaserGallery component6() {
        return this.gallery;
    }

    @NotNull
    public final AutotekaTeaserResult copy(@NotNull String str, @NotNull String str2, @NotNull List<TeaserInsight> list, @NotNull ReportLink reportLink2, @Nullable AutotekaCpoTeaser autotekaCpoTeaser, @Nullable AutotekaTeaserGallery autotekaTeaserGallery) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(list, "insights");
        Intrinsics.checkNotNullParameter(reportLink2, "reportLink");
        return new AutotekaTeaserResult(str, str2, list, reportLink2, autotekaCpoTeaser, autotekaTeaserGallery);
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
        if (!(obj instanceof AutotekaTeaserResult)) {
            return false;
        }
        AutotekaTeaserResult autotekaTeaserResult = (AutotekaTeaserResult) obj;
        return Intrinsics.areEqual(this.title, autotekaTeaserResult.title) && Intrinsics.areEqual(this.subTitle, autotekaTeaserResult.subTitle) && Intrinsics.areEqual(this.insights, autotekaTeaserResult.insights) && Intrinsics.areEqual(this.reportLink, autotekaTeaserResult.reportLink) && Intrinsics.areEqual(this.cpo, autotekaTeaserResult.cpo) && Intrinsics.areEqual(this.gallery, autotekaTeaserResult.gallery);
    }

    @Nullable
    public final AutotekaCpoTeaser getCpo() {
        return this.cpo;
    }

    @Nullable
    public final AutotekaTeaserGallery getGallery() {
        return this.gallery;
    }

    @NotNull
    public final List<TeaserInsight> getInsights() {
        return this.insights;
    }

    @NotNull
    public final ReportLink getReportLink() {
        return this.reportLink;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
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
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<TeaserInsight> list = this.insights;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        ReportLink reportLink2 = this.reportLink;
        int hashCode4 = (hashCode3 + (reportLink2 != null ? reportLink2.hashCode() : 0)) * 31;
        AutotekaCpoTeaser autotekaCpoTeaser = this.cpo;
        int hashCode5 = (hashCode4 + (autotekaCpoTeaser != null ? autotekaCpoTeaser.hashCode() : 0)) * 31;
        AutotekaTeaserGallery autotekaTeaserGallery = this.gallery;
        if (autotekaTeaserGallery != null) {
            i = autotekaTeaserGallery.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaTeaserResult(title=");
        L.append(this.title);
        L.append(", subTitle=");
        L.append(this.subTitle);
        L.append(", insights=");
        L.append(this.insights);
        L.append(", reportLink=");
        L.append(this.reportLink);
        L.append(", cpo=");
        L.append(this.cpo);
        L.append(", gallery=");
        L.append(this.gallery);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        Iterator n0 = a.n0(this.insights, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((TeaserInsight) n0.next(), i);
        }
        parcel.writeParcelable(this.reportLink, i);
        AutotekaCpoTeaser autotekaCpoTeaser = this.cpo;
        if (autotekaCpoTeaser != null) {
            parcel.writeInt(1);
            autotekaCpoTeaser.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AutotekaTeaserGallery autotekaTeaserGallery = this.gallery;
        if (autotekaTeaserGallery != null) {
            parcel.writeInt(1);
            autotekaTeaserGallery.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutotekaTeaserResult(String str, String str2, List list, ReportLink reportLink2, AutotekaCpoTeaser autotekaCpoTeaser, AutotekaTeaserGallery autotekaTeaserGallery, int i, j jVar) {
        this(str, str2, list, reportLink2, (i & 16) != 0 ? null : autotekaCpoTeaser, autotekaTeaserGallery);
    }
}
