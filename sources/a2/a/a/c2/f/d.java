package a2.a.a.c2.f;

import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import com.avito.android.profile_phones.phones_list.PhonesListViewModel;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<PhoneListItem> {
    public final /* synthetic */ PhonesListFragment a;

    public d(PhonesListFragment phonesListFragment) {
        this.a = phonesListFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(PhoneListItem phoneListItem) {
        PhoneListItem phoneListItem2 = phoneListItem;
        PhonesListViewModel access$getPhonesListViewModel$p = PhonesListFragment.access$getPhonesListViewModel$p(this.a);
        Intrinsics.checkNotNullExpressionValue(phoneListItem2, "it");
        access$getPhonesListViewModel$p.onPhoneClicked(phoneListItem2);
    }
}
