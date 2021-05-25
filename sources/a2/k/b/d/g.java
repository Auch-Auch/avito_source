package a2.k.b.d;

import android.view.DragEvent;
import android.view.View;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class g extends Observable<DragEvent> {
    public final View a;
    public final Function1<DragEvent, Boolean> b;

    public static final class a extends MainThreadDisposable implements View.OnDragListener {
        public final View b;
        public final Function1<DragEvent, Boolean> c;
        public final Observer<? super DragEvent> d;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.DragEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View view, @NotNull Function1<? super DragEvent, Boolean> function1, @NotNull Observer<? super DragEvent> observer) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = view;
            this.c = function1;
            this.d = observer;
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnDragListener(null);
        }

        @Override // android.view.View.OnDragListener
        public boolean onDrag(@NotNull View view, @NotNull DragEvent dragEvent) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            Intrinsics.checkParameterIsNotNull(dragEvent, "event");
            if (isDisposed()) {
                return false;
            }
            try {
                if (!this.c.invoke(dragEvent).booleanValue()) {
                    return false;
                }
                this.d.onNext(dragEvent);
                return true;
            } catch (Exception e) {
                this.d.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super android.view.DragEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull View view, @NotNull Function1<? super DragEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = view;
        this.b = function1;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super DragEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, this.b, observer);
            observer.onSubscribe(aVar);
            this.a.setOnDragListener(aVar);
        }
    }
}
