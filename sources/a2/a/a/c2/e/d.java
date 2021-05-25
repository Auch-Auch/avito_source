package a2.a.a.c2.e;

import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementView;
import io.reactivex.functions.Action;
public final class d implements Action {
    public final /* synthetic */ PhoneManagementPresenterImpl a;

    public d(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        this.a = phoneManagementPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        PhoneManagementPresenterImpl.access$clearFieldErrors(this.a);
        PhoneManagementView phoneManagementView = this.a.a;
        if (phoneManagementView != null) {
            phoneManagementView.hideProgress();
        }
    }
}
