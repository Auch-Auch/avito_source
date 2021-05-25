package com.my.target;

import a2.l.a.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ag;
import com.my.target.al;
import com.my.target.am;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.gh;
import com.my.target.gn;
import com.my.target.iq;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import java.util.List;
public class an {
    public final boolean a;
    public final boolean b;
    @NonNull
    public final b c;
    @NonNull
    public final cg d;
    @NonNull
    public final ak e;
    @NonNull
    public final iq f;
    @NonNull
    public final iq.b g;
    @NonNull
    public final gh.a h;
    public boolean i;
    public int j = 0;
    @Nullable
    public am k;
    @Nullable
    public Parcelable l;
    public boolean m;
    public boolean n;
    public boolean o = true;
    @Nullable
    public ig p;
    public boolean q;
    public View.OnClickListener r;

    public class a implements ag.b {
        public a() {
        }

        @Override // com.my.target.ag.b
        public void i(@NonNull Context context) {
            im.a(an.this.d.getStatHolder().K("closedByUser"), context);
            ig igVar = an.this.p;
            ViewGroup eL = igVar != null ? igVar.eL() : null;
            an.this.f.fj();
            an.this.f.a(null);
            an.this.e(false);
            an.this.q = true;
            if (eL != null) {
                eL.setVisibility(4);
            }
        }
    }

    public interface b extends View.OnClickListener, al.a, am.b, gn.a {
        void ab();

        void ac();

        void n(@NonNull Context context);
    }

    public class c extends iq.b {
        public c() {
        }

        @Override // com.my.target.iq.b
        public void aa() {
            ig igVar;
            an anVar = an.this;
            ig igVar2 = anVar.p;
            Context context = igVar2 != null ? igVar2.getContext() : null;
            if (context != null) {
                anVar.c.n(context);
            }
            if (anVar.j != 1 && (igVar = anVar.p) != null) {
                igVar.eM();
            }
        }

        @Override // com.my.target.iq.b
        public void g(boolean z) {
            an anVar = an.this;
            ig igVar = anVar.p;
            if (igVar == null || igVar.eL() == null) {
                anVar.unregisterView();
            } else if (anVar.j == 1) {
                anVar.e(z);
            }
        }
    }

    public class d implements gh.a {
        public d() {
        }

        @Override // com.my.target.gh.a
        public void h(boolean z) {
            ViewGroup eL;
            an anVar = an.this;
            if (z) {
                ig igVar = anVar.p;
                if (igVar != null && (eL = igVar.eL()) != null) {
                    anVar.f.m(eL);
                    return;
                }
                return;
            }
            anVar.e(false);
            anVar.f.fj();
        }
    }

    public an(@NonNull cg cgVar, @NonNull b bVar, boolean z) {
        boolean z2 = false;
        this.c = bVar;
        this.d = cgVar;
        this.a = cgVar.getNativeAdCards().size() > 0;
        this.b = z && id.eF() && id.eG();
        cf<VideoData> videoBanner = cgVar.getVideoBanner();
        this.i = (videoBanner == null || videoBanner.getMediaData() == null) ? false : true;
        this.e = ak.b(cgVar.getAdChoices());
        this.f = iq.a(cgVar.getViewability(), cgVar.getStatHolder(), videoBanner == null ? true : z2);
        this.g = new c();
        this.h = new d();
    }

    public static an a(@NonNull cg cgVar, @NonNull b bVar, boolean z) {
        return new an(cgVar, bVar, z);
    }

    @Nullable
    public int[] V() {
        MediaAdView mediaAdView;
        gm c2;
        ig igVar = this.p;
        if (igVar == null) {
            return null;
        }
        int i2 = this.j;
        if (i2 == 2) {
            gn eJ = igVar.eJ();
            if (eJ == null) {
                return null;
            }
            return eJ.getVisibleCardNumbers();
        } else if (i2 != 3 || (mediaAdView = igVar.getMediaAdView()) == null || (c2 = c(mediaAdView)) == null) {
            return null;
        } else {
            return c2.getVisibleCardNumbers();
        }
    }

    public void W() {
        MediaAdView mediaAdView;
        this.i = false;
        this.j = 0;
        am amVar = this.k;
        if (amVar != null) {
            amVar.unregister();
        }
        ig igVar = this.p;
        if (igVar != null && (mediaAdView = igVar.getMediaAdView()) != null) {
            ImageData image = this.d.getImage();
            mediaAdView.setBackgroundColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
            gm c2 = c(mediaAdView);
            if (c2 != null) {
                this.l = c2.getState();
                c2.dispose();
                ((View) c2).setVisibility(8);
            }
            d(mediaAdView, image);
            mediaAdView.getImageView().setVisibility(0);
            if (this.o) {
                mediaAdView.setOnClickListener(this.c);
            }
        }
    }

