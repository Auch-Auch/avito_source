package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import com.yandex.metrica.impl.ob.aam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
public class zx {
    @NonNull
    private static final List<Class> a;
    @NonNull
    private static final List<Class> b;
    @NonNull
    private final TreeSet<Float> c;
    @NonNull
    private final List<aad> d;
    @NonNull
    private final List<aae> e;
    @NonNull
    private final List<zq> f;
    @NonNull
    private final aas g;
    @NonNull
    private final zs h;
    @NonNull
    private final aap i;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        b = arrayList2;
        arrayList.add(ListView.class);
        arrayList.add(GridView.class);
        a(arrayList, "android.support.v7.widget.RecyclerView");
        a(arrayList, "android.support.v4.view.ViewPager");
        a(arrayList, "androidx.viewpager2.widget.ViewPager2");
        a(arrayList2, "android.support.design.widget.CoordinatorLayout");
        a(arrayList2, "android.support.v4.widget.DrawerLayout");
        a(arrayList2, "android.support.v4.widget.SlidingPaneLayout");
        a(arrayList2, "android.support.v4.widget.SwipeRefreshLayout");
        a(arrayList2, "android.support.v4.widget.NestedScrollView");
        a(arrayList2, "android.support.constraint.ConstraintLayout");
        a(arrayList2, "android.support.v7.widget.ContentFrameLayout");
        arrayList2.add(AbsoluteLayout.class);
        arrayList2.add(FrameLayout.class);
        arrayList2.add(LinearLayout.class);
        arrayList2.add(RelativeLayout.class);
        arrayList2.add(TableLayout.class);
        arrayList2.add(ScrollView.class);
        if (dl.a(14)) {
            arrayList2.add(GridLayout.class);
        }
    }

    public zx(@NonNull aap aap) {
        this(aap, new aas(), new zs(aap.c), Arrays.asList(new zu(), new aab(aap.a), new zy(Collections.emptyList())), Arrays.asList(new aac(aap.b)));
    }

    private boolean c(@NonNull View view) {
        if (dl.a(21)) {
            return view instanceof Toolbar;
        }
        return false;
    }

    private boolean d(@NonNull View view) {
        return (view instanceof TextView) && ((TextView) view).getInputType() != 0;
    }

    private boolean e(@NonNull View view) {
        return a(b, view);
    }

    @NonNull
    public zv a(@Nullable aam aam, @NonNull View view, int i2) {
        aam.d dVar;
        aam.c cVar;
        aam.c cVar2;
        String name = view.getClass().getName();
        String hexString = Integer.toHexString(view.getId());
        boolean z = aam != null && (aam.q || aam.s == aam.a.LIST);
        if (view instanceof ViewGroup) {
            dVar = aam.d.VIEW_CONTAINER;
        } else {
            dVar = aam.d.VIEW;
        }
        aam.a b2 = b(view);
        aam aam2 = null;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            Iterator<aae> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar2 = null;
                    break;
                }
                aae next = it.next();
                if (next.a(textView)) {
                    cVar2 = next.a();
                    break;
                }
            }
            if (cVar2 == null) {
                aam2 = a(textView, name, hexString, i2, z, b2);
            }
            cVar = cVar2;
        } else {
            boolean z2 = view instanceof WebView;
            cVar = null;
        }
        if (aam2 == null) {
            aam2 = new aam(name, hexString, cVar, i2, z, dVar, b2);
        }
        this.h.a(aam2);
        return new zv(aam2);
    }

    @NonNull
    public final List<aad> b() {
        return this.d;
    }

    @NonNull
    private aam.a b(@NonNull View view) {
        if (a(view)) {
            return aam.a.LIST;
        }
        if (view instanceof ImageView) {
            return aam.a.IMAGE;
        }
        if (view instanceof WebView) {
            return aam.a.WEBVIEW;
        }
        if (e(view)) {
            return aam.a.CONTAINER;
        }
        if (view instanceof Button) {
            return aam.a.BUTTON;
        }
        if (d(view)) {
            return aam.a.INPUT;
        }
        if (c(view)) {
            return aam.a.TOOLBAR;
        }
        if (!(view instanceof TextView) || ((TextView) view).getInputType() != 0) {
            return aam.a.OTHER;
        }
        return aam.a.LABEL;
    }

    @VisibleForTesting
    public zx(@NonNull aap aap, @NonNull aas aas, @NonNull zs zsVar, @NonNull List<aae> list, @NonNull List<zq> list2) {
        this.c = new TreeSet<>();
        this.d = new ArrayList();
        this.i = aap;
        this.g = aas;
        this.h = zsVar;
        this.e = list;
        this.f = list2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be A[LOOP:0: B:36:0x00b8->B:38:0x00be, LOOP_END] */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.yandex.metrica.impl.ob.aam a(@android.support.annotation.NonNull android.widget.TextView r20, @android.support.annotation.NonNull java.lang.String r21, @android.support.annotation.NonNull java.lang.String r22, int r23, boolean r24, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.aam.a r25) {
        /*
            r19 = this;
            r0 = r19
            java.lang.CharSequence r1 = r20.getText()
            if (r1 != 0) goto L_0x000b
            java.lang.String r1 = ""
            goto L_0x000f
        L_0x000b:
            java.lang.String r1 = r1.toString()
        L_0x000f:
            r9 = r1
            int r1 = r20.getVisibility()
            r2 = 0
            if (r1 != 0) goto L_0x001b
            r1 = 1
            r16 = 1
            goto L_0x001d
        L_0x001b:
            r16 = 0
        L_0x001d:
            r1 = 0
            android.content.Context r3 = r20.getContext()     // Catch:{ all -> 0x004c }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ all -> 0x004c }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ all -> 0x004c }
            float r4 = r20.getTextSize()     // Catch:{ all -> 0x004c }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ all -> 0x004c }
            float r5 = r4.floatValue()     // Catch:{ all -> 0x004a }
            float r6 = r3.density     // Catch:{ all -> 0x004a }
            float r5 = r5 / r6
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ all -> 0x004a }
            float r6 = r4.floatValue()     // Catch:{ all -> 0x004e }
            float r3 = r3.scaledDensity     // Catch:{ all -> 0x004e }
            float r6 = r6 / r3
            java.lang.Float r3 = java.lang.Float.valueOf(r6)     // Catch:{ all -> 0x004e }
            r12 = r3
            goto L_0x004f
        L_0x004a:
            r5 = r1
            goto L_0x004e
        L_0x004c:
            r4 = r1
            r5 = r4
        L_0x004e:
            r12 = r1
        L_0x004f:
            r10 = r4
            r11 = r5
            if (r10 == 0) goto L_0x005e
            com.yandex.metrica.impl.ob.aap r3 = r0.i
            boolean r3 = r3.e
            if (r3 == 0) goto L_0x005e
            java.util.TreeSet<java.lang.Float> r3 = r0.c
            r3.add(r10)
        L_0x005e:
            com.yandex.metrica.impl.ob.aas r3 = r0.g
            r4 = r20
            int r17 = r3.a(r4)
            android.text.TextUtils$TruncateAt r3 = r20.getEllipsize()
            com.yandex.metrica.impl.ob.aad$a r18 = com.yandex.metrica.impl.ob.aad.a.a(r3)
            android.graphics.Typeface r3 = r20.getTypeface()
            if (r3 != 0) goto L_0x0082
            r5 = 20
            boolean r5 = com.yandex.metrica.impl.ob.dl.a(r5)
            if (r5 != 0) goto L_0x0082
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r2)
        L_0x0082:
            if (r3 == 0) goto L_0x0097
            boolean r1 = r3.isBold()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r2 = r3.isItalic()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r14 = r1
            r15 = r2
            goto L_0x0099
        L_0x0097:
            r14 = r1
            r15 = r14
        L_0x0099:
            int r1 = r20.getCurrentTextColor()
            java.lang.String r13 = java.lang.Integer.toHexString(r1)
            com.yandex.metrica.impl.ob.aad r1 = new com.yandex.metrica.impl.ob.aad
            r2 = r1
            r5 = 0
            r3 = r21
            r4 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.util.List<com.yandex.metrica.impl.ob.zq> r2 = r0.f
            java.util.Iterator r2 = r2.iterator()
        L_0x00b8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00c8
            java.lang.Object r3 = r2.next()
            com.yandex.metrica.impl.ob.zq r3 = (com.yandex.metrica.impl.ob.zq) r3
            r3.a(r1)
            goto L_0x00b8
        L_0x00c8:
            java.util.List<com.yandex.metrica.impl.ob.aad> r2 = r0.d
            r2.add(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.zx.a(android.widget.TextView, java.lang.String, java.lang.String, int, boolean, com.yandex.metrica.impl.ob.aam$a):com.yandex.metrica.impl.ob.aam");
    }

    @NonNull
    public TreeSet<Float> a() {
        return this.c;
    }

    private boolean a(@NonNull View view) {
        return a(a, view);
    }

    @NonNull
    public List<View> a(@NonNull View view, int i2) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int min = Math.min(this.h.a(i2), viewGroup.getChildCount());
            for (int i3 = 0; i3 < min; i3++) {
                arrayList.add(viewGroup.getChildAt(i3));
            }
        }
        return arrayList;
    }

    @Nullable
    private static Class a(@NonNull String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean a(@NonNull List<Class> list, @NonNull View view) {
        for (Class cls : list) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    private static void a(@NonNull List<Class> list, @NonNull String str) {
        Class a3 = a(str);
        if (a3 != null) {
            list.add(a3);
        }
    }
}
