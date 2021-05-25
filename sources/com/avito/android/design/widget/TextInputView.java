package com.avito.android.design.widget;

import a2.g.r.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text_input.TextPainter;
import t6.r.a.j;
import t6.v.e;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input(context, attrs, defStyleAttr)", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0001B.\b\u0007\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u000e¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\tJ#\u0010!\u001a\u00020\u00052\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001e\"\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\tJ\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b(\u0010)J7\u0010/\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000eH\u0014¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00122\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b9\u00108R$\u0010 \u001a\u00020:2\u0006\u0010;\u001a\u00020:8V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010E\u001a\u0004\u0018\u00010@2\b\u0010;\u001a\u0004\u0018\u00010@8F@FX\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR?\u0010P\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u0005\u0018\u00010F8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR+\u0010X\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\u00128V@VX\u0002¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR.\u0010c\u001a\u0004\u0018\u00010\\2\b\u0010;\u001a\u0004\u0018\u00010\\8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010g\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010\u001cR*\u0010k\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e8\u0016@VX\u000e¢\u0006\u0012\n\u0004\bh\u0010Z\u001a\u0004\bi\u0010e\"\u0004\bj\u0010\u001cR\u0016\u0010m\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010ZR?\u0010r\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020\u0005\u0018\u00010F8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bo\u0010K\u001a\u0004\bp\u0010M\"\u0004\bq\u0010OR$\u0010u\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\bs\u0010e\"\u0004\bt\u0010\u001cR$\u0010x\u001a\u00020\u00122\u0006\u0010;\u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\bv\u0010U\"\u0004\bw\u0010WR\u0016\u0010{\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010zR\u0016\u0010~\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010}R&\u0010\u0001\u001a\u00020:2\u0006\u0010;\u001a\u00020:8V@VX\u000e¢\u0006\r\u001a\u0004\b\u0010=\"\u0005\b\u0001\u0010?R&\u0010\u0001\u001a\u00020\u00128\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\b\u0010\u0001\u001a\u0005\b\u0001\u0010U\"\u0005\b\u0001\u0010WR.\u0010\u0001\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000e8\u0016@VX\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010Z\u001a\u0005\b\u0001\u0010e\"\u0005\b\u0001\u0010\u001cR/\u0010\u0001\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00038B@BX\u0002¢\u0006\u0015\n\u0004\b\f\u0010S\u001a\u0006\b\u0001\u0010\u0001\"\u0005\b\u0001\u0010\u0007R\"\u0010\u0001\u001a\u00030\u00018B@\u0002X\u0002¢\u0006\u000f\n\u0005\b\u0018\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/design/widget/TextInputView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/TextInput;", "Landroid/widget/EditText;", "editText", "", "setEditView", "(Landroid/widget/EditText;)V", "e", "()V", "", "target", AuthSource.SEND_ABUSE, "(F)V", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "c", "(I)Landroid/widget/EditText;", "", "isPressed", "", AuthSource.BOOKING_ORDER, "(Z)[I", "condition", "d", "(IZ)I", "stringId", "setHintResId", "(I)V", "moveCursorToEnd", "", "", "hint", "setAutofillHints", "([Ljava/lang/String;)V", "resetText", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "changed", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "", "value", "getHint", "()Ljava/lang/CharSequence;", "setHint", "(Ljava/lang/CharSequence;)V", "Landroid/text/method/TransformationMethod;", "getTransformationMethod", "()Landroid/text/method/TransformationMethod;", "setTransformationMethod", "(Landroid/text/method/TransformationMethod;)V", "transformationMethod", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasFocus", g.a, "Lkotlin/jvm/functions/Function1;", "getFocusChangeListener", "()Lkotlin/jvm/functions/Function1;", "setFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "focusChangeListener", "<set-?>", "j", "Lkotlin/properties/ReadWriteProperty;", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", AuthSource.OPEN_CHANNEL_LIST, "I", "errorStyle", "Landroid/text/TextWatcher;", "f", "Landroid/text/TextWatcher;", "getTextChangeListener", "()Landroid/text/TextWatcher;", "setTextChangeListener", "(Landroid/text/TextWatcher;)V", "textChangeListener", "getImeOptions", "()I", "setImeOptions", "imeOptions", "i", "getTextLength", "setTextLength", "textLength", "l", "normalStyle", "actionId", "h", "getActionListener", "setActionListener", "actionListener", "getInputType", "setInputType", "inputType", "getEnable", "setEnable", "enable", "Lru/avito/component/text_input/TextPainter;", "Lru/avito/component/text_input/TextPainter;", "textPainter", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "getText", "setText", "text", "Z", "getDrawBorder", "setDrawBorder", "drawBorder", "k", "getMaxLines", "setMaxLines", "maxLines", "getCurrentEditText", "()Landroid/widget/EditText;", "setCurrentEditText", "currentEditText", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Lazy;", "getBorderDrawable", "()Landroid/graphics/drawable/Drawable;", "borderDrawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextInputView extends FrameLayout implements TextInput {
    public static final /* synthetic */ KProperty[] n = {a2.b.a.a.a.u0(TextInputView.class, "currentEditText", "getCurrentEditText()Landroid/widget/EditText;", 0), a2.b.a.a.a.u0(TextInputView.class, "hasError", "getHasError()Z", 0)};
    public final ReadWriteProperty a;
    public final TextPainter b;
    public final ValueAnimator c;
    public final Lazy d;
    public boolean e;
    @Nullable
    public TextWatcher f;
    @Nullable
    public Function1<? super Boolean, Unit> g;
    @Nullable
    public Function1<? super Integer, Unit> h;
    public int i;
    @NotNull
    public final ReadWriteProperty j;
    public int k;
    public final int l;
    public final int m;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ TextInputView a;

        public a(TextInputView textInputView) {
            this.a = textInputView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.b.setFraction(((Float) a2.b.a.a.a.g2(valueAnimator, "it", "null cannot be cast to non-null type kotlin.Float")).floatValue());
        }
    }

    public static final class b extends Lambda implements Function0<Drawable> {
        public final /* synthetic */ TextInputView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(TextInputView textInputView) {
            super(0);
            this.a = textInputView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Drawable invoke() {
            Drawable drawable = Views.getDrawable(this.a, R.drawable.text_input_background);
            drawable.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
            return drawable;
        }
    }

    public static final class c implements View.OnFocusChangeListener {
        public final /* synthetic */ TextInputView a;

        public c(TextInputView textInputView) {
            this.a = textInputView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            Function1<Boolean, Unit> focusChangeListener = this.a.getFocusChangeListener();
            if (focusChangeListener != null) {
                focusChangeListener.invoke(Boolean.valueOf(z));
            }
            TextInputView textInputView = this.a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            TextInputView.access$animateHintOnFocusChange(textInputView, view, z);
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        public final /* synthetic */ TextInputView a;

        public d(TextInputView textInputView) {
            this.a = textInputView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Function1<Integer, Unit> actionListener = this.a.getActionListener();
            return (actionListener != null ? actionListener.invoke(Integer.valueOf(i)) : null) != null;
        }
    }

    @JvmOverloads
    public TextInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public TextInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextInputView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void access$animateHintOnFocusChange(TextInputView textInputView, View view, boolean z) {
        Objects.requireNonNull(textInputView);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.EditText");
        boolean z2 = !TextUtils.isEmpty(((EditText) view).getText());
        textInputView.b.setHasFocus(z);
        if (z2 || z) {
            textInputView.a(TextInputViewKt.getCOLLAPSED_FRACTION());
        } else {
            textInputView.a(TextInputViewKt.getEXPANDED_FRACTION());
        }
    }

    public static final void access$replaceEditText(TextInputView textInputView) {
        EditText currentEditText = textInputView.getCurrentEditText();
        int i2 = textInputView.getHasError() ? textInputView.m : textInputView.l;
        currentEditText.setOnFocusChangeListener(null);
        EditText c2 = textInputView.c(i2);
        c2.setImeOptions(currentEditText.getImeOptions());
        c2.setInputType(currentEditText.getInputType());
        c2.onRestoreInstanceState(currentEditText.onSaveInstanceState());
        String[] autofillHintsCompat = Views.getAutofillHintsCompat(currentEditText);
        Views.setAutofillHintsCompat(c2, (String[]) Arrays.copyOf(autofillHintsCompat, autofillHintsCompat.length));
        if (textInputView.getMaxLines() < Integer.MAX_VALUE) {
            int maxLines = textInputView.getMaxLines();
            c2.setMaxLines(maxLines);
            c2.setSingleLine(maxLines == 1);
        }
        if (textInputView.getTextLength() < Integer.MAX_VALUE) {
            c2.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(textInputView.getTextLength())});
        }
        if (textInputView.getTextChangeListener() != null) {
            c2.addTextChangedListener(textInputView.getTextChangeListener());
        }
        EditText currentEditText2 = textInputView.getCurrentEditText();
        boolean hasFocus = currentEditText2.hasFocus();
        textInputView.setEditView(c2);
        if (hasFocus) {
            Keyboards.showKeyboard$default(c2, 0, 1, null);
        }
        textInputView.removeView(currentEditText2);
    }

    private final Drawable getBorderDrawable() {
        return (Drawable) this.d.getValue();
    }

    private final EditText getCurrentEditText() {
        return (EditText) this.a.getValue(this, n[0]);
    }

    private final void setCurrentEditText(EditText editText) {
        this.a.setValue(this, n[0], editText);
    }

    private final void setEditView(EditText editText) {
        setCurrentEditText(editText);
        addView(getCurrentEditText());
    }

    public final void a(float f2) {
        if (this.b.getFraction() != f2) {
            if (this.c.isRunning()) {
                this.c.cancel();
            }
            TextPainter textPainter = this.b;
            this.c.setFloatValues(textPainter.getFraction() == 0.0f ? (1.0f / ((float) TextInputViewKt.getANIMATION_DURATION())) + textPainter.getFraction() : textPainter.getFraction(), f2);
            this.c.start();
        }
    }

    public final int[] b(boolean z) {
        return new int[]{d(16842910, isEnabled()), d(16842908, isFocused()), d(16842919, z)};
    }

    public final EditText c(@StyleRes int i2) {
        EditText editText = new EditText(new ContextThemeWrapper(getContext(), i2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.text_input_top_padding);
        editText.setLayoutParams(layoutParams);
        Views.setBackgroundCompat(editText, new ColorDrawable(0));
        Views.changePadding(editText, 0, 0, 0, 0);
        editText.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.text_input_text_size));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        editText.setTypeface(Typefaces.getTypeface(context, TypefaceType.Regular));
        editText.setOnFocusChangeListener(new c(this));
        editText.setOnEditorActionListener(new d(this));
        editText.addTextChangedListener(new SimpleTextWatcher(this) { // from class: com.avito.android.design.widget.TextInputView$createStyledEditText$4
            public final /* synthetic */ TextInputView a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i3, int i4, int i5) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                TextInputView.access$resetTextFraction(this.a);
            }
        });
        return editText;
    }

    public final int d(int i2, boolean z) {
        return z ? i2 : -i2;
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        this.b.draw(canvas);
        if (this.e) {
            getBorderDrawable().draw(canvas);
        }
    }

    public final void e() {
        float f2;
        TextPainter textPainter = this.b;
        Editable text = getCurrentEditText().getText();
        Intrinsics.checkNotNullExpressionValue(text, "currentEditText.text");
        if ((text.length() > 0) || hasFocus()) {
            f2 = TextInputViewKt.getCOLLAPSED_FRACTION();
        } else {
            f2 = TextInputViewKt.getEXPANDED_FRACTION();
        }
        textPainter.setFraction(f2);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> */
    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public Function1<Integer, Unit> getActionListener() {
        return this.h;
    }

    public final boolean getDrawBorder() {
        return this.e;
    }

    @Override // com.avito.android.design.widget.TextInput
    public boolean getEnable() {
        return getCurrentEditText().isEnabled();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> */
    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public Function1<Boolean, Unit> getFocusChangeListener() {
        return this.g;
    }

    @Override // com.avito.android.design.widget.TextInput
    public boolean getHasError() {
        return ((Boolean) this.j.getValue(this, n[1])).booleanValue();
    }

    @Override // com.avito.android.design.widget.TextInput
    @NotNull
    public CharSequence getHint() {
        return this.b.getText();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getImeOptions() {
        return getCurrentEditText().getImeOptions();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getInputType() {
        return getCurrentEditText().getInputType();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getMaxLines() {
        return this.k;
    }

    @Override // com.avito.android.design.widget.TextInput
    @NotNull
    public CharSequence getText() {
        Editable text = getCurrentEditText().getText();
        Intrinsics.checkNotNullExpressionValue(text, "currentEditText.text");
        return text;
    }

    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public TextWatcher getTextChangeListener() {
        return this.f;
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getTextLength() {
        return this.i;
    }

    @Nullable
    public final TransformationMethod getTransformationMethod() {
        return getCurrentEditText().getTransformationMethod();
    }

    @Override // com.avito.android.design.widget.TextInput
    public void moveCursorToEnd() {
        getCurrentEditText().setSelection(getCurrentEditText().getText().length());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.b.updateSize(getPaddingLeft(), getPaddingRight(), getHeight());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setHasError(savedState.getHasError());
            getCurrentEditText().onRestoreInstanceState(savedState.getEditState());
            e();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        boolean hasError = getHasError();
        Parcelable onSaveInstanceState2 = getCurrentEditText().onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState2);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState2, "currentEditText.onSaveInstanceState()!!");
        return new SavedState(hasError, onSaveInstanceState2, onSaveInstanceState);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action == 0) {
            getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
            Drawable background = getBackground();
            Intrinsics.checkNotNullExpressionValue(background, "background");
            background.setState(b(true));
        } else if (action == 1 || action == 3) {
            Drawable background2 = getBackground();
            Intrinsics.checkNotNullExpressionValue(background2, "background");
            background2.setState(b(false));
        }
        float coerceAtMost = e.coerceAtMost(motionEvent.getX() - ((float) getCurrentEditText().getLeft()), (float) getCurrentEditText().getWidth());
        float coerceAtMost2 = e.coerceAtMost(motionEvent.getY() - ((float) getCurrentEditText().getTop()), (float) getCurrentEditText().getHeight());
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(coerceAtMost, coerceAtMost2);
        if (getCurrentEditText().onTouchEvent(obtain)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void resetText() {
        getCurrentEditText().setText(getText());
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setActionListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.h = function1;
    }

    @Override // android.view.View
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hint");
        Views.setAutofillHintsCompat(getCurrentEditText(), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void setDrawBorder(boolean z) {
        this.e = z;
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setEnable(boolean z) {
        getCurrentEditText().setEnabled(z);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.g = function1;
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHasError(boolean z) {
        this.j.setValue(this, n[1], Boolean.valueOf(z));
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.b.setText(charSequence);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHintResId(int i2) {
        TextPainter textPainter = this.b;
        String string = getContext().getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
        textPainter.setText(string);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setImeOptions(int i2) {
        getCurrentEditText().setImeOptions(i2);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setInputType(int i2) {
        getCurrentEditText().setInputType(i2);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setMaxLines(int i2) {
        this.k = i2;
        EditText currentEditText = getCurrentEditText();
        currentEditText.setMaxLines(i2);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        currentEditText.setSingleLine(z);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        getCurrentEditText().setText(charSequence);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setTextChangeListener(@Nullable TextWatcher textWatcher) {
        getCurrentEditText().removeTextChangedListener(this.f);
        this.f = textWatcher;
        getCurrentEditText().addTextChangedListener(textWatcher);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setTextLength(int i2) {
        this.i = i2;
        getCurrentEditText().setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public final void setTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        int selectionStart = getCurrentEditText().getSelectionStart();
        int selectionEnd = getCurrentEditText().getSelectionEnd();
        getCurrentEditText().setTransformationMethod(transformationMethod);
        int length = getCurrentEditText().getText().length();
        getCurrentEditText().setSelection(Math.min(selectionStart, length), Math.min(selectionEnd, length));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = Delegates.INSTANCE.notNull();
        this.b = new TextPainter(this);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(TextInputViewKt.getANIMATION_DURATION());
        valueAnimator.addUpdateListener(new a(this));
        this.c = valueAnimator;
        this.d = t6.c.lazy(new b(this));
        this.i = Integer.MAX_VALUE;
        Boolean bool = Boolean.FALSE;
        this.j = new ObservableProperty<Boolean>(bool, bool, this) { // from class: com.avito.android.design.widget.TextInputView$$special$$inlined$observable$1
            public final /* synthetic */ Object b;
            public final /* synthetic */ TextInputView c;

            {
                this.b = r1;
                this.c = r3;
            }

            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> kProperty, Boolean bool2, Boolean bool3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                boolean booleanValue = bool3.booleanValue();
                if (booleanValue != bool2.booleanValue()) {
                    TextInputView.access$getTextPainter$p(this.c).setHasError(booleanValue);
                    TextInputView.access$replaceEditText(this.c);
                }
            }
        };
        this.k = Integer.MAX_VALUE;
        int i3 = R.style.TextInputAppearance;
        this.l = i3;
        this.m = R.style.TextInputAppearanceError;
        setWillNotDraw(false);
        setEditView(c(i3));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TextInputView);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.TextInputView_android_text);
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.TextInputView_android_hint);
        int i4 = obtainStyledAttributes.getInt(R.styleable.TextInputView_android_inputType, 0);
        int i5 = obtainStyledAttributes.getInt(R.styleable.TextInputView_android_imeOptions, 0);
        this.e = obtainStyledAttributes.getBoolean(R.styleable.TextInputView_drawBorder, false);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.TextInputView_android_background);
        drawable = drawable == null ? Views.getDrawable(this, R.drawable.bg_btn_flat) : drawable;
        Intrinsics.checkNotNullExpressionValue(drawable, "styledAttrs.getDrawable(…e(R.drawable.bg_btn_flat)");
        Views.setBackgroundCompat(this, drawable);
        Views.changePadding$default(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextInputView_android_paddingLeft, 0), 0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextInputView_android_paddingRight, 0), 0, 10, null);
        if (i4 != 0) {
            setInputType(i4);
        }
        if (i5 != 0) {
            setImeOptions(i5);
        }
        if (text != null) {
            setText(text);
        }
        if (text2 != null) {
            setHint(text2);
        }
        obtainStyledAttributes.recycle();
        Resources resources = getResources();
        setMinimumHeight(resources.getDimensionPixelSize(R.dimen.text_input_min_height));
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.text_input_small_padding);
        Views.changePadding$default(this, 0, dimensionPixelSize, 0, dimensionPixelSize, 5, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017B!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/design/widget/TextInputView$SavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getHasError", "()Z", "hasError", "Landroid/os/Parcelable;", AuthSource.BOOKING_ORDER, "Landroid/os/Parcelable;", "getEditState", "()Landroid/os/Parcelable;", "editState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "superState", "(ZLandroid/os/Parcelable;Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final boolean a;
        @NotNull
        public final Parcelable b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/TextInputView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/TextInputView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a = ParcelsKt.readBool(parcel);
            this.b = a2.b.a.a.a.z1(Parcelable.class, parcel);
        }

        @NotNull
        public final Parcelable getEditState() {
            return this.b;
        }

        public final boolean getHasError() {
            return this.a;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (parcel != null) {
                ParcelsKt.writeBool(parcel, this.a);
                parcel.writeParcelable(this.b, i);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(boolean z, @NotNull Parcelable parcelable, @NotNull Parcelable parcelable2) {
            super(parcelable2);
            Intrinsics.checkNotNullParameter(parcelable, "editState");
            Intrinsics.checkNotNullParameter(parcelable2, "superState");
            this.a = z;
            this.b = parcelable;
        }
    }
}
