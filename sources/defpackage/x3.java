package defpackage;

import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementView;
import io.reactivex.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: x3  reason: default package */
public final class x3 implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public x3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            PhoneManagementView phoneManagementView = ((PhoneManagementPresenterImpl) this.b).a;
            if (phoneManagementView != null) {
                phoneManagementView.hideProgress();
            }
        } else if (i == 1) {
            PhoneManagementPresenterImpl.access$onPhoneReplaced((PhoneManagementPresenterImpl) this.b);
        } else {
            throw null;
        }
    }
}
