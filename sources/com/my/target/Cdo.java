package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.my.target.do  reason: invalid class name */
public class Cdo {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final dn d;
    @Nullable
    public String e;
    public boolean f = true;

    public Cdo(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = dn.c(bpVar, aVar, context);
    }

    @NonNull
    public static Cdo d(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new Cdo(bpVar, aVar, context);
    }

    public boolean a(@NonNull JSONObject jSONObject, @NonNull cf<VideoData> cfVar) {
        VideoData chooseBest;
        this.d.a(jSONObject, cfVar);
        this.f = cfVar.isLogErrors();
        if ("statistics".equals(cfVar.getType())) {
            b(jSONObject, cfVar);
            return true;
        }
        this.e = cfVar.getId();
        float duration = cfVar.getDuration();
        if (duration <= 0.0f) {
            c("Bad value", "wrong videoBanner duration " + duration);
            return false;
        }
        cfVar.setCloseActionText(jSONObject.optString("closeActionText", "Close"));
        cfVar.setReplayActionText(jSONObject.optString("replayActionText", cfVar.getReplayActionText()));
        cfVar.setCloseDelayActionText(jSONObject.optString("closeDelayActionText", cfVar.getCloseDelayActionText()));
        cfVar.setAutoMute(jSONObject.optBoolean("automute", cfVar.isAutoMute()));
        cfVar.setShowPlayerControls(jSONObject.optBoolean("showPlayerControls", cfVar.isShowPlayerControls()));
        cfVar.setAutoPlay(jSONObject.optBoolean("autoplay", cfVar.isAutoPlay()));
        cfVar.setHasCtaButton(jSONObject.optBoolean("hasCtaButton", cfVar.isHasCtaButton()));
        b(jSONObject, cfVar);
        Boolean bg = this.a.bg();
        cfVar.setAllowClose(bg != null ? bg.booleanValue() : jSONObject.optBoolean("allowClose", cfVar.isAllowClose()));
        Boolean bh = this.a.bh();
        cfVar.setAllowPause(bh != null ? bh.booleanValue() : jSONObject.optBoolean("hasPause", cfVar.isAllowPause()));
        Boolean bo = this.a.bo();
        cfVar.setAllowReplay(bo != null ? bo.booleanValue() : jSONObject.optBoolean("allowReplay", cfVar.isAllowReplay()));
        float allowCloseDelay = this.a.getAllowCloseDelay();
        if (allowCloseDelay < 0.0f) {
            allowCloseDelay = (float) jSONObject.optDouble("allowCloseDelay", (double) cfVar.getAllowCloseDelay());
        }
        cfVar.setAllowCloseDelay(allowCloseDelay);
        String optString = jSONObject.optString("previewLink");
        if (!TextUtils.isEmpty(optString)) {
            cfVar.setPreview(ImageData.newImageData(optString, jSONObject.optInt("previewWidth"), jSONObject.optInt("previewHeight")));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("mediafiles");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ae.a("mediafiles array is empty");
            c("Required field", "unable to find mediaFiles in MediaBanner");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString2 = optJSONObject.optString("src");
                int optInt = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                int optInt2 = optJSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                VideoData videoData = null;
                if (TextUtils.isEmpty(optString2) || optInt <= 0 || optInt2 <= 0) {
                    StringBuilder S = a.S("bad mediafile object, src = ", optString2, ", width = ", optInt, ", height = ");
                    S.append(optInt2);
                    c("Bad value", S.toString());
                } else {
                    VideoData newVideoData = VideoData.newVideoData(optString2, optInt, optInt2);
                    newVideoData.setBitrate(optJSONObject.optInt("bitrate"));
                    if (!newVideoData.getUrl().endsWith(VideoData.M3U8) || id.eG()) {
                        videoData = newVideoData;
                    } else {
                        ae.a("HLS Video does not supported, add com.google.android.exoplayer:exoplayer-hls dependency to play HLS video ");
                    }
                }
                if (videoData != null) {
                    arrayList.add(videoData);
                }
            }
        }
        if (arrayList.size() <= 0 || (chooseBest = VideoData.chooseBest(arrayList, this.b.getVideoQuality())) == null) {
            return false;
        }
        cfVar.setMediaData(chooseBest);
        return true;
    }

    public final void b(@NonNull JSONObject jSONObject, @NonNull cf<VideoData> cfVar) {
        float point = this.a.getPoint();
        if (point < 0.0f && jSONObject.has("point")) {
            point = (float) jSONObject.optDouble("point");
            if (point < 0.0f) {
                c("Bad value", "Wrong value " + point + " for point");
            }
        }
        float pointP = this.a.getPointP();
        if (pointP < 0.0f && jSONObject.has("pointP")) {
            pointP = (float) jSONObject.optDouble("pointP");
            if (pointP < 0.0f) {
                c("Bad value", "Wrong value " + pointP + " for pointP");
            }
        }
        if (point < 0.0f && pointP < 0.0f) {
            point = -1.0f;
            pointP = 50.0f;
        }
        cfVar.setPoint(point);
        cfVar.setPointP(pointP);
    }

    public final void c(@NonNull String str, @NonNull String str2) {
        if (this.f) {
            dh.M(str).N(str2).v(this.b.getSlotId()).P(this.e).O(this.a.getUrl()).v(this.c);
        }
    }
}
