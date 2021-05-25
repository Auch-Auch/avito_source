package com.google.androidbrowserhelper.trusted.splashscreens;

import a2.j.c.a.h.c;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.browser.trusted.splashscreens.SplashScreenParamKey;
import androidx.browser.trusted.splashscreens.SplashScreenVersion;
import com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy;
import com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask;
import java.util.Objects;
public class PwaWrapperSplashScreenStrategy implements SplashScreenStrategy {
    public static c n = new c();
    public final Activity a;
    @DrawableRes
    public final int b;
    @ColorInt
    public final int c;
    public final ImageView.ScaleType d;
    @Nullable
    public final Matrix e;
    public final String f;
    public final int g;
    @Nullable
    public Bitmap h;
    @Nullable
    public SplashImageTransferTask i;
    @Nullable
    public String j;
    public boolean k;
    public boolean l = false;
    @Nullable
    public Runnable m;

    public PwaWrapperSplashScreenStrategy(Activity activity, @DrawableRes int i2, @ColorInt int i3, ImageView.ScaleType scaleType, @Nullable Matrix matrix, int i4, String str) {
        this.b = i2;
        this.c = i3;
        this.d = scaleType;
        this.e = matrix;
        this.a = activity;
        this.f = str;
        this.g = i4;
    }

