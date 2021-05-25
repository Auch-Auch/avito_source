package com.avito.android.component.search.list;

import a2.a.a.a.f.a.b;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/component/search/list/BubblesItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/component/search/list/BubblesItemView;", "", "Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem;", "words", "Lcom/avito/android/component/search/SuggestItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setBubbles", "(Ljava/util/List;Lcom/avito/android/component/search/SuggestItemListener;)V", "", "paddingTop", "paddingBottom", "setPadding", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "bubblesContainer", "La2/a/a/a/f/a/b;", "t", "La2/a/a/a/f/a/b;", "reusableChildHelper", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BubblesItemViewHolder extends BaseViewHolder implements BubblesItemView {
    public final ViewGroup s;
    public final b t;
    public final View u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BubblesItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.words);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.words)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.s = viewGroup;
        this.t = new b(viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0035 A[EDGE_INSN: B:18:0x0035->B:14:0x0035 ?: BREAK  , SYNTHETIC] */
    @Override // com.avito.android.component.search.list.BubblesItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setBubbles(@org.jetbrains.annotations.NotNull java.util.List<com.avito.android.remote.model.search.suggest.SuggestBubbleItem> r7, @org.jetbrains.annotations.NotNull com.avito.android.component.search.SuggestItemListener r8) {
        /*
            r6 = this;
            java.lang.String r0 = "words"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.Iterator r1 = r7.iterator()
        L_0x000e:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()
            r5 = r2
            com.avito.android.remote.model.search.suggest.SuggestBubbleItem r5 = (com.avito.android.remote.model.search.suggest.SuggestBubbleItem) r5
            java.lang.String r5 = r5.getDescription()
            if (r5 == 0) goto L_0x0030
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r5 == 0) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            if (r5 == 0) goto L_0x000e
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            if (r2 == 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r3 = 0
        L_0x0039:
            a2.a.a.a.f.a.b r1 = r6.t
            java.util.Objects.requireNonNull(r1)
            java.lang.String r2 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r1.c = r3
            r1.b = r8
            android.view.ViewGroup r8 = r1.d
            r1.reuseChildrenView(r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.search.list.BubblesItemViewHolder.setBubbles(java.util.List, com.avito.android.component.search.SuggestItemListener):void");
    }

    @Override // com.avito.android.component.search.list.BubblesItemView
    public void setPadding(@Nullable Integer num, @Nullable Integer num2) {
        int i;
        int i2;
        if (num != null) {
            i = Views.dpToPx(this.u, num.intValue());
        } else {
            i = 0;
        }
        if (num2 != null) {
            i2 = Views.dpToPx(this.u, num2.intValue());
        } else {
            i2 = 0;
        }
        Views.changePadding$default(this.u, 0, i, 0, i2, 5, null);
    }
}
