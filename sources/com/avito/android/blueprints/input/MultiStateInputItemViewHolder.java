package com.avito.android.blueprints.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u001f\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0007J\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\u00020\u00052\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J%\u0010*\u001a\u00020\u00052\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010&H\u0016¢\u0006\u0004\b*\u0010)J\u001f\u0010,\u001a\u00020\u00052\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+H\u0016¢\u0006\u0004\b,\u0010-J#\u00100\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020\u00112\b\b\u0001\u0010/\u001a\u00020\u0011H\u0016¢\u0006\u0004\b0\u0010\u0015J\u001d\u00101\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0016¢\u0006\u0004\b1\u0010-J#\u00102\u001a\u00020\u00052\b\b\u0001\u0010.\u001a\u00020\u00112\b\b\u0001\u0010/\u001a\u00020\u0011H\u0016¢\u0006\u0004\b2\u0010\u0015J\u001d\u00103\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050+H\u0016¢\u0006\u0004\b3\u0010-J\u000f\u00104\u001a\u00020\u0005H\u0016¢\u0006\u0004\b4\u0010\u0017J\u000f\u00105\u001a\u00020\u0005H\u0016¢\u0006\u0004\b5\u0010\u0017J\u0017\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0017J\u0017\u0010?\u001a\u00020\u00052\u0006\u0010'\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J`\u0010G\u001a\u00020\u00052O\u0010'\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\u0011¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u0005\u0018\u00010AH\u0016¢\u0006\u0004\bG\u0010HJ\u0011\u0010I\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bI\u0010JR*\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010-R\u0018\u0010S\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010VR*\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010+8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bX\u0010L\u001a\u0004\bY\u0010N\"\u0004\bZ\u0010-R\u0018\u0010]\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010RR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006f"}, d2 = {"Lcom/avito/android/blueprints/input/MultiStateInputItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/input/MultiStateInputItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "value", "setValue", "setValueIfDistinct", "", "minLines", "maxLines", "setMultiLine", "(II)V", "setSingleLine", "()V", "", "selectionToEnd", "setSelectionToEndOnFocus", "(Z)V", "prefix", "setPrefix", "postfix", "setPostfix", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setFocusChangeListener", "Lkotlin/Function0;", "setOnViewTouchedListener", "(Lkotlin/jvm/functions/Function0;)V", "icon", "colorAttr", "setRightIcon", "setRightIconClickListener", "setLeftIcon", "setLeftIconClickListener", "onUnbind", "showKeyboard", "limit", "setMaxLength", "(I)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "Landroid/text/method/KeyListener;", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "text", "selStart", "selEnd", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "getText", "()Ljava/lang/CharSequence;", "w", "Lkotlin/jvm/functions/Function0;", "getAttachListener", "()Lkotlin/jvm/functions/Function0;", "setAttachListener", "attachListener", "u", "Landroid/text/TextWatcher;", "valueChangedTextWatcher", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "input", "x", "getDetachListener", "setDetachListener", "detachListener", VKApiConst.VERSION, "currentCustomTextWatcher", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateInputItemViewHolder extends BaseViewHolder implements MultiStateInputItemView {
    public final ComponentContainer s;
    public final Input t;
    public TextWatcher u;
    public TextWatcher v;
    @Nullable
    public Function0<Unit> w;
    @Nullable
    public Function0<Unit> x;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(MultiStateInputItemViewHolder multiStateInputItemViewHolder, Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateInputItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.container)");
        this.s = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.input)");
        this.t = (Input) findViewById2;
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.blueprints.input.MultiStateInputItemViewHolder$listener$1
            public final /* synthetic */ MultiStateInputItemViewHolder a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
                Function0<Unit> attachListener = this.a.getAttachListener();
                if (attachListener != null) {
                    attachListener.invoke();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
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
        return this.w;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public Function0<Unit> getDetachListener() {
        return this.x;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public CharSequence getText() {
        return this.t.m90getText();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        removeTextWatcher();
        this.t.setFocusChangeListener(null);
        Keyboards.hideKeyboard$default(this.s, false, 1, null);
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void removeTextWatcher() {
        TextWatcher textWatcher = this.v;
        if (textWatcher != null) {
            this.t.removeTextChangedListener(textWatcher);
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setAttachListener(@Nullable Function0<Unit> function0) {
        this.w = function0;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setDetachListener(@Nullable Function0<Unit> function0) {
        this.x = function0;
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        if (function1 != null) {
            this.t.setFocusChangeListener(new a(this, function1));
        } else {
            this.t.setFocusChangeListener(null);
        }
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setInputType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        Input.setFormatterType$default(this.t, formatterType, false, 2, null);
    }

    @Override // com.avito.android.util.FormattableInputView
    public void setKeyListener(@NotNull KeyListener keyListener) {
        Intrinsics.checkNotNullParameter(keyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setKeyListener(keyListener);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setLeftIcon(@DrawableRes int i, @AttrRes int i2) {
        this.t.setLeftIcon(i);
        Input input = this.t;
        input.setLeftIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setLeftIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setLeftIconListener(new b(function0));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setMaxLength(int i) {
        this.t.setMaxLength(i);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setMultiLine(int i, int i2) {
        this.t.setMultiLine(i2, i);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.s.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3) {
        this.t.setOnSelectionChangedListener(function3);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.u;
        if (textWatcher != null) {
            this.t.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.t;
            MultiStateInputItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 multiStateInputItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.blueprints.input.MultiStateInputItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1
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
            input.addTextChangedListener(multiStateInputItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1);
            this.u = multiStateInputItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnViewTouchedListener(@Nullable Function0<Unit> function0) {
        this.t.setTouchListener(function0 != null ? new c(function0) : null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPlaceholder(@Nullable String str) {
        this.t.setHint(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPostfix(@Nullable String str) {
        Input input = this.t;
        if (str == null) {
            str = "";
        }
        input.setPostfix(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setPrefix(@Nullable String str) {
        Input input = this.t;
        if (str == null) {
            str = "";
        }
        input.setPrefix(str);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setRightIcon(@DrawableRes int i, @AttrRes int i2) {
        this.t.setRightIcon(i);
        Input input = this.t;
        input.setRightIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setRightIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setRightIconListener(new d(function0));
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setSelectionToEndOnFocus(boolean z) {
        this.t.setSelectionToEndOnFocus(z);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setSingleLine() {
        this.t.setSingleLine();
    }

    @Override // com.avito.android.util.FormattableInputView, com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        TextWatcher textWatcher2 = this.v;
        if (textWatcher2 != null) {
            this.t.removeTextChangedListener(textWatcher2);
        }
        this.v = textWatcher;
        this.t.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setValue(@Nullable CharSequence charSequence) {
        Input.setText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setValueIfDistinct(@Nullable String str) {
        if (!Intrinsics.areEqual(str, this.t.getDeformattedText())) {
            this.t.setText(str, true);
        }
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.s, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.input.MultiStateInputItemView
    public void showKeyboard() {
        this.t.showKeyboard();
    }
}
