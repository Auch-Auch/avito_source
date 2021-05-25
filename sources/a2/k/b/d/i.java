package a2.k.b.d;

import android.view.View;
import android.view.ViewGroup;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.jakewharton.rxbinding4.view.ViewGroupHierarchyChangeEvent;
import com.jakewharton.rxbinding4.view.ViewGroupHierarchyChildViewAddEvent;
import com.jakewharton.rxbinding4.view.ViewGroupHierarchyChildViewRemoveEvent;
import com.vk.sdk.api.model.VKApiUserFull;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class i extends Observable<ViewGroupHierarchyChangeEvent> {
    public final ViewGroup a;

    public static final class a extends MainThreadDisposable implements ViewGroup.OnHierarchyChangeListener {
        public final ViewGroup b;
        public final Observer<? super ViewGroupHierarchyChangeEvent> c;

        public a(@NotNull ViewGroup viewGroup, @NotNull Observer<? super ViewGroupHierarchyChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = viewGroup;
            this.c = observer;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkParameterIsNotNull(view, "parent");
            Intrinsics.checkParameterIsNotNull(view2, VKApiUserFull.RelativeType.CHILD);
            if (!isDisposed()) {
                this.c.onNext(new ViewGroupHierarchyChildViewAddEvent(this.b, view2));
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(@NotNull View view, @NotNull View view2) {
            Intrinsics.checkParameterIsNotNull(view, "parent");
            Intrinsics.checkParameterIsNotNull(view2, VKApiUserFull.RelativeType.CHILD);
            if (!isDisposed()) {
                this.c.onNext(new ViewGroupHierarchyChildViewRemoveEvent(this.b, view2));
            }
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnHierarchyChangeListener(null);
        }
    }

    public i(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
        this.a = viewGroup;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super ViewGroupHierarchyChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setOnHierarchyChangeListener(aVar);
        }
    }
}
