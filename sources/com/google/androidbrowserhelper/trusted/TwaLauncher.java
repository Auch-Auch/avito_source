package com.google.androidbrowserhelper.trusted;

import a2.j.c.a.c;
import a2.j.c.a.d;
import a2.j.c.a.e;
import a2.j.c.a.f;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.trusted.Token;
import androidx.browser.trusted.TokenStore;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.core.content.ContextCompat;
import com.google.androidbrowserhelper.trusted.TwaLauncher;
import com.google.androidbrowserhelper.trusted.TwaProviderPicker;
import com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy;
public class TwaLauncher {
    public static final FallbackStrategy CCT_FALLBACK_STRATEGY = c.a;
    public static final FallbackStrategy WEBVIEW_FALLBACK_STRATEGY = f.a;
    public final Context a;
    @Nullable
    public final String b;
    public final int c;
    public final int d;
    @Nullable
    public b e;
    @Nullable
    public CustomTabsSession f;
    public TokenStore g;
    public boolean h;

    public interface FallbackStrategy {
        void launch(Context context, TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable String str, @Nullable Runnable runnable);
    }

    public class b extends CustomTabsServiceConnection {
        public Runnable b;
        public Runnable c;

        public b(a aVar) {
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Runnable runnable;
            Runnable runnable2;
            if (!ChromeLegacyUtils.supportsLaunchWithoutWarmup(TwaLauncher.this.a.getPackageManager(), TwaLauncher.this.b)) {
                customTabsClient.warmup(0);
            }
            TwaLauncher twaLauncher = TwaLauncher.this;
            twaLauncher.f = customTabsClient.newSession(null, twaLauncher.d);
            CustomTabsSession customTabsSession = TwaLauncher.this.f;
            if (customTabsSession != null && (runnable2 = this.b) != null) {
                runnable2.run();
            } else if (customTabsSession == null && (runnable = this.c) != null) {
                runnable.run();
            }
            this.b = null;
            this.c = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            TwaLauncher.this.f = null;
        }
    }

    public TwaLauncher(Context context) {
        this(context, null);
    }

