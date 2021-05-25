package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.my.target.ej;
public class ef implements ej {
    @Nullable
    public ej.a a;
    @NonNull
    public final fz b;

    public class a implements View.OnClickListener {
        public final /* synthetic */ cd a;

        public a(cd cdVar) {
            this.a = cdVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ej.a aVar = ef.this.a;
            if (aVar != null) {
                aVar.b(this.a, null, view.getContext());
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ej.a aVar = ef.this.a;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    @VisibleForTesting
    public ef(@NonNull fz fzVar) {
        this.b = fzVar;
    }

    public static ef y(Context context) {
        return new ef(new fz(context));
    }

    public void a(@NonNull cd cdVar) {
        this.b.a(cdVar.getOptimalLandscapeImage(), cdVar.getOptimalPortraitImage(), cdVar.getCloseIcon());
        this.b.setAgeRestrictions(cdVar.getAgeRestrictions());
        this.b.getImageView().setOnClickListener(new a(cdVar));
        this.b.getCloseButton().setOnClickListener(new b());
        ej.a aVar = this.a;
        if (aVar != null) {
            aVar.a(cdVar, this.b);
        }
    }

    public void a(@Nullable ej.a aVar) {
        this.a = aVar;
    }

    @Override // com.my.target.ej
    @NonNull
    public View cZ() {
        return this.b;
    }

    @Override // com.my.target.ej
    public void destroy() {
    }

    @Override // com.my.target.ej
    public void pause() {
    }

    @Override // com.my.target.ej
    public void resume() {
    }

    @Override // com.my.target.ej
    public void stop() {
    }
}
