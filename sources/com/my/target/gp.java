package com.my.target;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
@SuppressLint({"ViewConstructor"})
public class gp extends RelativeLayout {
    @NonNull
    public final RelativeLayout a;
    @NonNull
    public final ImageView b;
    @NonNull
    public final ImageView c;
    @NonNull
    public final io d;
    public final boolean e;
    @NonNull
    public final View.OnClickListener f;

    public static class b implements View.OnClickListener {
        @NonNull
        public final Context a;

        public b(Context context, a aVar) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://target.my.com/"));
                if (!(this.a instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                this.a.startActivity(intent);
            } catch (Throwable th) {
                ae.a(th.getMessage());
            }
        }
    }

    public gp(@NonNull Context context, @NonNull io ioVar, boolean z) {
        super(context);
        this.a = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        this.b = imageView;
        io.a(imageView, "logo_image");
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        io.a(imageView2, "store_image");
        this.d = ioVar;
        this.e = z;
        this.f = new b(context, null);
    }
}
