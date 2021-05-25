package a2.k.a.f;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding3.InitialValueObservable;
import com.jakewharton.rxbinding3.widget.TextViewAfterTextChangeEvent;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class u extends InitialValueObservable<TextViewAfterTextChangeEvent> {
    public final TextView a;

    public static final class a extends MainThreadDisposable implements TextWatcher {
        public final TextView b;
        public final Observer<? super TextViewAfterTextChangeEvent> c;

        public a(@NotNull TextView textView, @NotNull Observer<? super TextViewAfterTextChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = textView;
            this.c = observer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkParameterIsNotNull(editable, "s");
            this.c.onNext(new TextViewAfterTextChangeEvent(this.b, editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(charSequence, "charSequence");
        }

        @Override // io.reactivex.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(charSequence, "charSequence");
        }
    }

    public u(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.a = textView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public TextViewAfterTextChangeEvent getInitialValue() {
        TextView textView = this.a;
        return new TextViewAfterTextChangeEvent(textView, textView.getEditableText());
    }

    @Override // com.jakewharton.rxbinding3.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super TextViewAfterTextChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        a aVar = new a(this.a, observer);
        observer.onSubscribe(aVar);
        this.a.addTextChangedListener(aVar);
    }
}
