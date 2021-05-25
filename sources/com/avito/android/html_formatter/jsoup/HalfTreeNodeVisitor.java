package com.avito.android.html_formatter.jsoup;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeVisitor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001Bµ\u0001\u00128\u0010\u0018\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00160\n\u00128\u0010\u0015\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\n\u00128\u0010\u0010\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bRH\u0010\u0010\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012RH\u0010\u0015\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fRH\u0010\u0018\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00160\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/HalfTreeNodeVisitor;", "Lorg/jsoup/select/NodeVisitor;", "Lorg/jsoup/nodes/Node;", "node", "", "depth", "", "head", "(Lorg/jsoup/nodes/Node;I)V", "tail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "side", "d", "Lkotlin/jvm/functions/Function2;", "actionTail", AuthSource.SEND_ABUSE, "I", "nodeSide", "c", "actionHead", "", AuthSource.BOOKING_ORDER, "splitCondition", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class HalfTreeNodeVisitor implements NodeVisitor {
    public int a = -1;
    public final Function2<Node, Integer, Boolean> b;
    public final Function2<Node, Integer, Unit> c;
    public final Function2<Node, Integer, Unit> d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super org.jsoup.nodes.Node, ? super java.lang.Integer, java.lang.Boolean> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super org.jsoup.nodes.Node, ? super java.lang.Integer, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super org.jsoup.nodes.Node, ? super java.lang.Integer, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public HalfTreeNodeVisitor(@NotNull Function2<? super Node, ? super Integer, Boolean> function2, @NotNull Function2<? super Node, ? super Integer, Unit> function22, @NotNull Function2<? super Node, ? super Integer, Unit> function23) {
        Intrinsics.checkNotNullParameter(function2, "splitCondition");
        Intrinsics.checkNotNullParameter(function22, "actionHead");
        Intrinsics.checkNotNullParameter(function23, "actionTail");
        this.b = function2;
        this.c = function22;
        this.d = function23;
    }

    @Override // org.jsoup.select.NodeVisitor
    public void head(@Nullable Node node, int i) {
        int i2 = this.a;
        if (i2 == -1 && this.b.invoke(node, Integer.valueOf(i2)).booleanValue()) {
            this.a = 0;
        }
        this.c.invoke(node, Integer.valueOf(this.a));
    }

    @Override // org.jsoup.select.NodeVisitor
    public void tail(@Nullable Node node, int i) {
        this.d.invoke(node, Integer.valueOf(this.a));
        int i2 = this.a;
        if (i2 == 0 && this.b.invoke(node, Integer.valueOf(i2)).booleanValue()) {
            this.a = 1;
        }
    }
}
