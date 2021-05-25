package com.avito.android;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b4\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J \u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010\u0004R)\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u0010\nR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\r¨\u00066"}, d2 = {"Lcom/avito/android/SummaryState;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/util/Map;", "", "component6", "()Z", "markerId", "fiasGuid", "serviceId", BookingInfoActivity.EXTRA_ITEM_ID, "contacts", "skipMap", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lcom/avito/android/SummaryState;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMarkerId", AuthSource.BOOKING_ORDER, "getFiasGuid", "d", "getAdvertId", "c", "getServiceId", "e", "Ljava/util/Map;", "getContacts", "f", "Z", "getSkipMap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SummaryState implements Parcelable {
    public static final Parcelable.Creator<SummaryState> CREATOR = new Creator();
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Map<String, String> e;
    public final boolean f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SummaryState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SummaryState createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new SummaryState(readString, readString2, readString3, readString4, linkedHashMap, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SummaryState[] newArray(int i) {
            return new SummaryState[i];
        }
    }

    public SummaryState() {
        this(null, null, null, null, null, false, 63, null);
    }

    public SummaryState(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = map;
        this.f = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.SummaryState */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SummaryState copy$default(SummaryState summaryState, String str, String str2, String str3, String str4, Map map, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = summaryState.a;
        }
        if ((i & 2) != 0) {
            str2 = summaryState.b;
        }
        if ((i & 4) != 0) {
            str3 = summaryState.c;
        }
        if ((i & 8) != 0) {
            str4 = summaryState.d;
        }
        if ((i & 16) != 0) {
            map = summaryState.e;
        }
        if ((i & 32) != 0) {
            z = summaryState.f;
        }
        return summaryState.copy(str, str2, str3, str4, map, z);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Map<String, String> component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    @NotNull
    public final SummaryState copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, String> map, boolean z) {
        return new SummaryState(str, str2, str3, str4, map, z);
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
        if (!(obj instanceof SummaryState)) {
            return false;
        }
        SummaryState summaryState = (SummaryState) obj;
        return Intrinsics.areEqual(this.a, summaryState.a) && Intrinsics.areEqual(this.b, summaryState.b) && Intrinsics.areEqual(this.c, summaryState.c) && Intrinsics.areEqual(this.d, summaryState.d) && Intrinsics.areEqual(this.e, summaryState.e) && this.f == summaryState.f;
    }

    @Nullable
    public final String getAdvertId() {
        return this.d;
    }

    @Nullable
    public final Map<String, String> getContacts() {
        return this.e;
    }

    @Nullable
    public final String getFiasGuid() {
        return this.b;
    }

    @Nullable
    public final String getMarkerId() {
        return this.a;
    }

    @Nullable
    public final String getServiceId() {
        return this.c;
    }

    public final boolean getSkipMap() {
        return this.f;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Map<String, String> map = this.e;
        if (map != null) {
            i = map.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.f;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SummaryState(markerId=");
        L.append(this.a);
        L.append(", fiasGuid=");
        L.append(this.b);
        L.append(", serviceId=");
        L.append(this.c);
        L.append(", advertId=");
        L.append(this.d);
        L.append(", contacts=");
        L.append(this.e);
        L.append(", skipMap=");
        return a.B(L, this.f, ")");
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
            java.lang.String r4 = r2.c
            r3.writeString(r4)
            java.lang.String r4 = r2.d
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.e
            if (r4 == 0) goto L_0x003f
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0022:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0022
        L_0x003f:
            r4 = 0
            r3.writeInt(r4)
        L_0x0043:
            boolean r4 = r2.f
            r3.writeInt(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.SummaryState.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SummaryState(String str, String str2, String str3, String str4, Map map, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) == 0 ? map : null, (i & 32) != 0 ? false : z);
    }
}
