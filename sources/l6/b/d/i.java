package l6.b.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;
import java.util.Arrays;
public class i {
    @NonNull
    public final TextView a;
    public TintInfo b;
    public TintInfo c;
    public TintInfo d;
    public TintInfo e;
    public TintInfo f;
    public TintInfo g;
    public TintInfo h;
    @NonNull
    public final j i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public class a extends ResourcesCompat.FontCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(@NonNull Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.b & 2) != 0);
            }
            i iVar = i.this;
            WeakReference weakReference = this.c;
            if (iVar.m) {
                iVar.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    textView.setTypeface(typeface, iVar.j);
                }
            }
        }
    }

    public i(@NonNull TextView textView) {
        this.a = textView;
        this.i = new j(textView);
    }

    public static TintInfo c(Context context, AppCompatDrawableManager appCompatDrawableManager, int i2) {
        ColorStateList a3 = appCompatDrawableManager.a(context, i2);
        if (a3 == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = a3;
        return tintInfo;
    }

    public final void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.b(drawable, tintInfo, this.a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.b == null && this.c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean d() {
        j jVar = this.i;
        return jVar.i() && jVar.a != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02a8  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0380 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03e9  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x041c  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0434  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ce  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(@androidx.annotation.Nullable android.util.AttributeSet r23, int r24) {
        /*
        // Method dump skipped, instructions count: 1096
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.b.d.i.e(android.util.AttributeSet, int):void");
    }

    public void f(Context context, int i2) {
        String string;
        ColorStateList colorStateList;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i2, R.styleable.TextAppearance);
        int i3 = R.styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i3)) {
            this.a.setAllCaps(obtainStyledAttributes.getBoolean(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R.styleable.TextAppearance_android_textColor;
            if (obtainStyledAttributes.hasValue(i5) && (colorStateList = obtainStyledAttributes.getColorStateList(i5)) != null) {
                this.a.setTextColor(colorStateList);
            }
        }
        int i6 = R.styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i6) && obtainStyledAttributes.getDimensionPixelSize(i6, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        l(context, obtainStyledAttributes);
        if (i4 >= 26) {
            int i7 = R.styleable.TextAppearance_fontVariationSettings;
            if (obtainStyledAttributes.hasValue(i7) && (string = obtainStyledAttributes.getString(i7)) != null) {
                this.a.setFontVariationSettings(string);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void g(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        j jVar = this.i;
        if (jVar.i()) {
            DisplayMetrics displayMetrics = jVar.j.getResources().getDisplayMetrics();
            jVar.j(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (jVar.g()) {
                jVar.a();
            }
        }
    }

    public void h(@NonNull int[] iArr, int i2) throws IllegalArgumentException {
        j jVar = this.i;
        if (jVar.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = jVar.j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                jVar.f = jVar.b(iArr2);
                if (!jVar.h()) {
                    StringBuilder L = a2.b.a.a.a.L("None of the preset sizes is valid: ");
                    L.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(L.toString());
                }
            } else {
                jVar.g = false;
            }
            if (jVar.g()) {
                jVar.a();
            }
        }
    }

    public void i(int i2) {
        j jVar = this.i;
        if (!jVar.i()) {
            return;
        }
        if (i2 == 0) {
            jVar.a = 0;
            jVar.d = -1.0f;
            jVar.e = -1.0f;
            jVar.c = -1.0f;
            jVar.f = new int[0];
            jVar.b = false;
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = jVar.j.getResources().getDisplayMetrics();
            jVar.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (jVar.g()) {
                jVar.a();
            }
        } else {
            throw new IllegalArgumentException(a2.b.a.a.a.M2("Unknown auto-size text type: ", i2));
        }
    }

    public void j(@Nullable ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new TintInfo();
        }
        TintInfo tintInfo = this.h;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        this.b = tintInfo;
        this.c = tintInfo;
        this.d = tintInfo;
        this.e = tintInfo;
        this.f = tintInfo;
        this.g = tintInfo;
    }

    public void k(@Nullable PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new TintInfo();
        }
        TintInfo tintInfo = this.h;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        this.b = tintInfo;
        this.c = tintInfo;
        this.d = tintInfo;
        this.e = tintInfo;
        this.f = tintInfo;
        this.g = tintInfo;
    }

    public final void l(Context context, TintTypedArray tintTypedArray) {
        String string;
        this.j = tintTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, this.j);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 28) {
            int i3 = tintTypedArray.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        int i4 = R.styleable.TextAppearance_android_fontFamily;
        if (tintTypedArray.hasValue(i4) || tintTypedArray.hasValue(R.styleable.TextAppearance_fontFamily)) {
            this.l = null;
            int i5 = R.styleable.TextAppearance_fontFamily;
            if (tintTypedArray.hasValue(i5)) {
                i4 = i5;
            }
            int i6 = this.k;
            int i7 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface font = tintTypedArray.getFont(i4, this.j, new a(i6, i7, new WeakReference(this.a)));
                    if (font != null) {
                        if (i2 < 28 || this.k == -1) {
                            this.l = font;
                        } else {
                            this.l = Typeface.create(Typeface.create(font, 0), this.k, (this.j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (string = tintTypedArray.getString(i4)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    this.l = Typeface.create(string, this.j);
                    return;
                }
                Typeface create = Typeface.create(string, 0);
                int i8 = this.k;
                if ((this.j & 2) != 0) {
                    z = true;
                }
                this.l = Typeface.create(create, i8, z);
                return;
            }
            return;
        }
        int i9 = R.styleable.TextAppearance_android_typeface;
        if (tintTypedArray.hasValue(i9)) {
            this.m = false;
            int i10 = tintTypedArray.getInt(i9, 1);
            if (i10 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.l = Typeface.SERIF;
            } else if (i10 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }
}
