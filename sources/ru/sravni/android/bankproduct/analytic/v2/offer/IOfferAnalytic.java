package ru.sravni.android.bankproduct.analytic.v2.offer;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0013\u0010\u0014J_\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/analytic/v2/offer/IOfferAnalytic;", "Lru/sravni/android/bankproduct/analytic/v2/IBaseAnalytic;", "", AnalyticFieldsName.searchId, AnalyticFieldsName.productName, "", AnalyticFieldsName.offersCount, "", AnalyticFieldsName.organizationName, "Lkotlin/Pair;", AnalyticFieldsName.offerName, AnalyticFieldsName.orderId, "", AnalyticFieldsName.route, "isPush", "previousStep", "", "offerShow", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "offerOpen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", AnalyticFieldsName.brokerSendPoint, "offerSend", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "errorType", "offerFail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IOfferAnalytic extends IBaseAnalytic {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void offerFail$default(IOfferAnalytic iOfferAnalytic, String str, String str2, String str3, Boolean bool, Boolean bool2, int i, Object obj) {
            if (obj == null) {
                iOfferAnalytic.offerFail(str, str2, str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offerFail");
        }

        public static /* synthetic */ void offerOpen$default(IOfferAnalytic iOfferAnalytic, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, int i, Object obj) {
            if (obj == null) {
                iOfferAnalytic.offerOpen(str, str2, str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offerOpen");
        }

        public static /* synthetic */ void offerSend$default(IOfferAnalytic iOfferAnalytic, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, String str6, int i, Object obj) {
            if (obj == null) {
                iOfferAnalytic.offerSend(str, str2, str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : str6);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offerSend");
        }

        public static /* synthetic */ void offerShow$default(IOfferAnalytic iOfferAnalytic, String str, String str2, int i, List list, List list2, String str3, Boolean bool, Boolean bool2, String str4, int i2, Object obj) {
            if (obj == null) {
                iOfferAnalytic.offerShow(str, str2, i, list, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : bool, (i2 & 128) != 0 ? null : bool2, str4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: offerShow");
        }
    }

    void offerFail(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool, @Nullable Boolean bool2);

    void offerOpen(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable Boolean bool2);

    void offerSend(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str6);

    void offerShow(@NotNull String str, @NotNull String str2, int i, @NotNull List<String> list, @Nullable List<Pair<String, String>> list2, @Nullable String str3, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull String str4);
}
