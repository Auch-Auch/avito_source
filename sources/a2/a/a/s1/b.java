package a2.a.a.s1;

import com.avito.android.passport_verification.PassportVerificationModel;
import com.avito.android.passport_verification.PassportVerificationModelImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ PassportVerificationModelImpl a;

    public b(PassportVerificationModelImpl passportVerificationModelImpl) {
        this.a = passportVerificationModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.subjects.BehaviorSubject */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        this.a.c.onNext(new PassportVerificationModel.Navigation.FinishWithError(false));
    }
}
