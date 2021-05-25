package com.avito.android.enabler;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.toggle.Feature;
import com.avito.android.util.AvitoBuildInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/enabler/RemoteFeatures;", "Lcom/avito/android/Features;", "Landroid/content/Context;", "context", "Lcom/avito/android/util/AvitoBuildInfo;", "buildInfo", "Lcom/avito/android/enabler/TogglesStorage;", "storage", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/AvitoBuildInfo;Lcom/avito/android/enabler/TogglesStorage;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class RemoteFeatures extends Features {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteFeatures(@NotNull Context context, @NotNull AvitoBuildInfo avitoBuildInfo, @NotNull final TogglesStorage togglesStorage) {
        super(context, avitoBuildInfo);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avitoBuildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(togglesStorage, "storage");
        decorate(new Function1<Feature<? extends Object>, Feature<? extends Object>>() { // from class: com.avito.android.enabler.RemoteFeatures.1
            @NotNull
            public final Feature<Object> invoke(@NotNull Feature<? extends Object> feature) {
                Intrinsics.checkNotNullParameter(feature, "feature");
                return feature.isRemote() ? new RemoteFeature(feature, new Function1<String, Object>(this) { // from class: com.avito.android.enabler.RemoteFeatures.1.1
                    public final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    @Nullable
                    public final Object invoke(@NotNull String str) {
                        Intrinsics.checkNotNullParameter(str, "key");
                        return togglesStorage.getFeatureValue(str);
                    }
                }) : feature;
            }
        });
    }
}
