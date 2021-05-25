package ru.sravni.android.bankproduct.repository.analytic;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/repository/analytic/AnalyticRepository;", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "event", "", "logEvent", "(Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;)V", "Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", "logError", "(Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", AuthSource.SEND_ABUSE, "eventLogger", "<init>", "(Ljava/util/List;Ljava/util/List;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnalyticRepository implements IAnalyticEventLogger, IErrorLogger {
    public final List<IAnalyticEventLogger> a;
    public final List<IErrorLogger> b;
    public final IThrowableWrapper c;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends ru.sravni.android.bankproduct.domain.analytic.IErrorLogger> */
    /* JADX WARN: Multi-variable type inference failed */
    public AnalyticRepository(@NotNull List<? extends IAnalyticEventLogger> list, @NotNull List<? extends IErrorLogger> list2, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(list, "eventLogger");
        Intrinsics.checkParameterIsNotNull(list2, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.a = list;
        this.b = list2;
        this.c = iThrowableWrapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IErrorLogger
    public void logError(@NotNull MessagePriority messagePriority, @NotNull SravniError sravniError) {
        Intrinsics.checkParameterIsNotNull(messagePriority, Constants.FirelogAnalytics.PARAM_PRIORITY);
        Intrinsics.checkParameterIsNotNull(sravniError, "error");
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            try {
                it.next().logError(messagePriority, sravniError);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger
    public void logEvent(@NotNull AnalyticEvent analyticEvent) {
        Intrinsics.checkParameterIsNotNull(analyticEvent, "event");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                it.next().logEvent(analyticEvent);
            } catch (Throwable th) {
                logError(MessagePriority.ERROR, this.c.wrap(th));
            }
        }
    }
}
