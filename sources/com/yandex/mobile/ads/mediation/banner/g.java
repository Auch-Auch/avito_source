package com.yandex.mobile.ads.mediation.banner;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.bd;
import com.yandex.mobile.ads.mediation.banner.MediatedBannerAdapter;
import java.lang.ref.WeakReference;
public final class g {
    @NonNull
    private final Handler a = new Handler(Looper.getMainLooper());
    @NonNull
    private final WeakReference<ViewGroup> b;
    @NonNull
    private final bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> c;

    public g(@Nullable ViewGroup viewGroup, @NonNull bd<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> bdVar) {
        this.b = new WeakReference<>(viewGroup);
        this.c = bdVar;
    }

    public static /* synthetic */ void c(g gVar) {
        int childCount;
        ViewGroup viewGroup = gVar.b.get();
        if (viewGroup != null && viewGroup.getChildCount() > 0 && viewGroup.getChildCount() - 1 > 0) {
            viewGroup.removeViews(0, childCount);
        }
    }

    public final void a(@NonNull final View view) {
        this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.mediation.banner.g.1
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup viewGroup = (ViewGroup) g.this.b.get();
                if (viewGroup != null && viewGroup.indexOfChild(view) == -1) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(view, layoutParams);
                    viewGroup.setVisibility(0);
                    view.setVisibility(0);
                    g gVar = g.this;
                    View view2 = view;
                    view2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(view2) { // from class: com.yandex.mobile.ads.mediation.banner.g.2
                        public final /* synthetic */ View a;

                        {
                            this.a = r2;
                        }

                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public final boolean onPreDraw() {
                            if (!this.a.isShown()) {
                                return true;
                            }
                            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                            g.this.c.c(this.a.getContext());
                            g.this.a.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.mediation.banner.g.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    g.c(g.this);
                                }
                            }, 50);
                            return true;
                        }
                    });
                }
            }
        });
    }
}
