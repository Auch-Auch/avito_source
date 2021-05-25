package com.avito.android.analytics.provider.pixel;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoderImpl;", "Lcom/avito/android/analytics/provider/pixel/PixelParameterEncoder;", "", "value", "encode", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class PixelParameterEncoderImpl implements PixelParameterEncoder {
    @Override // com.avito.android.analytics.provider.pixel.PixelParameterEncoder
    @NotNull
    public String encode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        if (str.length() == 0) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(value, \"UTF-8\")");
            return m.replace$default(m.replace$default(m.replace$default(m.replace$default(m.replace$default(m.replace$default(encode, "+", "%20", false, 4, (Object) null), "%21", "!", false, 4, (Object) null), "%27", "'", false, 4, (Object) null), "%28", "(", false, 4, (Object) null), "%29", ")", false, 4, (Object) null), "%7E", "~", false, 4, (Object) null);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
