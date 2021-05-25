package com.avito.android.design.widget.lifecycle_view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.legacy.widget.Space;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/avito/android/design/widget/lifecycle_view/LifecycleView;", "Landroidx/legacy/widget/Space;", "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", "attachListener", "", "setAttachListener", "(Lcom/avito/android/design/widget/lifecycle_view/AttachListener;)V", "Lcom/avito/android/design/widget/lifecycle_view/StateListener;", "stateListener", "setStateListener", "(Lcom/avito/android/design/widget/lifecycle_view/StateListener;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/lifecycle_view/AttachListener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/design/widget/lifecycle_view/StateListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public class LifecycleView extends Space {
    public AttachListener a;
    public StateListener b;

    @JvmOverloads
    public LifecycleView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public LifecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LifecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AttachListener attachListener = this.a;
        if (attachListener != null) {
            attachListener.onAttach();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AttachListener attachListener = this.a;
        if (attachListener != null) {
            attachListener.onDetach();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (parcelable instanceof Kundle) {
            Kundle kundle = (Kundle) parcelable;
            super.onRestoreInstanceState(kundle.getParcelable("saved_view_state"));
            StateListener stateListener = this.b;
            if (stateListener != null) {
                stateListener.onRestoreState((Kundle) kundle.getParcelable("saved_external_state"));
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        StateListener stateListener = this.b;
        return new Kundle().putParcelable("saved_view_state", onSaveInstanceState).putParcelable("saved_external_state", stateListener != null ? stateListener.onSaveState() : null);
    }

    public final void setAttachListener(@NotNull AttachListener attachListener) {
        Intrinsics.checkNotNullParameter(attachListener, "attachListener");
        this.a = attachListener;
    }

    public final void setStateListener(@NotNull StateListener stateListener) {
        Intrinsics.checkNotNullParameter(stateListener, "stateListener");
        this.b = stateListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifecycleView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
