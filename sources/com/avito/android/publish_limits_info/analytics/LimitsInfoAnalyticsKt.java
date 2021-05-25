package com.avito.android.publish_limits_info.analytics;

import com.avito.android.remote.model.LimitsInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/LimitsInfo;", "", "getSeverity", "(Lcom/avito/android/remote/model/LimitsInfo;)Ljava/lang/String;", "Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", "(Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;)Ljava/lang/String;", "publish-limits-info_release"}, k = 2, mv = {1, 4, 2})
public final class LimitsInfoAnalyticsKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            LimitsInfo.Progress.Style.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            LimitsInfo.Progress.Style style = LimitsInfo.Progress.Style.NORMAL;
            iArr[0] = 1;
            LimitsInfo.Progress.Style style2 = LimitsInfo.Progress.Style.WARNING;
            iArr[1] = 2;
        }
    }

    @NotNull
    public static final String getSeverity(@NotNull LimitsInfo limitsInfo) {
        Intrinsics.checkNotNullParameter(limitsInfo, "$this$getSeverity");
        LimitsInfo.Progress progress = limitsInfo.getProgress();
        if (progress == null) {
            return "absent";
        }
        if (progress.getValue() == 0.0f) {
            return "empty";
        }
        return getSeverity(progress.getStyle());
    }

    @NotNull
    public static final String getSeverity(@NotNull LimitsInfo.Progress.Style style) {
        Intrinsics.checkNotNullParameter(style, "$this$getSeverity");
        int ordinal = style.ordinal();
        if (ordinal == 0) {
            return "normal";
        }
        if (ordinal == 1) {
            return "warning";
        }
        throw new NoWhenBranchMatchedException();
    }
}
