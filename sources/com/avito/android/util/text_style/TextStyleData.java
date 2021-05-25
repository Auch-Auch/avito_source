package com.avito.android.util.text_style;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J>\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010 R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u0006¨\u0006%"}, d2 = {"Lcom/avito/android/util/text_style/TextStyleData;", "", "", "component1", "()I", "component2", "()Ljava/lang/Integer;", "component3", "component4", "linkStyle", "lineHeight", "paragraphSpacing", "textColorLink", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/avito/android/util/text_style/TextStyleData;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/Integer;", "getParagraphSpacing", AuthSource.SEND_ABUSE, "I", "getLinkStyle", "d", "getTextColorLink", "setTextColorLink", "(Ljava/lang/Integer;)V", AuthSource.BOOKING_ORDER, "getLineHeight", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class TextStyleData {
    public final int a;
    @Nullable
    public final Integer b;
    @Nullable
    public final Integer c;
    @Nullable
    public Integer d;

    public TextStyleData(int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.a = i;
        this.b = num;
        this.c = num2;
        this.d = num3;
    }

    public static /* synthetic */ TextStyleData copy$default(TextStyleData textStyleData, int i, Integer num, Integer num2, Integer num3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = textStyleData.a;
        }
        if ((i2 & 2) != 0) {
            num = textStyleData.b;
        }
        if ((i2 & 4) != 0) {
            num2 = textStyleData.c;
        }
        if ((i2 & 8) != 0) {
            num3 = textStyleData.d;
        }
        return textStyleData.copy(i, num, num2, num3);
    }

    public final int component1() {
        return this.a;
    }

    @Nullable
    public final Integer component2() {
        return this.b;
    }

    @Nullable
    public final Integer component3() {
        return this.c;
    }

    @Nullable
    public final Integer component4() {
        return this.d;
    }

    @NotNull
    public final TextStyleData copy(int i, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new TextStyleData(i, num, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyleData)) {
            return false;
        }
        TextStyleData textStyleData = (TextStyleData) obj;
        return this.a == textStyleData.a && Intrinsics.areEqual(this.b, textStyleData.b) && Intrinsics.areEqual(this.c, textStyleData.c) && Intrinsics.areEqual(this.d, textStyleData.d);
    }

    @Nullable
    public final Integer getLineHeight() {
        return this.b;
    }

    public final int getLinkStyle() {
        return this.a;
    }

    @Nullable
    public final Integer getParagraphSpacing() {
        return this.c;
    }

    @Nullable
    public final Integer getTextColorLink() {
        return this.d;
    }

    public int hashCode() {
        int i = this.a * 31;
        Integer num = this.b;
        int i2 = 0;
        int hashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.c;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.d;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final void setTextColorLink(@Nullable Integer num) {
        this.d = num;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextStyleData(linkStyle=");
        L.append(this.a);
        L.append(", lineHeight=");
        L.append(this.b);
        L.append(", paragraphSpacing=");
        L.append(this.c);
        L.append(", textColorLink=");
        return a.p(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextStyleData(int i, Integer num, Integer num2, Integer num3, int i2, j jVar) {
        this(i, num, num2, (i2 & 8) != 0 ? null : num3);
    }
}
