package a7.a.a.c;

import com.avito.android.util.loading_state.LoadingProgress;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.component.floating_add_advert.AdvertShortcut;
import ru.avito.component.floating_add_advert.FloatingAddAdvertImpl;
public final class c<T> implements Consumer<LoadingProgress<? super List<? extends AdvertShortcut>>> {
    public final /* synthetic */ FloatingAddAdvertImpl a;

    public c(FloatingAddAdvertImpl floatingAddAdvertImpl) {
        this.a = floatingAddAdvertImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingProgress<? super List<? extends AdvertShortcut>> loadingProgress) {
        LoadingProgress<? super List<? extends AdvertShortcut>> loadingProgress2 = loadingProgress;
        boolean z = true;
        if (loadingProgress2 instanceof LoadingProgress.Error) {
            FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).hideProgress();
            String access$getErrorMessage = FloatingAddAdvertImpl.access$getErrorMessage(this.a, ((LoadingProgress.Error) loadingProgress2).getError());
            if (access$getErrorMessage != null) {
                if (access$getErrorMessage.length() != 0) {
                    z = false;
                }
                if (!z) {
                    FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).showError(access$getErrorMessage);
                    return;
                }
            }
            FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).showFatalError();
        } else if (loadingProgress2 instanceof LoadingProgress.Loaded) {
            FloatingAddAdvertImpl.access$setLockPosition$p(this.a, true);
            FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).hideProgress();
            FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).initButtons((List) ((LoadingProgress.Loaded) loadingProgress2).getData());
            FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).handleAdvertShortcutsLoaded();
        } else if (loadingProgress2 instanceof LoadingProgress.Loading) {
            CompositeDisposable access$getSubscriptions$p = FloatingAddAdvertImpl.access$getSubscriptions$p(this.a);
            Disposable subscribe = FloatingAddAdvertImpl.access$getAddAdvertView$p(this.a).showProgress().subscribe(new a(this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "addAdvertView\n          …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(access$getSubscriptions$p, subscribe);
        }
    }
}
