package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.io.IOException;
import l6.b.b.a.a;
import l6.b.b.a.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@SuppressLint({"RestrictedAPI"})
public class AnimatedStateListDrawableCompat extends l6.b.b.a.b implements TintAwareDrawable {
    public static final String u = AnimatedStateListDrawableCompat.class.getSimpleName();
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    public static class b extends g {
        public final Animatable a;

        public b(Animatable animatable) {
            super(null);
            this.a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void c() {
            this.a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void d() {
            this.a.stop();
        }
    }

    public static class c extends b.a {
        public LongSparseArray<Long> K;
        public SparseArrayCompat<Integer> L;

        public c(@Nullable c cVar, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(cVar, animatedStateListDrawableCompat, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new LongSparseArray<>();
            this.L = new SparseArrayCompat<>();
        }

        public static long j(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        @Override // l6.b.b.a.b.a, l6.b.b.a.a.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int i(int i, int i2, @NonNull Drawable drawable, boolean z) {
            int a = a(drawable);
            long j = j(i, i2);
            long j2 = z ? 8589934592L : 0;
            long j3 = (long) a;
            this.K.append(j, Long.valueOf(j3 | j2));
            if (z) {
                this.K.append(j(i2, i), Long.valueOf(4294967296L | j3 | j2));
            }
            return a;
        }

        public int k(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.get(i, 0).intValue();
        }

        @Override // l6.b.b.a.b.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // l6.b.b.a.b.a, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class d extends g {
        public final AnimatedVectorDrawableCompat a;

        public d(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super(null);
            this.a = animatedVectorDrawableCompat;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void c() {
            this.a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void d() {
            this.a.stop();
        }
    }

    public static class e extends g {
        public final ObjectAnimator a;
        public final boolean b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            ofInt.setAutoCancel(true);
            ofInt.setDuration((long) fVar.c);
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.a = ofInt;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public boolean a() {
            return this.b;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void b() {
            this.a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void c() {
            this.a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.g
        public void d() {
            this.a.cancel();
        }
    }

    public static class f implements TimeInterpolator {
        public int[] a;
        public int b;
        public int c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.c)) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.c) : 0.0f);
        }
    }

    public static abstract class g {
        public g(a aVar) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Nullable
    public static AnimatedStateListDrawableCompat create(@NonNull Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        XmlResourceParser xml;
        int next;
        try {
            Resources resources = context.getResources();
            xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            if (next == 2) {
                return createFromXmlInner(context, resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
        while (true) {
            next = xml.next();
            if (next == 2 || next == 1) {
                break;
            }
        }
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // l6.b.b.a.b
    public /* bridge */ /* synthetic */ void addState(int[] iArr, Drawable drawable) {
        super.addState(iArr, drawable);
    }

    public <T extends Drawable & Animatable> void addTransition(int i, int i2, @NonNull T t2, boolean z) {
        if (t2 != null) {
            this.p.i(i, i2, t2, z);
            return;
        }
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a
    public a.c b() {
        return new c(this.p, this, null);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a
    public void e(@NonNull a.c cVar) {
        super.e(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }

    @Override // l6.b.b.a.b
    public b.a f() {
        return new c(this.p, this, null);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@NonNull Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public /* bridge */ /* synthetic */ void getOutline(@NonNull Outline outline) {
        super.getOutline(outline);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@NonNull Rect rect) {
        return super.getPadding(rect);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01b6, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r19.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
     */
    @Override // l6.b.b.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.NonNull android.content.res.Resources r18, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r19, @androidx.annotation.NonNull android.util.AttributeSet r20, @androidx.annotation.Nullable android.content.res.Resources.Theme r21) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 472
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.inflate(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            d(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t && super.mutate() == this) {
            this.p.e();
            this.t = true;
        }
        return this;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // l6.b.b.a.b, l6.b.b.a.a, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        g gVar;
        c cVar = this.p;
        int h = cVar.h(iArr);
        if (h < 0) {
            h = cVar.h(StateSet.WILD_CARD);
        }
        int i = this.g;
        boolean z2 = false;
        if (h != i) {
            g gVar2 = this.q;
            if (gVar2 != null) {
                if (h != this.r) {
                    if (h != this.s || !gVar2.a()) {
                        i = this.r;
                        gVar2.d();
                    } else {
                        gVar2.b();
                        this.r = this.s;
                        this.s = h;
                    }
                }
                z = true;
                if (z || d(h)) {
                    z2 = true;
                }
            }
            this.q = null;
            this.s = -1;
            this.r = -1;
            c cVar2 = this.p;
            int k = cVar2.k(i);
            int k2 = cVar2.k(h);
            if (!(k2 == 0 || k == 0)) {
                int longValue = (int) cVar2.K.get(c.j(k, k2), -1L).longValue();
                if (longValue >= 0) {
                    boolean z3 = (cVar2.K.get(c.j(k, k2), -1L).longValue() & 8589934592L) != 0;
                    d(longValue);
                    Drawable current = getCurrent();
                    if (current instanceof AnimationDrawable) {
                        gVar = new e((AnimationDrawable) current, (cVar2.K.get(c.j(k, k2), -1L).longValue() & 4294967296L) != 0, z3);
                    } else if (current instanceof AnimatedVectorDrawableCompat) {
                        gVar = new d((AnimatedVectorDrawableCompat) current);
                    } else if (current instanceof Animatable) {
                        gVar = new b((Animatable) current);
                    }
                    gVar.c();
                    this.q = gVar;
                    this.s = i;
                    this.r = h;
                    z = true;
                    z2 = true;
                }
            }
            z = false;
            z2 = true;
        }
        Drawable current2 = getCurrent();
        return current2 != null ? z2 | current2.setState(iArr) : z2;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // l6.b.b.a.a
    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int i) {
        super.setEnterFadeDuration(i);
    }

    @Override // l6.b.b.a.a
    public /* bridge */ /* synthetic */ void setExitFadeDuration(int i) {
        super.setExitFadeDuration(i);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(@NonNull PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.q;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public AnimatedStateListDrawableCompat(@Nullable c cVar, @Nullable Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        c cVar2 = new c(cVar, this, resources);
        super.e(cVar2);
        this.p = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i) {
        if (drawable != null) {
            c cVar = this.p;
            int a3 = cVar.a(drawable);
            cVar.J[a3] = iArr;
            cVar.L.put(a3, Integer.valueOf(i));
            onStateChange(getState());
            return;
        }
        throw new IllegalArgumentException("Drawable must not be null");
    }
}
