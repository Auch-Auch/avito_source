package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u0000 12\u00020\u0001:\u00011B7\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001c\u0010\u001c\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u001b\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\rR\u001c\u0010\u0018\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b*\u0010\rR\u001c\u0010\u001a\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0011R\u001c\u0010\u0019\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b-\u0010\u0011R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b.\u0010\r¨\u00062"}, d2 = {"Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "Landroid/net/Uri;", "component3", "()Landroid/net/Uri;", "component4", "component5", "Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "description", "reportUrl", "exampleUrl", "vin", "disclaimer", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "Ljava/lang/String;", "getVin", "getDescription", "Landroid/net/Uri;", "getExampleUrl", "getReportUrl", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "Companion", "autoteka_release"}, k = 1, mv = {1, 4, 2})
public final class AutotekaDetailsResponse implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AutotekaDetailsResponse> CREATOR = Parcels.creator(AutotekaDetailsResponse$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("disclaimer")
    @NotNull
    private final AttributedText disclaimer;
    @SerializedName("exampleUrl")
    @NotNull
    private final Uri exampleUrl;
    @SerializedName("reportUrl")
    @NotNull
    private final Uri reportUrl;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("vin")
    @NotNull
    private final String vin;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/AutotekaDetailsResponse$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "autoteka_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public AutotekaDetailsResponse(@NotNull String str, @NotNull String str2, @NotNull Uri uri, @NotNull Uri uri2, @NotNull String str3, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(uri, "reportUrl");
        Intrinsics.checkNotNullParameter(uri2, "exampleUrl");
        Intrinsics.checkNotNullParameter(str3, "vin");
        Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
        this.title = str;
        this.description = str2;
        this.reportUrl = uri;
        this.exampleUrl = uri2;
        this.vin = str3;
        this.disclaimer = attributedText;
    }

    public static /* synthetic */ AutotekaDetailsResponse copy$default(AutotekaDetailsResponse autotekaDetailsResponse, String str, String str2, Uri uri, Uri uri2, String str3, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            str = autotekaDetailsResponse.title;
        }
        if ((i & 2) != 0) {
            str2 = autotekaDetailsResponse.description;
        }
        if ((i & 4) != 0) {
            uri = autotekaDetailsResponse.reportUrl;
        }
        if ((i & 8) != 0) {
            uri2 = autotekaDetailsResponse.exampleUrl;
        }
        if ((i & 16) != 0) {
            str3 = autotekaDetailsResponse.vin;
        }
        if ((i & 32) != 0) {
            attributedText = autotekaDetailsResponse.disclaimer;
        }
        return autotekaDetailsResponse.copy(str, str2, uri, uri2, str3, attributedText);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final Uri component3() {
        return this.reportUrl;
    }

    @NotNull
    public final Uri component4() {
        return this.exampleUrl;
    }

    @NotNull
    public final String component5() {
        return this.vin;
    }

    @NotNull
    public final AttributedText component6() {
        return this.disclaimer;
    }

    @NotNull
    public final AutotekaDetailsResponse copy(@NotNull String str, @NotNull String str2, @NotNull Uri uri, @NotNull Uri uri2, @NotNull String str3, @NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(uri, "reportUrl");
        Intrinsics.checkNotNullParameter(uri2, "exampleUrl");
        Intrinsics.checkNotNullParameter(str3, "vin");
        Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
        return new AutotekaDetailsResponse(str, str2, uri, uri2, str3, attributedText);
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
        if (!(obj instanceof AutotekaDetailsResponse)) {
            return false;
        }
        AutotekaDetailsResponse autotekaDetailsResponse = (AutotekaDetailsResponse) obj;
        return Intrinsics.areEqual(this.title, autotekaDetailsResponse.title) && Intrinsics.areEqual(this.description, autotekaDetailsResponse.description) && Intrinsics.areEqual(this.reportUrl, autotekaDetailsResponse.reportUrl) && Intrinsics.areEqual(this.exampleUrl, autotekaDetailsResponse.exampleUrl) && Intrinsics.areEqual(this.vin, autotekaDetailsResponse.vin) && Intrinsics.areEqual(this.disclaimer, autotekaDetailsResponse.disclaimer);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final Uri getExampleUrl() {
        return this.exampleUrl;
    }

    @NotNull
    public final Uri getReportUrl() {
        return this.reportUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getVin() {
        return this.vin;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Uri uri = this.reportUrl;
        int hashCode3 = (hashCode2 + (uri != null ? uri.hashCode() : 0)) * 31;
        Uri uri2 = this.exampleUrl;
        int hashCode4 = (hashCode3 + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        String str3 = this.vin;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        AttributedText attributedText = this.disclaimer;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AutotekaDetailsResponse(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", reportUrl=");
        L.append(this.reportUrl);
        L.append(", exampleUrl=");
        L.append(this.exampleUrl);
        L.append(", vin=");
        L.append(this.vin);
        L.append(", disclaimer=");
        L.append(this.disclaimer);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.reportUrl, i);
        parcel.writeParcelable(this.exampleUrl, i);
        parcel.writeString(this.vin);
        parcel.writeParcelable(this.disclaimer, i);
    }
}
