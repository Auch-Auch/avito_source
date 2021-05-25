package ru.sravni.android.bankproduct.utils.filter.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "", "", "c", "I", "getIcon", "()I", "icon", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;", "getType", "()Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;", "type", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "d", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "getFilterInfo", "()Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "filterInfo", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;ILru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;)V", "FilterInfo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public class FilterItem {
    @NotNull
    public final String a;
    @NotNull
    public final FilterTypeEnum b;
    public final int c;
    @NotNull
    public final FilterInfo d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u0001'B-\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\b¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo$DetailFilter;", "component4", "()Ljava/util/List;", "name", "titleDetail", "editable", ProductAction.ACTION_DETAIL, "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitleDetail", "d", "Ljava/util/List;", "getDetail", AuthSource.SEND_ABUSE, "getName", "c", "Z", "getEditable", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "DetailFilter", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class FilterInfo {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        public final boolean c;
        @NotNull
        public final List<DetailFilter> d;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo$DetailFilter;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "code", "title", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem$FilterInfo$DetailFilter;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getValue", AuthSource.SEND_ABUSE, "getCode", AuthSource.BOOKING_ORDER, "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class DetailFilter {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            public DetailFilter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                a.a1(str, "code", str2, "title", str3, "value");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public static /* synthetic */ DetailFilter copy$default(DetailFilter detailFilter, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = detailFilter.a;
                }
                if ((i & 2) != 0) {
                    str2 = detailFilter.b;
                }
                if ((i & 4) != 0) {
                    str3 = detailFilter.c;
                }
                return detailFilter.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final DetailFilter copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str, "code");
                Intrinsics.checkParameterIsNotNull(str2, "title");
                Intrinsics.checkParameterIsNotNull(str3, "value");
                return new DetailFilter(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DetailFilter)) {
                    return false;
                }
                DetailFilter detailFilter = (DetailFilter) obj;
                return Intrinsics.areEqual(this.a, detailFilter.a) && Intrinsics.areEqual(this.b, detailFilter.b) && Intrinsics.areEqual(this.c, detailFilter.c);
            }

            @NotNull
            public final String getCode() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }

            @NotNull
            public final String getValue() {
                return this.c;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.c;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("DetailFilter(code=");
                L.append(this.a);
                L.append(", title=");
                L.append(this.b);
                L.append(", value=");
                return a.t(L, this.c, ")");
            }
        }

        public FilterInfo(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<DetailFilter> list) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "titleDetail");
            Intrinsics.checkParameterIsNotNull(list, ProductAction.ACTION_DETAIL);
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.utils.filter.entity.FilterItem$FilterInfo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FilterInfo copy$default(FilterInfo filterInfo, String str, String str2, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = filterInfo.a;
            }
            if ((i & 2) != 0) {
                str2 = filterInfo.b;
            }
            if ((i & 4) != 0) {
                z = filterInfo.c;
            }
            if ((i & 8) != 0) {
                list = filterInfo.d;
            }
            return filterInfo.copy(str, str2, z, list);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final List<DetailFilter> component4() {
            return this.d;
        }

        @NotNull
        public final FilterInfo copy(@NotNull String str, @NotNull String str2, boolean z, @NotNull List<DetailFilter> list) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(str2, "titleDetail");
            Intrinsics.checkParameterIsNotNull(list, ProductAction.ACTION_DETAIL);
            return new FilterInfo(str, str2, z, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FilterInfo)) {
                return false;
            }
            FilterInfo filterInfo = (FilterInfo) obj;
            return Intrinsics.areEqual(this.a, filterInfo.a) && Intrinsics.areEqual(this.b, filterInfo.b) && this.c == filterInfo.c && Intrinsics.areEqual(this.d, filterInfo.d);
        }

        @NotNull
        public final List<DetailFilter> getDetail() {
            return this.d;
        }

        public final boolean getEditable() {
            return this.c;
        }

        @NotNull
        public final String getName() {
            return this.a;
        }

        @NotNull
        public final String getTitleDetail() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.c;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode2 + i2) * 31;
            List<DetailFilter> list = this.d;
            if (list != null) {
                i = list.hashCode();
            }
            return i5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("FilterInfo(name=");
            L.append(this.a);
            L.append(", titleDetail=");
            L.append(this.b);
            L.append(", editable=");
            L.append(this.c);
            L.append(", detail=");
            return a.w(L, this.d, ")");
        }
    }

    public FilterItem(@NotNull String str, @NotNull FilterTypeEnum filterTypeEnum, int i, @NotNull FilterInfo filterInfo) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(filterTypeEnum, "type");
        Intrinsics.checkParameterIsNotNull(filterInfo, "filterInfo");
        this.a = str;
        this.b = filterTypeEnum;
        this.c = i;
        this.d = filterInfo;
    }

    @NotNull
    public final FilterInfo getFilterInfo() {
        return this.d;
    }

    public final int getIcon() {
        return this.c;
    }

    @NotNull
    public String getTitle() {
        return this.a;
    }

    @NotNull
    public final FilterTypeEnum getType() {
        return this.b;
    }
}
