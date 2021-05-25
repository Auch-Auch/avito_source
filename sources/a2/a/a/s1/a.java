package a2.a.a.s1;

import com.avito.android.passport_verification.PassportVerificationModelImpl;
import com.avito.android.passport_verification.SnsSdkNavigation;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<String> {
    public final /* synthetic */ PassportVerificationModelImpl a;

    public a(PassportVerificationModelImpl passportVerificationModelImpl) {
        this.a = passportVerificationModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.subjects.BehaviorSubject */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        BehaviorSubject behaviorSubject = this.a.b;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        behaviorSubject.onNext(new SnsSdkNavigation.OpenSnsSdk(str2, this.a.e, this.a.d));
    }
}
