package ru.sravni.android.bankproduct.domain.analytic;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lru/sravni/android/bankproduct/domain/analytic/AnalyticInteractor;", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "event", "", "logEvent", "(Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;)V", "Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", "logError", "(Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "eventLogger", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnalyticInteractor implements IAnalyticEventLogger, IErrorLogger {
    public final IAnalyticEventLogger a;
    public final IErrorLogger b;

    public AnalyticInteractor(@NotNull IAnalyticEventLogger iAnalyticEventLogger, @NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "eventLogger");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.a = iAnalyticEventLogger;
        this.b = iErrorLogger;
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IErrorLogger
    public void logError(@NotNull MessagePriority messagePriority, @NotNull SravniError sravniError) {
        Intrinsics.checkParameterIsNotNull(messagePriority, Constants.FirelogAnalytics.PARAM_PRIORITY);
        Intrinsics.checkParameterIsNotNull(sravniError, "error");
        this.b.logError(messagePriority, sravniError);
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger
    public void logEvent(@NotNull AnalyticEvent analyticEvent) {
        Intrinsics.checkParameterIsNotNull(analyticEvent, "event");
        this.a.logEvent(analyticEvent);
    }
}
