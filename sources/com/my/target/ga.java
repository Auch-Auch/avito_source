package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
public class ga extends fs {
    @Nullable
    public a b;
    public boolean c;
    public boolean d;
    public int e;

    public interface a {
        void aN();

        void onVisibilityChanged(boolean z);
    }

    public static class b extends GestureDetector {
        @NonNull
        public final View a;
        @Nullable
        public a b;

        public interface a {
            void dT();
        }

        public b(@NonNull Context context, @NonNull View view) {
            super(context, new GestureDetector.SimpleOnGestureListener());
            this.a = view;
            setIsLongpressEnabled(false);
        }
    }

    public class c implements b.a {
        public c() {
        }

        @Override // com.my.target.ga.b.a
        public void dT() {
            ga.this.d = true;
        }
    }

    public class d implements View.OnTouchListener {
        public final /* synthetic */ b a;

        public d(ga gaVar, b bVar) {
            this.a = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
            if (r4 <= ((float) r0.getHeight())) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
            if (r2 != false) goto L_0x0055;
         */
        @Override // android.view.View.OnTouchListener
        @android.annotation.SuppressLint({"ClickableViewAccessibility"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                r7 = this;
                com.my.target.ga$b r8 = r7.a
                java.util.Objects.requireNonNull(r8)
                int r0 = r9.getAction()
                r1 = 0
                if (r0 == 0) goto L_0x0055
                r2 = 1
                if (r0 == r2) goto L_0x0040
                r3 = 2
                if (r0 == r3) goto L_0x0013
                goto L_0x0058
            L_0x0013:
                android.view.View r0 = r8.a
                if (r0 != 0) goto L_0x0018
                goto L_0x003c
            L_0x0018:
                float r3 = r9.getX()
                float r4 = r9.getY()
                r5 = 0
                int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r6 < 0) goto L_0x003c
                int r6 = r0.getWidth()
                float r6 = (float) r6
                int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r3 > 0) goto L_0x003c
                int r3 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r3 < 0) goto L_0x003c
                int r0 = r0.getHeight()
                float r0 = (float) r0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 > 0) goto L_0x003c
                goto L_0x003d
            L_0x003c:
                r2 = 0
            L_0x003d:
                if (r2 == 0) goto L_0x0058
                goto L_0x0055
            L_0x0040:
                com.my.target.ga$b$a r9 = r8.b
                if (r9 == 0) goto L_0x004f
                java.lang.String r9 = "Gestures: user clicked"
                com.my.target.ae.a(r9)
                com.my.target.ga$b$a r8 = r8.b
                r8.dT()
                goto L_0x0058
            L_0x004f:
                java.lang.String r8 = "View's onUserClick() is not registered."
                com.my.target.ae.a(r8)
                goto L_0x0058
            L_0x0055:
                r8.onTouchEvent(r9)
            L_0x0058:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.my.target.ga.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public ga(@NonNull Context context) {
        super(context);
        this.c = getVisibility() == 0;
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
            settings.setAllowFileAccess(false);
            settings.setAllowContentAccess(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        b bVar = new b(getContext(), this);
        bVar.b = new c();
        setOnTouchListener(new d(this, bVar));
    }

    public void D(boolean z) {
        ae.a("MraidWebView: pause, finishing " + z);
        if (z) {
            stopLoading();
            loadUrl("");
        }
        onPause();
    }

    public boolean dW() {
        return this.d;
    }

    public boolean isVisible() {
        return this.c;
    }

    @Override // com.my.target.fs, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = ((float) View.MeasureSpec.getSize(i)) / ((float) View.MeasureSpec.getSize(i2)) > 1.0f ? 2 : 1;
        if (i3 != this.e) {
            this.e = i3;
            a aVar = this.b;
            if (aVar != null) {
                aVar.aN();
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        boolean z = i == 0;
        if (z != this.c) {
            this.c = z;
            a aVar = this.b;
            if (aVar != null) {
                aVar.onVisibilityChanged(z);
            }
        }
    }

    @VisibleForTesting
    public void setClicked(boolean z) {
        this.d = z;
    }

    public void setVisibilityChangedListener(@Nullable a aVar) {
        this.b = aVar;
    }
}
