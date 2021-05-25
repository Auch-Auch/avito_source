package com.avito.android.serp.adapter;

import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/adapter/BaseSerpItemSizeAdjuster;", "Lcom/avito/android/serp/adapter/SerpItemSizeAdjuster;", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", "T", "", "list", "", "columns", BuildConfig.FLAVOR, "(Ljava/util/List;I)Ljava/util/List;", "item", "getSpanCount", "(Lcom/avito/android/serp/adapter/ViewTypeSerpItem;)I", "Lcom/avito/android/serp/adapter/SerpItem;", "", "fullSize", "", AuthSource.SEND_ABUSE, "(Ljava/util/List;Z)V", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseSerpItemSizeAdjuster implements SerpItemSizeAdjuster {
    public final void a(List<? extends SerpItem> list, boolean z) {
        for (T t : list) {
            if (t instanceof AdjustableSerpItem) {
                t.setFullSize(z);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends T extends com.avito.android.serp.adapter.ViewTypeSerpItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.serp.adapter.SerpItemSizeAdjuster
    @NotNull
    public <T extends ViewTypeSerpItem> List<T> adjust(@NotNull List<? extends T> list, int i) {
        int i2;
        int i3;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "list");
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (Object obj : list) {
            int i7 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            int spanCount = getSpanCount((ViewTypeSerpItem) obj) + i5;
            if (spanCount >= i || i4 == CollectionsKt__CollectionsKt.getLastIndex(list)) {
                List<? extends SerpItem> subList = list.subList(i6, i7);
                boolean z2 = subList instanceof Collection;
                if (!z2 || !subList.isEmpty()) {
                    Iterator<T> it = subList.iterator();
                    i2 = 0;
                    while (it.hasNext()) {
                        if ((it.next() instanceof AdjustableSerpItem) && (i2 = i2 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                } else {
                    i2 = 0;
                }
                if (i2 == 1 && subList.size() == 1) {
                    a(subList, true);
                } else {
                    if (!z2 || !subList.isEmpty()) {
                        i3 = 0;
                        for (T t : subList) {
                            if (t instanceof AdvertItem) {
                                String address = t.getAddress();
                                if (!(address == null || address.length() == 0)) {
                                    z = true;
                                    if (z && (i3 = i3 + 1) < 0) {
                                        CollectionsKt__CollectionsKt.throwCountOverflow();
                                    }
                                }
                            }
                            z = false;
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 0) {
                        a(subList, true);
                    }
                }
                i6 = i7;
                i5 = 0;
            } else {
                i5 = spanCount;
            }
            i4 = i7;
        }
        return list;
    }

    public abstract int getSpanCount(@NotNull ViewTypeSerpItem viewTypeSerpItem);
}
