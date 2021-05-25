package a2.a.a.b1;

import com.avito.android.html_editor.OperationTreeDisassembler;
import com.avito.android.html_editor.OperationTreeDisassemblerImpl;
import com.avito.android.html_formatter.FormatOperation;
import com.avito.android.html_formatter.span.NodeSpan;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function4<Integer, NodeSpan, Integer, Integer, OperationTreeDisassembler.NodeOperation> {
    public final /* synthetic */ OperationTreeDisassemblerImpl a;
    public final /* synthetic */ FormatOperation b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(OperationTreeDisassemblerImpl operationTreeDisassemblerImpl, FormatOperation formatOperation) {
        super(4);
        this.a = operationTreeDisassemblerImpl;
        this.b = formatOperation;
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
        return new OperationTreeDisassembler.NodeOperation(nodeSpan2.getNode(), new FormatOperation(OperationTreeDisassemblerImpl.access$getNodeOperationFromIndex(this.a, this.b.getFrom(), intValue), OperationTreeDisassemblerImpl.access$getOperationGlobalToIndex(this.a, this.b.getTo(), intValue2, intValue), this.b.getFormatChange()));
    }
}
