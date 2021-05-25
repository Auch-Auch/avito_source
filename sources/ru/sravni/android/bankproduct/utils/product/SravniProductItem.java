package ru.sravni.android.bankproduct.utils.product;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b@\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b%\u0010\u0007J\u0010\u0010&\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b&\u0010\fJ\u001a\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0018\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0004R\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u0010\fR\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010+\u001a\u0004\b8\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010\u0007R\u001b\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010+\u001a\u0004\b<\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00100\u001a\u0004\b>\u0010\fR\u001b\u0010!\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010+\u001a\u0004\b@\u0010\u0007R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010+\u001a\u0004\bE\u0010\u0007R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010+\u001a\u0004\bG\u0010\u0007¨\u0006J"}, d2 = {"Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()I", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Integer;", "component11", "component12", "component13", "webView", "urlProduct", "title", "chatName", "colorProduct", "colorProgressBackground", "iconProduct", "status", "conversationID", "progress", "progressString", "version", "analyticProductName", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/utils/product/SravniProductItem;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "i", "Ljava/lang/String;", "getConversationID", "c", "getTitle", g.a, "I", "getIconProduct", AuthSource.SEND_ABUSE, "Z", "getWebView", "e", "getColorProduct", AuthSource.OPEN_CHANNEL_LIST, "getAnalyticProductName", AuthSource.BOOKING_ORDER, "getUrlProduct", "k", "getProgressString", "f", "getColorProgressBackground", "l", "getVersion", "j", "Ljava/lang/Integer;", "getProgress", "d", "getChatName", "h", "getStatus", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniProductItem {
    public final boolean a;
    @Nullable
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final Integer j;
    @Nullable
    public final String k;
    @Nullable
    public final String l;
    @NotNull
    public final String m;

    public SravniProductItem(boolean z, @Nullable String str, @NotNull String str2, @NotNull String str3, int i2, int i3, int i4, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable String str7, @NotNull String str8) {
        a.a1(str2, "title", str3, "chatName", str8, "analyticProductName");
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = str4;
        this.i = str5;
        this.j = num;
        this.k = str6;
        this.l = str7;
        this.m = str8;
    }

    public static /* synthetic */ SravniProductItem copy$default(SravniProductItem sravniProductItem, boolean z, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, Integer num, String str6, String str7, String str8, int i5, Object obj) {
        return sravniProductItem.copy((i5 & 1) != 0 ? sravniProductItem.a : z, (i5 & 2) != 0 ? sravniProductItem.b : str, (i5 & 4) != 0 ? sravniProductItem.c : str2, (i5 & 8) != 0 ? sravniProductItem.d : str3, (i5 & 16) != 0 ? sravniProductItem.e : i2, (i5 & 32) != 0 ? sravniProductItem.f : i3, (i5 & 64) != 0 ? sravniProductItem.g : i4, (i5 & 128) != 0 ? sravniProductItem.h : str4, (i5 & 256) != 0 ? sravniProductItem.i : str5, (i5 & 512) != 0 ? sravniProductItem.j : num, (i5 & 1024) != 0 ? sravniProductItem.k : str6, (i5 & 2048) != 0 ? sravniProductItem.l : str7, (i5 & 4096) != 0 ? sravniProductItem.m : str8);
    }

    public final boolean component1() {
        return this.a;
    }

    @Nullable
    public final Integer component10() {
        return this.j;
    }

    @Nullable
    public final String component11() {
        return this.k;
    }

    @Nullable
    public final String component12() {
        return this.l;
    }

    @NotNull
    public final String component13() {
        return this.m;
    }

    @Nullable
    public final String component2() {
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

    public final int component5() {
        return this.e;
    }

    public final int component6() {
        return this.f;
    }

    public final int component7() {
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
    public final SravniProductItem copy(boolean z, @Nullable String str, @NotNull String str2, @NotNull String str3, int i2, int i3, int i4, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable String str6, @Nullable String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(str3, "chatName");
        Intrinsics.checkParameterIsNotNull(str8, "analyticProductName");
        return new SravniProductItem(z, str, str2, str3, i2, i3, i4, str4, str5, num, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SravniProductItem)) {
            return false;
        }
        SravniProductItem sravniProductItem = (SravniProductItem) obj;
        return this.a == sravniProductItem.a && Intrinsics.areEqual(this.b, sravniProductItem.b) && Intrinsics.areEqual(this.c, sravniProductItem.c) && Intrinsics.areEqual(this.d, sravniProductItem.d) && this.e == sravniProductItem.e && this.f == sravniProductItem.f && this.g == sravniProductItem.g && Intrinsics.areEqual(this.h, sravniProductItem.h) && Intrinsics.areEqual(this.i, sravniProductItem.i) && Intrinsics.areEqual(this.j, sravniProductItem.j) && Intrinsics.areEqual(this.k, sravniProductItem.k) && Intrinsics.areEqual(this.l, sravniProductItem.l) && Intrinsics.areEqual(this.m, sravniProductItem.m);
    }

    @NotNull
    public final String getAnalyticProductName() {
        return this.m;
    }

    @NotNull
    public final String getChatName() {
        return this.d;
    }

    public final int getColorProduct() {
        return this.e;
    }

    public final int getColorProgressBackground() {
        return this.f;
    }

    @Nullable
    public final String getConversationID() {
        return this.i;
    }

    public final int getIconProduct() {
        return this.g;
    }

    @Nullable
    public final Integer getProgress() {
        return this.j;
    }

    @Nullable
    public final String getProgressString() {
        return this.k;
    }

    @Nullable
    public final String getStatus() {
        return this.h;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Nullable
    public final String getUrlProduct() {
        return this.b;
    }

    @Nullable
    public final String getVersion() {
        return this.l;
    }

    public final boolean getWebView() {
        return this.a;
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = i2 * 31;
        String str = this.b;
        int i6 = 0;
        int hashCode = (i5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (((((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
        String str4 = this.h;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.j;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        String str6 = this.k;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.l;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.m;
        if (str8 != null) {
            i6 = str8.hashCode();
        }
        return hashCode8 + i6;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SravniProductItem(webView=");
        L.append(this.a);
        L.append(", urlProduct=");
        L.append(this.b);
        L.append(", title=");
        L.append(this.c);
        L.append(", chatName=");
        L.append(this.d);
        L.append(", colorProduct=");
        L.append(this.e);
        L.append(", colorProgressBackground=");
        L.append(this.f);
        L.append(", iconProduct=");
        L.append(this.g);
        L.append(", status=");
        L.append(this.h);
        L.append(", conversationID=");
        L.append(this.i);
        L.append(", progress=");
        L.append(this.j);
        L.append(", progressString=");
        L.append(this.k);
        L.append(", version=");
        L.append(this.l);
        L.append(", analyticProductName=");
        return a.t(L, this.m, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SravniProductItem(boolean z, String str, String str2, String str3, int i2, int i3, int i4, String str4, String str5, Integer num, String str6, String str7, String str8, int i5, j jVar) {
        this(z, (i5 & 2) != 0 ? null : str, str2, str3, i2, i3, i4, (i5 & 128) != 0 ? null : str4, (i5 & 256) != 0 ? null : str5, (i5 & 512) != 0 ? null : num, (i5 & 1024) != 0 ? null : str6, (i5 & 2048) != 0 ? null : str7, str8);
    }
}
