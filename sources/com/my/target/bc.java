package com.my.target;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.az;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.common.models.ImageData;
import com.my.target.mediation.MediationAdapter;
import com.my.target.mediation.MediationNativeBannerAdAdapter;
import com.my.target.mediation.MediationNativeBannerAdConfig;
import com.my.target.mediation.MyTargetNativeBannerAdAdapter;
import com.my.target.nativeads.NativeBannerAd;
import com.my.target.nativeads.banners.NativeBanner;
import com.my.target.nativeads.views.IconAdView;
import java.lang.ref.WeakReference;
import java.util.Map;
public class bc extends az<MediationNativeBannerAdAdapter> implements ar {
    @NonNull
    public final NativeBannerAd h;
    @Nullable
    public NativeBanner i;
    @NonNull
    public final a j;
    @Nullable
    public WeakReference<IconAdView> k;
    @Nullable
    public WeakReference<View> l;

    public class a implements MediationNativeBannerAdAdapter.MediationNativeBannerAdListener {
        @NonNull
        public final cm a;

        public a(cm cmVar) {
            this.a = cmVar;
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdAdapter.MediationNativeBannerAdListener
        public void onClick(@NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter) {
            bc bcVar = bc.this;
            if (bcVar.e == mediationNativeBannerAdAdapter) {
                Context g = bcVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("click"), g);
                }
                NativeBannerAd.NativeBannerAdListener listener = bc.this.h.getListener();
                if (listener != null) {
                    listener.onClick(bc.this.h);
                }
            }
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdAdapter.MediationNativeBannerAdListener
        public void onLoad(@NonNull NativeBanner nativeBanner, @NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter) {
            if (bc.this.e == mediationNativeBannerAdAdapter) {
                String name = this.a.getName();
                ae.a("MediationNativeBannerAdEngine: data from " + name + " ad network loaded successfully");
                Context g = bc.this.g();
                if ((!"myTarget".equals(this.a.getName()) && !"0".equals(this.a.bN().get("lg"))) && g != null) {
                    ie.a(name, nativeBanner, g);
                }
                bc.this.a(this.a, true);
                bc bcVar = bc.this;
                bcVar.i = nativeBanner;
                NativeBannerAd.NativeBannerAdListener listener = bcVar.h.getListener();
                if (listener != null) {
                    listener.onLoad(nativeBanner, bc.this.h);
                }
            }
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdAdapter.MediationNativeBannerAdListener
        public void onNoAd(@NonNull String str, @NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter) {
            if (bc.this.e == mediationNativeBannerAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationNativeBannerAdEngine: no data from ");
                L.append(this.a.getName());
                L.append(" ad network");
                ae.a(L.toString());
                bc.this.a(this.a, false);
            }
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdAdapter.MediationNativeBannerAdListener
        public void onShow(@NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter) {
            bc bcVar = bc.this;
            if (bcVar.e == mediationNativeBannerAdAdapter) {
                Context g = bcVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("playbackStarted"), g);
                }
                NativeBannerAd.NativeBannerAdListener listener = bc.this.h.getListener();
                if (listener != null) {
                    listener.onShow(bc.this.h);
                }
            }
        }
    }

    public static class b extends az.a implements MediationNativeBannerAdConfig {
        public final int g;
        public final int h;

        public b(@NonNull String str, @Nullable String str2, @NonNull Map<String, String> map, int i, int i2, @NonNull MyTargetPrivacy myTargetPrivacy, int i3, int i4) {
            super(str, str2, map, i, i2, myTargetPrivacy);
            this.g = i3;
            this.h = i4;
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdConfig
        public int getAdChoicesPlacement() {
            return this.h;
        }

        @Override // com.my.target.mediation.MediationNativeBannerAdConfig
        public int getCachePolicy() {
            return this.g;
        }
    }

    public bc(@NonNull NativeBannerAd nativeBannerAd, @NonNull cl clVar, @NonNull a aVar) {
        super(clVar);
        this.h = nativeBannerAd;
        this.j = aVar;
    }

