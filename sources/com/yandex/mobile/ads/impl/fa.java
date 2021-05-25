package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.mobile.ads.impl.fc;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
public final class fa implements fh {
    private final ey a;
    private final ev b;
    private final fe c;
    private final fc d = new fc();
    @NonNull
    private fm e = fm.LOADING;
    @NonNull
    private final ff f;
    @NonNull
    private final fg g;
    @NonNull
    private final String h;
    @NonNull
    private final iw i = new iw();
    @Nullable
    private fd j;
    @Nullable
    private jl k;
    @Nullable
    private jk l;
    @Nullable
    private eu m;
    @Nullable
    private ej n;
    @Nullable
    private fi o;

    /* renamed from: com.yandex.mobile.ads.impl.fa$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            fb.values();
            int[] iArr = new int[8];
            a = iArr;
            try {
                fb fbVar = fb.CLOSE;
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = a;
                fb fbVar2 = fb.USE_CUSTOM_CLOSE;
                iArr2[6] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = a;
                fb fbVar3 = fb.OPEN;
                iArr3[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = a;
                fb fbVar4 = fb.AD_VIDEO_COMPLETE;
                iArr4[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = a;
                fb fbVar5 = fb.IMPRESSION_TRACKING_START;
                iArr5[1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = a;
                fb fbVar6 = fb.IMPRESSION_TRACKING_SUCCESS;
                iArr6[2] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = a;
                fb fbVar7 = fb.REWARDED_AD_COMPLETE;
                iArr7[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public class a implements eq {
        private a() {
        }

        @Override // com.yandex.mobile.ads.impl.eq
        public final void a(@NonNull Context context, @NonNull String str) {
            fa.this.b.a(context, str);
        }

        @Override // com.yandex.mobile.ads.impl.eq
        public final void d() {
            fa.this.b.d();
        }

        public /* synthetic */ a(fa faVar, byte b) {
            this();
        }
    }

    public fa(@NonNull ev evVar) {
        this.b = evVar;
        fe feVar = new fe(new a(this, (byte) 0));
        this.c = feVar;
        evVar.setWebViewClient(feVar);
        this.a = new ey(evVar);
        ff ffVar = new ff();
        this.f = ffVar;
        this.g = new fg(evVar, ffVar, this);
        this.h = dt.a(this);
    }

    private void b(@NonNull fi fiVar) {
        if (!fiVar.equals(this.o)) {
            this.o = fiVar;
            this.a.a(c(fiVar));
        }
    }

    @NonNull
    private static fj c(@NonNull fi fiVar) {
        return new fj(fiVar.a(), fiVar.b());
    }

    public final void a(@NonNull fd fdVar) {
        this.j = fdVar;
    }

    public final void a(@NonNull jl jlVar) {
        this.k = jlVar;
    }

    public final void a(@NonNull jk jkVar) {
        this.l = jkVar;
    }

    public final void a(@NonNull eu euVar) {
        this.m = euVar;
    }

    public final void c() {
        this.g.b();
        fc.a(this.b.getContext(), this.h);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    public final void a(@NonNull ej ejVar) {
        this.n = ejVar;
    }

    public final void b() {
        if (fm.DEFAULT == this.e) {
            a(fm.HIDDEN);
        }
    }

    public final void a(@NonNull final String str) {
        Context context = this.b.getContext();
        fc fcVar = this.d;
        String str2 = this.h;
        AnonymousClass1 r3 = new fc.a() { // from class: com.yandex.mobile.ads.impl.fa.1
            @Override // com.yandex.mobile.ads.impl.fc.a
            public final void a(@NonNull String str3) {
                fa.this.c.a(str3);
                fa.this.a.a(str);
            }
        };
        fz a3 = fy.a().a(context);
        if (a3 == null || TextUtils.isEmpty(a3.f())) {
            r3.a(fc.a);
            return;
        }
        sw swVar = new sw(a3.f(), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0034: CONSTRUCTOR  (r4v2 'swVar' com.yandex.mobile.ads.impl.sw) = 
              (wrap: java.lang.String : 0x0024: INVOKE  (r8v4 java.lang.String) = (r8v2 'a3' com.yandex.mobile.ads.impl.fz) type: VIRTUAL call: com.yandex.mobile.ads.impl.fz.f():java.lang.String)
              (wrap: com.yandex.mobile.ads.impl.fc$1 : 0x002c: CONSTRUCTOR  (r5v0 com.yandex.mobile.ads.impl.fc$1) = (r1v0 'fcVar' com.yandex.mobile.ads.impl.fc), (r3v0 'r3' com.yandex.mobile.ads.impl.fa$1) call: com.yandex.mobile.ads.impl.fc.1.<init>(com.yandex.mobile.ads.impl.fc, com.yandex.mobile.ads.impl.fc$a):void type: CONSTRUCTOR)
              (wrap: com.yandex.mobile.ads.impl.fc$2 : 0x0031: CONSTRUCTOR  (r6v0 com.yandex.mobile.ads.impl.fc$2) = (r1v0 'fcVar' com.yandex.mobile.ads.impl.fc), (r3v0 'r3' com.yandex.mobile.ads.impl.fa$1) call: com.yandex.mobile.ads.impl.fc.2.<init>(com.yandex.mobile.ads.impl.fc, com.yandex.mobile.ads.impl.fc$a):void type: CONSTRUCTOR)
             call: com.yandex.mobile.ads.impl.sw.<init>(java.lang.String, com.yandex.mobile.ads.impl.sa$b, com.yandex.mobile.ads.impl.sa$a):void type: CONSTRUCTOR in method: com.yandex.mobile.ads.impl.fa.a(java.lang.String):void, file: classes8.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002c: CONSTRUCTOR  (r5v0 com.yandex.mobile.ads.impl.fc$1) = (r1v0 'fcVar' com.yandex.mobile.ads.impl.fc), (r3v0 'r3' com.yandex.mobile.ads.impl.fa$1) call: com.yandex.mobile.ads.impl.fc.1.<init>(com.yandex.mobile.ads.impl.fc, com.yandex.mobile.ads.impl.fc$a):void type: CONSTRUCTOR in method: com.yandex.mobile.ads.impl.fa.a(java.lang.String):void, file: classes8.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:282)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:138)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:116)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:955)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:690)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:275)
            	... 19 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.yandex.mobile.ads.impl.fc, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:212)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:657)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:390)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:258)
            	... 25 more
            */
        /*
            this = this;
            com.yandex.mobile.ads.impl.ev r0 = r7.b
            android.content.Context r0 = r0.getContext()
            com.yandex.mobile.ads.impl.fc r1 = r7.d
            java.lang.String r2 = r7.h
            com.yandex.mobile.ads.impl.fa$1 r3 = new com.yandex.mobile.ads.impl.fa$1
            r3.<init>(r8)
            com.yandex.mobile.ads.impl.fy r8 = com.yandex.mobile.ads.impl.fy.a()
            com.yandex.mobile.ads.impl.fz r8 = r8.a(r0)
            if (r8 == 0) goto L_0x0042
            java.lang.String r4 = r8.f()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0024
            goto L_0x0042
        L_0x0024:
            java.lang.String r8 = r8.f()
            com.yandex.mobile.ads.impl.sw r4 = new com.yandex.mobile.ads.impl.sw
            com.yandex.mobile.ads.impl.fc$1 r5 = new com.yandex.mobile.ads.impl.fc$1
            r5.<init>(r3)
            com.yandex.mobile.ads.impl.fc$2 r6 = new com.yandex.mobile.ads.impl.fc$2
            r6.<init>(r3)
            r4.<init>(r8, r5, r6)
            r4.a(r2)
            com.yandex.mobile.ads.impl.ai r8 = com.yandex.mobile.ads.impl.ai.a()
            r8.a(r0, r4)
            return
        L_0x0042:
            java.lang.String r8 = com.yandex.mobile.ads.impl.fc.a
            r3.a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.fa.a(java.lang.String):void");
    }

    public final void b(String str) {
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if ("mraid".equals(scheme) || "mobileads".equals(scheme)) {
                HashMap hashMap = new HashMap();
                for (NameValuePair nameValuePair : URLEncodedUtils.parse(uri, "UTF-8")) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
                fb a3 = fb.a(host);
                try {
                    if (this.j != null) {
                        switch (AnonymousClass2.a[a3.ordinal()]) {
                            case 1:
                                if (fm.DEFAULT == this.e) {
                                    a(fm.HIDDEN);
                                    eu euVar = this.m;
                                    if (euVar != null) {
                                        euVar.h();
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                if (this.m != null) {
                                    this.m.a(Boolean.parseBoolean((String) hashMap.get("shouldUseCustomClose")));
                                    break;
                                }
                                break;
                            case 3:
                                if (this.j != null) {
                                    String str2 = (String) hashMap.get("url");
                                    if (!TextUtils.isEmpty(str2)) {
                                        this.j.a(str2);
                                        break;
                                    } else {
                                        throw new ez(String.format("Mraid open command sent an invalid URL: %s", str2));
                                    }
                                }
                                break;
                            case 4:
                                ej ejVar = this.n;
                                if (ejVar != null) {
                                    ejVar.a();
                                    break;
                                }
                                break;
                            case 5:
                                jk jkVar = this.l;
                                if (jkVar != null) {
                                    jkVar.b();
                                    break;
                                }
                                break;
                            case 6:
                                jk jkVar2 = this.l;
                                if (jkVar2 != null) {
                                    jkVar2.d_();
                                    break;
                                }
                                break;
                            case 7:
                                jl jlVar = this.k;
                                if (jlVar != null) {
                                    jlVar.i();
                                    break;
                                }
                                break;
                            default:
                                throw new ez("Unspecified MRAID Javascript command");
                        }
                        this.a.a(a3);
                        return;
                    }
                    throw new ez("Invalid state to execute this command");
                } catch (ez e2) {
                    this.a.a(a3, e2.getMessage());
                }
            }
        } catch (URISyntaxException unused) {
            this.a.a(fb.UNSPECIFIED, "Mraid command sent an invalid URL");
        }
    }

    public final void a() {
        fl flVar = new fl(this.b);
        fn fnVar = new fn(iw.a(this.b));
        fj c2 = c(ff.a(this.b));
        fm fmVar = fm.DEFAULT;
        this.e = fmVar;
        this.a.a(fmVar, fnVar, c2, flVar);
        this.a.a();
        fd fdVar = this.j;
        if (fdVar != null) {
            fdVar.a();
        }
    }

    public final void a(boolean z) {
        this.a.a(new fn(z));
        if (z) {
            this.g.a();
            return;
        }
        this.g.b();
        b(ff.a(this.b));
    }

    @Override // com.yandex.mobile.ads.impl.fh
    public final void a(@NonNull fi fiVar) {
        b(fiVar);
    }

    private void a(@NonNull fm fmVar) {
        this.e = fmVar;
        this.a.a(fmVar);
    }
}
