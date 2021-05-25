package com.avito.android.rating.publish;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b%\b\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f¢\u0006\u0004\bK\u0010LJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J|\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ \u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b)\u0010*R$\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010/R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0004\"\u0004\b3\u00104R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b5\u00101\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00104R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010<R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u00101\u001a\u0004\b>\u0010\u0004\"\u0004\b?\u00104R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u00101\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u00104R$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010GR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u00101\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u00104¨\u0006M"}, d2 = {"Lcom/avito/android/rating/publish/RatingPublishViewData;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/util/Map;", "itemId", "stageId", "score", AbuseSendingResult.COMMENT, "filesOperationId", "imagesOperationId", "buyerInfo", "dynamicParams", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/avito/android/rating/publish/RatingPublishViewData;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/Integer;", "getScore", "setScore", "(Ljava/lang/Integer;)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", "setItemId", "(Ljava/lang/String;)V", g.a, "getBuyerInfo", "setBuyerInfo", "h", "Ljava/util/Map;", "getDynamicParams", "setDynamicParams", "(Ljava/util/Map;)V", "d", "getComment", "setComment", "e", "getFilesOperationId", "setFilesOperationId", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getStageId", "setStageId", "(Ljava/lang/Long;)V", "f", "getImagesOperationId", "setImagesOperationId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingPublishViewData implements Parcelable {
    public static final Parcelable.Creator<RatingPublishViewData> CREATOR = new Creator();
    @Nullable
    public String a;
    @Nullable
    public Long b;
    @Nullable
    public Integer c;
    @Nullable
    public String d;
    @Nullable
    public String e;
    @Nullable
    public String f;
    @Nullable
    public String g;
    @Nullable
    public Map<String, String> h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RatingPublishViewData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishViewData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            }
            return new RatingPublishViewData(readString, valueOf, valueOf2, readString2, readString3, readString4, readString5, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RatingPublishViewData[] newArray(int i) {
            return new RatingPublishViewData[i];
        }
    }

    public RatingPublishViewData() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public RatingPublishViewData(@Nullable String str, @Nullable Long l, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Map<String, String> map) {
        this.a = str;
        this.b = l;
        this.c = num;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = map;
    }

    public static /* synthetic */ RatingPublishViewData copy$default(RatingPublishViewData ratingPublishViewData, String str, Long l, Integer num, String str2, String str3, String str4, String str5, Map map, int i, Object obj) {
        return ratingPublishViewData.copy((i & 1) != 0 ? ratingPublishViewData.a : str, (i & 2) != 0 ? ratingPublishViewData.b : l, (i & 4) != 0 ? ratingPublishViewData.c : num, (i & 8) != 0 ? ratingPublishViewData.d : str2, (i & 16) != 0 ? ratingPublishViewData.e : str3, (i & 32) != 0 ? ratingPublishViewData.f : str4, (i & 64) != 0 ? ratingPublishViewData.g : str5, (i & 128) != 0 ? ratingPublishViewData.h : map);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Long component2() {
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
    public final Map<String, String> component8() {
        return this.h;
    }

    @NotNull
    public final RatingPublishViewData copy(@Nullable String str, @Nullable Long l, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Map<String, String> map) {
        return new RatingPublishViewData(str, l, num, str2, str3, str4, str5, map);
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
        if (!(obj instanceof RatingPublishViewData)) {
            return false;
        }
        RatingPublishViewData ratingPublishViewData = (RatingPublishViewData) obj;
        return Intrinsics.areEqual(this.a, ratingPublishViewData.a) && Intrinsics.areEqual(this.b, ratingPublishViewData.b) && Intrinsics.areEqual(this.c, ratingPublishViewData.c) && Intrinsics.areEqual(this.d, ratingPublishViewData.d) && Intrinsics.areEqual(this.e, ratingPublishViewData.e) && Intrinsics.areEqual(this.f, ratingPublishViewData.f) && Intrinsics.areEqual(this.g, ratingPublishViewData.g) && Intrinsics.areEqual(this.h, ratingPublishViewData.h);
    }

    @Nullable
    public final String getBuyerInfo() {
        return this.g;
    }

    @Nullable
    public final String getComment() {
        return this.d;
    }

    @Nullable
    public final Map<String, String> getDynamicParams() {
        return this.h;
    }

    @Nullable
    public final String getFilesOperationId() {
        return this.e;
    }

    @Nullable
    public final String getImagesOperationId() {
        return this.f;
    }

    @Nullable
    public final String getItemId() {
        return this.a;
    }

    @Nullable
    public final Integer getScore() {
        return this.c;
    }

    @Nullable
    public final Long getStageId() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.b;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 31;
        Integer num = this.c;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.g;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Map<String, String> map = this.h;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode7 + i;
    }

    public final void setBuyerInfo(@Nullable String str) {
        this.g = str;
    }

    public final void setComment(@Nullable String str) {
        this.d = str;
    }

    public final void setDynamicParams(@Nullable Map<String, String> map) {
        this.h = map;
    }

    public final void setFilesOperationId(@Nullable String str) {
        this.e = str;
    }

    public final void setImagesOperationId(@Nullable String str) {
        this.f = str;
    }

    public final void setItemId(@Nullable String str) {
        this.a = str;
    }

    public final void setScore(@Nullable Integer num) {
        this.c = num;
    }

    public final void setStageId(@Nullable Long l) {
        this.b = l;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RatingPublishViewData(itemId=");
        L.append(this.a);
        L.append(", stageId=");
        L.append(this.b);
        L.append(", score=");
        L.append(this.c);
        L.append(", comment=");
        L.append(this.d);
        L.append(", filesOperationId=");
        L.append(this.e);
        L.append(", imagesOperationId=");
        L.append(this.f);
        L.append(", buyerInfo=");
        L.append(this.g);
        L.append(", dynamicParams=");
        return a.x(L, this.h, ")");
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
            java.lang.Long r4 = r2.b
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0014
            a2.b.a.a.a.I0(r3, r0, r4)
            goto L_0x0017
        L_0x0014:
            r3.writeInt(r1)
        L_0x0017:
            java.lang.Integer r4 = r2.c
            if (r4 == 0) goto L_0x001f
            a2.b.a.a.a.H0(r3, r0, r4)
            goto L_0x0022
        L_0x001f:
            r3.writeInt(r1)
        L_0x0022:
            java.lang.String r4 = r2.d
            r3.writeString(r4)
            java.lang.String r4 = r2.e
            r3.writeString(r4)
            java.lang.String r4 = r2.f
            r3.writeString(r4)
            java.lang.String r4 = r2.g
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.h
            if (r4 == 0) goto L_0x005b
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x003e:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x005e
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x003e
        L_0x005b:
            r3.writeInt(r1)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.publish.RatingPublishViewData.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingPublishViewData(String str, Long l, Integer num, String str2, String str3, String str4, String str5, Map map, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? map : null);
    }
}
