package ru.sravni.android.bankproduct.repository;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.repository.chat.ButtonContentWithoutButtons;
import ru.sravni.android.bankproduct.repository.chat.NoSliderPointsError;
import ru.sravni.android.bankproduct.repository.chat.NotEnoughSliderPointsError;
import ru.sravni.android.bankproduct.repository.chat.NullNameInContentCard;
import ru.sravni.android.bankproduct.repository.chat.NullSavedSearchInContentCard;
import ru.sravni.android.bankproduct.repository.chat.NullValidateInContentCard;
import ru.sravni.android.bankproduct.repository.chat.UnknownContentCard;
import ru.sravni.android.bankproduct.repository.chat.WrongCreatedDateFormat;
import ru.sravni.android.bankproduct.repository.offer.entity.ListDetailFilterError;
import ru.sravni.android.bankproduct.repository.offer.osago.EmptyOsagoCompanyNameForOsagoCompanyOrder;
import ru.sravni.android.bankproduct.repository.offer.osago.EmptyOsagoCompanyNameForOsagoListCompany;
import ru.sravni.android.bankproduct.repository.offer.osago.EmptyOsagoCompanyNameForOsagoPollingCompany;
import ru.sravni.android.bankproduct.repository.offer.product.EmptyProductCompanyNameForProductListCompany;
import ru.sravni.android.bankproduct.repository.offer.product.EmptyProductCompanyNameForProductStatusCompany;
import ru.sravni.android.bankproduct.repository.scoring.StatusStringNotFoundError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/repository/RepositoryErrorDescriptionMapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "mapToError", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "domain", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class RepositoryErrorDescriptionMapper implements IThrowableErrorDescriptionMapper {
    @NotNull
    public final String a = "RE";

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @NotNull
    public String getDomain() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableErrorDescriptionMapper
    @Nullable
    public ErrorDescription mapToError(@NotNull Throwable th) {
        ErrorDescription errorDescription;
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        if (th instanceof EmptyCardListException) {
            return new ErrorDescription(22, "EmCaLi", "Try call next on empty cards list in answer ChatRepository method", null, 8, null);
        }
        if (th instanceof ButtonContentWithoutButtons) {
            return new ErrorDescription(23, "BuCo", "In chat came button content without button", null, 8, null);
        }
        if (th instanceof NullNameInContentCard) {
            StringBuilder L = a.L("Null name in content card in card ");
            NullNameInContentCard nullNameInContentCard = (NullNameInContentCard) th;
            L.append(nullNameInContentCard.getCardId());
            L.append(" in chat ");
            L.append(nullNameInContentCard.getChatId());
            errorDescription = new ErrorDescription(24, "NuNaCoCa", L.toString(), null, 8, null);
        } else if (th instanceof UnknownContentCard) {
            StringBuilder L2 = a.L("Unknown type in content card in card ");
            UnknownContentCard unknownContentCard = (UnknownContentCard) th;
            L2.append(unknownContentCard.getCardId());
            L2.append(" in chat ");
            L2.append(unknownContentCard.getChatId());
            L2.append(" in type ");
            L2.append(unknownContentCard.getCardType());
            errorDescription = new ErrorDescription(25, "UnCoCa", L2.toString(), null, 8, null);
        } else if (th instanceof NoSliderPointsError) {
            StringBuilder L3 = a.L("No slider points in slider in content card in card ");
            NoSliderPointsError noSliderPointsError = (NoSliderPointsError) th;
            L3.append(noSliderPointsError.getCardId());
            L3.append(" in chat ");
            L3.append(noSliderPointsError.getChatId());
            errorDescription = new ErrorDescription(30, "NoSliPo", L3.toString(), null, 8, null);
        } else if (th instanceof NotEnoughSliderPointsError) {
            StringBuilder L4 = a.L("Only ");
            NotEnoughSliderPointsError notEnoughSliderPointsError = (NotEnoughSliderPointsError) th;
            L4.append(notEnoughSliderPointsError.getPoints());
            L4.append(" slider points in slider in content card in card ");
            L4.append(notEnoughSliderPointsError.getCardId());
            L4.append(" in chat ");
            L4.append(notEnoughSliderPointsError.getChatId());
            errorDescription = new ErrorDescription(31, "NotEnoSliPo", L4.toString(), null, 8, null);
        } else if (th instanceof StatusStringNotFoundError) {
            StringBuilder L5 = a.L("There is no status ");
            L5.append(((StatusStringNotFoundError) th).getStatusString());
            L5.append(" for scoring");
            errorDescription = new ErrorDescription(50, "NoScrolStat", L5.toString(), null, 8, null);
        } else if (th instanceof NullValidateInContentCard) {
            StringBuilder L6 = a.L("No validation info in card ");
            NullValidateInContentCard nullValidateInContentCard = (NullValidateInContentCard) th;
            L6.append(nullValidateInContentCard.getCardId());
            L6.append(" in chat ");
            L6.append(nullValidateInContentCard.getChatId());
            L6.append(" for osago");
            errorDescription = new ErrorDescription(70, "NoValidate", L6.toString(), null, 8, null);
        } else if (th instanceof NullSavedSearchInContentCard) {
            StringBuilder L7 = a.L("There is no saved search in card ");
            NullSavedSearchInContentCard nullSavedSearchInContentCard = (NullSavedSearchInContentCard) th;
            L7.append(nullSavedSearchInContentCard.getCardId());
            L7.append(" in chat ");
            L7.append(nullSavedSearchInContentCard.getChatId());
            L7.append(" for osago");
            errorDescription = new ErrorDescription(80, "NoSavSearch", L7.toString(), null, 8, null);
        } else if (th instanceof ListDetailFilterError) {
            StringBuilder L8 = a.L("Empty list values for filter ");
            ListDetailFilterError listDetailFilterError = (ListDetailFilterError) th;
            L8.append(listDetailFilterError.getFilterName());
            L8.append(" from ");
            L8.append(listDetailFilterError.getSavedSearchID());
            errorDescription = new ErrorDescription(100, "LiDeFi", L8.toString(), null, 8, null);
        } else if (th instanceof EmptyOsagoCompanyNameForOsagoCompanyOrder) {
            return RepositoryErrorDescriptionMapperKt.emptyOsagoCompanyNameForOsagoCompanyOrderDescription(((EmptyOsagoCompanyNameForOsagoCompanyOrder) th).getPollingID());
        } else {
            if (th instanceof EmptyOsagoCompanyNameForOsagoPollingCompany) {
                EmptyOsagoCompanyNameForOsagoPollingCompany emptyOsagoCompanyNameForOsagoPollingCompany = (EmptyOsagoCompanyNameForOsagoPollingCompany) th;
                return RepositoryErrorDescriptionMapperKt.emptyOsagoCompanyNameForOsagoPollingCompanyDescription(emptyOsagoCompanyNameForOsagoPollingCompany.getPollingID(), emptyOsagoCompanyNameForOsagoPollingCompany.getSavedSearchID(), emptyOsagoCompanyNameForOsagoPollingCompany.getCompanyID(), emptyOsagoCompanyNameForOsagoPollingCompany.getProductID());
            } else if (th instanceof EmptyOsagoCompanyNameForOsagoListCompany) {
                EmptyOsagoCompanyNameForOsagoListCompany emptyOsagoCompanyNameForOsagoListCompany = (EmptyOsagoCompanyNameForOsagoListCompany) th;
                return RepositoryErrorDescriptionMapperKt.emptyOsagoCompanyNameForOsagoListCompanyDescription(emptyOsagoCompanyNameForOsagoListCompany.getPollingID(), emptyOsagoCompanyNameForOsagoListCompany.getSavedSearchID(), emptyOsagoCompanyNameForOsagoListCompany.getProductID());
            } else if (th instanceof EmptyProductCompanyNameForProductListCompany) {
                EmptyProductCompanyNameForProductListCompany emptyProductCompanyNameForProductListCompany = (EmptyProductCompanyNameForProductListCompany) th;
                return RepositoryErrorDescriptionMapperKt.emptyProductCompanyNameForProductListCompanyDescription(emptyProductCompanyNameForProductListCompany.getSavedSearchID(), emptyProductCompanyNameForProductListCompany.getProductID(), emptyProductCompanyNameForProductListCompany.getOrderID(), emptyProductCompanyNameForProductListCompany.getBankID());
            } else if (th instanceof EmptyProductCompanyNameForProductStatusCompany) {
                EmptyProductCompanyNameForProductStatusCompany emptyProductCompanyNameForProductStatusCompany = (EmptyProductCompanyNameForProductStatusCompany) th;
                return RepositoryErrorDescriptionMapperKt.emptyProductCompanyNameForProductStatusCompanyDescription(emptyProductCompanyNameForProductStatusCompany.getSavedSearchID(), emptyProductCompanyNameForProductStatusCompany.getProductID(), emptyProductCompanyNameForProductStatusCompany.getOrderID(), emptyProductCompanyNameForProductStatusCompany.getBankID());
            } else if (!(th instanceof WrongCreatedDateFormat)) {
                return null;
            } else {
                WrongCreatedDateFormat wrongCreatedDateFormat = (WrongCreatedDateFormat) th;
                return RepositoryErrorDescriptionMapperKt.wrongCreatedDateFormatErrorDescription(wrongCreatedDateFormat.getCardId(), wrongCreatedDateFormat.getChatId(), wrongCreatedDateFormat.getDateField());
            }
        }
        return errorDescription;
    }
}
