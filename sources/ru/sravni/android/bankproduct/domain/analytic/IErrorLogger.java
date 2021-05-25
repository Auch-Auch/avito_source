package ru.sravni.android.bankproduct.domain.analytic;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "", "Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;", Constants.FirelogAnalytics.PARAM_PRIORITY, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "error", "", "logError", "(Lru/sravni/android/bankproduct/domain/analytic/entity/MessagePriority;Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IErrorLogger {
    void logError(@NotNull MessagePriority messagePriority, @NotNull SravniError sravniError);
}
