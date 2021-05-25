package xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW;

import a2.b.a.a.a;
import com.google.gson.Gson;
import com.sumsub.sns.core.ValueProvider;
import com.sumsub.sns.core.common.SNSSession;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import timber.log.Timber;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.AyZhE6NYuOjRPjA;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.IXGaYizhe6FCHn8nw5EAC9h8U1;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.YuBMj5oYSZ1EKs0piMUZxDCY;
import xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.mrIBiYc0Jm;
public final class BYfFGQyI88 {
    public int Cwa7EHp4RmMFhwpOCPWojiqbo;
    public final SNSSession J3eZRYS4AnxhOKbC2x2nQNPT;
    public final ValueProvider<String> Ku863HM4m4Edc3Ql5I;
    public final String N434VQHTrGUotPhpDDIhYJrpL4ro;
    public final Gson TISdV9vjEDKYTeuQpV0VHpJbW;
    public final C0699BYfFGQyI88 aDBqOnRnCJ0gWECtZQu = new C0699BYfFGQyI88(this);
    public boolean ejVYvrSYmsA1fCSIPxDrI;
    public VVeXCTyov0hLti0HOLqom2taL0gk lk42nG4RRcMiHe8r6w;
    public WebSocket oVTxbCNkVuXyP468Xhsl9qtSE9v;
    public final OkHttpClient yr0oPNYrJWblwzfs6tPicPv;

