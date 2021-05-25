package com.avito.android.html_formatter.jsoup;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR1\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00060\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/TextVisitor;", "Lorg/jsoup/select/NodeVisitor;", "Lorg/jsoup/nodes/Node;", "node", "", "depth", "", "tail", "(Lorg/jsoup/nodes/Node;I)V", "head", "Lkotlin/Function1;", "Lorg/jsoup/nodes/TextNode;", "Lkotlin/ParameterName;", "name", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "action", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class TextVisitor implements NodeVisitor {
    public final Function1<TextNode, Unit> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super org.jsoup.nodes.TextNode, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public TextVisitor(@NotNull Function1<? super TextNode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.a = function1;
    }

    @Override // org.jsoup.select.NodeVisitor
    public void head(@Nullable Node node, int i) {
    }

    @Override // org.jsoup.select.NodeVisitor
    public void tail(@Nullable Node node, int i) {
        if (node instanceof TextNode) {
            this.a.invoke(node);
        }
    }
}
