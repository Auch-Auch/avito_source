package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\tR\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\f¨\u0006("}, d2 = {"Lcom/avito/android/html_formatter/HtmlRenderOptions;", "", "", "component1", "()I", "component2", "component3", "", "component4", "()Ljava/lang/String;", "", "component5", "()Z", "listBulletLeftMargin", "listBulletRightMargin", "listBulletWidth", "listBullet", "markupForEdit", "copy", "(IIILjava/lang/String;Z)Lcom/avito/android/html_formatter/HtmlRenderOptions;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getListBulletWidth", AuthSource.BOOKING_ORDER, "getListBulletRightMargin", AuthSource.SEND_ABUSE, "getListBulletLeftMargin", "d", "Ljava/lang/String;", "getListBullet", "e", "Z", "getMarkupForEdit", "<init>", "(IIILjava/lang/String;Z)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class HtmlRenderOptions {
    public final int a;
    public final int b;
    public final int c;
    @NotNull
    public final String d;
    public final boolean e;

    public HtmlRenderOptions(int i, int i2, int i3, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "listBullet");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        this.e = z;
    }

    public static /* synthetic */ HtmlRenderOptions copy$default(HtmlRenderOptions htmlRenderOptions, int i, int i2, int i3, String str, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = htmlRenderOptions.a;
        }
        if ((i4 & 2) != 0) {
            i2 = htmlRenderOptions.b;
        }
        if ((i4 & 4) != 0) {
            i3 = htmlRenderOptions.c;
        }
        if ((i4 & 8) != 0) {
            str = htmlRenderOptions.d;
        }
        if ((i4 & 16) != 0) {
            z = htmlRenderOptions.e;
        }
        return htmlRenderOptions.copy(i, i2, i3, str, z);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
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
    public final HtmlRenderOptions copy(int i, int i2, int i3, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "listBullet");
        return new HtmlRenderOptions(i, i2, i3, str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HtmlRenderOptions)) {
            return false;
        }
        HtmlRenderOptions htmlRenderOptions = (HtmlRenderOptions) obj;
        return this.a == htmlRenderOptions.a && this.b == htmlRenderOptions.b && this.c == htmlRenderOptions.c && Intrinsics.areEqual(this.d, htmlRenderOptions.d) && this.e == htmlRenderOptions.e;
    }

    @NotNull
    public final String getListBullet() {
        return this.d;
    }

    public final int getListBulletLeftMargin() {
        return this.a;
    }

    public final int getListBulletRightMargin() {
        return this.b;
    }

    public final int getListBulletWidth() {
        return this.c;
    }

    public final boolean getMarkupForEdit() {
        return this.e;
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        String str = this.d;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("HtmlRenderOptions(listBulletLeftMargin=");
        L.append(this.a);
        L.append(", listBulletRightMargin=");
        L.append(this.b);
        L.append(", listBulletWidth=");
        L.append(this.c);
        L.append(", listBullet=");
        L.append(this.d);
        L.append(", markupForEdit=");
        return a.B(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HtmlRenderOptions(int i, int i2, int i3, String str, boolean z, int i4, j jVar) {
        this(i, i2, i3, str, (i4 & 16) != 0 ? false : z);
    }
}
