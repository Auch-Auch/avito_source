package a2.a.a.c2.a;

import com.avito.android.code_confirmation.phone_confirm.PhoneCodeInfo;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.LandlinePhoneVerificationLink;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class k<T> implements Consumer<PhoneCodeInfo> {
    public final /* synthetic */ AddPhoneViewModelImpl a;
    public final /* synthetic */ String b;

    public k(AddPhoneViewModelImpl addPhoneViewModelImpl, String str) {
        this.a = addPhoneViewModelImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(PhoneCodeInfo phoneCodeInfo) {
        PhoneCodeInfo phoneCodeInfo2 = phoneCodeInfo;
        if (phoneCodeInfo2 instanceof PhoneCodeInfo.Ok) {
            this.a.d.postValue(AddPhoneViewModel.ScreenState.Ok.INSTANCE);
            PhoneCodeInfo.Ok ok = (PhoneCodeInfo.Ok) phoneCodeInfo2;
            this.a.e.postValue(new AddPhoneViewModel.RoutingAction.GoToPhoneConfirmation(this.b, ok.getLength(), ok.getTimeout()));
        } else if (phoneCodeInfo2 instanceof PhoneCodeInfo.Error) {
            this.a.d.postValue(new AddPhoneViewModel.ScreenState.Error(((PhoneCodeInfo.Error) phoneCodeInfo2).getMessage()));
        } else if (phoneCodeInfo2 instanceof PhoneCodeInfo.LandlinePhone) {
            PhoneCodeInfo.LandlinePhone landlinePhone = (PhoneCodeInfo.LandlinePhone) phoneCodeInfo2;
            DeepLink deeplink = landlinePhone.getDeeplink();
            if (!(deeplink instanceof LandlinePhoneVerificationLink)) {
                deeplink = null;
            }
            LandlinePhoneVerificationLink landlinePhoneVerificationLink = (LandlinePhoneVerificationLink) deeplink;
            if (landlinePhoneVerificationLink != null) {
                landlinePhoneVerificationLink.setPhone(this.b);
            }
            this.a.d.postValue(AddPhoneViewModel.ScreenState.Ok.INSTANCE);
            this.a.e.postValue(new AddPhoneViewModel.RoutingAction.GoByDeeplink(landlinePhone.getDeeplink()));
        }
    }
}
