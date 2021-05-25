package a2.a.a.c2.e;

import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PhoneManagementPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        super(0);
        this.a = phoneManagementPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PhoneManagementView phoneManagementView = this.a.a;
        if (phoneManagementView != null) {
            phoneManagementView.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
