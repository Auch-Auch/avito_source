package a2.a.a.q0;

import androidx.lifecycle.Observer;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.extended_profile.ExtendedProfileViewImpl;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Observer<List<? extends ContactBar.Action>> {
    public final /* synthetic */ ExtendedProfileViewImpl a;

    public e(ExtendedProfileViewImpl extendedProfileViewImpl) {
        this.a = extendedProfileViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.advert_core.contactbar.AdvertContactsView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends ContactBar.Action> list) {
        List<? extends ContactBar.Action> list2 = list;
        AdvertContactsView advertContactsView = this.a.m;
        Intrinsics.checkNotNullExpressionValue(list2, "actions");
        advertContactsView.showContactBar(null, list2, new d(this));
    }
}
