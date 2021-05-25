package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.my.target.common.models.ImageData;
import com.my.target.er;
import com.my.target.fr;
public class ee implements er, fr.a {
    @NonNull
    public final fr a;
    @NonNull
    public final fx b;
    @NonNull
    public final FrameLayout c;
    @NonNull
    public final Handler d = new Handler(Looper.getMainLooper());
    @Nullable
    public c e;
    @Nullable
    public b f;
    @Nullable
    public er.a g;
    public long h;
    public long i;
    @Nullable
    public cc j;
    public long k;
    public long l;

    public static class a implements View.OnClickListener {
        @NonNull
        public final ee a;

        public a(@NonNull ee eeVar) {
            this.a = eeVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            er.a aVar = this.a.g;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    public static class b implements Runnable {
        @NonNull
        public final ee a;

        public b(@NonNull ee eeVar) {
            this.a = eeVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ee eeVar = this.a;
            er.a aVar = eeVar.g;
            if (aVar != null) {
                aVar.p(eeVar.c.getContext());
            }
        }
    }

    public static class c implements Runnable {
        @NonNull
        public final fx a;

        public c(@NonNull fx fxVar) {
            this.a = fxVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.a("banner became just closeable");
            this.a.setVisibility(0);
        }
    }

    public ee(@NonNull Context context) {
        fr frVar = new fr(context);
        this.a = frVar;
        fx fxVar = new fx(context);
        this.b = fxVar;
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        fxVar.setContentDescription("Close");
        io.a(fxVar, "close_button");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = GravityCompat.END;
        fxVar.setVisibility(8);
        fxVar.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 1;
        frVar.setLayoutParams(layoutParams2);
        frameLayout.addView(frVar);
        if (fxVar.getParent() == null) {
            frameLayout.addView(fxVar);
        }
        Bitmap z = fh.z(io.af(context).L(28));
        if (z != null) {
            fxVar.a(z, false);
        }
    }

    @NonNull
    public static ee x(@NonNull Context context) {
        return new ee(context);
    }

    public final void a(long j2) {
        c cVar = this.e;
        if (cVar != null) {
            this.d.removeCallbacks(cVar);
            this.h = System.currentTimeMillis();
            this.d.postDelayed(this.e, j2);
        }
    }

    @Override // com.my.target.er
    public void a(@NonNull cq cqVar, @NonNull cc ccVar) {
        this.j = ccVar;
        this.a.setBannerWebViewListener(this);
        String source = ccVar.getSource();
        if (source != null) {
            this.a.setData(source);
            ImageData closeIcon = ccVar.getCloseIcon();
            if (closeIcon != null) {
                this.b.a(closeIcon.getBitmap(), false);
            }
            this.b.setOnClickListener(new a(this));
            if (ccVar.getAllowCloseDelay() > 0.0f) {
                StringBuilder L = a2.b.a.a.a.L("banner will be allowed to close in ");
                L.append(ccVar.getAllowCloseDelay());
                L.append(" seconds");
                ae.a(L.toString());
                this.e = new c(this.b);
                long allowCloseDelay = (long) (ccVar.getAllowCloseDelay() * 1000.0f);
                this.i = allowCloseDelay;
                a(allowCloseDelay);
            } else {
                ae.a("banner is allowed to close");
                this.b.setVisibility(0);
            }
            if (ccVar.getTimeToReward() > 0.0f) {
                this.f = new b(this);
                long timeToReward = ((long) ccVar.getTimeToReward()) * 1000;
                this.l = timeToReward;
                b(timeToReward);
            }
            er.a aVar = this.g;
            if (aVar != null) {
                aVar.a(ccVar, cZ());
                return;
            }
            return;
        }
        er.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.onNoAd("failed to load, null source");
        }
    }

    @Override // com.my.target.er
    public void a(@Nullable er.a aVar) {
        this.g = aVar;
    }

    public final void b(long j2) {
        b bVar = this.f;
        if (bVar != null) {
            this.d.removeCallbacks(bVar);
            this.k = System.currentTimeMillis();
            this.d.postDelayed(this.f, j2);
        }
    }

    @Override // com.my.target.ej
    @NonNull
    public View cZ() {
        return this.c;
    }

    @Override // com.my.target.fr.a
    public void d(@NonNull String str) {
        er.a aVar = this.g;
        if (aVar != null) {
            aVar.b(this.j, str, cZ().getContext());
        }
    }

    @Override // com.my.target.ej
    public void destroy() {
        this.c.removeView(this.a);
        this.a.destroy();
    }

    @Override // com.my.target.fr.a
    public void onError(@NonNull String str) {
        er.a aVar = this.g;
        if (aVar != null) {
            aVar.onNoAd(str);
        }
    }

    @Override // com.my.target.ej
    public void pause() {
        if (this.h > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            if (currentTimeMillis > 0) {
                long j2 = this.i;
                if (currentTimeMillis < j2) {
                    this.i = j2 - currentTimeMillis;
                }
            }
            this.i = 0;
        }
        if (this.k > 0) {
            long currentTimeMillis2 = System.currentTimeMillis() - this.k;
            if (currentTimeMillis2 > 0) {
                long j3 = this.l;
                if (currentTimeMillis2 < j3) {
                    this.l = j3 - currentTimeMillis2;
                }
            }
            this.l = 0;
        }
        b bVar = this.f;
        if (bVar != null) {
            this.d.removeCallbacks(bVar);
        }
        c cVar = this.e;
        if (cVar != null) {
            this.d.removeCallbacks(cVar);
        }
    }

    @Override // com.my.target.ej
    public void resume() {
        long j2 = this.i;
        if (j2 > 0) {
            a(j2);
        }
        long j3 = this.l;
        if (j3 > 0) {
            b(j3);
        }
    }

    @Override // com.my.target.ej
    public void stop() {
    }
}
