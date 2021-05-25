package com.avito.android.brandspace.items.textmeasurement;

import a2.b.a.a.a;
import a2.g.r.g;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Size;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "", "Landroid/widget/TextView;", "textView", "", "maxTextWidth", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "createTextParams", "(Landroid/widget/TextView;I)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "", "text", "params", "Lcom/avito/android/remote/model/Size;", "measure", "(Ljava/lang/String;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;)Lcom/avito/android/remote/model/Size;", "TextParams", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface TextMeasurer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B«\u0001\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\t\u0012\u0006\u0010(\u001a\u00020\f\u0012\u0006\u0010)\u001a\u00020\f\u0012\u0006\u0010*\u001a\u00020\u0010\u0012\b\b\u0002\u0010+\u001a\u00020\u0013\u0012\b\b\u0002\u0010,\u001a\u00020\u0016\u0012\b\b\u0002\u0010-\u001a\u00020\u0010\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u00103\u001a\u00020\u0002¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004JÆ\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\f2\b\b\u0002\u0010)\u001a\u00020\f2\b\b\u0002\u0010*\u001a\u00020\u00102\b\b\u0002\u0010+\u001a\u00020\u00132\b\b\u0002\u0010,\u001a\u00020\u00162\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00103\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00107\u001a\u000206HÖ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b9\u0010\u0004J\u001a\u0010;\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b;\u0010<R\u0019\u0010)\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u000eR\u0013\u0010A\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\u0004R\u0019\u0010(\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010\u000eR\u0019\u00100\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0004R\u0019\u0010#\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010E\u001a\u0004\bH\u0010\u0004R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010\u0004R\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010E\u001a\u0004\bL\u0010\u0004R\u0013\u0010N\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\bM\u0010\u0004R\u0019\u0010,\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010\u0018R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010E\u001a\u0004\bS\u0010\u0004R\u0019\u0010*\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010\u0012R\u0019\u0010+\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010\u0015R\u0019\u00103\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010E\u001a\u0004\b[\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\\\u0010E\u001a\u0004\b]\u0010\u0004R\u0019\u0010.\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010E\u001a\u0004\b_\u0010\u0004R\u001b\u00102\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010 R\u0019\u0010-\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\bc\u0010U\u001a\u0004\b-\u0010\u0012R\u0019\u00101\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010E\u001a\u0004\be\u0010\u0004R\u0019\u0010'\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u000bR\u0019\u0010/\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010E\u001a\u0004\bj\u0010\u0004¨\u0006m"}, d2 = {"Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "", "", "component1", "()I", "component2", "component3", "component4", "component5", "Landroid/text/TextPaint;", "component6", "()Landroid/text/TextPaint;", "", "component7", "()F", "component8", "", "component9", "()Z", "Landroid/text/Layout$Alignment;", "component10", "()Landroid/text/Layout$Alignment;", "Landroid/text/TextDirectionHeuristic;", "component11", "()Landroid/text/TextDirectionHeuristic;", "component12", "component13", "component14", "component15", "component16", "Landroid/text/TextUtils$TruncateAt;", "component17", "()Landroid/text/TextUtils$TruncateAt;", "component18", "maxTextWidth", "verticalPadding", "horizontalPadding", "verticalMargin", "horizontalMargin", "textPaint", "spacingAdd", "spacingMult", "includePad", "textAlignment", "textDirection", "isFallbackLineSpacing", "breakStrategy", "hyphenationFrequency", "justificationMode", "maxLines", "ellipsis", "ellipsisWidth", "copy", "(IIIIILandroid/text/TextPaint;FFZLandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;ZIIIILandroid/text/TextUtils$TruncateAt;I)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "h", "F", "getSpacingMult", "getCombinedVerticalEdgeSpace", "combinedVerticalEdgeSpace", g.a, "getSpacingAdd", "o", "I", "getJustificationMode", AuthSource.BOOKING_ORDER, "getVerticalPadding", "c", "getHorizontalPadding", "e", "getHorizontalMargin", "getCombinedHorizontalEdgeSpace", "combinedHorizontalEdgeSpace", "k", "Landroid/text/TextDirectionHeuristic;", "getTextDirection", "d", "getVerticalMargin", "i", "Z", "getIncludePad", "j", "Landroid/text/Layout$Alignment;", "getTextAlignment", "r", "getEllipsisWidth", AuthSource.SEND_ABUSE, "getMaxTextWidth", AuthSource.OPEN_CHANNEL_LIST, "getBreakStrategy", VKApiConst.Q, "Landroid/text/TextUtils$TruncateAt;", "getEllipsis", "l", "p", "getMaxLines", "f", "Landroid/text/TextPaint;", "getTextPaint", "n", "getHyphenationFrequency", "<init>", "(IIIIILandroid/text/TextPaint;FFZLandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;ZIIIILandroid/text/TextUtils$TruncateAt;I)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextParams {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        @NotNull
        public final TextPaint f;
        public final float g;
        public final float h;
        public final boolean i;
        @NotNull
        public final Layout.Alignment j;
        @NotNull
        public final TextDirectionHeuristic k;
        public final boolean l;
        public final int m;
        public final int n;
        public final int o;
        public final int p;
        @Nullable
        public final TextUtils.TruncateAt q;
        public final int r;

        public TextParams(int i2, int i3, int i4, int i5, int i6, @NotNull TextPaint textPaint, float f2, float f3, boolean z, @NotNull Layout.Alignment alignment, @NotNull TextDirectionHeuristic textDirectionHeuristic, boolean z2, int i7, int i8, int i9, int i10, @Nullable TextUtils.TruncateAt truncateAt, int i11) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            Intrinsics.checkNotNullParameter(alignment, "textAlignment");
            Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDirection");
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = i5;
            this.e = i6;
            this.f = textPaint;
            this.g = f2;
            this.h = f3;
            this.i = z;
            this.j = alignment;
            this.k = textDirectionHeuristic;
            this.l = z2;
            this.m = i7;
            this.n = i8;
            this.o = i9;
            this.p = i10;
            this.q = truncateAt;
            this.r = i11;
        }

        public static /* synthetic */ TextParams copy$default(TextParams textParams, int i2, int i3, int i4, int i5, int i6, TextPaint textPaint, float f2, float f3, boolean z, Layout.Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, boolean z2, int i7, int i8, int i9, int i10, TextUtils.TruncateAt truncateAt, int i11, int i12, Object obj) {
            return textParams.copy((i12 & 1) != 0 ? textParams.a : i2, (i12 & 2) != 0 ? textParams.b : i3, (i12 & 4) != 0 ? textParams.c : i4, (i12 & 8) != 0 ? textParams.d : i5, (i12 & 16) != 0 ? textParams.e : i6, (i12 & 32) != 0 ? textParams.f : textPaint, (i12 & 64) != 0 ? textParams.g : f2, (i12 & 128) != 0 ? textParams.h : f3, (i12 & 256) != 0 ? textParams.i : z, (i12 & 512) != 0 ? textParams.j : alignment, (i12 & 1024) != 0 ? textParams.k : textDirectionHeuristic, (i12 & 2048) != 0 ? textParams.l : z2, (i12 & 4096) != 0 ? textParams.m : i7, (i12 & 8192) != 0 ? textParams.n : i8, (i12 & 16384) != 0 ? textParams.o : i9, (i12 & 32768) != 0 ? textParams.p : i10, (i12 & 65536) != 0 ? textParams.q : truncateAt, (i12 & 131072) != 0 ? textParams.r : i11);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final Layout.Alignment component10() {
            return this.j;
        }

        @NotNull
        public final TextDirectionHeuristic component11() {
            return this.k;
        }

        public final boolean component12() {
            return this.l;
        }

        public final int component13() {
            return this.m;
        }

        public final int component14() {
            return this.n;
        }

        public final int component15() {
            return this.o;
        }

        public final int component16() {
            return this.p;
        }

        @Nullable
        public final TextUtils.TruncateAt component17() {
            return this.q;
        }

        public final int component18() {
            return this.r;
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        public final int component4() {
            return this.d;
        }

        public final int component5() {
            return this.e;
        }

        @NotNull
        public final TextPaint component6() {
            return this.f;
        }

        public final float component7() {
            return this.g;
        }

        public final float component8() {
            return this.h;
        }

        public final boolean component9() {
            return this.i;
        }

        @NotNull
        public final TextParams copy(int i2, int i3, int i4, int i5, int i6, @NotNull TextPaint textPaint, float f2, float f3, boolean z, @NotNull Layout.Alignment alignment, @NotNull TextDirectionHeuristic textDirectionHeuristic, boolean z2, int i7, int i8, int i9, int i10, @Nullable TextUtils.TruncateAt truncateAt, int i11) {
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            Intrinsics.checkNotNullParameter(alignment, "textAlignment");
            Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDirection");
            return new TextParams(i2, i3, i4, i5, i6, textPaint, f2, f3, z, alignment, textDirectionHeuristic, z2, i7, i8, i9, i10, truncateAt, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextParams)) {
                return false;
            }
            TextParams textParams = (TextParams) obj;
            return this.a == textParams.a && this.b == textParams.b && this.c == textParams.c && this.d == textParams.d && this.e == textParams.e && Intrinsics.areEqual(this.f, textParams.f) && Float.compare(this.g, textParams.g) == 0 && Float.compare(this.h, textParams.h) == 0 && this.i == textParams.i && Intrinsics.areEqual(this.j, textParams.j) && Intrinsics.areEqual(this.k, textParams.k) && this.l == textParams.l && this.m == textParams.m && this.n == textParams.n && this.o == textParams.o && this.p == textParams.p && Intrinsics.areEqual(this.q, textParams.q) && this.r == textParams.r;
        }

        public final int getBreakStrategy() {
            return this.m;
        }

        public final int getCombinedHorizontalEdgeSpace() {
            return this.e + this.c;
        }

        public final int getCombinedVerticalEdgeSpace() {
            return this.d + this.b;
        }

        @Nullable
        public final TextUtils.TruncateAt getEllipsis() {
            return this.q;
        }

        public final int getEllipsisWidth() {
            return this.r;
        }

        public final int getHorizontalMargin() {
            return this.e;
        }

        public final int getHorizontalPadding() {
            return this.c;
        }

        public final int getHyphenationFrequency() {
            return this.n;
        }

        public final boolean getIncludePad() {
            return this.i;
        }

        public final int getJustificationMode() {
            return this.o;
        }

        public final int getMaxLines() {
            return this.p;
        }

        public final int getMaxTextWidth() {
            return this.a;
        }

        public final float getSpacingAdd() {
            return this.g;
        }

        public final float getSpacingMult() {
            return this.h;
        }

        @NotNull
        public final Layout.Alignment getTextAlignment() {
            return this.j;
        }

        @NotNull
        public final TextDirectionHeuristic getTextDirection() {
            return this.k;
        }

        @NotNull
        public final TextPaint getTextPaint() {
            return this.f;
        }

        public final int getVerticalMargin() {
            return this.d;
        }

        public final int getVerticalPadding() {
            return this.b;
        }

        public int hashCode() {
            int i2 = ((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            TextPaint textPaint = this.f;
            int i3 = 0;
            int i1 = a.i1(this.h, a.i1(this.g, (i2 + (textPaint != null ? textPaint.hashCode() : 0)) * 31, 31), 31);
            boolean z = this.i;
            int i4 = 1;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = (i1 + i5) * 31;
            Layout.Alignment alignment = this.j;
            int hashCode = (i8 + (alignment != null ? alignment.hashCode() : 0)) * 31;
            TextDirectionHeuristic textDirectionHeuristic = this.k;
            int hashCode2 = (hashCode + (textDirectionHeuristic != null ? textDirectionHeuristic.hashCode() : 0)) * 31;
            boolean z2 = this.l;
            if (!z2) {
                i4 = z2 ? 1 : 0;
            }
            int i9 = (((((((((hashCode2 + i4) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31;
            TextUtils.TruncateAt truncateAt = this.q;
            if (truncateAt != null) {
                i3 = truncateAt.hashCode();
            }
            return ((i9 + i3) * 31) + this.r;
        }

        public final boolean isFallbackLineSpacing() {
            return this.l;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("TextParams(maxTextWidth=");
            L.append(this.a);
            L.append(", verticalPadding=");
            L.append(this.b);
            L.append(", horizontalPadding=");
            L.append(this.c);
            L.append(", verticalMargin=");
            L.append(this.d);
            L.append(", horizontalMargin=");
            L.append(this.e);
            L.append(", textPaint=");
            L.append(this.f);
            L.append(", spacingAdd=");
            L.append(this.g);
            L.append(", spacingMult=");
            L.append(this.h);
            L.append(", includePad=");
            L.append(this.i);
            L.append(", textAlignment=");
            L.append(this.j);
            L.append(", textDirection=");
            L.append(this.k);
            L.append(", isFallbackLineSpacing=");
            L.append(this.l);
            L.append(", breakStrategy=");
            L.append(this.m);
            L.append(", hyphenationFrequency=");
            L.append(this.n);
            L.append(", justificationMode=");
            L.append(this.o);
            L.append(", maxLines=");
            L.append(this.p);
            L.append(", ellipsis=");
            L.append(this.q);
            L.append(", ellipsisWidth=");
            return a.j(L, this.r, ")");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TextParams(int r22, int r23, int r24, int r25, int r26, android.text.TextPaint r27, float r28, float r29, boolean r30, android.text.Layout.Alignment r31, android.text.TextDirectionHeuristic r32, boolean r33, int r34, int r35, int r36, int r37, android.text.TextUtils.TruncateAt r38, int r39, int r40, t6.r.a.j r41) {
            /*
                r21 = this;
                r0 = r40
                r1 = r0 & 512(0x200, float:7.175E-43)
                if (r1 == 0) goto L_0x000a
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
                r12 = r1
                goto L_0x000c
            L_0x000a:
                r12 = r31
            L_0x000c:
                r1 = r0 & 1024(0x400, float:1.435E-42)
                if (r1 == 0) goto L_0x0019
                android.text.TextDirectionHeuristic r1 = android.text.TextDirectionHeuristics.LTR
                java.lang.String r2 = "TextDirectionHeuristics.LTR"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                r13 = r1
                goto L_0x001b
            L_0x0019:
                r13 = r32
            L_0x001b:
                r1 = r0 & 2048(0x800, float:2.87E-42)
                r2 = 0
                if (r1 == 0) goto L_0x0022
                r14 = 0
                goto L_0x0024
            L_0x0022:
                r14 = r33
            L_0x0024:
                r1 = r0 & 4096(0x1000, float:5.74E-42)
                if (r1 == 0) goto L_0x002a
                r15 = 0
                goto L_0x002c
            L_0x002a:
                r15 = r34
            L_0x002c:
                r1 = r0 & 8192(0x2000, float:1.14794E-41)
                if (r1 == 0) goto L_0x0033
                r16 = 0
                goto L_0x0035
            L_0x0033:
                r16 = r35
            L_0x0035:
                r1 = r0 & 16384(0x4000, float:2.2959E-41)
                if (r1 == 0) goto L_0x003c
                r17 = 0
                goto L_0x003e
            L_0x003c:
                r17 = r36
            L_0x003e:
                r1 = 32768(0x8000, float:4.5918E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x004b
                r1 = 2147483647(0x7fffffff, float:NaN)
                r18 = 2147483647(0x7fffffff, float:NaN)
                goto L_0x004d
            L_0x004b:
                r18 = r37
            L_0x004d:
                r1 = 65536(0x10000, float:9.18355E-41)
                r1 = r1 & r0
                if (r1 == 0) goto L_0x0056
                r1 = 0
                r19 = r1
                goto L_0x0058
            L_0x0056:
                r19 = r38
            L_0x0058:
                r1 = 131072(0x20000, float:1.83671E-40)
                r0 = r0 & r1
                if (r0 == 0) goto L_0x0060
                r20 = 0
                goto L_0x0062
            L_0x0060:
                r20 = r39
            L_0x0062:
                r2 = r21
                r3 = r22
                r4 = r23
                r5 = r24
                r6 = r25
                r7 = r26
                r8 = r27
                r9 = r28
                r10 = r29
                r11 = r30
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.items.textmeasurement.TextMeasurer.TextParams.<init>(int, int, int, int, int, android.text.TextPaint, float, float, boolean, android.text.Layout$Alignment, android.text.TextDirectionHeuristic, boolean, int, int, int, int, android.text.TextUtils$TruncateAt, int, int, t6.r.a.j):void");
        }
    }

    @NotNull
    TextParams createTextParams(@NotNull TextView textView, int i);

    @NotNull
    Size measure(@Nullable String str, @NotNull TextParams textParams);
}