    @NonNull
    public static bc a(@NonNull NativeBannerAd nativeBannerAd, @NonNull cl clVar, @NonNull a aVar) {
        return new bc(nativeBannerAd, clVar, aVar);
    }

    @Override // com.my.target.ar
    @Nullable
    public NativeBanner ag() {
        return this.i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.my.target.mediation.MediationAdapter, com.my.target.cm, android.content.Context] */
    @Override // com.my.target.az
    public void b(@NonNull MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter, @NonNull cm cmVar, @NonNull Context context) {
        MediationNativeBannerAdAdapter mediationNativeBannerAdAdapter2 = mediationNativeBannerAdAdapter;
        b bVar = new b(cmVar.getPlacementId(), cmVar.getPayload(), cmVar.bN(), this.j.getCustomParams().getAge(), this.j.getCustomParams().getGender(), MyTargetPrivacy.currentPrivacy(), this.j.getCachePolicy(), this.h.getAdChoicesPlacement());
        if (mediationNativeBannerAdAdapter2 instanceof MyTargetNativeBannerAdAdapter) {
            cn bP = cmVar.bP();
            if (bP instanceof cs) {
                ((MyTargetNativeBannerAdAdapter) mediationNativeBannerAdAdapter2).setSection((cs) bP);
            }
        }
        try {
            mediationNativeBannerAdAdapter2.load(bVar, new a(cmVar), context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationNativeBannerAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public boolean c(@NonNull MediationAdapter mediationAdapter) {
        return mediationAdapter instanceof MediationNativeBannerAdAdapter;
    }

    /* Return type fixed from 'com.my.target.mediation.MediationAdapter' to match base method */
    @Override // com.my.target.az
    @NonNull
    public MediationNativeBannerAdAdapter d() {
        return new MyTargetNativeBannerAdAdapter();
    }

    @Override // com.my.target.az
    public void e() {
        NativeBannerAd.NativeBannerAdListener listener = this.h.getListener();
        if (listener != null) {
            listener.onNoAd("No data for available ad networks", this.h);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0099  */
    @Override // com.my.target.ar
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerView(@androidx.annotation.NonNull android.view.View r7, @androidx.annotation.Nullable java.util.List<android.view.View> r8, int r9) {
        /*
            r6 = this;
            T extends com.my.target.mediation.MediationAdapter r0 = r6.e
            if (r0 != 0) goto L_0x0008
            java.lang.String r7 = "MediationNativeBannerAdEngine error: can't register view, adapter is not set"
            goto L_0x00c4
        L_0x0008:
            com.my.target.nativeads.banners.NativeBanner r0 = r6.i
            if (r0 != 0) goto L_0x0010
            java.lang.String r7 = "MediationNativeBannerAdEngine error: can't register view, banner is null or not loaded yet"
            goto L_0x00c4
        L_0x0010:
            r6.unregisterView()
            if (r8 == 0) goto L_0x001b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            goto L_0x001d
        L_0x001b:
            java.util.List r0 = java.util.Collections.EMPTY_LIST
        L_0x001d:
            T extends com.my.target.mediation.MediationAdapter r8 = r6.e
            boolean r8 = r8 instanceof com.my.target.mediation.MyTargetNativeBannerAdAdapter
            java.lang.String r1 = "MediationNativeBannerAdEngine error: "
            if (r8 != 0) goto L_0x00c8
            boolean r8 = r7 instanceof android.view.ViewGroup
            if (r8 == 0) goto L_0x00c8
            r8 = r7
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            com.my.target.ig r8 = com.my.target.ig.f(r8)
            com.my.target.nativeads.views.IconAdView r8 = r8.eH()
            if (r8 == 0) goto L_0x00ae
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
            r2.<init>(r8)
            r6.k = r2
            r2 = 0
            T extends com.my.target.mediation.MediationAdapter r3 = r6.e     // Catch:{ all -> 0x004b }
            com.my.target.mediation.MediationNativeBannerAdAdapter r3 = (com.my.target.mediation.MediationNativeBannerAdAdapter) r3     // Catch:{ all -> 0x004b }
            android.content.Context r4 = r7.getContext()     // Catch:{ all -> 0x004b }
            android.view.View r2 = r3.getIconView(r4)     // Catch:{ all -> 0x004b }
            goto L_0x0053
        L_0x004b:
            r3 = move-exception
            java.lang.StringBuilder r4 = a2.b.a.a.a.L(r1)
            a2.b.a.a.a.r1(r3, r4)
        L_0x0053:
            if (r2 == 0) goto L_0x005c
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r2)
            r6.l = r3
        L_0x005c:
            com.my.target.nativeads.banners.NativeBanner r3 = r6.i
            com.my.target.common.models.ImageData r3 = r3.getIcon()
            if (r3 != 0) goto L_0x0066
            r4 = 0
            goto L_0x007f
        L_0x0066:
            int r4 = r3.getWidth()
            if (r4 <= 0) goto L_0x007e
            int r4 = r3.getHeight()
            if (r4 <= 0) goto L_0x007e
            int r4 = r3.getWidth()
            int r5 = r3.getHeight()
            r8.setPlaceHolderDimension(r4, r5)
            goto L_0x0082
        L_0x007e:
            r4 = 1
        L_0x007f:
            r8.setPlaceHolderDimension(r4, r4)
        L_0x0082:
            if (r2 == 0) goto L_0x0099
            java.lang.String r3 = "MediationNativeBannerAdEngine: got IconView from adapter"
            com.my.target.ae.a(r3)
            r8.addView(r2)
            int r8 = r0.indexOf(r8)
            if (r8 < 0) goto L_0x00c8
            r0.remove(r8)
            r0.add(r2)
            goto L_0x00c8
        L_0x0099:
            android.widget.ImageView r8 = r8.getImageView()
            com.my.target.gc r8 = (com.my.target.gc) r8
            r8.setImageData(r3)
            if (r3 == 0) goto L_0x00c8
            android.graphics.Bitmap r2 = r3.getBitmap()
            if (r2 != 0) goto L_0x00c8
            com.my.target.ia.a(r3, r8)
            goto L_0x00c8
        L_0x00ae:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "IconView component not found in ad view  "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = ". It's required"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
        L_0x00c4:
            com.my.target.ae.b(r7)
            return
        L_0x00c8:
            T extends com.my.target.mediation.MediationAdapter r8 = r6.e     // Catch:{ all -> 0x00d0 }
            com.my.target.mediation.MediationNativeBannerAdAdapter r8 = (com.my.target.mediation.MediationNativeBannerAdAdapter) r8     // Catch:{ all -> 0x00d0 }
            r8.registerView(r7, r0, r9)     // Catch:{ all -> 0x00d0 }
            goto L_0x00d8
        L_0x00d0:
            r7 = move-exception
            java.lang.StringBuilder r8 = a2.b.a.a.a.L(r1)
            a2.b.a.a.a.r1(r7, r8)
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.bc.registerView(android.view.View, java.util.List, int):void");
    }

    @Override // com.my.target.ar
    public void setMediaListener(@Nullable NativeBannerAd.NativeBannerAdMediaListener nativeBannerAdMediaListener) {
        ae.a("NativeBannerAdMediaListener is not currently supported for mediation");
    }

    @Override // com.my.target.ar
    public void unregisterView() {
        if (this.e == null) {
            ae.b("MediationNativeBannerAdEngine error: can't unregister view, adapter is not set");
            return;
        }
        WeakReference<View> weakReference = this.l;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            this.l.clear();
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        WeakReference<IconAdView> weakReference2 = this.k;
        IconAdView iconAdView = weakReference2 != null ? weakReference2.get() : null;
        if (iconAdView != null) {
            this.k.clear();
            NativeBanner nativeBanner = this.i;
            ImageData icon = nativeBanner != null ? nativeBanner.getIcon() : null;
            gc gcVar = (gc) iconAdView.getImageView();
            if (icon != null) {
                ia.b(icon, gcVar);
            }
            gcVar.setImageData(null);
        }
        this.l = null;
        this.k = null;
        try {
            ((MediationNativeBannerAdAdapter) this.e).unregisterView();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationNativeBannerAdEngine error: "));
        }
    }
}
