package a2.k.a.f;

import android.view.KeyEvent;
import android.widget.TextView;
import com.jakewharton.rxbinding3.internal.Preconditions;
import com.jakewharton.rxbinding3.widget.TextViewEditorActionEvent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class w extends Observable<TextViewEditorActionEvent> {
    public final TextView a;
    public final Function1<TextViewEditorActionEvent, Boolean> b;

    public static final class a extends MainThreadDisposable implements TextView.OnEditorActionListener {
        public final TextView b;
        public final Observer<? super TextViewEditorActionEvent> c;
        public final Function1<TextViewEditorActionEvent, Boolean> d;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding3.widget.TextViewEditorActionEvent, java.lang.Boolean> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull TextView textView, @NotNull Observer<? super TextViewEditorActionEvent> observer, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            Intrinsics.checkParameterIsNotNull(function1, "handled");
            this.b = textView;
            this.c = observer;
            this.d = function1;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.setOnEditorActionListener(null);
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(@NotNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
            Intrinsics.checkParameterIsNotNull(textView, "textView");
            TextViewEditorActionEvent textViewEditorActionEvent = new TextViewEditorActionEvent(this.b, i, keyEvent);
            try {
                if (isDisposed() || !this.d.invoke(textViewEditorActionEvent).booleanValue()) {
                    return false;
                }
                this.c.onNext(textViewEditorActionEvent);
                return true;
            } catch (Exception e) {
                this.c.onError(e);
                dispose();
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.jakewharton.rxbinding3.widget.TextViewEditorActionEvent, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull TextView textView, @NotNull Function1<? super TextViewEditorActionEvent, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(function1, "handled");
        this.a = textView;
        this.b = function1;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(@NotNull Observer<? super TextViewEditorActionEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer, this.b);
            observer.onSubscribe(aVar);
            this.a.setOnEditorActionListener(aVar);
        }
    }
}
