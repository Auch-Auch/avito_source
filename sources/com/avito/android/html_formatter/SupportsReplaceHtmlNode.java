package com.avito.android.html_formatter;

import com.avito.android.html_formatter.MutableHtmlNode;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J/\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/html_formatter/SupportsReplaceHtmlNode;", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode;", "Lcom/avito/android/html_formatter/SupportsInsertHtmlNode;", "", "from", "to", "", "Lcom/avito/android/html_formatter/InsertOperation;", "insertOperations", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "replace", "(IILjava/util/List;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface SupportsReplaceHtmlNode extends SupportsDeleteHtmlNode, SupportsInsertHtmlNode {
    @Nullable
    MutableHtmlNode.OperationResult replace(int i, int i2, @NotNull List<InsertOperation> list);
}
