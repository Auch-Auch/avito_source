package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.item.button.EditButtonAction;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<EditButtonAction> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public f(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(EditButtonAction editButtonAction) {
        EditButtonAction editButtonAction2 = editButtonAction;
        if (editButtonAction2 instanceof EditButtonAction.DeeplinkAction) {
            this.a.l.setValue(((EditButtonAction.DeeplinkAction) editButtonAction2).getDeepLink());
        } else if (editButtonAction2 instanceof EditButtonAction.DiscardChangesAction) {
            EditInfoViewModelImpl.access$discardTariffChange(this.a);
        }
    }
}
