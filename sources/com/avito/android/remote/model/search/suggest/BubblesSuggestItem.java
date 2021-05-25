package com.avito.android.remote.model.search.suggest;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/BubblesSuggestItem;", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "colorConfiguration", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "getColorConfiguration", "()Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "Lcom/avito/android/remote/model/search/suggest/Padding;", "padding", "Lcom/avito/android/remote/model/search/suggest/Padding;", "getPadding", "()Lcom/avito/android/remote/model/search/suggest/Padding;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem;", "bubbles", "Ljava/util/List;", "getBubbles", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/search/suggest/Padding;Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BubblesSuggestItem extends SuggestItem {
    public static final Parcelable.Creator<BubblesSuggestItem> CREATOR = new Creator();
    @SerializedName("bubbles")
    @NotNull
    private final List<SuggestBubbleItem> bubbles;
    @SerializedName("color_configuration")
    @Nullable
    private final SuggestBubbleItem.ColorConfiguration colorConfiguration;
    @SerializedName("padding")
    @Nullable
    private final Padding padding;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BubblesSuggestItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BubblesSuggestItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(SuggestBubbleItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            SuggestBubbleItem.ColorConfiguration colorConfiguration = null;
            Padding createFromParcel = parcel.readInt() != 0 ? Padding.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                colorConfiguration = SuggestBubbleItem.ColorConfiguration.CREATOR.createFromParcel(parcel);
            }
            return new BubblesSuggestItem(arrayList, createFromParcel, colorConfiguration);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BubblesSuggestItem[] newArray(int i) {
            return new BubblesSuggestItem[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubblesSuggestItem(@NotNull List<SuggestBubbleItem> list, @Nullable Padding padding2, @Nullable SuggestBubbleItem.ColorConfiguration colorConfiguration2) {
        super(null);
        Intrinsics.checkNotNullParameter(list, "bubbles");
        this.bubbles = list;
        this.padding = padding2;
        this.colorConfiguration = colorConfiguration2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<SuggestBubbleItem> getBubbles() {
        return this.bubbles;
    }

    @Nullable
    public final SuggestBubbleItem.ColorConfiguration getColorConfiguration() {
        return this.colorConfiguration;
    }

    @Nullable
    public final Padding getPadding() {
        return this.padding;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.bubbles, parcel);
        while (n0.hasNext()) {
            ((SuggestBubbleItem) n0.next()).writeToParcel(parcel, 0);
        }
        Padding padding2 = this.padding;
        if (padding2 != null) {
            parcel.writeInt(1);
            padding2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        SuggestBubbleItem.ColorConfiguration colorConfiguration2 = this.colorConfiguration;
        if (colorConfiguration2 != null) {
            parcel.writeInt(1);
            colorConfiguration2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
