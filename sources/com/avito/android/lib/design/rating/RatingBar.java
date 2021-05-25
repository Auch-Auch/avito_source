package com.avito.android.lib.design.rating;

import a2.a.a.k1.a.h.a;
import a2.g.r.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.s.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001sB'\b\u0007\u0012\u0006\u0010m\u001a\u00020l\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n\u0012\b\b\u0002\u0010p\u001a\u00020\u0006¢\u0006\u0004\bq\u0010rJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00068B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R*\u00105\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010.\"\u0004\b4\u0010\"R\u0016\u00108\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R*\u0010;\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\t\u00102\u001a\u0004\b9\u0010.\"\u0004\b:\u0010\"R\"\u0010?\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010$\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\u0016\u0010A\u001a\u00020\u00068B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010.R.\u0010I\u001a\u0004\u0018\u00010B2\b\u00100\u001a\u0004\u0018\u00010B8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010M\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bJ\u00102\u001a\u0004\bK\u0010.\"\u0004\bL\u0010\"R*\u0010P\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\f\u00102\u001a\u0004\bN\u0010.\"\u0004\bO\u0010\"R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR*\u0010[\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\bX\u0010R\u001a\u0004\bY\u0010T\"\u0004\bZ\u0010VR\u0016\u0010]\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010$R\u0016\u0010_\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u00107R*\u0010b\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0004\u00102\u001a\u0004\b`\u0010.\"\u0004\ba\u0010\"R\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020h0g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006t"}, d2 = {"Lcom/avito/android/lib/design/rating/RatingBar;", "Landroid/view/View;", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, AuthSource.BOOKING_ORDER, "(F)F", "", "desiredSize", "measureSpec", "c", "(II)I", "", AuthSource.SEND_ABUSE, "()V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/graphics/drawable/Drawable;", "drawable", "setSelectedDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setUnselectedDrawable", "color", "setBackgroundColor", "(I)V", "e", "Z", "isIndicator", "()Z", "setIndicator", "(Z)V", "Landroid/view/GestureDetector;", "p", "Landroid/view/GestureDetector;", "singleTapDetector", "getDesiredWidth", "()I", "desiredWidth", "value", g.a, "I", "getNumStars", "setNumStars", "numStars", "n", "Landroid/graphics/drawable/Drawable;", "unselectedDrawable", "getUnselectedColor", "setUnselectedColor", "unselectedColor", "h", "getFloatingRatingIsEnabled", "setFloatingRatingIsEnabled", "floatingRatingIsEnabled", "getDesiredHeight", "desiredHeight", "Lcom/avito/android/lib/design/rating/RatingBar$OnRatingBarChangeListener;", "d", "Lcom/avito/android/lib/design/rating/RatingBar$OnRatingBarChangeListener;", "getListener", "()Lcom/avito/android/lib/design/rating/RatingBar$OnRatingBarChangeListener;", "setListener", "(Lcom/avito/android/lib/design/rating/RatingBar$OnRatingBarChangeListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "f", "getDividerWidthPx", "setDividerWidthPx", "dividerWidthPx", "getRatingBackgroundColor", "setRatingBackgroundColor", "ratingBackgroundColor", "i", "F", "getDefaultRating", "()F", "setDefaultRating", "(F)V", "defaultRating", "j", "getRating", "setRating", "rating", "l", "isCancelable", AuthSource.OPEN_CHANNEL_LIST, "selectedDrawable", "getSelectedColor", "setSelectedColor", "selectedColor", "La2/a/a/k1/a/h/a;", "k", "La2/a/a/k1/a/h/a;", "halfRating", "", "Landroid/graphics/Rect;", "o", "[Landroid/graphics/Rect;", "locations", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnRatingBarChangeListener", "components_release"}, k = 1, mv = {1, 4, 2})
public final class RatingBar extends View {
    public int a;
    public int b;
    public int c;
    @Nullable
    public OnRatingBarChangeListener d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public float i;
    public float j;
    public a k;
    public boolean l;
    public Drawable m;
    public Drawable n;
    public Rect[] o;
    public final GestureDetector p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/rating/RatingBar$OnRatingBarChangeListener;", "", "", "rating", "", "fromUser", "", "onRatingChanged", "(IZ)V", "components_release"}, k = 1, mv = {1, 4, 2})
    public interface OnRatingBarChangeListener {
        void onRatingChanged(int i, boolean z);
    }

    @JvmOverloads
    public RatingBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public RatingBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RatingBar(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight();
    }

