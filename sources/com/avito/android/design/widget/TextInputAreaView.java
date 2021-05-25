package com.avito.android.design.widget;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.android.util.Views;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001^B'\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020\u0007¢\u0006\u0004\b\\\u0010]J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\rR$\u0010\u0014\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020!8F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b\u0015\u0010$R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R+\u0010-\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00028B@BX\u0002¢\u0006\u0012\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u0006R$\u00100\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010\rR+\u00107\u001a\u0002012\u0006\u0010(\u001a\u0002018F@FX\u0002¢\u0006\u0012\n\u0004\b2\u0010)\u001a\u0004\b3\u00104\"\u0004\b5\u00106R*\u0010;\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u000e¢\u0006\u0012\n\u0004\b8\u0010&\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010\rR$\u0010\u000f\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020!8F@FX\u000e¢\u0006\f\u001a\u0004\b<\u0010#\"\u0004\b=\u0010$R*\u0010A\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00078F@FX\u000e¢\u0006\u0012\n\u0004\b>\u0010&\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010\rR.\u0010I\u001a\u0004\u0018\u00010B2\b\u0010\u001c\u001a\u0004\u0018\u00010B8F@FX\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010Q\u001a\u0004\u0018\u00010J2\b\u0010\u001c\u001a\u0004\u0018\u00010J8F@FX\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010&R$\u0010V\u001a\u0002012\u0006\u0010\u001c\u001a\u0002018F@FX\u000e¢\u0006\f\u001a\u0004\bT\u00104\"\u0004\bU\u00106¨\u0006_"}, d2 = {"Lcom/avito/android/design/widget/TextInputAreaView;", "Landroid/widget/FrameLayout;", "Landroid/widget/EditText;", "editText", "", "setEditView", "(Landroid/widget/EditText;)V", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, AuthSource.SEND_ABUSE, "(I)Landroid/widget/EditText;", FirebaseAnalytics.Param.INDEX, "setSelection", "(I)V", "", "text", "insertInCursorPosition", "(Ljava/lang/String;)V", "stringId", "setHintResId", "hint", "setHint", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "value", "getImeOptions", "()I", "setImeOptions", "imeOptions", "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "h", "I", "errorStyle", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", "getCurrentEditText", "()Landroid/widget/EditText;", "setCurrentEditText", "currentEditText", "getInputType", "setInputType", "inputType", "", "e", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", "f", "getMaxLines", "setMaxLines", "maxLines", "getText", "setText", "d", "getTextLength", "setTextLength", "textLength", "Landroid/text/TextWatcher;", "c", "Landroid/text/TextWatcher;", "getTextChangeListener", "()Landroid/text/TextWatcher;", "setTextChangeListener", "(Landroid/text/TextWatcher;)V", "textChangeListener", "Landroid/view/View$OnFocusChangeListener;", AuthSource.BOOKING_ORDER, "Landroid/view/View$OnFocusChangeListener;", "getFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "focusChangeListener", g.a, "normalStyle", "getEnable", "setEnable", "enable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class TextInputAreaView extends FrameLayout {
    public static final /* synthetic */ KProperty[] i = {a.u0(TextInputAreaView.class, "currentEditText", "getCurrentEditText()Landroid/widget/EditText;", 0), a.u0(TextInputAreaView.class, "hasError", "getHasError()Z", 0)};
    public final ReadWriteProperty a;
    @Nullable
    public View.OnFocusChangeListener b;
    @Nullable
    public TextWatcher c;
    public int d;
    @NotNull
    public final ReadWriteProperty e;
    public int f;
    public final int g;
    public final int h;

    @JvmOverloads
    public TextInputAreaView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public TextInputAreaView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextInputAreaView(Context context, AttributeSet attributeSet, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static final void access$replaceEditText(TextInputAreaView textInputAreaView) {
        EditText currentEditText = textInputAreaView.getCurrentEditText();
        int i2 = textInputAreaView.getHasError() ? textInputAreaView.h : textInputAreaView.g;
        currentEditText.setOnFocusChangeListener(null);
        EditText a3 = textInputAreaView.a(i2);
        a3.setImeOptions(currentEditText.getImeOptions());
        a3.setInputType(currentEditText.getInputType());
        a3.setHint(currentEditText.getHint());
        a3.onRestoreInstanceState(currentEditText.onSaveInstanceState());
        if (textInputAreaView.getMaxLines() < Integer.MAX_VALUE) {
            a3.setMaxLines(textInputAreaView.getMaxLines());
        }
        if (textInputAreaView.getTextLength() < Integer.MAX_VALUE) {
            a3.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(textInputAreaView.getTextLength())});
        }
        if (textInputAreaView.getTextChangeListener() != null) {
            a3.addTextChangedListener(textInputAreaView.getTextChangeListener());
        }
        if (textInputAreaView.getFocusChangeListener() != null) {
            a3.setOnFocusChangeListener(textInputAreaView.getFocusChangeListener());
        }
        EditText currentEditText2 = textInputAreaView.getCurrentEditText();
        textInputAreaView.setEditView(a3);
        textInputAreaView.removeView(currentEditText2);
    }

    private final EditText getCurrentEditText() {
        return (EditText) this.a.getValue(this, i[0]);
    }

    private final void setCurrentEditText(EditText editText) {
        this.a.setValue(this, i[0], editText);
    }

    private final void setEditView(EditText editText) {
        setCurrentEditText(editText);
        addView(getCurrentEditText());
    }

    public final EditText a(@StyleRes int i2) {
        EditText editText = new EditText(new ContextThemeWrapper(getContext(), i2));
        editText.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        Views.setBackgroundCompat(editText, new ColorDrawable(0));
        Views.changePadding(editText, 0, 0, 0, 0);
        editText.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.text_input_text_size));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        editText.setTypeface(Typefaces.getTypeface(context, TypefaceType.Regular));
        editText.setId(R.id.text_input_area_view_edit_text);
        editText.setGravity(48);
        return editText;
    }

    public final boolean getEnable() {
        return getCurrentEditText().isEnabled();
    }

    @Nullable
    public final View.OnFocusChangeListener getFocusChangeListener() {
        return this.b;
    }

    public final boolean getHasError() {
        return ((Boolean) this.e.getValue(this, i[1])).booleanValue();
    }

    @NotNull
    public final CharSequence getHint() {
        CharSequence hint = getCurrentEditText().getHint();
        Intrinsics.checkNotNullExpressionValue(hint, "currentEditText.hint");
        return hint;
    }

    public final int getImeOptions() {
        return getCurrentEditText().getImeOptions();
    }

    public final int getInputType() {
        return getCurrentEditText().getInputType();
    }

    public final int getMaxLines() {
        return this.f;
    }

    @NotNull
    public final CharSequence getText() {
        Editable text = getCurrentEditText().getText();
        Intrinsics.checkNotNullExpressionValue(text, "currentEditText.text");
        return text;
    }

    @Nullable
    public final TextWatcher getTextChangeListener() {
        return this.c;
    }

    public final int getTextLength() {
        return this.d;
    }

    public final void insertInCursorPosition(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        int selectionStart = getCurrentEditText().getSelectionStart();
        int selectionEnd = getCurrentEditText().getSelectionEnd();
        if (selectionEnd > selectionStart) {
            EditText currentEditText = getCurrentEditText();
            Editable text = getCurrentEditText().getText();
            Intrinsics.checkNotNullExpressionValue(text, "currentEditText.text");
            currentEditText.setText(StringsKt__StringsKt.removeRange(text, selectionStart, selectionEnd));
            getCurrentEditText().getText().insert(selectionStart, str);
            setSelection(str.length() + selectionStart);
            return;
        }
        getCurrentEditText().getText().insert(selectionStart, str);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setHasError(savedState.getHasError());
            getCurrentEditText().onRestoreInstanceState(savedState.getEditState());
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

    public final void setEnable(boolean z) {
        getCurrentEditText().setEnabled(z);
    }

    public final void setFocusChangeListener(@Nullable View.OnFocusChangeListener onFocusChangeListener) {
        getCurrentEditText().setOnFocusChangeListener(onFocusChangeListener);
        this.b = onFocusChangeListener;
    }

    public final void setHasError(boolean z) {
        this.e.setValue(this, i[1], Boolean.valueOf(z));
    }

    public final void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        getCurrentEditText().setHint(charSequence);
    }

    public final void setHintResId(int i2) {
        getCurrentEditText().setHint(i2);
    }

    public final void setImeOptions(int i2) {
        getCurrentEditText().setImeOptions(i2);
    }

    public final void setInputType(int i2) {
        getCurrentEditText().setInputType(i2);
    }

    public final void setMaxLines(int i2) {
        this.f = i2;
        getCurrentEditText().setMaxLines(i2);
    }

    public final void setSelection(int i2) {
        getCurrentEditText().setSelection(i2);
    }

    public final void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        getCurrentEditText().setText(charSequence);
    }

    public final void setTextChangeListener(@Nullable TextWatcher textWatcher) {
        getCurrentEditText().removeTextChangedListener(this.c);
        this.c = textWatcher;
        getCurrentEditText().addTextChangedListener(textWatcher);
    }

    public final void setTextLength(int i2) {
        this.d = i2;
        getCurrentEditText().setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i2)});
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInputAreaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = Delegates.INSTANCE.notNull();
        this.d = Integer.MAX_VALUE;
        Boolean bool = Boolean.FALSE;
        this.e = new ObservableProperty<Boolean>(bool, bool, this) { // from class: com.avito.android.design.widget.TextInputAreaView$$special$$inlined$observable$1
            public final /* synthetic */ Object b;
            public final /* synthetic */ TextInputAreaView c;

            {
                this.b = r1;
                this.c = r3;
            }

            @Override // kotlin.properties.ObservableProperty
            public void afterChange(@NotNull KProperty<?> kProperty, Boolean bool2, Boolean bool3) {
                Intrinsics.checkNotNullParameter(kProperty, "property");
                if (bool3.booleanValue() != bool2.booleanValue()) {
                    TextInputAreaView.access$replaceEditText(this.c);
                }
            }
        };
        this.f = Integer.MAX_VALUE;
        int i3 = R.style.TextInputAppearance;
        this.g = i3;
        this.h = R.style.TextInputAppearanceError;
        setEditView(a(i3));
        Resources resources = getResources();
        setMinimumHeight(resources.getDimensionPixelSize(R.dimen.text_input_area_min_height));
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.text_input_area_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, resources.getDimensionPixelSize(R.dimen.text_input_area_bottom_padding));
    }

    public final void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        getCurrentEditText().setHint(str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017B!\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/avito/android/design/widget/TextInputAreaView$SavedState;", "Landroid/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "getHasError", "()Z", "hasError", "Landroid/os/Parcelable;", AuthSource.BOOKING_ORDER, "Landroid/os/Parcelable;", "getEditState", "()Landroid/os/Parcelable;", "editState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "superState", "(ZLandroid/os/Parcelable;Landroid/os/Parcelable;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public final boolean a;
        @NotNull
        public final Parcelable b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/widget/TextInputAreaView$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/design/widget/TextInputAreaView$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
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
