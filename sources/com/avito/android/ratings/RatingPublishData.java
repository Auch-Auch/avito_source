package com.avito.android.ratings;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.abuse.AbuseSendingResult;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b4\b\b\u0018\u00002\u00020\u0001B©\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016¢\u0006\u0004\be\u0010fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J´\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010#\u001a\u00020\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0004J\u0010\u0010)\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b/\u0010*J \u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b4\u00105R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0004\"\u0004\b9\u0010:R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0018\"\u0004\b>\u0010?R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u00107\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u0010:R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u000b\"\u0004\bH\u0010IR$\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010NR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bO\u00107\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010:R\"\u0010#\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\b#\u0010\u0014\"\u0004\bT\u0010UR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bV\u00107\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010:R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bY\u00107\u001a\u0004\bZ\u0010\u0004\"\u0004\b[\u0010:R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\\\u00107\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010:R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b_\u00107\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010:R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bb\u00107\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010:¨\u0006g"}, d2 = {"Lcom/avito/android/ratings/RatingPublishData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Long;", "", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "component10", "", "component11", "()Z", "component12", "", "component13", "()Ljava/util/Map;", "userKey", "itemId", "stageId", "score", AbuseSendingResult.COMMENT, "contextId", "filesOperationId", "imagesOperationId", "buyerInfo", "stepId", "isLastStep", "images", "dynamicParams", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;)Lcom/avito/android/ratings/RatingPublishData;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "i", "Ljava/lang/String;", "getBuyerInfo", "setBuyerInfo", "(Ljava/lang/String;)V", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/Map;", "getDynamicParams", "setDynamicParams", "(Ljava/util/Map;)V", "j", "getStepId", "setStepId", AuthSource.SEND_ABUSE, "getUserKey", "d", "Ljava/lang/Integer;", "getScore", "setScore", "(Ljava/lang/Integer;)V", "c", "Ljava/lang/Long;", "getStageId", "setStageId", "(Ljava/lang/Long;)V", g.a, "getFilesOperationId", "setFilesOperationId", "k", "Z", "setLastStep", "(Z)V", AuthSource.BOOKING_ORDER, "getItemId", "setItemId", "f", "getContextId", "setContextId", "h", "getImagesOperationId", "setImagesOperationId", "l", "getImages", "setImages", "e", "getComment", "setComment", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishData implements Parcelable {
    public static final Parcelable.Creator<RatingPublishData> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public String b;
    @Nullable
    public Long c;
    @Nullable
    public Integer d;
    @Nullable
    public String e;
    @Nullable
    public String f;
    @Nullable
    public String g;
    @Nullable
    public String h;
    @Nullable
    public String i;
    @Nullable
    public String j;
    public boolean k;
    @Nullable
    public String l;
    @Nullable
    public Map<String, String> m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RatingPublishData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String readString9 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                    readString9 = readString9;
                    z = z;
                }
            }
            return new RatingPublishData(readString, readString2, valueOf, valueOf2, readString3, readString4, readString5, readString6, readString7, readString8, z, readString9, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishData[] newArray(int i) {
            return new RatingPublishData[i];
        }
    }

    public RatingPublishData(@NotNull String str, @Nullable String str2, @Nullable Long l2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, boolean z, @Nullable String str9, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.a = str;
        this.b = str2;
        this.c = l2;
        this.d = num;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.k = z;
        this.l = str9;
        this.m = map;
    }

    public static /* synthetic */ RatingPublishData copy$default(RatingPublishData ratingPublishData, String str, String str2, Long l2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, Map map, int i2, Object obj) {
        return ratingPublishData.copy((i2 & 1) != 0 ? ratingPublishData.a : str, (i2 & 2) != 0 ? ratingPublishData.b : str2, (i2 & 4) != 0 ? ratingPublishData.c : l2, (i2 & 8) != 0 ? ratingPublishData.d : num, (i2 & 16) != 0 ? ratingPublishData.e : str3, (i2 & 32) != 0 ? ratingPublishData.f : str4, (i2 & 64) != 0 ? ratingPublishData.g : str5, (i2 & 128) != 0 ? ratingPublishData.h : str6, (i2 & 256) != 0 ? ratingPublishData.i : str7, (i2 & 512) != 0 ? ratingPublishData.j : str8, (i2 & 1024) != 0 ? ratingPublishData.k : z, (i2 & 2048) != 0 ? ratingPublishData.l : str9, (i2 & 4096) != 0 ? ratingPublishData.m : map);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    @Nullable
    public final String component12() {
        return this.l;
    }

    @Nullable
    public final Map<String, String> component13() {
        return this.m;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final Long component3() {
        return this.c;
    }

    @Nullable
    public final Integer component4() {
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

    @Nullable
    public final String component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final RatingPublishData copy(@NotNull String str, @Nullable String str2, @Nullable Long l2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, boolean z, @Nullable String str9, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return new RatingPublishData(str, str2, l2, num, str3, str4, str5, str6, str7, str8, z, str9, map);
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
        if (!(obj instanceof RatingPublishData)) {
            return false;
        }
        RatingPublishData ratingPublishData = (RatingPublishData) obj;
        return Intrinsics.areEqual(this.a, ratingPublishData.a) && Intrinsics.areEqual(this.b, ratingPublishData.b) && Intrinsics.areEqual(this.c, ratingPublishData.c) && Intrinsics.areEqual(this.d, ratingPublishData.d) && Intrinsics.areEqual(this.e, ratingPublishData.e) && Intrinsics.areEqual(this.f, ratingPublishData.f) && Intrinsics.areEqual(this.g, ratingPublishData.g) && Intrinsics.areEqual(this.h, ratingPublishData.h) && Intrinsics.areEqual(this.i, ratingPublishData.i) && Intrinsics.areEqual(this.j, ratingPublishData.j) && this.k == ratingPublishData.k && Intrinsics.areEqual(this.l, ratingPublishData.l) && Intrinsics.areEqual(this.m, ratingPublishData.m);
    }

    @Nullable
    public final String getBuyerInfo() {
        return this.i;
    }

    @Nullable
    public final String getComment() {
        return this.e;
    }

    @Nullable
    public final String getContextId() {
        return this.f;
    }

    @Nullable
    public final Map<String, String> getDynamicParams() {
        return this.m;
    }

    @Nullable
    public final String getFilesOperationId() {
        return this.g;
    }

    @Nullable
    public final String getImages() {
        return this.l;
    }

    @Nullable
    public final String getImagesOperationId() {
        return this.h;
    }

    @Nullable
    public final String getItemId() {
        return this.b;
    }

    @Nullable
    public final Integer getScore() {
        return this.d;
    }

    @Nullable
    public final Long getStageId() {
        return this.c;
    }

    @Nullable
    public final String getStepId() {
        return this.j;
    }

    @NotNull
    public final String getUserKey() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l2 = this.c;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Integer num = this.d;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.g;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.h;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.i;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.j;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        boolean z = this.k;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode10 + i3) * 31;
        String str9 = this.l;
        int hashCode11 = (i6 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Map<String, String> map = this.m;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode11 + i2;
    }

    public final boolean isLastStep() {
        return this.k;
    }

    public final void setBuyerInfo(@Nullable String str) {
        this.i = str;
    }

    public final void setComment(@Nullable String str) {
        this.e = str;
    }

    public final void setContextId(@Nullable String str) {
        this.f = str;
    }

    public final void setDynamicParams(@Nullable Map<String, String> map) {
        this.m = map;
    }

    public final void setFilesOperationId(@Nullable String str) {
        this.g = str;
    }

    public final void setImages(@Nullable String str) {
        this.l = str;
    }

    public final void setImagesOperationId(@Nullable String str) {
        this.h = str;
    }

    public final void setItemId(@Nullable String str) {
        this.b = str;
    }

    public final void setLastStep(boolean z) {
        this.k = z;
    }

    public final void setScore(@Nullable Integer num) {
        this.d = num;
    }

    public final void setStageId(@Nullable Long l2) {
        this.c = l2;
    }

    public final void setStepId(@Nullable String str) {
        this.j = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RatingPublishData(userKey=");
        L.append(this.a);
        L.append(", itemId=");
        L.append(this.b);
        L.append(", stageId=");
        L.append(this.c);
        L.append(", score=");
        L.append(this.d);
        L.append(", comment=");
        L.append(this.e);
        L.append(", contextId=");
        L.append(this.f);
        L.append(", filesOperationId=");
        L.append(this.g);
        L.append(", imagesOperationId=");
        L.append(this.h);
        L.append(", buyerInfo=");
        L.append(this.i);
        L.append(", stepId=");
        L.append(this.j);
        L.append(", isLastStep=");
        L.append(this.k);
        L.append(", images=");
        L.append(this.l);
        L.append(", dynamicParams=");
        return a.x(L, this.m, ")");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r4 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            java.lang.String r4 = r2.a
            r3.writeString(r4)
            java.lang.String r4 = r2.b
            r3.writeString(r4)
            java.lang.Long r4 = r2.c
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0019
            a2.b.a.a.a.I0(r3, r0, r4)
            goto L_0x001c
        L_0x0019:
            r3.writeInt(r1)
        L_0x001c:
            java.lang.Integer r4 = r2.d
            if (r4 == 0) goto L_0x0024
            a2.b.a.a.a.H0(r3, r0, r4)
            goto L_0x0027
        L_0x0024:
            r3.writeInt(r1)
        L_0x0027:
            java.lang.String r4 = r2.e
            r3.writeString(r4)
            java.lang.String r4 = r2.f
            r3.writeString(r4)
            java.lang.String r4 = r2.g
            r3.writeString(r4)
            java.lang.String r4 = r2.h
            r3.writeString(r4)
            java.lang.String r4 = r2.i
            r3.writeString(r4)
            java.lang.String r4 = r2.j
            r3.writeString(r4)
            boolean r4 = r2.k
            r3.writeInt(r4)
            java.lang.String r4 = r2.l
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.m
            if (r4 == 0) goto L_0x0074
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0057:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0057
        L_0x0074:
            r3.writeInt(r1)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.ratings.RatingPublishData.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingPublishData(String str, String str2, Long l2, Integer num, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, Map map, int i2, j jVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : l2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : str7, (i2 & 512) != 0 ? null : str8, (i2 & 1024) != 0 ? false : z, (i2 & 2048) != 0 ? null : str9, (i2 & 4096) == 0 ? map : null);
    }
}
