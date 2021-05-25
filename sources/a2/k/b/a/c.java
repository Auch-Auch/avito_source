package a2.k.b.a;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.jakewharton.rxbinding4.internal.Preconditions;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class c extends Observable<MenuItem> {
    public final PopupMenu a;

    public static final class a extends MainThreadDisposable implements PopupMenu.OnMenuItemClickListener {
        public final PopupMenu b;
        public final Observer<? super MenuItem> c;

        public a(@NotNull PopupMenu popupMenu, @NotNull Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull(popupMenu, "popupMenu");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = popupMenu;
            this.c = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnMenuItemClickListener(null);
        }

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return true;
            }
            this.c.onNext(menuItem);
            return true;
        }
    }

    public c(@NotNull PopupMenu popupMenu) {
        Intrinsics.checkParameterIsNotNull(popupMenu, "view");
        this.a = popupMenu;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnMenuItemClickListener(aVar);
        }
    }
}
