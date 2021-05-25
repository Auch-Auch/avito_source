package a2.a.a.b2.f1;

import com.avito.android.account.Credentials;
import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<Maybe<Credentials.PasswordCredentials>> {
    public final /* synthetic */ PasswordChangePresenterImpl a;

    public g(PasswordChangePresenterImpl passwordChangePresenterImpl) {
        this.a = passwordChangePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Maybe<Credentials.PasswordCredentials> maybe) {
        Maybe<Credentials.PasswordCredentials> maybe2 = maybe;
        CompositeDisposable compositeDisposable = this.a.k;
        Intrinsics.checkNotNullExpressionValue(maybe2, "process");
        Disposable subscribe = InteropKt.toV2(maybe2).doOnSubscribe(new c(this)).doAfterTerminate(new d(this)).subscribe(new e(this), new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "process.toV2()\n         …      }\n                )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
