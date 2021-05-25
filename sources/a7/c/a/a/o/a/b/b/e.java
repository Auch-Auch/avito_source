package a7.c.a.a.o.a.b.b;

import io.reactivex.functions.Consumer;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ ProfileSmsViewModel a;
    public final /* synthetic */ IErrorLogger b;
    public final /* synthetic */ IThrowableWrapper c;

    public e(ProfileSmsViewModel profileSmsViewModel, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper) {
        this.a = profileSmsViewModel;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.b.logError(MessagePriority.ERROR, this.c.wrap(th));
        IBaseAnalytic.DefaultImpls.sendFailEvent$default(this.a.r, "code", this.a.s.getPreviousModuleName(), null, 4, null);
    }
}
