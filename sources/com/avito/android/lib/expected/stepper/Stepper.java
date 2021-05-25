package com.avito.android.lib.expected.stepper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.R;
import com.avito.android.util.Views;
import com.avito.android.util.drawable.RoundStateDrawable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002OPB1\b\u0007\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010L\u001a\u00020\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000e\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u0010\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u0018\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010\u001eR\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010(R*\u0010\u0015\u001a\u00020,2\u0006\u0010-\u001a\u00020,8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00109R*\u0010@\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001a\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010\u001eR\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010(R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006Q"}, d2 = {"Lcom/avito/android/lib/expected/stepper/Stepper;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setOnMinusClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnPlusClickListener", "setOnValueClickListener", "Lkotlin/Function1;", "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "value", "u", "I", "getMaxValue", "()I", "setMaxValue", "(I)V", "maxValue", AppSettingsData.STATUS_NEW, VKApiConst.VERSION, "getValue", "setValue", "B", "[I", "currentDrawableState", "y", "Lkotlin/jvm/functions/Function0;", "onMinusClickListener", "x", "onValueClickListener", "Lcom/avito/android/lib/expected/stepper/Stepper$State;", "newState", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/lib/expected/stepper/Stepper$State;", "getState", "()Lcom/avito/android/lib/expected/stepper/Stepper$State;", "setState", "(Lcom/avito/android/lib/expected/stepper/Stepper$State;)V", "w", "Lkotlin/jvm/functions/Function1;", "onValueChangeListener", "Landroid/widget/ImageButton;", VKApiConst.Q, "Landroid/widget/ImageButton;", "minusSign", "s", "plusSign", "t", "getMinValue", "setMinValue", "minValue", "z", "onPlusClickListener", "Landroid/widget/TextView;", "r", "Landroid/widget/TextView;", "valueField", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "SavedState", "State", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Stepper extends ConstraintLayout {
    @NotNull
    public State A;
    public int[] B;
    public final ImageButton q;
    public final TextView r;
    public final ImageButton s;
    public int t;
    public int u;
    public int v;
    public Function1<? super Integer, Unit> w;
    public Function0<Unit> x;
    public Function0<Boolean> y;
    public Function0<Boolean> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0015\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/lib/expected/stepper/Stepper$State;", "", "", AuthSource.SEND_ABUSE, "[I", "getDrawableState", "()[I", "drawableState", "<init>", "(Ljava/lang/String;I[I)V", "NORMAL", "ERROR", "components_release"}, k = 1, mv = {1, 4, 2})
    public enum State {
        NORMAL(null, 1),
        ERROR(new int[]{R.attr.state_error});
        
        @NotNull
        public final int[] a;

        /* access modifiers changed from: public */
        State(int[] iArr) {
            this.a = iArr;
        }

        @NotNull
        public final int[] getDrawableState() {
            return this.a;
        }

        /* access modifiers changed from: public */
        State(int[] iArr, int i) {
            this.a = (i & 1) != 0 ? new int[0] : null;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            int i = this.a;
            if (i == 0) {
                return Boolean.FALSE;
            }
            if (i == 1) {
                return Boolean.FALSE;
            }
            throw null;
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            num.intValue();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    @JvmOverloads
    public Stepper(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public Stepper(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public Stepper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Stepper(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public static MaterialShapeDrawable b(Stepper stepper, float f, float f2, float f3, float f4, int i) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder().setBottomLeftCorner(0, f2).setTopLeftCorner(0, f).setBottomRightCorner(0, f4).setTopRightCorner(0, f3).build());
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK));
        return materialShapeDrawable;
    }

    public final int getMaxValue() {
        return this.u;
    }

    public final int getMinValue() {
        return this.t;
    }

    @NotNull
    public final State getState() {
        return this.A;
    }

    public final int getValue() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    @NotNull
    public int[] onCreateDrawableState(int i) {
        int[] mergeDrawableStates = View.mergeDrawableStates(super.onCreateDrawableState(i + this.B.length), this.B);
        Intrinsics.checkNotNullExpressionValue(mergeDrawableStates, "View.mergeDrawableStates…es, currentDrawableState)");
        return mergeDrawableStates;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setState(savedState.getDrawableState());
            setValue(savedState.getValue());
            setMinValue(savedState.getMinValue());
            setMaxValue(savedState.getMaxValue());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        State state = this.A;
        int i = this.v;
        int i2 = this.t;
        int i3 = this.u;
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        return new SavedState(state, i, i2, i3, onSaveInstanceState);
    }

    public final void setMaxValue(int i) {
        int coerceAtLeast = e.coerceAtLeast(i, this.t);
        this.u = coerceAtLeast;
        setValue(e.coerceAtMost(this.v, coerceAtLeast));
    }

    public final void setMinValue(int i) {
        int coerceAtMost = e.coerceAtMost(i, this.u);
        this.t = coerceAtMost;
        setValue(e.coerceAtLeast(this.v, coerceAtMost));
    }

    public final void setOnMinusClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = function0;
    }

    public final void setOnPlusClickListener(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.z = function0;
    }

    public final void setOnValueChangeListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = function1;
    }

    public final void setOnValueClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x = function0;
    }

    public final void setState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "newState");
        if (state != this.A) {
            this.A = state;
            this.B = state.getDrawableState();
            refreshDrawableState();
        }
    }

    public final void setValue(int i) {
        int i2 = this.t;
        if (i <= i2 || i >= (i2 = this.u)) {
            i = i2;
        }
        boolean z2 = true;
        this.s.setEnabled(i < this.u);
        ImageButton imageButton = this.q;
        if (i <= this.t) {
            z2 = false;
        }
        imageButton.setEnabled(z2);
        if (i != this.v) {
            this.v = i;
            this.r.setText(String.valueOf(i));
            this.w.invoke(Integer.valueOf(i));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Stepper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.u = Integer.MAX_VALUE;
        this.v = -1;
        this.w = b.a;
        this.x = c.a;
        this.y = a.b;
        this.z = a.c;
        State state = State.NORMAL;
        this.A = state;
        this.B = state.getDrawableState();
        View inflate = LayoutInflater.from(context).inflate(com.avito.android.lib.design.R.layout.stepper, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(com.avito.android.lib.design.R.id.minus_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.minus_button)");
        ImageButton imageButton = (ImageButton) findViewById;
        this.q = imageButton;
        View findViewById2 = inflate.findViewById(com.avito.android.lib.design.R.id.value_field);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.value_field)");
        TextView textView = (TextView) findViewById2;
        this.r = textView;
        View findViewById3 = inflate.findViewById(com.avito.android.lib.design.R.id.plus_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.plus_button)");
        ImageButton imageButton2 = (ImageButton) findViewById3;
        this.s = imageButton2;
        Integer valueOf = Integer.valueOf(i2);
        RippleDrawable rippleDrawable = null;
        valueOf = !(valueOf.intValue() > 0) ? null : valueOf;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.avito.android.lib.design.R.styleable.Stepper, i, valueOf != null ? valueOf.intValue() : com.avito.android.lib.design.R.style.Stepper);
        int i3 = com.avito.android.lib.design.R.styleable.Stepper_stepper_minValue;
        if (obtainStyledAttributes.hasValue(i3)) {
            setMinValue(obtainStyledAttributes.getInt(i3, 0));
        }
        int i4 = com.avito.android.lib.design.R.styleable.Stepper_stepper_maxValue;
        if (obtainStyledAttributes.hasValue(i4)) {
            setMaxValue(obtainStyledAttributes.getInt(i4, Integer.MAX_VALUE));
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.avito.android.lib.design.R.styleable.Stepper_stepper_cornerRadius, 0);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.Stepper_stepper_buttonsRippleColor);
        Views.setBackgroundCompat(this, RoundStateDrawable.Companion.invoke$default(RoundStateDrawable.Companion, obtainStyledAttributes.getColorStateList(com.avito.android.lib.design.R.styleable.Stepper_stepper_backgroundColor), null, dimensionPixelSize, null, 0, 0, 0, 122, null));
        obtainStyledAttributes.recycle();
        float f = (float) dimensionPixelSize;
        MaterialShapeDrawable b2 = b(this, f, f, 0.0f, 0.0f, 12);
        MaterialShapeDrawable b3 = b(this, 0.0f, 0.0f, f, f, 3);
        RippleDrawable rippleDrawable2 = colorStateList != null ? new RippleDrawable(colorStateList, null, b2) : null;
        rippleDrawable = colorStateList != null ? new RippleDrawable(colorStateList, null, b3) : rippleDrawable;
        Views.setBackgroundCompat(imageButton, rippleDrawable2);
        Views.setBackgroundCompat(imageButton2, rippleDrawable);
        RxView.clicks(imageButton).filter(new m3(0, this)).subscribe(new v2(0, this));
        RxView.clicks(imageButton2).filter(new m3(1, this)).subscribe(new v2(1, this));
        RxView.clicks(textView).subscribe(new v2(2, this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cB1\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001fJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\r\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0019\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/avito/android/lib/expected/stepper/Stepper$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "I", "getMinValue", "()I", "minValue", "e", "getMaxValue", "maxValue", "c", "getValue", "value", "Lcom/avito/android/lib/expected/stepper/Stepper$State;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/expected/stepper/Stepper$State;", "getDrawableState", "()Lcom/avito/android/lib/expected/stepper/Stepper$State;", "drawableState", "parcel", "<init>", "(Landroid/os/Parcel;)V", "Landroid/os/Parcelable;", "superState", "(Lcom/avito/android/lib/expected/stepper/Stepper$State;IIILandroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends AbsSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final State b;
        public final int c;
        public final int d;
        public final int e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/expected/stepper/Stepper$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/expected/stepper/Stepper$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
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
            this.b = (State) ParcelsKt.readEnum(parcel, State.values());
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        @NotNull
        public final State getDrawableState() {
            return this.b;
        }

        public final int getMaxValue() {
            return this.e;
        }

        public final int getMinValue() {
            return this.d;
        }

        public final int getValue() {
            return this.c;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@Nullable Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            if (parcel != null) {
                ParcelsKt.writeEnum(parcel, this.b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.d);
                parcel.writeInt(this.e);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull State state, int i, int i2, int i3, @NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(state, "drawableState");
            Intrinsics.checkNotNullParameter(parcelable, "superState");
            this.b = state;
            this.c = i;
            this.d = i2;
            this.e = i3;
        }
    }
}
