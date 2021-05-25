package com.my.target;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.my.target.instreamads.InstreamAdPlayer;
public class aj {
    @NonNull
    public final b a = new b(null);
    @NonNull
    public final ik b = ik.J(200);
    @NonNull
    public final d c = new d(null);
    @NonNull
    public final ii d = ii.eO();
    public float e = 1.0f;
    @Nullable
    public ir f;
    @Nullable
    public InstreamAdPlayer g;
    @Nullable
    public c h;
    @Nullable
    public cf<VideoData> i;
    public int j;
    public float k;
    public int l = 10;
    public boolean m;
    public int n = 0;

    public class b implements InstreamAdPlayer.AdPlayerListener {
        public float a = 1.0f;

        public b(a aVar) {
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoCompleted() {
            aj ajVar = aj.this;
            if (ajVar.n != 2) {
                if (!(ajVar.i == null || ajVar.h == null)) {
                    aj.b(ajVar);
                    aj ajVar2 = aj.this;
                    cf<VideoData> cfVar = ajVar2.i;
                    if (cfVar != null) {
                        ajVar2.c();
                        float duration = cfVar.getDuration();
                        aj.this.d.d(duration, duration);
                        aj.this.h.d(cfVar);
                    }
                }
                aj.this.n = 2;
            }
            aj ajVar3 = aj.this;
            ajVar3.b.e(ajVar3.c);
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoError(@NonNull String str) {
            c cVar;
            InstreamAdPlayer instreamAdPlayer = aj.this.g;
            if (instreamAdPlayer != null) {
                instreamAdPlayer.stopAdVideo();
            }
            aj ajVar = aj.this;
            cf<VideoData> cfVar = ajVar.i;
            if (!(cfVar == null || (cVar = ajVar.h) == null)) {
                cVar.a(str, cfVar);
            }
            aj.this.d.eS();
            aj ajVar2 = aj.this;
            ajVar2.b.e(ajVar2.c);
            aj.this.c();
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoPaused() {
            c cVar;
            aj.this.d.eP();
            aj ajVar = aj.this;
            ajVar.b.e(ajVar.c);
            aj ajVar2 = aj.this;
            cf<VideoData> cfVar = ajVar2.i;
            if (cfVar != null && (cVar = ajVar2.h) != null) {
                cVar.e(cfVar);
            }
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoResumed() {
            c cVar;
            aj.this.d.trackResume();
            aj ajVar = aj.this;
            ajVar.b.d(ajVar.c);
            aj ajVar2 = aj.this;
            cf<VideoData> cfVar = ajVar2.i;
            if (cfVar != null && (cVar = ajVar2.h) != null) {
                cVar.f(cfVar);
            }
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoStarted() {
            InstreamAdPlayer instreamAdPlayer;
            cf<VideoData> cfVar;
            c cVar;
            aj ajVar = aj.this;
            ajVar.n = 1;
            if (!ajVar.m && (instreamAdPlayer = ajVar.g) != null) {
                float adVideoDuration = instreamAdPlayer.getAdVideoDuration();
                cf<VideoData> cfVar2 = ajVar.i;
                if (!(cfVar2 == null || (cVar = ajVar.h) == null)) {
                    cVar.b(cfVar2);
                }
                c cVar2 = ajVar.h;
                if (!(cVar2 == null || (cfVar = ajVar.i) == null)) {
                    cVar2.a(adVideoDuration, adVideoDuration, cfVar);
                }
                ajVar.d.d(0.0f, adVideoDuration);
                ajVar.m = true;
            }
            aj ajVar2 = aj.this;
            ajVar2.b.d(ajVar2.c);
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onAdVideoStopped() {
            aj ajVar = aj.this;
            if (ajVar.n == 1) {
                if (!(ajVar.i == null || ajVar.h == null)) {
                    ajVar.d.eQ();
                    aj ajVar2 = aj.this;
                    ajVar2.h.c(ajVar2.i);
                }
                aj.this.n = 0;
            }
            aj ajVar3 = aj.this;
            ajVar3.b.e(ajVar3.c);
        }

        @Override // com.my.target.instreamads.InstreamAdPlayer.AdPlayerListener
        public void onVolumeChanged(float f) {
            boolean z;
            ii iiVar;
            float f2 = this.a;
            if (f != f2) {
                int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i <= 0 || f > 0.0f) {
                    if (i == 0 && f > 0.0f && aj.this.getContext() != null) {
                        aj ajVar = aj.this;
                        if (ajVar.i != null) {
                            iiVar = ajVar.d;
                            z = true;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (aj.this.getContext() != null) {
                    aj ajVar2 = aj.this;
                    if (ajVar2.i != null) {
                        iiVar = ajVar2.d;
                        z = false;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                iiVar.P(z);
                this.a = f;
                aj.this.e = f;
            }
        }
    }

    public interface c {
        void a(float f, float f2, @NonNull cf cfVar);

        void a(@NonNull String str, @NonNull cf cfVar);

        void b(@NonNull cf cfVar);

        void c(@NonNull cf cfVar);

        void d(@NonNull cf cfVar);

        void e(@NonNull cf cfVar);

        void f(@NonNull cf cfVar);
    }

    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            aj.b(aj.this);
        }
    }

    public static void b(aj ajVar) {
        float f2;
        float f3;
        float f4;
        cf<VideoData> cfVar;
        c cVar;
        cf<VideoData> cfVar2;
        cf<VideoData> cfVar3;
        InstreamAdPlayer instreamAdPlayer;
        cf<VideoData> cfVar4 = ajVar.i;
        float duration = cfVar4 != null ? cfVar4.getDuration() : 0.0f;
        if (ajVar.i == null) {
            ajVar.b.e(ajVar.c);
            return;
        }
        if (ajVar.n != 1 || (instreamAdPlayer = ajVar.g) == null) {
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f4 = instreamAdPlayer.getAdVideoDuration();
            f3 = ajVar.g.getAdVideoPosition();
            f2 = duration - f3;
        }
        if (ajVar.n != 1 || ajVar.k == f3 || f4 <= 0.0f) {
            ajVar.j++;
        } else {
            ajVar.j = 0;
            ajVar.k = f3;
            if (f3 < duration) {
                ajVar.d.d(f3, duration);
                ir irVar = ajVar.f;
                if (irVar != null) {
                    irVar.p(f3);
                }
                c cVar2 = ajVar.h;
                if (!(cVar2 == null || (cfVar3 = ajVar.i) == null)) {
                    cVar2.a(f2, duration, cfVar3);
                }
            } else {
                ajVar.d.d(duration, duration);
                ajVar.k = duration;
                ir irVar2 = ajVar.f;
                if (irVar2 != null) {
                    irVar2.p(duration);
                }
                c cVar3 = ajVar.h;
                if (!(cVar3 == null || (cfVar2 = ajVar.i) == null)) {
                    cVar3.a(0.0f, duration, cfVar2);
                }
                ajVar.b.e(ajVar.c);
                if (ajVar.n != 2) {
                    ajVar.n = 2;
                    InstreamAdPlayer instreamAdPlayer2 = ajVar.g;
                    if (instreamAdPlayer2 != null) {
                        instreamAdPlayer2.stopAdVideo();
                    }
                    cf<VideoData> cfVar5 = ajVar.i;
                    ajVar.c();
                    if (!(cfVar5 == null || (cVar = ajVar.h) == null)) {
                        cVar.d(cfVar5);
                    }
                }
            }
        }
        if (ajVar.j >= (ajVar.l * 1000) / 200) {
            StringBuilder L = a2.b.a.a.a.L("video freeze more then ");
            L.append(ajVar.l);
            L.append(" seconds, stopping");
            ae.a(L.toString());
            InstreamAdPlayer instreamAdPlayer3 = ajVar.g;
            if (instreamAdPlayer3 != null) {
                instreamAdPlayer3.stopAdVideo();
            }
            ajVar.b.e(ajVar.c);
            ajVar.d.eT();
            c cVar4 = ajVar.h;
            if (!(cVar4 == null || (cfVar = ajVar.i) == null)) {
                cVar4.a("Timeout", cfVar);
            }
            ajVar.c();
        }
    }

    @NonNull
    public static aj u() {
        return new aj();
    }

    public void a(@Nullable c cVar) {
        this.h = cVar;
    }

    public void a(@NonNull cf<VideoData> cfVar) {
        this.i = cfVar;
        this.m = false;
        this.d.i(cfVar);
        ir c2 = ir.c(cfVar.getStatHolder());
        this.f = c2;
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            c2.setView(instreamAdPlayer.getView());
        }
        VideoData mediaData = cfVar.getMediaData();
        if (mediaData != null) {
            Uri parse = Uri.parse(mediaData.getUrl());
            InstreamAdPlayer instreamAdPlayer2 = this.g;
            if (instreamAdPlayer2 != null) {
                instreamAdPlayer2.setVolume(this.e);
                this.g.playAdVideo(parse, mediaData.getWidth(), mediaData.getHeight());
            }
        }
    }

    public final void c() {
        this.i = null;
        ir irVar = this.f;
        if (irVar != null) {
            irVar.destroy();
            this.f = null;
        }
    }

    public void destroy() {
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            instreamAdPlayer.destroy();
        }
        this.g = null;
        c();
    }

    @Nullable
    public Context getContext() {
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer == null) {
            return null;
        }
        return instreamAdPlayer.getView().getContext();
    }

    @Nullable
    public InstreamAdPlayer getPlayer() {
        return this.g;
    }

    public float getVolume() {
        return this.e;
    }

    public void pause() {
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            instreamAdPlayer.pauseAdVideo();
        }
    }

    public void resume() {
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            instreamAdPlayer.resumeAdVideo();
        }
    }

    public void setConnectionTimeout(int i2) {
        this.l = i2;
    }

    public void setPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        InstreamAdPlayer instreamAdPlayer2 = this.g;
        if (instreamAdPlayer2 != null) {
            instreamAdPlayer2.setAdPlayerListener(null);
        }
        this.g = instreamAdPlayer;
        if (instreamAdPlayer != null) {
            View view = instreamAdPlayer.getView();
            ir irVar = this.f;
            if (irVar != null) {
                irVar.setView(view);
            }
            instreamAdPlayer.setAdPlayerListener(this.a);
            this.d.setContext(view.getContext());
            return;
        }
        ir irVar2 = this.f;
        if (irVar2 != null) {
            irVar2.setView(null);
        }
        this.d.setContext(null);
    }

    public void setVolume(float f2) {
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            instreamAdPlayer.setVolume(f2);
        }
        this.e = f2;
    }

