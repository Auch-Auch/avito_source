package com.avito.android.remote.model.search.suggest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestNewQuery;", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "query", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestNewQuery extends SuggestAction {
    public static final Parcelable.Creator<SuggestNewQuery> CREATOR = new Creator();
    @SerializedName("new_query")
    @NotNull
    private final String query;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestNewQuery> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestNewQuery createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SuggestNewQuery(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestNewQuery[] newArray(int i) {
            return new SuggestNewQuery[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestNewQuery(@NotNull String str) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "query");
        this.query = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getQuery() {
        return this.query;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.query);
    }
}
