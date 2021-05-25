package com.avito.android.beduin.component.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.form.TextTransform;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.model.icon.IconBase64;
import com.avito.android.beduin.core.model.icon.IconPosition;
import com.avito.android.beduin.core.model.icon.LocalIcon;
import com.avito.android.beduin.core.model.text.Alignment;
import com.avito.android.remote.model.text.AttributedText;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\n\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\u0004\bI\u0010JJ\u0017\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b)\u0010\bJ\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010-HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020*HÖ\u0001¢\u0006\u0004\b2\u0010,J \u00107\u001a\u0002062\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020*HÖ\u0001¢\u0006\u0004\b7\u00108R\u001b\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b%\u00109\u001a\u0004\b:\u0010\u0019R\u001b\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010\fR\u001b\u0010#\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010\u0013R$\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\b@\u0010\u001dR\u001b\u0010!\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010A\u001a\u0004\bB\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010A\u001a\u0004\bC\u0010\bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010D\u001a\u0004\bE\u0010\u0010R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010A\u001a\u0004\bF\u0010\bR\u001b\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010G\u001a\u0004\bH\u0010\u0016¨\u0006K"}, d2 = {"Lcom/avito/android/beduin/component/text/BeduinTextModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "transform", "apply", "(Lcom/avito/android/beduin/core/form/BeduinModelTransform;)Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "component4", "Lcom/avito/android/beduin/core/model/text/Alignment;", "component5", "()Lcom/avito/android/beduin/core/model/text/Alignment;", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "component6", "()Lcom/avito/android/beduin/core/model/icon/IconBase64;", "Lcom/avito/android/beduin/core/model/icon/IconPosition;", "component7", "()Lcom/avito/android/beduin/core/model/icon/IconPosition;", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "component8", "()Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component9", "()Ljava/util/List;", "id", "text", "attributedText", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "alignment", "base64Icon", "iconPosition", "localIcon", "actions", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/beduin/core/model/text/Alignment;Lcom/avito/android/beduin/core/model/icon/IconBase64;Lcom/avito/android/beduin/core/model/icon/IconPosition;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Ljava/util/List;)Lcom/avito/android/beduin/component/text/BeduinTextModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/beduin/core/model/icon/LocalIcon;", "getLocalIcon", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "Lcom/avito/android/beduin/core/model/icon/IconBase64;", "getBase64Icon", "Ljava/util/List;", "getActions", "Ljava/lang/String;", "getStyle", "getId", "Lcom/avito/android/beduin/core/model/text/Alignment;", "getAlignment", "getText", "Lcom/avito/android/beduin/core/model/icon/IconPosition;", "getIconPosition", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/beduin/core/model/text/Alignment;Lcom/avito/android/beduin/core/model/icon/IconBase64;Lcom/avito/android/beduin/core/model/icon/IconPosition;Lcom/avito/android/beduin/core/model/icon/LocalIcon;Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinTextModel implements BeduinModel {
    public static final Parcelable.Creator<BeduinTextModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final Alignment alignment;
    @Nullable
    private final AttributedText attributedText;
    @Nullable
    private final IconBase64 base64Icon;
    @Nullable
    private final IconPosition iconPosition;
    @Nullable
    private final String id;
    @Nullable
    private final LocalIcon localIcon;
    @Nullable
    private final String style;
    @Nullable
    private final String text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinTextModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinTextModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(BeduinTextModel.class.getClassLoader());
            String readString3 = parcel.readString();
            ArrayList arrayList = null;
            Alignment alignment = parcel.readInt() != 0 ? (Alignment) Enum.valueOf(Alignment.class, parcel.readString()) : null;
            IconBase64 createFromParcel = parcel.readInt() != 0 ? IconBase64.CREATOR.createFromParcel(parcel) : null;
            IconPosition iconPosition = parcel.readInt() != 0 ? (IconPosition) Enum.valueOf(IconPosition.class, parcel.readString()) : null;
            LocalIcon createFromParcel2 = parcel.readInt() != 0 ? LocalIcon.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinTextModel.class.getClassLoader()));
                    readInt--;
                }
            }
            return new BeduinTextModel(readString, readString2, attributedText, readString3, alignment, createFromParcel, iconPosition, createFromParcel2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinTextModel[] newArray(int i) {
            return new BeduinTextModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinTextModel(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText2, @Nullable String str3, @Nullable Alignment alignment2, @Nullable IconBase64 iconBase64, @Nullable IconPosition iconPosition2, @Nullable LocalIcon localIcon2, @Nullable List<? extends BeduinAction> list) {
        this.id = str;
        this.text = str2;
        this.attributedText = attributedText2;
        this.style = str3;
        this.alignment = alignment2;
        this.base64Icon = iconBase64;
        this.iconPosition = iconPosition2;
        this.localIcon = localIcon2;
        this.actions = list;
    }

    public static /* synthetic */ BeduinTextModel copy$default(BeduinTextModel beduinTextModel, String str, String str2, AttributedText attributedText2, String str3, Alignment alignment2, IconBase64 iconBase64, IconPosition iconPosition2, LocalIcon localIcon2, List list, int i, Object obj) {
        return beduinTextModel.copy((i & 1) != 0 ? beduinTextModel.getId() : str, (i & 2) != 0 ? beduinTextModel.text : str2, (i & 4) != 0 ? beduinTextModel.attributedText : attributedText2, (i & 8) != 0 ? beduinTextModel.style : str3, (i & 16) != 0 ? beduinTextModel.alignment : alignment2, (i & 32) != 0 ? beduinTextModel.base64Icon : iconBase64, (i & 64) != 0 ? beduinTextModel.iconPosition : iconPosition2, (i & 128) != 0 ? beduinTextModel.localIcon : localIcon2, (i & 256) != 0 ? beduinTextModel.getActions() : list);
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public BeduinModel apply(@NotNull BeduinModelTransform beduinModelTransform) {
        Intrinsics.checkNotNullParameter(beduinModelTransform, "transform");
        return beduinModelTransform instanceof TextTransform ? copy$default(this, null, ((TextTransform) beduinModelTransform).getText(), null, null, null, null, null, null, null, 509, null) : this;
    }

    @Nullable
    public final String component1() {
        return getId();
    }

    @Nullable
    public final String component2() {
        return this.text;
    }

    @Nullable
    public final AttributedText component3() {
        return this.attributedText;
    }

    @Nullable
    public final String component4() {
        return this.style;
    }

    @Nullable
    public final Alignment component5() {
        return this.alignment;
    }

    @Nullable
    public final IconBase64 component6() {
        return this.base64Icon;
    }

    @Nullable
    public final IconPosition component7() {
        return this.iconPosition;
    }

    @Nullable
    public final LocalIcon component8() {
        return this.localIcon;
    }

    @Nullable
    public final List<BeduinAction> component9() {
        return getActions();
    }

    @NotNull
    public final BeduinTextModel copy(@Nullable String str, @Nullable String str2, @Nullable AttributedText attributedText2, @Nullable String str3, @Nullable Alignment alignment2, @Nullable IconBase64 iconBase64, @Nullable IconPosition iconPosition2, @Nullable LocalIcon localIcon2, @Nullable List<? extends BeduinAction> list) {
        return new BeduinTextModel(str, str2, attributedText2, str3, alignment2, iconBase64, iconPosition2, localIcon2, list);
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
        if (!(obj instanceof BeduinTextModel)) {
            return false;
        }
        BeduinTextModel beduinTextModel = (BeduinTextModel) obj;
        return Intrinsics.areEqual(getId(), beduinTextModel.getId()) && Intrinsics.areEqual(this.text, beduinTextModel.text) && Intrinsics.areEqual(this.attributedText, beduinTextModel.attributedText) && Intrinsics.areEqual(this.style, beduinTextModel.style) && Intrinsics.areEqual(this.alignment, beduinTextModel.alignment) && Intrinsics.areEqual(this.base64Icon, beduinTextModel.base64Icon) && Intrinsics.areEqual(this.iconPosition, beduinTextModel.iconPosition) && Intrinsics.areEqual(this.localIcon, beduinTextModel.localIcon) && Intrinsics.areEqual(getActions(), beduinTextModel.getActions());
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @Nullable
    public List<BeduinAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final AttributedText getAttributedText() {
        return this.attributedText;
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

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String str = this.text;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.attributedText;
        int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        String str2 = this.style;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Alignment alignment2 = this.alignment;
        int hashCode5 = (hashCode4 + (alignment2 != null ? alignment2.hashCode() : 0)) * 31;
        IconBase64 iconBase64 = this.base64Icon;
        int hashCode6 = (hashCode5 + (iconBase64 != null ? iconBase64.hashCode() : 0)) * 31;
        IconPosition iconPosition2 = this.iconPosition;
        int hashCode7 = (hashCode6 + (iconPosition2 != null ? iconPosition2.hashCode() : 0)) * 31;
        LocalIcon localIcon2 = this.localIcon;
        int hashCode8 = (hashCode7 + (localIcon2 != null ? localIcon2.hashCode() : 0)) * 31;
        List<BeduinAction> actions2 = getActions();
        if (actions2 != null) {
            i = actions2.hashCode();
        }
        return hashCode8 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinTextModel(id=");
        L.append(getId());
        L.append(", text=");
        L.append(this.text);
        L.append(", attributedText=");
        L.append(this.attributedText);
        L.append(", style=");
        L.append(this.style);
        L.append(", alignment=");
        L.append(this.alignment);
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
        parcel.writeString(this.text);
        parcel.writeParcelable(this.attributedText, i);
        parcel.writeString(this.style);
        Alignment alignment2 = this.alignment;
        if (alignment2 != null) {
            parcel.writeInt(1);
            parcel.writeString(alignment2.name());
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
