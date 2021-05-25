package com.avito.android.html_editor;

import a2.b.a.a.a;
import android.text.Spanned;
import com.avito.android.html_formatter.EditorOperation;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/html_editor/OperationTreeDisassembler;", "", "Landroid/text/Spanned;", "treeSpannable", "Lcom/avito/android/html_formatter/EditorOperation;", "operation", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "", "Lcom/avito/android/html_editor/OperationTreeDisassembler$NodeOperation;", "applyOperationToTree", "(Landroid/text/Spanned;Lcom/avito/android/html_formatter/EditorOperation;Lcom/avito/android/html_formatter/MutableHtmlNode;)Ljava/util/List;", "NodeOperation", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public interface OperationTreeDisassembler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0002\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/avito/android/html_editor/OperationTreeDisassembler$NodeOperation;", "", "other", "", "compareTo", "(Lcom/avito/android/html_editor/OperationTreeDisassembler$NodeOperation;)I", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "component1", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "Lcom/avito/android/html_formatter/EditorOperation;", "component2", "()Lcom/avito/android/html_formatter/EditorOperation;", "node", "operation", "copy", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Lcom/avito/android/html_formatter/EditorOperation;)Lcom/avito/android/html_editor/OperationTreeDisassembler$NodeOperation;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/EditorOperation;", "getOperation", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getNode", "<init>", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Lcom/avito/android/html_formatter/EditorOperation;)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class NodeOperation implements Comparable<NodeOperation> {
        @NotNull
        public final MutableHtmlNode a;
        @NotNull
        public final EditorOperation b;

        public NodeOperation(@NotNull MutableHtmlNode mutableHtmlNode, @NotNull EditorOperation editorOperation) {
            Intrinsics.checkNotNullParameter(mutableHtmlNode, "node");
            Intrinsics.checkNotNullParameter(editorOperation, "operation");
            this.a = mutableHtmlNode;
            this.b = editorOperation;
        }

        public static /* synthetic */ NodeOperation copy$default(NodeOperation nodeOperation, MutableHtmlNode mutableHtmlNode, EditorOperation editorOperation, int i, Object obj) {
            if ((i & 1) != 0) {
                mutableHtmlNode = nodeOperation.a;
            }
            if ((i & 2) != 0) {
                editorOperation = nodeOperation.b;
            }
            return nodeOperation.copy(mutableHtmlNode, editorOperation);
        }

        @NotNull
        public final MutableHtmlNode component1() {
            return this.a;
        }

        @NotNull
        public final EditorOperation component2() {
            return this.b;
        }

        @NotNull
        public final NodeOperation copy(@NotNull MutableHtmlNode mutableHtmlNode, @NotNull EditorOperation editorOperation) {
            Intrinsics.checkNotNullParameter(mutableHtmlNode, "node");
            Intrinsics.checkNotNullParameter(editorOperation, "operation");
            return new NodeOperation(mutableHtmlNode, editorOperation);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NodeOperation)) {
                return false;
            }
            NodeOperation nodeOperation = (NodeOperation) obj;
            return Intrinsics.areEqual(this.a, nodeOperation.a) && Intrinsics.areEqual(this.b, nodeOperation.b);
        }

        @NotNull
        public final MutableHtmlNode getNode() {
            return this.a;
        }

        @NotNull
        public final EditorOperation getOperation() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            MutableHtmlNode mutableHtmlNode = this.a;
            int i = 0;
            int hashCode = (mutableHtmlNode != null ? mutableHtmlNode.hashCode() : 0) * 31;
            EditorOperation editorOperation = this.b;
            if (editorOperation != null) {
                i = editorOperation.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("NodeOperation(node=");
            L.append(this.a);
            L.append(", operation=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }

        public int compareTo(@NotNull NodeOperation nodeOperation) {
            Intrinsics.checkNotNullParameter(nodeOperation, "other");
            if (this.a.isChildOf(nodeOperation.a)) {
                return -1;
            }
            return this.a.isParentOf(nodeOperation.a) ? 1 : 0;
        }
    }

    @NotNull
    List<NodeOperation> applyOperationToTree(@NotNull Spanned spanned, @NotNull EditorOperation editorOperation, @NotNull MutableHtmlNode mutableHtmlNode);
}
