package com.avito.android.remote;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJP\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\u000fR$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lcom/avito/android/remote/DomotekaTeaser;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/DomotekaTeaserType;", "component1", "()Lcom/avito/android/remote/DomotekaTeaserType;", "", "component2", "()Ljava/lang/String;", "component3", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "component4", "()Ljava/util/List;", "Lcom/avito/android/remote/ReportLink;", "component5", "()Lcom/avito/android/remote/ReportLink;", "type", "title", MessengerShareContentUtility.SUBTITLE, "insights", "reportLink", "copy", "(Lcom/avito/android/remote/DomotekaTeaserType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/ReportLink;)Lcom/avito/android/remote/DomotekaTeaser;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/DomotekaTeaserType;", "getType", "Ljava/lang/String;", "getSubtitle", "Lcom/avito/android/remote/ReportLink;", "getReportLink", "Ljava/util/List;", "getInsights", "getTitle", "<init>", "(Lcom/avito/android/remote/DomotekaTeaserType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/ReportLink;)V", "domoteka_release"}, k = 1, mv = {1, 4, 2})
public final class DomotekaTeaser implements Parcelable {
    public static final Parcelable.Creator<DomotekaTeaser> CREATOR = new Creator();
    @SerializedName("insights")
    @Nullable
    private final List<TeaserInsight> insights;
    @SerializedName("reportLink")
    @Nullable
    private final ReportLink reportLink;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("type")
    @NotNull
    private final DomotekaTeaserType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DomotekaTeaser> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DomotekaTeaser createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            DomotekaTeaserType domotekaTeaserType = (DomotekaTeaserType) Enum.valueOf(DomotekaTeaserType.class, parcel.readString());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((TeaserInsight) parcel.readParcelable(DomotekaTeaser.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new DomotekaTeaser(domotekaTeaserType, readString, readString2, arrayList, parcel.readInt() != 0 ? ReportLink.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DomotekaTeaser[] newArray(int i) {
            return new DomotekaTeaser[i];
        }
    }

    public DomotekaTeaser(@NotNull DomotekaTeaserType domotekaTeaserType, @Nullable String str, @Nullable String str2, @Nullable List<TeaserInsight> list, @Nullable ReportLink reportLink2) {
        Intrinsics.checkNotNullParameter(domotekaTeaserType, "type");
        this.type = domotekaTeaserType;
        this.title = str;
        this.subtitle = str2;
        this.insights = list;
        this.reportLink = reportLink2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.DomotekaTeaser */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DomotekaTeaser copy$default(DomotekaTeaser domotekaTeaser, DomotekaTeaserType domotekaTeaserType, String str, String str2, List list, ReportLink reportLink2, int i, Object obj) {
        if ((i & 1) != 0) {
            domotekaTeaserType = domotekaTeaser.type;
        }
        if ((i & 2) != 0) {
            str = domotekaTeaser.title;
        }
        if ((i & 4) != 0) {
            str2 = domotekaTeaser.subtitle;
        }
        if ((i & 8) != 0) {
            list = domotekaTeaser.insights;
        }
        if ((i & 16) != 0) {
            reportLink2 = domotekaTeaser.reportLink;
        }
        return domotekaTeaser.copy(domotekaTeaserType, str, str2, list, reportLink2);
    }

    @NotNull
    public final DomotekaTeaserType component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final List<TeaserInsight> component4() {
        return this.insights;
    }

    @Nullable
    public final ReportLink component5() {
        return this.reportLink;
    }

    @NotNull
    public final DomotekaTeaser copy(@NotNull DomotekaTeaserType domotekaTeaserType, @Nullable String str, @Nullable String str2, @Nullable List<TeaserInsight> list, @Nullable ReportLink reportLink2) {
        Intrinsics.checkNotNullParameter(domotekaTeaserType, "type");
        return new DomotekaTeaser(domotekaTeaserType, str, str2, list, reportLink2);
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
        if (!(obj instanceof DomotekaTeaser)) {
            return false;
        }
        DomotekaTeaser domotekaTeaser = (DomotekaTeaser) obj;
        return Intrinsics.areEqual(this.type, domotekaTeaser.type) && Intrinsics.areEqual(this.title, domotekaTeaser.title) && Intrinsics.areEqual(this.subtitle, domotekaTeaser.subtitle) && Intrinsics.areEqual(this.insights, domotekaTeaser.insights) && Intrinsics.areEqual(this.reportLink, domotekaTeaser.reportLink);
    }

    @Nullable
    public final List<TeaserInsight> getInsights() {
        return this.insights;
    }

    @Nullable
    public final ReportLink getReportLink() {
        return this.reportLink;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DomotekaTeaserType getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DomotekaTeaserType domotekaTeaserType = this.type;
        int i = 0;
        int hashCode = (domotekaTeaserType != null ? domotekaTeaserType.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.subtitle;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<TeaserInsight> list = this.insights;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        ReportLink reportLink2 = this.reportLink;
        if (reportLink2 != null) {
            i = reportLink2.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DomotekaTeaser(type=");
        L.append(this.type);
        L.append(", title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", insights=");
        L.append(this.insights);
        L.append(", reportLink=");
        L.append(this.reportLink);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type.name());
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        List<TeaserInsight> list = this.insights;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((TeaserInsight) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        ReportLink reportLink2 = this.reportLink;
        if (reportLink2 != null) {
            parcel.writeInt(1);
            reportLink2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
