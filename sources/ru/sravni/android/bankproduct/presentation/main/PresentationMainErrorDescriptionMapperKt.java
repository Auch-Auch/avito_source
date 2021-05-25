package ru.sravni.android.bankproduct.presentation.main;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/sravnierror/entity/ErrorDescription;", "emptyNavActionErrorDescription", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class PresentationMainErrorDescriptionMapperKt {
    public static final ErrorDescription a = new ErrorDescription(20, "EmptyNavAction", "Multiple actions ", null, 8, null);

    public static final ErrorDescription access$navigateToStartHomeErrorDescription(String str) {
        return new ErrorDescription(40, "NavStrHo", a.d3("Unable to go to start screen from ", str, FormatterType.defaultDecimalSeparator), null, 8, null);
    }

    public static final ErrorDescription access$nullUriErrorErrorDescription(String str) {
        return new ErrorDescription(30, "nullUri", a.c3("Could not get uri for ", str), null, 8, null);
    }

    public static final ErrorDescription access$urlWithoutHttpErrorErrorDescription(String str) {
        return new ErrorDescription(31, "noHttplUrl", a.c3("Url don't start with http for ", str), null, 8, null);
    }
}
