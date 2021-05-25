package a2.a.a.a1.c0;

import com.avito.android.home.default_search_location.DefaultSearchLocationPresenterImpl;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<Boolean> {
    public final /* synthetic */ DefaultSearchLocationPresenterImpl a;

    public a(DefaultSearchLocationPresenterImpl defaultSearchLocationPresenterImpl) {
        this.a = defaultSearchLocationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Observable<T> observable;
        Boolean bool2 = bool;
        this.a.d.unlock();
        CompositeDisposable compositeDisposable = this.a.c;
        Intrinsics.checkNotNullExpressionValue(bool2, "permissionsGranted");
        if (bool2.booleanValue()) {
            observable = DefaultSearchLocationPresenterImpl.access$getDefaultLocation(this.a);
        } else {
            this.a.l.sendResolveCoordinates(null, "PERMISSION DENIED");
            this.a.f = true;
            this.a.o.setIsChangeCoordinates();
            observable = Single.never().toObservable();
        }
        Disposable subscribe = observable.subscribe(this.a.b, Functions.emptyConsumer());
        Intrinsics.checkNotNullExpressionValue(subscribe, "if (permissionsGranted) …sumer()\n                )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
