package ru.avito.component.text_input;

import androidx.annotation.StringRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\r\u001a\u00020\f2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006H'¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0010\u001a\u00020\f2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0006H'¢\u0006\u0004\b\u0010\u0010\u000eJ2\u0010\u0013\u001a\u00020\f2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u0006H'¢\u0006\u0004\b\u0013\u0010\u000eJ2\u0010\u0016\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\nH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\n2\b\b\u0001\u0010\u001d\u001a\u00020\u0014H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0003H&¢\u0006\u0004\b\u001e\u0010!J\u000f\u0010\"\u001a\u00020\nH&¢\u0006\u0004\b\"\u0010\u001bJ\u000f\u0010#\u001a\u00020\nH&¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u00020\nH&¢\u0006\u0004\b$\u0010\u001bJ#\u0010'\u001a\u00020\n2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030%\"\u00020\u0003H&¢\u0006\u0004\b'\u0010(R\u001c\u0010-\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R9\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0017R\u001c\u00105\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u001fR\u001c\u00109\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u0010!R\u001c\u0010?\u001a\u00020:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010 \u001a\u00020@8&@&X¦\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\b\u001e\u0010CR\u001c\u0010F\u001a\u00020@8&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010B\"\u0004\bE\u0010CR9\u0010I\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010/\"\u0004\bH\u0010\u0017R9\u0010L\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010/\"\u0004\bK\u0010\u0017R\u001c\u0010O\u001a\u00020\u00118&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u0010*\"\u0004\bN\u0010,¨\u0006P"}, d2 = {"Lru/avito/component/text_input/EditTextPhone;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "formattedCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rawText", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/rxjava3/disposables/Disposable;", "setRawInputListener", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "formattedText", "setFormattedInputListener", "", "hasFocus", "setFocusChangeListener", "", "actionId", "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "actionCallbacks", "doneCallbacks", "show", "()V", "hide", "hintId", "setHint", "(I)V", "hint", "(Ljava/lang/String;)V", "requestFocus", "showKeyboard", "moveCursorToEnd", "", "hints", "setAutofillHints", "([Ljava/lang/String;)V", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", "getFocusListener", "()Lkotlin/jvm/functions/Function1;", "setFocusListener", "focusListener", "getImeOptions", "()I", "setImeOptions", "imeOptions", "getMask", "()Ljava/lang/String;", "setMask", "mask", "", "getPlaceholder", "()C", "setPlaceholder", "(C)V", InternalConstsKt.PLACEHOLDER, "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "getText", "setText", "text", "getRawListener", "setRawListener", "rawListener", "getFormattedListener", "setFormattedListener", "formattedListener", "getEnable", "setEnable", "enable", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface EditTextPhone {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements ObservableOnSubscribe<Integer> {
            public final /* synthetic */ EditTextPhone a;

            /* renamed from: ru.avito.component.text_input.EditTextPhone$DefaultImpls$a$a  reason: collision with other inner class name */
            public static final class C0674a extends Lambda implements Function1<Integer, Unit> {
                public final /* synthetic */ ObservableEmitter a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0674a(ObservableEmitter observableEmitter) {
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

            public a(EditTextPhone editTextPhone) {
                this.a = editTextPhone;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
                this.a.setActionListener(new C0674a(observableEmitter));
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

        public static final class d<T> implements ObservableOnSubscribe<String> {
            public final /* synthetic */ EditTextPhone a;

            public static final class a extends Lambda implements Function1<String, Unit> {
                public final /* synthetic */ ObservableEmitter a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(ObservableEmitter observableEmitter) {
                    super(1);
                    this.a = observableEmitter;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(String str) {
                    String str2 = str;
                    Intrinsics.checkNotNullParameter(str2, "text");
                    this.a.onNext(str2);
                    return Unit.INSTANCE;
                }
            }

            public d(EditTextPhone editTextPhone) {
                this.a = editTextPhone;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter<String> observableEmitter) {
                this.a.setFormattedListener(new a(observableEmitter));
            }
        }

        @NotNull
        public static Observable<Integer> actionCallbacks(@NotNull EditTextPhone editTextPhone) {
            Observable<Integer> create = Observable.create(new a(editTextPhone));
            Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…mitter.onNext(it) }\n    }");
            return create;
        }

        @NotNull
        public static Observable<Unit> doneCallbacks(@NotNull EditTextPhone editTextPhone) {
            Observable<R> map = editTextPhone.actionCallbacks().filter(b.a).map(c.a);
            Intrinsics.checkNotNullExpressionValue(map, "actionCallbacks()\n      …E }\n        .map { Unit }");
            return map;
        }

        @NotNull
        public static Observable<String> formattedCallbacks(@NotNull EditTextPhone editTextPhone) {
            Observable<String> create = Observable.create(new d(editTextPhone));
            Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(text)\n        }\n    }");
            return create;
        }
    }

    @NotNull
    Observable<Integer> actionCallbacks();

    @NotNull
    Observable<Unit> doneCallbacks();

    @NotNull
    Observable<String> formattedCallbacks();

    boolean getEnable();

    @Nullable
    Function1<Boolean, Unit> getFocusListener();

    @Nullable
    Function1<String, Unit> getFormattedListener();

    boolean getHasError();

    @NotNull
    CharSequence getHint();

    int getImeOptions();

    @NotNull
    String getMask();

    char getPlaceholder();

    @Nullable
    Function1<String, Unit> getRawListener();

    @NotNull
    CharSequence getText();

    void hide();

    void moveCursorToEnd();

    void requestFocus();

    void setActionListener(@NotNull Function1<? super Integer, Unit> function1);

    void setAutofillHints(@NotNull String... strArr);

    void setEnable(boolean z);

    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    Disposable setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setFocusListener(@Nullable Function1<? super Boolean, Unit> function1);

    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    Disposable setFormattedInputListener(@NotNull Function1<? super String, Unit> function1);

    void setFormattedListener(@Nullable Function1<? super String, Unit> function1);

    void setHasError(boolean z);

    void setHint(@StringRes int i);

    void setHint(@NotNull CharSequence charSequence);

    void setHint(@NotNull String str);

    void setImeOptions(int i);

    void setMask(@NotNull String str);

    void setPlaceholder(char c);

    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    Disposable setRawInputListener(@NotNull Function1<? super String, Unit> function1);

    void setRawListener(@Nullable Function1<? super String, Unit> function1);

    void setText(@NotNull CharSequence charSequence);

    void show();

    void showKeyboard();
}
