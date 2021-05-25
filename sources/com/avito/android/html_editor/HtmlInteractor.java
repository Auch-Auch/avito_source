package com.avito.android.html_editor;

import a2.b.a.a.a;
import android.text.Spanned;
import com.avito.android.html_formatter.EditorOperation;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/html_editor/HtmlInteractor;", "", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "Landroid/text/Spanned;", "textBeforeChanges", "Lcom/avito/android/html_formatter/EditorOperation;", "operation", "Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "applyOperation", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Landroid/text/Spanned;Lcom/avito/android/html_formatter/EditorOperation;)Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "", "operations", "applyOperationsList", "(Lcom/avito/android/html_formatter/MutableHtmlNode;Landroid/text/Spanned;Ljava/util/List;)Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "text", "", "selectionStart", "selectionEnd", "getFormat", "(Landroid/text/Spanned;II)I", "", "removePendingOperations", "()V", "Lio/reactivex/Observable;", "Lcom/avito/android/html_editor/HistorySnapshot;", "getHistorySnapshots", "()Lio/reactivex/Observable;", "historySnapshots", "OperationResult", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "component2", "()Lcom/avito/android/html_formatter/HtmlCharSequence;", "", "component3", "()I", "html", "renderedText", "cursorShift", "copy", "(Ljava/lang/String;Lcom/avito/android/html_formatter/HtmlCharSequence;I)Lcom/avito/android/html_editor/HtmlInteractor$OperationResult;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getCursorShift", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/HtmlCharSequence;", "getRenderedText", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getHtml", "<init>", "(Ljava/lang/String;Lcom/avito/android/html_formatter/HtmlCharSequence;I)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
    public static final class OperationResult {
        @NotNull
        public final String a;
        @NotNull
        public final HtmlCharSequence b;
        public final int c;

        public OperationResult(@NotNull String str, @NotNull HtmlCharSequence htmlCharSequence, int i) {
            Intrinsics.checkNotNullParameter(str, "html");
            Intrinsics.checkNotNullParameter(htmlCharSequence, "renderedText");
            this.a = str;
            this.b = htmlCharSequence;
            this.c = i;
        }

        public static /* synthetic */ OperationResult copy$default(OperationResult operationResult, String str, HtmlCharSequence htmlCharSequence, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = operationResult.a;
            }
            if ((i2 & 2) != 0) {
                htmlCharSequence = operationResult.b;
            }
            if ((i2 & 4) != 0) {
                i = operationResult.c;
            }
            return operationResult.copy(str, htmlCharSequence, i);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final HtmlCharSequence component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final OperationResult copy(@NotNull String str, @NotNull HtmlCharSequence htmlCharSequence, int i) {
            Intrinsics.checkNotNullParameter(str, "html");
            Intrinsics.checkNotNullParameter(htmlCharSequence, "renderedText");
            return new OperationResult(str, htmlCharSequence, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationResult)) {
                return false;
            }
            OperationResult operationResult = (OperationResult) obj;
            return Intrinsics.areEqual(this.a, operationResult.a) && Intrinsics.areEqual(this.b, operationResult.b) && this.c == operationResult.c;
        }

        public final int getCursorShift() {
            return this.c;
        }

        @NotNull
        public final String getHtml() {
            return this.a;
        }

        @NotNull
        public final HtmlCharSequence getRenderedText() {
            return this.b;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            HtmlCharSequence htmlCharSequence = this.b;
            if (htmlCharSequence != null) {
                i = htmlCharSequence.hashCode();
            }
            return ((hashCode + i) * 31) + this.c;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OperationResult(html=");
            L.append(this.a);
            L.append(", renderedText=");
            L.append((Object) this.b);
            L.append(", cursorShift=");
            return a.j(L, this.c, ")");
        }
    }

    @NotNull
    OperationResult applyOperation(@NotNull MutableHtmlNode mutableHtmlNode, @NotNull Spanned spanned, @NotNull EditorOperation editorOperation);

    @NotNull
    OperationResult applyOperationsList(@NotNull MutableHtmlNode mutableHtmlNode, @NotNull Spanned spanned, @NotNull List<? extends EditorOperation> list);

    int getFormat(@NotNull Spanned spanned, int i, int i2);

    @NotNull
    Observable<HistorySnapshot> getHistorySnapshots();

    void removePendingOperations();
}
