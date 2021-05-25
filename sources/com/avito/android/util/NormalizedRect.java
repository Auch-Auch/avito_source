package com.avito.android.util;

import a2.b.a.a.a;
import android.graphics.Rect;
import androidx.annotation.FloatRange;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\u000e\u001a\u00020\b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\b\u0012\b\b\u0001\u0010\u0010\u001a\u00020\b\u0012\b\b\u0001\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\r\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\b2\b\b\u0003\u0010\u0010\u001a\u00020\b2\b\b\u0003\u0010\u0011\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\nR\u0019\u0010\u0011\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\nR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/avito/android/util/NormalizedRect;", "", "", "fullWidth", "fullHeight", "Landroid/graphics/Rect;", "toRect", "(II)Landroid/graphics/Rect;", "", "component1", "()F", "component2", "component3", "component4", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "copy", "(FFFF)Lcom/avito/android/util/NormalizedRect;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "F", "getLeft", "c", "getRight", "d", "getBottom", AuthSource.BOOKING_ORDER, "getTop", "<init>", "(FFFF)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class NormalizedRect {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public NormalizedRect(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    public static /* synthetic */ NormalizedRect copy$default(NormalizedRect normalizedRect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = normalizedRect.a;
        }
        if ((i & 2) != 0) {
            f2 = normalizedRect.b;
        }
        if ((i & 4) != 0) {
            f3 = normalizedRect.c;
        }
        if ((i & 8) != 0) {
            f4 = normalizedRect.d;
        }
        return normalizedRect.copy(f, f2, f3, f4);
    }

    public final float component1() {
        return this.a;
    }

    public final float component2() {
        return this.b;
    }

    public final float component3() {
        return this.c;
    }

    public final float component4() {
        return this.d;
    }

    @NotNull
    public final NormalizedRect copy(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return new NormalizedRect(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NormalizedRect)) {
            return false;
        }
        NormalizedRect normalizedRect = (NormalizedRect) obj;
        return Float.compare(this.a, normalizedRect.a) == 0 && Float.compare(this.b, normalizedRect.b) == 0 && Float.compare(this.c, normalizedRect.c) == 0 && Float.compare(this.d, normalizedRect.d) == 0;
    }

    public final float getBottom() {
        return this.d;
    }

    public final float getLeft() {
        return this.a;
    }

    public final float getRight() {
        return this.c;
    }

    public final float getTop() {
        return this.b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.d) + a.i1(this.c, a.i1(this.b, Float.floatToIntBits(this.a) * 31, 31), 31);
    }

    @NotNull
    public final Rect toRect(int i, int i2) {
        float f = (float) i;
        float f2 = (float) i2;
        return new Rect((int) (this.a * f), (int) (this.b * f2), (int) (this.c * f), (int) (this.d * f2));
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NormalizedRect(left=");
        L.append(this.a);
        L.append(", top=");
        L.append(this.b);
        L.append(", right=");
        L.append(this.c);
        L.append(", bottom=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
