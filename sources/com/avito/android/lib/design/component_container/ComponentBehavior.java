package com.avito.android.lib.design.component_container;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001/B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00062\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\bJ\r\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010#\u001a\u00020\"8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010\t\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u000b¨\u00060"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentBehavior;", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "state", "", "onStateChanged", "(Lcom/avito/android/lib/design/component_container/ComponentContainer$State;)V", "view", "onAttachView", "(Landroid/view/View;)V", "onDetachView", "attach", "detach", "()V", "notifyValueReset", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueResetListener", "(Lkotlin/jvm/functions/Function0;)V", "", "autoResetCondition", "setAutoResetCondition", "(I)V", "getAutoResetCondition", "()I", "setState", "getState", "()Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "autoReset", "I", "currentState", "Lcom/avito/android/lib/design/component_container/ComponentContainer$State;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "resetListener", "Lkotlin/jvm/functions/Function0;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "<init>", "(Landroid/content/Context;)V", "Companion", "components_release"}, k = 1, mv = {1, 4, 2})
public abstract class ComponentBehavior<V extends View> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int RESET_ANY_CHANGES = 2;
    public static final int RESET_NEVER = 0;
    public static final int RESET_NOT_NORMAL_ONLY = 1;
    private int autoReset;
    @NotNull
    private final Context context;
    private ComponentContainer.State currentState;
    private Function0<Unit> resetListener;
    @Nullable
    private V view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/lib/design/component_container/ComponentBehavior$Companion;", "", "", "RESET_ANY_CHANGES", "I", "RESET_NEVER", "RESET_NOT_NORMAL_ONLY", "<init>", "()V", "components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public ComponentBehavior(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void attach(@NotNull V v) {
        Intrinsics.checkNotNullParameter(v, "view");
        if (this.view != null) {
            detach();
        }
        this.view = v;
        onAttachView(v);
    }

    public final void detach() {
        V v = this.view;
        if (v != null) {
            onDetachView(v);
            this.view = null;
        }
    }

    public final int getAutoResetCondition() {
        return this.autoReset;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final ComponentContainer.State getState() {
        ComponentContainer.State state = this.currentState;
        return state != null ? state : ComponentContainer.State.NORMAL;
    }

    @Nullable
    public final V getView() {
        return this.view;
    }

    public final void notifyValueReset() {
        Function0<Unit> function0 = this.resetListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public abstract void onAttachView(@NotNull V v);

    public abstract void onDetachView(@NotNull V v);

    public abstract void onStateChanged(@NotNull ComponentContainer.State state);

    public final void setAutoResetCondition(int i) {
        this.autoReset = i;
    }

    public final void setState(@NotNull ComponentContainer.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.currentState != state) {
            this.currentState = state;
            onStateChanged(state);
        }
    }

    public final void setValueResetListener(@Nullable Function0<Unit> function0) {
        this.resetListener = function0;
    }

    public final void setView(@Nullable V v) {
        this.view = v;
    }
}
