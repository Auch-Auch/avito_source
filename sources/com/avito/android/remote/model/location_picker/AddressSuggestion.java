package com.avito.android.remote.model.location_picker;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u0000 12\u00020\u0001:\u000212B9\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b.\u00100J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015JH\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\nJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010\rR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b&\u0010\rR\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b'\u0010\rR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\u0011R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b+\u0010\u0015R\u0013\u0010-\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010\r¨\u00063"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/Coordinates;", "component3", "()Lcom/avito/android/remote/model/Coordinates;", "component4", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;", "component5", "()Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;", "title", MessengerShareContentUtility.SUBTITLE, "coordinates", "jsonWebToken", "suggestType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;)Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSubtitle", "getJsonWebToken", "getTitle", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;", "getSuggestType", "getAddressStringOneLine", "addressStringOneLine", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;)V", "(Landroid/os/Parcel;)V", "CREATOR", "SuggestType", "location_release"}, k = 1, mv = {1, 4, 2})
public final class AddressSuggestion implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("coordinates")
    @Nullable
    private final Coordinates coordinates;
    @SerializedName(AddressParameter.Value.JSON_WEB_TOKEN)
    @Nullable
    private final String jsonWebToken;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @NotNull
    private final String subtitle;
    @SerializedName("suggestType")
    @Nullable
    private final SuggestType suggestType;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressSuggestion$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "<init>", "()V", "location_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AddressSuggestion> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AddressSuggestion createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AddressSuggestion(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AddressSuggestion[] newArray(int i) {
            return new AddressSuggestion[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/location_picker/AddressSuggestion$SuggestType;", "", "<init>", "(Ljava/lang/String;I)V", "HISTORICAL", MessengerShareContentUtility.PREVIEW_DEFAULT, "location_release"}, k = 1, mv = {1, 4, 2})
    public enum SuggestType {
        HISTORICAL,
        DEFAULT
    }

    public AddressSuggestion(@NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates2, @Nullable String str3, @Nullable SuggestType suggestType2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        this.title = str;
        this.subtitle = str2;
        this.coordinates = coordinates2;
        this.jsonWebToken = str3;
        this.suggestType = suggestType2;
    }

    public static /* synthetic */ AddressSuggestion copy$default(AddressSuggestion addressSuggestion, String str, String str2, Coordinates coordinates2, String str3, SuggestType suggestType2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addressSuggestion.title;
        }
        if ((i & 2) != 0) {
            str2 = addressSuggestion.subtitle;
        }
        if ((i & 4) != 0) {
            coordinates2 = addressSuggestion.coordinates;
        }
        if ((i & 8) != 0) {
            str3 = addressSuggestion.jsonWebToken;
        }
        if ((i & 16) != 0) {
            suggestType2 = addressSuggestion.suggestType;
        }
        return addressSuggestion.copy(str, str2, coordinates2, str3, suggestType2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subtitle;
    }

    @Nullable
    public final Coordinates component3() {
        return this.coordinates;
    }

    @Nullable
    public final String component4() {
        return this.jsonWebToken;
    }

    @Nullable
    public final SuggestType component5() {
        return this.suggestType;
    }

    @NotNull
    public final AddressSuggestion copy(@NotNull String str, @NotNull String str2, @Nullable Coordinates coordinates2, @Nullable String str3, @Nullable SuggestType suggestType2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        return new AddressSuggestion(str, str2, coordinates2, str3, suggestType2);
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
        if (!(obj instanceof AddressSuggestion)) {
            return false;
        }
        AddressSuggestion addressSuggestion = (AddressSuggestion) obj;
        return Intrinsics.areEqual(this.title, addressSuggestion.title) && Intrinsics.areEqual(this.subtitle, addressSuggestion.subtitle) && Intrinsics.areEqual(this.coordinates, addressSuggestion.coordinates) && Intrinsics.areEqual(this.jsonWebToken, addressSuggestion.jsonWebToken) && Intrinsics.areEqual(this.suggestType, addressSuggestion.suggestType);
    }

    @NotNull
    public final String getAddressStringOneLine() {
        boolean z = true;
        if (!(this.title.length() == 0)) {
            if (!(this.subtitle.length() == 0)) {
                return this.subtitle + ", " + this.title;
            }
        }
        if (!(this.title.length() == 0)) {
            return this.title;
        }
        if (this.subtitle.length() != 0) {
            z = false;
        }
        return !z ? this.subtitle : "";
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final String getJsonWebToken() {
        return this.jsonWebToken;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final SuggestType getSuggestType() {
        return this.suggestType;
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
        Coordinates coordinates2 = this.coordinates;
        int hashCode3 = (hashCode2 + (coordinates2 != null ? coordinates2.hashCode() : 0)) * 31;
        String str3 = this.jsonWebToken;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SuggestType suggestType2 = this.suggestType;
        if (suggestType2 != null) {
            i = suggestType2.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AddressSuggestion(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", coordinates=");
        L.append(this.coordinates);
        L.append(", jsonWebToken=");
        L.append(this.jsonWebToken);
        L.append(", suggestType=");
        L.append(this.suggestType);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.coordinates, i);
        ParcelsKt.writeNullableValue(parcel, this.jsonWebToken);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressSuggestion(String str, String str2, Coordinates coordinates2, String str3, SuggestType suggestType2, int i, j jVar) {
        this(str, str2, coordinates2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : suggestType2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddressSuggestion(@org.jetbrains.annotations.NotNull android.os.Parcel r10) {
        /*
            r9 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r2 = r10.readString()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r0 = "parcel.readString()!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r3 = a2.b.a.a.a.u2(r10, r0)
            java.lang.Class<com.avito.android.remote.model.Coordinates> r0 = com.avito.android.remote.model.Coordinates.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r10.readParcelable(r0)
            r4 = r0
            com.avito.android.remote.model.Coordinates r4 = (com.avito.android.remote.model.Coordinates) r4
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r10 = r10.readValue(r0)
            boolean r0 = r10 instanceof java.lang.String
            if (r0 != 0) goto L_0x0031
            r10 = 0
        L_0x0031:
            r5 = r10
            java.lang.String r5 = (java.lang.String) r5
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.location_picker.AddressSuggestion.<init>(android.os.Parcel):void");
    }
}
