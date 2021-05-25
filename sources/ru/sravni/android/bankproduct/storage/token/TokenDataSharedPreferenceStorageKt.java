package ru.sravni.android.bankproduct.storage.token;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0005\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002¨\u0006\u0006"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "decryptErrorDescription", AuthSource.SEND_ABUSE, "encryptErrorDescription", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class TokenDataSharedPreferenceStorageKt {
    public static final ErrorDescription a = new ErrorDescription(10, "encErr", "Error while encrypt", null, 8, null);
    public static final ErrorDescription b = new ErrorDescription(20, "decErr", "Error while decrypt", null, 8, null);
}
