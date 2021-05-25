package com.avito.android.beduin.component.button;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.form.IsEnabledTransform;
import com.avito.android.beduin.core.form.TextTransform;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.model.icon.IconBase64;
import com.avito.android.beduin.core.model.icon.IconPosition;
import com.avito.android.beduin.core.model.icon.LocalIcon;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJr\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b%\u0010\bJ\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020&HÖ\u0001¢\u0006\u0004\b-\u0010(J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020&HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u0010\bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b7\u0010\u0010R$\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\b9\u0010\u001aR\u001b\u0010!\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010:\u001a\u0004\b;\u0010\u0016R\u001b\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u0010<\u001a\u0004\b=\u0010\u0013R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010>\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u001c\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b?\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b@\u0010\b¨\u0006C"}, d2 = {"Lcom/avito/android/beduin/component/button/BeduinButtonModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "transform", "apply", "(Lcom/avito/android/beduin/core/form/BeduinModelTransform;)Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()Ljava/lang/Boolean;", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "component5", "()Lcom/avito/android/beduin/core/model/icon/IconBase64;", "Lcom/avito/android/beduin/core/model/icon/IconPosition;", "component6", "()Lcom/avito/android/beduin/core/model/icon/IconPosition;", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "component7", "()Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component8", "()Ljava/util/List;", "id", "title", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "isEnabled", "base64Icon", "iconPosition", "localIcon", "actions", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/beduin/core/model/icon/IconBase64;Lcom/avito/android/beduin/core/model/icon/IconPosition;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Ljava/util/List;)Lcom/avito/android/beduin/component/button/BeduinButtonModel;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getStyle", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "getBase64Icon", "Ljava/util/List;", "getActions", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "getLocalIcon", "Lcom/avito/android/beduin/core/model/icon/IconPosition;", "getIconPosition", "Ljava/lang/Boolean;", "getTitle", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/beduin/core/model/icon/IconBase64;Lcom/avito/android/beduin/core/model/icon/IconPosition;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinButtonModel implements BeduinModel {
    public static final Parcelable.Creator<BeduinButtonModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final IconBase64 base64Icon;
    @Nullable
    private final IconPosition iconPosition;
    @Nullable
    private final String id;
    @Nullable
    private final Boolean isEnabled;
    @Nullable
    private final LocalIcon localIcon;
    @NotNull
    private final String style;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinButtonModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinButtonModel createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList arrayList = null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            IconBase64 createFromParcel = parcel.readInt() != 0 ? IconBase64.CREATOR.createFromParcel(parcel) : null;
            IconPosition iconPosition = parcel.readInt() != 0 ? (IconPosition) Enum.valueOf(IconPosition.class, parcel.readString()) : null;
            LocalIcon createFromParcel2 = parcel.readInt() != 0 ? LocalIcon.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinButtonModel.class.getClassLoader()));
                    readInt--;
                }
            }
            return new BeduinButtonModel(readString, readString2, readString3, bool, createFromParcel, iconPosition, createFromParcel2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinButtonModel[] newArray(int i) {
            return new BeduinButtonModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinButtonModel(@Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool, @Nullable IconBase64 iconBase64, @Nullable IconPosition iconPosition2, @Nullable LocalIcon localIcon2, @Nullable List<? extends BeduinAction> list) {
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.id = str;
        this.title = str2;
        this.style = str3;
        this.isEnabled = bool;
        this.base64Icon = iconBase64;
        this.iconPosition = iconPosition2;
        this.localIcon = localIcon2;
        this.actions = list;
    }

    public static /* synthetic */ BeduinButtonModel copy$default(BeduinButtonModel beduinButtonModel, String str, String str2, String str3, Boolean bool, IconBase64 iconBase64, IconPosition iconPosition2, LocalIcon localIcon2, List list, int i, Object obj) {
        return beduinButtonModel.copy((i & 1) != 0 ? beduinButtonModel.getId() : str, (i & 2) != 0 ? beduinButtonModel.title : str2, (i & 4) != 0 ? beduinButtonModel.style : str3, (i & 8) != 0 ? beduinButtonModel.isEnabled : bool, (i & 16) != 0 ? beduinButtonModel.base64Icon : iconBase64, (i & 32) != 0 ? beduinButtonModel.iconPosition : iconPosition2, (i & 64) != 0 ? beduinButtonModel.localIcon : localIcon2, (i & 128) != 0 ? beduinButtonModel.getActions() : list);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public BeduinModel apply(@NotNull BeduinModelTransform beduinModelTransform) {
        Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
        if (beduinModelTransform instanceof TextTransform) {
            return copy$default(this, null, ((TextTransform) beduinModelTransform).getText(), null, null, null, null, null, null, 253, null);
        }
        return beduinModelTransform instanceof IsEnabledTransform ? copy$default(this, null, null, null, Boolean.valueOf(((IsEnabledTransform) beduinModelTransform).isEnabled()), null, null, null, null, 247, null) : this;
    }

    @Nullable
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.style;
    }

    @Nullable
    public final Boolean component4() {
        return this.isEnabled;
    }

    @Nullable
    public final IconBase64 component5() {
        return this.base64Icon;
    }

    @Nullable
    public final IconPosition component6() {
        return this.iconPosition;
    }

    @Nullable
    public final LocalIcon component7() {
        return this.localIcon;
    }

    @Nullable
    public final List<BeduinAction> component8() {
        return getActions();
    }

    @NotNull
    public final BeduinButtonModel copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable Boolean bool, @Nullable IconBase64 iconBase64, @Nullable IconPosition iconPosition2, @Nullable LocalIcon localIcon2, @Nullable List<? extends BeduinAction> list) {
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new BeduinButtonModel(str, str2, str3, bool, iconBase64, iconPosition2, localIcon2, list);
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
        if (!(obj instanceof BeduinButtonModel)) {
            return false;
        }
        BeduinButtonModel beduinButtonModel = (BeduinButtonModel) obj;
        return Intrinsics.areEqual(getId(), beduinButtonModel.getId()) && Intrinsics.areEqual(this.title, beduinButtonModel.title) && Intrinsics.areEqual(this.style, beduinButtonModel.style) && Intrinsics.areEqual(this.isEnabled, beduinButtonModel.isEnabled) && Intrinsics.areEqual(this.base64Icon, beduinButtonModel.base64Icon) && Intrinsics.areEqual(this.iconPosition, beduinButtonModel.iconPosition) && Intrinsics.areEqual(this.localIcon, beduinButtonModel.localIcon) && Intrinsics.areEqual(getActions(), beduinButtonModel.getActions());
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public List<BeduinAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final IconBase64 getBase64Icon() {
        return this.base64Icon;
    }

    @Nullable
    public final IconPosition getIconPosition() {
        return this.iconPosition;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public String getId() {
        return this.id;
    }

    @Nullable
    public final LocalIcon getLocalIcon() {
        return this.localIcon;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public Map<String, Object> getParameters() {
        return BeduinModel.DefaultImpls.getParameters(this);
    }

    @NotNull
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.style;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.isEnabled;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        IconBase64 iconBase64 = this.base64Icon;
        int hashCode5 = (hashCode4 + (iconBase64 != null ? iconBase64.hashCode() : 0)) * 31;
        IconPosition iconPosition2 = this.iconPosition;
        int hashCode6 = (hashCode5 + (iconPosition2 != null ? iconPosition2.hashCode() : 0)) * 31;
        LocalIcon localIcon2 = this.localIcon;
        int hashCode7 = (hashCode6 + (localIcon2 != null ? localIcon2.hashCode() : 0)) * 31;
        List<BeduinAction> actions2 = getActions();
        if (actions2 != null) {
            i = actions2.hashCode();
        }
        return hashCode7 + i;
    }

    @Nullable
    public final Boolean isEnabled() {
        return this.isEnabled;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinButtonModel(id=");
        L.append(getId());
        L.append(", title=");
        L.append(this.title);
        L.append(", style=");
        L.append(this.style);
        L.append(", isEnabled=");
        L.append(this.isEnabled);
        L.append(", base64Icon=");
        L.append(this.base64Icon);
        L.append(", iconPosition=");
        L.append(this.iconPosition);
        L.append(", localIcon=");
        L.append(this.localIcon);
        L.append(", actions=");
        L.append(getActions());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.style);
        Boolean bool = this.isEnabled;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        IconBase64 iconBase64 = this.base64Icon;
        if (iconBase64 != null) {
            parcel.writeInt(1);
            iconBase64.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        IconPosition iconPosition2 = this.iconPosition;
        if (iconPosition2 != null) {
            parcel.writeInt(1);
            parcel.writeString(iconPosition2.name());
        } else {
            parcel.writeInt(0);
        }
        LocalIcon localIcon2 = this.localIcon;
        if (localIcon2 != null) {
            parcel.writeInt(1);
            localIcon2.writeToParcel(parcel, 0);
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
