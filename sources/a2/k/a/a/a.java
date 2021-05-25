package a2.k.a.a;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends Observable<MenuItem> {
    public final ActionMenuView a;

    /* renamed from: a2.k.a.a.a$a  reason: collision with other inner class name */
    public static final class C0088a extends MainThreadDisposable implements ActionMenuView.OnMenuItemClickListener {
        public final ActionMenuView b;
        public final Observer<? super MenuItem> c;

        public C0088a(@NotNull ActionMenuView actionMenuView, @NotNull Observer<? super MenuItem> observer) {
            Intrinsics.checkParameterIsNotNull(actionMenuView, "actionMenuView");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = actionMenuView;
            this.c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnMenuItemClickListener(null);
        }

        @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
        public boolean onMenuItemClick(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "item");
            if (isDisposed()) {
                return true;
            }
            this.c.onNext(menuItem);
            return true;
        }
    }

    public a(@NotNull ActionMenuView actionMenuView) {
        Intrinsics.checkParameterIsNotNull(actionMenuView, "view");
        this.a = actionMenuView;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super MenuItem> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            C0088a aVar = new C0088a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnMenuItemClickListener(aVar);
        }
    }
}
