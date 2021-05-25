package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
public enum rq {
    YMAD_HEADER_WIDTH("YMAd-Width"),
    YMAD_HEADER_HEIGHT("YMAd-Height"),
    YMAD_TYPE("YMAd-Type"),
    YMAD_ID("YMAd-Id"),
    YMAD_SHOW_NOTICE("YMAd-ShowNotice"),
    YMAD_RENDER_TRACKING_URLS("YMAd-RenderTrackingUrls"),
    YMAD_MEDIATION("YMAd-Mediation"),
    YMAD_NOTICE_DELAY("YMAd-NoticeDelay"),
    YMAD_CLICK_THROUGH("YMAd-ClickThrough"),
    YMAD_FALSE_CLICK_URL("YMAd-FalseClickUrl"),
    YMAD_FALSE_CLICK_INTERVAL("YMAd-FalseClickInterval"),
    YMAD_PREFETCH_COUNT("YMAd-PrefetchCount"),
    YMAD_REFRESH_PERIOD("YMAd-RefreshPeriod"),
    YMAD_RELOAD_TIMEOUT("YMAd-ReloadTimeout"),
    YMAD_REWARD_AMOUNT("YMAd-RewardAmount"),
    YMAD_REWARD_TYPE("YMAd-RewardType"),
    YMAD_REWARD_URL("YMAd-RewardUrl"),
    YMAD_EMPTY_INTERVAL("YMAd-EmptyInterval"),
    YMAD_RENDERER("YMAd-Renderer"),
    YMAD_ROTATION_ENABLED("YMAd-RotationEnabled"),
    YMAD_RAW_VAST_ENABLED("YMAd-RawVastEnabled"),
    YMAD_SERVER_SIDE_REWARD("YMAd-ServerSideReward"),
    YMAD_SESSION_DATA("YMAd-SessionData"),
    YMAD_RENDER_AD_IDS("YMAd-RenderAdIds"),
    YMAD_IMPRESSION_AD_IDS("YMAd-ImpressionAdIds"),
    YMAD_VISIBILITY_PERCENT("YMAd-VisibilityPercent"),
    YMAD_NON_SKIPPABLE_AD_ENABLED("YMAd-NonSkippableAdEnabled"),
    YMAD_TYPE_FORMAT("YMAd-AdTypeFormat"),
    YMAD_PRODUCT_TYPE("YMAd-ProductType"),
    YMAD_SOURCE("YMAd-Source"),
    YMAD_ADAPTER_IMPRESSION_ENABLED("YMAd-AdapterImpressionEnabled"),
    LOCATION(HttpHeaders.LOCATION),
    USER_AGENT("User-Agent");
    
    private final String H;

    private rq(String str) {
        this.H = str;
    }

    public final String a() {
        return this.H;
    }
}
