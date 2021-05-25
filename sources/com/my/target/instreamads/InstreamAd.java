package com.my.target.instreamads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.at;
import com.my.target.cf;
import com.my.target.cn;
import com.my.target.co;
import com.my.target.common.BaseAd;
import com.my.target.common.models.VideoData;
import com.my.target.cr;
import com.my.target.f;
import com.my.target.fl;
import com.my.target.id;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public final class InstreamAd extends BaseAd {
    @NonNull
    public final Context b;
    @Nullable
    public co c;
    @Nullable
    public at d;
    @Nullable
    public InstreamAdPlayer e;
    @Nullable
    public InstreamAdListener f;
    public int g = 10;
    public boolean h;
    @Nullable
    public float[] i;
    @Nullable
    public float[] j;
    public float k;
    public float l = 1.0f;

    public static final class InstreamAdBanner {
        public final boolean allowClose;
        public final float allowCloseDelay;
        public final boolean allowPause;
        @Nullable
        public final String ctaText;
        public final float duration;
        @NonNull
        public final String id;
        public final int videoHeight;
        public final int videoWidth;

        public InstreamAdBanner(@NonNull String str, boolean z, float f, float f2, int i, int i2, @Nullable String str2, boolean z2) {
            this.id = str;
            this.allowClose = z;
            this.allowCloseDelay = f;
            this.duration = f2;
            this.videoHeight = i2;
            this.videoWidth = i;
            this.ctaText = str2;
            this.allowPause = z2;
        }

        @NonNull
        public static InstreamAdBanner newBanner(@NonNull cf cfVar) {
            return new InstreamAdBanner(cfVar.getId(), cfVar.isAllowClose(), cfVar.getAllowCloseDelay(), cfVar.getDuration(), cfVar.getWidth(), cfVar.getHeight(), cfVar.getCtaText(), cfVar.isAllowPause());
        }
    }

    public interface InstreamAdListener {
        void onBannerComplete(@NonNull InstreamAd instreamAd, @NonNull InstreamAdBanner instreamAdBanner);

        void onBannerPause(@NonNull InstreamAd instreamAd, @NonNull InstreamAdBanner instreamAdBanner);

        void onBannerResume(@NonNull InstreamAd instreamAd, @NonNull InstreamAdBanner instreamAdBanner);

        void onBannerStart(@NonNull InstreamAd instreamAd, @NonNull InstreamAdBanner instreamAdBanner);

        void onBannerTimeLeftChange(float f, float f2, @NonNull InstreamAd instreamAd);

        void onComplete(@NonNull String str, @NonNull InstreamAd instreamAd);

        void onError(@NonNull String str, @NonNull InstreamAd instreamAd);

        void onLoad(@NonNull InstreamAd instreamAd);

        void onNoAd(@NonNull String str, @NonNull InstreamAd instreamAd);
    }

    public class a implements f.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            co coVar = (co) cnVar;
            InstreamAd instreamAd = InstreamAd.this;
            if (instreamAd.f == null) {
                return;
            }
            if (coVar == null || !coVar.bT()) {
                InstreamAdListener instreamAdListener = instreamAd.f;
                if (str == null) {
                    str = "no ad";
                }
                instreamAdListener.onNoAd(str, instreamAd);
                return;
            }
            instreamAd.c = coVar;
            at a3 = at.a(instreamAd, coVar, instreamAd.adConfig);
            instreamAd.d = a3;
            a3.e(instreamAd.g);
            instreamAd.d.setVolume(instreamAd.l);
            InstreamAdPlayer instreamAdPlayer = instreamAd.e;
            if (instreamAdPlayer != null) {
                instreamAd.d.setPlayer(instreamAdPlayer);
            }
            instreamAd.configureMidpoints(instreamAd.k, instreamAd.j);
            instreamAd.f.onLoad(instreamAd);
        }
    }

    public InstreamAd(int i2, @NonNull Context context) {
        super(i2, "instreamads");
        this.b = context;
        ae.c("InstreamAd created. Version: 5.12.2");
    }

    public final void a(@NonNull String str) {
        at atVar = this.d;
        if (atVar == null) {
            ae.a("Unable to start ad: not loaded yet");
        } else if (atVar.getPlayer() == null) {
            ae.a("Unable to start ad: player has not set");
        } else {
            this.d.start(str);
        }
    }

    public void configureMidpoints(float f2) {
        configureMidpoints(f2, null);
    }

    public void configureMidpoints(float f2, @Nullable float[] fArr) {
        cr<VideoData> v;
        String str;
        if (f2 <= 0.0f) {
            str = "midpoints are not configured, duration is not set or <= zero";
        } else if (this.i != null) {
            str = "midpoints already configured";
        } else {
            this.j = fArr;
            this.k = f2;
            co coVar = this.c;
            if (coVar != null && (v = coVar.v(AdBreak.BreakId.MIDROLL)) != null) {
                float[] a3 = id.a(v, this.j, f2);
                this.i = a3;
                at atVar = this.d;
                if (atVar != null) {
                    atVar.a(a3);
                    return;
                }
                return;
            }
            return;
        }
        ae.a(str);
    }

    public void configureMidpointsPercents(float f2, @Nullable float[] fArr) {
        if (fArr == null) {
            configureMidpoints(f2);
        } else {
            configureMidpoints(f2, id.a(f2, fArr));
        }
    }

    public void destroy() {
        this.f = null;
        at atVar = this.d;
        if (atVar != null) {
            atVar.destroy();
        }
    }

    @Nullable
    public InstreamAdListener getListener() {
        return this.f;
    }

    public int getLoadingTimeout() {
        return this.g;
    }

    @NonNull
    public float[] getMidPoints() {
        float[] fArr = this.i;
        return fArr == null ? new float[0] : (float[]) fArr.clone();
    }

    @Nullable
    public InstreamAdPlayer getPlayer() {
        return this.e;
    }

    public int getVideoQuality() {
        return this.adConfig.getVideoQuality();
    }

    @NonNull
    public List<String> getVideoSectionNames() {
        if (this.c == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<cr<VideoData>> bS = this.c.bS();
        if (bS.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        Iterator<cr<VideoData>> it = bS.iterator();
        while (it.hasNext()) {
            cr<VideoData> next = it.next();
            if (next.getBannersCount() > 0 || next.ce()) {
                arrayList.add(next.getName());
            }
        }
        return arrayList;
    }

    public float getVolume() {
        at atVar = this.d;
        return atVar != null ? atVar.getVolume() : this.l;
    }

    public void handleClick() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.handleClick();
        }
    }

    public boolean isFullscreen() {
        return this.h;
    }

    public void load() {
        if (isLoadCalled()) {
            ae.a("InstreamAd doesn't support multiple load");
        } else {
            f.a(this.adConfig, this.g).a(new a()).a(this.b);
        }
    }

    public void pause() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.pause();
        }
    }

    public void resume() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.resume();
        }
    }

    public void setFullscreen(boolean z) {
        this.h = z;
        at atVar = this.d;
        if (atVar != null) {
            atVar.setFullscreen(z);
        }
    }

    public void setListener(@Nullable InstreamAdListener instreamAdListener) {
        this.f = instreamAdListener;
    }

    public void setLoadingTimeout(int i2) {
        if (i2 < 5) {
            ae.a("unable to set ad loading timeout < 5, set to 5 seconds");
            this.g = 5;
        } else {
            ae.a("ad loading timeout set to " + i2 + " seconds");
            this.g = i2;
        }
        at atVar = this.d;
        if (atVar != null) {
            atVar.e(this.g);
        }
    }

    public void setPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        this.e = instreamAdPlayer;
        at atVar = this.d;
        if (atVar != null) {
            atVar.setPlayer(instreamAdPlayer);
        }
    }

    public void setVideoQuality(int i2) {
        this.adConfig.setVideoQuality(i2);
    }

    public void setVolume(float f2) {
        if (Float.compare(f2, 0.0f) < 0 || Float.compare(f2, 1.0f) > 0) {
            ae.a("unable to set volume" + f2 + ", volume must be in range [0..1]");
            return;
        }
        this.l = f2;
        at atVar = this.d;
        if (atVar != null) {
            atVar.setVolume(f2);
        }
    }

    public void skip() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.skip();
        }
    }

    public void skipBanner() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.skipBanner();
        }
    }

    public void startMidroll(float f2) {
        at atVar = this.d;
        if (atVar == null) {
            ae.a("Unable to start ad: not loaded yet");
        } else if (atVar.getPlayer() == null) {
            ae.a("Unable to start ad: player has not set");
        } else {
            this.d.startMidroll(f2);
        }
    }

    public void startPauseroll() {
        a(AdBreak.BreakId.PAUSEROLL);
    }

    public void startPostroll() {
        a(AdBreak.BreakId.POSTROLL);
    }

    public void startPreroll() {
        a(AdBreak.BreakId.PREROLL);
    }

    public void stop() {
        at atVar = this.d;
        if (atVar != null) {
            atVar.stop();
        }
    }

    public void swapPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        this.e = instreamAdPlayer;
        at atVar = this.d;
        if (atVar != null) {
            atVar.swapPlayer(instreamAdPlayer);
        }
    }

    public void useDefaultPlayer() {
        setPlayer(new fl(this.b));
    }
}
