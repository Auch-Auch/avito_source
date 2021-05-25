package ru.sravni.android.bankproduct.domain.sravnierror;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "getUNPREDICITBLE_SRAVNI_ERROR", "()Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "UNPREDICITBLE_SRAVNI_ERROR", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class UnsupportErrorDescriptionMapperKt {
    @NotNull
    public static final ErrorDescription a = new ErrorDescription(1, OkListener.KEY_EXCEPTION, "Unsupported situation. No MAPPER and DOMAIN", null, 8, null);

    @NotNull
    public static final ErrorDescription getUNPREDICITBLE_SRAVNI_ERROR() {
        return a;
    }
}