    public void a(@NonNull View view, @Nullable List<View> list, int i2, @Nullable MediaAdView mediaAdView) {
        gh eI;
        fm fmVar;
        VideoData videoData;
        if (!(view instanceof ViewGroup)) {
            ae.b("unable to register view for displaying NativeAd " + view + ", should be instance of ViewGroup");
        } else if (this.q) {
            ae.b("Registering ad was disabled by user");
            view.setVisibility(4);
        } else {
            boolean z = false;
            view.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) view;
            ig a3 = ig.a(viewGroup, list, mediaAdView, this.c);
            this.p = a3;
            MediaAdView mediaAdView2 = a3.getMediaAdView();
            gn eJ = this.p.eJ();
            IconAdView eH = this.p.eH();
            this.o = this.p.eK();
            if (eH == null) {
                StringBuilder L = a2.b.a.a.a.L("IconAdView component not found in ad view ");
                L.append(viewGroup.getClass().getName());
                L.append(". It will be required in future versions of sdk.");
                ae.b(L.toString());
            } else {
                il.fb();
            }
            if (mediaAdView2 == null) {
                StringBuilder L2 = a2.b.a.a.a.L("MediaAdView component not found in ad view ");
                L2.append(viewGroup.getClass().getName());
                L2.append(". It will be required in future versions of sdk.");
                ae.b(L2.toString());
            } else {
                il.fa();
            }
            this.f.a(this.g);
            ig igVar = this.p;
            if (igVar != null) {
                gh eI2 = igVar.eI();
                if (eI2 == null) {
                    eI2 = new gh(viewGroup.getContext());
                    io.a(eI2, "viewability_view");
                    try {
                        viewGroup.addView(eI2);
                        this.p.a(eI2);
                    } catch (Throwable th) {
                        a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Unable to add Viewability View: "));
                        this.m = true;
                    }
                }
                eI2.setViewabilityListener(this.h);
            }
            this.e.a(viewGroup, this.p.getAdChoicesView(), new a(), i2);
            if (this.a && eJ != null) {
                this.j = 2;
                eJ.setPromoCardSliderListener(this.c);
                Parcelable parcelable = this.l;
                if (parcelable != null) {
                    eJ.restoreState(parcelable);
                }
            } else if (mediaAdView2 != null) {
                ImageData image = this.d.getImage();
                if (this.a) {
                    d(mediaAdView2, image);
                    if (this.j != 2) {
                        this.j = 3;
                        Context context = mediaAdView2.getContext();
                        gm c2 = c(mediaAdView2);
                        if (c2 == null) {
                            c2 = new gl(context);
                            mediaAdView2.addView(c2.getView(), new ViewGroup.LayoutParams(-1, -1));
                        }
                        Parcelable parcelable2 = this.l;
                        if (parcelable2 != null) {
                            c2.restoreState(parcelable2);
                        }
                        c2.getView().setClickable(this.o);
                        c2.setupCards(this.d.getNativeAdCards());
                        c2.setPromoCardSliderListener(this.c);
                        mediaAdView2.setBackgroundColor(0);
                        c2.setVisibility(0);
                    }
                } else {
                    gc gcVar = (gc) mediaAdView2.getImageView();
                    if (image != null) {
                        Bitmap bitmap = image.getBitmap();
                        if (bitmap != null) {
                            gcVar.setImageBitmap(bitmap);
                        } else {
                            gcVar.setImageBitmap(null);
                            ia.a(image, gcVar, new a2.l.a.d(this));
                        }
                    } else {
                        gcVar.setImageBitmap(null);
                    }
                    ci content = this.d.getContent();
                    if (content != null) {
                        fmVar = b(mediaAdView2);
                        if (fmVar == null) {
                            fmVar = new fm(mediaAdView2.getContext());
                            mediaAdView2.addView(fmVar, new ViewGroup.LayoutParams(-2, -2));
                        }
                        fmVar.a(this.d.getCtcText(), this.d.getCtcIcon());
                        View.OnClickListener cVar = new a2.l.a.c(this, content);
                        this.r = cVar;
                        fmVar.setOnClickListener(cVar);
                    } else {
                        fmVar = null;
                    }
                    if (this.i) {
                        boolean z2 = fmVar != null;
                        b bVar = this.c;
                        this.j = 1;
                        cf<VideoData> videoBanner = this.d.getVideoBanner();
                        if (videoBanner != null) {
                            mediaAdView2.setPlaceHolderDimension(videoBanner.getWidth(), videoBanner.getHeight());
                            videoData = videoBanner.getMediaData();
                        } else {
                            videoData = null;
                        }
                        if (this.k == null && videoData != null) {
                            this.j = 1;
                            this.k = new am(this.d, videoBanner, videoData, this.b);
                        }
                        if (this.k != null) {
                            mediaAdView2.setOnClickListener(new e(this));
                            am amVar = this.k;
                            amVar.s = bVar;
                            amVar.w = z2;
                            amVar.x = z2;
                            amVar.i = this.c;
                            ig igVar2 = this.p;
                            if (igVar2 != null) {
                                amVar.a(mediaAdView2, igVar2.getContext());
                            }
                        }
                    } else {
                        d(mediaAdView2, image);
                        this.j = 0;
                        mediaAdView2.getImageView().setVisibility(0);
                        mediaAdView2.getPlayButtonView().setVisibility(8);
                        mediaAdView2.getProgressBarView().setVisibility(8);
                        if (this.o) {
                            mediaAdView2.setOnClickListener(this.c);
                        }
                    }
                }
            }
            if (eH != null) {
                ImageView imageView = eH.getImageView();
                if (imageView instanceof gc) {
                    ImageData icon = this.d.getIcon();
                    if (icon != null) {
                        Bitmap bitmap2 = icon.getBitmap();
                        int width = icon.getWidth();
                        int height = icon.getHeight();
                        if (width <= 0 || height <= 0) {
                            width = 100;
                            height = 100;
                        }
                        ((gc) imageView).setPlaceholderDimensions(width, height);
                        if (bitmap2 == null) {
                            ia.a(icon, imageView, new a2.l.a.b(this));
                        } else {
                            imageView.setImageBitmap(bitmap2);
                        }
                    } else {
                        imageView.setImageBitmap(null);
                        ((gc) imageView).setPlaceholderDimensions(0, 0);
                    }
                }
            }
            il.ae(viewGroup.getContext());
            ig igVar3 = this.p;
            if (!(igVar3 == null || (eI = igVar3.eI()) == null)) {
                z = eI.ef();
            }
            if (z || this.m) {
                this.f.m(viewGroup);
            }
        }
    }

    @Nullable
    public final fm b(@NonNull MediaAdView mediaAdView) {
        int childCount = mediaAdView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = mediaAdView.getChildAt(i2);
            if (childAt instanceof fm) {
                return (fm) childAt;
            }
        }
        return null;
    }

    @Nullable
    public final gm c(@NonNull MediaAdView mediaAdView) {
        if (!this.a) {
            return null;
        }
        for (int i2 = 0; i2 < mediaAdView.getChildCount(); i2++) {
            View childAt = mediaAdView.getChildAt(i2);
            if (childAt instanceof gn) {
                return (gm) childAt;
            }
        }
        return null;
    }

    public final void d(@NonNull MediaAdView mediaAdView, @Nullable ImageData imageData) {
        if (imageData != null) {
            int width = imageData.getWidth();
            int height = imageData.getHeight();
            if (this.n || width <= 0 || height <= 0) {
                mediaAdView.setPlaceHolderDimension(16, 9);
                this.n = true;
                return;
            }
            mediaAdView.setPlaceHolderDimension(width, height);
            return;
        }
        mediaAdView.setPlaceHolderDimension(0, 0);
    }

    public void e(boolean z) {
        am amVar = this.k;
        if (amVar != null) {
            if (z) {
                amVar.w();
            } else {
                amVar.x();
            }
        }
    }

    public void unregisterView() {
        this.f.fj();
        this.f.a(null);
        am amVar = this.k;
        if (amVar != null) {
            amVar.unregister();
        }
        ig igVar = this.p;
        if (igVar != null) {
            IconAdView eH = igVar.eH();
            if (eH != null) {
                eH.setOnClickListener(null);
                ImageView imageView = eH.getImageView();
                imageView.setImageBitmap(null);
                if (imageView instanceof gc) {
                    ((gc) imageView).setPlaceholderDimensions(0, 0);
                }
                ImageData icon = this.d.getIcon();
                if (icon != null) {
                    ia.b(icon, imageView);
                }
            }
            MediaAdView mediaAdView = this.p.getMediaAdView();
            if (mediaAdView != null) {
                ImageData image = this.d.getImage();
                gc gcVar = (gc) mediaAdView.getImageView();
                if (image != null) {
                    ia.b(image, gcVar);
                }
                mediaAdView.getProgressBarView().setVisibility(8);
                mediaAdView.getPlayButtonView().setVisibility(8);
                gcVar.setImageData(null);
                mediaAdView.setPlaceHolderDimension(0, 0);
                mediaAdView.setOnClickListener(null);
                mediaAdView.setBackgroundColor(MediaAdView.COLOR_PLACEHOLDER_GRAY);
                gm c2 = c(mediaAdView);
                if (c2 != null) {
                    this.l = c2.getState();
                    c2.dispose();
                    ((View) c2).setVisibility(8);
                }
                fm b2 = b(mediaAdView);
                if (b2 != null) {
                    mediaAdView.removeView(b2);
                }
            }
            gn eJ = this.p.eJ();
            if (eJ != null) {
                eJ.setPromoCardSliderListener(null);
                this.l = eJ.getState();
                eJ.dispose();
            }
            ViewGroup eL = this.p.eL();
            if (eL != null) {
                this.e.a(eL);
                eL.setVisibility(0);
            }
            this.p.clearViews();
            this.p = null;
        }
    }
}
