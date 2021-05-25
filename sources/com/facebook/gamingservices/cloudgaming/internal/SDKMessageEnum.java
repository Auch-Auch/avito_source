package com.facebook.gamingservices.cloudgaming.internal;

import androidx.annotation.Nullable;
public enum SDKMessageEnum {
    OPEN_PLAY_STORE("openPlayStore"),
    OPEN_APP_STORE("openAppStore"),
    MARK_GAME_LOADED("markGameLoaded"),
    GET_PLAYER_DATA("getPlayerData"),
    SET_PLAYER_DATA("setPlayerData"),
    GET_CATALOG("getCatalog"),
    GET_PURCHASES("getPurchases"),
    PURCHASE("purchase"),
    CONSUME_PURCHASE("consumePurchase"),
    ON_READY("onReady"),
    LOAD_INTERSTITIAL_AD("loadInterstitialAd"),
    LOAD_REWARDED_VIDEO("loadRewardedVideo"),
    SHOW_INTERSTITIAL_AD("showInterstitialAd"),
    SHOW_REWARDED_VIDEO("showRewardedVideo"),
    GET_ACCESS_TOKEN("getAccessToken"),
    GET_CONTEXT_TOKEN("getContextToken"),
    GET_PAYLOAD("getPayload"),
    IS_ENV_READY("isEnvReady"),
    SHARE("share"),
    CAN_CREATE_SHORTCUT("canCreateShortcut"),
    CREATE_SHORTCUT("createShortcut"),
    OPEN_GAMING_SERVICES_DEEP_LINK("openGamingServicesDeepLink");
    
    public final String a;

    /* access modifiers changed from: public */
    SDKMessageEnum(String str) {
        this.a = str;
    }

    @Nullable
    public static SDKMessageEnum fromString(String str) {
        SDKMessageEnum[] values = values();
        for (int i = 0; i < 22; i++) {
            SDKMessageEnum sDKMessageEnum = values[i];
            if (sDKMessageEnum.toString().equals(str)) {
                return sDKMessageEnum;
            }
        }
        return null;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.a;
    }
}
