package com.avito.android.html_editor;

import android.text.Spanned;
import com.avito.android.html_editor.OperationTreeDisassembler;
import com.avito.android.html_formatter.DeleteOperation;
import com.avito.android.html_formatter.HtmlNode;
import com.avito.android.html_formatter.InsertOperation;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.span.NodeSpan;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/html_editor/OperationTreeDisassemblerImpl;", "Lcom/avito/android/html_editor/OperationTreeDisassembler;", "Landroid/text/Spanned;", "treeSpannable", "Lcom/avito/android/html_formatter/EditorOperation;", "operation", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "", "Lcom/avito/android/html_editor/OperationTreeDisassembler$NodeOperation;", "applyOperationToTree", "(Landroid/text/Spanned;Lcom/avito/android/html_formatter/EditorOperation;Lcom/avito/android/html_formatter/MutableHtmlNode;)Ljava/util/List;", "Lcom/avito/android/html_formatter/InsertOperation;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/html_formatter/InsertOperation;Landroid/text/Spanned;Lcom/avito/android/html_formatter/MutableHtmlNode;)Ljava/util/List;", "Lcom/avito/android/html_formatter/DeleteOperation;", AuthSource.SEND_ABUSE, "(Landroid/text/Spanned;Lcom/avito/android/html_formatter/DeleteOperation;)Ljava/util/List;", "<init>", "()V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class OperationTreeDisassemblerImpl implements OperationTreeDisassembler {

    public static final class a extends Lambda implements Function4<Integer, NodeSpan, Integer, Integer, OperationTreeDisassembler.NodeOperation> {
        public final /* synthetic */ OperationTreeDisassemblerImpl a;
        public final /* synthetic */ DeleteOperation b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(OperationTreeDisassemblerImpl operationTreeDisassemblerImpl, DeleteOperation deleteOperation) {
            super(4);
            this.a = operationTreeDisassemblerImpl;
            this.b = deleteOperation;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function4
        public OperationTreeDisassembler.NodeOperation invoke(Integer num, NodeSpan nodeSpan, Integer num2, Integer num3) {
            num.intValue();
            NodeSpan nodeSpan2 = nodeSpan;
            int intValue = num2.intValue();
            int intValue2 = num3.intValue();
            Intrinsics.checkNotNullParameter(nodeSpan2, "span");
            return new OperationTreeDisassembler.NodeOperation(nodeSpan2.getNode(), new DeleteOperation(OperationTreeDisassemblerImpl.access$getNodeOperationFromIndex(this.a, this.b.getFrom(), intValue), OperationTreeDisassemblerImpl.access$getOperationGlobalToIndex(this.a, this.b.getTo(), intValue2, intValue)));
        }
    }

    public static final int access$getNodeOperationFromIndex(OperationTreeDisassemblerImpl operationTreeDisassemblerImpl, int i, int i2) {
        Objects.requireNonNull(operationTreeDisassemblerImpl);
        return e.coerceAtLeast(i - i2, 0);
    }

    public static final int access$getOperationGlobalToIndex(OperationTreeDisassemblerImpl operationTreeDisassemblerImpl, int i, int i2, int i3) {
        Objects.requireNonNull(operationTreeDisassemblerImpl);
        return i2 > i ? i - i3 : i2 - i3;
    }

    public final List<OperationTreeDisassembler.NodeOperation> a(Spanned spanned, DeleteOperation deleteOperation) {
        return CollectionsKt___CollectionsKt.sorted(SpannedUtilsKt.iterateThroughSpansInOrder(spanned, deleteOperation.getFrom(), deleteOperation.getTo(), NodeSpan.class, new a(this, deleteOperation)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.avito.android.html_editor.OperationTreeDisassembler$NodeOperation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.html_editor.OperationTreeDisassembler
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.html_editor.OperationTreeDisassembler.NodeOperation> applyOperationToTree(@org.jetbrains.annotations.NotNull android.text.Spanned r17, @org.jetbrains.annotations.NotNull com.avito.android.html_formatter.EditorOperation r18, @org.jetbrains.annotations.NotNull com.avito.android.html_formatter.MutableHtmlNode r19) {
        /*
        // Method dump skipped, instructions count: 436
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_editor.OperationTreeDisassemblerImpl.applyOperationToTree(android.text.Spanned, com.avito.android.html_formatter.EditorOperation, com.avito.android.html_formatter.MutableHtmlNode):java.util.List");
    }

    public final List<OperationTreeDisassembler.NodeOperation> b(InsertOperation insertOperation, Spanned spanned, MutableHtmlNode mutableHtmlNode) {
        MutableHtmlNode mutableHtmlNode2;
        int i;
        HtmlNode firstBlankRow;
        MutableHtmlNode node;
        MutableHtmlNode node2;
        MutableHtmlNode node3;
        Object[] spans = spanned.getSpans(insertOperation.getFrom(), e.coerceAtMost(insertOperation.getFrom() + 1, spanned.length()), NodeSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "treeSpannable.getSpans(\n…pan::class.java\n        )");
        NodeSpan nodeSpan = (NodeSpan) ArraysKt___ArraysKt.firstOrNull(spans);
        Object[] spans2 = spanned.getSpans(e.coerceAtLeast(insertOperation.getFrom() - 1, 0), e.coerceAtLeast(insertOperation.getFrom() - 1, 0) + 1, NodeSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "treeSpannable.getSpans(\n…pan::class.java\n        )");
        NodeSpan nodeSpan2 = (NodeSpan) ArraysKt___ArraysKt.firstOrNull(spans2);
        if ((nodeSpan == null || (node3 = nodeSpan.getNode()) == null || !node3.isTextNode()) && !((nodeSpan2 == null || (node2 = nodeSpan2.getNode()) == null || !node2.isTextNode()) && (nodeSpan == null || (node = nodeSpan.getNode()) == null || !node.isBlock()))) {
            nodeSpan = nodeSpan2;
        }
        if (nodeSpan == null || (mutableHtmlNode2 = nodeSpan.getNode()) == null) {
            MutableHtmlNode createEmptyParagraph = mutableHtmlNode.createEmptyParagraph();
            mutableHtmlNode2 = (createEmptyParagraph == null || (firstBlankRow = createEmptyParagraph.getFirstBlankRow()) == null) ? null : firstBlankRow.asMutable();
        }
        if (mutableHtmlNode2 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (mutableHtmlNode2.isBlock()) {
            i = 0;
        } else {
            i = e.coerceAtLeast(insertOperation.getFrom() - (nodeSpan != null ? spanned.getSpanStart(nodeSpan) : 0), 0);
        }
        List<String> split = new Regex("(?<=[\n])|(?=[\n])").split(insertOperation.getContent(), 0);
        ArrayList arrayList = new ArrayList();
        for (T t : split) {
            if (!(t.length() == 0)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            OperationTreeDisassembler.NodeOperation nodeOperation = new OperationTreeDisassembler.NodeOperation(mutableHtmlNode2, new InsertOperation(i, str));
            if (str.hashCode() == 10 && str.equals("\n")) {
                i = 0;
            } else {
                i = str.length() + i;
            }
            arrayList2.add(nodeOperation);
            i2 = i3;
        }
        return arrayList2;
    }
}
