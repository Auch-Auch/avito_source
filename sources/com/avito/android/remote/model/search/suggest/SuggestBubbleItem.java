package com.avito.android.remote.model.search.suggest;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Color;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001!B3\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "colorConfiguration", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "getColorConfiguration", "()Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "setColorConfiguration", "(Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;)V", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;Ljava/util/List;)V", "ColorConfiguration", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestBubbleItem implements Parcelable {
    public static final Parcelable.Creator<SuggestBubbleItem> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final List<SuggestAction> actions;
    @SerializedName("color_configuration")
    @Nullable
    private ColorConfiguration colorConfiguration;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("text")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "border", "Lcom/avito/android/remote/model/Color;", "getBorder", "()Lcom/avito/android/remote/model/Color;", "text", "getText", "description", "getDescription", "highlightedBackground", "getHighlightedBackground", "background", "getBackground", "<init>", "(Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ColorConfiguration implements Parcelable {
        public static final Parcelable.Creator<ColorConfiguration> CREATOR = new Creator();
        @SerializedName("background")
        @Nullable
        private final Color background;
        @SerializedName("border")
        @Nullable
        private final Color border;
        @SerializedName("description")
        @Nullable
        private final Color description;
        @SerializedName("highlighted_background")
        @Nullable
        private final Color highlightedBackground;
        @SerializedName("text")
        @Nullable
        private final Color text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ColorConfiguration> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ColorConfiguration createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ColorConfiguration(parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ColorConfiguration[] newArray(int i) {
                return new ColorConfiguration[i];
            }
        }

        public ColorConfiguration(@Nullable Color color, @Nullable Color color2, @Nullable Color color3, @Nullable Color color4, @Nullable Color color5) {
            this.background = color;
            this.highlightedBackground = color2;
            this.border = color3;
            this.text = color4;
            this.description = color5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Color getBackground() {
            return this.background;
        }

        @Nullable
        public final Color getBorder() {
            return this.border;
        }

        @Nullable
        public final Color getDescription() {
            return this.description;
        }

        @Nullable
        public final Color getHighlightedBackground() {
            return this.highlightedBackground;
        }

        @Nullable
        public final Color getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Color color = this.background;
            if (color != null) {
                parcel.writeInt(1);
                color.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Color color2 = this.highlightedBackground;
            if (color2 != null) {
                parcel.writeInt(1);
                color2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Color color3 = this.border;
            if (color3 != null) {
                parcel.writeInt(1);
                color3.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Color color4 = this.text;
            if (color4 != null) {
                parcel.writeInt(1);
                color4.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Color color5 = this.description;
            if (color5 != null) {
                parcel.writeInt(1);
                color5.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestBubbleItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestBubbleItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            ColorConfiguration createFromParcel = parcel.readInt() != 0 ? ColorConfiguration.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((SuggestAction) parcel.readParcelable(SuggestBubbleItem.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            }
            return new SuggestBubbleItem(readString, readString2, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestBubbleItem[] newArray(int i) {
            return new SuggestBubbleItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.search.suggest.SuggestAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public SuggestBubbleItem(@NotNull String str, @Nullable String str2, @Nullable ColorConfiguration colorConfiguration2, @Nullable List<? extends SuggestAction> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.colorConfiguration = colorConfiguration2;
        this.actions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<SuggestAction> getActions() {
        return this.actions;
    }

    @Nullable
    public final ColorConfiguration getColorConfiguration() {
        return this.colorConfiguration;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final void setColorConfiguration(@Nullable ColorConfiguration colorConfiguration2) {
        this.colorConfiguration = colorConfiguration2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        ColorConfiguration colorConfiguration2 = this.colorConfiguration;
        if (colorConfiguration2 != null) {
            parcel.writeInt(1);
            colorConfiguration2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<SuggestAction> list = this.actions;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((SuggestAction) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
