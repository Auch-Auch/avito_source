package com.my.target;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.net.URI;
public class gi extends LinearLayout {
    public static final int kA = io.fh();
    public static final int kz = io.fh();
    @NonNull
    public final io a;
    @NonNull
    public final ImageButton b;
    @NonNull
    public final LinearLayout c;
    @NonNull
    public final TextView d;
    @NonNull
    public final TextView e;
    @NonNull
    public final FrameLayout f;
    @NonNull
    public final View g;
    @NonNull
    public final FrameLayout h;
    @NonNull
    public final ImageButton i;
    @NonNull
    public final RelativeLayout j;
    @NonNull
    public final fs k;
    @NonNull
    public final ProgressBar l;
    @Nullable
    public b m;

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            gi giVar = gi.this;
            giVar.d.setText(giVar.a(str));
            return true;
        }
    }

    public interface b {
        void p();
    }

    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i < 100 && gi.this.l.getVisibility() == 8) {
                gi.this.l.setVisibility(0);
                gi.this.g.setVisibility(8);
            }
            gi.this.l.setProgress(i);
            if (i >= 100) {
                gi.this.l.setVisibility(8);
                gi.this.g.setVisibility(0);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            gi.this.e.setText(webView.getTitle());
            gi.this.e.setVisibility(0);
        }
    }

    public class d implements View.OnClickListener {
        public d(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            gi giVar = gi.this;
            if (view == giVar.b) {
                b bVar = giVar.m;
                if (bVar != null) {
                    bVar.p();
                }
            } else if (view == giVar.i) {
                String url = giVar.k.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                        if (!(giVar.getContext() instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        giVar.getContext().startActivity(intent);
                    } catch (Throwable unused) {
                        a2.b.a.a.a.U0("unable to open url ", url);
                    }
                }
            }
        }
    }

    public gi(@NonNull Context context) {
        super(context);
        this.j = new RelativeLayout(context);
        this.k = new fs(context);
        this.b = new ImageButton(context);
        this.c = new LinearLayout(context);
        this.d = new TextView(context);
        this.e = new TextView(context);
        this.f = new FrameLayout(context);
        this.h = new FrameLayout(context);
        this.i = new ImageButton(context);
        this.l = new ProgressBar(context, null, 16842872);
        this.g = new View(context);
        this.a = io.af(context);
    }

    public final String a(String str) {
        try {
            URI uri = new URI(str);
            return uri.getScheme() + "://" + uri.getHost();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public boolean canGoBack() {
        return this.k.canGoBack();
    }

    public void destroy() {
        this.k.setWebChromeClient(null);
        this.k.destroy();
    }

    public void goBack() {
        this.k.goBack();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void init() {
        WebSettings settings = this.k.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        }
        this.k.setWebViewClient(new a());
        this.k.setWebChromeClient(new c());
        setOrientation(1);
        setGravity(16);
        d dVar = new d(null);
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        TypedValue typedValue = new TypedValue();
        int L = this.a.L(50);
        if (getContext().getTheme().resolveAttribute(16843499, typedValue, true)) {
            L = TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics());
        }
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, L));
        this.f.setLayoutParams(new LinearLayout.LayoutParams(L, L));
        FrameLayout frameLayout = this.f;
        int i2 = kz;
        frameLayout.setId(i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageBitmap(fh.c(L / 4, this.a.L(2)));
        this.b.setContentDescription("Close");
        this.b.setOnClickListener(dVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(L, L);
        layoutParams2.addRule(21);
        this.h.setLayoutParams(layoutParams2);
        FrameLayout frameLayout2 = this.h;
        int i3 = kA;
        frameLayout2.setId(i3);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.i.setLayoutParams(layoutParams3);
        this.i.setImageBitmap(fh.P(getContext()));
        this.i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.i.setContentDescription("Open outside");
        this.i.setOnClickListener(dVar);
        io.a(this.b, 0, -3355444);
        io.a(this.i, 0, -3355444);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(1, i2);
        layoutParams4.addRule(0, i3);
        this.c.setLayoutParams(layoutParams4);
        this.c.setOrientation(1);
        this.c.setPadding(this.a.L(4), this.a.L(4), this.a.L(4), this.a.L(4));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        this.e.setVisibility(8);
        this.e.setLayoutParams(layoutParams5);
        this.e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.e.setTextSize(2, 18.0f);
        this.e.setSingleLine();
        this.e.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.d.setSingleLine();
        this.d.setTextSize(2, 12.0f);
        this.d.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(-16537100), GravityCompat.START, 1);
        ColorDrawable colorDrawable = new ColorDrawable(-1968642);
        LayerDrawable layerDrawable = (LayerDrawable) this.l.getProgressDrawable();
        layerDrawable.setDrawableByLayerId(16908288, colorDrawable);
        layerDrawable.setDrawableByLayerId(16908301, clipDrawable);
        this.l.setProgressDrawable(layerDrawable);
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, this.a.L(2)));
        this.l.setProgress(0);
        this.c.addView(this.e);
        this.c.addView(this.d);
        this.f.addView(this.b);
        this.h.addView(this.i);
        this.j.addView(this.f);
        this.j.addView(this.c);
        this.j.addView(this.h);
        addView(this.j);
        this.g.setBackgroundColor(-5592406);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 1);
        this.g.setVisibility(8);
        this.g.setLayoutParams(layoutParams6);
        addView(this.l);
        addView(this.g);
        addView(this.k);
    }

    public void setListener(@Nullable b bVar) {
        this.m = bVar;
    }

    public void setUrl(@NonNull String str) {
        this.k.loadUrl(str);
        this.d.setText(a(str));
    }
}
