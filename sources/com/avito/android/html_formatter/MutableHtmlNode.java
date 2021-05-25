package com.avito.android.html_formatter;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tJ\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/html_formatter/MutableHtmlNode;", "Lcom/avito/android/html_formatter/HtmlNode;", "Lcom/avito/android/html_formatter/SupportsReplaceHtmlNode;", "Lcom/avito/android/html_formatter/SupportsFormatHtmlNode;", "", "simplifyHtml", "()I", "createEmptyParagraph", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "OperationResult", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface MutableHtmlNode extends HtmlNode, SupportsReplaceHtmlNode, SupportsFormatHtmlNode {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0003\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "", "result", "merge", "(Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "component1", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "", "component2", "()I", "replacedNode", "cursorPositionShift", "copy", "(Lcom/avito/android/html_formatter/MutableHtmlNode;I)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getReplacedNode", AuthSource.BOOKING_ORDER, "I", "getCursorPositionShift", "<init>", "(Lcom/avito/android/html_formatter/MutableHtmlNode;I)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class OperationResult {
        @Nullable
        public final MutableHtmlNode a;
        public final int b;

        public OperationResult(@Nullable MutableHtmlNode mutableHtmlNode, int i) {
            this.a = mutableHtmlNode;
            this.b = i;
        }

        public static /* synthetic */ OperationResult copy$default(OperationResult operationResult, MutableHtmlNode mutableHtmlNode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mutableHtmlNode = operationResult.a;
            }
            if ((i2 & 2) != 0) {
                i = operationResult.b;
            }
            return operationResult.copy(mutableHtmlNode, i);
        }

        @Nullable
        public final MutableHtmlNode component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final OperationResult copy(@Nullable MutableHtmlNode mutableHtmlNode, int i) {
            return new OperationResult(mutableHtmlNode, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationResult)) {
                return false;
            }
            OperationResult operationResult = (OperationResult) obj;
            return Intrinsics.areEqual(this.a, operationResult.a) && this.b == operationResult.b;
        }

        public final int getCursorPositionShift() {
            return this.b;
        }

        @Nullable
        public final MutableHtmlNode getReplacedNode() {
            return this.a;
        }

        public int hashCode() {
            MutableHtmlNode mutableHtmlNode = this.a;
            return ((mutableHtmlNode != null ? mutableHtmlNode.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public final OperationResult merge(@Nullable OperationResult operationResult) {
            if (operationResult == null) {
                return this;
            }
            return new OperationResult(operationResult.a, this.b + operationResult.b);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OperationResult(replacedNode=");
            L.append(this.a);
            L.append(", cursorPositionShift=");
            return a.j(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OperationResult(MutableHtmlNode mutableHtmlNode, int i, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : mutableHtmlNode, i);
        }
    }

    @Nullable
    MutableHtmlNode createEmptyParagraph();

    int simplifyHtml();
}
