package com.avito.android.beduin.container.spread;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.BedionContainerIndent;
import com.avito.android.beduin.core.model.container.BeduinContainerBackground;
import com.avito.android.beduin.core.model.container.BeduinContainerModel;
import com.avito.android.beduin.core.model.container.BeduinContainerPriority;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.google.firebase.messaging.Constants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005¢\u0006\u0004\bB\u0010CJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\bJ\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004J\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b,\u0010&J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b1\u00102R!\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b4\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u0010\u0004R!\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b7\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b9\u0010\u000bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010\u0011R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010<\u001a\u0004\b=\u0010\u0015R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010>\u001a\u0004\b?\u0010\u000eR$\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b@\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010:\u001a\u0004\bA\u0010\u0011¨\u0006D"}, d2 = {"Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerModel;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component2", "()Ljava/util/List;", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "component3", "()Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "", "component4", "()Ljava/lang/Integer;", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "component5", "()Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "component6", "Lcom/avito/android/beduin/core/model/container/BeduinContainerPriority;", "component7", "()Lcom/avito/android/beduin/core/model/container/BeduinContainerPriority;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "component8", "component9", "id", "actions", "background", "interItemSpacing", "padding", "margin", Constants.FirelogAnalytics.PARAM_PRIORITY, "leftChildren", "rightChildren", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;Ljava/lang/Integer;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/container/BeduinContainerPriority;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/beduin/container/spread/BeduinSpreadContainerModel;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getLeftChildren", "Ljava/lang/String;", "getId", "getRightChildren", "Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;", "getBackground", "Lcom/avito/android/beduin/core/model/BedionContainerIndent;", "getPadding", "Lcom/avito/android/beduin/core/model/container/BeduinContainerPriority;", "getPriority", "Ljava/lang/Integer;", "getInterItemSpacing", "getActions", "getMargin", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/beduin/core/model/container/BeduinContainerBackground;Ljava/lang/Integer;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/BedionContainerIndent;Lcom/avito/android/beduin/core/model/container/BeduinContainerPriority;Ljava/util/List;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinSpreadContainerModel implements BeduinContainerModel {
    public static final Parcelable.Creator<BeduinSpreadContainerModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final BeduinContainerBackground background;
    @Nullable
    private final String id;
    @Nullable
    private final Integer interItemSpacing;
    @Nullable
    private final List<BeduinModel> leftChildren;
    @Nullable
    private final BedionContainerIndent margin;
    @Nullable
    private final BedionContainerIndent padding;
    @Nullable
    private final BeduinContainerPriority priority;
    @Nullable
    private final List<BeduinModel> rightChildren;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinSpreadContainerModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSpreadContainerModel createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            ArrayList arrayList3 = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinSpreadContainerModel.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            BeduinContainerBackground createFromParcel = parcel.readInt() != 0 ? BeduinContainerBackground.CREATOR.createFromParcel(parcel) : null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            BedionContainerIndent createFromParcel2 = parcel.readInt() != 0 ? BedionContainerIndent.CREATOR.createFromParcel(parcel) : null;
            BedionContainerIndent createFromParcel3 = parcel.readInt() != 0 ? BedionContainerIndent.CREATOR.createFromParcel(parcel) : null;
            BeduinContainerPriority beduinContainerPriority = parcel.readInt() != 0 ? (BeduinContainerPriority) Enum.valueOf(BeduinContainerPriority.class, parcel.readString()) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add((BeduinModel) parcel.readParcelable(BeduinSpreadContainerModel.class.getClassLoader()));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                arrayList3 = new ArrayList(readInt3);
                while (readInt3 != 0) {
                    arrayList3.add((BeduinModel) parcel.readParcelable(BeduinSpreadContainerModel.class.getClassLoader()));
                    readInt3--;
                }
            }
            return new BeduinSpreadContainerModel(readString, arrayList, createFromParcel, valueOf, createFromParcel2, createFromParcel3, beduinContainerPriority, arrayList2, arrayList3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinSpreadContainerModel[] newArray(int i) {
            return new BeduinSpreadContainerModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinSpreadContainerModel(@Nullable String str, @Nullable List<? extends BeduinAction> list, @Nullable BeduinContainerBackground beduinContainerBackground, @Nullable Integer num, @Nullable BedionContainerIndent bedionContainerIndent, @Nullable BedionContainerIndent bedionContainerIndent2, @Nullable BeduinContainerPriority beduinContainerPriority, @Nullable List<? extends BeduinModel> list2, @Nullable List<? extends BeduinModel> list3) {
        this.id = str;
        this.actions = list;
        this.background = beduinContainerBackground;
        this.interItemSpacing = num;
        this.padding = bedionContainerIndent;
        this.margin = bedionContainerIndent2;
        this.priority = beduinContainerPriority;
        this.leftChildren = list2;
        this.rightChildren = list3;
    }

    public static /* synthetic */ BeduinSpreadContainerModel copy$default(BeduinSpreadContainerModel beduinSpreadContainerModel, String str, List list, BeduinContainerBackground beduinContainerBackground, Integer num, BedionContainerIndent bedionContainerIndent, BedionContainerIndent bedionContainerIndent2, BeduinContainerPriority beduinContainerPriority, List list2, List list3, int i, Object obj) {
        return beduinSpreadContainerModel.copy((i & 1) != 0 ? beduinSpreadContainerModel.getId() : str, (i & 2) != 0 ? beduinSpreadContainerModel.getActions() : list, (i & 4) != 0 ? beduinSpreadContainerModel.getBackground() : beduinContainerBackground, (i & 8) != 0 ? beduinSpreadContainerModel.getInterItemSpacing() : num, (i & 16) != 0 ? beduinSpreadContainerModel.getPadding() : bedionContainerIndent, (i & 32) != 0 ? beduinSpreadContainerModel.getMargin() : bedionContainerIndent2, (i & 64) != 0 ? beduinSpreadContainerModel.priority : beduinContainerPriority, (i & 128) != 0 ? beduinSpreadContainerModel.leftChildren : list2, (i & 256) != 0 ? beduinSpreadContainerModel.rightChildren : list3);
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

    @Nullable
    public final BeduinContainerPriority component7() {
        return this.priority;
    }

    @Nullable
    public final List<BeduinModel> component8() {
        return this.leftChildren;
    }

    @Nullable
    public final List<BeduinModel> component9() {
        return this.rightChildren;
    }

    @NotNull
    public final BeduinSpreadContainerModel copy(@Nullable String str, @Nullable List<? extends BeduinAction> list, @Nullable BeduinContainerBackground beduinContainerBackground, @Nullable Integer num, @Nullable BedionContainerIndent bedionContainerIndent, @Nullable BedionContainerIndent bedionContainerIndent2, @Nullable BeduinContainerPriority beduinContainerPriority, @Nullable List<? extends BeduinModel> list2, @Nullable List<? extends BeduinModel> list3) {
        return new BeduinSpreadContainerModel(str, list, beduinContainerBackground, num, bedionContainerIndent, bedionContainerIndent2, beduinContainerPriority, list2, list3);
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
        if (!(obj instanceof BeduinSpreadContainerModel)) {
            return false;
        }
        BeduinSpreadContainerModel beduinSpreadContainerModel = (BeduinSpreadContainerModel) obj;
        return Intrinsics.areEqual(getId(), beduinSpreadContainerModel.getId()) && Intrinsics.areEqual(getActions(), beduinSpreadContainerModel.getActions()) && Intrinsics.areEqual(getBackground(), beduinSpreadContainerModel.getBackground()) && Intrinsics.areEqual(getInterItemSpacing(), beduinSpreadContainerModel.getInterItemSpacing()) && Intrinsics.areEqual(getPadding(), beduinSpreadContainerModel.getPadding()) && Intrinsics.areEqual(getMargin(), beduinSpreadContainerModel.getMargin()) && Intrinsics.areEqual(this.priority, beduinSpreadContainerModel.priority) && Intrinsics.areEqual(this.leftChildren, beduinSpreadContainerModel.leftChildren) && Intrinsics.areEqual(this.rightChildren, beduinSpreadContainerModel.rightChildren);
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

    @Nullable
    public final List<BeduinModel> getLeftChildren() {
        return this.leftChildren;
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

    @Nullable
    public final BeduinContainerPriority getPriority() {
        return this.priority;
    }

    @Nullable
    public final List<BeduinModel> getRightChildren() {
        return this.rightChildren;
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
        BeduinContainerPriority beduinContainerPriority = this.priority;
        int hashCode7 = (hashCode6 + (beduinContainerPriority != null ? beduinContainerPriority.hashCode() : 0)) * 31;
        List<BeduinModel> list = this.leftChildren;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<BeduinModel> list2 = this.rightChildren;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode8 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinContainerModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinSpreadContainerModel(id=");
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
        L.append(", priority=");
        L.append(this.priority);
        L.append(", leftChildren=");
        L.append(this.leftChildren);
        L.append(", rightChildren=");
        return a.w(L, this.rightChildren, ")");
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
        BeduinContainerPriority beduinContainerPriority = this.priority;
        if (beduinContainerPriority != null) {
            parcel.writeInt(1);
            parcel.writeString(beduinContainerPriority.name());
        } else {
            parcel.writeInt(0);
        }
        List<BeduinModel> list2 = this.leftChildren;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                parcel.writeParcelable((BeduinModel) l02.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        List<BeduinModel> list3 = this.rightChildren;
        if (list3 != null) {
            Iterator l03 = a.l0(parcel, 1, list3);
            while (l03.hasNext()) {
                parcel.writeParcelable((BeduinModel) l03.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
