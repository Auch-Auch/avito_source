package com.avito.android.beduin.component.spacing;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010!R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\fR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b(\u0010\u0007¨\u0006+"}, d2 = {"Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component4", "()Ljava/util/List;", "id", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "actions", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/avito/android/beduin/component/spacing/BeduinSpacingModel;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getActions", "Ljava/lang/Integer;", "getHeight", "Ljava/lang/String;", "getId", "getWidth", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSpacingModel implements BeduinModel {
    public static final Parcelable.Creator<BeduinSpacingModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final Integer height;
    @Nullable
    private final String id;
    @Nullable
    private final Integer width;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinSpacingModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSpacingModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((BeduinAction) parcel.readParcelable(BeduinSpacingModel.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            }
            return new BeduinSpacingModel(readString, valueOf, valueOf2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSpacingModel[] newArray(int i) {
            return new BeduinSpacingModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinSpacingModel(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable List<? extends BeduinAction> list) {
        this.id = str;
        this.width = num;
        this.height = num2;
        this.actions = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.beduin.component.spacing.BeduinSpacingModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinSpacingModel copy$default(BeduinSpacingModel beduinSpacingModel, String str, Integer num, Integer num2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beduinSpacingModel.getId();
        }
        if ((i & 2) != 0) {
            num = beduinSpacingModel.width;
        }
        if ((i & 4) != 0) {
            num2 = beduinSpacingModel.height;
        }
        if ((i & 8) != 0) {
            list = beduinSpacingModel.getActions();
        }
        return beduinSpacingModel.copy(str, num, num2, list);
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
    public final Integer component2() {
        return this.width;
    }

    @Nullable
    public final Integer component3() {
        return this.height;
    }

    @Nullable
    public final List<BeduinAction> component4() {
        return getActions();
    }

    @NotNull
    public final BeduinSpacingModel copy(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable List<? extends BeduinAction> list) {
        return new BeduinSpacingModel(str, num, num2, list);
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
        if (!(obj instanceof BeduinSpacingModel)) {
            return false;
        }
        BeduinSpacingModel beduinSpacingModel = (BeduinSpacingModel) obj;
        return Intrinsics.areEqual(getId(), beduinSpacingModel.getId()) && Intrinsics.areEqual(this.width, beduinSpacingModel.width) && Intrinsics.areEqual(this.height, beduinSpacingModel.height) && Intrinsics.areEqual(getActions(), beduinSpacingModel.getActions());
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public List<BeduinAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
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

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        Integer num = this.width;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<BeduinAction> actions2 = getActions();
        if (actions2 != null) {
            i = actions2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinSpacingModel(id=");
        L.append(getId());
        L.append(", width=");
        L.append(this.width);
        L.append(", height=");
        L.append(this.height);
        L.append(", actions=");
        L.append(getActions());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        Integer num = this.width;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.height;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
        List<BeduinAction> list = this.actions;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((BeduinAction) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
