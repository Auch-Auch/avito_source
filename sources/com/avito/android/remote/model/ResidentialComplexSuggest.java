package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.util.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\r\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007R\u001c\u0010\f\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "id", "name", "officialDeveloper", Constants.LOCATION_NAME, "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/ResidentialComplexSuggest;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getName", "getLocationName", "getOfficialDeveloper", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class ResidentialComplexSuggest {
    @SerializedName("id")
    private final int id;
    @SerializedName(Constants.LOCATION_NAME)
    @NotNull
    private final String locationName;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("officialDeveloper")
    @NotNull
    private final String officialDeveloper;

    public ResidentialComplexSuggest(int i, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.Z0(str, "name", str2, "officialDeveloper", str3, Constants.LOCATION_NAME);
        this.id = i;
        this.name = str;
        this.officialDeveloper = str2;
        this.locationName = str3;
    }

    public static /* synthetic */ ResidentialComplexSuggest copy$default(ResidentialComplexSuggest residentialComplexSuggest, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = residentialComplexSuggest.id;
        }
        if ((i2 & 2) != 0) {
            str = residentialComplexSuggest.name;
        }
        if ((i2 & 4) != 0) {
            str2 = residentialComplexSuggest.officialDeveloper;
        }
        if ((i2 & 8) != 0) {
            str3 = residentialComplexSuggest.locationName;
        }
        return residentialComplexSuggest.copy(i, str, str2, str3);
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.officialDeveloper;
    }

    @NotNull
    public final String component4() {
        return this.locationName;
    }

    @NotNull
    public final ResidentialComplexSuggest copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "officialDeveloper");
        Intrinsics.checkNotNullParameter(str3, Constants.LOCATION_NAME);
        return new ResidentialComplexSuggest(i, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResidentialComplexSuggest)) {
            return false;
        }
        ResidentialComplexSuggest residentialComplexSuggest = (ResidentialComplexSuggest) obj;
        return this.id == residentialComplexSuggest.id && Intrinsics.areEqual(this.name, residentialComplexSuggest.name) && Intrinsics.areEqual(this.officialDeveloper, residentialComplexSuggest.officialDeveloper) && Intrinsics.areEqual(this.locationName, residentialComplexSuggest.locationName);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLocationName() {
        return this.locationName;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getOfficialDeveloper() {
        return this.officialDeveloper;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.officialDeveloper;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.locationName;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ResidentialComplexSuggest(id=");
        L.append(this.id);
        L.append(", name=");
        L.append(this.name);
        L.append(", officialDeveloper=");
        L.append(this.officialDeveloper);
        L.append(", locationName=");
        return a.t(L, this.locationName, ")");
    }
}
