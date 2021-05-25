package a2.a.a.c2.a;

import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.phone_confirm.PhoneCodeInfo;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModelImpl;
import com.avito.android.remote.model.PhoneValidationResult;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class j<T, R> implements Function<PhoneValidationResult, SingleSource<? extends PhoneCodeInfo>> {
    public final /* synthetic */ AddPhoneViewModelImpl a;
    public final /* synthetic */ String b;

    public j(AddPhoneViewModelImpl addPhoneViewModelImpl, String str) {
        this.a = addPhoneViewModelImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends PhoneCodeInfo> apply(PhoneValidationResult phoneValidationResult) {
        PhoneValidationResult phoneValidationResult2 = phoneValidationResult;
        if (phoneValidationResult2 instanceof PhoneValidationResult.Ok) {
            return PhoneConfirmInteractor.DefaultImpls.requestCode$default(this.a.f, this.b, Source.PHONE_ADD, false, 4, null);
        }
        if (phoneValidationResult2 instanceof PhoneValidationResult.IncorrectData) {
            return Single.just(new PhoneCodeInfo.Error((String) CollectionsKt___CollectionsKt.firstOrNull(((PhoneValidationResult.IncorrectData) phoneValidationResult2).getMessages().values())));
        }
        throw new NoWhenBranchMatchedException();
    }
}
