package com.avito.android.serp.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/serp/adapter/SpanLookup;", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", VKApiConst.POSITION, "getSpanSize", "(I)I", "Lcom/avito/android/serp/adapter/SpanProvider;", "e", "Lcom/avito/android/serp/adapter/SpanProvider;", "spanProvider", "<init>", "(Lcom/avito/android/serp/adapter/SpanProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SpanLookup extends GridLayoutManager.SpanSizeLookup {
    public final SpanProvider e;

    @Inject
    public SpanLookup(@NotNull SpanProvider spanProvider) {
        Intrinsics.checkNotNullParameter(spanProvider, "spanProvider");
        this.e = spanProvider;
        setSpanIndexCacheEnabled(true);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        return this.e.getSpan(i);
    }
}
