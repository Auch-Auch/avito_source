package com.my.target;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.fk;
import com.my.target.fr;
import com.my.target.fu;
import java.lang.ref.WeakReference;
import java.util.Objects;
public class al implements fk.a, fr.a {
    @NonNull
    public final ci a;
    @Nullable
    public iq b;
    @Nullable
    public WeakReference<fk> c;
    @Nullable
    public WeakReference<fr> d;
    @Nullable
    public a e;
    public boolean f;
    public boolean g;

    public interface a {
        void a(@NonNull ci ciVar, @Nullable String str, @NonNull Context context);
    }

    public class b implements fu.a {
        public final /* synthetic */ fk a;

        public b(fk fkVar) {
            this.a = fkVar;
        }

        @Override // com.my.target.fu.a
        public void onClose() {
            al alVar = al.this;
            fk fkVar = this.a;
            Objects.requireNonNull(alVar);
            if (fkVar.isShowing()) {
                fkVar.dismiss();
            }
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ fr a;
        public final /* synthetic */ ProgressBar b;

        public c(fr frVar, ProgressBar progressBar) {
            this.a = frVar;
            this.b = progressBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            al alVar = al.this;
            fr frVar = this.a;
            ProgressBar progressBar = this.b;
            Objects.requireNonNull(alVar);
            alVar.d = new WeakReference<>(frVar);
            progressBar.setVisibility(8);
            frVar.setVisibility(0);
            iq iqVar = alVar.b;
            if (iqVar != null) {
                iqVar.fj();
            }
            iq a3 = iq.a(alVar.a.getViewability(), alVar.a.getStatHolder());
            alVar.b = a3;
            if (alVar.g) {
                a3.m(frVar);
            }
            im.a(alVar.a.getStatHolder().K("playbackStarted"), frVar.getContext());
        }
    }

    public al(@NonNull ci ciVar) {
        this.a = ciVar;
    }

    public static al a(@NonNull ci ciVar) {
        return new al(ciVar);
    }

    public void a(@Nullable a aVar) {
        this.e = aVar;
    }

    @Override // com.my.target.fk.a
    public void a(@NonNull fk fkVar, @NonNull FrameLayout frameLayout) {
        fu fuVar = new fu(frameLayout.getContext());
        fuVar.setOnCloseListener(new b(fkVar));
        frameLayout.addView(fuVar, -1, -1);
        fr frVar = new fr(frameLayout.getContext());
        frVar.setVisibility(8);
        frVar.setBannerWebViewListener(this);
        fuVar.addView(frVar, new FrameLayout.LayoutParams(-1, -1));
        frVar.setData(this.a.getSource());
        ProgressBar progressBar = new ProgressBar(frameLayout.getContext(), null, 16842871);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(progressBar, layoutParams);
        frameLayout.postDelayed(new c(frVar, progressBar), 555);
    }

    @Override // com.my.target.fk.a
    public void a(boolean z) {
        fr frVar;
        if (z != this.g) {
            this.g = z;
            iq iqVar = this.b;
            if (iqVar == null) {
                return;
            }
            if (z) {
                WeakReference<fr> weakReference = this.d;
                if (weakReference != null && (frVar = weakReference.get()) != null) {
                    this.b.m(frVar);
                    return;
                }
                return;
            }
            iqVar.fj();
        }
    }

    @Override // com.my.target.fr.a
    public void d(@NonNull String str) {
        fk fkVar;
        WeakReference<fk> weakReference = this.c;
        if (weakReference != null && (fkVar = weakReference.get()) != null) {
            a aVar = this.e;
            if (aVar != null) {
                aVar.a(this.a, str, fkVar.getContext());
            }
            this.f = true;
            if (fkVar.isShowing()) {
                fkVar.dismiss();
            }
        }
    }

    public void k(@NonNull Context context) {
        fk a3 = fk.a(this, context);
        this.c = new WeakReference<>(a3);
        try {
            a3.show();
        } catch (Throwable th) {
            th.printStackTrace();
            ae.b("Unable to start video dialog! Check myTarget MediaAdView, maybe it was created with non-Activity context");
            o();
        }
    }

    @Override // com.my.target.fk.a
    public void o() {
        WeakReference<fk> weakReference = this.c;
        if (weakReference != null) {
            fk fkVar = weakReference.get();
            if (!this.f) {
                im.a(this.a.getStatHolder().K("closedByUser"), fkVar.getContext());
            }
            this.c.clear();
            this.c = null;
        }
        iq iqVar = this.b;
        if (iqVar != null) {
            iqVar.fj();
            this.b = null;
        }
        WeakReference<fr> weakReference2 = this.d;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.d = null;
        }
    }

    @Override // com.my.target.fr.a
    public void onError(@NonNull String str) {
        a2.b.a.a.a.U0("content JS error: ", str);
    }
}
