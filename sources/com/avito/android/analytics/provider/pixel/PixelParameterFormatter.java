package com.avito.android.analytics.provider.pixel;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J%\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelParameterFormatter;", "", "", "", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "format", "(Ljava/util/Map;)Ljava/lang/String;", "analytics_release"}, k = 1, mv = {1, 4, 2})
public interface PixelParameterFormatter {
    @NotNull
    String format(@NotNull Map<String, String> map);
}
