package com.avito.android.remote.model.category_parameters.base;

import com.avito.android.remote.model.category_parameters.base.HasError;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u0007¢\u0006\u0004\b*\u0010\u000eJ\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\f2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\f0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\u0004\u0018\u00018\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u0013\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R(\u0010\u001e\u001a\u0004\u0018\u00018\u00002\b\u0010\u001e\u001a\u0004\u0018\u00018\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R(\u0010!\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "T", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/base/HasError;", "Lcom/avito/android/remote/model/category_parameters/base/BaseEditableParameter;", "Lcom/avito/android/remote/model/category_parameters/base/ObservableParameter;", "newValue", "", "proceedValue", "(Ljava/lang/Object;)Z", "hasValue", "()Z", "", "onParamChanged", "()V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueChangesListener", "(Lkotlin/jvm/functions/Function1;)V", "oldValue", "areValuesTheSame", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "get_value", "()Ljava/lang/Object;", "set_value", "(Ljava/lang/Object;)V", "_value", "Ljava/lang/Object;", "getOldValue", "setOldValue", "value", "getValue", "setValue", "valueChangesListener", "Lkotlin/jvm/functions/Function1;", "", "error", "Ljava/lang/String;", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "<init>", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class EditableParameter<T> extends CategoryParameter implements HasError, BaseEditableParameter<T>, ObservableParameter {
    @Nullable
    private String error;
    @Nullable
    private T oldValue;
    private Function1<? super EditableParameter<?>, Unit> valueChangesListener;

    private final boolean proceedValue(T t) {
        T t2 = get_value();
        set_value(t);
        if (areValuesTheSame(t2, t)) {
            return false;
        }
        if (t2 != null || hasValue()) {
            return true;
        }
        return false;
    }

    public boolean areValuesTheSame(@Nullable T t, @Nullable T t2) {
        return Intrinsics.areEqual((Object) t, (Object) t2);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    @Nullable
    public String getError() {
        return this.error;
    }

    @Nullable
    public final T getOldValue() {
        return this.oldValue;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public final T getValue() {
        return get_value();
    }

    @Nullable
    public abstract T get_value();

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    public boolean hasError() {
        return HasError.DefaultImpls.hasError(this);
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    public final void onParamChanged() {
        Function1<? super EditableParameter<?>, Unit> function1 = this.valueChangesListener;
        if (function1 != null) {
            function1.invoke(this);
        }
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasError
    public void setError(@Nullable String str) {
        this.error = str;
    }

    public final void setOldValue(@Nullable T t) {
        this.oldValue = t;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    public final void setValue(@Nullable T t) {
        if (proceedValue(t)) {
            onParamChanged();
        }
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ObservableParameter
    public void setValueChangesListener(@NotNull Function1<? super EditableParameter<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.valueChangesListener = function1;
    }

    public abstract void set_value(@Nullable T t);
}
