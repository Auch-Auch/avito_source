package com.voximplant.sdk.internal.proto;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
public class M_refreshOauthTokenSuccessful extends WSMessageAuth {
    public final Map<String, Object> a() {
        return (Map) ((Map) this.params.get(0)).get("OAuth");
    }

    public int getAccessExpire() {
        return ((Double) a().get("accessExpire")).intValue();
    }

    public String getAccessToken() {
        return (String) a().get(SDKConstants.PARAM_ACCESS_TOKEN);
    }

    public int getRefreshExpire() {
        return ((Double) a().get("refreshExpire")).intValue();
    }

    public String getRefreshToken() {
        return (String) a().get("refreshToken");
    }
}
