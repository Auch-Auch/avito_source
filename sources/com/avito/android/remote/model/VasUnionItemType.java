package com.avito.android.remote.model;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/VasUnionItemType;", "", "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", ScreenPublicConstsKt.CONTENT_TYPE_MNZ_PERFORMANCE_VAS, "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "getPerformanceVas", "()Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "Lcom/avito/android/remote/model/Bundles;", "bundles", "Lcom/avito/android/remote/model/Bundles;", "getBundles", "()Lcom/avito/android/remote/model/Bundles;", "<init>", "(Lcom/avito/android/remote/model/Bundles;Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class VasUnionItemType {
    @SerializedName("bundles")
    @Nullable
    private final Bundles bundles;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_MNZ_PERFORMANCE_VAS)
    @Nullable
    private final VasPerformanceResult performanceVas;

    public VasUnionItemType(@Nullable Bundles bundles2, @Nullable VasPerformanceResult vasPerformanceResult) {
        this.bundles = bundles2;
        this.performanceVas = vasPerformanceResult;
    }

    @Nullable
    public final Bundles getBundles() {
        return this.bundles;
    }

    @Nullable
    public final VasPerformanceResult getPerformanceVas() {
        return this.performanceVas;
    }
}
