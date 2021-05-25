package com.avito.android.toggle;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.URLUtil;
import com.avito.android.Features;
import com.avito.android.util.AvitoBuildInfo;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/toggle/MutableFeatures;", "Lcom/avito/android/Features;", "T", "Lcom/avito/android/toggle/Feature;", "feature", "value", "", "isValueValid", "(Lcom/avito/android/toggle/Feature;Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "<init>", "(Landroid/content/Context;Landroid/content/SharedPreferences;Lcom/avito/android/util/AvitoBuildInfo;)V", "features_release"}, k = 1, mv = {1, 4, 2})
public class MutableFeatures extends Features {

    public static final class a extends Lambda implements Function1<Feature<? extends Object>, Feature<? extends Object>> {
        public final /* synthetic */ MutableFeatures a;
        public final /* synthetic */ SharedPreferences b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MutableFeatures mutableFeatures, SharedPreferences sharedPreferences) {
            super(1);
            this.a = mutableFeatures;
            this.b = sharedPreferences;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Feature<? extends Object> invoke(Feature<? extends Object> feature) {
            Feature<? extends Object> feature2 = feature;
            Intrinsics.checkNotNullParameter(feature2, "feature");
            return new MutableFeatures$1$1(this, feature2, feature2, this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableFeatures(@NotNull Context context, @NotNull SharedPreferences sharedPreferences, @NotNull AvitoBuildInfo avitoBuildInfo) {
        super(context, avitoBuildInfo);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        decorate(new a(this, sharedPreferences));
    }

    public final <T> boolean isValueValid(@NotNull Feature<? extends T> feature, T t) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (!Intrinsics.areEqual(feature.getKey(), getApiUrl().getKey())) {
            return true;
        }
        Objects.requireNonNull(t, "null cannot be cast to non-null type kotlin.String");
        T t2 = t;
        if (URLUtil.isHttpsUrl(t2) || URLUtil.isHttpUrl(t2)) {
            return true;
        }
        return false;
    }
}
