package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ`\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b+\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b-\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b.\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b/\u0010\bR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b0\u0010\u0004¨\u00063"}, d2 = {"Lcom/avito/android/remote/model/CloseReason;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Boolean;", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "component7", "id", "title", "showAppRater", "showInput", "motivationText", "currentPrice", "shouldUpdateIncome", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/CloseReason;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivationText", "getTitle", "Ljava/lang/Boolean;", "getShouldUpdateIncome", "getShowAppRater", "getShowInput", "getCurrentPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/Boolean;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReason implements Parcelable {
    public static final Parcelable.Creator<CloseReason> CREATOR = new Creator();
    @SerializedName("currentPrice")
    @Nullable
    private final String currentPrice;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("motivationText")
    @Nullable
    private final AttributedText motivationText;
    @SerializedName("shouldUpdateIncome")
    @Nullable
    private final Boolean shouldUpdateIncome;
    @SerializedName("showAppRater")
    @Nullable
    private final Boolean showAppRater;
    @SerializedName("showInput")
    @Nullable
    private final Boolean showInput;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CloseReason> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CloseReason createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            if (parcel.readInt() != 0) {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool2 = null;
            }
            AttributedText attributedText = (AttributedText) parcel.readParcelable(CloseReason.class.getClassLoader());
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool3 = Boolean.valueOf(z);
            } else {
                bool3 = null;
            }
            return new CloseReason(readString, readString2, bool, bool2, attributedText, readString3, bool3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CloseReason[] newArray(int i) {
            return new CloseReason[i];
        }
    }

    public CloseReason(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.showAppRater = bool;
        this.showInput = bool2;
        this.motivationText = attributedText;
        this.currentPrice = str3;
        this.shouldUpdateIncome = bool3;
    }

    public static /* synthetic */ CloseReason copy$default(CloseReason closeReason, String str, String str2, Boolean bool, Boolean bool2, AttributedText attributedText, String str3, Boolean bool3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = closeReason.id;
        }
        if ((i & 2) != 0) {
            str2 = closeReason.title;
        }
        if ((i & 4) != 0) {
            bool = closeReason.showAppRater;
        }
        if ((i & 8) != 0) {
            bool2 = closeReason.showInput;
        }
        if ((i & 16) != 0) {
            attributedText = closeReason.motivationText;
        }
        if ((i & 32) != 0) {
            str3 = closeReason.currentPrice;
        }
        if ((i & 64) != 0) {
            bool3 = closeReason.shouldUpdateIncome;
        }
        return closeReason.copy(str, str2, bool, bool2, attributedText, str3, bool3);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Boolean component3() {
        return this.showAppRater;
    }

    @Nullable
    public final Boolean component4() {
        return this.showInput;
    }

    @Nullable
    public final AttributedText component5() {
        return this.motivationText;
    }

    @Nullable
    public final String component6() {
        return this.currentPrice;
    }

    @Nullable
    public final Boolean component7() {
        return this.shouldUpdateIncome;
    }

    @NotNull
    public final CloseReason copy(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new CloseReason(str, str2, bool, bool2, attributedText, str3, bool3);
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
        if (!(obj instanceof CloseReason)) {
            return false;
        }
        CloseReason closeReason = (CloseReason) obj;
        return Intrinsics.areEqual(this.id, closeReason.id) && Intrinsics.areEqual(this.title, closeReason.title) && Intrinsics.areEqual(this.showAppRater, closeReason.showAppRater) && Intrinsics.areEqual(this.showInput, closeReason.showInput) && Intrinsics.areEqual(this.motivationText, closeReason.motivationText) && Intrinsics.areEqual(this.currentPrice, closeReason.currentPrice) && Intrinsics.areEqual(this.shouldUpdateIncome, closeReason.shouldUpdateIncome);
    }

    @Nullable
    public final String getCurrentPrice() {
        return this.currentPrice;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AttributedText getMotivationText() {
        return this.motivationText;
    }

    @Nullable
    public final Boolean getShouldUpdateIncome() {
        return this.shouldUpdateIncome;
    }

    @Nullable
    public final Boolean getShowAppRater() {
        return this.showAppRater;
    }

    @Nullable
    public final Boolean getShowInput() {
        return this.showInput;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.showAppRater;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.showInput;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        AttributedText attributedText = this.motivationText;
        int hashCode5 = (hashCode4 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        String str3 = this.currentPrice;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool3 = this.shouldUpdateIncome;
        if (bool3 != null) {
            i = bool3.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CloseReason(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", showAppRater=");
        L.append(this.showAppRater);
        L.append(", showInput=");
        L.append(this.showInput);
        L.append(", motivationText=");
        L.append(this.motivationText);
        L.append(", currentPrice=");
        L.append(this.currentPrice);
        L.append(", shouldUpdateIncome=");
        return a.o(L, this.shouldUpdateIncome, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        Boolean bool = this.showAppRater;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.showInput;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.motivationText, i);
        parcel.writeString(this.currentPrice);
        Boolean bool3 = this.shouldUpdateIncome;
        if (bool3 != null) {
            a.G0(parcel, 1, bool3);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloseReason(String str, String str2, Boolean bool, Boolean bool2, AttributedText attributedText, String str3, Boolean bool3, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : attributedText, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : bool3);
    }
}
