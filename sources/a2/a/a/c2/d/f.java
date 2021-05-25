package a2.a.a.c2.d;

import androidx.lifecycle.Observer;
import com.avito.android.profile_phones.phone_action.PhoneActionFragment;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.Arguments;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import t6.n.d;
public final class f<T> implements Observer<PhoneActionViewModel.PhonesList> {
    public final /* synthetic */ PhoneActionFragment a;

    public f(PhoneActionFragment phoneActionFragment) {
        this.a = phoneActionFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(PhoneActionViewModel.PhonesList phonesList) {
        List list;
        PhoneActionViewModel.PhonesList phonesList2 = phonesList;
        PhoneActionFragment phoneActionFragment = this.a;
        String title = phonesList2.getTitle();
        List<ParcelableEntity<String>> phones = phonesList2.getPhones();
        ParcelableEntity<String> selectedPhone = phonesList2.getSelectedPhone();
        if (selectedPhone == null || (list = d.listOf(selectedPhone)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        PhoneActionFragment.access$showBottomSheetSelect(phoneActionFragment, new Arguments("phone_select", phones, list, title, false, false, false, false, true, false, null, false, false, null, 15872, null));
    }
}
