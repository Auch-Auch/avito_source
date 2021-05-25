package a7.c.a.a.o.a.b.b;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ ProfileSmsViewModel a;

    public b(ProfileSmsViewModel profileSmsViewModel) {
        this.a = profileSmsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ProfileSmsViewModel profileSmsViewModel = this.a;
        Intrinsics.checkExpressionValueIsNotNull(th2, "it");
        ProfileSmsViewModel.access$mapThrowableToErrorAction(profileSmsViewModel, th2);
        this.a.o.logError(MessagePriority.ERROR, this.a.p.wrap(th2));
        IBaseAnalytic.DefaultImpls.sendFailEvent$default(this.a.r, "code", this.a.s.getPreviousModuleName(), null, 4, null);
    }
}
