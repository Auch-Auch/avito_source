package a2.a.a.b2.f1;

import com.avito.android.profile.password_change.PasswordChangePresenterImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class k<T> implements Consumer<Maybe<Unit>> {
    public final /* synthetic */ PasswordChangePresenterImpl a;
    public final /* synthetic */ String b;

    public k(PasswordChangePresenterImpl passwordChangePresenterImpl, String str) {
        this.a = passwordChangePresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Maybe<Unit> maybe) {
        Maybe<Unit> maybe2 = maybe;
        CompositeDisposable compositeDisposable = this.a.k;
        Intrinsics.checkNotNullExpressionValue(maybe2, "process");
        Disposable subscribe = InteropKt.toV2(maybe2).subscribe(new i(this), new j(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "process.toV2()\n         …      }\n                )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
