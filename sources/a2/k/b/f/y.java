package a2.k.b.f;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding4.InitialValueObservable;
import com.jakewharton.rxbinding4.widget.TextViewTextChangeEvent;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class y extends InitialValueObservable<TextViewTextChangeEvent> {
    public final TextView a;

    public static final class a extends MainThreadDisposable implements TextWatcher {
        public final TextView b;
        public final Observer<? super TextViewTextChangeEvent> c;

        public a(@NotNull TextView textView, @NotNull Observer<? super TextViewTextChangeEvent> observer) {
            Intrinsics.checkParameterIsNotNull(textView, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = textView;
            this.c = observer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkParameterIsNotNull(editable, "editable");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(charSequence, "s");
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
            Intrinsics.checkParameterIsNotNull(charSequence, "s");
            if (!isDisposed()) {
                this.c.onNext(new TextViewTextChangeEvent(this.b, charSequence, i, i2, i3));
            }
        }
    }

    public y(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        this.a = textView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public TextViewTextChangeEvent getInitialValue() {
        TextView textView = this.a;
        CharSequence text = textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "view.text");
        return new TextViewTextChangeEvent(textView, text, 0, 0, 0);
    }

    @Override // com.jakewharton.rxbinding4.InitialValueObservable
    public void subscribeListener(@NotNull Observer<? super TextViewTextChangeEvent> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        a aVar = new a(this.a, observer);
        observer.onSubscribe(aVar);
        this.a.addTextChangedListener(aVar);
    }
}
