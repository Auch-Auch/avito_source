package ru.sravni.android.bankproduct.analytic.v2.product;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJG\u0010\u0011\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "", "", "previousStep", AnalyticFieldsName.productName, AnalyticFieldsName.draft, "", "isPush", "", "sendOpenEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "errorType", "sendFailEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", AnalyticFieldsName.step, "conversationID", "isProlongation", "sendChatEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IProductAnalytic {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendOpenEvent$default(IProductAnalytic iProductAnalytic, String str, String str2, String str3, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                iProductAnalytic.sendOpenEvent(str, str2, str3, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendOpenEvent");
        }
    }

    void sendChatEvent(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable Boolean bool, @NotNull String str4);

    void sendFailEvent(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void sendOpenEvent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z);
}
