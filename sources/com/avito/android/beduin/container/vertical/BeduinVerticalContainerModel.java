package com.avito.android.beduin.container.vertical;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.BedionContainerIndent;
import com.avito.android.beduin.core.model.container.BeduinContainerBackground;
import com.avito.android.beduin.core.model.container.BeduinContainerModel;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005¢\u0006\u0004\b9\u0010:J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJn\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b&\u0010 J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b+\u0010,R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\u0011R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b1\u0010\bR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\u000bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u00104\u001a\u0004\b5\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u00106\u001a\u0004\b7\u0010\u0004R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b8\u0010\u0011¨\u0006;"}, d2 = {"Lcom/avito/android/beduin/container/vertical/BeduinVerticalContainerModel;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerModel;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component2", "()Ljava/util/List;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "component3", "()Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "", "component4", "()Ljava/lang/Integer;", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "component5", "()Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "component6", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "component7", "id", "actions", "background", "interItemSpacing", "padding", "margin", "children", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;Ljava/lang/Integer;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Ljava/util/List;)Lcom/avito/android/beduin/container/vertical/BeduinVerticalContainerModel;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getActions", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "getPadding", "getChildren", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "getBackground", "Ljava/lang/Integer;", "getInterItemSpacing", "Ljava/lang/String;", "getId", "getMargin", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;Ljava/lang/Integer;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinVerticalContainerModel implements BeduinContainerModel {
    public static final Parcelable.Creator<BeduinVerticalContainerModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final BeduinContainerBackground background;
    @NotNull
    private final List<BeduinModel> children;
    @Nullable
    private final String id;
    @Nullable
    private final Integer interItemSpacing;
    @Nullable
    private final BedionContainerIndent margin;
    @Nullable
    private final BedionContainerIndent padding;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinVerticalContainerModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinVerticalContainerModel createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinVerticalContainerModel.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            BeduinContainerBackground createFromParcel = parcel.readInt() != 0 ? BeduinContainerBackground.CREATOR.createFromParcel(parcel) : null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            BedionContainerIndent createFromParcel2 = parcel.readInt() != 0 ? BedionContainerIndent.CREATOR.createFromParcel(parcel) : null;
            BedionContainerIndent createFromParcel3 = parcel.readInt() != 0 ? BedionContainerIndent.CREATOR.createFromParcel(parcel) : null;
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((BeduinModel) parcel.readParcelable(BeduinVerticalContainerModel.class.getClassLoader()));
                readInt2--;
            }
            return new BeduinVerticalContainerModel(readString, arrayList, createFromParcel, valueOf, createFromParcel2, createFromParcel3, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinVerticalContainerModel[] newArray(int i) {
            return new BeduinVerticalContainerModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinVerticalContainerModel(@Nullable String str, @Nullable List<? extends BeduinAction> list, @Nullable BeduinContainerBackground beduinContainerBackground, @Nullable Integer num, @Nullable BedionContainerIndent bedionContainerIndent, @Nullable BedionContainerIndent bedionContainerIndent2, @NotNull List<? extends BeduinModel> list2) {
        Intrinsics.checkNotNullParameter(list2, "children");
        this.id = str;
        this.actions = list;
        this.background = beduinContainerBackground;
        this.interItemSpacing = num;
        this.padding = bedionContainerIndent;
        this.margin = bedionContainerIndent2;
        this.children = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.beduin.container.vertical.BeduinVerticalContainerModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinVerticalContainerModel copy$default(BeduinVerticalContainerModel beduinVerticalContainerModel, String str, List list, BeduinContainerBackground beduinContainerBackground, Integer num, BedionContainerIndent bedionContainerIndent, BedionContainerIndent bedionContainerIndent2, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beduinVerticalContainerModel.getId();
        }
        if ((i & 2) != 0) {
            list = beduinVerticalContainerModel.getActions();
        }
        if ((i & 4) != 0) {
            beduinContainerBackground = beduinVerticalContainerModel.getBackground();
        }
        if ((i & 8) != 0) {
            num = beduinVerticalContainerModel.getInterItemSpacing();
        }
        if ((i & 16) != 0) {
            bedionContainerIndent = beduinVerticalContainerModel.getPadding();
        }
        if ((i & 32) != 0) {
            bedionContainerIndent2 = beduinVerticalContainerModel.getMargin();
        }
        if ((i & 64) != 0) {
            list2 = beduinVerticalContainerModel.children;
        }
        return beduinVerticalContainerModel.copy(str, list, beduinContainerBackground, num, bedionContainerIndent, bedionContainerIndent2, list2);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public BeduinModel apply(@NotNull BeduinModelTransform beduinModelTransform) {
        Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
        return BeduinContainerModel.DefaultImpls.apply(this, beduinModelTransform);
    }

    @Nullable
    public final String component1() {
        return getId();
    }

    @Nullable
    public final List<BeduinAction> component2() {
        return getActions();
    }

    @Nullable
    public final BeduinContainerBackground component3() {
        return getBackground();
    }

    @Nullable
    public final Integer component4() {
        return getInterItemSpacing();
    }

    @Nullable
    public final BedionContainerIndent component5() {
        return getPadding();
    }

    @Nullable
    public final BedionContainerIndent component6() {
        return getMargin();
    }

    @NotNull
    public final List<BeduinModel> component7() {
        return this.children;
    }

    @NotNull
    public final BeduinVerticalContainerModel copy(@Nullable String str, @Nullable List<? extends BeduinAction> list, @Nullable BeduinContainerBackground beduinContainerBackground, @Nullable Integer num, @Nullable BedionContainerIndent bedionContainerIndent, @Nullable BedionContainerIndent bedionContainerIndent2, @NotNull List<? extends BeduinModel> list2) {
        Intrinsics.checkNotNullParameter(list2, "children");
        return new BeduinVerticalContainerModel(str, list, beduinContainerBackground, num, bedionContainerIndent, bedionContainerIndent2, list2);
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
        if (!(obj instanceof BeduinVerticalContainerModel)) {
            return false;
        }
        BeduinVerticalContainerModel beduinVerticalContainerModel = (BeduinVerticalContainerModel) obj;
        return Intrinsics.areEqual(getId(), beduinVerticalContainerModel.getId()) && Intrinsics.areEqual(getActions(), beduinVerticalContainerModel.getActions()) && Intrinsics.areEqual(getBackground(), beduinVerticalContainerModel.getBackground()) && Intrinsics.areEqual(getInterItemSpacing(), beduinVerticalContainerModel.getInterItemSpacing()) && Intrinsics.areEqual(getPadding(), beduinVerticalContainerModel.getPadding()) && Intrinsics.areEqual(getMargin(), beduinVerticalContainerModel.getMargin()) && Intrinsics.areEqual(this.children, beduinVerticalContainerModel.children);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public List<BeduinAction> getActions() {
        return this.actions;
    }

    @Override // com.avito.android.beduin.core.model.container.BeduinContainerModel
    @Nullable
    public BeduinContainerBackground getBackground() {
        return this.background;
    }

    @NotNull
    public final List<BeduinModel> getChildren() {
        return this.children;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public String getId() {
        return this.id;
    }

    @Override // com.avito.android.beduin.core.model.container.BeduinContainerModel
    @Nullable
    public Integer getInterItemSpacing() {
        return this.interItemSpacing;
    }

    @Override // com.avito.android.beduin.core.model.container.BeduinContainerModel
    @Nullable
    public BedionContainerIndent getMargin() {
        return this.margin;
    }

    @Override // com.avito.android.beduin.core.model.container.BeduinContainerModel
    @Nullable
    public BedionContainerIndent getPadding() {
        return this.padding;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public Map<String, Object> getParameters() {
        return BeduinContainerModel.DefaultImpls.getParameters(this);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        List<BeduinAction> actions2 = getActions();
        int hashCode2 = (hashCode + (actions2 != null ? actions2.hashCode() : 0)) * 31;
        BeduinContainerBackground background2 = getBackground();
        int hashCode3 = (hashCode2 + (background2 != null ? background2.hashCode() : 0)) * 31;
        Integer interItemSpacing2 = getInterItemSpacing();
        int hashCode4 = (hashCode3 + (interItemSpacing2 != null ? interItemSpacing2.hashCode() : 0)) * 31;
        BedionContainerIndent padding2 = getPadding();
        int hashCode5 = (hashCode4 + (padding2 != null ? padding2.hashCode() : 0)) * 31;
        BedionContainerIndent margin2 = getMargin();
        int hashCode6 = (hashCode5 + (margin2 != null ? margin2.hashCode() : 0)) * 31;
        List<BeduinModel> list = this.children;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinContainerModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinVerticalContainerModel(id=");
        L.append(getId());
        L.append(", actions=");
        L.append(getActions());
        L.append(", background=");
        L.append(getBackground());
        L.append(", interItemSpacing=");
        L.append(getInterItemSpacing());
        L.append(", padding=");
        L.append(getPadding());
        L.append(", margin=");
        L.append(getMargin());
        L.append(", children=");
        return a.w(L, this.children, ")");
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
        BeduinContainerBackground beduinContainerBackground = this.background;
        if (beduinContainerBackground != null) {
            parcel.writeInt(1);
            beduinContainerBackground.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.interItemSpacing;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        BedionContainerIndent bedionContainerIndent = this.padding;
        if (bedionContainerIndent != null) {
            parcel.writeInt(1);
            bedionContainerIndent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        BedionContainerIndent bedionContainerIndent2 = this.margin;
        if (bedionContainerIndent2 != null) {
            parcel.writeInt(1);
            bedionContainerIndent2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.children, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((BeduinModel) n0.next(), i);
        }
    }
}
