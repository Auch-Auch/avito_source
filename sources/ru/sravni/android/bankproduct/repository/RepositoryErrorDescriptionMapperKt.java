package ru.sravni.android.bankproduct.repository;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import t6.n.q;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\n\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\t\u001a-\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\t\u001a%\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"", "pollingID", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "emptyOsagoCompanyNameForOsagoCompanyOrderDescription", "(Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "savedSearchID", "companyID", "productID", "emptyOsagoCompanyNameForOsagoPollingCompanyDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "emptyOsagoCompanyNameForOsagoListCompanyDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "orderID", "bankID", "emptyProductCompanyNameForProductListCompanyDescription", "emptyProductCompanyNameForProductStatusCompanyDescription", "", "cardId", "chatId", "dateField", "wrongCreatedDateFormatErrorDescription", "(ILjava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class RepositoryErrorDescriptionMapperKt {
    @NotNull
    public static final ErrorDescription emptyOsagoCompanyNameForOsagoCompanyOrderDescription(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        return new ErrorDescription(110, "EmptyOsagoNameOrder", a.c3("Empty OSAGO name for order ", str), q.mapOf(TuplesKt.to("pollingID", str)));
    }

    @NotNull
    public static final ErrorDescription emptyOsagoCompanyNameForOsagoListCompanyDescription(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str3, "productID");
        return new ErrorDescription(112, "EmptyOsagoListCompany", a.d("Empty OSAGO name from list company polling ", str, " with ssID: ", str2), r.mapOf(TuplesKt.to("pollingID", str), TuplesKt.to("savedSearchId", str2), TuplesKt.to("productId", str3)));
    }

    @NotNull
    public static final ErrorDescription emptyOsagoCompanyNameForOsagoPollingCompanyDescription(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pollingID");
        Intrinsics.checkParameterIsNotNull(str2, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str3, "companyID");
        Intrinsics.checkParameterIsNotNull(str4, "productID");
        return new ErrorDescription(111, "EmptyOsagoNewPoll", a.d("Empty OSAGO name for new polling ", str, " with ssID: ", str2), r.mapOf(TuplesKt.to("pollingID", str), TuplesKt.to("savedSearchId", str2), TuplesKt.to("companyId", str3), TuplesKt.to("productId", str4)));
    }

    @NotNull
    public static final ErrorDescription emptyProductCompanyNameForProductListCompanyDescription(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str3, "orderID");
        Intrinsics.checkParameterIsNotNull(str4, "bankID");
        return new ErrorDescription(113, "EmptyProductListCompany", a.c3("Empty Product name from list company with ssID: ", str), r.mapOf(TuplesKt.to("orderID", str3), TuplesKt.to("bankID", str4), TuplesKt.to("savedSearchID", str), TuplesKt.to("productID", str2)));
    }

    @NotNull
    public static final ErrorDescription emptyProductCompanyNameForProductStatusCompanyDescription(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str2, "productID");
        Intrinsics.checkParameterIsNotNull(str3, "orderID");
        Intrinsics.checkParameterIsNotNull(str4, "bankID");
        return new ErrorDescription(114, "EmptyProductStatusCompany", a.c3("Empty Product name from status company with ssID: ", str), r.mapOf(TuplesKt.to("orderID", str3), TuplesKt.to("bankID", str4), TuplesKt.to("savedSearchID", str), TuplesKt.to("productID", str2)));
    }

    @NotNull
    public static final ErrorDescription wrongCreatedDateFormatErrorDescription(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "chatId");
        Intrinsics.checkParameterIsNotNull(str2, "dateField");
        return new ErrorDescription(115, "WrongDate", "DateCreated with unknown format", r.mapOf(TuplesKt.to("cardId", String.valueOf(i)), TuplesKt.to("chatId", str), TuplesKt.to("dateField", str2)));
    }
}
