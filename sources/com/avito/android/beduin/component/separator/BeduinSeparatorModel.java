package com.avito.android.beduin.component.separator;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.model.separator.SeparatorStyle;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b$\u0010\u000bR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component2", "()Ljava/util/List;", "Lcom/avito/android/beduin/core/model/separator/SeparatorStyle;", "component3", "()Lcom/avito/android/beduin/core/model/separator/SeparatorStyle;", "id", "actions", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/separator/SeparatorStyle;)Lcom/avito/android/beduin/component/separator/BeduinSeparatorModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "Lcom/avito/android/beduin/core/model/separator/SeparatorStyle;", "getStyle", "Ljava/util/List;", "getActions", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/separator/SeparatorStyle;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSeparatorModel implements BeduinModel {
    public static final Parcelable.Creator<BeduinSeparatorModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final String id;
    @NotNull
    private final SeparatorStyle style;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinSeparatorModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSeparatorModel createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinSeparatorModel.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new BeduinSeparatorModel(readString, arrayList, (SeparatorStyle) Enum.valueOf(SeparatorStyle.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSeparatorModel[] newArray(int i) {
            return new BeduinSeparatorModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinSeparatorModel(@Nullable String str, @Nullable List<? extends BeduinAction> list, @NotNull SeparatorStyle separatorStyle) {
        Intrinsics.checkNotNullParameter(separatorStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.id = str;
        this.actions = list;
        this.style = separatorStyle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.beduin.component.separator.BeduinSeparatorModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinSeparatorModel copy$default(BeduinSeparatorModel beduinSeparatorModel, String str, List list, SeparatorStyle separatorStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beduinSeparatorModel.getId();
        }
        if ((i & 2) != 0) {
            list = beduinSeparatorModel.getActions();
        }
        if ((i & 4) != 0) {
            separatorStyle = beduinSeparatorModel.style;
        }
        return beduinSeparatorModel.copy(str, list, separatorStyle);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public BeduinModel apply(@NotNull BeduinModelTransform beduinModelTransform) {
        Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
        return BeduinModel.DefaultImpls.apply(this, beduinModelTransform);
    }

    @Nullable
    public final String component1() {
        return getId();
    }

    @Nullable
    public final List<BeduinAction> component2() {
        return getActions();
    }

    @NotNull
    public final SeparatorStyle component3() {
        return this.style;
    }

    @NotNull
    public final BeduinSeparatorModel copy(@Nullable String str, @Nullable List<? extends BeduinAction> list, @NotNull SeparatorStyle separatorStyle) {
        Intrinsics.checkNotNullParameter(separatorStyle, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new BeduinSeparatorModel(str, list, separatorStyle);
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
        if (!(obj instanceof BeduinSeparatorModel)) {
            return false;
        }
        BeduinSeparatorModel beduinSeparatorModel = (BeduinSeparatorModel) obj;
        return Intrinsics.areEqual(getId(), beduinSeparatorModel.getId()) && Intrinsics.areEqual(getActions(), beduinSeparatorModel.getActions()) && Intrinsics.areEqual(this.style, beduinSeparatorModel.style);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public List<BeduinAction> getActions() {
        return this.actions;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public String getId() {
        return this.id;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public Map<String, Object> getParameters() {
        return BeduinModel.DefaultImpls.getParameters(this);
    }

    @NotNull
    public final SeparatorStyle getStyle() {
        return this.style;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        List<BeduinAction> actions2 = getActions();
        int hashCode2 = (hashCode + (actions2 != null ? actions2.hashCode() : 0)) * 31;
        SeparatorStyle separatorStyle = this.style;
        if (separatorStyle != null) {
            i = separatorStyle.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinSeparatorModel(id=");
        L.append(getId());
        L.append(", actions=");
        L.append(getActions());
        L.append(", style=");
        L.append(this.style);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        List<BeduinAction> list = this.actions;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((BeduinAction) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.style.name());
    }
}
