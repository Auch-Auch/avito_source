package com.avito.android.remote.model.category_parameters.slot;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.avito.android.remote.parse.adapter.SlotTypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010\u0006R\u001c\u0010\n\u001a\u00028\u00008\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "T", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "component1", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "component2", "()Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "type", Navigation.CONFIG, "copy", "(Lcom/avito/android/remote/model/category_parameters/slot/SlotType;Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;)Lcom/avito/android/remote/model/category_parameters/slot/SlotWidget;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/slot/SlotType;", "getType", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "getConfig", "<init>", "(Lcom/avito/android/remote/model/category_parameters/slot/SlotType;Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SlotWidget<T extends SlotConfig> implements Parcelable {
    public static final Parcelable.Creator<SlotWidget> CREATOR = new Creator();
    @SerializedName(Navigation.CONFIG)
    @NotNull
    private final T config;
    @SerializedName("type")
    @JsonAdapter(SlotTypeAdapter.class)
    @NotNull
    private final SlotType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SlotWidget> {
        /* Return type fixed from 'com.avito.android.remote.model.category_parameters.slot.SlotWidget<T extends com.avito.android.remote.model.category_parameters.slot.SlotConfig>' to match base method */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SlotWidget createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SlotWidget((SlotType) Enum.valueOf(SlotType.class, parcel.readString()), (SlotConfig) parcel.readParcelable(SlotWidget.class.getClassLoader()));
        }

        /* Return type fixed from 'com.avito.android.remote.model.category_parameters.slot.SlotWidget<T extends com.avito.android.remote.model.category_parameters.slot.SlotConfig>[]' to match base method */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SlotWidget[] newArray(int i) {
            return new SlotWidget[i];
        }
    }

    public SlotWidget(@NotNull SlotType slotType, @NotNull T t) {
        Intrinsics.checkNotNullParameter(slotType, "type");
        Intrinsics.checkNotNullParameter(t, Navigation.CONFIG);
        this.type = slotType;
        this.config = t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.slot.SlotWidget */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlotWidget copy$default(SlotWidget slotWidget, SlotType slotType, SlotConfig slotConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            slotType = slotWidget.type;
        }
        if ((i & 2) != 0) {
            slotConfig = slotWidget.config;
        }
        return slotWidget.copy(slotType, slotConfig);
    }

    @NotNull
    public final SlotType component1() {
        return this.type;
    }

    @NotNull
    public final T component2() {
        return this.config;
    }

    @NotNull
    public final SlotWidget<T> copy(@NotNull SlotType slotType, @NotNull T t) {
        Intrinsics.checkNotNullParameter(slotType, "type");
        Intrinsics.checkNotNullParameter(t, Navigation.CONFIG);
        return new SlotWidget<>(slotType, t);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlotWidget)) {
            return false;
        }
        SlotWidget slotWidget = (SlotWidget) obj;
        return Intrinsics.areEqual(this.type, slotWidget.type) && Intrinsics.areEqual(this.config, slotWidget.config);
    }

    @NotNull
    public final T getConfig() {
        return this.config;
    }

    @NotNull
    public final SlotType getType() {
        return this.type;
    }

    @Override // java.lang.Object
    public int hashCode() {
        SlotType slotType = this.type;
        int i = 0;
        int hashCode = (slotType != null ? slotType.hashCode() : 0) * 31;
        T t = this.config;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SlotWidget(type=");
        L.append(this.type);
        L.append(", config=");
        L.append(this.config);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type.name());
        parcel.writeParcelable(this.config, i);
    }
}
