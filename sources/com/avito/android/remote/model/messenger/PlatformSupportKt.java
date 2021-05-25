package com.avito.android.remote.model.messenger;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u001a\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/messenger/PlatformSupport;", "", "isSupported", "(Lcom/avito/android/remote/model/messenger/PlatformSupport;)Z", "models_release"}, k = 2, mv = {1, 4, 2})
public final class PlatformSupportKt {
    public static final boolean isSupported(@Nullable PlatformSupport platformSupport) {
        List<String> platforms;
        if (platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) {
            return true;
        }
        return platforms.contains("android");
    }
}
