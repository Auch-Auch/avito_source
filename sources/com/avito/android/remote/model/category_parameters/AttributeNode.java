package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "", "", "getId", "()Ljava/lang/String;", "id", "<init>", "()V", "ListNode", "StringNode", "Lcom/avito/android/remote/model/category_parameters/AttributeNode$ListNode;", "Lcom/avito/android/remote/model/category_parameters/AttributeNode$StringNode;", "api_release"}, k = 1, mv = {1, 4, 2})
public abstract class AttributeNode {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AttributeNode$ListNode;", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "id", "value", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/AttributeNode$ListNode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getValue", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ListNode extends AttributeNode {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("value")
        @NotNull
        private final List<AttributeNode> value;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ListNode(String str, List list, int i, j jVar) {
            this(str, (i & 2) != 0 ? new ArrayList() : list);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.AttributeNode$ListNode */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListNode copy$default(ListNode listNode, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = listNode.getId();
            }
            if ((i & 2) != 0) {
                list = listNode.value;
            }
            return listNode.copy(str, list);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final List<AttributeNode> component2() {
            return this.value;
        }

        @NotNull
        public final ListNode copy(@NotNull String str, @NotNull List<AttributeNode> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "value");
            return new ListNode(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListNode)) {
                return false;
            }
            ListNode listNode = (ListNode) obj;
            return Intrinsics.areEqual(getId(), listNode.getId()) && Intrinsics.areEqual(this.value, listNode.value);
        }

        @Override // com.avito.android.remote.model.category_parameters.AttributeNode
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final List<AttributeNode> getValue() {
            return this.value;
        }

        public int hashCode() {
            String id2 = getId();
            int i = 0;
            int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
            List<AttributeNode> list = this.value;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ListNode(id=");
            L.append(getId());
            L.append(", value=");
            return a.w(L, this.value, ")");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ListNode(@NotNull String str, @NotNull List<AttributeNode> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "value");
            this.id = str;
            this.value = list;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AttributeNode$StringNode;", "Lcom/avito/android/remote/model/category_parameters/AttributeNode;", "", "component1", "()Ljava/lang/String;", "component2", "id", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AttributeNode$StringNode;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class StringNode extends AttributeNode {
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("value")
        @NotNull
        private final String value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StringNode(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.id = str;
            this.value = str2;
        }

        public static /* synthetic */ StringNode copy$default(StringNode stringNode, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringNode.getId();
            }
            if ((i & 2) != 0) {
                str2 = stringNode.value;
            }
            return stringNode.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final String component2() {
            return this.value;
        }

        @NotNull
        public final StringNode copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "value");
            return new StringNode(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringNode)) {
                return false;
            }
            StringNode stringNode = (StringNode) obj;
            return Intrinsics.areEqual(getId(), stringNode.getId()) && Intrinsics.areEqual(this.value, stringNode.value);
        }

        @Override // com.avito.android.remote.model.category_parameters.AttributeNode
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            String id2 = getId();
            int i = 0;
            int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
            String str = this.value;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("StringNode(id=");
            L.append(getId());
            L.append(", value=");
            return a.t(L, this.value, ")");
        }
    }

    private AttributeNode() {
    }

    @NotNull
    public abstract String getId();

    public /* synthetic */ AttributeNode(j jVar) {
        this();
    }
}
