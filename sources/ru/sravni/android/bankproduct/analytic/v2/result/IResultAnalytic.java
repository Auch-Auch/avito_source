package ru.sravni.android.bankproduct.analytic.v2.result;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJG\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/result/IResultAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", AnalyticFieldsName.searchId, AnalyticFieldsName.productName, AnalyticFieldsName.field, "previousStep", "", "sendResultEditEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", AnalyticFieldsName.offersCount, "", AnalyticFieldsName.route, "isPush", "sendResultOpenEvent", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "errorType", "sendResultFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IResultAnalytic extends IBaseAnalytic {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendResultFailEvent$default(IResultAnalytic iResultAnalytic, String str, String str2, Boolean bool, String str3, Boolean bool2, int i, Object obj) {
            if (obj == null) {
                iResultAnalytic.sendResultFailEvent(str, str2, (i & 4) != 0 ? null : bool, str3, (i & 16) != 0 ? null : bool2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendResultFailEvent");
        }

        public static /* synthetic */ void sendResultOpenEvent$default(IResultAnalytic iResultAnalytic, String str, String str2, int i, Boolean bool, String str3, Boolean bool2, int i2, Object obj) {
            if (obj == null) {
                iResultAnalytic.sendResultOpenEvent(str, str2, i, (i2 & 8) != 0 ? null : bool, str3, (i2 & 32) != 0 ? null : bool2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendResultOpenEvent");
        }
    }

    void sendResultEditEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void sendResultFailEvent(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @NotNull String str3, @Nullable Boolean bool2);

    void sendResultOpenEvent(@NotNull String str, @NotNull String str2, int i, @Nullable Boolean bool, @NotNull String str3, @Nullable Boolean bool2);
}
