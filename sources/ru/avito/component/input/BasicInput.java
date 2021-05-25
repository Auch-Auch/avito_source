package ru.avito.component.input;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.text.method.KeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxbinding4.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxrelay3.BehaviorRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\u0001GB)\b\u0002\u0012\u0006\u0010B\u001a\u00020?\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bE\u0010FJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u000bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020#8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010)\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001eR\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010%R\u0016\u00102\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010!R\u001e\u00108\u001a\n 5*\u0004\u0018\u000104048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010!RD\u0010>\u001a0\u0012\f\u0012\n 5*\u0004\u0018\u00010\b0\b 5*\u0017\u0012\f\u0012\n 5*\u0004\u0018\u00010\b0\b\u0018\u00010:¢\u0006\u0002\b;0:¢\u0006\u0002\b;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010!¨\u0006H"}, d2 = {"Lru/avito/component/input/BasicInput;", "Lru/avito/component/input/Input;", "", "text", "", "setText", "(Ljava/lang/String;)V", "setPlaceholder", "Lru/avito/component/input/InputState;", "state", "setState", "(Lru/avito/component/input/InputState;)V", "setStateWithAnimation", "bindTitle", "bindSubtitle", "", "singleLine", "setSingleLine", "(Z)V", "", "count", "setMinLinesCount", "(I)V", "needsMargin", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, "(Lru/avito/component/input/InputState;)I", "c", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "subtitleView", "d", "I", "bgWarning", "Lio/reactivex/rxjava3/core/Observable;", "getTextChanges", "()Lio/reactivex/rxjava3/core/Observable;", "textChanges", "e", "bgError", "titlesColorEnabled", "k", "titleView", "i", "Lio/reactivex/rxjava3/core/Observable;", "getStateChanges", "stateChanges", "getCurrentState", "()Lru/avito/component/input/InputState;", "currentState", "bgNormal", "Landroid/text/method/KeyListener;", "kotlin.jvm.PlatformType", "h", "Landroid/text/method/KeyListener;", "keyListener", "titlesColorDisabled", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "Lio/reactivex/rxjava3/annotations/NonNull;", g.a, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "statesRelay", "Landroid/widget/EditText;", "j", "Landroid/widget/EditText;", "editText", "f", "bgDisabled", "<init>", "(Landroid/widget/EditText;Landroid/widget/TextView;Landroid/widget/TextView;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BasicInput implements Input {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final BehaviorRelay<InputState> g;
    public final KeyListener h;
    @NotNull
    public final Observable<InputState> i;
    public final EditText j;
    public final TextView k;
    public final TextView l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/component/input/BasicInput$Companion;", "", "Landroid/view/View;", "view", "Lru/avito/component/input/BasicInput;", "createFromContainerView", "(Landroid/view/View;)Lru/avito/component/input/BasicInput;", "Landroid/widget/EditText;", "editText", "createFromEditText", "(Landroid/widget/EditText;)Lru/avito/component/input/BasicInput;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final BasicInput createFromContainerView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.input);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.EditText");
            View findViewById2 = view.findViewById(R.id.title);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            View findViewById3 = view.findViewById(R.id.subtitle);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            return new BasicInput((EditText) findViewById, (TextView) findViewById2, (TextView) findViewById3, null);
        }

        @NotNull
        public final BasicInput createFromEditText(@NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "editText");
            return new BasicInput(editText, null, null);
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            InputState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public static final class a<T, R> implements Function<TextViewAfterTextChangeEvent, String> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
            return textViewAfterTextChangeEvent.toString();
        }
    }

    public BasicInput(EditText editText, TextView textView, TextView textView2) {
        this.j = editText;
        this.k = textView;
        this.l = textView2;
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "editText.context");
        this.a = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
        Context context2 = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "editText.context");
        this.b = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.black);
        this.c = R.drawable.bg_input_normal;
        this.d = R.drawable.bg_input_warning;
        this.e = R.drawable.bg_input_error;
        this.f = R.drawable.bg_input_disabled;
        BehaviorRelay<InputState> create = BehaviorRelay.create();
        this.g = create;
        this.h = editText.getKeyListener();
        Observable<InputState> distinctUntilChanged = create.hide().distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "statesRelay.hide().distinctUntilChanged()");
        this.i = distinctUntilChanged;
        bindTitle(null);
        bindSubtitle(null);
    }

    public final int a(InputState inputState) {
        int ordinal = inputState.ordinal();
        if (ordinal == 0) {
            return this.c;
        }
        if (ordinal == 1) {
            return this.e;
        }
        if (ordinal == 2) {
            return this.d;
        }
        if (ordinal == 3) {
            return this.f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void b(boolean z) {
        int dimension = z ? (int) this.j.getResources().getDimension(R.dimen.input_margin_after_header) : 0;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).topMargin = dimension;
    }

    @Override // ru.avito.component.input.InputLabel
    public void bindSubtitle(@Nullable String str) {
        TextView textView;
        TextView textView2 = this.l;
        boolean z = false;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, str, false, 2, null);
        }
        TextView textView3 = this.k;
        if ((textView3 != null && Views.isVisible(textView3)) || ((textView = this.l) != null && Views.isVisible(textView))) {
            z = true;
        }
        b(z);
    }

    @Override // ru.avito.component.input.InputLabel
    public void bindTitle(@Nullable String str) {
        TextView textView;
        TextView textView2 = this.k;
        boolean z = false;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, str, false, 2, null);
        }
        TextView textView3 = this.k;
        if ((textView3 != null && Views.isVisible(textView3)) || ((textView = this.l) != null && Views.isVisible(textView))) {
            z = true;
        }
        b(z);
    }

    public final void c(InputState inputState) {
        if (inputState == InputState.DISABLED) {
            TextView textView = this.k;
            if (textView != null) {
                textView.setTextColor(this.a);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setTextColor(this.a);
                return;
            }
            return;
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setTextColor(this.b);
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setTextColor(this.b);
        }
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public InputState getCurrentState() {
        BehaviorRelay<InputState> behaviorRelay = this.g;
        Intrinsics.checkNotNullExpressionValue(behaviorRelay, "statesRelay");
        InputState value = behaviorRelay.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "statesRelay.value");
        return value;
    }

    @Override // ru.avito.component.input.Stateful
    @NotNull
    public Observable<InputState> getStateChanges() {
        return this.i;
    }

    @Override // ru.avito.component.input.Input
    @NotNull
    public Observable<String> getTextChanges() {
        Observable<R> map = RxTextView.afterTextChangeEvents(this.j).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "editText.afterTextChange…s().map { it.toString() }");
        return map;
    }

    @Override // ru.avito.component.input.Input
    public void setMinLinesCount(int i2) {
        this.j.setSingleLine(false);
        this.j.setOnFocusChangeListener(null);
        this.j.setMinLines(i2);
    }

    @Override // ru.avito.component.input.Input
    public void setPlaceholder(@Nullable String str) {
        this.j.setHint(str);
    }

    @Override // ru.avito.component.input.Input
    public void setSingleLine(boolean z) {
        this.j.setSingleLine(z);
        if (z) {
            this.j.setOnFocusChangeListener(new a7.a.a.d.a(this));
        } else {
            this.j.setOnFocusChangeListener(null);
        }
    }

    @Override // ru.avito.component.input.Stateful
    public void setState(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "state");
        EditText editText = this.j;
        InputState inputState2 = InputState.DISABLED;
        editText.setTextColor(inputState == inputState2 ? this.a : this.b);
        this.j.setBackgroundResource(a(inputState));
        this.j.setEnabled(inputState != inputState2);
        c(inputState);
        this.g.accept(inputState);
    }

    @Override // ru.avito.component.input.Stateful
    public void setStateWithAnimation(@NotNull InputState inputState) {
        Intrinsics.checkNotNullParameter(inputState, "state");
        int paddingLeft = this.j.getPaddingLeft();
        int paddingTop = this.j.getPaddingTop();
        int paddingRight = this.j.getPaddingRight();
        int paddingBottom = this.j.getPaddingBottom();
        EditText editText = this.j;
        InputState inputState2 = InputState.DISABLED;
        editText.setEnabled(inputState != inputState2);
        this.j.setTextColor(inputState == inputState2 ? this.a : this.b);
        c(inputState);
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{this.j.getBackground(), this.j.getResources().getDrawable(a(inputState), null)});
        Views.setBackgroundCompat(this.j, transitionDrawable);
        this.j.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        transitionDrawable.startTransition(400);
        this.g.accept(inputState);
    }

    @Override // ru.avito.component.input.Input
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.j.setText(str);
    }

    public /* synthetic */ BasicInput(EditText editText, TextView textView, TextView textView2, j jVar) {
        this(editText, textView, textView2);
    }
}
