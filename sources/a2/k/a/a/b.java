package a2.k.a.a;

import androidx.appcompat.widget.PopupMenu;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends Observable<Unit> {
    public final PopupMenu a;

    public static final class a extends MainThreadDisposable implements PopupMenu.OnDismissListener {
        public final PopupMenu b;
        public final Observer<? super Unit> c;

        public a(@NotNull PopupMenu popupMenu, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "popupMenu");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = popupMenu;
            this.c = observer;
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnDismissListener
        public void onDismiss(@NotNull PopupMenu popupMenu) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "menu");
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnDismissListener(null);
        }
    }

    public b(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "view");
        this.a = popupMenu;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnDismissListener(aVar);
        }
    }
}
