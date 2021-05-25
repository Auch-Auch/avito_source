package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012 \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bV\u0010WJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J*\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J¶\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\"\b\u0002\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020)HÖ\u0001¢\u0006\u0004\b0\u0010+J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020)HÖ\u0001¢\u0006\u0004\b5\u00106R\u0019\u0010\u001a\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0007R\u001b\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010;\u001a\u0004\b>\u0010\u0004R\u0019\u0010\u001c\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u000bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010\u0004R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010;\u001a\u0004\bE\u0010\u0004R\u001b\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010;\u001a\u0004\bG\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bI\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bK\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bL\u00108\u001a\u0004\bM\u0010\u0007R3\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u0016R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010;\u001a\u0004\bR\u0010\u0004R\u0019\u0010 \u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0011¨\u0006X"}, d2 = {"Lcom/sumsub/sns/core/data/model/AppConfig;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "Lcom/sumsub/sns/core/data/model/FlowType;", "component4", "()Lcom/sumsub/sns/core/data/model/FlowType;", "component5", "component6", "component7", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component8", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "component9", "component10", "", "component11", "()Ljava/util/Map;", "component12", "component13", "applicantId", "docReaderDisabled", "doubleSidedPassport", "flowType", "flowName", "idDocSetType", "actionId", "actionType", "faceLivenessLic", "facemapPublicKey", "sdkDict", "documentsByCountriesMap", "uiConf", "copy", "(Ljava/lang/String;ZZLcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/AppConfig;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Z", "getDocReaderDisabled", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "getUiConf", "e", "getFlowName", "d", "Lcom/sumsub/sns/core/data/model/FlowType;", "getFlowType", g.a, "getActionId", "i", "getFaceLivenessLic", "l", "getDocumentsByCountriesMap", AuthSource.SEND_ABUSE, "getApplicantId", "f", "getIdDocSetType", "c", "getDoubleSidedPassport", "k", "Ljava/util/Map;", "getSdkDict", "j", "getFacemapPublicKey", "h", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getActionType", "<init>", "(Ljava/lang/String;ZZLcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class AppConfig implements Parcelable {
    public static final Parcelable.Creator<AppConfig> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    public final boolean c;
    @NotNull
    public final FlowType d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @NotNull
    public final FlowActionType h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;
    @Nullable
    public final Map<String, Map<String, String>> k;
    @Nullable
    public final String l;
    @Nullable
    public final String m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AppConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppConfig createFromParcel(@NotNull Parcel parcel) {
            FlowActionType flowActionType;
            String str;
            String str2;
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            FlowType flowType = (FlowType) Enum.valueOf(FlowType.class, parcel.readString());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            FlowActionType flowActionType2 = (FlowActionType) Enum.valueOf(FlowActionType.class, parcel.readString());
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    String readString7 = parcel.readString();
                    int readInt2 = parcel.readInt();
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap(readInt2);
                    while (readInt2 != 0) {
                        readInt2 = a.U(parcel, linkedHashMap3, parcel.readString(), readInt2, -1);
                        readString5 = readString5;
                        flowActionType2 = flowActionType2;
                    }
                    linkedHashMap2.put(readString7, linkedHashMap3);
                    readInt--;
                    readString6 = readString6;
                }
                flowActionType = flowActionType2;
                str = readString5;
                str2 = readString6;
                linkedHashMap = linkedHashMap2;
            } else {
                flowActionType = flowActionType2;
                str = readString5;
                str2 = readString6;
                linkedHashMap = null;
            }
            return new AppConfig(readString, z, z2, flowType, readString2, readString3, readString4, flowActionType, str, str2, linkedHashMap, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppConfig[] newArray(int i) {
            return new AppConfig[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.Map<java.lang.String, java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public AppConfig(@NotNull String str, boolean z, boolean z2, @NotNull FlowType flowType, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull FlowActionType flowActionType, @NotNull String str5, @NotNull String str6, @Nullable Map<String, ? extends Map<String, String>> map, @Nullable String str7, @Nullable String str8) {
        Intrinsics.checkNotNullParameter(str, "applicantId");
        Intrinsics.checkNotNullParameter(flowType, "flowType");
        Intrinsics.checkNotNullParameter(flowActionType, "actionType");
        Intrinsics.checkNotNullParameter(str5, "faceLivenessLic");
        Intrinsics.checkNotNullParameter(str6, "facemapPublicKey");
        this.a = str;
        this.b = z;
        this.c = z2;
        this.d = flowType;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = flowActionType;
        this.i = str5;
        this.j = str6;
        this.k = map;
        this.l = str7;
        this.m = str8;
    }

    public static /* synthetic */ AppConfig copy$default(AppConfig appConfig, String str, boolean z, boolean z2, FlowType flowType, String str2, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map map, String str7, String str8, int i2, Object obj) {
        return appConfig.copy((i2 & 1) != 0 ? appConfig.a : str, (i2 & 2) != 0 ? appConfig.b : z, (i2 & 4) != 0 ? appConfig.c : z2, (i2 & 8) != 0 ? appConfig.d : flowType, (i2 & 16) != 0 ? appConfig.e : str2, (i2 & 32) != 0 ? appConfig.f : str3, (i2 & 64) != 0 ? appConfig.g : str4, (i2 & 128) != 0 ? appConfig.h : flowActionType, (i2 & 256) != 0 ? appConfig.i : str5, (i2 & 512) != 0 ? appConfig.j : str6, (i2 & 1024) != 0 ? appConfig.k : map, (i2 & 2048) != 0 ? appConfig.l : str7, (i2 & 4096) != 0 ? appConfig.m : str8);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    @Nullable
    public final Map<String, Map<String, String>> component11() {
        return this.k;
    }

    @Nullable
    public final String component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    public final boolean component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final FlowType component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final FlowActionType component8() {
        return this.h;
    }

    @NotNull
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final AppConfig copy(@NotNull String str, boolean z, boolean z2, @NotNull FlowType flowType, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull FlowActionType flowActionType, @NotNull String str5, @NotNull String str6, @Nullable Map<String, ? extends Map<String, String>> map, @Nullable String str7, @Nullable String str8) {
        Intrinsics.checkNotNullParameter(str, "applicantId");
        Intrinsics.checkNotNullParameter(flowType, "flowType");
        Intrinsics.checkNotNullParameter(flowActionType, "actionType");
        Intrinsics.checkNotNullParameter(str5, "faceLivenessLic");
        Intrinsics.checkNotNullParameter(str6, "facemapPublicKey");
        return new AppConfig(str, z, z2, flowType, str2, str3, str4, flowActionType, str5, str6, map, str7, str8);
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
        if (!(obj instanceof AppConfig)) {
            return false;
        }
        AppConfig appConfig = (AppConfig) obj;
        return Intrinsics.areEqual(this.a, appConfig.a) && this.b == appConfig.b && this.c == appConfig.c && Intrinsics.areEqual(this.d, appConfig.d) && Intrinsics.areEqual(this.e, appConfig.e) && Intrinsics.areEqual(this.f, appConfig.f) && Intrinsics.areEqual(this.g, appConfig.g) && Intrinsics.areEqual(this.h, appConfig.h) && Intrinsics.areEqual(this.i, appConfig.i) && Intrinsics.areEqual(this.j, appConfig.j) && Intrinsics.areEqual(this.k, appConfig.k) && Intrinsics.areEqual(this.l, appConfig.l) && Intrinsics.areEqual(this.m, appConfig.m);
    }

    @Nullable
    public final String getActionId() {
        return this.g;
    }

    @NotNull
    public final FlowActionType getActionType() {
        return this.h;
    }

    @NotNull
    public final String getApplicantId() {
        return this.a;
    }

    public final boolean getDocReaderDisabled() {
        return this.b;
    }

    @Nullable
    public final String getDocumentsByCountriesMap() {
        return this.l;
    }

    public final boolean getDoubleSidedPassport() {
        return this.c;
    }

    @NotNull
    public final String getFaceLivenessLic() {
        return this.i;
    }

    @NotNull
    public final String getFacemapPublicKey() {
        return this.j;
    }

    @Nullable
    public final String getFlowName() {
        return this.e;
    }

    @NotNull
    public final FlowType getFlowType() {
        return this.d;
    }

    @Nullable
    public final String getIdDocSetType() {
        return this.f;
    }

    @Nullable
    public final Map<String, Map<String, String>> getSdkDict() {
        return this.k;
    }

    @Nullable
    public final String getUiConf() {
        return this.m;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode + i4) * 31;
        boolean z2 = this.c;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        int i8 = (i7 + i3) * 31;
        FlowType flowType = this.d;
        int hashCode2 = (i8 + (flowType != null ? flowType.hashCode() : 0)) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        FlowActionType flowActionType = this.h;
        int hashCode6 = (hashCode5 + (flowActionType != null ? flowActionType.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.j;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Map<String, Map<String, String>> map = this.k;
        int hashCode9 = (hashCode8 + (map != null ? map.hashCode() : 0)) * 31;
        String str7 = this.l;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.m;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode10 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AppConfig(applicantId=");
        L.append(this.a);
        L.append(", docReaderDisabled=");
        L.append(this.b);
        L.append(", doubleSidedPassport=");
        L.append(this.c);
        L.append(", flowType=");
        L.append(this.d);
        L.append(", flowName=");
        L.append(this.e);
        L.append(", idDocSetType=");
        L.append(this.f);
        L.append(", actionId=");
        L.append(this.g);
        L.append(", actionType=");
        L.append(this.h);
        L.append(", faceLivenessLic=");
        L.append(this.i);
        L.append(", facemapPublicKey=");
        L.append(this.j);
        L.append(", sdkDict=");
        L.append(this.k);
        L.append(", documentsByCountriesMap=");
        L.append(this.l);
        L.append(", uiConf=");
        return a.t(L, this.m, ")");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r5 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            java.lang.String r5 = r3.a
            r4.writeString(r5)
            boolean r5 = r3.b
            r4.writeInt(r5)
            boolean r5 = r3.c
            r4.writeInt(r5)
            com.sumsub.sns.core.data.model.FlowType r5 = r3.d
            java.lang.String r5 = r5.name()
            r4.writeString(r5)
            java.lang.String r5 = r3.e
            r4.writeString(r5)
            java.lang.String r5 = r3.f
            r4.writeString(r5)
            java.lang.String r5 = r3.g
            r4.writeString(r5)
            com.sumsub.sns.core.data.model.FlowActionType r5 = r3.h
            java.lang.String r5 = r5.name()
            r4.writeString(r5)
            java.lang.String r5 = r3.i
            r4.writeString(r5)
            java.lang.String r5 = r3.j
            r4.writeString(r5)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r5 = r3.k
            if (r5 == 0) goto L_0x0082
            r0 = 1
            java.util.Iterator r5 = a2.b.a.a.a.m0(r4, r0, r5)
        L_0x0048:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r5.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.util.Map r0 = (java.util.Map) r0
            java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r4)
        L_0x0065:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            goto L_0x0065
        L_0x0082:
            r5 = 0
            r4.writeInt(r5)
        L_0x0086:
            java.lang.String r5 = r3.l
            r4.writeString(r5)
            java.lang.String r5 = r3.m
            r4.writeString(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.AppConfig.writeToParcel(android.os.Parcel, int):void");
    }
}