    @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy
    public void configureTwaBuilder(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, CustomTabsSession customTabsSession, Runnable runnable) {
        if (!this.k || this.h == null) {
            runnable.run();
        } else if (TextUtils.isEmpty(this.f)) {
            runnable.run();
        } else {
            SplashImageTransferTask splashImageTransferTask = new SplashImageTransferTask(this.a, this.h, this.f, customTabsSession, this.j);
            this.i = splashImageTransferTask;
            splashImageTransferTask.execute(new SplashImageTransferTask.Callback(trustedWebActivityIntentBuilder, runnable) { // from class: a2.j.c.a.h.a
                public final /* synthetic */ TrustedWebActivityIntentBuilder b;
                public final /* synthetic */ Runnable c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashImageTransferTask.Callback
                public final void onFinished(boolean z) {
                    PwaWrapperSplashScreenStrategy pwaWrapperSplashScreenStrategy = PwaWrapperSplashScreenStrategy.this;
                    TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder2 = this.b;
                    Runnable runnable2 = this.c;
                    Objects.requireNonNull(pwaWrapperSplashScreenStrategy);
                    if (!z) {
                        runnable2.run();
                        return;
                    }
                    Bundle y1 = a2.b.a.a.a.y1(SplashScreenParamKey.KEY_VERSION, SplashScreenVersion.V1);
                    y1.putInt(SplashScreenParamKey.KEY_FADE_OUT_DURATION_MS, pwaWrapperSplashScreenStrategy.g);
                    y1.putInt(SplashScreenParamKey.KEY_BACKGROUND_COLOR, pwaWrapperSplashScreenStrategy.c);
                    y1.putInt(SplashScreenParamKey.KEY_SCALE_TYPE, pwaWrapperSplashScreenStrategy.d.ordinal());
                    Matrix matrix = pwaWrapperSplashScreenStrategy.e;
                    if (matrix != null) {
                        float[] fArr = new float[9];
                        matrix.getValues(fArr);
                        y1.putFloatArray(SplashScreenParamKey.KEY_IMAGE_TRANSFORMATION_MATRIX, fArr);
                    }
                    trustedWebActivityIntentBuilder2.setSplashScreenParams(y1);
                    b bVar = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: CONSTRUCTOR  (r6v3 'bVar' a2.j.c.a.h.b) = 
                          (r0v0 'pwaWrapperSplashScreenStrategy' com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy)
                          (r2v0 'runnable2' java.lang.Runnable)
                         call: a2.j.c.a.h.b.<init>(com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy, java.lang.Runnable):void type: CONSTRUCTOR in method: a2.j.c.a.h.a.onFinished(boolean):void, file: classes6.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:267)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.c.a.h.b, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                        	... 19 more
                        */
                    /*
                        this = this;
                        com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy r0 = com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy.this
                        androidx.browser.trusted.TrustedWebActivityIntentBuilder r1 = r5.b
                        java.lang.Runnable r2 = r5.c
                        java.util.Objects.requireNonNull(r0)
                        if (r6 != 0) goto L_0x000f
                        r2.run()
                        goto L_0x0052
                    L_0x000f:
                        java.lang.String r6 = "androidx.browser.trusted.KEY_SPLASH_SCREEN_VERSION"
                        java.lang.String r3 = "androidx.browser.trusted.category.TrustedWebActivitySplashScreensV1"
                        android.os.Bundle r6 = a2.b.a.a.a.y1(r6, r3)
                        int r3 = r0.g
                        java.lang.String r4 = "androidx.browser.trusted.KEY_SPLASH_SCREEN_FADE_OUT_DURATION"
                        r6.putInt(r4, r3)
                        int r3 = r0.c
                        java.lang.String r4 = "androidx.browser.trusted.trusted.KEY_SPLASH_SCREEN_BACKGROUND_COLOR"
                        r6.putInt(r4, r3)
                        android.widget.ImageView$ScaleType r3 = r0.d
                        int r3 = r3.ordinal()
                        java.lang.String r4 = "androidx.browser.trusted.KEY_SPLASH_SCREEN_SCALE_TYPE"
                        r6.putInt(r4, r3)
                        android.graphics.Matrix r3 = r0.e
                        if (r3 == 0) goto L_0x0040
                        r4 = 9
                        float[] r4 = new float[r4]
                        r3.getValues(r4)
                        java.lang.String r3 = "androidx.browser.trusted.KEY_SPLASH_SCREEN_TRANSFORMATION_MATRIX"
                        r6.putFloatArray(r3, r4)
                    L_0x0040:
                        r1.setSplashScreenParams(r6)
                        a2.j.c.a.h.b r6 = new a2.j.c.a.h.b
                        r6.<init>(r0, r2)
                        boolean r1 = r0.l
                        if (r1 == 0) goto L_0x0050
                        r6.run()
                        goto L_0x0052
                    L_0x0050:
                        r0.m = r6
                    L_0x0052:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: a2.j.c.a.h.a.onFinished(boolean):void");
                }
            });
        }
    }

    public void destroy() {
        SplashImageTransferTask splashImageTransferTask = this.i;
        if (splashImageTransferTask != null) {
            splashImageTransferTask.cancel();
        }
    }

    public void onActivityEnterAnimationComplete() {
        this.l = true;
        Runnable runnable = this.m;
        if (runnable != null) {
            runnable.run();
            this.m = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTwaLaunchInitiated(java.lang.String r7, androidx.browser.trusted.TrustedWebActivityIntentBuilder r8) {
        /*
            r6 = this;
            r6.j = r7
            android.app.Activity r0 = r6.a
            java.lang.String r1 = "androidx.browser.trusted.category.TrustedWebActivitySplashScreensV1"
            boolean r0 = androidx.browser.customtabs.TrustedWebUtils.areSplashScreensSupported(r0, r7, r1)
            r6.k = r0
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            android.app.Activity r0 = r6.a
            int r1 = r6.b
            android.graphics.Bitmap r0 = com.google.androidbrowserhelper.trusted.Utils.convertDrawableToBitmap(r0, r1)
            r6.h = r0
            r1 = -1
            if (r0 != 0) goto L_0x001d
            goto L_0x004b
        L_0x001d:
            android.widget.ImageView r0 = new android.widget.ImageView
            android.app.Activity r2 = r6.a
            r0.<init>(r2)
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            r2.<init>(r1, r1)
            r0.setLayoutParams(r2)
            android.graphics.Bitmap r2 = r6.h
            r0.setImageBitmap(r2)
            int r2 = r6.c
            r0.setBackgroundColor(r2)
            android.widget.ImageView$ScaleType r2 = r6.d
            r0.setScaleType(r2)
            android.widget.ImageView$ScaleType r2 = r6.d
            android.widget.ImageView$ScaleType r3 = android.widget.ImageView.ScaleType.MATRIX
            if (r2 != r3) goto L_0x0046
            android.graphics.Matrix r2 = r6.e
            r0.setImageMatrix(r2)
        L_0x0046:
            android.app.Activity r2 = r6.a
            r2.setContentView(r0)
        L_0x004b:
            android.graphics.Bitmap r0 = r6.h
            if (r0 == 0) goto L_0x00db
            a2.j.c.a.h.c r0 = com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy.n
            android.app.Activity r2 = r6.a
            java.util.Objects.requireNonNull(r0)
            androidx.browser.customtabs.CustomTabsIntent r3 = r8.buildCustomTabsIntent()
            android.content.Intent r3 = r3.intent
            a2.j.c.a.h.c$b r4 = r0.b(r2, r7)
            boolean r4 = r4.a
            r5 = 0
            if (r4 == 0) goto L_0x0088
            a2.j.c.a.h.c$b r0 = r0.b(r2, r7)
            boolean r0 = r0.b
            if (r0 == 0) goto L_0x0078
            int r0 = a2.j.c.a.h.c.a(r2, r8)
            androidx.browser.customtabs.CustomTabColorSchemeParams r0 = androidx.browser.customtabs.CustomTabsIntent.getColorSchemeParams(r3, r0)
            java.lang.Integer r0 = r0.navigationBarColor
            goto L_0x0094
        L_0x0078:
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x007f
            goto L_0x0093
        L_0x007f:
            java.lang.String r1 = "androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR"
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0094
        L_0x0088:
            boolean r0 = com.google.androidbrowserhelper.trusted.ChromeLegacyUtils.usesWhiteNavbar(r7)
            if (r0 == 0) goto L_0x0093
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            goto L_0x0094
        L_0x0093:
            r0 = r5
        L_0x0094:
            if (r0 == 0) goto L_0x009f
            android.app.Activity r1 = r6.a
            int r0 = r0.intValue()
            com.google.androidbrowserhelper.trusted.Utils.setNavigationBarColor(r1, r0)
        L_0x009f:
            a2.j.c.a.h.c r0 = com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy.n
            android.app.Activity r1 = r6.a
            java.util.Objects.requireNonNull(r0)
            androidx.browser.customtabs.CustomTabsIntent r2 = r8.buildCustomTabsIntent()
            android.content.Intent r2 = r2.intent
            a2.j.c.a.h.c$b r7 = r0.b(r1, r7)
            boolean r7 = r7.b
            if (r7 == 0) goto L_0x00bf
            int r7 = a2.j.c.a.h.c.a(r1, r8)
            androidx.browser.customtabs.CustomTabColorSchemeParams r7 = androidx.browser.customtabs.CustomTabsIntent.getColorSchemeParams(r2, r7)
            java.lang.Integer r7 = r7.toolbarColor
            goto L_0x00d0
        L_0x00bf:
            android.os.Bundle r7 = r2.getExtras()
            if (r7 != 0) goto L_0x00c6
            goto L_0x00cf
        L_0x00c6:
            java.lang.String r8 = "android.support.customtabs.extra.TOOLBAR_COLOR"
            java.lang.Object r7 = r7.get(r8)
            r5 = r7
            java.lang.Integer r5 = (java.lang.Integer) r5
        L_0x00cf:
            r7 = r5
        L_0x00d0:
            if (r7 == 0) goto L_0x00db
            android.app.Activity r8 = r6.a
            int r7 = r7.intValue()
            com.google.androidbrowserhelper.trusted.Utils.setStatusBarColor(r8, r7)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.androidbrowserhelper.trusted.splashscreens.PwaWrapperSplashScreenStrategy.onTwaLaunchInitiated(java.lang.String, androidx.browser.trusted.TrustedWebActivityIntentBuilder):void");
    }
}
