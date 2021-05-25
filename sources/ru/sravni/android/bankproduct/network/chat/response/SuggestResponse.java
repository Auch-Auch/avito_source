package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse;", "", "", "Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse$SuggestItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "SuggestItem", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SuggestResponse {
    @SerializedName("items")
    @Nullable
    private final List<SuggestItem> items;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJH\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000f\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R*\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse$SuggestItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "", "component4", "()Z", "text", "subText", "optionalFields", "isComplete", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lru/sravni/android/bankproduct/network/chat/response/SuggestResponse$SuggestItem;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getText", "Ljava/util/Map;", "getOptionalFields", "getSubText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class SuggestItem {
        @SerializedName("isComplete")
        private final boolean isComplete;
        @SerializedName("optionalFields")
        @Nullable
        private final Map<String, String> optionalFields;
        @SerializedName("subText")
        @Nullable
        private final String subText;
        @SerializedName("text")
        @NotNull
        private final String text;

        public SuggestItem(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            this.text = str;
            this.subText = str2;
            this.optionalFields = map;
            this.isComplete = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.SuggestResponse$SuggestItem */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SuggestItem copy$default(SuggestItem suggestItem, String str, String str2, Map map, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = suggestItem.text;
            }
            if ((i & 2) != 0) {
                str2 = suggestItem.subText;
            }
            if ((i & 4) != 0) {
                map = suggestItem.optionalFields;
            }
            if ((i & 8) != 0) {
                z = suggestItem.isComplete;
            }
            return suggestItem.copy(str, str2, map, z);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @Nullable
        public final String component2() {
            return this.subText;
        }

        @Nullable
        public final Map<String, String> component3() {
            return this.optionalFields;
        }

        public final boolean component4() {
            return this.isComplete;
        }

        @NotNull
        public final SuggestItem copy(@NotNull String str, @Nullable String str2, @Nullable Map<String, String> map, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "text");
            return new SuggestItem(str, str2, map, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SuggestItem)) {
                return false;
            }
            SuggestItem suggestItem = (SuggestItem) obj;
            return Intrinsics.areEqual(this.text, suggestItem.text) && Intrinsics.areEqual(this.subText, suggestItem.subText) && Intrinsics.areEqual(this.optionalFields, suggestItem.optionalFields) && this.isComplete == suggestItem.isComplete;
        }

        @Nullable
        public final Map<String, String> getOptionalFields() {
            return this.optionalFields;
        }

        @Nullable
        public final String getSubText() {
            return this.subText;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.text;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.subText;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Map<String, String> map = this.optionalFields;
            if (map != null) {
                i = map.hashCode();
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z = this.isComplete;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        public final boolean isComplete() {
            return this.isComplete;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SuggestItem(text=");
            L.append(this.text);
            L.append(", subText=");
            L.append(this.subText);
            L.append(", optionalFields=");
            L.append(this.optionalFields);
            L.append(", isComplete=");
            return a.B(L, this.isComplete, ")");
        }
    }

    public SuggestResponse() {
        this(null, 1, null);
    }

    public SuggestResponse(@Nullable List<SuggestItem> list) {
        this.items = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.network.chat.response.SuggestResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestResponse copy$default(SuggestResponse suggestResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = suggestResponse.items;
        }
        return suggestResponse.copy(list);
    }

    @Nullable
    public final List<SuggestItem> component1() {
        return this.items;
    }

    @NotNull
    public final SuggestResponse copy(@Nullable List<SuggestItem> list) {
        return new SuggestResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SuggestResponse) && Intrinsics.areEqual(this.items, ((SuggestResponse) obj).items);
        }
        return true;
    }

    @Nullable
    public final List<SuggestItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<SuggestItem> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a.w(a.L("SuggestResponse(items="), this.items, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuggestResponse(List list, int i, j jVar) {
        this((i & 1) != 0 ? null : list);
    }
}
