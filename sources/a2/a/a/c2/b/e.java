package a2.a.a.c2.b;

import com.avito.android.code_confirmation.phone_confirm.ConfirmedCodeData;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<ConfirmedCodeData> {
    public final /* synthetic */ ConfirmPhoneViewModelImpl a;

    public e(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
        this.a = confirmPhoneViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(ConfirmedCodeData confirmedCodeData) {
        ConfirmedCodeData confirmedCodeData2 = confirmedCodeData;
        if (confirmedCodeData2 instanceof ConfirmedCodeData.Ok) {
            this.a.f.postValue(new ConfirmPhoneViewModel.RoutingAction.GoToPhonesList(this.a.g));
        } else if (confirmedCodeData2 instanceof ConfirmedCodeData.Error) {
            this.a.d.postValue(new ConfirmPhoneViewModel.ScreenState.InputError(((ConfirmedCodeData.Error) confirmedCodeData2).getMessage()));
        }
    }
}
