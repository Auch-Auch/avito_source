package com.avito.android.brandspace.data;

import com.avito.android.IdProvider;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.marketplace.tab.items.ContentsOfTabsItem;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.brandspace.remote.model.MarketplaceTabContentElement;
import com.avito.android.brandspace.remote.model.MarketplaceTabsContentModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/brandspace/data/BrandspaceTabsRepositoryImpl;", "Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/BuildInfo;", "e", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "c", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "marketplaceItemsProcessor", "Lcom/avito/android/brandspace/remote/BrandspaceApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/remote/BrandspaceApi;", "brandspaceApi", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/IdProvider;", "d", "Lcom/avito/android/IdProvider;", "idProvider", "<init>", "(Lcom/avito/android/brandspace/remote/BrandspaceApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;Lcom/avito/android/IdProvider;Lcom/avito/android/util/BuildInfo;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceTabsRepositoryImpl implements AdvertRepository<AdvertSource.TabsSource> {
    public final BrandspaceApi a;
    public final SchedulersFactory3 b;
    public final MarketplaceItemsProcessor c;
    public final IdProvider d;
    public final BuildInfo e;

    public static final class a<T, R> implements Function<MarketplaceTabsContentModule, ContentsOfTabsItem> {
        public final /* synthetic */ BrandspaceTabsRepositoryImpl a;
        public final /* synthetic */ Map b;

        public a(BrandspaceTabsRepositoryImpl brandspaceTabsRepositoryImpl, Map map) {
            this.a = brandspaceTabsRepositoryImpl;
            this.b = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ContentsOfTabsItem apply(MarketplaceTabsContentModule marketplaceTabsContentModule) {
            return BrandspaceTabsRepositoryImpl.access$getContentsOfTabsItem(this.a, this.b, marketplaceTabsContentModule.getTabs());
        }
    }

    @Inject
    public BrandspaceTabsRepositoryImpl(@NotNull BrandspaceApi brandspaceApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MarketplaceItemsProcessor marketplaceItemsProcessor, @NotNull IdProvider idProvider, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(brandspaceApi, "brandspaceApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(marketplaceItemsProcessor, "marketplaceItemsProcessor");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = brandspaceApi;
        this.b = schedulersFactory3;
        this.c = marketplaceItemsProcessor;
        this.d = idProvider;
        this.e = buildInfo;
    }

    public static final ContentsOfTabsItem access$getContentsOfTabsItem(BrandspaceTabsRepositoryImpl brandspaceTabsRepositoryImpl, Map map, List list) {
        Objects.requireNonNull(brandspaceTabsRepositoryImpl);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MarketplaceTabContentElement marketplaceTabContentElement = (MarketplaceTabContentElement) it.next();
            String str = (String) map.get(marketplaceTabContentElement.getUuid());
            Pair pair = str != null ? TuplesKt.to(str, brandspaceTabsRepositoryImpl.c.convert(marketplaceTabContentElement.getItems())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return new ContentsOfTabsItem(brandspaceTabsRepositoryImpl.d.generateId(), BlockType.MARKETPLACE_TABS, r.toMap(arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [a2.a.a.w.a.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Single<? extends java.util.List<com.avito.android.brandspace.presenter.BrandspaceItem>> getAdverts(@org.jetbrains.annotations.NotNull com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource.TabsSource r12) {
        /*
            r11 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r1 = r12.getContentLinks()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            r2.<init>(r3)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0069
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r6 = 0
            java.lang.Object r7 = r3.getKey()
            java.lang.String r7 = (java.lang.String) r7
            int r7 = r7.hashCode()
            long r7 = (long) r7
            kotlin.random.Random$Default r9 = kotlin.random.Random.Default
            long r9 = r9.nextLong()
            long r9 = r9 + r7
            java.lang.Long r7 = java.lang.Long.valueOf(r9)
            r5[r6] = r7
            java.lang.String r6 = "%x"
            java.lang.String r7 = "java.lang.String.format(this, *args)"
            java.lang.String r4 = a2.b.a.a.a.H(r5, r4, r6, r7)
            java.lang.Object r5 = r3.getKey()
            r0.put(r4, r5)
            com.avito.android.brandspace.remote.model.MarketplaceTabSearchElement r5 = new com.avito.android.brandspace.remote.model.MarketplaceTabSearchElement
            java.lang.Object r3 = r3.getValue()
            com.avito.android.brandspace.presenter.virtualitems.extraloading.TabDetailsSource r3 = (com.avito.android.brandspace.presenter.virtualitems.extraloading.TabDetailsSource) r3
            java.lang.String r3 = r3.getSearchUrl()
            r5.<init>(r4, r3)
            r2.add(r5)
            goto L_0x001f
        L_0x0069:
            com.avito.android.brandspace.remote.BrandspaceApi r1 = r11.a
            com.avito.android.util.BuildInfo r3 = r11.e
            java.lang.String r3 = r3.getApiKey()
            int r12 = r12.getLimit()
            com.avito.android.util.RequestUtils r4 = com.avito.android.util.RequestUtils.INSTANCE
            java.lang.String r5 = "tabs"
            java.util.Map r2 = r4.toMapQueryParams(r2, r5)
            io.reactivex.rxjava3.core.Single r12 = r1.getMarketplaceTabsModule(r3, r12, r2)
            com.avito.android.util.SchedulersFactory3 r1 = r11.b
            io.reactivex.rxjava3.core.Scheduler r1 = r1.io()
            io.reactivex.rxjava3.core.Single r12 = r12.subscribeOn(r1)
            com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl$a r1 = new com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl$a
            r1.<init>(r11, r0)
            io.reactivex.rxjava3.core.Single r12 = r12.map(r1)
            com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl$b r0 = com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl.b.a
            if (r0 == 0) goto L_0x009e
            a2.a.a.w.a.a r1 = new a2.a.a.w.a.a
            r1.<init>(r0)
            r0 = r1
        L_0x009e:
            io.reactivex.rxjava3.functions.Function r0 = (io.reactivex.rxjava3.functions.Function) r0
            io.reactivex.rxjava3.core.Single r12 = r12.map(r0)
            java.lang.String r0 = "brandspaceApi.getMarketp…           .map(::listOf)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.data.BrandspaceTabsRepositoryImpl.getAdverts(com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource$TabsSource):io.reactivex.rxjava3.core.Single");
    }
}
