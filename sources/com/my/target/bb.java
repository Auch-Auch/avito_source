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
import com.my.target.mediation.MediationNativeAdAdapter;
import com.my.target.mediation.MediationNativeAdConfig;
import com.my.target.mediation.MyTargetNativeAdAdapter;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class bb extends az<MediationNativeAdAdapter> implements aq {
    @NonNull
    public final NativeAd h;
    @Nullable
    public NativePromoBanner i;
    @NonNull
    public final a j;
    @Nullable
    public WeakReference<MediaAdView> k;
    @Nullable
    public WeakReference<View> l;
    @Nullable
    public WeakReference<IconAdView> m;

    public class a implements MediationNativeAdAdapter.MediationNativeAdListener {
        @NonNull
        public final cm a;

        public a(cm cmVar) {
            this.a = cmVar;
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onClick(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            bb bbVar = bb.this;
            if (bbVar.e == mediationNativeAdAdapter) {
                Context g = bbVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("click"), g);
                }
                NativeAd.NativeAdListener listener = bb.this.h.getListener();
                if (listener != null) {
                    listener.onClick(bb.this.h);
                }
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onLoad(@NonNull NativePromoBanner nativePromoBanner, @NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            if (bb.this.e == mediationNativeAdAdapter) {
                String name = this.a.getName();
                ae.a("MediationNativeAdEngine: data from " + name + " ad network loaded successfully");
                Context g = bb.this.g();
                if ((!"myTarget".equals(this.a.getName()) && !"0".equals(this.a.bN().get("lg"))) && g != null) {
                    ie.a(name, nativePromoBanner, g);
                }
                bb.this.a(this.a, true);
                bb bbVar = bb.this;
                bbVar.i = nativePromoBanner;
                NativeAd.NativeAdListener listener = bbVar.h.getListener();
                if (listener != null) {
                    listener.onLoad(nativePromoBanner, bb.this.h);
                }
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onNoAd(@NonNull String str, @NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            if (bb.this.e == mediationNativeAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationNativeAdEngine: no data from ");
                L.append(this.a.getName());
                L.append(" ad network");
                ae.a(L.toString());
                bb.this.a(this.a, false);
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onShow(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            bb bbVar = bb.this;
            if (bbVar.e == mediationNativeAdAdapter) {
                Context g = bbVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("playbackStarted"), g);
                }
                NativeAd.NativeAdListener listener = bb.this.h.getListener();
                if (listener != null) {
                    listener.onShow(bb.this.h);
                }
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onVideoComplete(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            NativeAd.NativeAdListener listener;
            bb bbVar = bb.this;
            if (bbVar.e == mediationNativeAdAdapter && (listener = bbVar.h.getListener()) != null) {
                listener.onVideoComplete(bb.this.h);
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onVideoPause(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            NativeAd.NativeAdListener listener;
            bb bbVar = bb.this;
            if (bbVar.e == mediationNativeAdAdapter && (listener = bbVar.h.getListener()) != null) {
                listener.onVideoPause(bb.this.h);
            }
        }

        @Override // com.my.target.mediation.MediationNativeAdAdapter.MediationNativeAdListener
        public void onVideoPlay(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter) {
            NativeAd.NativeAdListener listener;
            bb bbVar = bb.this;
            if (bbVar.e == mediationNativeAdAdapter && (listener = bbVar.h.getListener()) != null) {
                listener.onVideoPlay(bb.this.h);
            }
        }
    }

    public static class b extends az.a implements MediationNativeAdConfig {
        public final int g;
        public final int h;

        public b(@NonNull String str, @Nullable String str2, @NonNull Map<String, String> map, int i, int i2, @NonNull MyTargetPrivacy myTargetPrivacy, int i3, int i4) {
            super(str, str2, map, i, i2, myTargetPrivacy);
            this.g = i3;
            this.h = i4;
        }

        @Override // com.my.target.mediation.MediationNativeAdConfig
        public int getAdChoicesPlacement() {
            return this.h;
        }

        @Override // com.my.target.mediation.MediationNativeAdConfig
        public int getCachePolicy() {
            return this.g;
        }

        @Override // com.my.target.mediation.MediationNativeAdConfig
        @Deprecated
        public boolean isAutoLoadImages() {
            int i = this.g;
            return i == 0 || i == 1;
        }

        @Override // com.my.target.mediation.MediationNativeAdConfig
        @Deprecated
        public boolean isAutoLoadVideo() {
            int i = this.g;
            return i == 0 || i == 2;
        }
    }

    public bb(@NonNull NativeAd nativeAd, @NonNull cl clVar, @NonNull a aVar) {
        super(clVar);
        this.h = nativeAd;
        this.j = aVar;
    }

    @NonNull
    public static final bb a(@NonNull NativeAd nativeAd, @NonNull cl clVar, @NonNull a aVar) {
        return new bb(nativeAd, clVar, aVar);
    }

    @Override // com.my.target.aq
    public void a(@NonNull View view, @Nullable List<View> list, int i2, @Nullable MediaAdView mediaAdView) {
        String str;
        ArrayList arrayList;
        int indexOf;
        int i3;
        int i4;
        if (this.e == null) {
            str = "MediationNativeAdEngine error: can't register view, adapter is not set";
        } else if (this.i == null) {
            str = "MediationNativeAdEngine error: can't register view, banner is null or not loaded yet";
        } else {
            unregisterView();
            View view2 = null;
            if (list != null) {
                arrayList = new ArrayList();
                for (View view3 : list) {
                    if (view3 != null) {
                        arrayList.add(view3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (!(this.e instanceof MyTargetNativeAdAdapter) && (view instanceof ViewGroup)) {
                ig a3 = ig.a((ViewGroup) view, mediaAdView);
                MediaAdView mediaAdView2 = a3.getMediaAdView();
                if (mediaAdView2 != null) {
                    this.k = new WeakReference<>(mediaAdView2);
                    try {
                        view2 = ((MediationNativeAdAdapter) this.e).getMediaView(view.getContext());
                    } catch (Throwable th) {
                        a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationNativeAdEngine error: "));
                    }
                    if (view2 != null) {
                        this.l = new WeakReference<>(view2);
                    }
                    ImageData image = this.i.getImage();
                    boolean hasVideo = this.i.hasVideo();
                    if (image != null || hasVideo) {
                        if (image == null || image.getWidth() <= 0 || image.getHeight() <= 0) {
                            i4 = 16;
                            i3 = 10;
                        } else {
                            i4 = image.getWidth();
                            i3 = image.getHeight();
                        }
                        mediaAdView2.setPlaceHolderDimension(i4, i3);
                    } else {
                        mediaAdView2.setPlaceHolderDimension(0, 0);
                    }
                    if (view2 != null) {
                        ae.a("MediationNativeAdEngine: got MediaView from adapter");
                        mediaAdView2.addView(view2);
                        if (arrayList != null && (indexOf = arrayList.indexOf(mediaAdView2)) >= 0) {
                            arrayList.remove(indexOf);
                            arrayList.add(view2);
                        }
                    } else {
                        gc gcVar = (gc) mediaAdView2.getImageView();
                        gcVar.setImageData(image);
                        if (image != null && image.getBitmap() == null) {
                            ia.a(image, gcVar);
                        }
                    }
                }
                IconAdView eH = a3.eH();
                ImageData icon = this.i.getIcon();
                if (!(eH == null || icon == null)) {
                    this.m = new WeakReference<>(eH);
                    gc gcVar2 = (gc) eH.getImageView();
                    gcVar2.setImageData(icon);
                    if (icon.getBitmap() == null) {
                        ia.a(icon, gcVar2);
                    }
                }
            }
            try {
                ((MediationNativeAdAdapter) this.e).registerView(view, arrayList, i2);
                return;
            } catch (Throwable th2) {
                a2.b.a.a.a.r1(th2, a2.b.a.a.a.L("MediationNativeAdEngine error: "));
                return;
            }
        }
        ae.b(str);
    }

    @Override // com.my.target.aq
    @Nullable
    public NativePromoBanner af() {
        return this.i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.my.target.mediation.MediationAdapter, com.my.target.cm, android.content.Context] */
    @Override // com.my.target.az
    public void b(@NonNull MediationNativeAdAdapter mediationNativeAdAdapter, @NonNull cm cmVar, @NonNull Context context) {
        MediationNativeAdAdapter mediationNativeAdAdapter2 = mediationNativeAdAdapter;
        b bVar = new b(cmVar.getPlacementId(), cmVar.getPayload(), cmVar.bN(), this.j.getCustomParams().getAge(), this.j.getCustomParams().getGender(), MyTargetPrivacy.currentPrivacy(), this.j.getCachePolicy(), this.h.getAdChoicesPlacement());
        if (mediationNativeAdAdapter2 instanceof MyTargetNativeAdAdapter) {
            cn bP = cmVar.bP();
            if (bP instanceof cs) {
                ((MyTargetNativeAdAdapter) mediationNativeAdAdapter2).setSection((cs) bP);
            }
        }
        try {
            mediationNativeAdAdapter2.load(bVar, new a(cmVar), context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationNativeAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public boolean c(@NonNull MediationAdapter mediationAdapter) {
        return mediationAdapter instanceof MediationNativeAdAdapter;
    }

    /* Return type fixed from 'com.my.target.mediation.MediationAdapter' to match base method */
    @Override // com.my.target.az
    @NonNull
    public MediationNativeAdAdapter d() {
        return new MyTargetNativeAdAdapter();
    }

    @Override // com.my.target.az
    public void e() {
        NativeAd.NativeAdListener listener = this.h.getListener();
        if (listener != null) {
            listener.onNoAd("No data for available ad networks", this.h);
        }
    }

    @Override // com.my.target.aq
    public void setMediaListener(@Nullable NativeAd.NativeAdMediaListener nativeAdMediaListener) {
        ae.a("NativeAdMediaListener is not currently supported for mediation");
    }

    @Override // com.my.target.aq
    public void unregisterView() {
        if (this.e == null) {
            ae.b("MediationNativeAdEngine error: can't unregister view, adapter is not set");
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
        WeakReference<MediaAdView> weakReference2 = this.k;
        MediaAdView mediaAdView = weakReference2 != null ? weakReference2.get() : null;
        if (mediaAdView != null) {
            this.k.clear();
            NativePromoBanner nativePromoBanner = this.i;
            ImageData image = nativePromoBanner != null ? nativePromoBanner.getImage() : null;
            gc gcVar = (gc) mediaAdView.getImageView();
            if (image != null) {
                ia.b(image, gcVar);
            }
            gcVar.setImageData(null);
            mediaAdView.setPlaceHolderDimension(0, 0);
        }
        WeakReference<IconAdView> weakReference3 = this.m;
        IconAdView iconAdView = weakReference3 != null ? weakReference3.get() : null;
        if (iconAdView != null) {
            this.m.clear();
            NativePromoBanner nativePromoBanner2 = this.i;
            ImageData icon = nativePromoBanner2 != null ? nativePromoBanner2.getIcon() : null;
            gc gcVar2 = (gc) iconAdView.getImageView();
            if (icon != null) {
                ia.b(icon, gcVar2);
            }
            gcVar2.setImageData(null);
        }
        this.l = null;
        this.k = null;
        try {
            ((MediationNativeAdAdapter) this.e).unregisterView();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationNativeAdEngine error: "));
        }
    }
}