    private final int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getSuggestedMinimumWidth();
    }

    public final void a() {
        Rect rect;
        this.k = null;
        float f2 = (float) 2;
        int roundToInt = c.roundToInt(this.j * f2);
        int i2 = roundToInt / 2;
        if (this.h && roundToInt % 2 != 0 && (rect = (Rect) ArraysKt___ArraysKt.getOrNull(this.o, i2)) != null) {
            float f3 = (float) (rect.right - rect.left);
            Path path = new Path();
            int i3 = rect.left;
            float f4 = f3 / f2;
            path.addRect((float) i3, (float) rect.top, ((float) i3) + f4, (float) rect.bottom, Path.Direction.CW);
            Path path2 = new Path();
            int i4 = rect.left;
            path2.addRect(((float) i4) + f4, (float) rect.top, ((float) i4) + f3, (float) rect.bottom, Path.Direction.CW);
            this.k = new a(i2, path, path2);
        }
    }

    public final float b(float f2) {
        int i2 = this.g;
        return (f2 * ((float) i2)) + ((float) ((i2 - 1) * this.f));
    }

    public final int c(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            return size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    public final float getDefaultRating() {
        return this.i;
    }

    public final int getDividerWidthPx() {
        return this.f;
    }

    public final boolean getFloatingRatingIsEnabled() {
        return this.h;
    }

    @Nullable
    public final OnRatingBarChangeListener getListener() {
        return this.d;
    }

    public final int getNumStars() {
        return this.g;
    }

    public final float getRating() {
        return this.j;
    }

    public final int getRatingBackgroundColor() {
        return this.a;
    }

    public final int getSelectedColor() {
        return this.b;
    }

    public final int getUnselectedColor() {
        return this.c;
    }

    public final boolean isIndicator() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds(0, 0, getWidth(), getHeight());
            background.draw(canvas);
        }
        a aVar = this.k;
        int roundToInt = c.roundToInt(this.j * ((float) 2)) / 2;
        int i2 = this.g;
        for (int i3 = 0; i3 < i2; i3++) {
            Rect rect = this.o[i3];
            int min = Math.min(rect.width(), rect.height());
            int width = (rect.width() - min) / 2;
            int height = (rect.height() - min) / 2;
            int i4 = rect.left + width;
            int i5 = rect.top + height;
            int i6 = rect.right - width;
            int i7 = rect.bottom - height;
            if ((i3 == 0 && this.j > 0.0f && roundToInt <= 1) || i3 < roundToInt) {
                Drawable drawable = this.m;
                drawable.setBounds(i4, i5, i6, i7);
                drawable.draw(canvas);
            } else if (aVar == null || aVar.a != i3) {
                Drawable drawable2 = this.n;
                drawable2.setBounds(i4, i5, i6, i7);
                drawable2.draw(canvas);
            } else {
                Drawable drawable3 = this.m;
                Path path = aVar.b;
                canvas.save();
                canvas.clipPath(path);
                drawable3.setBounds(i4, i5, i6, i7);
                drawable3.draw(canvas);
                canvas.restore();
                Drawable drawable4 = this.n;
                Path path2 = aVar.c;
                canvas.save();
                canvas.clipPath(path2);
                drawable4.setBounds(i4, i5, i6, i7);
                drawable4.draw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int c2 = c(getDesiredWidth(), i2);
        int c3 = c(getDesiredHeight(), i3);
        if (c2 == 0 && c3 == 0) {
            setMinimumHeight(this.n.getMinimumHeight());
            setMinimumWidth((int) b((float) getMinimumHeight()));
        } else if (c2 > 0 && c3 == 0) {
            int i4 = this.f;
            int i5 = this.g;
            setMinimumHeight((int) ((((float) c2) - ((float) ((i5 - 1) * i4))) / ((float) i5)));
        } else if (c2 == 0 && c3 > 0) {
            setMinimumWidth((int) b((float) c3));
        }
        int c4 = c(getDesiredWidth(), i2);
        int c5 = c(getDesiredHeight(), i3);
        setMeasuredDimension(c4, c5);
        float f2 = (float) c4;
        float f3 = (float) c5;
        Float valueOf = Float.valueOf(b(f3));
        if (!(valueOf.floatValue() <= f2)) {
            valueOf = null;
        }
        float floatValue = valueOf != null ? valueOf.floatValue() : f2;
        RectF rectF = new RectF(0.0f, 0.0f, floatValue / ((float) this.g), f3);
        float f4 = (float) 2;
        float f5 = (f2 / f4) - (floatValue / f4);
        float height = (f3 / f4) - (rectF.height() / f4);
        int i6 = this.g;
        for (int i7 = 0; i7 < i6; i7++) {
            this.o[i7].set((int) f5, (int) height, (int) (rectF.width() + f5), (int) (rectF.height() + height));
            f5 += rectF.width();
        }
        a();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        boolean z;
        OnRatingBarChangeListener onRatingBarChangeListener;
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        boolean z2 = false;
        if (this.e) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect[] rectArr = this.o;
        int length = rectArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (rectArr[i2].contains(x, y)) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        boolean z3 = !z;
        if (!this.l || !z3) {
            int x2 = (int) motionEvent.getX();
            motionEvent.getY();
            Rect[] rectArr2 = this.o;
            int length2 = rectArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    i3 = -1;
                    break;
                }
                Rect rect = rectArr2[i3];
                if (rect.contains(x2, rect.centerY())) {
                    break;
                }
                i3++;
            }
            Float valueOf = Float.valueOf((float) (i3 + 1));
            float floatValue = valueOf.floatValue();
            if (floatValue > 0.0f && floatValue != this.j) {
                z2 = true;
            }
            if (!z2) {
                valueOf = null;
            }
            if (valueOf != null) {
                setRating(valueOf.floatValue());
            }
        } else {
            float f2 = this.j;
            float f3 = this.i;
            if (f2 != f3) {
                setRating(f3);
            }
        }
        if (this.p.onTouchEvent(motionEvent)) {
            return true;
        }
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && ((!this.l || !z3) && (onRatingBarChangeListener = this.d) != null)) {
            onRatingBarChangeListener.onRatingChanged((int) this.j, true);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        setRatingBackgroundColor(i2);
    }

    public final void setDefaultRating(float f2) {
        this.i = f2;
    }

    public final void setDividerWidthPx(int i2) {
        this.f = i2;
    }

    public final void setFloatingRatingIsEnabled(boolean z) {
        this.h = z;
    }

    public final void setIndicator(boolean z) {
        this.e = z;
    }

    public final void setListener(@Nullable OnRatingBarChangeListener onRatingBarChangeListener) {
        this.d = onRatingBarChangeListener;
        if (onRatingBarChangeListener != null) {
            this.e = false;
        }
    }

    public final void setNumStars(int i2) {
        this.g = i2;
        Rect[] rectArr = new Rect[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            rectArr[i3] = new Rect();
        }
        this.o = rectArr;
        invalidate();
    }

    public final void setRating(float f2) {
        if (!this.h) {
            f2 = (float) c.roundToInt(f2);
        }
        boolean z = this.j != f2;
        this.j = f2;
        if (z) {
            a();
            invalidate();
        }
        OnRatingBarChangeListener onRatingBarChangeListener = this.d;
        if (onRatingBarChangeListener != null) {
            onRatingBarChangeListener.onRatingChanged((int) this.j, false);
        }
    }

    public final void setRatingBackgroundColor(int i2) {
        this.n.setColorFilter(RatingBarKt.access$multiplyColorFilter(this.c, i2));
        this.a = i2;
    }

    public final void setSelectedColor(int i2) {
        this.m.setColorFilter(RatingBarKt.access$colorFilter(i2));
        this.b = i2;
    }

    public final void setSelectedDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "drawable.mutate()");
        this.m = mutate;
        setSelectedColor(this.b);
    }

    public final void setUnselectedColor(int i2) {
        this.n.setColorFilter(RatingBarKt.access$multiplyColorFilter(i2, this.a));
        this.c = i2;
    }

    public final void setUnselectedDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "drawable.mutate()");
        this.n = mutate;
        setUnselectedColor(this.c);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RatingBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = Contexts.getColorByAttr(context, R.attr.orange);
        this.c = Contexts.getColorByAttr(context, R.attr.gray12);
        this.e = true;
        this.g = 5;
        int i3 = R.drawable.design_rating_star_large;
        Drawable drawable = context.getDrawable(i3);
        Intrinsics.checkNotNull(drawable);
        Drawable mutate = drawable.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "context.getDrawable(R.dr…ng_star_large)!!.mutate()");
        this.m = mutate;
        Drawable drawable2 = context.getDrawable(i3);
        Intrinsics.checkNotNull(drawable2);
        Drawable mutate2 = drawable2.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "context.getDrawable(R.dr…ng_star_large)!!.mutate()");
        this.n = mutate2;
        int i4 = this.g;
        Rect[] rectArr = new Rect[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            rectArr[i5] = new Rect();
        }
        this.o = rectArr;
        this.p = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(this) { // from class: com.avito.android.lib.design.rating.RatingBar$singleTapDetector$1
            public final /* synthetic */ RatingBar a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(@NotNull MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "event");
                RatingBar ratingBar = this.a;
                RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = ratingBar.d;
                if (onRatingBarChangeListener != null) {
                    onRatingBarChangeListener.onRatingChanged((int) ratingBar.j, true);
                }
                return true;
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatingBar);
        int i6 = R.styleable.RatingBar_ratingDrawable;
        Drawable drawable3 = obtainStyledAttributes.getDrawable(i6);
        if (drawable3 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable3, "it");
            setSelectedDrawable(drawable3);
        }
        Drawable drawable4 = obtainStyledAttributes.getDrawable(i6);
        if (drawable4 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable4, "it");
            setUnselectedDrawable(drawable4);
        }
        setRatingBackgroundColor(obtainStyledAttributes.getColor(R.styleable.RatingBar_android_background, this.a));
        setSelectedColor(obtainStyledAttributes.getColor(R.styleable.RatingBar_selectedColor, this.b));
        setUnselectedColor(obtainStyledAttributes.getColor(R.styleable.RatingBar_unselectedColor, this.c));
        this.e = obtainStyledAttributes.getBoolean(R.styleable.RatingBar_isIndicator, this.e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RatingBar_dividerWidth, this.f);
        setNumStars(obtainStyledAttributes.getInteger(R.styleable.RatingBar_numStars, this.g));
        this.l = obtainStyledAttributes.getBoolean(R.styleable.RatingBar_isCancelable, this.l);
        float f2 = obtainStyledAttributes.getFloat(R.styleable.RatingBar_rating, this.j);
        this.i = f2;
        setRating(f2);
        obtainStyledAttributes.recycle();
    }
}
