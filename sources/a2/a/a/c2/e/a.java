package a2.a.a.c2.e;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenter;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementView;
import com.avito.android.remote.model.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PhoneManagementPresenterImpl a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PhoneManagementPresenterImpl phoneManagementPresenterImpl, Action action) {
        super(0);
        this.a = phoneManagementPresenterImpl;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeepLink deepLink = this.b.getDeepLink();
        PhoneManagementView phoneManagementView = this.a.a;
        if (phoneManagementView != null) {
            phoneManagementView.hideProgress();
        }
        PhoneManagementPresenter.Router router = this.a.b;
        if (router != null) {
            router.followDeepLink(deepLink);
        }
        PhoneManagementView phoneManagementView2 = this.a.a;
        if (phoneManagementView2 != null) {
            phoneManagementView2.closeUserDialog();
        }
        return Unit.INSTANCE;
    }
}
