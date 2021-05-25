package a7.c.a.a.o.a.b.b;

import io.reactivex.functions.Consumer;
import kotlin.text.StringsKt__StringsKt;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
import ru.sravni.android.bankproduct.utils.sms.SmsInfo;
public final class d<T> implements Consumer<SmsInfo> {
    public final /* synthetic */ ProfileSmsViewModel a;

    public d(ProfileSmsViewModel profileSmsViewModel) {
        this.a = profileSmsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SmsInfo smsInfo) {
        this.a.getSmsInsertedText().setValue(StringsKt__StringsKt.removePrefix(smsInfo.getSmsText(), (CharSequence) this.a.q));
    }
}
