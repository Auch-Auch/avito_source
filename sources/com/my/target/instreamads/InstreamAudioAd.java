package com.my.target.instreamads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.au;
import com.my.target.bz;
import com.my.target.cf;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.common.models.AudioData;
import com.my.target.common.models.ShareButtonData;
import com.my.target.cp;
import com.my.target.cr;
import com.my.target.i;
import com.my.target.id;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public final class InstreamAudioAd extends BaseAd {
    @NonNull
    public final Context b;
    @Nullable
    public cp c;
    @Nullable
    public au d;
    @Nullable
    public InstreamAudioAdPlayer e;
    @Nullable
    public InstreamAudioAdListener f;
    public int g = 10;
    public float h = 1.0f;
    @Nullable
    public float[] i;
    @Nullable
    public float[] j;
    public float k;

    public static final class InstreamAdCompanionBanner {
        @Nullable
        public final String adSlotID;
        @Nullable
        public final String apiFramework;
        public final int assetHeight;
        public final int assetWidth;
        public final int expandedHeight;
        public final int expandedWidth;
        public final int height;
        @Nullable
        public final String htmlResource;
        @Nullable
        public final String iframeResource;
        public final boolean isClickable;
        @Nullable
        public final String required;
        @Nullable
        public final String staticResource;
        public final int width;

        public InstreamAdCompanionBanner(int i, int i2, int i3, int i4, int i5, int i6, boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.width = i;
            this.height = i2;
            this.assetWidth = i3;
            this.assetHeight = i4;
            this.expandedWidth = i5;
            this.expandedHeight = i6;
            this.isClickable = z;
            this.staticResource = str;
            this.iframeResource = str2;
            this.htmlResource = str3;
            this.apiFramework = str4;
            this.adSlotID = str5;
            this.required = str6;
        }

        @NonNull
        public static InstreamAdCompanionBanner newBanner(@NonNull bz bzVar) {
            return new InstreamAdCompanionBanner(bzVar.getWidth(), bzVar.getHeight(), bzVar.getAssetWidth(), bzVar.getAssetHeight(), bzVar.getExpandedWidth(), bzVar.getExpandedHeight(), !TextUtils.isEmpty(bzVar.getTrackingLink()), bzVar.getStaticResource(), bzVar.getIframeResource(), bzVar.getHtmlResource(), bzVar.getApiFramework(), bzVar.getAdSlotID(), bzVar.getRequired());
        }
    }

    public static final class InstreamAudioAdBanner {
        @Nullable
        public final String adText;
        public final boolean allowPause;
        public final boolean allowSeek;
        public final boolean allowSkip;
        public final boolean allowTrackChange;
        @NonNull
        public final List<InstreamAdCompanionBanner> companionBanners;
        public final float duration;
        @NonNull
        public final ArrayList<ShareButtonData> shareButtonDatas;

        public InstreamAudioAdBanner(boolean z, boolean z2, boolean z3, float f, @Nullable String str, boolean z4, @NonNull ArrayList<ShareButtonData> arrayList, @NonNull List<InstreamAdCompanionBanner> list) {
            this.allowSeek = z;
            this.allowSkip = z2;
            this.allowPause = z4;
            this.allowTrackChange = z3;
            this.duration = f;
            this.adText = str;
            this.shareButtonDatas = arrayList;
            this.companionBanners = list;
        }

        @NonNull
        public static InstreamAudioAdBanner newBanner(@NonNull cf<AudioData> cfVar) {
            ArrayList arrayList = new ArrayList();
            Iterator<bz> it = cfVar.getCompanionBanners().iterator();
            while (it.hasNext()) {
                arrayList.add(InstreamAdCompanionBanner.newBanner(it.next()));
            }
            return new InstreamAudioAdBanner(cfVar.isAllowSeek(), cfVar.isAllowSkip(), cfVar.isAllowTrackChange(), cfVar.getDuration(), cfVar.getAdText(), cfVar.isAllowPause(), cfVar.getShareButtonDatas(), arrayList);
        }
    }

    public interface InstreamAudioAdListener {
        void onBannerComplete(@NonNull InstreamAudioAd instreamAudioAd, @NonNull InstreamAudioAdBanner instreamAudioAdBanner);

        void onBannerStart(@NonNull InstreamAudioAd instreamAudioAd, @NonNull InstreamAudioAdBanner instreamAudioAdBanner);

        void onBannerTimeLeftChange(float f, float f2, @NonNull InstreamAudioAd instreamAudioAd);

        void onComplete(@NonNull String str, @NonNull InstreamAudioAd instreamAudioAd);

        void onError(@NonNull String str, @NonNull InstreamAudioAd instreamAudioAd);

        void onLoad(@NonNull InstreamAudioAd instreamAudioAd);

        void onNoAd(@NonNull String str, @NonNull InstreamAudioAd instreamAudioAd);
    }

    public class a implements i.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            cp cpVar = (cp) cnVar;
            InstreamAudioAd instreamAudioAd = InstreamAudioAd.this;
            if (instreamAudioAd.f == null) {
                return;
            }
            if (cpVar == null || !cpVar.bT()) {
                InstreamAudioAdListener instreamAudioAdListener = instreamAudioAd.f;
                if (str == null) {
                    str = "no ad";
                }
                instreamAudioAdListener.onNoAd(str, instreamAudioAd);
                return;
            }
            instreamAudioAd.c = cpVar;
            au a3 = au.a(instreamAudioAd, cpVar, instreamAudioAd.adConfig);
            instreamAudioAd.d = a3;
            a3.e(instreamAudioAd.g);
            instreamAudioAd.d.setVolume(instreamAudioAd.h);
            InstreamAudioAdPlayer instreamAudioAdPlayer = instreamAudioAd.e;
            if (instreamAudioAdPlayer != null) {
                instreamAudioAd.d.setPlayer(instreamAudioAdPlayer);
            }
            instreamAudioAd.configureMidpoints(instreamAudioAd.k, instreamAudioAd.j);
            instreamAudioAd.f.onLoad(instreamAudioAd);
        }
    }

    public InstreamAudioAd(int i2, @NonNull Context context) {
        super(i2, "instreamaudioads");
        this.b = context;
        ae.c("InstreamAudioAd created. Version: 5.12.2");
    }

    public final void a(@NonNull String str) {
        au auVar = this.d;
        if (auVar == null) {
            ae.a("Unable to start ad: not loaded yet");
        } else if (auVar.getPlayer() == null) {
            ae.a("Unable to start ad: player has not set");
        } else {
            this.d.start(str);
        }
    }

    public void configureMidpoints(float f2) {
        configureMidpoints(f2, null);
    }

    public void configureMidpoints(float f2, @Nullable float[] fArr) {
        cr<AudioData> w;
        String str;
        if (f2 <= 0.0f) {
            str = "midpoints are not configured, duration is not set or <= zero";
        } else if (this.i != null) {
            str = "midpoints already configured";
        } else {
            this.j = fArr;
            this.k = f2;
            cp cpVar = this.c;
            if (cpVar != null && (w = cpVar.w(AdBreak.BreakId.MIDROLL)) != null) {
                float[] a3 = id.a(w, this.j, f2);
                this.i = a3;
                au auVar = this.d;
                if (auVar != null) {
                    auVar.a(a3);
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
        au auVar = this.d;
        if (auVar != null) {
            auVar.destroy();
        }
    }

    @Nullable
    public InstreamAudioAdBanner getCurrentBanner() {
        au auVar = this.d;
        if (auVar != null) {
            return auVar.getCurrentBanner();
        }
        return null;
    }

    @Nullable
    public InstreamAudioAdListener getListener() {
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
    public InstreamAudioAdPlayer getPlayer() {
        return this.e;
    }

    public float getVolume() {
        au auVar = this.d;
        return auVar != null ? auVar.getVolume() : this.h;
    }

    public void handleCompanionClick(@NonNull InstreamAdCompanionBanner instreamAdCompanionBanner) {
        au auVar = this.d;
        if (auVar != null) {
            auVar.handleCompanionClick(instreamAdCompanionBanner);
        }
    }

    public void handleCompanionClick(@NonNull InstreamAdCompanionBanner instreamAdCompanionBanner, @NonNull Context context) {
        au auVar = this.d;
        if (auVar != null) {
            auVar.handleCompanionClick(instreamAdCompanionBanner, context);
        }
    }

    public void handleCompanionShow(@NonNull InstreamAdCompanionBanner instreamAdCompanionBanner) {
        au auVar = this.d;
        if (auVar != null) {
            auVar.handleCompanionShow(instreamAdCompanionBanner);
        }
    }

    public void load() {
        if (isLoadCalled()) {
            ae.a("InstreamAudioAd doesn't support multiple load");
        } else {
            i.a(this.adConfig, this.g).a(new a()).a(this.b);
        }
    }

    public void pause() {
        au auVar = this.d;
        if (auVar != null) {
            auVar.pause();
        }
    }

    public void resume() {
        au auVar = this.d;
        if (auVar != null) {
            auVar.resume();
        }
    }

    public void setListener(@Nullable InstreamAudioAdListener instreamAudioAdListener) {
        this.f = instreamAudioAdListener;
    }

    public void setLoadingTimeout(int i2) {
        if (i2 < 5) {
            ae.a("unable to set ad loading timeout < 5, set to 5 seconds");
            this.g = 5;
        } else {
            ae.a("ad loading timeout set to " + i2 + " seconds");
            this.g = i2;
        }
        au auVar = this.d;
        if (auVar != null) {
            auVar.e(this.g);
        }
    }

    public void setPlayer(@Nullable InstreamAudioAdPlayer instreamAudioAdPlayer) {
        this.e = instreamAudioAdPlayer;
        au auVar = this.d;
        if (auVar != null) {
            auVar.setPlayer(instreamAudioAdPlayer);
        }
    }

    public void setVolume(float f2) {
        if (Float.compare(f2, 0.0f) < 0 || Float.compare(f2, 1.0f) > 0) {
            ae.a("unable to set volume" + f2 + ", volume must be in range [0..1]");
            return;
        }
        this.h = f2;
        au auVar = this.d;
        if (auVar != null) {
            auVar.setVolume(f2);
        }
    }

    public void skip() {
        au auVar = this.d;
        if (auVar != null) {
            auVar.skip();
        }
    }

    public void skipBanner() {
        au auVar = this.d;
        if (auVar != null) {
            auVar.skipBanner();
        }
    }

    public void startMidroll(float f2) {
        au auVar = this.d;
        if (auVar == null) {
            ae.a("Unable to start ad: not loaded yet");
        } else if (auVar.getPlayer() == null) {
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
        au auVar = this.d;
        if (auVar != null) {
            auVar.stop();
        }
    }
}
