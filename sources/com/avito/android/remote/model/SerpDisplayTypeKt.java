package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SerpDisplayType;", "", "toParameterValue", "(Lcom/avito/android/remote/model/SerpDisplayType;)Ljava/lang/String;", "orDefault", "(Lcom/avito/android/remote/model/SerpDisplayType;)Lcom/avito/android/remote/model/SerpDisplayType;", "", "isTablet", "fallbackForTablet", "(Lcom/avito/android/remote/model/SerpDisplayType;Z)Lcom/avito/android/remote/model/SerpDisplayType;", "models_release"}, k = 2, mv = {1, 4, 2})
public final class SerpDisplayTypeKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SerpDisplayType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            SerpDisplayType serpDisplayType = SerpDisplayType.Grid;
            iArr[0] = 1;
            SerpDisplayType serpDisplayType2 = SerpDisplayType.List;
            iArr[1] = 2;
            SerpDisplayType serpDisplayType3 = SerpDisplayType.Rich;
            iArr[2] = 3;
            SerpDisplayType serpDisplayType4 = SerpDisplayType.Vacancy;
            iArr[3] = 4;
        }
    }

    @NotNull
    public static final SerpDisplayType fallbackForTablet(@NotNull SerpDisplayType serpDisplayType, boolean z) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "$this$fallbackForTablet");
        if (!(!z || !serpDisplayType.isInformative())) {
            serpDisplayType = null;
        }
        return orDefault(serpDisplayType);
    }

    @NotNull
    public static final SerpDisplayType orDefault(@Nullable SerpDisplayType serpDisplayType) {
        return serpDisplayType != null ? serpDisplayType : SerpDisplayType.Grid;
    }

    @NotNull
    public static final String toParameterValue(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "$this$toParameterValue");
        int ordinal = serpDisplayType.ordinal();
        if (ordinal == 0) {
            return "grid";
        }
        if (ordinal == 1) {
            return "list";
        }
        if (ordinal == 2) {
            return "rich";
        }
        if (ordinal == 3) {
            return "vacancy";
        }
        throw new NoWhenBranchMatchedException();
    }
}
