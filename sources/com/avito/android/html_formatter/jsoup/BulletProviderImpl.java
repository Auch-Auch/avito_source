package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/BulletProviderImpl;", "Lcom/avito/android/html_formatter/jsoup/BulletProvider;", "Lorg/jsoup/nodes/Node;", "node", "", "populateBulletListIfNeeded", "(Lorg/jsoup/nodes/Node;)V", "truncateBulletListIfNeeded", "", "", "getCurrentBulletList", "()Ljava/util/List;", "Ljava/util/Stack;", AuthSource.SEND_ABUSE, "Ljava/util/Stack;", "bulletStack", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "options", "<init>", "(Lcom/avito/android/html_formatter/HtmlRenderOptions;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class BulletProviderImpl implements BulletProvider {
    public final Stack<String> a = new Stack<>();
    public final HtmlRenderOptions b;

    public BulletProviderImpl(@NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "options");
        this.b = htmlRenderOptions;
    }

    @Override // com.avito.android.html_formatter.jsoup.BulletProvider
    @NotNull
    public List<String> getCurrentBulletList() {
        Stack<String> stack = this.a;
        ArrayList arrayList = new ArrayList();
        for (T t : stack) {
            if (!Intrinsics.areEqual(t, "")) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.html_formatter.jsoup.BulletProvider
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populateBulletListIfNeeded(@org.jetbrains.annotations.NotNull org.jsoup.nodes.Node r10) {
        /*
            r9 = this;
            java.lang.String r0 = "node"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10 instanceof org.jsoup.nodes.Element
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10
            java.lang.String r0 = r10.normalName()
            if (r0 != 0) goto L_0x0014
            goto L_0x00cf
        L_0x0014:
            int r1 = r0.hashCode()
            r2 = 3453(0xd7d, float:4.839E-42)
            java.lang.String r3 = "ul"
            java.lang.String r4 = "ol"
            r5 = 3735(0xe97, float:5.234E-42)
            r6 = 3549(0xddd, float:4.973E-42)
            if (r1 == r2) goto L_0x0040
            if (r1 == r6) goto L_0x0031
            if (r1 == r5) goto L_0x002a
            goto L_0x00cf
        L_0x002a:
            boolean r10 = r0.equals(r3)
            if (r10 == 0) goto L_0x00cf
            goto L_0x0037
        L_0x0031:
            boolean r10 = r0.equals(r4)
            if (r10 == 0) goto L_0x00cf
        L_0x0037:
            java.util.Stack<java.lang.String> r10 = r9.a
            java.lang.String r0 = ""
            r10.push(r0)
            goto L_0x00cf
        L_0x0040:
            java.lang.String r1 = "li"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00cf
            com.avito.android.html_formatter.HtmlRenderOptions r0 = r9.b
            org.jsoup.select.Elements r1 = r10.parents()
            java.lang.String r2 = "node.parents()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0057:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c7
            java.lang.Object r2 = r1.next()
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            java.lang.String r7 = r2.normalName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r3)
            r8 = 1
            if (r7 != 0) goto L_0x007b
            java.lang.String r7 = r2.normalName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r7 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r7 = 0
            goto L_0x007c
        L_0x007b:
            r7 = 1
        L_0x007c:
            if (r7 == 0) goto L_0x0057
            java.lang.String r1 = r2.normalName()
            if (r1 != 0) goto L_0x0085
            goto L_0x00ba
        L_0x0085:
            int r2 = r1.hashCode()
            if (r2 == r6) goto L_0x0099
            if (r2 == r5) goto L_0x008e
            goto L_0x00ba
        L_0x008e:
            boolean r10 = r1.equals(r3)
            if (r10 == 0) goto L_0x00ba
            java.lang.String r10 = r0.getListBullet()
            goto L_0x00bb
        L_0x0099:
            boolean r0 = r1.equals(r4)
            if (r0 == 0) goto L_0x00ba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r10 = r10.siblingIndex()
            int r10 = r10 + r8
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r0.append(r10)
            java.lang.String r10 = "."
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            goto L_0x00bb
        L_0x00ba:
            r10 = 0
        L_0x00bb:
            if (r10 == 0) goto L_0x00cf
            java.util.Stack<java.lang.String> r0 = r9.a
            int r1 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r0)
            r0.set(r1, r10)
            goto L_0x00cf
        L_0x00c7:
            java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
            java.lang.String r0 = "Collection contains no element matching the predicate."
            r10.<init>(r0)
            throw r10
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_formatter.jsoup.BulletProviderImpl.populateBulletListIfNeeded(org.jsoup.nodes.Node):void");
    }

    @Override // com.avito.android.html_formatter.jsoup.BulletProvider
    public void truncateBulletListIfNeeded(@NotNull Node node) {
        String normalName;
        Intrinsics.checkNotNullParameter(node, "node");
        if ((node instanceof Element) && (normalName = ((Element) node).normalName()) != null) {
            int hashCode = normalName.hashCode();
            if (hashCode != 3549) {
                if (hashCode != 3735 || !normalName.equals("ul")) {
                    return;
                }
            } else if (!normalName.equals("ol")) {
                return;
            }
            this.a.pop();
        }
    }
}
