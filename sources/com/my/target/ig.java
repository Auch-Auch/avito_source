package com.my.target;

import a2.l.a.r;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import com.my.target.nativeads.views.PromoCardRecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;
public class ig {
    @NonNull
    public final WeakReference<ViewGroup> a;
    @Nullable
    public List<WeakReference<View>> b;
    @Nullable
    public WeakReference<MediaAdView> c;
    @Nullable
    public WeakReference<IconAdView> d;
    @Nullable
    public WeakReference<fo> e;
    @Nullable
    public WeakReference<gh> f;
    @Nullable
    public WeakReference<gn> g;
    public boolean h = false;

    public ig(@NonNull ViewGroup viewGroup, @Nullable MediaAdView mediaAdView) {
        this.a = new WeakReference<>(viewGroup);
        if (mediaAdView != null) {
            this.c = new WeakReference<>(mediaAdView);
        }
        d(viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ig(@androidx.annotation.NonNull android.view.ViewGroup r5, @androidx.annotation.Nullable java.util.List<android.view.View> r6, @androidx.annotation.Nullable com.my.target.nativeads.views.MediaAdView r7, @androidx.annotation.Nullable android.view.View.OnClickListener r8) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.h = r0
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r5)
            r4.a = r1
            if (r7 == 0) goto L_0x0016
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r7)
            r4.c = r1
        L_0x0016:
            r7 = 1
            if (r6 == 0) goto L_0x004e
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x004e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.b = r1
            java.util.Iterator r6 = r6.iterator()
        L_0x002a:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x004e
            java.lang.Object r1 = r6.next()
            android.view.View r1 = (android.view.View) r1
            if (r1 != 0) goto L_0x0039
            goto L_0x002a
        L_0x0039:
            java.util.List<java.lang.ref.WeakReference<android.view.View>> r2 = r4.b
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r1)
            r2.add(r3)
            boolean r2 = r1 instanceof com.my.target.nativeads.views.MediaAdView
            if (r2 == 0) goto L_0x004a
            r4.h = r7
            goto L_0x002a
        L_0x004a:
            r1.setOnClickListener(r8)
            goto L_0x002a
        L_0x004e:
            boolean r6 = r4.e(r5)
            if (r6 == 0) goto L_0x0055
            goto L_0x00b2
        L_0x0055:
            java.util.List<java.lang.ref.WeakReference<android.view.View>> r6 = r4.b
            if (r6 != 0) goto L_0x005c
            r5.setOnClickListener(r8)
        L_0x005c:
            r6 = 0
        L_0x005d:
            int r1 = r5.getChildCount()
            if (r6 >= r1) goto L_0x0065
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            if (r1 == 0) goto L_0x00b2
            int r1 = r6 + 1
            android.view.View r6 = r5.getChildAt(r6)
            boolean r2 = r6 instanceof com.my.target.fo
            if (r2 == 0) goto L_0x007d
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r3 = r6
            com.my.target.fo r3 = (com.my.target.fo) r3
            r2.<init>(r3)
            r4.e = r2
            goto L_0x008b
        L_0x007d:
            boolean r2 = r6 instanceof com.my.target.gh
            if (r2 == 0) goto L_0x008d
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r3 = r6
            com.my.target.gh r3 = (com.my.target.gh) r3
            r2.<init>(r3)
            r4.f = r2
        L_0x008b:
            r2 = 1
            goto L_0x008e
        L_0x008d:
            r2 = 0
        L_0x008e:
            if (r2 != 0) goto L_0x00b0
            boolean r2 = r6 instanceof com.my.target.nativeads.views.IconAdView
            if (r2 == 0) goto L_0x00a0
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r3 = r6
            com.my.target.nativeads.views.IconAdView r3 = (com.my.target.nativeads.views.IconAdView) r3
            r2.<init>(r3)
            r4.d = r2
            r2 = 1
            goto L_0x00a1
        L_0x00a0:
            r2 = 0
        L_0x00a1:
            if (r2 == 0) goto L_0x00a4
            goto L_0x00b0
        L_0x00a4:
            r4.b(r6, r8)
            boolean r2 = r6 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x00b0
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r4.c(r6, r8)
        L_0x00b0:
            r6 = r1
            goto L_0x005d
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.ig.<init>(android.view.ViewGroup, java.util.List, com.my.target.nativeads.views.MediaAdView, android.view.View$OnClickListener):void");
    }

    public static ig a(@NonNull ViewGroup viewGroup, @Nullable MediaAdView mediaAdView) {
        return new ig(viewGroup, mediaAdView);
    }

    public static ig a(@NonNull ViewGroup viewGroup, @Nullable List<View> list, @Nullable View.OnClickListener onClickListener) {
        return new ig(viewGroup, list, null, onClickListener);
    }

    public static ig a(@NonNull ViewGroup viewGroup, @Nullable List<View> list, @Nullable MediaAdView mediaAdView, @Nullable View.OnClickListener onClickListener) {
        return new ig(viewGroup, list, mediaAdView, onClickListener);
    }

    public static ig f(@NonNull ViewGroup viewGroup) {
        return new ig(viewGroup, null);
    }

    public void a(@NonNull gh ghVar) {
        this.f = new WeakReference<>(ghVar);
    }

    public final void b(@NonNull View view, @Nullable View.OnClickListener onClickListener) {
        if (this.b == null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void c(@NonNull ViewGroup viewGroup, @Nullable View.OnClickListener onClickListener) {
        if (!e(viewGroup)) {
            int i = 0;
            while (true) {
                boolean z = true;
                if (i < viewGroup.getChildCount()) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    b(childAt, onClickListener);
                    if (childAt instanceof IconAdView) {
                        this.d = new WeakReference<>((IconAdView) childAt);
                    } else {
                        z = false;
                    }
                    if (!z && (childAt instanceof ViewGroup)) {
                        c((ViewGroup) childAt, onClickListener);
                    }
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public void clearViews() {
        WeakReference<MediaAdView> weakReference = this.c;
        if (weakReference != null) {
            weakReference.clear();
            this.c = null;
        }
        List<WeakReference<View>> list = this.b;
        if (list != null) {
            for (WeakReference<View> weakReference2 : list) {
                View view = weakReference2.get();
                if (view != null) {
                    view.setOnClickListener(null);
                }
            }
            return;
        }
        ViewGroup viewGroup = this.a.get();
        if (viewGroup != null) {
            g(viewGroup);
        }
    }

    public final boolean d(@NonNull ViewGroup viewGroup) {
        if (this.c == null && (viewGroup instanceof MediaAdView)) {
            this.c = new WeakReference<>((MediaAdView) viewGroup);
        } else if (viewGroup instanceof IconAdView) {
            this.d = new WeakReference<>((IconAdView) viewGroup);
        } else {
            r.a aVar = new r.a();
            while (aVar.hasNext()) {
                View view = (View) aVar.next();
                if ((view instanceof ViewGroup) && d((ViewGroup) view)) {
                    return true;
                }
            }
        }
        if (this.c == null || this.d == null) {
            return false;
        }
        return true;
    }

    public final boolean e(@NonNull ViewGroup viewGroup) {
        if (viewGroup instanceof PromoCardRecyclerView) {
            this.g = new WeakReference<>((gn) viewGroup);
            return true;
        } else if (this.c != null || !(viewGroup instanceof MediaAdView)) {
            return false;
        } else {
            this.c = new WeakReference<>((MediaAdView) viewGroup);
            return true;
        }
    }

    @Nullable
    public IconAdView eH() {
        WeakReference<IconAdView> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public gh eI() {
        WeakReference<gh> weakReference = this.f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public gn eJ() {
        WeakReference<gn> weakReference = this.g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean eK() {
        return this.b == null || this.h;
    }

    @Nullable
    public ViewGroup eL() {
        return this.a.get();
    }

    public void eM() {
        WeakReference<gh> weakReference = this.f;
        if (weakReference != null) {
            gh ghVar = weakReference.get();
            if (ghVar != null) {
                ghVar.setViewabilityListener(null);
            }
            this.f.clear();
            this.f = null;
        }
    }

    public final void g(@NonNull ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            if (i < viewGroup.getChildCount()) {
                int i2 = i + 1;
                View childAt = viewGroup.getChildAt(i);
                if (!(childAt instanceof RecyclerView) && !(childAt instanceof MediaAdView) && !(childAt instanceof fo) && !(childAt instanceof gh)) {
                    childAt.setOnClickListener(null);
                    if (childAt instanceof ViewGroup) {
                        g((ViewGroup) childAt);
                    }
                }
                i = i2;
            } else {
                return;
            }
        }
    }

    @Nullable
    public fo getAdChoicesView() {
        WeakReference<fo> weakReference = this.e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public Context getContext() {
        ViewGroup viewGroup = this.a.get();
        if (viewGroup != null) {
            return viewGroup.getContext();
        }
        return null;
    }

    @Nullable
    public MediaAdView getMediaAdView() {
        WeakReference<MediaAdView> weakReference = this.c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
