package a7.c.a.a.o.a.b.b;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
import ru.sravni.android.bankproduct.utils.sms.SmsInfo;
public final class c<T> implements Predicate<SmsInfo> {
    public final /* synthetic */ ProfileSmsViewModel a;

    public c(ProfileSmsViewModel profileSmsViewModel) {
        this.a = profileSmsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(SmsInfo smsInfo) {
        SmsInfo smsInfo2 = smsInfo;
        Intrinsics.checkParameterIsNotNull(smsInfo2, "it");
        return ProfileSmsViewModel.access$checkSms(this.a, smsInfo2);
    }
}
