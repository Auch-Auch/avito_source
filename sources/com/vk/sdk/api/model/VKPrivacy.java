package com.vk.sdk.api.model;

import com.avito.android.remote.model.ProfileTab;
import org.json.JSONObject;
public class VKPrivacy {
    public static final int PRIVACY_ALL = 0;
    public static final int PRIVACY_FRIENDS = 1;
    public static final int PRIVACY_FRIENDS_OF_FRIENDS = 2;
    public static final int PRIVACY_NOBODY = 3;
    public static final int PRIVACY_UNKNOWN = 4;

    public static int parsePrivacy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        String optString = jSONObject.optString("type");
        if (ProfileTab.ALL.equals(optString)) {
            return 0;
        }
        if ("friends".equals(optString)) {
            return 1;
        }
        if ("friends_of_friends".equals(optString)) {
            return 2;
        }
        return "nobody".equals(optString) ? 3 : 4;
    }
}
