package com.vk.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vk.sdk.util.VKStringJoiner;
import com.vk.sdk.util.VKUtil;
import java.util.HashMap;
import java.util.Map;
public class VKAccessToken {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String CREATED = "created";
    public static final String EMAIL = "email";
    public static final String EXPIRES_IN = "expires_in";
    public static final String HTTPS_REQUIRED = "https_required";
    public static final String SCOPE = "scope";
    public static final String SECRET = "secret";
    public static final String SUCCESS = "success";
    public static final String USER_ID = "user_id";
    public static volatile VKAccessToken b;
    public Map<String, Boolean> a = null;
    public String accessToken = null;
    public long created = 0;
    public String email = null;
    public int expiresIn = 0;
    public boolean httpsRequired = false;
    public String secret = null;
    public String userId = null;

    public static VKAccessToken a(@NonNull Context context, @Nullable VKAccessToken vKAccessToken) {
        VKAccessToken vKAccessToken2 = b;
        b = vKAccessToken;
        if (b != null) {
            b.save();
        } else {
            removeTokenAtKey(context, "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
        }
        return vKAccessToken2;
    }

    public static VKAccessToken currentToken() {
        if (b == null) {
            synchronized (VKAccessToken.class) {
                if (b == null) {
                    b = tokenFromSharedPreferences(VKUIHelper.getApplicationContext(), "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
                }
            }
        }
        return b;
    }

    public static void removeTokenAtKey(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static VKAccessToken tokenFromFile(String str) {
        try {
            return tokenFromUrlString(VKUtil.fileToString(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static VKAccessToken tokenFromParameters(@Nullable Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        VKAccessToken vKAccessToken = new VKAccessToken();
        try {
            vKAccessToken.accessToken = map.get("access_token");
            vKAccessToken.userId = map.get("user_id");
            vKAccessToken.secret = map.get(SECRET);
            vKAccessToken.email = map.get("email");
            vKAccessToken.httpsRequired = false;
            if (map.get("expires_in") != null) {
                vKAccessToken.expiresIn = Integer.parseInt(map.get("expires_in"));
            }
            String str = map.get("scope");
            if (str != null) {
                HashMap hashMap = new HashMap();
                for (String str2 : str.split(",")) {
                    hashMap.put(str2, Boolean.TRUE);
                }
                vKAccessToken.a = hashMap;
            }
            if (map.containsKey(HTTPS_REQUIRED)) {
                vKAccessToken.httpsRequired = map.get(HTTPS_REQUIRED).equals("1");
            } else if (vKAccessToken.secret == null) {
                vKAccessToken.httpsRequired = true;
            }
            if (map.containsKey("created")) {
                vKAccessToken.created = Long.parseLong(map.get("created"));
            } else {
                vKAccessToken.created = System.currentTimeMillis();
            }
            if (vKAccessToken.accessToken != null) {
                return vKAccessToken;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static VKAccessToken tokenFromSharedPreferences(Context context, String str) {
        return tokenFromUrlString(PreferenceManager.getDefaultSharedPreferences(context).getString(str, null));
    }

    public static VKAccessToken tokenFromUrlString(String str) {
        if (str == null) {
            return null;
        }
        return tokenFromParameters(VKUtil.explodeQueryString(str));
    }

    public VKAccessToken copyWithToken(@NonNull VKAccessToken vKAccessToken) {
        Map<String, String> map = tokenParams();
        map.putAll(vKAccessToken.tokenParams());
        return tokenFromParameters(map);
    }

    public boolean hasScope(String... strArr) {
        for (String str : strArr) {
            if (this.a.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isExpired() {
        int i = this.expiresIn;
        return i > 0 && ((long) (i * 1000)) + this.created < System.currentTimeMillis();
    }

    public void save() {
        saveTokenToSharedPreferences(VKUIHelper.getApplicationContext(), "VK_SDK_ACCESS_TOKEN_PLEASE_DONT_TOUCH");
    }

    public void saveTokenToFile(String str) {
        VKUtil.stringToFile(str, serialize());
    }

    public void saveTokenToSharedPreferences(Context context, String str) {
        if (context != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString(str, serialize());
            edit.apply();
        }
    }

    public String serialize() {
        return VKStringJoiner.joinParams(tokenParams());
    }

    public Map<String, String> tokenParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("access_token", this.accessToken);
        hashMap.put("expires_in", "" + this.expiresIn);
        hashMap.put("user_id", this.userId);
        hashMap.put("created", "" + this.created);
        Map<String, Boolean> map = this.a;
        if (map != null) {
            hashMap.put("scope", TextUtils.join(",", map.keySet()));
        }
        String str = this.secret;
        if (str != null) {
            hashMap.put(SECRET, str);
        }
        if (this.httpsRequired) {
            hashMap.put(HTTPS_REQUIRED, "1");
        }
        String str2 = this.email;
        if (str2 != null) {
            hashMap.put("email", str2);
        }
        return hashMap;
    }
}
