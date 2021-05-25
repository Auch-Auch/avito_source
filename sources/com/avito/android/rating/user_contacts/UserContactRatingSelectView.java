package com.avito.android.rating.user_contacts;

import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0005¢\u0006\u0004\bA\u0010BJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ7\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u0004\u001a\u0004\b'\u0010(R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010&R\u0016\u00102\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010-R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010&R\u001c\u00109\u001a\b\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002XD¢\u0006\u0006\n\u0004\b:\u0010&¨\u0006D"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView;", "Landroid/view/View;", "", "resetSelectedRating", "()V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "calculateStarSpace", "(I)I", "Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView$OnRatingSelectListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView$OnRatingSelectListener;", "getOnRatingSelectListener", "()Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView$OnRatingSelectListener;", "setOnRatingSelectListener", "(Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView$OnRatingSelectListener;)V", "onRatingSelectListener", AuthSource.BOOKING_ORDER, "I", "getStarSize", "()I", "getStarSize$annotations", "starSize", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "selectedDrawable", "h", "ratingValue", "f", "unselectedDrawable", "d", "defaultStarSpace", "", "Landroid/graphics/Rect;", g.a, "[Landroid/graphics/Rect;", "starAreas", "c", "starCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnRatingSelectListener", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactRatingSelectView extends View {
    @Nullable
    public OnRatingSelectListener a;
    public final int b;
    public final int c;
    public final int d;
    public final Drawable e;
    public final Drawable f;
    public final Rect[] g;
    public int h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactRatingSelectView$OnRatingSelectListener;", "", "", "rating", "", "onRatingSelect", "(I)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public interface OnRatingSelectListener {
        void onRatingSelect(int i);
    }

    @JvmOverloads
    public UserContactRatingSelectView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public UserContactRatingSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserContactRatingSelectView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @VisibleForTesting
    public static /* synthetic */ void getStarSize$annotations() {
    }

    @VisibleForTesting
    public final int calculateStarSpace(int i) {
        if (i < Views.dpToPx(this, 300)) {
            return Views.dpToPx(this, 4);
        }
        if (i < Views.dpToPx(this, 350)) {
            return Views.dpToPx(this, 10);
        }
        return Views.dpToPx(this, 16);
    }

    @Nullable
    public final OnRatingSelectListener getOnRatingSelectListener() {
        return this.a;
    }

    public final int getStarSize() {
        return this.b;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i = this.c;
        int i2 = 0;
        while (i2 < i) {
            Drawable drawable = i2 <= this.h + -1 ? this.e : this.f;
            drawable.setBounds(this.g[i2]);
            drawable.draw(canvas);
            i2++;
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int calculateStarSpace = calculateStarSpace(i5);
        int i7 = this.c;
        int i8 = this.b;
        int i9 = ((i5 - (i7 * i8)) - ((i7 - 1) * calculateStarSpace)) / 2;
        int i10 = (i6 - i8) / 2;
        for (int i11 = 0; i11 < i7; i11++) {
            Rect rect = this.g[i11];
            int i12 = this.b;
            rect.set(i9, i10, i9 + i12, i12 + i10);
            i9 += this.b + calculateStarSpace;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.getSize(i);
        } else if (mode != 1073741824) {
            int i5 = this.c;
            i3 = ((i5 - 1) * this.d) + (this.b * i5);
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE) {
            i4 = this.b;
        } else if (mode2 != 1073741824) {
            i4 = this.b;
        } else {
            i4 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        OnRatingSelectListener onRatingSelectListener;
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        int i = 0;
        if (action == 0) {
            return true;
        }
        if (action != 1) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect[] rectArr = this.g;
        int length = rectArr.length;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (rectArr[i].contains(x, y)) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        if (i2 == this.h) {
            return true;
        }
        this.h = i2;
        if (i2 > 0 && (onRatingSelectListener = this.a) != null) {
            onRatingSelectListener.onRatingSelect(i2);
        }
        invalidate();
        return true;
    }

    public final void resetSelectedRating() {
        if (this.h != 0) {
            this.h = 0;
            invalidate();
        }
    }

    public final void setOnRatingSelectListener(@Nullable OnRatingSelectListener onRatingSelectListener) {
        this.a = onRatingSelectListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UserContactRatingSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = Views.dpToPx(this, 48);
        this.c = 5;
        this.d = Views.dpToPx(this, 4);
        int i2 = R.drawable.design_rating_star_large;
        Drawable drawable = context.getDrawable(i2);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "context.getDrawable(desi…ng_star_large)!!.mutate()");
        this.e = mutate;
        Drawable drawable2 = context.getDrawable(i2);
        Intrinsics.checkNotNull(drawable2);
        Drawable mutate2 = drawable2.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "context.getDrawable(desi…ng_star_large)!!.mutate()");
        this.f = mutate2;
        Rect[] rectArr = new Rect[5];
        for (int i3 = 0; i3 < 5; i3++) {
            rectArr[i3] = new Rect();
        }
        this.g = rectArr;
        this.e.setColorFilter(new PorterDuffColorFilter(Contexts.getColorByAttr(context, R.attr.orange), PorterDuff.Mode.SRC_ATOP));
        this.f.setColorFilter(new PorterDuffColorFilter(Contexts.getColorByAttr(context, R.attr.gray12), PorterDuff.Mode.SRC_ATOP));
    }
}
