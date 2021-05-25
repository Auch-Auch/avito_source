package com.avito.android.remote.model.autoteka;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.teaser.TeaserInsight;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JV\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0004R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b-\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b.\u0010\u0004R\u001f\u0010/\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b3\u00104\u001a\u0004\b1\u00102R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b5\u0010\u0004¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryReportLink;", "component3", "()Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryReportLink;", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "component4", "()Ljava/util/List;", "component5", "component6", "title", "reportInfoSubtitle", "reportLink", "insights", "photosInReportSubtitle", "photosInReportTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryReportLink;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryReportLink;", "getReportLink", "Ljava/lang/String;", "getPhotosInReportSubtitle", "Ljava/util/List;", "getInsights", "getTitle", "getPhotosInReportTitle", "hasAnotherPhotoInReport", "Z", "getHasAnotherPhotoInReport", "()Z", "getHasAnotherPhotoInReport$annotations", "()V", "getReportInfoSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryReportLink;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaTeaserGalleryModel implements Parcelable {
    public static final Parcelable.Creator<AutotekaTeaserGalleryModel> CREATOR = new Creator();
    private final boolean hasAnotherPhotoInReport;
    @NotNull
    private final List<TeaserInsight> insights;
    @Nullable
    private final String photosInReportSubtitle;
    @Nullable
    private final String photosInReportTitle;
    @NotNull
    private final String reportInfoSubtitle;
    @NotNull
    private final AutotekaTeaserGalleryReportLink reportLink;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaTeaserGalleryModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserGalleryModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            AutotekaTeaserGalleryReportLink createFromParcel = AutotekaTeaserGalleryReportLink.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(TeaserInsight.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new AutotekaTeaserGalleryModel(readString, readString2, createFromParcel, arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaTeaserGalleryModel[] newArray(int i) {
            return new AutotekaTeaserGalleryModel[i];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AutotekaTeaserGalleryModel(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryReportLink r4, @org.jetbrains.annotations.NotNull java.util.List<com.avito.android.remote.model.teaser.TeaserInsight> r5, @org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r1 = this;
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "reportInfoSubtitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "reportLink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "insights"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r1.<init>()
            r1.title = r2
            r1.reportInfoSubtitle = r3
            r1.reportLink = r4
            r1.insights = r5
            r1.photosInReportSubtitle = r6
            r1.photosInReportTitle = r7
            r2 = 0
            r3 = 1
            if (r7 == 0) goto L_0x0034
            int r4 = r7.length()
            if (r4 <= 0) goto L_0x002f
            r4 = 1
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            if (r4 == 0) goto L_0x0034
            r4 = 1
            goto L_0x0035
        L_0x0034:
            r4 = 0
        L_0x0035:
            if (r4 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x0046
            int r4 = r6.length()
            if (r4 <= 0) goto L_0x0041
            r4 = 1
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0046
            r4 = 1
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            if (r4 == 0) goto L_0x0051
            boolean r4 = r5.isEmpty()
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x0051
            r2 = 1
        L_0x0051:
            r1.hasAnotherPhotoInReport = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel.<init>(java.lang.String, java.lang.String, com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryReportLink, java.util.List, java.lang.String, java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutotekaTeaserGalleryModel copy$default(AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, String str, String str2, AutotekaTeaserGalleryReportLink autotekaTeaserGalleryReportLink, List list, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autotekaTeaserGalleryModel.title;
        }
        if ((i & 2) != 0) {
            str2 = autotekaTeaserGalleryModel.reportInfoSubtitle;
        }
        if ((i & 4) != 0) {
            autotekaTeaserGalleryReportLink = autotekaTeaserGalleryModel.reportLink;
        }
        if ((i & 8) != 0) {
            list = autotekaTeaserGalleryModel.insights;
        }
        if ((i & 16) != 0) {
            str3 = autotekaTeaserGalleryModel.photosInReportSubtitle;
        }
        if ((i & 32) != 0) {
            str4 = autotekaTeaserGalleryModel.photosInReportTitle;
        }
        return autotekaTeaserGalleryModel.copy(str, str2, autotekaTeaserGalleryReportLink, list, str3, str4);
    }

    public static /* synthetic */ void getHasAnotherPhotoInReport$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.reportInfoSubtitle;
    }

    @NotNull
    public final AutotekaTeaserGalleryReportLink component3() {
        return this.reportLink;
    }

    @NotNull
    public final List<TeaserInsight> component4() {
        return this.insights;
    }

    @Nullable
    public final String component5() {
        return this.photosInReportSubtitle;
    }

    @Nullable
    public final String component6() {
        return this.photosInReportTitle;
    }

    @NotNull
    public final AutotekaTeaserGalleryModel copy(@NotNull String str, @NotNull String str2, @NotNull AutotekaTeaserGalleryReportLink autotekaTeaserGalleryReportLink, @NotNull List<TeaserInsight> list, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "reportInfoSubtitle");
        Intrinsics.checkNotNullParameter(autotekaTeaserGalleryReportLink, "reportLink");
        Intrinsics.checkNotNullParameter(list, "insights");
        return new AutotekaTeaserGalleryModel(str, str2, autotekaTeaserGalleryReportLink, list, str3, str4);
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
        if (!(obj instanceof AutotekaTeaserGalleryModel)) {
            return false;
        }
        AutotekaTeaserGalleryModel autotekaTeaserGalleryModel = (AutotekaTeaserGalleryModel) obj;
        return Intrinsics.areEqual(this.title, autotekaTeaserGalleryModel.title) && Intrinsics.areEqual(this.reportInfoSubtitle, autotekaTeaserGalleryModel.reportInfoSubtitle) && Intrinsics.areEqual(this.reportLink, autotekaTeaserGalleryModel.reportLink) && Intrinsics.areEqual(this.insights, autotekaTeaserGalleryModel.insights) && Intrinsics.areEqual(this.photosInReportSubtitle, autotekaTeaserGalleryModel.photosInReportSubtitle) && Intrinsics.areEqual(this.photosInReportTitle, autotekaTeaserGalleryModel.photosInReportTitle);
    }

    public final boolean getHasAnotherPhotoInReport() {
        return this.hasAnotherPhotoInReport;
    }

    @NotNull
    public final List<TeaserInsight> getInsights() {
        return this.insights;
    }

    @Nullable
    public final String getPhotosInReportSubtitle() {
        return this.photosInReportSubtitle;
    }

    @Nullable
    public final String getPhotosInReportTitle() {
        return this.photosInReportTitle;
    }

    @NotNull
    public final String getReportInfoSubtitle() {
        return this.reportInfoSubtitle;
    }

    @NotNull
    public final AutotekaTeaserGalleryReportLink getReportLink() {
        return this.reportLink;
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
        String str2 = this.reportInfoSubtitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        AutotekaTeaserGalleryReportLink autotekaTeaserGalleryReportLink = this.reportLink;
        int hashCode3 = (hashCode2 + (autotekaTeaserGalleryReportLink != null ? autotekaTeaserGalleryReportLink.hashCode() : 0)) * 31;
        List<TeaserInsight> list = this.insights;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.photosInReportSubtitle;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.photosInReportTitle;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaTeaserGalleryModel(title=");
        L.append(this.title);
        L.append(", reportInfoSubtitle=");
        L.append(this.reportInfoSubtitle);
        L.append(", reportLink=");
        L.append(this.reportLink);
        L.append(", insights=");
        L.append(this.insights);
        L.append(", photosInReportSubtitle=");
        L.append(this.photosInReportSubtitle);
        L.append(", photosInReportTitle=");
        return a.t(L, this.photosInReportTitle, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.reportInfoSubtitle);
        this.reportLink.writeToParcel(parcel, 0);
        Iterator n0 = a.n0(this.insights, parcel);
        while (n0.hasNext()) {
            ((TeaserInsight) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.photosInReportSubtitle);
        parcel.writeString(this.photosInReportTitle);
    }
}
