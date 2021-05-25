package com.avito.android.remote.model.search.suggest;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/search/suggest/TextSuggestItem;", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "title", "getTitle", "minHeight", "Ljava/lang/Integer;", "getMinHeight", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/search/suggest/Padding;", "padding", "Lcom/avito/android/remote/model/search/suggest/Padding;", "getPadding", "()Lcom/avito/android/remote/model/search/suggest/Padding;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/search/suggest/IconSource;", "icon", "Lcom/avito/android/remote/model/search/suggest/IconSource;", "getIcon", "()Lcom/avito/android/remote/model/search/suggest/IconSource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/search/suggest/IconSource;Lcom/avito/android/remote/model/search/suggest/Padding;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class TextSuggestItem extends SuggestItem {
    public static final Parcelable.Creator<TextSuggestItem> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final List<SuggestAction> actions;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("icon")
    @Nullable
    private final IconSource icon;
    @SerializedName("minimal_height")
    @Nullable
    private final Integer minHeight;
    @SerializedName("padding")
    @Nullable
    private final Padding padding;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<TextSuggestItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextSuggestItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            IconSource iconSource = (IconSource) parcel.readParcelable(TextSuggestItem.class.getClassLoader());
            Padding createFromParcel = parcel.readInt() != 0 ? Padding.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SuggestAction) parcel.readParcelable(TextSuggestItem.class.getClassLoader()));
                    readInt--;
                }
            }
            return new TextSuggestItem(readString, readString2, valueOf, iconSource, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final TextSuggestItem[] newArray(int i) {
            return new TextSuggestItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.avito.android.remote.model.search.suggest.SuggestAction> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextSuggestItem(@NotNull String str, @Nullable String str2, @Nullable Integer num, @Nullable IconSource iconSource, @Nullable Padding padding2, @Nullable List<? extends SuggestAction> list) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.minHeight = num;
        this.icon = iconSource;
        this.padding = padding2;
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
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final IconSource getIcon() {
        return this.icon;
    }

    @Nullable
    public final Integer getMinHeight() {
        return this.minHeight;
    }

    @Nullable
    public final Padding getPadding() {
        return this.padding;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Integer num = this.minHeight;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.icon, i);
        Padding padding2 = this.padding;
        if (padding2 != null) {
            parcel.writeInt(1);
            padding2.writeToParcel(parcel, 0);
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
