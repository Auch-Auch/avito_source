package com.avito.android.toggle;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.util.AvitoBuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "Lcom/avito/android/toggle/MutableFeatures;", "createMutableFeatures", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;)Lcom/avito/android/toggle/MutableFeatures;", "features_release"}, k = 2, mv = {1, 4, 2})
public final class MutableFeaturesKt {
    @NotNull
    public static final MutableFeatures createMutableFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        SharedPreferences sharedPreferences = context.getSharedPreferences("features", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "preferences");
        return new MutableFeatures(context, sharedPreferences, avitoBuildInfo);
    }
}
