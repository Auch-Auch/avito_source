package com.my.target;

import a2.l.a.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ag;
import com.my.target.common.models.ImageData;
import com.my.target.gh;
import com.my.target.iq;
import com.my.target.nativeads.views.IconAdView;
import java.util.List;
public class ao {
    @NonNull
    public final b a;
    @NonNull
    public final cg b;
    @NonNull
    public final ak c;
    @NonNull
    public final iq d;
    @NonNull
    public final iq.b e = new c();
    @NonNull
    public final gh.a f = new d();
    public boolean g;
    @Nullable
    public ig h;
    public boolean i;

    public class a implements ag.b {
        public a() {
        }

        @Override // com.my.target.ag.b
        public void i(@NonNull Context context) {
            im.a(ao.this.b.getStatHolder().K("closedByUser"), context);
            ig igVar = ao.this.h;
            ViewGroup eL = igVar != null ? igVar.eL() : null;
            ao.this.d.fj();
            ao.this.d.a(null);
            ao.this.i = true;
            if (eL != null) {
                eL.setVisibility(4);
            }
        }
    }

    public interface b extends View.OnClickListener {
        void ab();

        void n(@NonNull Context context);
    }

    public class c extends iq.b {
        public c() {
        }

        @Override // com.my.target.iq.b
        public void aa() {
            ao aoVar = ao.this;
            ig igVar = aoVar.h;
            Context context = igVar != null ? igVar.getContext() : null;
            if (context != null) {
                aoVar.a.n(context);
            }
            ig igVar2 = aoVar.h;
            if (igVar2 != null) {
                igVar2.eM();
            }
        }
    }

    public class d implements gh.a {
        public d() {
        }

        @Override // com.my.target.gh.a
        public void h(boolean z) {
            ViewGroup eL;
            ao aoVar = ao.this;
            if (z) {
                ig igVar = aoVar.h;
                if (igVar != null && (eL = igVar.eL()) != null) {
                    aoVar.d.m(eL);
                    return;
                }
                return;
            }
            aoVar.d.fj();
        }
    }

    public ao(@NonNull cg cgVar, @NonNull b bVar) {
        this.a = bVar;
        this.b = cgVar;
        this.c = ak.b(cgVar.getAdChoices());
        this.d = iq.a(cgVar.getViewability(), cgVar.getStatHolder(), true);
    }

    public static ao a(@NonNull cg cgVar, @NonNull b bVar) {
        return new ao(cgVar, bVar);
    }

    public void registerView(@NonNull View view, @Nullable List<View> list, int i2) {
        gh eI;
        if (this.i) {
            ae.b("Registering ad was disabled by user");
            view.setVisibility(4);
            return;
        }
        boolean z = false;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            ae.b("unable to register view for displaying NativeBannerAd " + view + ", should be instance of ViewGroup");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        ig a3 = ig.a(viewGroup, list, this.a);
        this.h = a3;
        IconAdView eH = a3.eH();
        if (eH == null) {
            ae.b("IconAdView component not found in ad view  " + viewGroup + ". It's required");
            return;
        }
        il.fb();
        ImageView imageView = eH.getImageView();
        if (imageView instanceof gc) {
            ImageData icon = this.b.getIcon();
            if (icon != null) {
                Bitmap bitmap = icon.getBitmap();
                int width = icon.getWidth();
                int height = icon.getHeight();
                if (width <= 0 || height <= 0) {
                    width = 100;
                    height = 100;
                }
                ((gc) imageView).setPlaceholderDimensions(width, height);
                if (bitmap == null) {
                    ia.a(icon, imageView, new f(this));
                } else {
                    imageView.setImageBitmap(bitmap);
                }
            } else {
                imageView.setImageBitmap(null);
                ((gc) imageView).setPlaceholderDimensions(0, 0);
            }
        }
        this.d.a(this.e);
        ig igVar = this.h;
        if (igVar != null) {
            gh eI2 = igVar.eI();
            if (eI2 == null) {
                eI2 = new gh(viewGroup.getContext());
                io.a(eI2, "viewability_view");
                try {
                    viewGroup.addView(eI2);
                    this.h.a(eI2);
                } catch (Throwable th) {
                    a2.b.a.a.a.q1(th, a2.b.a.a.a.L("Unable to add Viewability View: "));
                    this.g = true;
                }
            }
            eI2.setViewabilityListener(this.f);
        }
        this.c.a(viewGroup, this.h.getAdChoicesView(), new a(), i2);
        ig igVar2 = this.h;
        if (!(igVar2 == null || (eI = igVar2.eI()) == null)) {
            z = eI.ef();
        }
        if (z || this.g) {
            this.d.m(viewGroup);
        }
    }

    public void unregisterView() {
        this.d.fj();
        this.d.a(null);
        ig igVar = this.h;
        if (igVar != null) {
            IconAdView eH = igVar.eH();
            if (eH != null) {
                eH.setOnClickListener(null);
                ImageView imageView = eH.getImageView();
                imageView.setImageBitmap(null);
                if (imageView instanceof gc) {
                    ((gc) imageView).setPlaceholderDimensions(0, 0);
                }
                ImageData icon = this.b.getIcon();
                if (icon != null) {
                    ia.b(icon, imageView);
                }
            }
            ViewGroup eL = this.h.eL();
            if (eL != null) {
                this.c.a(eL);
                eL.setVisibility(0);
            }
            this.h.clearViews();
            this.h = null;
        }
    }
}
