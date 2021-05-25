package com.avito.android.adapter;

import a2.b.a.a.a;
import com.avito.android.advert.actions.HiddenAdvertsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/adapter/MoreActionsItemProcessorImpl;", "Lcom/avito/android/adapter/MoreActionsItemProcessor;", "Lcom/avito/conveyor_item/Item;", "T", "", "items", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "fillItems", "(Ljava/util/List;Lcom/avito/android/remote/model/AdvertItemActions;)Ljava/util/List;", "", "resolveStatus", "(Ljava/util/List;)V", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "hiddenAdvertsInteractor", "<init>", "(Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class MoreActionsItemProcessorImpl implements MoreActionsItemProcessor {
    public final HiddenAdvertsInteractor a;

    @Inject
    public MoreActionsItemProcessorImpl(@NotNull HiddenAdvertsInteractor hiddenAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(hiddenAdvertsInteractor, "hiddenAdvertsInteractor");
        this.a = hiddenAdvertsInteractor;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0040 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends T extends com.avito.conveyor_item.Item> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.avito.conveyor_item.Item] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.avito.conveyor_item.Item, com.avito.android.adapter.HiddenAdvertItem] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.adapter.MoreActionsItemProcessor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.avito.conveyor_item.Item> java.util.List<T> fillItems(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r5, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.AdvertItemActions r6) {
        /*
            r4 = this;
            java.lang.String r0 = "items"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            if (r6 != 0) goto L_0x0008
            goto L_0x0045
        L_0x0008:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r5, r1)
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L_0x0017:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r5.next()
            com.avito.conveyor_item.Item r1 = (com.avito.conveyor_item.Item) r1
            boolean r2 = r1 instanceof com.avito.android.adapter.MoreActionsItem
            if (r2 == 0) goto L_0x0040
            com.avito.android.adapter.MoreActionsItem r1 = (com.avito.android.adapter.MoreActionsItem) r1
            com.avito.android.remote.model.AdvertItemActions r2 = r1.getMoreActions()
            if (r2 != 0) goto L_0x0033
            com.avito.android.adapter.MoreActionsItem r1 = r1.copyWithMoreActions(r6)
        L_0x0033:
            com.avito.android.advert.actions.HiddenAdvertsInteractor r2 = r4.a
            java.lang.String r3 = r1.getStringId()
            boolean r2 = r2.isHidden(r3)
            r1.setHidden(r2)
        L_0x0040:
            r0.add(r1)
            goto L_0x0017
        L_0x0044:
            r5 = r0
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.adapter.MoreActionsItemProcessorImpl.fillItems(java.util.List, com.avito.android.remote.model.AdvertItemActions):java.util.List");
    }

    @Override // com.avito.android.adapter.MoreActionsItemProcessor
    public <T extends Item> void resolveStatus(@NotNull List<? extends T> list) {
        ArrayList i0 = a.i0(list, "items");
        for (T t : list) {
            T t2 = t;
            if ((t2 instanceof HiddenAdvertItem) && t2.getCanBeHidden()) {
                i0.add(t);
            }
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(i0, 10));
        Iterator it = i0.iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            Objects.requireNonNull(item, "null cannot be cast to non-null type com.avito.android.adapter.HiddenAdvertItem");
            arrayList.add((HiddenAdvertItem) item);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HiddenAdvertItem hiddenAdvertItem = (HiddenAdvertItem) it2.next();
            hiddenAdvertItem.setHidden(this.a.isHidden(hiddenAdvertItem.getStringId()));
        }
    }
}
