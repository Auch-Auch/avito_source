package com.avito.android.remote.model.category_parameters.slot.information;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.slot.SlotConfig;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlotConfig;", "Lcom/avito/android/remote/model/category_parameters/slot/SlotConfig;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "text", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/category_parameters/slot/information/InformationSlotConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class InformationSlotConfig implements SlotConfig {
    public static final Parcelable.Creator<InformationSlotConfig> CREATOR = new Creator();
    @SerializedName("text")
    @NotNull
    private final AttributedText text;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<InformationSlotConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InformationSlotConfig createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new InformationSlotConfig((AttributedText) parcel.readParcelable(InformationSlotConfig.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final InformationSlotConfig[] newArray(int i) {
            return new InformationSlotConfig[i];
        }
    }

    public InformationSlotConfig(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.text = attributedText;
    }

    public static /* synthetic */ InformationSlotConfig copy$default(InformationSlotConfig informationSlotConfig, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            attributedText = informationSlotConfig.text;
        }
        return informationSlotConfig.copy(attributedText);
    }

    @NotNull
    public final AttributedText component1() {
        return this.text;
    }

    @NotNull
    public final InformationSlotConfig copy(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        return new InformationSlotConfig(attributedText);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof InformationSlotConfig) && Intrinsics.areEqual(this.text, ((InformationSlotConfig) obj).text);
        }
        return true;
    }

    @NotNull
    public final AttributedText getText() {
        return this.text;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AttributedText attributedText = this.text;
        if (attributedText != null) {
            return attributedText.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("InformationSlotConfig(text=");
        L.append(this.text);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.text, i);
    }
}
