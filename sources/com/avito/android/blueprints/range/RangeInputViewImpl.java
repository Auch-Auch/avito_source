package com.avito.android.blueprints.range;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.blueprints.input.MultiStateInputItemView;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010U\u001a\u00020P\u0012\u0006\u0010O\u001a\u00020J¢\u0006\u0004\bc\u0010dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010#\u001a\u00020\u00042\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u00020\u00042\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b&\u0010$J\u001f\u0010(\u001a\u00020\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b(\u0010)J#\u0010,\u001a\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\u00102\b\b\u0001\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b,\u0010\u0014J\u001d\u0010-\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b-\u0010)J#\u0010.\u001a\u00020\u00042\b\b\u0001\u0010*\u001a\u00020\u00102\b\b\u0001\u0010+\u001a\u00020\u0010H\u0016¢\u0006\u0004\b.\u0010\u0014J\u001d\u0010/\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040'H\u0016¢\u0006\u0004\b/\u0010)J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0016J\u000f\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b1\u0010\u0016J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0010H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020%H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\u0016J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J`\u0010F\u001a\u00020\u00042O\u0010\"\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020\u0004\u0018\u00010@H\u0016¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\bH\u0010IR\u0019\u0010O\u001a\u00020J8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0019\u0010U\u001a\u00020P8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR*\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010)R\u0018\u0010^\u001a\u0004\u0018\u0001088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R*\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010'8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b_\u0010W\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010)¨\u0006e"}, d2 = {"Lcom/avito/android/blueprints/range/RangeInputViewImpl;", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "value", "setValue", "setValueIfDistinct", "", "minLines", "maxLines", "setMultiLine", "(II)V", "setSingleLine", "()V", "prefix", "setPrefix", "postfix", "setPostfix", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "setFocusChangeListener", "Lkotlin/Function0;", "setOnViewTouchedListener", "(Lkotlin/jvm/functions/Function0;)V", "icon", "colorAttr", "setRightIcon", "setRightIconClickListener", "setLeftIcon", "setLeftIconClickListener", "onUnbind", "showKeyboard", "limit", "setMaxLength", "(I)V", "selectionToEnd", "setSelectionToEndOnFocus", "(Z)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "Landroid/text/method/KeyListener;", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "text", "selStart", "selEnd", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "getText", "()Ljava/lang/CharSequence;", "Lcom/avito/android/lib/design/input/Input;", "e", "Lcom/avito/android/lib/design/input/Input;", "getInput", "()Lcom/avito/android/lib/design/input/Input;", "input", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "d", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "getContainer", "()Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getAttachListener", "()Lkotlin/jvm/functions/Function0;", "setAttachListener", "attachListener", AuthSource.SEND_ABUSE, "Landroid/text/TextWatcher;", "valueChangedTextWatcher", "c", "getDetachListener", "setDetachListener", "detachListener", "<init>", "(Lcom/avito/android/lib/design/component_container/ComponentContainer;Lcom/avito/android/lib/design/input/Input;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class RangeInputViewImpl implements MultiStateInputItemView {
    public TextWatcher a;
    @Nullable
    public Function0<Unit> b;
    @Nullable
    public Function0<Unit> c;
    @NotNull
    public final ComponentContainer d;
    @NotNull
    public final Input e;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            Function1 function1 = this.a;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(Boolean.valueOf(z));
            }
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Intrinsics.checkNotNullExpressionValue(motionEvent, "motionEvent");
            if (motionEvent.getAction() != 1) {
                return false;
            }
            this.a.invoke();
            return false;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public RangeInputViewImpl(@NotNull ComponentContainer componentContainer, @NotNull Input input) {
        Intrinsics.checkNotNullParameter(componentContainer, "container");
        Intrinsics.checkNotNullParameter(input, "input");
        this.d = componentContainer;
        this.e = input;
        componentContainer.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.blueprints.range.RangeInputViewImpl$listener$1
            public final /* synthetic */ RangeInputViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, VKApiConst.VERSION);
                Function0<Unit> attachListener = this.a.getAttachListener();
                if (attachListener != null) {
                    attachListener.invoke();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, VKApiConst.VERSION);
                Function0<Unit> detachListener = this.a.getDetachListener();
                if (detachListener != null) {
                    detachListener.invoke();
                }
            }
        });
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public Function0<Unit> getAttachListener() {
        return this.b;
    }

    @NotNull
    public final ComponentContainer getContainer() {
        return this.d;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public Function0<Unit> getDetachListener() {
        return this.c;
    }

    @NotNull
    public final Input getInput() {
        return this.e;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public CharSequence getText() {
        return this.e.m90getText();
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        removeTextWatcher();
        Keyboards.hideKeyboard$default(this.d, false, 1, null);
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void removeTextWatcher() {
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setAttachListener(@Nullable Function0<Unit> function0) {
        this.b = function0;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setDetachListener(@Nullable Function0<Unit> function0) {
        this.c = function0;
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showError$default(this.d, new int[]{this.e.getId()}, charSequence, null, 4, null);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.e.setFocusChangeListener(new a(function1));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setInputType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        Input.setFormatterType$default(this.e, formatterType, false, 2, null);
    }

    @Override // com.avito.android.util.FormattableInputView
    public void setKeyListener(@NotNull KeyListener keyListener) {
        Intrinsics.checkNotNullParameter(keyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setKeyListener(keyListener);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setLeftIcon(@DrawableRes int i, @AttrRes int i2) {
        this.e.setLeftIcon(i);
        Input input = this.e;
        input.setLeftIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setLeftIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setLeftIconListener(new b(function0));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setMaxLength(int i) {
        this.e.setMaxLength(i);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setMultiLine(int i, int i2) {
        this.e.setMultiLine(i2, i);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.d.showNormal(new int[]{this.e.getId()}, charSequence);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3) {
        this.e.setOnSelectionChangedListener(function3);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.a;
        if (textWatcher != null) {
            this.e.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.e;
            RangeInputViewImpl$$special$$inlined$addDeformattedTextChangedListener$1 rangeInputViewImpl$$special$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.blueprints.range.RangeInputViewImpl$$special$$inlined$addDeformattedTextChangedListener$1
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
            input.addTextChangedListener(rangeInputViewImpl$$special$$inlined$addDeformattedTextChangedListener$1);
            this.a = rangeInputViewImpl$$special$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnViewTouchedListener(@Nullable Function0<Unit> function0) {
        this.e.setTouchListener(function0 != null ? new c(function0) : null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPlaceholder(@Nullable String str) {
        this.e.setHint(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPostfix(@Nullable String str) {
        Input input = this.e;
        if (str == null) {
            str = "";
        }
        input.setPostfix(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPrefix(@Nullable String str) {
        Input input = this.e;
        if (str == null) {
            str = "";
        }
        input.setPrefix(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setRightIcon(@DrawableRes int i, @AttrRes int i2) {
        this.e.setRightIcon(i);
        Input input = this.e;
        input.setRightIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setRightIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.setRightIconListener(new d(function0));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setSelectionToEndOnFocus(boolean z) {
        this.e.setSelectionToEndOnFocus(z);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setSingleLine() {
        this.e.setSingleLine();
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.e.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.d.setTitle(str);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setValue(@Nullable CharSequence charSequence) {
        Input.setText$default(this.e, charSequence, false, 2, null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setValueIfDistinct(@Nullable String str) {
        String deformattedText = this.e.getDeformattedText();
        if (!Intrinsics.areEqual(str, deformattedText)) {
            this.e.setText(deformattedText, true);
        }
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarning$default(this.d, new int[]{this.e.getId()}, charSequence, null, 4, null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void showKeyboard() {
        this.e.showKeyboard();
    }
}
