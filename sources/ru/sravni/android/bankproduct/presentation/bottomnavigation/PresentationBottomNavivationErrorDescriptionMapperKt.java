package ru.sravni.android.bankproduct.presentation.bottomnavigation;

import a2.b.a.a.a;
import kotlin.Metadata;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.presentation.navigation.ScreenNotFoundError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class PresentationBottomNavivationErrorDescriptionMapperKt {
    public static final ErrorDescription access$screenNotFoundErrorDescription(ScreenNotFoundError screenNotFoundError) {
        StringBuilder L = a.L("Screen for dashboard not found. Reason : ");
        L.append(screenNotFoundError.getDescription());
        return new ErrorDescription(10, "ScrNotFound", L.toString(), null, 8, null);
    }
}
