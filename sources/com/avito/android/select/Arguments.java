package com.avito.android.select;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b$\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0012\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\u0006\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u0012\b\b\u0002\u0010%\u001a\u00020\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bV\u0010WJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\rJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\rJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J¸\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u0004J\u0010\u0010*\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b0\u0010+J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b5\u00106R\u0019\u0010%\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\rR%\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\bR\u0019\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010\rR%\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010\bR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bA\u00108\u001a\u0004\bB\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010D\u001a\u0004\bG\u0010\u0004R\u0019\u0010!\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bH\u00108\u001a\u0004\b!\u0010\rR\u001b\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bK\u00108\u001a\u0004\bL\u0010\rR\u001b\u0010#\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u0015R\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bP\u00108\u001a\u0004\bQ\u0010\rR\u0019\u0010$\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bR\u00108\u001a\u0004\bS\u0010\rR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bT\u00108\u001a\u0004\bU\u0010\r¨\u0006X"}, d2 = {"Lcom/avito/android/select/Arguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "component2", "()Ljava/util/List;", "component3", "component4", "", "component5", "()Z", "component6", "component7", "component8", "component9", "component10", "", "component11", "()Ljava/lang/Integer;", "component12", "component13", "component14", "requestId", "variants", "selected", "title", "showSearch", "multiSelect", "canClear", "requestFocus", "isRedesign", "typoCorrectionEnabled", "attributeId", "withImages", "shouldExposeImageFilterGroup", "titlePattern", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZZZZZLjava/lang/Integer;ZZLjava/lang/String;)Lcom/avito/android/select/Arguments;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.OPEN_CHANNEL_LIST, "Z", "getShouldExposeImageFilterGroup", "c", "Ljava/util/List;", "getSelected", "e", "getShowSearch", AuthSource.BOOKING_ORDER, "getVariants", "h", "getRequestFocus", "d", "Ljava/lang/String;", "getTitle", AuthSource.SEND_ABUSE, "getRequestId", "i", "n", "getTitlePattern", "f", "getMultiSelect", "k", "Ljava/lang/Integer;", "getAttributeId", "j", "getTypoCorrectionEnabled", "l", "getWithImages", g.a, "getCanClear", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZZZZZZLjava/lang/Integer;ZZLjava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class Arguments implements Parcelable {
    public static final Parcelable.Creator<Arguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final List<ParcelableEntity<String>> b;
    @NotNull
    public final List<ParcelableEntity<String>> c;
    @NotNull
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    @Nullable
    public final Integer k;
    public final boolean l;
    public final boolean m;
    @Nullable
    public final String n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Arguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Arguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((ParcelableEntity) parcel.readParcelable(Arguments.class.getClassLoader()));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((ParcelableEntity) parcel.readParcelable(Arguments.class.getClassLoader()));
                readInt2--;
            }
            return new Arguments(readString, arrayList, arrayList2, parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Arguments[] newArray(int i) {
            return new Arguments[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public Arguments(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull List<? extends ParcelableEntity<String>> list2, @NotNull String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, @Nullable Integer num, boolean z8, boolean z9, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "variants");
        Intrinsics.checkNotNullParameter(list2, "selected");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.a = str;
        this.b = list;
        this.c = list2;
        this.d = str2;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = z5;
        this.j = z7;
        this.k = num;
        this.l = z8;
        this.m = z9;
        this.n = str3;
    }

    public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, List list, List list2, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, Integer num, boolean z8, boolean z9, String str3, int i2, Object obj) {
        return arguments.copy((i2 & 1) != 0 ? arguments.a : str, (i2 & 2) != 0 ? arguments.b : list, (i2 & 4) != 0 ? arguments.c : list2, (i2 & 8) != 0 ? arguments.d : str2, (i2 & 16) != 0 ? arguments.e : z, (i2 & 32) != 0 ? arguments.f : z2, (i2 & 64) != 0 ? arguments.g : z3, (i2 & 128) != 0 ? arguments.h : z4, (i2 & 256) != 0 ? arguments.i : z5, (i2 & 512) != 0 ? arguments.j : z7, (i2 & 1024) != 0 ? arguments.k : num, (i2 & 2048) != 0 ? arguments.l : z8, (i2 & 4096) != 0 ? arguments.m : z9, (i2 & 8192) != 0 ? arguments.n : str3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    @Nullable
    public final Integer component11() {
        return this.k;
    }

    public final boolean component12() {
        return this.l;
    }

    public final boolean component13() {
        return this.m;
    }

    @Nullable
    public final String component14() {
        return this.n;
    }

    @NotNull
    public final List<ParcelableEntity<String>> component2() {
        return this.b;
    }

    @NotNull
    public final List<ParcelableEntity<String>> component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final Arguments copy(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull List<? extends ParcelableEntity<String>> list2, @NotNull String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, @Nullable Integer num, boolean z8, boolean z9, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "variants");
        Intrinsics.checkNotNullParameter(list2, "selected");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new Arguments(str, list, list2, str2, z, z2, z3, z4, z5, z7, num, z8, z9, str3);
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
        if (!(obj instanceof Arguments)) {
            return false;
        }
        Arguments arguments = (Arguments) obj;
        return Intrinsics.areEqual(this.a, arguments.a) && Intrinsics.areEqual(this.b, arguments.b) && Intrinsics.areEqual(this.c, arguments.c) && Intrinsics.areEqual(this.d, arguments.d) && this.e == arguments.e && this.f == arguments.f && this.g == arguments.g && this.h == arguments.h && this.i == arguments.i && this.j == arguments.j && Intrinsics.areEqual(this.k, arguments.k) && this.l == arguments.l && this.m == arguments.m && Intrinsics.areEqual(this.n, arguments.n);
    }

    @Nullable
    public final Integer getAttributeId() {
        return this.k;
    }

    public final boolean getCanClear() {
        return this.g;
    }

    public final boolean getMultiSelect() {
        return this.f;
    }

    public final boolean getRequestFocus() {
        return this.h;
    }

    @NotNull
    public final String getRequestId() {
        return this.a;
    }

    @NotNull
    public final List<ParcelableEntity<String>> getSelected() {
        return this.c;
    }

    public final boolean getShouldExposeImageFilterGroup() {
        return this.m;
    }

    public final boolean getShowSearch() {
        return this.e;
    }

    @NotNull
    public final String getTitle() {
        return this.d;
    }

    @Nullable
    public final String getTitlePattern() {
        return this.n;
    }

    public final boolean getTypoCorrectionEnabled() {
        return this.j;
    }

    @NotNull
    public final List<ParcelableEntity<String>> getVariants() {
        return this.b;
    }

    public final boolean getWithImages() {
        return this.l;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ParcelableEntity<String>> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ParcelableEntity<String>> list2 = this.c;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.e;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode4 + i4) * 31;
        boolean z2 = this.f;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.g;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i11 + i12) * 31;
        boolean z4 = this.h;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (i15 + i16) * 31;
        boolean z5 = this.i;
        if (z5) {
            z5 = true;
        }
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = z5 ? 1 : 0;
        int i23 = (i19 + i20) * 31;
        boolean z7 = this.j;
        if (z7) {
            z7 = true;
        }
        int i24 = z7 ? 1 : 0;
        int i25 = z7 ? 1 : 0;
        int i26 = z7 ? 1 : 0;
        int i27 = (i23 + i24) * 31;
        Integer num = this.k;
        int hashCode5 = (i27 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z8 = this.l;
        if (z8) {
            z8 = true;
        }
        int i28 = z8 ? 1 : 0;
        int i29 = z8 ? 1 : 0;
        int i30 = z8 ? 1 : 0;
        int i31 = (hashCode5 + i28) * 31;
        boolean z9 = this.m;
        if (!z9) {
            i3 = z9 ? 1 : 0;
        }
        int i32 = (i31 + i3) * 31;
        String str3 = this.n;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i32 + i2;
    }

    public final boolean isRedesign() {
        return this.i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Arguments(requestId=");
        L.append(this.a);
        L.append(", variants=");
        L.append(this.b);
        L.append(", selected=");
        L.append(this.c);
        L.append(", title=");
        L.append(this.d);
        L.append(", showSearch=");
        L.append(this.e);
        L.append(", multiSelect=");
        L.append(this.f);
        L.append(", canClear=");
        L.append(this.g);
        L.append(", requestFocus=");
        L.append(this.h);
        L.append(", isRedesign=");
        L.append(this.i);
        L.append(", typoCorrectionEnabled=");
        L.append(this.j);
        L.append(", attributeId=");
        L.append(this.k);
        L.append(", withImages=");
        L.append(this.l);
        L.append(", shouldExposeImageFilterGroup=");
        L.append(this.m);
        L.append(", titlePattern=");
        return a.t(L, this.n, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        Iterator n0 = a.n0(this.b, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((ParcelableEntity) n0.next(), i2);
        }
        Iterator n02 = a.n0(this.c, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((ParcelableEntity) n02.next(), i2);
        }
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        Integer num = this.k;
        if (num != null) {
            parcel.writeInt(1);
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeString(this.n);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Arguments(String str, List list, List list2, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, Integer num, boolean z8, boolean z9, String str3, int i2, j jVar) {
        this(str, list, list2, str2, z, z2, z3, z4, z5, (i2 & 512) != 0 ? false : z7, (i2 & 1024) != 0 ? -1 : num, (i2 & 2048) != 0 ? false : z8, (i2 & 4096) != 0 ? false : z9, (i2 & 8192) != 0 ? null : str3);
    }
}
