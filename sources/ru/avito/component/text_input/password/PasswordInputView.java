package ru.avito.component.text_input.password;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.StringRes;
import com.avito.android.design.widget.TextInput;
import com.avito.android.design.widget.TextInputView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.Views;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001fB1\b\u0007\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\b\b\u0002\u0010c\u001a\u00020\u0005\u0012\b\b\u0002\u0010M\u001a\u00020J¢\u0006\u0004\bd\u0010eJ7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\n2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\n2\b\b\u0001\u0010\u001a\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u001cR9\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\n\u0018\u00010\u001d8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010+\u001a\u00020&8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u00101\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R9\u00105\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b3\u0010\"\"\u0004\b4\u0010$R\u001c\u00109\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u0010\u001cR\u001c\u0010>\u001a\u00020\u00038\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\bC\u0010;\"\u0004\bD\u0010=R\u001c\u0010G\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bE\u00107\"\u0004\bF\u0010\u001cR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010@R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010@R\u001c\u0010R\u001a\u00020\u00038\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bP\u0010;\"\u0004\bQ\u0010=R\u001c\u0010U\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bS\u00107\"\u0004\bT\u0010\u001cR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001c\u0010\u000f\u001a\u00020&8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bZ\u0010(\"\u0004\b[\u0010*R\u001c\u0010^\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b\\\u00107\"\u0004\b]\u0010\u001c¨\u0006g"}, d2 = {"Lru/avito/component/text_input/password/PasswordInputView;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/design/widget/TextInput;", "", "changed", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "", "onLayout", "(ZIIII)V", "", "", "hint", "setAutofillHints", "([Ljava/lang/String;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "moveCursorToEnd", "()V", "stringId", "setHintResId", "(I)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "actionId", "getActionListener", "()Lkotlin/jvm/functions/Function1;", "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "actionListener", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "Landroid/text/TextWatcher;", "getTextChangeListener", "()Landroid/text/TextWatcher;", "setTextChangeListener", "(Landroid/text/TextWatcher;)V", "textChangeListener", "hasFocus", "getFocusChangeListener", "setFocusChangeListener", "focusChangeListener", "getInputType", "()I", "setInputType", "inputType", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", "c", "I", "originPaddingRight", "value", "isSecure", "setSecure", "getImeOptions", "setImeOptions", "imeOptions", AuthSource.BOOKING_ORDER, "originPaddingLeft", "Lcom/avito/android/design/widget/TextInputView;", "e", "Lcom/avito/android/design/widget/TextInputView;", "input", "d", "securePadding", "getEnable", "setEnable", "enable", "getTextLength", "setTextLength", "textLength", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "secureButton", "getHint", "setHint", "getMaxLines", "setMaxLines", "maxLines", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/avito/android/design/widget/TextInputView;)V", "PasswordSavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordInputView extends FrameLayout implements TextInput {
    public final ImageView a;
    public int b;
    public int c;
    public final int d;
    public final TextInputView e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PasswordInputView a;

        public a(PasswordInputView passwordInputView) {
            this.a = passwordInputView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PasswordInputView passwordInputView = this.a;
            passwordInputView.setSecure(!passwordInputView.isSecure());
        }
    }

    @JvmOverloads
    public PasswordInputView(@NotNull Context context) {
        this(context, null, 0, null, 14, null);
    }

    @JvmOverloads
    public PasswordInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    @JvmOverloads
    public PasswordInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PasswordInputView(Context context, AttributeSet attributeSet, int i, TextInputView textInputView, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new TextInputView(context, null, 0, 6, null) : textInputView);
    }

    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public Function1<Integer, Unit> getActionListener() {
        return this.e.getActionListener();
    }

    @Override // com.avito.android.design.widget.TextInput
    public boolean getEnable() {
        return this.e.getEnable();
    }

    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public Function1<Boolean, Unit> getFocusChangeListener() {
        return this.e.getFocusChangeListener();
    }

    @Override // com.avito.android.design.widget.TextInput
    public boolean getHasError() {
        return this.e.getHasError();
    }

    @Override // com.avito.android.design.widget.TextInput
    @NotNull
    public CharSequence getHint() {
        return this.e.getHint();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getImeOptions() {
        return this.e.getImeOptions();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getInputType() {
        return this.e.getInputType();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getMaxLines() {
        return this.e.getMaxLines();
    }

    @Override // com.avito.android.design.widget.TextInput
    @NotNull
    public CharSequence getText() {
        return this.e.getText();
    }

    @Override // com.avito.android.design.widget.TextInput
    @Nullable
    public TextWatcher getTextChangeListener() {
        return this.e.getTextChangeListener();
    }

    @Override // com.avito.android.design.widget.TextInput
    public int getTextLength() {
        return this.e.getTextLength();
    }

    public final boolean isSecure() {
        return this.e.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    @Override // com.avito.android.design.widget.TextInput
    public void moveCursorToEnd() {
        this.e.moveCursorToEnd();
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.a.getMeasuredWidth();
        int measuredHeight = this.a.getMeasuredHeight();
        int i5 = i3 - i;
        int paddingRight = this.a.getPaddingRight() + (i5 - this.c);
        int i6 = paddingRight - measuredWidth;
        int i7 = i4 - i2;
        int i8 = (i7 - measuredHeight) / 2;
        this.a.layout(i6, i8, paddingRight, measuredHeight + i8);
        this.e.layout(0, 0, i5, i7);
        Views.changePadding$default(this.e, this.b, 0, getWidth() - i6, 0, 10, null);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof PasswordSavedState) {
            PasswordSavedState passwordSavedState = (PasswordSavedState) parcelable;
            super.onRestoreInstanceState(passwordSavedState.getSuperState());
            setSecure(passwordSavedState.isSecure());
            this.e.onRestoreInstanceState(passwordSavedState.getInputState());
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
        boolean isSecure = isSecure();
        Parcelable onSaveInstanceState2 = this.e.onSaveInstanceState();
        Objects.requireNonNull(onSaveInstanceState2, "null cannot be cast to non-null type com.avito.android.design.widget.TextInputView.SavedState");
        return new PasswordSavedState(isSecure, (TextInputView.SavedState) onSaveInstanceState2, onSaveInstanceState);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setActionListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.e.setActionListener(function1);
    }

    @Override // android.view.View
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hint");
        Views.setAutofillHintsCompat(this.e, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setEnable(boolean z) {
        this.e.setEnable(z);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.e.setFocusChangeListener(function1);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHasError(boolean z) {
        this.e.setHasError(z);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.e.setHint(charSequence);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setHintResId(@StringRes int i) {
        this.e.setHintResId(i);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setImeOptions(int i) {
        this.e.setImeOptions(i);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setInputType(int i) {
        this.e.setInputType(i);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setMaxLines(int i) {
        this.e.setMaxLines(i);
    }

    public final void setSecure(boolean z) {
        if (z) {
            this.e.setTransformationMethod(new PasswordTransformationMethod());
            ImageView imageView = this.a;
            Drawable drawable = getContext().getDrawable(R.drawable.ic_visible_off_24);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView.setImageDrawable(Contexts.getTintedDrawable(drawable, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48)));
            return;
        }
        this.e.setTransformationMethod(null);
        ImageView imageView2 = this.a;
        Drawable drawable2 = getContext().getDrawable(R.drawable.ic_visible_24);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        imageView2.setImageDrawable(Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray48)));
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.e.setText(charSequence);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setTextChangeListener(@Nullable TextWatcher textWatcher) {
        this.e.setTextChangeListener(textWatcher);
    }

    @Override // com.avito.android.design.widget.TextInput
    public void setTextLength(int i) {
        this.e.setTextLength(i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PasswordInputView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, @NotNull TextInputView textInputView) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textInputView, "input");
        this.e = textInputView;
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.standard_padding);
        this.d = dimensionPixelSize;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PasswordInputView);
        this.b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PasswordInputView_android_paddingLeft, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PasswordInputView_android_paddingRight, 0);
        Views.changePadding$default(this, 0, 0, 0, 0, 10, null);
        int i2 = obtainStyledAttributes.getInt(R.styleable.PasswordInputView_android_imeOptions, 0);
        if (i2 != 0) {
            textInputView.setImeOptions(i2);
        }
        obtainStyledAttributes.recycle();
        imageView.setBackgroundResource(R.drawable.bg_btn_circle);
        setClipToPadding(false);
        addView(textInputView, new FrameLayout.LayoutParams(-1, -2));
        addView(imageView, new FrameLayout.LayoutParams(-2, -2));
        imageView.setOnClickListener(new a(this));
        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016B!\b\u0016\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0015\u0010\u001aJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lru/avito/component/text_input/password/PasswordInputView$PasswordSavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "isSecure", "()Z", "Lcom/avito/android/design/widget/TextInputView$SavedState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/TextInputView$SavedState;", "getInputState", "()Lcom/avito/android/design/widget/TextInputView$SavedState;", "inputState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "editState", "Landroid/os/Parcelable;", "superState", "(ZLcom/avito/android/design/widget/TextInputView$SavedState;Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class PasswordSavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<PasswordSavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final boolean a;
        @NotNull
        public final TextInputView.SavedState b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/component/text_input/password/PasswordInputView$PasswordSavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/component/text_input/password/PasswordInputView$PasswordSavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, PasswordSavedState> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public PasswordSavedState invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new PasswordSavedState(parcel2);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PasswordSavedState(@NotNull Parcel parcel) {
            super(parcel);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.a = ParcelsKt.readBool(parcel);
            this.b = (TextInputView.SavedState) a2.b.a.a.a.z1(TextInputView.SavedState.class, parcel);
        }

        @NotNull
        public final TextInputView.SavedState getInputState() {
            return this.b;
        }

        public final boolean isSecure() {
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
        public PasswordSavedState(boolean z, @NotNull TextInputView.SavedState savedState, @NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(savedState, "editState");
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            this.a = z;
            this.b = savedState;
        }
    }
}
