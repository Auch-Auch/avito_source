package com.my.target;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.et;
import com.my.target.eu;
import com.my.target.fr;
public class ev implements eu, fr.a {
    @NonNull
    public final fr a;
    @NonNull
    public final fv b;
    @Nullable
    public et.a c;
    @Nullable
    public eu.a d;
    @Nullable
    public ck e;

    public class a implements fr.d {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.my.target.fr.d
        public void dN() {
            ev evVar = ev.this;
            evVar.a.setData(this.a);
            ev.this.a.setOnLayoutListener(null);
        }
    }

    public ev(@NonNull Context context) {
        fr frVar = new fr(context);
        fv fvVar = new fv(context);
        this.a = frVar;
        this.b = fvVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        fvVar.addView(frVar, 0);
        frVar.setLayoutParams(layoutParams);
        frVar.setBannerWebViewListener(this);
    }

    @NonNull
    public static ev A(@NonNull Context context) {
        return new ev(context);
    }

    @Override // com.my.target.et
    public void a(@NonNull ck ckVar) {
        this.e = ckVar;
        String source = ckVar.getSource();
        if (source == null) {
            eu.a aVar = this.d;
            if (aVar != null) {
                aVar.onNoAd("failed to load, null html");
                return;
            }
            return;
        }
        if (this.a.getMeasuredHeight() == 0 || this.a.getMeasuredWidth() == 0) {
            this.a.setOnLayoutListener(new a(source));
        } else {
            this.a.setData(source);
        }
        eu.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.onLoad();
        }
    }

    @Override // com.my.target.et
    public void a(@Nullable et.a aVar) {
        this.c = aVar;
    }

    @Override // com.my.target.eu
    public void a(@Nullable eu.a aVar) {
        this.d = aVar;
    }

    @Override // com.my.target.fr.a
    public void d(@NonNull String str) {
        et.a aVar;
        ck ckVar = this.e;
        if (ckVar != null && (aVar = this.c) != null && ckVar != null) {
            aVar.a(ckVar, str);
        }
    }

    @Override // com.my.target.et
    @NonNull
    public fv dJ() {
        return this.b;
    }

    @Override // com.my.target.et
    public void destroy() {
        a((eu.a) null);
        a((et.a) null);
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
        this.a.destroy();
    }

    @Override // com.my.target.fr.a
    public void onError(@NonNull String str) {
    }

    @Override // com.my.target.et
    public void pause() {
    }

    @Override // com.my.target.et
    public void resume() {
    }

    @Override // com.my.target.et
    public void start() {
        ck ckVar;
        et.a aVar = this.c;
        if (aVar != null && (ckVar = this.e) != null) {
            aVar.a(ckVar);
        }
    }

    @Override // com.my.target.et
    public void stop() {
    }
}
