package com.avito.android.lib.design.toggle;

import a2.g.r.g;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.B\u001b\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b-\u00101B#\b\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u00020\u0012¢\u0006\u0004\b-\u00103J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R*\u0010%\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00028\u0006@CX\u000e¢\u0006\u0012\n\u0004\b$\u0010!\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0006R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/avito/android/lib/design/toggle/Checkbox;", "Lcom/avito/android/lib/design/toggle/Toggle;", "", "indeterminate", "", "setIndeterminate", "(Z)V", "checked", "setChecked", "toggle", "()V", "Lcom/avito/android/lib/design/toggle/OnStateChangedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnStateChangedListener", "(Lcom/avito/android/lib/design/toggle/OnStateChangedListener;)V", "Lcom/avito/android/lib/design/toggle/State;", "getState", "()Lcom/avito/android/lib/design/toggle/State;", "", "extraSpace", "", "onCreateDrawableState", "(I)[I", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "d", "Lcom/avito/android/lib/design/toggle/OnStateChangedListener;", "stateChangedListener", g.a, "Z", "shouldNotify", "value", "f", "isIndeterminate", "()Z", "setIndeterminateInternally", "e", "[I", "indeterminateStateSet", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "SavedState", "components_release"}, k = 1, mv = {1, 4, 2})
public final class Checkbox extends Toggle {
    public OnStateChangedListener d;
    public final int[] e;
    public boolean f;
    public boolean g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/lib/design/toggle/Checkbox$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Z", "isIndeterminate", "()Z", "setIndeterminate", "(Z)V", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class SavedState extends View.BaseSavedState {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SavedState> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        public boolean a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/toggle/Checkbox$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/lib/design/toggle/Checkbox$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
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
                return new SavedState(parcel2, null);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SavedState(@NotNull Parcelable parcelable) {
            super(parcelable);
            Intrinsics.checkNotNullParameter(parcelable, "superState");
        }

        public final boolean isIndeterminate() {
            return this.a;
        }

        public final void setIndeterminate(boolean z) {
            this.a = z;
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            super.writeToParcel(parcel, i);
            ParcelsKt.writeBool(parcel, this.a);
        }

        public SavedState(Parcel parcel, j jVar) {
            super(parcel);
            this.a = ParcelsKt.readBool(parcel);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Checkbox(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmName(name = "setIndeterminateInternally")
    private final void setIndeterminateInternally(boolean z) {
        if (this.f != z) {
            this.f = z;
            refreshDrawableState();
        }
    }

    @NotNull
    public final State getState() {
        if (this.f) {
            return State.INDETERMINATE;
        }
        if (isChecked()) {
            return State.CHECKED;
        }
        return State.UNCHECKED;
    }

    public final boolean isIndeterminate() {
        return this.f;
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    @Nullable
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.f) {
            View.mergeDrawableStates(onCreateDrawableState, this.e);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        this.g = false;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setIndeterminateInternally(savedState.isIndeterminate());
        this.g = true;
    }

    @Override // android.widget.TextView, android.widget.CompoundButton, android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(onSaveInstanceState);
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "super.onSaveInstanceState()!!");
        SavedState savedState = new SavedState(onSaveInstanceState);
        savedState.setIndeterminate(this.f);
        return savedState;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        OnStateChangedListener onStateChangedListener;
        boolean z2 = isChecked() != z;
        super.setChecked(z);
        boolean z3 = this.f;
        setIndeterminateInternally(false);
        if ((z3 || z2) && this.g && (onStateChangedListener = this.d) != null) {
            onStateChangedListener.onStateChanged(this, getState());
        }
    }

    public final void setIndeterminate(boolean z) {
        OnStateChangedListener onStateChangedListener;
        if (this.f != z) {
            setIndeterminateInternally(z);
            if (this.g && (onStateChangedListener = this.d) != null) {
                onStateChangedListener.onStateChanged(this, getState());
            }
        }
    }

    public final void setOnStateChangedListener(@Nullable OnStateChangedListener onStateChangedListener) {
        this.d = onStateChangedListener;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.f) {
            setChecked(true);
        } else {
            super.toggle();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Checkbox(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"CustomViewStyleable", "Recycle"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Checkbox(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r0 = r6.intValue()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r6 = 0
        L_0x0018:
            if (r6 == 0) goto L_0x001f
            int r6 = r6.intValue()
            goto L_0x0021
        L_0x001f:
            int r6 = com.avito.android.lib.design.R.attr.checkbox
        L_0x0021:
            r3.<init>(r4, r5, r6)
            int[] r6 = new int[r1]
            int r0 = com.avito.android.util.R.attr.state_indeterminate
            r6[r2] = r0
            r3.e = r6
            r3.g = r1
            int[] r6 = com.avito.android.lib.design.R.styleable.Toggle
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r6, r2, r2)
            if (r4 == 0) goto L_0x0042
            int r5 = com.avito.android.lib.design.R.styleable.Toggle_toggle_indeterminate
            boolean r5 = r4.getBoolean(r5, r2)
            r3.setIndeterminateInternally(r5)
            r4.recycle()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.lib.design.toggle.Checkbox.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