    public void stop() {
        if (this.n == 1) {
            if (!(this.i == null || this.h == null)) {
                this.d.eQ();
                this.h.c(this.i);
            }
            this.n = 0;
        }
        InstreamAdPlayer instreamAdPlayer = this.g;
        if (instreamAdPlayer != null) {
            instreamAdPlayer.stopAdVideo();
        }
        c();
    }

    public void swapPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        ii iiVar;
        VideoData mediaData;
        InstreamAdPlayer instreamAdPlayer2 = this.g;
        Context context = null;
        if (instreamAdPlayer2 != null) {
            instreamAdPlayer2.setAdPlayerListener(null);
            this.g.stopAdVideo();
        }
        this.g = instreamAdPlayer;
        ir irVar = this.f;
        if (instreamAdPlayer != null) {
            if (irVar != null) {
                irVar.setView(instreamAdPlayer.getView());
            }
            instreamAdPlayer.setAdPlayerListener(this.a);
            iiVar = this.d;
            context = instreamAdPlayer.getView().getContext();
        } else {
            if (irVar != null) {
                irVar.setView(null);
            }
            iiVar = this.d;
        }
        iiVar.setContext(context);
        cf<VideoData> cfVar = this.i;
        if (cfVar != null && (mediaData = cfVar.getMediaData()) != null) {
            Uri parse = Uri.parse(mediaData.getUrl());
            if (instreamAdPlayer != null) {
                instreamAdPlayer.setVolume(this.e);
                instreamAdPlayer.playAdVideo(parse, mediaData.getWidth(), mediaData.getHeight(), this.k);
            }
        }
    }
}
