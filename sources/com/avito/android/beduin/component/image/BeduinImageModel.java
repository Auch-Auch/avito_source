package com.avito.android.beduin.component.image;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.form.BeduinModelTransform;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.beduin.core.model.image.Size;
import com.avito.android.remote.model.Image;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b3\u00104J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b'\u0010(R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010\u000eR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u0010\u0011R\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b2\u0010\u000b¨\u00065"}, d2 = {"Lcom/avito/android/beduin/component/image/BeduinImageModel;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/beduin/core/action/BeduinAction;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Image;", "component3", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/beduin/core/model/image/Size;", "component4", "()Lcom/avito/android/beduin/core/model/image/Size;", "Lcom/avito/android/beduin/component/image/ImageStyle;", "component5", "()Lcom/avito/android/beduin/component/image/ImageStyle;", "id", "actions", "image", "size", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Image;Lcom/avito/android/beduin/core/model/image/Size;Lcom/avito/android/beduin/component/image/ImageStyle;)Lcom/avito/android/beduin/component/image/BeduinImageModel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getActions", "Ljava/lang/String;", "getId", "Lcom/avito/android/beduin/core/model/image/Size;", "getSize", "Lcom/avito/android/beduin/component/image/ImageStyle;", "getStyle", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Image;Lcom/avito/android/beduin/core/model/image/Size;Lcom/avito/android/beduin/component/image/ImageStyle;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinImageModel implements BeduinModel {
    public static final Parcelable.Creator<BeduinImageModel> CREATOR = new Creator();
    @Nullable
    private final List<BeduinAction> actions;
    @Nullable
    private final String id;
    @NotNull
    private final Image image;
    @NotNull
    private final Size size;
    @Nullable
    private final ImageStyle style;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BeduinImageModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinImageModel createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((BeduinAction) parcel.readParcelable(BeduinImageModel.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new BeduinImageModel(readString, arrayList, (Image) parcel.readParcelable(BeduinImageModel.class.getClassLoader()), Size.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ImageStyle.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BeduinImageModel[] newArray(int i) {
            return new BeduinImageModel[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.action.BeduinAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BeduinImageModel(@Nullable String str, @Nullable List<? extends BeduinAction> list, @NotNull Image image2, @NotNull Size size2, @Nullable ImageStyle imageStyle) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(size2, "size");
        this.id = str;
        this.actions = list;
        this.image = image2;
        this.size = size2;
        this.style = imageStyle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.beduin.component.image.BeduinImageModel */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeduinImageModel copy$default(BeduinImageModel beduinImageModel, String str, List list, Image image2, Size size2, ImageStyle imageStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            str = beduinImageModel.getId();
        }
        if ((i & 2) != 0) {
            list = beduinImageModel.getActions();
        }
        if ((i & 4) != 0) {
            image2 = beduinImageModel.image;
        }
        if ((i & 8) != 0) {
            size2 = beduinImageModel.size;
        }
        if ((i & 16) != 0) {
            imageStyle = beduinImageModel.style;
        }
        return beduinImageModel.copy(str, list, image2, size2, imageStyle);
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
    public final Image component3() {
        return this.image;
    }

    @NotNull
    public final Size component4() {
        return this.size;
    }

    @Nullable
    public final ImageStyle component5() {
        return this.style;
    }

    @NotNull
    public final BeduinImageModel copy(@Nullable String str, @Nullable List<? extends BeduinAction> list, @NotNull Image image2, @NotNull Size size2, @Nullable ImageStyle imageStyle) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(size2, "size");
        return new BeduinImageModel(str, list, image2, size2, imageStyle);
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
        if (!(obj instanceof BeduinImageModel)) {
            return false;
        }
        BeduinImageModel beduinImageModel = (BeduinImageModel) obj;
        return Intrinsics.areEqual(getId(), beduinImageModel.getId()) && Intrinsics.areEqual(getActions(), beduinImageModel.getActions()) && Intrinsics.areEqual(this.image, beduinImageModel.image) && Intrinsics.areEqual(this.size, beduinImageModel.size) && Intrinsics.areEqual(this.style, beduinImageModel.style);
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

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    @NotNull
    public Map<String, Object> getParameters() {
        return BeduinModel.DefaultImpls.getParameters(this);
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    @Nullable
    public final ImageStyle getStyle() {
        return this.style;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        List<BeduinAction> actions2 = getActions();
        int hashCode2 = (hashCode + (actions2 != null ? actions2.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode3 = (hashCode2 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Size size2 = this.size;
        int hashCode4 = (hashCode3 + (size2 != null ? size2.hashCode() : 0)) * 31;
        ImageStyle imageStyle = this.style;
        if (imageStyle != null) {
            i = imageStyle.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.avito.android.beduin.core.model.container.component.BeduinModel
    public boolean isValid() {
        return BeduinModel.DefaultImpls.isValid(this);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("BeduinImageModel(id=");
        L.append(getId());
        L.append(", actions=");
        L.append(getActions());
        L.append(", image=");
        L.append(this.image);
        L.append(", size=");
        L.append(this.size);
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
        parcel.writeParcelable(this.image, i);
        this.size.writeToParcel(parcel, 0);
        ImageStyle imageStyle = this.style;
        if (imageStyle != null) {
            parcel.writeInt(1);
            imageStyle.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
