package com.avito.android.lib.design.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.jakewharton.rxbinding3.InitialValueObservable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a4\u0010\u0017\u001a\u00020\u0016*\u00020\u000e2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0004\b\u0017\u0010\u0018\u001a4\u0010\u0017\u001a\u00020\u0016*\u00020\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0004\b\u0017\u0010\u0019\u001a<\u0010\u001a\u001a\u00020\u0016*\u00020\u00002#\b\u0004\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"Lcom/avito/android/lib/design/input/Input;", "", "", "actions", "Lio/reactivex/rxjava3/core/Observable;", "actionsCallbacks", "(Lcom/avito/android/lib/design/input/Input;[I)Lio/reactivex/rxjava3/core/Observable;", "Lcom/jakewharton/rxbinding3/InitialValueObservable;", "", "textChanges", "(Lcom/avito/android/lib/design/input/Input;)Lcom/jakewharton/rxbinding3/InitialValueObservable;", "Lcom/jakewharton/rxbinding4/InitialValueObservable;", "textChangesRx3", "(Lcom/avito/android/lib/design/input/Input;)Lcom/jakewharton/rxbinding4/InitialValueObservable;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", "", "onTextChanged", "Landroid/text/TextWatcher;", "addTextChangedListener", "(Landroidx/appcompat/widget/AppCompatEditText;Lkotlin/jvm/functions/Function1;)Landroid/text/TextWatcher;", "(Lcom/avito/android/lib/design/input/Input;Lkotlin/jvm/functions/Function1;)Landroid/text/TextWatcher;", "addDeformattedTextChangedListener", "components_release"}, k = 2, mv = {1, 4, 2})
public final class InputExtensionsKt {

    public static final class a<T> implements ObservableOnSubscribe<Integer> {
        public final /* synthetic */ Input a;
        public final /* synthetic */ int[] b;

        /* renamed from: com.avito.android.lib.design.input.InputExtensionsKt$a$a  reason: collision with other inner class name */
        public static final class C0140a implements TextView.OnEditorActionListener {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            public C0140a(a aVar, ObservableEmitter observableEmitter) {
                this.a = aVar;
                this.b = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (!ArraysKt___ArraysKt.contains(this.a.b, i)) {
                    return false;
                }
                this.b.onNext(Integer.valueOf(i));
                return true;
            }
        }

        public a(Input input, int[] iArr) {
            this.a = input;
            this.b = iArr;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
            this.a.setOnEditorActionListener(new C0140a(this, observableEmitter));
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ Input a;

        public b(Input input) {
            this.a = input;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.setOnEditorActionListener(null);
        }
    }

    @NotNull
    public static final Observable<Integer> actionsCallbacks(@NotNull Input input, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(input, "$this$actionsCallbacks");
        Intrinsics.checkNotNullParameter(iArr, "actions");
        Observable<Integer> doFinally = Observable.create(new a(input, iArr)).doFinally(new b(input));
        Intrinsics.checkNotNullExpressionValue(doFinally, "Observable.create<Int> {…torActionListener(null) }");
        return doFinally;
    }

    @NotNull
    public static final TextWatcher addDeformattedTextChangedListener(@NotNull Input input, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(input, "$this$addDeformattedTextChangedListener");
        Intrinsics.checkNotNullParameter(function1, "onTextChanged");
        InputExtensionsKt$addDeformattedTextChangedListener$1 inputExtensionsKt$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.lib.design.input.InputExtensionsKt$addDeformattedTextChangedListener$1
            public String a;
            public final /* synthetic */ Input b;
            public final /* synthetic */ Function1 c;

            {
                this.b = r1;
                this.c = r2;
                this.a = r1.getDeformattedText();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                String deformattedText = this.b.getDeformattedText();
                if (!Intrinsics.areEqual(deformattedText, this.a)) {
                    this.c.invoke(deformattedText);
                    this.a = deformattedText;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        input.addTextChangedListener(inputExtensionsKt$addDeformattedTextChangedListener$1);
        return inputExtensionsKt$addDeformattedTextChangedListener$1;
    }

    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull AppCompatEditText appCompatEditText, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "$this$addTextChangedListener");
        Intrinsics.checkNotNullParameter(function1, "onTextChanged");
        SimpleTextWatcher simpleTextWatcher = new SimpleTextWatcher(appCompatEditText.getText(), function1);
        appCompatEditText.addTextChangedListener(simpleTextWatcher);
        return simpleTextWatcher;
    }

    @NotNull
    public static final InitialValueObservable<CharSequence> textChanges(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "$this$textChanges");
        return new InputTextObservable(input);
    }

    @NotNull
    public static final com.jakewharton.rxbinding4.InitialValueObservable<CharSequence> textChangesRx3(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "$this$textChangesRx3");
        return new InputTextObservable3(input);
    }

    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull Input input, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(input, "$this$addTextChangedListener");
        Intrinsics.checkNotNullParameter(function1, "onTextChanged");
        SimpleTextWatcher simpleTextWatcher = new SimpleTextWatcher(input.m90getText(), function1);
        input.addTextChangedListener(simpleTextWatcher);
        return simpleTextWatcher;
    }
}
