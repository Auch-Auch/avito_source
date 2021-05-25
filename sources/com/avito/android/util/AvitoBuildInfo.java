package com.avito.android.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/util/AvitoBuildInfo;", "Lcom/avito/android/util/BuildInfo;", "", "getApiKey", "()Ljava/lang/String;", "apiKey", "getAdjustDefaultTracker", "adjustDefaultTracker", "getWebSocketEndpoint", "webSocketEndpoint", "getMessengerImageUploadEndpoint", "messengerImageUploadEndpoint", "config_release"}, k = 1, mv = {1, 4, 2})
public interface AvitoBuildInfo extends BuildInfo {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static String getApiKey(@NotNull AvitoBuildInfo avitoBuildInfo) {
            return "Aewei8yaf0deeGho4eetos6cohQuoodooy2Ohmie";
        }
    }

    @Nullable
    String getAdjustDefaultTracker();

    @Override // com.avito.android.util.BuildInfo
    @NotNull
    String getApiKey();

    @NotNull
    String getMessengerImageUploadEndpoint();

    @NotNull
    String getWebSocketEndpoint();
}
