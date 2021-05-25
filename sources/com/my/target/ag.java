package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.bo;
import com.my.target.common.models.ImageData;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
public class ag {
    @Nullable
    public final bo a;
    @Nullable
    public final a2.l.a.a b;
    @Nullable
    public final a c;
    @Nullable
    public WeakReference<fo> d;

    public class a implements View.OnClickListener {
        @NonNull
        public final String a;

        public a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = view.getContext();
            a2.l.a.a aVar = ag.this.b;
            if (aVar == null) {
                ib.m(this.a, context);
                return;
            }
            WeakReference<fk> weakReference = aVar.c;
            if (!((weakReference == null || weakReference.get() == null) ? false : true)) {
                a2.l.a.a aVar2 = ag.this.b;
                Objects.requireNonNull(aVar2);
                try {
                    fk a3 = fk.a(aVar2, context);
                    aVar2.c = new WeakReference<>(a3);
                    a3.show();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ae.b("Unable to start adchoices dialog");
                    WeakReference<fk> weakReference2 = aVar2.c;
                    if (weakReference2 != null) {
                        weakReference2.clear();
                        aVar2.c = null;
                    }
                }
            }
        }
    }

    public interface b {
        void i(@NonNull Context context);
    }

    public ag(@Nullable bo boVar) {
        this.a = boVar;
        a2.l.a.a aVar = null;
        a aVar2 = null;
        aVar = null;
        if (boVar == null) {
            this.b = null;
        } else {
            List<bo.a> aX = boVar.aX();
            if (aX != null && !aX.isEmpty()) {
                aVar = new a2.l.a.a(aX);
            }
            this.b = aVar;
            aVar2 = new a(boVar.aW());
        }
        this.c = aVar2;
    }

    public static ag a(@Nullable bo boVar) {
        return new ag(boVar);
    }

    public void a(@NonNull fo foVar, @NonNull b bVar) {
        if (this.a == null) {
            b(foVar);
            return;
        }
        a2.l.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b = bVar;
        }
        this.d = new WeakReference<>(foVar);
        foVar.setVisibility(0);
        foVar.setOnClickListener(this.c);
        ImageData icon = this.a.getIcon();
        Bitmap bitmap = icon.getBitmap();
        if (icon.getBitmap() != null) {
            foVar.setImageBitmap(bitmap);
        } else {
            ia.a(icon, foVar);
        }
    }

    public void b(@NonNull fo foVar) {
        foVar.setImageBitmap(null);
        foVar.setVisibility(8);
        foVar.setOnClickListener(null);
    }

    public void unregister() {
        a2.l.a.a aVar = this.b;
        if (aVar != null) {
            aVar.b = null;
        }
        WeakReference<fo> weakReference = this.d;
        fo foVar = weakReference != null ? weakReference.get() : null;
        if (foVar != null) {
            bo boVar = this.a;
            if (boVar != null) {
                ia.b(boVar.getIcon(), foVar);
            }
            b(foVar);
            this.d.clear();
            this.d = null;
        }
    }
}
