package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jz\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020#HÖ\u0001¢\u0006\u0004\b+\u0010%J \u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020#HÖ\u0001¢\u0006\u0004\b0\u00101R\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u001f\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00104\u001a\u0004\b5\u0010\u0015R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u0019\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00107\u001a\u0004\b8\u0010\u000bR\u001c\u0010\u001d\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0011R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00102\u001a\u0004\b;\u0010\u0004R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010<\u001a\u0004\b=\u0010\bR\u001c\u0010\u001a\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b>\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b?\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u00102\u001a\u0004\b@\u0010\u0004¨\u0006C"}, d2 = {"Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/model/CpoLogo;", "component4", "()Lcom/avito/android/remote/model/CpoLogo;", "component5", "component6", "component7", "Lcom/avito/android/remote/model/CpoReportLink;", "component8", "()Lcom/avito/android/remote/model/CpoReportLink;", "component9", "Lcom/avito/android/remote/model/CpoDescription;", "component10", "()Lcom/avito/android/remote/model/CpoDescription;", "title", MessengerShareContentUtility.SUBTITLE, "terms", "logo", "reportTitle", "reportInfo", "reportIntro", "reportLink", "programLinkText", "description", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/CpoLogo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/CpoReportLink;Ljava/lang/String;Lcom/avito/android/remote/model/CpoDescription;)Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSubtitle", "Lcom/avito/android/remote/model/CpoDescription;", "getDescription", "getReportIntro", "Lcom/avito/android/remote/model/CpoLogo;", "getLogo", "Lcom/avito/android/remote/model/CpoReportLink;", "getReportLink", "getTitle", "Ljava/util/List;", "getTerms", "getReportTitle", "getReportInfo", "getProgramLinkText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/CpoLogo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/CpoReportLink;Ljava/lang/String;Lcom/avito/android/remote/model/CpoDescription;)V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaCpoTeaser implements Parcelable {
    public static final Parcelable.Creator<AutotekaCpoTeaser> CREATOR = new Creator();
    @SerializedName("description")
    @NotNull
    private final CpoDescription description;
    @SerializedName("logo")
    @NotNull
    private final CpoLogo logo;
    @SerializedName("programLinkText")
    @NotNull
    private final String programLinkText;
    @SerializedName("reportInfo")
    @NotNull
    private final String reportInfo;
    @SerializedName("reportIntro")
    @NotNull
    private final String reportIntro;
    @SerializedName("reportLink")
    @NotNull
    private final CpoReportLink reportLink;
    @SerializedName("reportTitle")
    @NotNull
    private final String reportTitle;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("terms")
    @NotNull
    private final List<String> terms;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AutotekaCpoTeaser> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaCpoTeaser createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AutotekaCpoTeaser(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), CpoLogo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), CpoReportLink.CREATOR.createFromParcel(parcel), parcel.readString(), CpoDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AutotekaCpoTeaser[] newArray(int i) {
            return new AutotekaCpoTeaser[i];
        }
    }

    public AutotekaCpoTeaser(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull CpoLogo cpoLogo, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull CpoReportLink cpoReportLink, @NotNull String str6, @NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(cpoLogo, "logo");
        Intrinsics.checkNotNullParameter(str3, "reportTitle");
        Intrinsics.checkNotNullParameter(str4, "reportInfo");
        Intrinsics.checkNotNullParameter(str5, "reportIntro");
        Intrinsics.checkNotNullParameter(cpoReportLink, "reportLink");
        Intrinsics.checkNotNullParameter(str6, "programLinkText");
        Intrinsics.checkNotNullParameter(cpoDescription, "description");
        this.title = str;
        this.subtitle = str2;
        this.terms = list;
        this.logo = cpoLogo;
        this.reportTitle = str3;
        this.reportInfo = str4;
        this.reportIntro = str5;
        this.reportLink = cpoReportLink;
        this.programLinkText = str6;
        this.description = cpoDescription;
    }

    public static /* synthetic */ AutotekaCpoTeaser copy$default(AutotekaCpoTeaser autotekaCpoTeaser, String str, String str2, List list, CpoLogo cpoLogo, String str3, String str4, String str5, CpoReportLink cpoReportLink, String str6, CpoDescription cpoDescription, int i, Object obj) {
        return autotekaCpoTeaser.copy((i & 1) != 0 ? autotekaCpoTeaser.title : str, (i & 2) != 0 ? autotekaCpoTeaser.subtitle : str2, (i & 4) != 0 ? autotekaCpoTeaser.terms : list, (i & 8) != 0 ? autotekaCpoTeaser.logo : cpoLogo, (i & 16) != 0 ? autotekaCpoTeaser.reportTitle : str3, (i & 32) != 0 ? autotekaCpoTeaser.reportInfo : str4, (i & 64) != 0 ? autotekaCpoTeaser.reportIntro : str5, (i & 128) != 0 ? autotekaCpoTeaser.reportLink : cpoReportLink, (i & 256) != 0 ? autotekaCpoTeaser.programLinkText : str6, (i & 512) != 0 ? autotekaCpoTeaser.description : cpoDescription);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final CpoDescription component10() {
        return this.description;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final List<String> component3() {
        return this.terms;
    }

    @NotNull
    public final CpoLogo component4() {
        return this.logo;
    }

    @NotNull
    public final String component5() {
        return this.reportTitle;
    }

    @NotNull
    public final String component6() {
        return this.reportInfo;
    }

    @NotNull
    public final String component7() {
        return this.reportIntro;
    }

    @NotNull
    public final CpoReportLink component8() {
        return this.reportLink;
    }

    @NotNull
    public final String component9() {
        return this.programLinkText;
    }

    @NotNull
    public final AutotekaCpoTeaser copy(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull CpoLogo cpoLogo, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull CpoReportLink cpoReportLink, @NotNull String str6, @NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(cpoLogo, "logo");
        Intrinsics.checkNotNullParameter(str3, "reportTitle");
        Intrinsics.checkNotNullParameter(str4, "reportInfo");
        Intrinsics.checkNotNullParameter(str5, "reportIntro");
        Intrinsics.checkNotNullParameter(cpoReportLink, "reportLink");
        Intrinsics.checkNotNullParameter(str6, "programLinkText");
        Intrinsics.checkNotNullParameter(cpoDescription, "description");
        return new AutotekaCpoTeaser(str, str2, list, cpoLogo, str3, str4, str5, cpoReportLink, str6, cpoDescription);
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
        if (!(obj instanceof AutotekaCpoTeaser)) {
            return false;
        }
        AutotekaCpoTeaser autotekaCpoTeaser = (AutotekaCpoTeaser) obj;
        return Intrinsics.areEqual(this.title, autotekaCpoTeaser.title) && Intrinsics.areEqual(this.subtitle, autotekaCpoTeaser.subtitle) && Intrinsics.areEqual(this.terms, autotekaCpoTeaser.terms) && Intrinsics.areEqual(this.logo, autotekaCpoTeaser.logo) && Intrinsics.areEqual(this.reportTitle, autotekaCpoTeaser.reportTitle) && Intrinsics.areEqual(this.reportInfo, autotekaCpoTeaser.reportInfo) && Intrinsics.areEqual(this.reportIntro, autotekaCpoTeaser.reportIntro) && Intrinsics.areEqual(this.reportLink, autotekaCpoTeaser.reportLink) && Intrinsics.areEqual(this.programLinkText, autotekaCpoTeaser.programLinkText) && Intrinsics.areEqual(this.description, autotekaCpoTeaser.description);
    }

    @NotNull
    public final CpoDescription getDescription() {
        return this.description;
    }

    @NotNull
    public final CpoLogo getLogo() {
        return this.logo;
    }

    @NotNull
    public final String getProgramLinkText() {
        return this.programLinkText;
    }

    @NotNull
    public final String getReportInfo() {
        return this.reportInfo;
    }

    @NotNull
    public final String getReportIntro() {
        return this.reportIntro;
    }

    @NotNull
    public final CpoReportLink getReportLink() {
        return this.reportLink;
    }

    @NotNull
    public final String getReportTitle() {
        return this.reportTitle;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final List<String> getTerms() {
        return this.terms;
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
        List<String> list = this.terms;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        CpoLogo cpoLogo = this.logo;
        int hashCode4 = (hashCode3 + (cpoLogo != null ? cpoLogo.hashCode() : 0)) * 31;
        String str3 = this.reportTitle;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.reportInfo;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.reportIntro;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        CpoReportLink cpoReportLink = this.reportLink;
        int hashCode8 = (hashCode7 + (cpoReportLink != null ? cpoReportLink.hashCode() : 0)) * 31;
        String str6 = this.programLinkText;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        CpoDescription cpoDescription = this.description;
        if (cpoDescription != null) {
            i = cpoDescription.hashCode();
        }
        return hashCode9 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaCpoTeaser(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", terms=");
        L.append(this.terms);
        L.append(", logo=");
        L.append(this.logo);
        L.append(", reportTitle=");
        L.append(this.reportTitle);
        L.append(", reportInfo=");
        L.append(this.reportInfo);
        L.append(", reportIntro=");
        L.append(this.reportIntro);
        L.append(", reportLink=");
        L.append(this.reportLink);
        L.append(", programLinkText=");
        L.append(this.programLinkText);
        L.append(", description=");
        L.append(this.description);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeStringList(this.terms);
        this.logo.writeToParcel(parcel, 0);
        parcel.writeString(this.reportTitle);
        parcel.writeString(this.reportInfo);
        parcel.writeString(this.reportIntro);
        this.reportLink.writeToParcel(parcel, 0);
        parcel.writeString(this.programLinkText);
        this.description.writeToParcel(parcel, 0);
    }
}
