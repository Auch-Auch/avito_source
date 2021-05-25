package ru.sravni.android.bankproduct.domain.sravnierror.entity;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", NotificationCompat.CATEGORY_ERROR, "", AuthSource.SEND_ABUSE, "(Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;)Ljava/lang/String;", "domain", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "errDescription", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;)Ljava/lang/String;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class SravniErrorKt {
    public static final String a(SravniError sravniError) {
        if (sravniError == null) {
            return "";
        }
        return b(sravniError.getDomain(), sravniError.getErrDescription()) + a(sravniError.getParent());
    }

    public static final String access$getErrorMessage(String str, ErrorDescription errorDescription, SravniError sravniError) {
        return b(str, errorDescription) + a(sravniError);
    }

    public static final String b(String str, ErrorDescription errorDescription) {
        return '[' + str + errorDescription.getCode() + " - " + errorDescription.getCodeName() + ']';
    }
}
