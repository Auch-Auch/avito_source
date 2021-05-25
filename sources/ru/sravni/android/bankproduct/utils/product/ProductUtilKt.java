package ru.sravni.android.bankproduct.utils.product;

import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0019\"\u001c\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u001c\u0010\u0007\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\u0004\"\u001c\u0010\t\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0004\"\u001c\u0010\u000b\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0004\"\u001c\u0010\r\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0004\"\u001c\u0010\u000f\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0004\"\u001c\u0010\u0011\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0004\"\u001c\u0010\u0013\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0004\"\u001c\u0010\u0015\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0004\"\u001c\u0010\u0017\u001a\u00020\u00008\u0006@\u0006XD¢\u0006\f\n\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u0019"}, d2 = {"", "CREDIT_AVITO_CHAT_NAME", "Ljava/lang/String;", "getCREDIT_AVITO_CHAT_NAME", "()Ljava/lang/String;", "KASKO_CHAT_NAME", "getKASKO_CHAT_NAME", "CREDIT_RATING_CHAT_NAME", "getCREDIT_RATING_CHAT_NAME", "TRAVEL_INSURANCE_CHAT_NAME", "getTRAVEL_INSURANCE_CHAT_NAME", "MORTRAGE_CHAT_NAME", "getMORTRAGE_CHAT_NAME", "OSAGO_CHAT_NAME", "getOSAGO_CHAT_NAME", "CREDIT_CHAT_NAME", "getCREDIT_CHAT_NAME", "MORTRAGE_INSURANSE_CHAT_NAME", "getMORTRAGE_INSURANSE_CHAT_NAME", "DEBIT_CARDS_CHAT_NAME", "getDEBIT_CARDS_CHAT_NAME", "DEPOSIT_CHAT_NAME", "getDEPOSIT_CHAT_NAME", "PROPERTY_INSURANSE_CHAT_NAME", "getPROPERTY_INSURANSE_CHAT_NAME", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ProductUtilKt {
    @NotNull
    public static final String getCREDIT_AVITO_CHAT_NAME() {
        return "credit_avito";
    }

    @NotNull
    public static final String getCREDIT_CHAT_NAME() {
        return PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT;
    }

    @NotNull
    public static final String getCREDIT_RATING_CHAT_NAME() {
        return "creditraiting";
    }

    @NotNull
    public static final String getDEBIT_CARDS_CHAT_NAME() {
        return "debit_cards";
    }

    @NotNull
    public static final String getDEPOSIT_CHAT_NAME() {
        return "deposit";
    }

    @NotNull
    public static final String getKASKO_CHAT_NAME() {
        return "kasko";
    }

    @NotNull
    public static final String getMORTRAGE_CHAT_NAME() {
        return "mortrage";
    }

    @NotNull
    public static final String getMORTRAGE_INSURANSE_CHAT_NAME() {
        return "mortgage_insurance";
    }

    @NotNull
    public static final String getOSAGO_CHAT_NAME() {
        return "osago";
    }

    @NotNull
    public static final String getPROPERTY_INSURANSE_CHAT_NAME() {
        return "property_insurance";
    }

    @NotNull
    public static final String getTRAVEL_INSURANCE_CHAT_NAME() {
        return "travel_insurance";
    }
}
