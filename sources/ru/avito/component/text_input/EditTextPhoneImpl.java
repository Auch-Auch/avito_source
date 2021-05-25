package ru.avito.component.text_input;

import android.content.Context;
import android.view.View;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.design.widget.TextInputView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text_input.EditTextPhone;
import t6.r.a.j;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010x\u001a\u00020w\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\b\b\u0002\u00109\u001a\u000202¢\u0006\u0004\by\u0010zJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ2\u0010\u0013\u001a\u00020\u00122!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0016\u001a\u00020\u00122!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J2\u0010\u0019\u001a\u00020\u00122!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0014J2\u0010\u001b\u001a\u00020\u00022!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J#\u0010\"\u001a\u00020\u00022\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0 \"\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\fR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R?\u0010C\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u001cRD\u0010I\u001a0\u0012\f\u0012\n E*\u0004\u0018\u00010\u00170\u0017 E*\u0017\u0012\f\u0012\n E*\u0004\u0018\u00010\u00170\u0017\u0018\u00010D¢\u0006\u0002\bF0D¢\u0006\u0002\bF8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR$\u0010P\u001a\u00020J2\u0006\u0010K\u001a\u00020J8V@VX\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010T\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010\tR$\u0010Y\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR?\u0010]\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bZ\u0010?\u001a\u0004\b[\u0010A\"\u0004\b\\\u0010\u001cR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`R$\u0010d\u001a\u00020\u00172\u0006\u0010K\u001a\u00020\u00178V@VX\u000e¢\u0006\f\u001a\u0004\bb\u0010V\"\u0004\bc\u0010XR$\u0010\u000b\u001a\u00020J2\u0006\u0010K\u001a\u00020J8V@VX\u000e¢\u0006\f\u001a\u0004\be\u0010M\"\u0004\b\b\u0010OR?\u0010i\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bf\u0010?\u001a\u0004\bg\u0010A\"\u0004\bh\u0010\u001cRD\u0010m\u001a0\u0012\f\u0012\n E*\u0004\u0018\u00010\n0\n E*\u0017\u0012\f\u0012\n E*\u0004\u0018\u00010\n0\n\u0018\u00010j¢\u0006\u0002\bF0j¢\u0006\u0002\bF8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lRD\u0010o\u001a0\u0012\f\u0012\n E*\u0004\u0018\u00010\n0\n E*\u0017\u0012\f\u0012\n E*\u0004\u0018\u00010\n0\n\u0018\u00010D¢\u0006\u0002\bF0D¢\u0006\u0002\bF8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010HR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006{"}, d2 = {"Lru/avito/component/text_input/EditTextPhoneImpl;", "Lru/avito/component/text_input/EditTextPhone;", "", "show", "()V", "hide", "", "hintId", "setHint", "(I)V", "", "hint", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rawText", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/rxjava3/disposables/Disposable;", "setRawInputListener", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "formattedText", "setFormattedInputListener", "", "hasFocus", "setFocusChangeListener", "actionId", "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "requestFocus", "showKeyboard", "moveCursorToEnd", "", "hints", "setAutofillHints", "([Ljava/lang/String;)V", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "getMask", "()Ljava/lang/String;", "setMask", "mask", "Lcom/avito/android/design/widget/TextInputView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/TextInputView;", "textInputView", "Lru/avito/component/text_input/SimpleMaskFormatter;", "f", "Lru/avito/component/text_input/SimpleMaskFormatter;", "maskFormatter", "", "n", "C", "getPlaceholder", "()C", "setPlaceholder", "(C)V", InternalConstsKt.PLACEHOLDER, "Lru/avito/component/text_input/Mask;", "c", "Lru/avito/component/text_input/Mask;", "maskExtractor", "l", "Lkotlin/jvm/functions/Function1;", "getFocusListener", "()Lkotlin/jvm/functions/Function1;", "setFocusListener", "focusListener", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "i", "Lcom/jakewharton/rxrelay3/PublishRelay;", "focusStateRelay", "", "value", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "getImeOptions", "()I", "setImeOptions", "imeOptions", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", "k", "getFormattedListener", "setFormattedListener", "formattedListener", "Lru/avito/component/text_input/SpannableColorizer;", a2.g.r.g.a, "Lru/avito/component/text_input/SpannableColorizer;", "colorizer", "getEnable", "setEnable", "enable", "getHint", "j", "getRawListener", "setRawListener", "rawListener", "Lio/reactivex/rxjava3/core/Observable;", "e", "Lio/reactivex/rxjava3/core/Observable;", "rawRelay", "d", "formattedRelay", AuthSource.BOOKING_ORDER, "I", "maskPrefixColor", "Lru/avito/component/text_input/FocusStatefulCharSequencePositionFormatter;", "h", "Lru/avito/component/text_input/FocusStatefulCharSequencePositionFormatter;", "focusableFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Ljava/lang/String;C)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class EditTextPhoneImpl implements EditTextPhone {
    public final TextInputView a;
    public final int b;
    public final Mask c;
    public final PublishRelay<String> d;
    public final Observable<String> e;
    public final SimpleMaskFormatter f;
    public final SpannableColorizer g;
    public final FocusStatefulCharSequencePositionFormatter h;
    public final PublishRelay<Boolean> i;
    @Nullable
    public Function1<? super String, Unit> j;
    @Nullable
    public Function1<? super String, Unit> k;
    @Nullable
    public Function1<? super Boolean, Unit> l;
    @NotNull
    public String m;
    public char n;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Function1<String, Unit> rawListener = ((EditTextPhoneImpl) this.b).getRawListener();
                if (rawListener != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "it");
                    rawListener.invoke(str2);
                }
            } else if (i == 1) {
                String str3 = str;
                Function1<String, Unit> formattedListener = ((EditTextPhoneImpl) this.b).getFormattedListener();
                if (formattedListener != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "it");
                    formattedListener.invoke(str3);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ EditTextPhoneImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(EditTextPhoneImpl editTextPhoneImpl) {
            super(1);
            this.a = editTextPhoneImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            this.a.h.setFocused(booleanValue);
            this.a.a.resetText();
            this.a.i.accept(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditTextPhoneImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(EditTextPhoneImpl editTextPhoneImpl) {
            super(1);
            this.a = editTextPhoneImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.d.accept(str2);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<Boolean> {
        public final /* synthetic */ EditTextPhoneImpl a;

        public d(EditTextPhoneImpl editTextPhoneImpl) {
            this.a = editTextPhoneImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Function1<Boolean, Unit> focusListener = this.a.getFocusListener();
            if (focusListener != null) {
                Intrinsics.checkNotNullExpressionValue(bool2, "it");
                focusListener.invoke(bool2);
            }
        }
    }

    public static final class e<T, R> implements Function<String, String> {
        public final /* synthetic */ EditTextPhoneImpl a;

        public e(EditTextPhoneImpl editTextPhoneImpl) {
            this.a = editTextPhoneImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(String str) {
            String str2 = str;
            Mask mask = this.a.c;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            return Mask.rawText$default(mask, str2, null, 2, null).toString();
        }
    }

    public static final class f<T> implements Consumer<Boolean> {
        public final /* synthetic */ Function1 a;

        public f(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            function1.invoke(bool2);
        }
    }

    public static final class g<T> implements Consumer<String> {
        public final /* synthetic */ Function1 a;

        public g(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            function1.invoke(str2);
        }
    }

    public static final class h<T> implements Consumer<String> {
        public final /* synthetic */ Function1 a;

        public h(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            function1.invoke(str2);
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ EditTextPhoneImpl a;

        public i(EditTextPhoneImpl editTextPhoneImpl) {
            this.a = editTextPhoneImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.showKeyboard$default(this.a.a, 0, 1, null);
        }
    }

    public EditTextPhoneImpl(@NotNull View view, @NotNull String str, char c2) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "mask");
        this.m = str;
        this.n = c2;
        TextInputView textInputView = (TextInputView) view;
        this.a = textInputView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int colorByAttr = Contexts.getColorByAttr(context, R.attr.gray48);
        this.b = colorByAttr;
        this.c = new Mask(getMask(), getPlaceholder());
        PublishRelay<String> create = PublishRelay.create();
        this.d = create;
        Observable<R> map = create.map(new e(this));
        this.e = map;
        SimpleMaskFormatter simpleMaskFormatter = new SimpleMaskFormatter(getMask(), getPlaceholder());
        this.f = simpleMaskFormatter;
        SpannableColorizer spannableColorizer = new SpannableColorizer(colorByAttr);
        this.g = spannableColorizer;
        FocusStatefulCharSequencePositionFormatter focusStatefulCharSequencePositionFormatter = new FocusStatefulCharSequencePositionFormatter(new ColoredHeadDecoratingFormatter(getMask(), getPlaceholder(), spannableColorizer, simpleMaskFormatter), new UnfocusedStateFormatter(getMask(), getPlaceholder(), simpleMaskFormatter));
        this.h = focusStatefulCharSequencePositionFormatter;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        this.i = create2;
        textInputView.setMaxLines(1);
        textInputView.setInputType(3);
        textInputView.setFocusChangeListener(new b(this));
        textInputView.setImeOptions(268435462);
        textInputView.setTextChangeListener(new CharSequencePositionFormatterTextWatcher(focusStatefulCharSequencePositionFormatter, new c(this)));
        map.subscribe(new a(0, this));
        create.subscribe(new a(1, this));
        create2.subscribe(new d(this));
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<Integer> actionCallbacks() {
        return EditTextPhone.DefaultImpls.actionCallbacks(this);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<Unit> doneCallbacks() {
        return EditTextPhone.DefaultImpls.doneCallbacks(this);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<String> formattedCallbacks() {
        return EditTextPhone.DefaultImpls.formattedCallbacks(this);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public boolean getEnable() {
        return this.a.getEnable();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<Boolean, Unit> getFocusListener() {
        return this.l;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> */
    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<String, Unit> getFormattedListener() {
        return this.k;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public boolean getHasError() {
        return this.a.getHasError();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public CharSequence getHint() {
        return this.a.getHint();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public String getMask() {
        return this.m;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public char getPlaceholder() {
        return this.n;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> */
    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<String, Unit> getRawListener() {
        return this.j;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public CharSequence getText() {
        return this.a.getText();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void hide() {
        Views.hide(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void moveCursorToEnd() {
        this.a.moveCursorToEnd();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void requestFocus() {
        this.a.requestFocus();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setActionListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setActionListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hints");
        this.a.setAutofillHints((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setEnable(boolean z) {
        this.a.setEnable(z);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Disposable setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribe = this.i.subscribe(new f(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "focusStateRelay.subscribe { listener.invoke(it) }");
        return subscribe;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setFocusListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.l = function1;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Disposable setFormattedInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribe = this.d.subscribe(new g(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "formattedRelay.subscribe { listener.invoke(it) }");
        return subscribe;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setFormattedListener(@Nullable Function1<? super String, Unit> function1) {
        this.k = function1;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHasError(boolean z) {
        this.a.setHasError(z);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setHint(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setImeOptions(int i2) {
        this.a.setImeOptions(i2);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setMask(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m = str;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setPlaceholder(char c2) {
        this.n = c2;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Disposable setRawInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Disposable subscribe = this.e.subscribe(new h(function1));
        Intrinsics.checkNotNullExpressionValue(subscribe, "rawRelay.subscribe { listener.invoke(it) }");
        return subscribe;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setRawListener(@Nullable Function1<? super String, Unit> function1) {
        this.j = function1;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void show() {
        Views.show(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void showKeyboard() {
        this.a.post(new i(this));
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(int i2) {
        this.a.setHintResId(i2);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.a.setHint(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditTextPhoneImpl(View view, String str, char c2, int i2, j jVar) {
        this(view, (i2 & 2) != 0 ? "+7 ### ###-##-##" : str, (i2 & 4) != 0 ? '#' : c2);
    }
}
