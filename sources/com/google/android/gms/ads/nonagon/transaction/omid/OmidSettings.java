package com.google.android.gms.ads.nonagon.transaction.omid;

import androidx.annotation.Nullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import org.json.JSONObject;
public class OmidSettings {
    private final JSONObject zzhcg;

    public OmidSettings(JSONObject jSONObject) {
        this.zzhcg = jSONObject;
    }

    public OmidMediaType getMediaType() {
        int optInt = this.zzhcg.optInt(MessengerShareContentUtility.MEDIA_TYPE, -1);
        if (optInt == 0) {
            return OmidMediaType.DISPLAY;
        }
        if (optInt != 1) {
            return OmidMediaType.UNKNOWN;
        }
        return OmidMediaType.VIDEO;
    }

    @Nullable
    public String getVideoEventsOwner() {
        if (zza.zzhcf[getMediaType().ordinal()] != 1) {
            return "javascript";
        }
        return null;
    }
}
