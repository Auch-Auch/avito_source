package com.avito.android.remote.model.publish;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.search.suggest.SuggestAction;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/publish/BubbleSuggest;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/publish/BubbleSuggest$SuggestType;", "type", "Lcom/avito/android/remote/model/publish/BubbleSuggest$SuggestType;", "getType", "()Lcom/avito/android/remote/model/publish/BubbleSuggest$SuggestType;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "replacementText", "getReplacementText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/publish/BubbleSuggest$SuggestType;Ljava/util/List;)V", "SuggestType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BubbleSuggest implements Parcelable {
    public static final Parcelable.Creator<BubbleSuggest> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final List<SuggestAction> actions;
    @SerializedName("title")
    @NotNull
    private final String replacementText;
    @SerializedName("text")
    @NotNull
    private final String title;
    @SerializedName("type")
    @NotNull
    private final SuggestType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BubbleSuggest> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BubbleSuggest createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            SuggestType suggestType = (SuggestType) Enum.valueOf(SuggestType.class, parcel.readString());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SuggestAction) parcel.readParcelable(BubbleSuggest.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new BubbleSuggest(readString, readString2, suggestType, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BubbleSuggest[] newArray(int i) {
            return new BubbleSuggest[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/publish/BubbleSuggest$SuggestType;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TYPO", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum SuggestType {
        NORMAL,
        TYPO
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.search.suggest.SuggestAction> */
    /* JADX WARN: Multi-variable type inference failed */
    public BubbleSuggest(@NotNull String str, @NotNull String str2, @NotNull SuggestType suggestType, @Nullable List<? extends SuggestAction> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "replacementText");
        Intrinsics.checkNotNullParameter(suggestType, "type");
        this.title = str;
        this.replacementText = str2;
        this.type = suggestType;
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

    @NotNull
    public final String getReplacementText() {
        return this.replacementText;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final SuggestType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.replacementText);
        parcel.writeString(this.type.name());
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
