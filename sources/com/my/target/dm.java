package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.ProfileTab;
import com.my.target.common.models.AudioData;
import com.my.target.common.models.ShareButtonData;
import org.json.JSONArray;
import org.json.JSONObject;
public class dm {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final dn d;
    public boolean e = true;

    public dm(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = dn.c(bpVar, aVar, context);
    }

    public static dm b(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dm(bpVar, aVar, context);
    }

    public boolean a(@NonNull JSONObject jSONObject, @NonNull cf<AudioData> cfVar) {
        this.d.a(jSONObject, cfVar);
        this.e = cfVar.isLogErrors();
        if (cfVar.getType().equals("statistics")) {
            d(jSONObject, cfVar);
            return true;
        }
        float optDouble = (float) jSONObject.optDouble("duration", 0.0d);
        if (optDouble <= 0.0f) {
            c("Required field", "unable to set duration " + optDouble, cfVar.getId());
            return false;
        }
        cfVar.setAutoPlay(jSONObject.optBoolean("autoplay", cfVar.isAutoPlay()));
        cfVar.setHasCtaButton(jSONObject.optBoolean("hasCtaButton", cfVar.isHasCtaButton()));
        cfVar.setAdText(jSONObject.optString("adText", cfVar.getAdText()));
        d(jSONObject, cfVar);
        Boolean bg = this.a.bg();
        cfVar.setAllowClose(bg != null ? bg.booleanValue() : jSONObject.optBoolean("allowClose", cfVar.isAllowClose()));
        Boolean bi = this.a.bi();
        cfVar.setAllowSeek(bi != null ? bi.booleanValue() : jSONObject.optBoolean("allowSeek", cfVar.isAllowSeek()));
        Boolean bj = this.a.bj();
        cfVar.setAllowSkip(bj != null ? bj.booleanValue() : jSONObject.optBoolean("allowSkip", cfVar.isAllowSkip()));
        Boolean bk = this.a.bk();
        cfVar.setAllowTrackChange(bk != null ? bk.booleanValue() : jSONObject.optBoolean("allowTrackChange", cfVar.isAllowTrackChange()));
        Boolean bh = this.a.bh();
        cfVar.setAllowPause(bh != null ? bh.booleanValue() : jSONObject.optBoolean("hasPause", cfVar.isAllowPause()));
        Boolean bo = this.a.bo();
        cfVar.setAllowReplay(bo != null ? bo.booleanValue() : jSONObject.optBoolean("allowReplay", cfVar.isAllowReplay()));
        float allowCloseDelay = this.a.getAllowCloseDelay();
        if (allowCloseDelay < 0.0f) {
            allowCloseDelay = (float) jSONObject.optDouble("allowCloseDelay", (double) cfVar.getAllowCloseDelay());
        }
        cfVar.setAllowCloseDelay(allowCloseDelay);
        JSONArray optJSONArray = jSONObject.optJSONArray("companionAds");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    String id = cfVar.getId();
                    bz newBanner = bz.newBanner();
                    this.d.a(optJSONObject, newBanner);
                    if (newBanner.getWidth() == 0 || newBanner.getHeight() == 0) {
                        StringBuilder L = a.L("Unable to add companion banner with width ");
                        L.append(newBanner.getWidth());
                        L.append(" and height ");
                        L.append(newBanner.getHeight());
                        c("Required field", L.toString(), id);
                        newBanner = null;
                    } else {
                        newBanner.setAssetWidth(optJSONObject.optInt("assetWidth"));
                        newBanner.setAssetHeight(optJSONObject.optInt("assetHeight"));
                        newBanner.setExpandedWidth(optJSONObject.optInt("expandedWidth"));
                        newBanner.setExpandedHeight(optJSONObject.optInt("expandedHeight"));
                        newBanner.setStaticResource(optJSONObject.optString("staticResource"));
                        newBanner.setIframeResource(optJSONObject.optString("iframeResource"));
                        newBanner.setHtmlResource(optJSONObject.optString("htmlResource"));
                        newBanner.setApiFramework(optJSONObject.optString("apiFramework"));
                        newBanner.setAdSlotID(optJSONObject.optString("adSlotID"));
                        String optString = optJSONObject.optString("required");
                        if (!TextUtils.isEmpty(optString)) {
                            if (ProfileTab.ALL.equals(optString) || "any".equals(optString) || "none".equals(optString)) {
                                newBanner.setRequired(optString);
                            } else {
                                c("Bad value", "Wrong companion required attribute:" + optString, id);
                            }
                        }
                    }
                    if (newBanner != null) {
                        cfVar.addCompanion(newBanner);
                    }
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("shareButtons");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    ShareButtonData newData = ShareButtonData.newData();
                    newData.setName(optJSONObject2.optString("name"));
                    newData.setUrl(optJSONObject2.optString("url"));
                    newData.setImageUrl(optJSONObject2.optString("imageUrl"));
                    cfVar.addShareButtonData(newData);
                }
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("mediafiles");
        if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
            ae.a("mediafiles array is empty");
        } else {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i3);
                if (optJSONObject3 != null) {
                    String optString2 = optJSONObject3.optString("src");
                    if (!TextUtils.isEmpty(optString2)) {
                        AudioData newAudioData = AudioData.newAudioData(optString2);
                        newAudioData.setBitrate(optJSONObject3.optInt("bitrate"));
                        cfVar.setMediaData(newAudioData);
                        return true;
                    }
                    c("Bad value", a.c3("bad mediafile object, src = ", optString2), cfVar.getId());
                }
            }
        }
        return false;
    }

    public final void c(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        if (this.e) {
            dh.M(str).N(str2).v(this.b.getSlotId()).P(str3).O(this.a.getUrl()).v(this.c);
        }
    }

    public final void d(@NonNull JSONObject jSONObject, @NonNull cf<AudioData> cfVar) {
        float point = this.a.getPoint();
        if (point < 0.0f && jSONObject.has("point")) {
            point = (float) jSONObject.optDouble("point");
            if (point < 0.0f) {
                c("Bad value", "Wrong value " + point + " for point", cfVar.getId());
            }
        }
        float pointP = this.a.getPointP();
        if (pointP < 0.0f && jSONObject.has("pointP")) {
            pointP = (float) jSONObject.optDouble("pointP");
            if (pointP < 0.0f) {
                c("Bad value", "Wrong value " + pointP + " for pointP", cfVar.getId());
            }
        }
        if (point < 0.0f && pointP < 0.0f) {
            point = -1.0f;
            pointP = 50.0f;
        }
        cfVar.setPoint(point);
        cfVar.setPointP(pointP);
    }
}
