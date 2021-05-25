package a2.a.a.e3.d.e;

import com.avito.android.lib.design.R;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.edit_info.item.manager_call.ManagerCallItem;
import com.avito.android.tariff.edit_info.viewmodel.BottomSheetParams;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt__CollectionsKt;
import t6.n.d;
public final class k<T> implements Consumer<ManagerCallItem> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public k(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(ManagerCallItem managerCallItem) {
        ManagerCallItem managerCallItem2 = managerCallItem;
        this.a.n.postValue(new BottomSheetParams(managerCallItem2.getTitle(), d.listOf(new AttributedText(managerCallItem2.getDescription(), CollectionsKt__CollectionsKt.emptyList())), managerCallItem2.getContactActionTitle(), null, new j(this, managerCallItem2), null, R.attr.buttonAccentLarge, Integer.valueOf(R.attr.ic_call20), 32, null));
    }
}
