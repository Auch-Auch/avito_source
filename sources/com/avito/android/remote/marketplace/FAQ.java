package com.avito.android.remote.marketplace;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.SimpleAdvertAction;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/marketplace/FAQ;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "action", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "getAction", "()Lcom/avito/android/remote/model/SimpleAdvertAction;", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "displayCount", "I", "getDisplayCount", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;ILcom/avito/android/remote/model/SimpleAdvertAction;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class FAQ implements Parcelable {
    public static final Parcelable.Creator<FAQ> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final SimpleAdvertAction action;
    @SerializedName("displayCount")
    private final int displayCount;
    @SerializedName("items")
    @NotNull
    private final List<AdvertParameters.Parameter> items;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<FAQ> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FAQ createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AdvertParameters.Parameter) parcel.readParcelable(FAQ.class.getClassLoader()));
                readInt--;
            }
            return new FAQ(readString, arrayList, parcel.readInt(), (SimpleAdvertAction) parcel.readParcelable(FAQ.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final FAQ[] newArray(int i) {
            return new FAQ[i];
        }
    }

    public FAQ(@NotNull String str, @NotNull List<AdvertParameters.Parameter> list, int i, @NotNull SimpleAdvertAction simpleAdvertAction) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(simpleAdvertAction, "action");
        this.title = str;
        this.items = list;
        this.displayCount = i;
        this.action = simpleAdvertAction;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final SimpleAdvertAction getAction() {
        return this.action;
    }

    public final int getDisplayCount() {
        return this.displayCount;
    }

    @NotNull
    public final List<AdvertParameters.Parameter> getItems() {
        return this.items;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.items, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((AdvertParameters.Parameter) n0.next(), i);
        }
        parcel.writeInt(this.displayCount);
        parcel.writeParcelable(this.action, i);
    }
}
