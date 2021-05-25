package com.avito.android.calls.quality;

import com.voximplant.sdk.call.QualityIssueLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00018\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/voximplant/sdk/call/QualityIssueLevel;", "", "convertToInt", "(Lcom/voximplant/sdk/call/QualityIssueLevel;)I", "QUALITY_ISSUE_LEVEL_CRITICAL", "I", "QUALITY_ISSUE_LEVEL_NONE", "QUALITY_ISSUE_LEVEL_MINOR", "QUALITY_ISSUE_LEVEL_MAJOR", "calls_release"}, k = 2, mv = {1, 4, 2})
public final class CallQualityIssueKt {
    public static final int QUALITY_ISSUE_LEVEL_CRITICAL = 3;
    public static final int QUALITY_ISSUE_LEVEL_MAJOR = 2;
    public static final int QUALITY_ISSUE_LEVEL_MINOR = 1;
    public static final int QUALITY_ISSUE_LEVEL_NONE = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            QualityIssueLevel.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final int convertToInt(@Nullable QualityIssueLevel qualityIssueLevel) {
        int ordinal;
        if (qualityIssueLevel == null || (ordinal = qualityIssueLevel.ordinal()) == 0) {
            return 0;
        }
        if (ordinal == 1) {
            return 1;
        }
        if (ordinal == 2) {
            return 2;
        }
        if (ordinal == 3) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }
}
