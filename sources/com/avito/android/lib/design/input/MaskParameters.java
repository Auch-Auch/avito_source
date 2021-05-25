package com.avito.android.lib.design.input;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0012\u0012\b\b\u0002\u0010#\u001a\u00020\u0015¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u0004J\u0010\u0010'\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b'\u0010\u0017J\u001a\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b,\u0010\u0017J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b1\u00102R\u0019\u0010\u001c\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0004R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b8\u00106\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u0010;R\u0019\u0010\"\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0014R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bC\u00104\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bD\u00104\u001a\u0004\b\u0019\u0010\u0007R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010IR\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bJ\u00106\u001a\u0004\bK\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bL\u00104\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010#\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0017¨\u0006R"}, d2 = {"Lcom/avito/android/lib/design/input/MaskParameters;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Ljava/util/List;", "component10", "", "component11", "()C", "", "component12", "()I", "prefix", "isPrefixSelectionAllowed", "postfix", "divider", "isPostfixSelectionAllowed", "mask", "isReversedMask", "isOverpastingAllowed", "removableStringsFromStartOnPasting", "removableDuplicateStringFromStart", "decimalSeparator", "decimalPlaces", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/util/List;Ljava/lang/String;CI)Lcom/avito/android/lib/design/input/MaskParameters;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "Z", "d", "Ljava/lang/String;", "getDivider", "j", "getRemovableDuplicateStringFromStart", "setRemovableDuplicateStringFromStart", "(Ljava/lang/String;)V", "k", "C", "getDecimalSeparator", "f", "getMask", "c", "getPostfix", g.a, AuthSource.BOOKING_ORDER, "i", "Ljava/util/List;", "getRemovableStringsFromStartOnPasting", "setRemovableStringsFromStartOnPasting", "(Ljava/util/List;)V", AuthSource.SEND_ABUSE, "getPrefix", "h", "l", "I", "getDecimalPlaces", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/util/List;Ljava/lang/String;CI)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class MaskParameters implements Parcelable {
    public static final Parcelable.Creator<MaskParameters> CREATOR = new Creator();
    @NotNull
    public final String a;
    public final boolean b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public final boolean e;
    @NotNull
    public final String f;
    public final boolean g;
    public final boolean h;
    @NotNull
    public List<String> i;
    @NotNull
    public String j;
    public final char k;
    public final int l;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MaskParameters> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MaskParameters createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MaskParameters(parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.createStringArrayList(), parcel.readString(), (char) parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MaskParameters[] newArray(int i) {
            return new MaskParameters[i];
        }
    }

    public MaskParameters() {
        this(null, false, null, null, false, null, false, false, null, null, 0, 0, 4095, null);
    }

    public MaskParameters(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, boolean z2, @NotNull String str4, boolean z3, boolean z4, @NotNull List<String> list, @NotNull String str5, char c2, int i2) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, "postfix");
        Intrinsics.checkNotNullParameter(str3, "divider");
        Intrinsics.checkNotNullParameter(str4, "mask");
        Intrinsics.checkNotNullParameter(list, "removableStringsFromStartOnPasting");
        Intrinsics.checkNotNullParameter(str5, "removableDuplicateStringFromStart");
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = str3;
        this.e = z2;
        this.f = str4;
        this.g = z3;
        this.h = z4;
        this.i = list;
        this.j = str5;
        this.k = c2;
        this.l = i2;
    }

    public static /* synthetic */ MaskParameters copy$default(MaskParameters maskParameters, String str, boolean z, String str2, String str3, boolean z2, String str4, boolean z3, boolean z4, List list, String str5, char c2, int i2, int i3, Object obj) {
        return maskParameters.copy((i3 & 1) != 0 ? maskParameters.a : str, (i3 & 2) != 0 ? maskParameters.b : z, (i3 & 4) != 0 ? maskParameters.c : str2, (i3 & 8) != 0 ? maskParameters.d : str3, (i3 & 16) != 0 ? maskParameters.e : z2, (i3 & 32) != 0 ? maskParameters.f : str4, (i3 & 64) != 0 ? maskParameters.g : z3, (i3 & 128) != 0 ? maskParameters.h : z4, (i3 & 256) != 0 ? maskParameters.i : list, (i3 & 512) != 0 ? maskParameters.j : str5, (i3 & 1024) != 0 ? maskParameters.k : c2, (i3 & 2048) != 0 ? maskParameters.l : i2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component10() {
        return this.j;
    }

    public final char component11() {
        return this.k;
    }

    public final int component12() {
        return this.l;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    @NotNull
    public final List<String> component9() {
        return this.i;
    }

    @NotNull
    public final MaskParameters copy(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, boolean z2, @NotNull String str4, boolean z3, boolean z4, @NotNull List<String> list, @NotNull String str5, char c2, int i2) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, "postfix");
        Intrinsics.checkNotNullParameter(str3, "divider");
        Intrinsics.checkNotNullParameter(str4, "mask");
        Intrinsics.checkNotNullParameter(list, "removableStringsFromStartOnPasting");
        Intrinsics.checkNotNullParameter(str5, "removableDuplicateStringFromStart");
        return new MaskParameters(str, z, str2, str3, z2, str4, z3, z4, list, str5, c2, i2);
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
        if (!(obj instanceof MaskParameters)) {
            return false;
        }
        MaskParameters maskParameters = (MaskParameters) obj;
        return Intrinsics.areEqual(this.a, maskParameters.a) && this.b == maskParameters.b && Intrinsics.areEqual(this.c, maskParameters.c) && Intrinsics.areEqual(this.d, maskParameters.d) && this.e == maskParameters.e && Intrinsics.areEqual(this.f, maskParameters.f) && this.g == maskParameters.g && this.h == maskParameters.h && Intrinsics.areEqual(this.i, maskParameters.i) && Intrinsics.areEqual(this.j, maskParameters.j) && this.k == maskParameters.k && this.l == maskParameters.l;
    }

    public final int getDecimalPlaces() {
        return this.l;
    }

    public final char getDecimalSeparator() {
        return this.k;
    }

    @NotNull
    public final String getDivider() {
        return this.d;
    }

    @NotNull
    public final String getMask() {
        return this.f;
    }

    @NotNull
    public final String getPostfix() {
        return this.c;
    }

    @NotNull
    public final String getPrefix() {
        return this.a;
    }

    @NotNull
    public final String getRemovableDuplicateStringFromStart() {
        return this.j;
    }

    @NotNull
    public final List<String> getRemovableStringsFromStartOnPasting() {
        return this.i;
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
        String str2 = this.c;
        int hashCode2 = (i7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.e;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (hashCode3 + i8) * 31;
        String str4 = this.f;
        int hashCode4 = (i11 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z3 = this.g;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (hashCode4 + i12) * 31;
        boolean z4 = this.h;
        if (!z4) {
            i3 = z4 ? 1 : 0;
        }
        int i16 = (i15 + i3) * 31;
        List<String> list = this.i;
        int hashCode5 = (i16 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.j;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return ((((hashCode5 + i2) * 31) + this.k) * 31) + this.l;
    }

    public final boolean isOverpastingAllowed() {
        return this.h;
    }

    public final boolean isPostfixSelectionAllowed() {
        return this.e;
    }

    public final boolean isPrefixSelectionAllowed() {
        return this.b;
    }

    public final boolean isReversedMask() {
        return this.g;
    }

    public final void setRemovableDuplicateStringFromStart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void setRemovableStringsFromStartOnPasting(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.i = list;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MaskParameters(prefix=");
        L.append(this.a);
        L.append(", isPrefixSelectionAllowed=");
        L.append(this.b);
        L.append(", postfix=");
        L.append(this.c);
        L.append(", divider=");
        L.append(this.d);
        L.append(", isPostfixSelectionAllowed=");
        L.append(this.e);
        L.append(", mask=");
        L.append(this.f);
        L.append(", isReversedMask=");
        L.append(this.g);
        L.append(", isOverpastingAllowed=");
        L.append(this.h);
        L.append(", removableStringsFromStartOnPasting=");
        L.append(this.i);
        L.append(", removableDuplicateStringFromStart=");
        L.append(this.j);
        L.append(", decimalSeparator=");
        L.append(this.k);
        L.append(", decimalPlaces=");
        return a.j(L, this.l, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeInt(this.b ? 1 : 0);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeStringList(this.i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MaskParameters(java.lang.String r13, boolean r14, java.lang.String r15, java.lang.String r16, boolean r17, java.lang.String r18, boolean r19, boolean r20, java.util.List r21, java.lang.String r22, char r23, int r24, int r25, t6.r.a.j r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = 0
            goto L_0x0013
        L_0x0012:
            r3 = r14
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = r2
            goto L_0x001a
        L_0x0019:
            r5 = r15
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            java.lang.String r6 = " "
            goto L_0x0023
        L_0x0021:
            r6 = r16
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r17
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r2
            goto L_0x0033
        L_0x0031:
            r8 = r18
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r19
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r4 = r20
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x004d
        L_0x004b:
            r10 = r21
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r2 = r22
        L_0x0054:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x005b
            r11 = 46
            goto L_0x005d
        L_0x005b:
            r11 = r23
        L_0x005d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0063
            r0 = 2
            goto L_0x0065
        L_0x0063:
            r0 = r24
        L_0x0065:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r4
            r22 = r10
            r23 = r2
            r24 = r11
            r25 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.input.MaskParameters.<init>(java.lang.String, boolean, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, boolean, java.util.List, java.lang.String, char, int, int, t6.r.a.j):void");
    }
}