    /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$BYfFGQyI88  reason: collision with other inner class name */
    public static final class C0699BYfFGQyI88 extends WebSocketListener {
        public final /* synthetic */ BYfFGQyI88 Cwa7EHp4RmMFhwpOCPWojiqbo;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C0699BYfFGQyI88(BYfFGQyI88 bYfFGQyI88) {
            this.Cwa7EHp4RmMFhwpOCPWojiqbo = bYfFGQyI88;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(@NotNull WebSocket webSocket, int i, @NotNull String str) {
            Timber.d("Liveness3dFaceRepository.onClosed: code=" + i + " reason=" + str, new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
            kotlin.io.CloseableKt.closeFinally(r5, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
            throw r4;
         */
        @Override // okhttp3.WebSocketListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onClosing(@org.jetbrains.annotations.NotNull okhttp3.WebSocket r3, int r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
            /*
                r2 = this;
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "Liveness3dFaceRepository.onClosing: code="
                r3.append(r0)
                r3.append(r4)
                java.lang.String r0 = " reason="
                r3.append(r0)
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                r5 = 0
                java.lang.Object[] r0 = new java.lang.Object[r5]
                timber.log.Timber.d(r3, r0)
                r3 = 1
                r0 = 4001(0xfa1, float:5.607E-42)
                if (r4 != r0) goto L_0x007a
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 r4 = r2.Cwa7EHp4RmMFhwpOCPWojiqbo
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$VVeXCTyov0hLti0HOLqom2taL0gk r4 = r4.lk42nG4RRcMiHe8r6w
                if (r4 == 0) goto L_0x002f
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$UGPkPVVOmk179tTX8sQoOodQt$DDdm1ec8RQad6rlXcC8U r0 = xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88.UGPkPVVOmk179tTX8sQoOodQt.DDdm1ec8RQad6rlXcC8U.Cwa7EHp4RmMFhwpOCPWojiqbo
                r4.Cwa7EHp4RmMFhwpOCPWojiqbo(r0)
            L_0x002f:
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 r4 = r2.Cwa7EHp4RmMFhwpOCPWojiqbo
                r4.getClass()
                java.lang.Object[] r0 = new java.lang.Object[r5]
                java.lang.String r1 = "Liveness3dFaceRepository.updateToken"
                timber.log.Timber.d(r1, r0)
                int r0 = r4.Cwa7EHp4RmMFhwpOCPWojiqbo
                int r0 = r0 + r3
                r4.Cwa7EHp4RmMFhwpOCPWojiqbo = r0
                r1 = 3
                if (r0 <= r1) goto L_0x005e
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.String r5 = "Liveness3dFaceRepository. Max reconnect attempts reached"
                timber.log.Timber.d(r5, r3)
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$VVeXCTyov0hLti0HOLqom2taL0gk r3 = r4.lk42nG4RRcMiHe8r6w
                if (r3 == 0) goto L_0x007e
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$UGPkPVVOmk179tTX8sQoOodQt$BYfFGQyI88 r4 = new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$UGPkPVVOmk179tTX8sQoOodQt$BYfFGQyI88
                java.lang.Exception r5 = new java.lang.Exception
                java.lang.String r0 = "Invalid access token"
                r5.<init>(r0)
                r4.<init>(r5)
                r3.Cwa7EHp4RmMFhwpOCPWojiqbo(r4)
                goto L_0x007e
            L_0x005e:
                java.util.concurrent.ExecutorService r5 = java.util.concurrent.Executors.newSingleThreadExecutor()
                kotlinx.coroutines.ExecutorCoroutineDispatcher r5 = kotlinx.coroutines.ExecutorsKt.from(r5)
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.alNh9hLeM39 r0 = new xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.alNh9hLeM39     // Catch:{ all -> 0x0073 }
                r1 = 0
                r0.<init>(r1, r4)     // Catch:{ all -> 0x0073 }
                kotlinx.coroutines.BuildersKt.runBlocking$default(r1, r0, r3, r1)     // Catch:{ all -> 0x0073 }
                kotlin.io.CloseableKt.closeFinally(r5, r1)
                goto L_0x007e
            L_0x0073:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x0075 }
            L_0x0075:
                r4 = move-exception
                kotlin.io.CloseableKt.closeFinally(r5, r3)
                throw r4
            L_0x007a:
                xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88 r4 = r2.Cwa7EHp4RmMFhwpOCPWojiqbo
                r4.ejVYvrSYmsA1fCSIPxDrI = r3
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88.C0699BYfFGQyI88.onClosing(okhttp3.WebSocket, int, java.lang.String):void");
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable th, @Nullable Response response) {
            if (!this.Cwa7EHp4RmMFhwpOCPWojiqbo.ejVYvrSYmsA1fCSIPxDrI) {
                Timber.d("Liveness3dFaceRepository.onFailure: e=" + th + ' ', new Object[0]);
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = this.Cwa7EHp4RmMFhwpOCPWojiqbo.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.C0700BYfFGQyI88(th));
                }
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(@NotNull WebSocket webSocket, @NotNull String str) {
            mrIBiYc0Jm mribiyc0jm = (mrIBiYc0Jm) this.Cwa7EHp4RmMFhwpOCPWojiqbo.TISdV9vjEDKYTeuQpV0VHpJbW.fromJson(str, (Class<Object>) mrIBiYc0Jm.class);
            int ordinal = IXGaYizhe6FCHn8nw5EAC9h8U1.mdHgHuGChkRJqBUMUk707.Cwa7EHp4RmMFhwpOCPWojiqbo(mribiyc0jm.aDBqOnRnCJ0gWECtZQu()).ordinal();
            if (ordinal == 3) {
                BYfFGQyI88 bYfFGQyI88 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
                bYfFGQyI88.Cwa7EHp4RmMFhwpOCPWojiqbo = 0;
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = bYfFGQyI88.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.mrIBiYc0Jm(mribiyc0jm.lk42nG4RRcMiHe8r6w()));
                }
            } else if (ordinal == 4) {
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk2 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk2 != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk2.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.alNh9hLeM39(mribiyc0jm.lk42nG4RRcMiHe8r6w()));
                }
            } else if (ordinal == 5) {
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk3 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk3 != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk3.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.C0701UGPkPVVOmk179tTX8sQoOodQt(mribiyc0jm.lk42nG4RRcMiHe8r6w()));
                }
            } else if (ordinal != 6) {
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk4 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk4 != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk4.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.IXGaYizhe6FCHn8nw5EAC9h8U1(str));
                }
            } else {
                VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk5 = this.Cwa7EHp4RmMFhwpOCPWojiqbo.lk42nG4RRcMiHe8r6w;
                if (vVeXCTyov0hLti0HOLqom2taL0gk5 != null) {
                    vVeXCTyov0hLti0HOLqom2taL0gk5.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.AyZhE6NYuOjRPjA(mribiyc0jm.lk42nG4RRcMiHe8r6w()));
                }
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
            BYfFGQyI88 bYfFGQyI88 = this.Cwa7EHp4RmMFhwpOCPWojiqbo;
            bYfFGQyI88.ejVYvrSYmsA1fCSIPxDrI = false;
            bYfFGQyI88.Cwa7EHp4RmMFhwpOCPWojiqbo(AyZhE6NYuOjRPjA.oVTxbCNkVuXyP468Xhsl9qtSE9v(bYfFGQyI88.N434VQHTrGUotPhpDDIhYJrpL4ro));
        }
    }

    public static abstract class UGPkPVVOmk179tTX8sQoOodQt {

        public static final class AyZhE6NYuOjRPjA extends UGPkPVVOmk179tTX8sQoOodQt {
            @Nullable
            public final YuBMj5oYSZ1EKs0piMUZxDCY Cwa7EHp4RmMFhwpOCPWojiqbo;

            public AyZhE6NYuOjRPjA(@Nullable YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = yuBMj5oYSZ1EKs0piMUZxDCY;
            }
        }

        /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$UGPkPVVOmk179tTX8sQoOodQt$BYfFGQyI88  reason: collision with other inner class name */
        public static final class C0700BYfFGQyI88 extends UGPkPVVOmk179tTX8sQoOodQt {
            @NotNull
            public final Throwable Cwa7EHp4RmMFhwpOCPWojiqbo;

            public C0700BYfFGQyI88(@NotNull Throwable th) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = th;
            }
        }

        public static final class DDdm1ec8RQad6rlXcC8U extends UGPkPVVOmk179tTX8sQoOodQt {
            @NotNull
            public static final DDdm1ec8RQad6rlXcC8U Cwa7EHp4RmMFhwpOCPWojiqbo = new DDdm1ec8RQad6rlXcC8U();

            public DDdm1ec8RQad6rlXcC8U() {
                super(null);
            }
        }

        public static final class IXGaYizhe6FCHn8nw5EAC9h8U1 extends UGPkPVVOmk179tTX8sQoOodQt {
            public IXGaYizhe6FCHn8nw5EAC9h8U1(@Nullable String str) {
                super(null);
            }
        }

        /* renamed from: xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.xwKerWrNChj.gdcOxAjdMGzsOAELfUBjSW.BYfFGQyI88$UGPkPVVOmk179tTX8sQoOodQt$UGPkPVVOmk179tTX8sQoOodQt  reason: collision with other inner class name */
        public static final class C0701UGPkPVVOmk179tTX8sQoOodQt extends UGPkPVVOmk179tTX8sQoOodQt {
            public C0701UGPkPVVOmk179tTX8sQoOodQt(@Nullable YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
                super(null);
            }
        }

        public static final class VVeXCTyov0hLti0HOLqom2taL0gk extends UGPkPVVOmk179tTX8sQoOodQt {
            @NotNull
            public static final VVeXCTyov0hLti0HOLqom2taL0gk Cwa7EHp4RmMFhwpOCPWojiqbo = new VVeXCTyov0hLti0HOLqom2taL0gk();

            public VVeXCTyov0hLti0HOLqom2taL0gk() {
                super(null);
            }
        }

        public static final class alNh9hLeM39 extends UGPkPVVOmk179tTX8sQoOodQt {
            @Nullable
            public final YuBMj5oYSZ1EKs0piMUZxDCY Cwa7EHp4RmMFhwpOCPWojiqbo;

            public alNh9hLeM39(@Nullable YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = yuBMj5oYSZ1EKs0piMUZxDCY;
            }
        }

        public static final class mrIBiYc0Jm extends UGPkPVVOmk179tTX8sQoOodQt {
            @Nullable
            public final YuBMj5oYSZ1EKs0piMUZxDCY Cwa7EHp4RmMFhwpOCPWojiqbo;

            public mrIBiYc0Jm(@Nullable YuBMj5oYSZ1EKs0piMUZxDCY yuBMj5oYSZ1EKs0piMUZxDCY) {
                super(null);
                this.Cwa7EHp4RmMFhwpOCPWojiqbo = yuBMj5oYSZ1EKs0piMUZxDCY;
            }
        }

        public UGPkPVVOmk179tTX8sQoOodQt() {
        }

        public /* synthetic */ UGPkPVVOmk179tTX8sQoOodQt(j jVar) {
            this();
        }
    }

    public interface VVeXCTyov0hLti0HOLqom2taL0gk {
        void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull UGPkPVVOmk179tTX8sQoOodQt uGPkPVVOmk179tTX8sQoOodQt);
    }

    public BYfFGQyI88(@NotNull OkHttpClient okHttpClient, @NotNull String str, @NotNull SNSSession sNSSession, @NotNull Gson gson, @NotNull ValueProvider<String> valueProvider) {
        this.yr0oPNYrJWblwzfs6tPicPv = okHttpClient;
        this.N434VQHTrGUotPhpDDIhYJrpL4ro = str;
        this.J3eZRYS4AnxhOKbC2x2nQNPT = sNSSession;
        this.TISdV9vjEDKYTeuQpV0VHpJbW = gson;
        this.Ku863HM4m4Edc3Ql5I = valueProvider;
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo(@NotNull mrIBiYc0Jm mribiyc0jm) {
        StringBuilder L = a.L("Liveness3dFaceRepository.send: ");
        L.append(mribiyc0jm.aDBqOnRnCJ0gWECtZQu());
        L.append(" isClosed=");
        L.append(this.ejVYvrSYmsA1fCSIPxDrI);
        Timber.d(L.toString(), new Object[0]);
        if (!this.ejVYvrSYmsA1fCSIPxDrI) {
            WebSocket webSocket = this.oVTxbCNkVuXyP468Xhsl9qtSE9v;
            if (webSocket != null) {
                webSocket.send(this.TISdV9vjEDKYTeuQpV0VHpJbW.toJson(mribiyc0jm));
                return;
            }
            VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = this.lk42nG4RRcMiHe8r6w;
            if (vVeXCTyov0hLti0HOLqom2taL0gk != null) {
                vVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo(UGPkPVVOmk179tTX8sQoOodQt.VVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo);
            }
        }
    }

    public final void Cwa7EHp4RmMFhwpOCPWojiqbo() {
        try {
            Timber.d("Liveness3dFaceRepository.newWebSocket", new Object[0]);
            WebSocket webSocket = this.oVTxbCNkVuXyP468Xhsl9qtSE9v;
            if (webSocket != null) {
                webSocket.close(1000, "reconnect");
            }
            this.oVTxbCNkVuXyP468Xhsl9qtSE9v = null;
            Request.Builder builder = new Request.Builder();
            this.oVTxbCNkVuXyP468Xhsl9qtSE9v = this.yr0oPNYrJWblwzfs6tPicPv.newWebSocket(builder.url(this.J3eZRYS4AnxhOKbC2x2nQNPT.getUrl() + "ws/liveness?token=" + this.J3eZRYS4AnxhOKbC2x2nQNPT.getAccessToken()).build(), this.aDBqOnRnCJ0gWECtZQu);
        } catch (Exception e) {
            VVeXCTyov0hLti0HOLqom2taL0gk vVeXCTyov0hLti0HOLqom2taL0gk = this.lk42nG4RRcMiHe8r6w;
            if (vVeXCTyov0hLti0HOLqom2taL0gk != null) {
                vVeXCTyov0hLti0HOLqom2taL0gk.Cwa7EHp4RmMFhwpOCPWojiqbo(new UGPkPVVOmk179tTX8sQoOodQt.C0700BYfFGQyI88(e));
            }
        }
    }
}
