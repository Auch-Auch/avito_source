package com.avito.android.util.architecture_components.auto_clear;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005B\u0007¢\u0006\u0004\b\u0015\u0010\u0010J$\u0010\t\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ,\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0017¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\r\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "", "T", "Lkotlin/properties/ReadWriteProperty;", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LifecycleObserver;", "thisRef", "Lkotlin/reflect/KProperty;", "property", "getValue", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", "setValue", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "onDestroy", "()V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
public class AutoClearedValue<T> implements ReadWriteProperty<Fragment, T>, LifecycleObserver {
    @Nullable
    public T a;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((Fragment) obj, (KProperty<?>) kProperty);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.a = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, kotlin.reflect.KProperty, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.properties.ReadWriteProperty
    public /* bridge */ /* synthetic */ void setValue(Fragment fragment, KProperty kProperty, Object obj) {
        setValue(fragment, (KProperty<?>) kProperty, (KProperty) obj);
    }

    @Nullable
    public final T getValue() {
        return this.a;
    }

    public final void setValue(@Nullable T t) {
        this.a = t;
    }

    @NotNull
    public T getValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        T t = this.a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Trying to call an auto-cleared value outside of the view lifecycle.");
    }

    public void setValue(@NotNull Fragment fragment, @NotNull KProperty<?> kProperty, @NotNull T t) {
        Intrinsics.checkNotNullParameter(fragment, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Intrinsics.checkNotNullParameter(t, "value");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "thisRef.viewLifecycleOwner");
        viewLifecycleOwner.getLifecycle().removeObserver(this);
        this.a = t;
        LifecycleOwner viewLifecycleOwner2 = fragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "thisRef.viewLifecycleOwner");
        viewLifecycleOwner2.getLifecycle().addObserver(this);
    }
}
