package com.avito.android.service_subscription.subscription_new;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/service_subscription/subscription_new/ColorParserImpl;", "Lcom/avito/android/service_subscription/subscription_new/ColorParser;", "", "color", "", "parseColor", "(Ljava/lang/String;)I", AuthSource.SEND_ABUSE, "I", "defaultColor", "<init>", "(I)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ColorParserImpl implements ColorParser {
    public final int a;

    public ColorParserImpl(@ColorInt int i) {
        this.a = i;
    }

    @Override // com.avito.android.service_subscription.subscription_new.ColorParser
    public int parseColor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "color");
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return this.a;
        }
    }
}
