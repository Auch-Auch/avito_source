package ru.sravni.android.bankproduct.di.buildlevel.debug;

import android.util.Log;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/di/buildlevel/debug/DebugLogger;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "event", "", "logEvent", "(Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;)V", "Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", "logError", "(Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DebugLogger implements IErrorLogger, IAnalyticEventLogger {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MessagePriority.values();
            int[] iArr = new int[6];
            $EnumSwitchMapping$0 = iArr;
            MessagePriority messagePriority = MessagePriority.ERROR;
            iArr[5] = 1;
            MessagePriority messagePriority2 = MessagePriority.ASSERT;
            iArr[0] = 2;
            MessagePriority messagePriority3 = MessagePriority.DEBUG;
            iArr[1] = 3;
            MessagePriority messagePriority4 = MessagePriority.INFO;
            iArr[2] = 4;
            MessagePriority messagePriority5 = MessagePriority.VERBOSE;
            iArr[3] = 5;
            MessagePriority messagePriority6 = MessagePriority.WARN;
            iArr[4] = 6;
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IErrorLogger
    public void logError(@NotNull MessagePriority messagePriority, @NotNull SravniError sravniError) {
        Intrinsics.checkParameterIsNotNull(messagePriority, Constants.FirelogAnalytics.PARAM_PRIORITY);
        Intrinsics.checkParameterIsNotNull(sravniError, "error");
        int ordinal = messagePriority.ordinal();
        int i = 5;
        if (ordinal == 0) {
            i = 7;
        } else if (ordinal == 1) {
            i = 3;
        } else if (ordinal == 2) {
            i = 4;
        } else if (ordinal == 3) {
            i = 2;
        } else if (ordinal != 4) {
            if (ordinal == 5) {
                i = 6;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        Log.println(i, sravniError.getDomain(), sravniError.getErrDescription().toString());
        sravniError.getMessage();
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger
    public void logEvent(@NotNull AnalyticEvent analyticEvent) {
        Intrinsics.checkParameterIsNotNull(analyticEvent, "event");
        String str = analyticEvent.getId() + analyticEvent.getParams() + analyticEvent.getMassiveParams();
    }
}