    public final void a(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable Runnable runnable) {
        CustomTabsSession customTabsSession;
        if (!this.h && (customTabsSession = this.f) != null) {
            Intent intent = trustedWebActivityIntentBuilder.build(customTabsSession).getIntent();
            FocusActivity.addToIntent(intent, this.a);
            ContextCompat.startActivity(this.a, intent, null);
            this.g.store(Token.create(this.b, this.a.getPackageManager()));
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void destroy() {
        if (!this.h) {
            b bVar = this.e;
            if (bVar != null) {
                this.a.unbindService(bVar);
            }
            this.h = true;
        }
    }

    @Nullable
    public String getProviderPackage() {
        return this.b;
    }

    public void launch(Uri uri) {
        launch(new TrustedWebActivityIntentBuilder(uri), null, null);
    }

    public TwaLauncher(Context context, @Nullable String str) {
        this(context, str, 96375, new SharedPreferencesTokenStore(context));
    }

    public void launch(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable SplashScreenStrategy splashScreenStrategy, @Nullable Runnable runnable, FallbackStrategy fallbackStrategy) {
        if (this.h) {
            throw new IllegalStateException("TwaLauncher already destroyed");
        } else if (this.c == 0) {
            if (splashScreenStrategy != null) {
                splashScreenStrategy.onTwaLaunchInitiated(this.b, trustedWebActivityIntentBuilder);
            }
            d dVar = new Runnable(trustedWebActivityIntentBuilder, splashScreenStrategy, runnable) { // from class: a2.j.c.a.d
                public final /* synthetic */ TrustedWebActivityIntentBuilder b;
                public final /* synthetic */ SplashScreenStrategy c;
                public final /* synthetic */ Runnable d;

                {
                    this.b = r2;
                    this.c = r3;
                    this.d = r4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    TwaLauncher twaLauncher = TwaLauncher.this;
                    TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder2 = this.b;
                    SplashScreenStrategy splashScreenStrategy2 = this.c;
                    Runnable runnable2 = this.d;
                    CustomTabsSession customTabsSession = twaLauncher.f;
                    if (customTabsSession == null) {
                        throw new IllegalStateException("mSession is null in launchWhenSessionEstablished");
                    } else if (splashScreenStrategy2 != null) {
                        splashScreenStrategy2.configureTwaBuilder(trustedWebActivityIntentBuilder2, customTabsSession, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: INVOKE  
                              (r2v0 'splashScreenStrategy2' com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy)
                              (r1v0 'trustedWebActivityIntentBuilder2' androidx.browser.trusted.TrustedWebActivityIntentBuilder)
                              (r4v0 'customTabsSession' androidx.browser.customtabs.CustomTabsSession)
                              (wrap: a2.j.c.a.b : 0x0010: CONSTRUCTOR  (r5v0 a2.j.c.a.b) = 
                              (r0v0 'twaLauncher' com.google.androidbrowserhelper.trusted.TwaLauncher)
                              (r1v0 'trustedWebActivityIntentBuilder2' androidx.browser.trusted.TrustedWebActivityIntentBuilder)
                              (r3v0 'runnable2' java.lang.Runnable)
                             call: a2.j.c.a.b.<init>(com.google.androidbrowserhelper.trusted.TwaLauncher, androidx.browser.trusted.TrustedWebActivityIntentBuilder, java.lang.Runnable):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy.configureTwaBuilder(androidx.browser.trusted.TrustedWebActivityIntentBuilder, androidx.browser.customtabs.CustomTabsSession, java.lang.Runnable):void in method: a2.j.c.a.d.run():void, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:245)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:104)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:169)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:146)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r5v0 a2.j.c.a.b) = 
                              (r0v0 'twaLauncher' com.google.androidbrowserhelper.trusted.TwaLauncher)
                              (r1v0 'trustedWebActivityIntentBuilder2' androidx.browser.trusted.TrustedWebActivityIntentBuilder)
                              (r3v0 'runnable2' java.lang.Runnable)
                             call: a2.j.c.a.b.<init>(com.google.androidbrowserhelper.trusted.TwaLauncher, androidx.browser.trusted.TrustedWebActivityIntentBuilder, java.lang.Runnable):void type: CONSTRUCTOR in method: a2.j.c.a.d.run():void, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:780)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:394)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
                            	... 23 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: a2.j.c.a.b, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
                            	... 29 more
                            */
                        /*
                            this = this;
                            com.google.androidbrowserhelper.trusted.TwaLauncher r0 = com.google.androidbrowserhelper.trusted.TwaLauncher.this
                            androidx.browser.trusted.TrustedWebActivityIntentBuilder r1 = r6.b
                            com.google.androidbrowserhelper.trusted.splashscreens.SplashScreenStrategy r2 = r6.c
                            java.lang.Runnable r3 = r6.d
                            androidx.browser.customtabs.CustomTabsSession r4 = r0.f
                            if (r4 == 0) goto L_0x001b
                            if (r2 == 0) goto L_0x0017
                            a2.j.c.a.b r5 = new a2.j.c.a.b
                            r5.<init>(r0, r1, r3)
                            r2.configureTwaBuilder(r1, r4, r5)
                            goto L_0x001a
                        L_0x0017:
                            r0.a(r1, r3)
                        L_0x001a:
                            return
                        L_0x001b:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "mSession is null in launchWhenSessionEstablished"
                            r0.<init>(r1)
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: a2.j.c.a.d.run():void");
                    }
                };
                if (this.f != null) {
                    dVar.run();
                    return;
                }
                e eVar = new Runnable(fallbackStrategy, trustedWebActivityIntentBuilder, runnable) { // from class: a2.j.c.a.e
                    public final /* synthetic */ TwaLauncher.FallbackStrategy b;
                    public final /* synthetic */ TrustedWebActivityIntentBuilder c;
                    public final /* synthetic */ Runnable d;

                    {
                        this.b = r2;
                        this.c = r3;
                        this.d = r4;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        TwaLauncher twaLauncher = TwaLauncher.this;
                        this.b.launch(twaLauncher.a, this.c, twaLauncher.b, this.d);
                    }
                };
                if (this.e == null) {
                    this.e = new b(null);
                }
                b bVar = this.e;
                bVar.b = dVar;
                bVar.c = eVar;
                CustomTabsClient.bindCustomTabsService(this.a, this.b, bVar);
            } else {
                fallbackStrategy.launch(this.a, trustedWebActivityIntentBuilder, this.b, runnable);
            }
        }

        public TwaLauncher(Context context, @Nullable String str, int i, TokenStore tokenStore) {
            this.a = context;
            this.d = i;
            this.g = tokenStore;
            if (str == null) {
                TwaProviderPicker.Action pickProvider = TwaProviderPicker.pickProvider(context.getPackageManager());
                this.b = pickProvider.provider;
                this.c = pickProvider.launchMode;
                return;
            }
            this.b = str;
            this.c = 0;
        }

        public void launch(TrustedWebActivityIntentBuilder trustedWebActivityIntentBuilder, @Nullable SplashScreenStrategy splashScreenStrategy, @Nullable Runnable runnable) {
            launch(trustedWebActivityIntentBuilder, splashScreenStrategy, runnable, CCT_FALLBACK_STRATEGY);
        }
    }
