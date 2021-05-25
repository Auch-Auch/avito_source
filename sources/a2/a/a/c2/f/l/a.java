package a2.a.a.c2.f.l;

import androidx.fragment.app.Fragment;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionResultHandler;
import com.avito.android.profile_phones.phones_list.actions.PhoneActionsSheetDialogFragment;
import com.avito.android.profile_phones.phones_list.actions.items.ActionItem;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<ActionItem> {
    public final /* synthetic */ PhoneActionsSheetDialogFragment a;

    public a(PhoneActionsSheetDialogFragment phoneActionsSheetDialogFragment) {
        this.a = phoneActionsSheetDialogFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(ActionItem actionItem) {
        ActionItem actionItem2 = actionItem;
        Fragment targetFragment = this.a.getTargetFragment();
        if (!(targetFragment instanceof PhoneActionResultHandler)) {
            targetFragment = null;
        }
        PhoneActionResultHandler phoneActionResultHandler = (PhoneActionResultHandler) targetFragment;
        if (phoneActionResultHandler != null) {
            phoneActionResultHandler.handlePhoneAction(actionItem2.getPhone(), actionItem2.getAction());
        }
        this.a.dismiss();
    }
}
