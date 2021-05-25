package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ-\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode;", "", "", "from", "to", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "transaction", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", PhoneActionStrings.REMOVE, "(IILcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "OperationTransaction", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface SupportsDeleteHtmlNode {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ MutableHtmlNode.OperationResult delete$default(SupportsDeleteHtmlNode supportsDeleteHtmlNode, int i, int i2, OperationTransaction operationTransaction, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    operationTransaction = null;
                }
                return supportsDeleteHtmlNode.delete(i, i2, operationTransaction);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "", "", "Lorg/jsoup/nodes/Node;", "component1", "()Ljava/util/List;", "", "Lorg/jsoup/nodes/TextNode;", "component2", "()Ljava/util/Map;", "removedNodes", "replacedNodes", "copy", "(Ljava/util/List;Ljava/util/Map;)Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getReplacedNodes", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getRemovedNodes", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class OperationTransaction {
        @NotNull
        public final List<Node> a;
        @NotNull
        public final Map<TextNode, Node> b;

        public OperationTransaction(@NotNull List<Node> list, @NotNull Map<TextNode, Node> map) {
            Intrinsics.checkNotNullParameter(list, "removedNodes");
            Intrinsics.checkNotNullParameter(map, "replacedNodes");
            this.a = list;
            this.b = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.html_formatter.SupportsDeleteHtmlNode$OperationTransaction */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OperationTransaction copy$default(OperationTransaction operationTransaction, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                list = operationTransaction.a;
            }
            if ((i & 2) != 0) {
                map = operationTransaction.b;
            }
            return operationTransaction.copy(list, map);
        }

        @NotNull
        public final List<Node> component1() {
            return this.a;
        }

        @NotNull
        public final Map<TextNode, Node> component2() {
            return this.b;
        }

        @NotNull
        public final OperationTransaction copy(@NotNull List<Node> list, @NotNull Map<TextNode, Node> map) {
            Intrinsics.checkNotNullParameter(list, "removedNodes");
            Intrinsics.checkNotNullParameter(map, "replacedNodes");
            return new OperationTransaction(list, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationTransaction)) {
                return false;
            }
            OperationTransaction operationTransaction = (OperationTransaction) obj;
            return Intrinsics.areEqual(this.a, operationTransaction.a) && Intrinsics.areEqual(this.b, operationTransaction.b);
        }

        @NotNull
        public final List<Node> getRemovedNodes() {
            return this.a;
        }

        @NotNull
        public final Map<TextNode, Node> getReplacedNodes() {
            return this.b;
        }

        public int hashCode() {
            List<Node> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<TextNode, Node> map = this.b;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OperationTransaction(removedNodes=");
            L.append(this.a);
            L.append(", replacedNodes=");
            return a.x(L, this.b, ")");
        }
    }

    @Nullable
    MutableHtmlNode.OperationResult delete(int i, int i2, @Nullable OperationTransaction operationTransaction);
}
