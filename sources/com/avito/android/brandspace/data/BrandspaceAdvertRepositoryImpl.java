package com.avito.android.brandspace.data;

import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItem;
import com.avito.android.brandspace.presenter.MarketplaceItemsProcessor;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.brandspace.remote.model.MarketplaceSnippetsResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ]\u0010\t\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005 \u0007*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005\u0018\u00010\u0004¢\u0006\u0002\b\b0\u0004¢\u0006\u0002\b\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/data/BrandspaceAdvertRepositoryImpl;", "Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/items/marketplace/snippet/MarketplaceSnippetItem;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "getAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/BuildInfo;", "d", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/brandspace/remote/BrandspaceApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/remote/BrandspaceApi;", "brandspaceApi", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "c", "Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;", "marketplaceItemsProcessor", "<init>", "(Lcom/avito/android/brandspace/remote/BrandspaceApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/brandspace/presenter/MarketplaceItemsProcessor;Lcom/avito/android/util/BuildInfo;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdvertRepositoryImpl implements AdvertRepository<AdvertSource.LinkSource> {
    public final BrandspaceApi a;
    public final SchedulersFactory3 b;
    public final MarketplaceItemsProcessor c;
    public final BuildInfo d;

    public static final class a<T, R> implements Function<MarketplaceSnippetsResult, List<? extends MarketplaceSnippetItem>> {
        public final /* synthetic */ BrandspaceAdvertRepositoryImpl a;

        public a(BrandspaceAdvertRepositoryImpl brandspaceAdvertRepositoryImpl) {
            this.a = brandspaceAdvertRepositoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends MarketplaceSnippetItem> apply(MarketplaceSnippetsResult marketplaceSnippetsResult) {
            return this.a.c.convert(marketplaceSnippetsResult.getItems());
        }
    }

    @Inject
    public BrandspaceAdvertRepositoryImpl(@NotNull BrandspaceApi brandspaceApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MarketplaceItemsProcessor marketplaceItemsProcessor, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(brandspaceApi, "brandspaceApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(marketplaceItemsProcessor, "marketplaceItemsProcessor");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = brandspaceApi;
        this.b = schedulersFactory3;
        this.c = marketplaceItemsProcessor;
        this.d = buildInfo;
    }

    public Single<List<MarketplaceSnippetItem>> getAdverts(@NotNull AdvertSource.LinkSource linkSource) {
        Intrinsics.checkNotNullParameter(linkSource, "source");
        return this.a.getMarketplaceItemModule(linkSource.getLink(), this.d.getApiKey()).subscribeOn(this.b.io()).map(new a(this));
    }
}
