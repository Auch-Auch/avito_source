package ru.sravni.android.bankproduct.presentation.offer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\b\"\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0019\u0010\u001a\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "sravniFilterItem", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "unknownFilterErrorDescription", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "parseFilterBarrelDayErrorDescription", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "recommendedFilterBarrelDayErrorDescription", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "getNullOfferCurrentSnapErrorDescription", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "NullOfferCurrentSnapErrorDescription", AuthSource.SEND_ABUSE, "getNullSavedSearchIDForProductListCameErrorDescription", "NullSavedSearchIDForProductListCameErrorDescription", "d", "getOsagoPollingStatusErrorDescription", "OsagoPollingStatusErrorDescription", "f", "getNullOfferProductDetailInfoForUpdateErrorDescription", "NullOfferProductDetailInfoForUpdateErrorDescription", AuthSource.BOOKING_ORDER, "getNullOsagoNavInfoCameErrorDescription", "NullOsagoNavInfoCameErrorDescription", "e", "getNullOrderIDGetStatusErrorDescription", "NullOrderIDGetStatusErrorDescription", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class PresentationOfferErrorDescriptionMapperKt {
    @NotNull
    public static final ErrorDescription a = new ErrorDescription(11, "nullSavedSearchID", "Try get order list for with null savedSearchID", null, 8, null);
    @NotNull
    public static final ErrorDescription b = new ErrorDescription(12, "nullOsagoInfo", "Try get order list for with null osago info", null, 8, null);
    @NotNull
    public static final ErrorDescription c = new ErrorDescription(23, "nullOfferCurrentSnap", "Null offer current snap while try get term from snap point", null, 8, null);
    @NotNull
    public static final ErrorDescription d = new ErrorDescription(25, "pollingStatusOsagoError", "Error from server get polling", null, 8, null);
    @NotNull
    public static final ErrorDescription e = new ErrorDescription(26, "orderIDError", "Null orderID while try get product status", null, 8, null);
    @NotNull
    public static final ErrorDescription f = new ErrorDescription(27, "nullOfferDetailInfo", "Null offer detail info while try update detail info", null, 8, null);

    @NotNull
    public static final ErrorDescription getNullOfferCurrentSnapErrorDescription() {
        return c;
    }

    @NotNull
    public static final ErrorDescription getNullOfferProductDetailInfoForUpdateErrorDescription() {
        return f;
    }

    @NotNull
    public static final ErrorDescription getNullOrderIDGetStatusErrorDescription() {
        return e;
    }

    @NotNull
    public static final ErrorDescription getNullOsagoNavInfoCameErrorDescription() {
        return b;
    }

    @NotNull
    public static final ErrorDescription getNullSavedSearchIDForProductListCameErrorDescription() {
        return a;
    }

    @NotNull
    public static final ErrorDescription getOsagoPollingStatusErrorDescription() {
        return d;
    }

    @NotNull
    public static final ErrorDescription parseFilterBarrelDayErrorDescription(@NotNull FilterItem.FilterInfo filterInfo) {
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        StringBuilder L = a.L("Can't parse date from string. ");
        L.append(UtilFunctionsKt.toSravniJson(filterInfo));
        return new ErrorDescription(51, "ErrorParseDate", L.toString(), null, 8, null);
    }

    @NotNull
    public static final ErrorDescription recommendedFilterBarrelDayErrorDescription(@NotNull FilterItem.FilterInfo filterInfo) {
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        StringBuilder L = a.L("Recommended date not included in range. ");
        L.append(UtilFunctionsKt.toSravniJson(filterInfo));
        return new ErrorDescription(52, "RecommendedNotRange", L.toString(), null, 8, null);
    }

    @NotNull
    public static final ErrorDescription unknownFilterErrorDescription(@NotNull FilterItem filterItem) {
        Intrinsics.checkParameterIsNotNull(filterItem, "sravniFilterItem");
        StringBuilder L = a.L("Unknown filter. ");
        L.append(UtilFunctionsKt.toSravniJson(filterItem));
        return new ErrorDescription(50, "WrongFilter", L.toString(), null, 8, null);
    }
}
