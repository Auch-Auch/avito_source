package com.avito.android.remote.model.category_parameters.slot.cpa_tariff;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJF\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010\bR*\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b(\u0010\u000b¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaTariffSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaSlotButton;", "component3", "()Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaSlotButton;", "", "component4", "()Ljava/util/Map;", "title", "description", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "attributesAndValues", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaSlotButton;Ljava/util/Map;)Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaTariffSlotConfig;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "getTitle", "Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaSlotButton;", "getButton", "Ljava/util/Map;", "getAttributesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/cpa_tariff/CpaSlotButton;Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CpaTariffSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<CpaTariffSlotConfig> CREATOR = new Creator();
    @SerializedName("developmentAttributesAndValues")
    @Nullable
    private final Map<String, String> attributesAndValues;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final CpaSlotButton button;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CpaTariffSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpaTariffSlotConfig createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            CpaSlotButton createFromParcel = CpaSlotButton.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new CpaTariffSlotConfig(readString, readString2, createFromParcel, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CpaTariffSlotConfig[] newArray(int i) {
            return new CpaTariffSlotConfig[i];
        }
    }

    public CpaTariffSlotConfig(@NotNull String str, @NotNull String str2, @NotNull CpaSlotButton cpaSlotButton, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(cpaSlotButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        this.title = str;
        this.description = str2;
        this.button = cpaSlotButton;
        this.attributesAndValues = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaTariffSlotConfig */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CpaTariffSlotConfig copy$default(CpaTariffSlotConfig cpaTariffSlotConfig, String str, String str2, CpaSlotButton cpaSlotButton, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cpaTariffSlotConfig.title;
        }
        if ((i & 2) != 0) {
            str2 = cpaTariffSlotConfig.description;
        }
        if ((i & 4) != 0) {
            cpaSlotButton = cpaTariffSlotConfig.button;
        }
        if ((i & 8) != 0) {
            map = cpaTariffSlotConfig.attributesAndValues;
        }
        return cpaTariffSlotConfig.copy(str, str2, cpaSlotButton, map);
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
    public final CpaSlotButton component3() {
        return this.button;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.attributesAndValues;
    }

    @NotNull
    public final CpaTariffSlotConfig copy(@NotNull String str, @NotNull String str2, @NotNull CpaSlotButton cpaSlotButton, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(cpaSlotButton, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        return new CpaTariffSlotConfig(str, str2, cpaSlotButton, map);
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
        if (!(obj instanceof CpaTariffSlotConfig)) {
            return false;
        }
        CpaTariffSlotConfig cpaTariffSlotConfig = (CpaTariffSlotConfig) obj;
        return Intrinsics.areEqual(this.title, cpaTariffSlotConfig.title) && Intrinsics.areEqual(this.description, cpaTariffSlotConfig.description) && Intrinsics.areEqual(this.button, cpaTariffSlotConfig.button) && Intrinsics.areEqual(this.attributesAndValues, cpaTariffSlotConfig.attributesAndValues);
    }

    @Nullable
    public final Map<String, String> getAttributesAndValues() {
        return this.attributesAndValues;
    }

    @NotNull
    public final CpaSlotButton getButton() {
        return this.button;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
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
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        CpaSlotButton cpaSlotButton = this.button;
        int hashCode3 = (hashCode2 + (cpaSlotButton != null ? cpaSlotButton.hashCode() : 0)) * 31;
        Map<String, String> map = this.attributesAndValues;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CpaTariffSlotConfig(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", button=");
        L.append(this.button);
        L.append(", attributesAndValues=");
        return a.x(L, this.attributesAndValues, ")");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = r2.title
            r3.writeString(r4)
            java.lang.String r4 = r2.description
            r3.writeString(r4)
            com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaSlotButton r4 = r2.button
            r0 = 0
            r4.writeToParcel(r3, r0)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.attributesAndValues
            if (r4 == 0) goto L_0x003b
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x001e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x003e
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x001e
        L_0x003b:
            r3.writeInt(r0)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaTariffSlotConfig.writeToParcel(android.os.Parcel, int):void");
    }
}
