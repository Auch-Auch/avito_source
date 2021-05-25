package com.avito.android.brandspace.presenter;

import com.avito.android.IdProvider;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessorImpl;", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "convert", "(Ljava/util/List;)Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "Lcom/avito/android/IdProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/IdProvider;", "idProvider", "<init>", "(Lcom/avito/android/IdProvider;Lcom/avito/android/serp/adapter/SerpAdvertConverter;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdvertItemProcessorImpl implements BrandspaceAdvertItemProcessor {
    public final IdProvider a;
    public final SerpAdvertConverter b;

    @Inject
    public BrandspaceAdvertItemProcessorImpl(@NotNull IdProvider idProvider, @NotNull SerpAdvertConverter serpAdvertConverter) {
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        this.a = idProvider;
        this.b = serpAdvertConverter;
    }

    @Override // com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor
    @NotNull
    public BrandspaceAdverts convert(@NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof SerpAdvert) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new BrandspaceAdvertItem(this.a.generateId(), BlockType.BS_SERP, this.b.convert((SerpAdvert) it.next(), false, SerpDisplayType.Grid)));
        }
        return new BrandspaceAdverts(arrayList2);
    }
}
