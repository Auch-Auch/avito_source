package com.avito.android.suggest_locations;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.PublishIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJ\u0010\u0010\u0015\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010#\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b)\u0010$J \u0010.\u001a\u00020-2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b.\u0010/R\u0019\u0010\u001b\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00101\u001a\u0004\b7\u0010\u000fR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0013R\u0019\u0010\u001f\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00101\u001a\u0004\b>\u0010\u000fR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\bR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010\u0004¨\u0006K"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "component4", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "component5", "()Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "", "component6", "()Z", "component7", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "component8", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "component9", "component10", "locationId", "categoryId", BookingInfoActivity.EXTRA_FROM_BLOCK, "query", "chooseButtonLocation", "showHistoricalSuggest", "geoSessionId", "validationRules", "autoOpenKeyboard", "useLegacyApi", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Z", "getShowHistoricalSuggest", g.a, "Ljava/lang/String;", "getGeoSessionId", "i", "getAutoOpenKeyboard", "d", "getQuery", "h", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "getValidationRules", "j", "getUseLegacyApi", AuthSource.BOOKING_ORDER, "getCategoryId", "c", "Ljava/lang/Integer;", "getFromBlock", "e", "Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;", "getChooseButtonLocation", AuthSource.SEND_ABUSE, "getLocationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/PublishIntentFactory$LocationPickerChooseButtonLocation;ZLjava/lang/String;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;ZZ)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsArguments implements Parcelable {
    public static final Parcelable.Creator<SuggestLocationsArguments> CREATOR = new Creator();
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final Integer c;
    @Nullable
    public final String d;
    @Nullable
    public final PublishIntentFactory.LocationPickerChooseButtonLocation e;
    public final boolean f;
    @Nullable
    public final String g;
    @Nullable
    public final AddressParameter.ValidationRules h;
    public final boolean i;
    public final boolean j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestLocationsArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationsArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SuggestLocationsArguments(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt() != 0 ? (PublishIntentFactory.LocationPickerChooseButtonLocation) Enum.valueOf(PublishIntentFactory.LocationPickerChooseButtonLocation.class, parcel.readString()) : null, parcel.readInt() != 0, parcel.readString(), (AddressParameter.ValidationRules) parcel.readParcelable(SuggestLocationsArguments.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationsArguments[] newArray(int i) {
            return new SuggestLocationsArguments[i];
        }
    }

    public SuggestLocationsArguments(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
        this.a = str;
        this.b = str2;
        this.c = num;
        this.d = str3;
        this.e = locationPickerChooseButtonLocation;
        this.f = z;
        this.g = str4;
        this.h = validationRules;
        this.i = z2;
        this.j = z3;
    }

    public static /* synthetic */ SuggestLocationsArguments copy$default(SuggestLocationsArguments suggestLocationsArguments, String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3, int i2, Object obj) {
        return suggestLocationsArguments.copy((i2 & 1) != 0 ? suggestLocationsArguments.a : str, (i2 & 2) != 0 ? suggestLocationsArguments.b : str2, (i2 & 4) != 0 ? suggestLocationsArguments.c : num, (i2 & 8) != 0 ? suggestLocationsArguments.d : str3, (i2 & 16) != 0 ? suggestLocationsArguments.e : locationPickerChooseButtonLocation, (i2 & 32) != 0 ? suggestLocationsArguments.f : z, (i2 & 64) != 0 ? suggestLocationsArguments.g : str4, (i2 & 128) != 0 ? suggestLocationsArguments.h : validationRules, (i2 & 256) != 0 ? suggestLocationsArguments.i : z2, (i2 & 512) != 0 ? suggestLocationsArguments.j : z3);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Integer component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final PublishIntentFactory.LocationPickerChooseButtonLocation component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @Nullable
    public final AddressParameter.ValidationRules component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final SuggestLocationsArguments copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, @Nullable String str4, @Nullable AddressParameter.ValidationRules validationRules, boolean z2, boolean z3) {
        return new SuggestLocationsArguments(str, str2, num, str3, locationPickerChooseButtonLocation, z, str4, validationRules, z2, z3);
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
        if (!(obj instanceof SuggestLocationsArguments)) {
            return false;
        }
        SuggestLocationsArguments suggestLocationsArguments = (SuggestLocationsArguments) obj;
        return Intrinsics.areEqual(this.a, suggestLocationsArguments.a) && Intrinsics.areEqual(this.b, suggestLocationsArguments.b) && Intrinsics.areEqual(this.c, suggestLocationsArguments.c) && Intrinsics.areEqual(this.d, suggestLocationsArguments.d) && Intrinsics.areEqual(this.e, suggestLocationsArguments.e) && this.f == suggestLocationsArguments.f && Intrinsics.areEqual(this.g, suggestLocationsArguments.g) && Intrinsics.areEqual(this.h, suggestLocationsArguments.h) && this.i == suggestLocationsArguments.i && this.j == suggestLocationsArguments.j;
    }

    public final boolean getAutoOpenKeyboard() {
        return this.i;
    }

    @Nullable
    public final String getCategoryId() {
        return this.b;
    }

    @Nullable
    public final PublishIntentFactory.LocationPickerChooseButtonLocation getChooseButtonLocation() {
        return this.e;
    }

    @Nullable
    public final Integer getFromBlock() {
        return this.c;
    }

    @Nullable
    public final String getGeoSessionId() {
        return this.g;
    }

    @Nullable
    public final String getLocationId() {
        return this.a;
    }

    @Nullable
    public final String getQuery() {
        return this.d;
    }

    public final boolean getShowHistoricalSuggest() {
        return this.f;
    }

    public final boolean getUseLegacyApi() {
        return this.j;
    }

    @Nullable
    public final AddressParameter.ValidationRules getValidationRules() {
        return this.h;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation = this.e;
        int hashCode5 = (hashCode4 + (locationPickerChooseButtonLocation != null ? locationPickerChooseButtonLocation.hashCode() : 0)) * 31;
        boolean z = this.f;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode5 + i4) * 31;
        String str4 = this.g;
        int hashCode6 = (i7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        AddressParameter.ValidationRules validationRules = this.h;
        if (validationRules != null) {
            i2 = validationRules.hashCode();
        }
        int i8 = (hashCode6 + i2) * 31;
        boolean z2 = this.i;
        if (z2) {
            z2 = true;
        }
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = z2 ? 1 : 0;
        int i12 = (i8 + i9) * 31;
        boolean z3 = this.j;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        return i12 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SuggestLocationsArguments(locationId=");
        L.append(this.a);
        L.append(", categoryId=");
        L.append(this.b);
        L.append(", fromBlock=");
        L.append(this.c);
        L.append(", query=");
        L.append(this.d);
        L.append(", chooseButtonLocation=");
        L.append(this.e);
        L.append(", showHistoricalSuggest=");
        L.append(this.f);
        L.append(", geoSessionId=");
        L.append(this.g);
        L.append(", validationRules=");
        L.append(this.h);
        L.append(", autoOpenKeyboard=");
        L.append(this.i);
        L.append(", useLegacyApi=");
        return a.B(L, this.j, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        Integer num = this.c;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.d);
        PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation = this.e;
        if (locationPickerChooseButtonLocation != null) {
            parcel.writeInt(1);
            parcel.writeString(locationPickerChooseButtonLocation.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeString(this.g);
        parcel.writeParcelable(this.h, i2);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuggestLocationsArguments(String str, String str2, Integer num, String str3, PublishIntentFactory.LocationPickerChooseButtonLocation locationPickerChooseButtonLocation, boolean z, String str4, AddressParameter.ValidationRules validationRules, boolean z2, boolean z3, int i2, j jVar) {
        this(str, str2, num, str3, locationPickerChooseButtonLocation, z, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : validationRules, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? false : z3);
    }
}
