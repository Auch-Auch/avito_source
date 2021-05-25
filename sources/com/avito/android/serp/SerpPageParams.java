package com.avito.android.serp;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PageParams;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00011B9\b\u0002\u0012\u0006\u0010(\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010.\u001a\u00020)\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b/\u00100J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J-\u0010\f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\u000fJ!\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010(\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0018R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/serp/SerpPageParams;", "Landroid/os/Parcelable;", "", "isFirstPage", "()Z", "hasNextPage", "", UrlParams.LAST_STAMP, "", "count", "", UrlParams.NEXT_PAGE_ID, "createNextPage", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)Lcom/avito/android/serp/SerpPageParams;", "createEmptySearch", "(Ljava/lang/Long;)Lcom/avito/android/serp/SerpPageParams;", "createErrorSearch", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "d", "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", AuthSource.BOOKING_ORDER, "Ljava/lang/Long;", "getLastStamp", "()Ljava/lang/Long;", "e", "Ljava/lang/String;", "getNextPageId", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "I", "getPage", "page", "Lcom/avito/android/serp/SearchType;", "c", "Lcom/avito/android/serp/SearchType;", "getSearchType", "()Lcom/avito/android/serp/SearchType;", "searchType", "<init>", "(ILjava/lang/Long;Lcom/avito/android/serp/SearchType;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpPageParams implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpPageParams> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final int a;
    @Nullable
    public final Long b;
    @NotNull
    public final SearchType c;
    @Nullable
    public final Integer d;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/SerpPageParams$Companion;", "", "Lcom/avito/android/serp/SerpPageParams;", "createFirstPage", "()Lcom/avito/android/serp/SerpPageParams;", "Lcom/avito/android/remote/model/PageParams;", "pageParams", "", "emptySearch", "createPageParams", "(Lcom/avito/android/remote/model/PageParams;Z)Lcom/avito/android/serp/SerpPageParams;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SerpPageParams createFirstPage() {
            return new SerpPageParams(1, null, SearchType.NORMAL, null, null, 16);
        }

        @NotNull
        public final SerpPageParams createPageParams(@NotNull PageParams pageParams, boolean z) {
            SearchType searchType;
            Intrinsics.checkNotNullParameter(pageParams, "pageParams");
            if (z) {
                searchType = SearchType.EMPTY;
            } else {
                searchType = SearchType.NORMAL;
            }
            return new SerpPageParams(pageParams.getPage(), pageParams.getLastStamp(), searchType, null, null, 16);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SerpPageParams> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SerpPageParams invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            int readInt = parcel2.readInt();
            Object readValue = parcel2.readValue(Long.class.getClassLoader());
            Integer num = null;
            if (!(readValue instanceof Long)) {
                readValue = null;
            }
            Long l = (Long) readValue;
            SearchType searchType = (SearchType) ParcelsKt.readEnum(parcel2, SearchType.values());
            Object readValue2 = parcel2.readValue(Integer.class.getClassLoader());
            if (readValue2 instanceof Integer) {
                num = readValue2;
            }
            return new SerpPageParams(readInt, l, searchType, num, null, 16);
        }
    }

    public SerpPageParams(int i, Long l, SearchType searchType, Integer num, String str) {
        this.a = i;
        this.b = l;
        this.c = searchType;
        this.d = num;
        this.e = str;
    }

    public static /* synthetic */ SerpPageParams createNextPage$default(SerpPageParams serpPageParams, Long l, Integer num, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        return serpPageParams.createNextPage(l, num, str);
    }

    @NotNull
    public final SerpPageParams createEmptySearch(@Nullable Long l) {
        return new SerpPageParams(this.a + 1, l, SearchType.EMPTY, 0, null, 16);
    }

    @NotNull
    public final SerpPageParams createErrorSearch(@Nullable Long l) {
        return new SerpPageParams(this.a, l, this.c, this.d, null, 16);
    }

    @NotNull
    public final SerpPageParams createNextPage(@Nullable Long l, @Nullable Integer num, @Nullable String str) {
        return new SerpPageParams(this.a + 1, l, SearchType.NORMAL, num, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Integer getCount() {
        return this.d;
    }

    @Nullable
    public final Long getLastStamp() {
        return this.b;
    }

    @Nullable
    public final String getNextPageId() {
        return this.e;
    }

    public final int getPage() {
        return this.a;
    }

    @NotNull
    public final SearchType getSearchType() {
        return this.c;
    }

    public final boolean hasNextPage() {
        Integer num;
        return this.c == SearchType.NORMAL && (num = this.d) != null && num.intValue() > 0;
    }

    public final boolean isFirstPage() {
        return this.a == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeInt(this.a);
            ParcelsKt.writeNullableValue(parcel, this.b);
            ParcelsKt.writeEnum(parcel, this.c);
            ParcelsKt.writeNullableValue(parcel, this.d);
        }
    }

    public SerpPageParams(int i, Long l, SearchType searchType, Integer num, String str, int i2) {
        int i3 = i2 & 16;
        this.a = i;
        this.b = l;
        this.c = searchType;
        this.d = num;
        this.e = null;
    }
}
