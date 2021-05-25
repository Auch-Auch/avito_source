package com.avito.android.remote.model.category_parameters.slot;

import a2.b.a.a.a;
import android.os.Parcel;
import androidx.annotation.CallSuper;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.HasError;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B%\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188V@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0006R\u0016\u0010%\u001a\u00020\"8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\"\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "T", "Lcom/avito/android/remote/model/category_parameters/slot/BaseSlot;", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "pretendResult", "applyPretendResult", "(Ljava/util/Map;)Lcom/avito/android/remote/model/PretendErrorValue;", "id", "Ljava/lang/String;", "getId", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "label", "getLabel", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "getSlotType", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "slotType", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "widget", "Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "getWidget", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class Slot<T extends SlotConfig> extends BaseSlot {
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("label")
    @NotNull
    private final String label;
    @NotNull
    private transient List<? extends ParameterSlot> parameters = CollectionsKt__CollectionsKt.emptyList();
    @SerializedName("widget")
    @NotNull
    private final SlotWidget<T> widget;

    public Slot(@NotNull String str, @NotNull String str2, @NotNull SlotWidget<T> slotWidget) {
        a.Y0(str, "id", str2, "label", slotWidget, "widget");
        this.id = str;
        this.label = str2;
        this.widget = slotWidget;
    }

    @Nullable
    public final PretendErrorValue applyPretendResult(@Nullable Map<String, ? extends PretendErrorValue> map) {
        PretendErrorValue pretendErrorValue;
        Iterator<ParameterSlot> it = getParameters().iterator();
        while (true) {
            pretendErrorValue = null;
            if (!it.hasNext()) {
                break;
            }
            ParameterSlot next = it.next();
            if ((next instanceof CategoryParameter) && map != null) {
                pretendErrorValue = (PretendErrorValue) map.get(next.getId());
                continue;
            }
            if (pretendErrorValue != null) {
                if (next instanceof HasError) {
                    ((HasError) next).setError(pretendErrorValue.getSingleMessage());
                }
            }
        }
        return pretendErrorValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ParameterSlot
    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot>, java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    @NotNull
    public List<ParameterSlot> getParameters() {
        if (this.parameters == null) {
            this.parameters = CollectionsKt__CollectionsKt.emptyList();
        }
        return this.parameters;
    }

    @Override // com.avito.android.remote.model.category_parameters.slot.BaseSlot
    @NotNull
    public SlotType getSlotType() {
        return this.widget.getType();
    }

    @NotNull
    public final SlotWidget<T> getWidget() {
        return this.widget;
    }

    public void setParameters(@NotNull List<? extends ParameterSlot> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.parameters = list;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Slot(id:");
        L.append(getId());
        L.append(", type:");
        L.append(getSlotType().getStrValue());
        L.append(')');
        return L.toString();
    }

    @Override // android.os.Parcelable
    @CallSuper
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(getId());
        }
        if (parcel != null) {
            parcel.writeString(this.label);
        }
        if (parcel != null) {
            parcel.writeParcelable(this.widget, i);
        }
    }
}
