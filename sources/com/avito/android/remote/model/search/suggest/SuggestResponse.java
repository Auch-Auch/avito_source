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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/search/suggest/SuggestItem;", "result", "Ljava/util/List;", "getResult", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestResponse implements Parcelable {
    public static final Parcelable.Creator<SuggestResponse> CREATOR = new Creator();
    @SerializedName("result")
    @NotNull
    private final List<SuggestItem> result;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SuggestItem) parcel.readParcelable(SuggestResponse.class.getClassLoader()));
                readInt--;
            }
            return new SuggestResponse(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestResponse[] newArray(int i) {
            return new SuggestResponse[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.search.suggest.SuggestItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public SuggestResponse(@NotNull List<? extends SuggestItem> list) {
        Intrinsics.checkNotNullParameter(list, "result");
        this.result = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<SuggestItem> getResult() {
        return this.result;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.result, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((SuggestItem) n0.next(), i);
        }
    }
}
