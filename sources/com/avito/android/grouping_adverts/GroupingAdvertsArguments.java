package com.avito.android.grouping_adverts;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "Landroid/os/Parcelable;", "<init>", "()V", "ItemList", "Search", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$Search;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public abstract class GroupingAdvertsArguments implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", "c", "Ljava/util/List;", "getIds", "()Ljava/util/List;", "ids", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemList extends GroupingAdvertsArguments {
        public static final Parcelable.Creator<ItemList> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final List<String> c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ItemList> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemList createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ItemList(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemList[] newArray(int i) {
                return new ItemList[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemList(@Nullable String str, @Nullable String str2, @NotNull List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "ids");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<String> getIds() {
            return this.c;
        }

        @Nullable
        public final String getSubtitle() {
            return this.b;
        }

        @Nullable
        public final String getTitle() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeStringList(this.c);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$Search;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SearchParams;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SearchParams;", "getParams", "()Lcom/avito/android/remote/model/SearchParams;", "params", "<init>", "(Lcom/avito/android/remote/model/SearchParams;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Search extends GroupingAdvertsArguments {
        public static final Parcelable.Creator<Search> CREATOR = new Creator();
        @NotNull
        public final SearchParams a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Search> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Search createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Search((SearchParams) parcel.readParcelable(Search.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Search[] newArray(int i) {
                return new Search[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Search(@NotNull SearchParams searchParams) {
            super(null);
            Intrinsics.checkNotNullParameter(searchParams, "params");
            this.a = searchParams;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final SearchParams getParams() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
        }
    }

    public GroupingAdvertsArguments() {
    }

    public GroupingAdvertsArguments(j jVar) {
    }
}
