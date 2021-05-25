package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ObservableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.avito.android.remote.model.category_parameters.slot.SlotWidget;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8V@VX\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ObservableSlot;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "T", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "Lcom/avito/android/remote/model/category_parameters/base/ObservableParameter;", "", "setListenerForParams", "()V", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setValueChangesListener", "(Lkotlin/jvm/functions/Function1;)V", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "value", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "valueChangesListener", "Lkotlin/jvm/functions/Function1;", "", "id", "label", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ObservableSlot<T extends SlotConfig> extends Slot<T> implements ObservableParameter {
    @NotNull
    private transient List<? extends ParameterSlot> parameters = CollectionsKt__CollectionsKt.emptyList();
    private Function1<? super EditableParameter<?>, Unit> valueChangesListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObservableSlot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<T> slotWidget) {
        super(str, str2, slotWidget);
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
    }

    private final void setListenerForParams() {
        Function1<? super EditableParameter<?>, Unit> function1 = this.valueChangesListener;
        if (function1 != null) {
            List<ParameterSlot> parameters2 = getParameters();
            ArrayList<ObservableParameter> arrayList = new ArrayList();
            for (T t : parameters2) {
                if (t instanceof ObservableParameter) {
                    arrayList.add(t);
                }
            }
            for (ObservableParameter observableParameter : arrayList) {
                observableParameter.setValueChangesListener(function1);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot>, java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    @Override // com.avito.android.remote.model.category_parameters.slot.Slot
    @NotNull
    public List<ParameterSlot> getParameters() {
        if (this.parameters == null) {
            this.parameters = CollectionsKt__CollectionsKt.emptyList();
        }
        return this.parameters;
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.Slot
    public void setParameters(@NotNull List<? extends ParameterSlot> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.parameters = list;
        setListenerForParams();
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ObservableParameter
    public void setValueChangesListener(@NotNull Function1<? super EditableParameter<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.valueChangesListener = function1;
    }
}
