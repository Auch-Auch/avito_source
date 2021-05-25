package com.avito.android.blueprints.publish.tagged_input;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.ui.widget.tagged_input.TagsConsumerView;
import com.avito.android.ui.widget.tagged_input.TagsListView;
import com.avito.android.ui.widget.tagged_input.TagsListViewImpl;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.util.Contexts;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010u\u001a\u00020t\u0012\u0006\u0010v\u001a\u00020\u0003¢\u0006\u0004\bw\u0010xJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b%\u0010\u0012J%\u0010'\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u001fJ\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u001dJ`\u00102\u001a\u00020\b2O\u0010\f\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\b\u0018\u00010,H\u0016¢\u0006\u0004\b2\u00103J%\u00105\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\b\u0018\u00010&H\u0016¢\u0006\u0004\b5\u0010(J\u001d\u00106\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0016¢\u0006\u0004\b6\u0010\u000eJ\u000f\u00107\u001a\u00020\bH\u0016¢\u0006\u0004\b7\u0010\u001fJ\u0017\u00108\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000fH\u0016¢\u0006\u0004\b8\u0010\u0012J\u0017\u00109\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000fH\u0016¢\u0006\u0004\b9\u0010\u0012J\u0017\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010\u001fJ\u0011\u0010?\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016¢\u0006\u0004\bA\u0010\u000eJ\u0018\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0001¢\u0006\u0004\bD\u0010EJ(\u0010K\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020IH\u0001¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\bH\u0001¢\u0006\u0004\bM\u0010\u001fJ \u0010N\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020IH\u0001¢\u0006\u0004\bN\u0010OJ0\u0010Q\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020I2\u0006\u0010P\u001a\u000204H\u0001¢\u0006\u0004\bQ\u0010RJ\u0018\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u000204H\u0001¢\u0006\u0004\bT\u0010UJ \u0010V\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020IH\u0001¢\u0006\u0004\bV\u0010OR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR*\u0010`\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010\u000eR\u0018\u0010c\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010\\R*\u0010i\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bf\u0010\\\u001a\u0004\bg\u0010^\"\u0004\bh\u0010\u000eR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010bR\u001c\u0010s\u001a\b\u0012\u0004\u0012\u0002040p8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bq\u0010r¨\u0006y"}, d2 = {"Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemView;", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView;", "Lcom/avito/android/ui/widget/tagged_input/TagsListView;", "", "icon", "colorAttr", "", "setRightIcon", "(II)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRightIconClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "value", "setValue", "minLines", "setMultiLine", "(I)V", "setSingleLine", "()V", "Lcom/avito/android/lib/design/input/FormatterType;", "inputType", "setInputType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "Lkotlin/Function1;", "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "showKeyboard", "limit", "setMaxLength", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "text", "selStart", "selEnd", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "", "setFocusChangeListener", "setOnUnbindListener", "onUnbind", "setText", "insertText", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "getText", "()Ljava/lang/CharSequence;", "setOnViewTouchedListener", "Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;", "textInserter", "attachTextInserter", "(Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView$TextInserter;)V", "itemId", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "tagsViewModel", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "bindTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "detachTextInserter", "unbind", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;)V", "tagListImmutable", "bindTagsListTo", "(Ljava/lang/String;Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;Landroidx/lifecycle/LifecycleOwner;Z)V", "singleLined", "setTagListStyle", "(Z)V", "unbindTagsList", "Lcom/avito/android/lib/design/input/Input;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/input/Input;", "input", "x", "Lkotlin/jvm/functions/Function0;", "getAttachListener", "()Lkotlin/jvm/functions/Function0;", "setAttachListener", "attachListener", "t", "Landroid/text/TextWatcher;", "currentCustomTextWatcher", "w", "unbindListener", "y", "getDetachListener", "setDetachListener", "detachListener", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "u", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "container", "s", "valueChangedTextWatcher", "Lio/reactivex/Observable;", "getTagsVisible", "()Lio/reactivex/Observable;", "tagsVisible", "Landroid/view/View;", "view", "tagsConsumerView", "<init>", "(Landroid/view/View;Lcom/avito/android/ui/widget/tagged_input/TagsConsumerView;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateInputWithTagsItemViewImpl extends BaseViewHolder implements MultiStateInputWithTagsItemView, TagsConsumerView, TagsListView {
    public final /* synthetic */ TagsListViewImpl A;
    public TextWatcher s;
    public TextWatcher t;
    public final ComponentContainer u;
    public final Input v;
    public Function0<Unit> w;
    @Nullable
    public Function0<Unit> x;
    @Nullable
    public Function0<Unit> y;
    public final /* synthetic */ TagsConsumerView z;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(MultiStateInputWithTagsItemViewImpl multiStateInputWithTagsItemViewImpl, Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
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

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateInputWithTagsItemViewImpl(@NotNull View view, @NotNull TagsConsumerView tagsConsumerView) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tagsConsumerView, "tagsConsumerView");
        this.z = tagsConsumerView;
        View findViewById = view.findViewById(R.id.tags);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.A = new TagsListViewImpl((RecyclerView) findViewById, R.dimen.tags_horizontal_side_padding);
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.u = (ComponentContainer) findViewById2;
        View findViewById3 = view.findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.input)");
        this.v = (Input) findViewById3;
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) { // from class: com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemViewImpl$listener$1
            public final /* synthetic */ MultiStateInputWithTagsItemViewImpl a;

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

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void attachTextInserter(@NotNull TagsConsumerView.TextInserter textInserter) {
        Intrinsics.checkNotNullParameter(textInserter, "textInserter");
        this.z.attachTextInserter(textInserter);
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    public void bindTagsListTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(tagsViewModel, "tagsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.A.bindTagsListTo(str, tagsViewModel, lifecycleOwner, z2);
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void bindTo(@NotNull String str, @NotNull TagsViewModel tagsViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(tagsViewModel, "tagsViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.z.bindTo(str, tagsViewModel, lifecycleOwner);
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void detachTextInserter() {
        this.z.detachTextInserter();
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public Function0<Unit> getAttachListener() {
        return this.x;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public Function0<Unit> getDetachListener() {
        return this.y;
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    @NotNull
    public Observable<Boolean> getTagsVisible() {
        return this.A.getTagsVisible();
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    @Nullable
    public CharSequence getText() {
        return this.v.m90getText();
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView.TextInserter
    public void insertText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (this.v.m90getText() == null) {
            Input.setText$default(this.v, "", false, 2, null);
        }
        Editable text = this.v.m90getText();
        if (text != null) {
            if (!this.v.hasFocus()) {
                Selection.setSelection(text, text.length());
            }
            int selectionStart = Selection.getSelectionStart(text);
            int selectionEnd = Selection.getSelectionEnd(text);
            if (selectionEnd > selectionStart) {
                Selection.setSelection(text.replace(selectionStart, selectionEnd, str), e.coerceIn(str.length() + selectionStart, 0, text.length()));
            } else {
                Selection.setSelection(text.insert(selectionStart, str), e.coerceIn(str.length() + selectionStart, 0, text.length()));
            }
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Keyboards.hideKeyboard$default(this.u, false, 1, null);
        Function0<Unit> function0 = this.w;
        if (function0 != null) {
            function0.invoke();
        }
        this.w = null;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void removeTextWatcher() {
        TextWatcher textWatcher = this.t;
        if (textWatcher != null) {
            this.v.removeTextChangedListener(textWatcher);
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setAttachListener(@Nullable Function0<Unit> function0) {
        this.x = function0;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setDetachListener(@Nullable Function0<Unit> function0) {
        this.y = function0;
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.u, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        if (function1 != null) {
            this.v.setFocusChangeListener(new a(this, function1));
        } else {
            this.v.setFocusChangeListener(null);
        }
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setInputType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "inputType");
        Input.setFormatterType$default(this.v, formatterType, false, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setMaxLength(int i) {
        this.v.setMaxLength(i);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setMultiLine(int i) {
        Input.setMultiLine$default(this.v, 0, i, 1, null);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.u.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3) {
        this.v.setOnSelectionChangedListener(function3);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setOnUnbindListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = function0;
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.s;
        if (textWatcher != null) {
            this.v.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.v;
            MultiStateInputWithTagsItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1 multiStateInputWithTagsItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1
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
            input.addTextChangedListener(multiStateInputWithTagsItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1);
            this.s = multiStateInputWithTagsItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setOnViewTouchedListener(@Nullable Function0<Unit> function0) {
        this.v.setTouchListener(function0 != null ? new b(function0) : null);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setPlaceholder(@Nullable String str) {
        this.v.setHint(str);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setRightIcon(int i, int i2) {
        this.v.setRightIcon(i);
        Input input = this.v;
        input.setRightIconColor(Contexts.getColorByAttr(input.getContext(), i2));
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setRightIconClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v.setRightIconListener(new c(function0));
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setSingleLine() {
        this.v.setSingleLine();
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    public void setTagListStyle(boolean z2) {
        this.A.setTagListStyle(z2);
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView.TextInserter
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        setValue(str);
        Editable text = this.v.m90getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        TextWatcher textWatcher2 = this.t;
        if (textWatcher2 != null) {
            this.v.removeTextChangedListener(textWatcher2);
        }
        this.t = textWatcher;
        this.v.addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setTitle(@Nullable String str) {
        this.u.setTitle(str);
    }

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    public void setValue(@Nullable CharSequence charSequence) {
        Input.setText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.u, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemView
    public void showKeyboard() {
        this.v.showKeyboard();
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsConsumerView
    public void unbind(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.z.unbind(str, lifecycleOwner);
    }

    @Override // com.avito.android.ui.widget.tagged_input.TagsListView
    public void unbindTagsList(@NotNull String str, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.A.unbindTagsList(str, lifecycleOwner);
    }
}
