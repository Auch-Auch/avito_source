package ru.avito.component.text_input;

import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ2\u0010\u0010\u001a\u00020\u00022!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u0011J2\u0010\u0014\u001a\u00020\u00022!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0011J2\u0010\u0016\u001a\u00020\u00022!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u0016\u0010\u0011J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H&¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H&¢\u0006\u0004\b\u001c\u0010\u0019J\u000f\u0010\u001d\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0012H&¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\u00022\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0!\"\u00020\u000bH&¢\u0006\u0004\b#\u0010$R\u001c\u0010\"\u001a\u00020%8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b\b\u0010(R\u001c\u0010,\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\tR\u001c\u0010\u000e\u001a\u00020%8&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010'\"\u0004\b.\u0010(R\u001c\u00101\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u0010*\"\u0004\b0\u0010\tR\u001c\u00105\u001a\u00020\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b2\u0010 \"\u0004\b3\u00104R\u001c\u00108\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b6\u0010*\"\u0004\b7\u0010\tR\u001c\u0010;\u001a\u00020\u00128&@&X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010 \"\u0004\b:\u00104¨\u0006<"}, d2 = {"Lru/avito/component/text_input/EditTextSingleLine;", "", "", "show", "()V", "hide", "", "hintId", "setHint", "(I)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "text", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTextChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "hasFocus", "setFocusChangeListener", "actionId", "setActionListener", "Lio/reactivex/rxjava3/core/Observable;", "actionCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "doneCallbacks", "textChangeCallbacks", "focusChangeCallbacks", "showKeyboard", "moveCursorToEnd", "isShown", "()Z", "", "hint", "setAutofillHints", "([Ljava/lang/String;)V", "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "getInputType", "()I", "setInputType", "inputType", "getText", "setText", "getTextLength", "setTextLength", "textLength", "getEnable", "setEnable", "(Z)V", "enable", "getImeOptions", "setImeOptions", "imeOptions", "getHasError", "setHasError", "hasError", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface EditTextSingleLine {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements ObservableOnSubscribe<Integer> {
            public final /* synthetic */ EditTextSingleLine a;

            /* renamed from: ru.avito.component.text_input.EditTextSingleLine$DefaultImpls$a$a  reason: collision with other inner class name */
            public static final class C0675a extends Lambda implements Function1<Integer, Unit> {
                public final /* synthetic */ ObservableEmitter a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0675a(ObservableEmitter observableEmitter) {
                    super(1);
                    this.a = observableEmitter;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Integer num) {
                    this.a.onNext(Integer.valueOf(num.intValue()));
                    return Unit.INSTANCE;
                }
            }

            public a(EditTextSingleLine editTextSingleLine) {
                this.a = editTextSingleLine;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
                this.a.setActionListener(new C0675a(observableEmitter));
            }
        }

        public static final class b<T> implements Predicate<Integer> {
            public static final b a = new b();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Predicate
            public boolean test(Integer num) {
                Integer num2 = num;
                return num2 != null && num2.intValue() == 6;
            }
        }

        public static final class c<T, R> implements Function<Integer, Unit> {
            public static final c a = new c();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Function
            public Unit apply(Integer num) {
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public static Observable<Integer> actionCallbacks(@NotNull EditTextSingleLine editTextSingleLine) {
            Observable<Integer> create = Observable.create(new a(editTextSingleLine));
            Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…mitter.onNext(it) }\n    }");
            return create;
        }

        @NotNull
        public static Observable<Unit> doneCallbacks(@NotNull EditTextSingleLine editTextSingleLine) {
            Observable<R> map = editTextSingleLine.actionCallbacks().filter(b.a).map(c.a);
            Intrinsics.checkNotNullExpressionValue(map, "actionCallbacks()\n      …E }\n        .map { Unit }");
            return map;
        }
    }

    @NotNull
    Observable<Integer> actionCallbacks();

    @NotNull
    Observable<Unit> doneCallbacks();

    @NotNull
    Observable<Boolean> focusChangeCallbacks();

    boolean getEnable();

    boolean getHasError();

    @NotNull
    CharSequence getHint();

    int getImeOptions();

    int getInputType();

    @NotNull
    CharSequence getText();

    int getTextLength();

    void hide();

    boolean isShown();

    void moveCursorToEnd();

    void setActionListener(@NotNull Function1<? super Integer, Unit> function1);

    void setAutofillHints(@NotNull String... strArr);

    void setEnable(boolean z);

    void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setHasError(boolean z);

    void setHint(@StringRes int i);

    void setHint(@NotNull CharSequence charSequence);

    void setImeOptions(int i);

    void setInputType(int i);

    void setText(@NotNull CharSequence charSequence);

    void setTextChangeListener(@NotNull Function1<? super String, Unit> function1);

    void setTextLength(int i);

    void show();

    void showKeyboard();

    @NotNull
    Observable<String> textChangeCallbacks();
}
