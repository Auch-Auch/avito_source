package l6.b.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import l6.b.b.a.a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@SuppressLint({"RestrictedAPI"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class b extends a {
    public a n;
    public boolean o;

    public static class a extends a.c {
        public int[][] J;

        public a(a aVar, b bVar, Resources resources) {
            super(aVar, bVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[this.g.length][];
            }
        }

        @Override // l6.b.b.a.a.c
        public void e() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public int g(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.J[a] = iArr;
            return a;
        }

        public int h(int[] iArr) {
            int[][] iArr2 = this.J;
            int i = this.h;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new b(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new b(this, resources);
        }
    }

    public b(a aVar, Resources resources) {
        e(new a(aVar, this, resources));
        onStateChange(getState());
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            a aVar = this.n;
            aVar.J[aVar.a(drawable)] = iArr;
            onStateChange(getState());
        }
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // l6.b.b.a.a
    public void e(@NonNull a.c cVar) {
        this.a = cVar;
        int i = this.g;
        if (i >= 0) {
            Drawable d = cVar.d(i);
            this.c = d;
            if (d != null) {
                c(d);
            }
        }
        this.d = null;
        if (cVar instanceof a) {
            this.n = (a) cVar;
        }
    }

    /* renamed from: f */
    public a b() {
        return new a(this.n, this, null);
    }

    public int[] g(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        a aVar = this.n;
        aVar.d |= obtainAttributes.getChangingConfigurations();
        aVar.i = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_variablePadding, aVar.i);
        aVar.l = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_constantSize, aVar.l);
        aVar.A = obtainAttributes.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, aVar.A);
        aVar.B = obtainAttributes.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, aVar.B);
        aVar.x = obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_dither, aVar.x);
        this.a.f(resources);
        obtainAttributes.recycle();
        a aVar2 = this.n;
        int depth2 = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next2 == 3)) {
                break;
            } else if (next2 == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                Drawable drawable = null;
                int resourceId = obtainAttributes2.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                if (resourceId > 0) {
                    drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                }
                obtainAttributes2.recycle();
                int[] g = g(attributeSet);
                if (drawable == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next == 2) {
                        drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                }
                aVar2.g(g, drawable);
            }
        }
        onStateChange(getState());
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.o && super.mutate() == this) {
            this.n.e();
            this.o = true;
        }
        return this;
    }

    @Override // l6.b.b.a.a, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int h = this.n.h(iArr);
        if (h < 0) {
            h = this.n.h(StateSet.WILD_CARD);
        }
        return d(h) || onStateChange;
    }

    public b(@Nullable a aVar) {
    }
}
