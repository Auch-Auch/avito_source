package com.avito.android.html_editor;

import android.text.Spannable;
import com.avito.android.html_formatter.MutableHtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/html_editor/RenderedHistorySnapshot;", "Lcom/avito/android/html_editor/HistorySnapshot;", "Landroid/text/Spannable;", "d", "Landroid/text/Spannable;", "getRenderedValue", "()Landroid/text/Spannable;", "renderedValue", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "e", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "getRootNode", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "rootNode", "", "value", "", "selectionStart", "selectionEnd", "<init>", "(Landroid/text/Spannable;Lcom/avito/android/html_formatter/MutableHtmlNode;Ljava/lang/String;II)V", "html-editor_release"}, k = 1, mv = {1, 4, 2})
public final class RenderedHistorySnapshot extends HistorySnapshot {
    @NotNull
    public final Spannable d;
    @NotNull
    public final MutableHtmlNode e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RenderedHistorySnapshot(@NotNull Spannable spannable, @NotNull MutableHtmlNode mutableHtmlNode, @NotNull String str, int i, int i2) {
        super(str, i, i2);
        Intrinsics.checkNotNullParameter(spannable, "renderedValue");
        Intrinsics.checkNotNullParameter(mutableHtmlNode, "rootNode");
        Intrinsics.checkNotNullParameter(str, "value");
        this.d = spannable;
        this.e = mutableHtmlNode;
    }

    @NotNull
    public final Spannable getRenderedValue() {
        return this.d;
    }

    @NotNull
    public final MutableHtmlNode getRootNode() {
        return this.e;
    }
}
