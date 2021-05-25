package com.avito.android.grouping_adverts;

import android.net.Uri;
import com.avito.android.favorite.FavoriteModel;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.grouping_adverts.GroupingAdvertsArguments;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.AdvertImage;
import com.avito.android.remote.model.FavoritesResponse;
import com.avito.android.remote.model.HeaderElement;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.References;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b'\u0010(J7\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractorImpl;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "page", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/SerpElementResult;", "loadGroupedElements", "(Lcom/avito/android/remote/model/SearchParams;Ljava/lang/Integer;Lcom/avito/android/remote/model/SerpDisplayType;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;", "args", "", "source", "loadElementsByIds", "(Lcom/avito/android/grouping_adverts/GroupingAdvertsArguments$ItemList;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SearchParamsConverter;", "d", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/util/SchedulersFactory3;", "c", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "e", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "favoritesConvert", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "api", "Lcom/avito/android/favorites/remote/FavoritesApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/remote/FavoritesApi;", "favoritesApi", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/favorites/remote/FavoritesApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/favorites/FavoriteAdvertItemConverter;)V", "grouping-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class GroupingAdvertsInteractorImpl implements GroupingAdvertsInteractor {
    public final SearchApi a;
    public final FavoritesApi b;
    public final SchedulersFactory3 c;
    public final SearchParamsConverter d;
    public final FavoriteAdvertItemConverter e;

    public static final class a<T, R> implements Function<FavoritesResponse, SerpElementResult> {
        public final /* synthetic */ GroupingAdvertsInteractorImpl a;
        public final /* synthetic */ GroupingAdvertsArguments.ItemList b;

        public a(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl, GroupingAdvertsArguments.ItemList itemList) {
            this.a = groupingAdvertsInteractorImpl;
            this.b = itemList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SerpElementResult apply(FavoritesResponse favoritesResponse) {
            List list;
            List list2;
            FavoritesResponse favoritesResponse2 = favoritesResponse;
            List<FavoriteModel> convert = this.a.e.convert(favoritesResponse2.getFavorites(), favoritesResponse2.getReferences());
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(convert, 10));
            Iterator<T> it = convert.iterator();
            while (true) {
                list = null;
                Map<String, String> map = null;
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl = this.a;
                References references = favoritesResponse2.getReferences();
                if (references != null) {
                    map = references.getCategory();
                }
                arrayList.add(GroupingAdvertsInteractorImpl.access$convertFavoritesToSerp(groupingAdvertsInteractorImpl, next, map));
            }
            if (this.b.getTitle() != null) {
                String title = this.b.getTitle();
                String subtitle = this.b.getSubtitle();
                if (subtitle != null) {
                    list = t6.n.d.listOf(subtitle);
                }
                list2 = t6.n.d.listOf(new HeaderElement(title, list));
            } else {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            return new SerpElementResult(CollectionsKt___CollectionsKt.plus((Collection) list2, (Iterable) arrayList), 0, 0, null, null, null, null, null, null, null, null, null, 4094, null);
        }
    }

    public static final class b<T, R> implements Function<SerpElementResult, LoadingState<? super SerpElementResult>> {
        public final /* synthetic */ GroupingAdvertsInteractorImpl a;

        public b(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl) {
            this.a = groupingAdvertsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SerpElementResult> apply(SerpElementResult serpElementResult) {
            SerpElementResult serpElementResult2 = serpElementResult;
            GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(serpElementResult2, "it");
            return GroupingAdvertsInteractorImpl.access$convert(groupingAdvertsInteractorImpl, serpElementResult2);
        }
    }

    public static final class c<T, R> implements Function<Throwable, LoadingState<? super SerpElementResult>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SerpElementResult> apply(Throwable th) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            return new LoadingState.Error(new ErrorResult.UnknownError(message, null, null, 6, null));
        }
    }

    public static final class d<T, R> implements Function<TypedResult<SerpElementResult>, LoadingState<? super SerpElementResult>> {
        public final /* synthetic */ GroupingAdvertsInteractorImpl a;

        public d(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl) {
            this.a = groupingAdvertsInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super SerpElementResult> apply(TypedResult<SerpElementResult> typedResult) {
            TypedResult<SerpElementResult> typedResult2 = typedResult;
            GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(typedResult2, "it");
            return GroupingAdvertsInteractorImpl.access$convert(groupingAdvertsInteractorImpl, typedResult2);
        }
    }

    @Inject
    public GroupingAdvertsInteractorImpl(@NotNull SearchApi searchApi, @NotNull FavoritesApi favoritesApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchParamsConverter searchParamsConverter, @NotNull FavoriteAdvertItemConverter favoriteAdvertItemConverter) {
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(favoritesApi, "favoritesApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(favoriteAdvertItemConverter, "favoritesConvert");
        this.a = searchApi;
        this.b = favoritesApi;
        this.c = schedulersFactory3;
        this.d = searchParamsConverter;
        this.e = favoriteAdvertItemConverter;
    }

    public static final LoadingState access$convert(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl, SerpElementResult serpElementResult) {
        Objects.requireNonNull(groupingAdvertsInteractorImpl);
        return new LoadingState.Loaded(serpElementResult);
    }

    public static final SerpElement access$convertFavoritesToSerp(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl, FavoriteModel favoriteModel, Map map) {
        String str;
        Map<Size, Uri> variants;
        Objects.requireNonNull(groupingAdvertsInteractorImpl);
        String advertId = favoriteModel.getAdvertId();
        String address = favoriteModel.getAddress();
        String location = favoriteModel.getLocation();
        Long valueOf = Long.valueOf(favoriteModel.getTime());
        String title = favoriteModel.getTitle();
        Image image = favoriteModel.getImage();
        AdvertImage advertImage = (image == null || (variants = image.getVariants()) == null) ? null : new AdvertImage(variants.size(), favoriteModel.getImage());
        NameIdEntity nameIdEntity = (map == null || (str = (String) map.get(favoriteModel.getCategoryName())) == null) ? null : new NameIdEntity(str, favoriteModel.getCategoryName());
        String price = favoriteModel.getPrice();
        String priceWithoutDiscount = favoriteModel.getPriceWithoutDiscount();
        String previousPrice = favoriteModel.getPreviousPrice();
        FavoriteModel.Status status = favoriteModel.getStatus();
        return new SerpAdvert(advertId, address, location, null, null, null, valueOf, title, favoriteModel.getStatusDescription(), null, advertImage, nameIdEntity, null, null, price, priceWithoutDiscount, previousPrice, null, null, status != null ? status.name() : null, false, null, favoriteModel.getDeepLink(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false);
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsInteractor
    @NotNull
    public Observable<LoadingState<SerpElementResult>> loadElementsByIds(@NotNull GroupingAdvertsArguments.ItemList itemList, @Nullable String str) {
        Intrinsics.checkNotNullParameter(itemList, "args");
        Observable<R> startWithItem = this.b.getFavoritesByIds(CollectionsKt___CollectionsKt.joinToString$default(itemList.getIds(), ",", null, null, 0, null, null, 62, null)).map(new a(this, itemList)).map(new b(this)).subscribeOn(this.c.io()).onErrorReturn(c.a).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "favoritesApi.getFavorite…tem(LoadingState.Loading)");
        return startWithItem;
    }

    @Override // com.avito.android.grouping_adverts.GroupingAdvertsInteractor
    @NotNull
    public Observable<LoadingState<SerpElementResult>> loadGroupedElements(@NotNull SearchParams searchParams, @Nullable Integer num, @Nullable SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Observable<R> startWithItem = this.a.getSerpElementTypedResult(num, null, serpDisplayType != null ? SerpDisplayTypeKt.toParameterValue(serpDisplayType) : null, null, null, null, SearchParamsConverter.DefaultImpls.convertToMap$default(this.d, searchParams, null, false, false, 14, null), null).subscribeOn(this.c.io()).map(new d(this)).startWithItem((R) LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWithItem, "api.getSerpElementTypedR…tem(LoadingState.Loading)");
        return startWithItem;
    }

    public static final LoadingState access$convert(GroupingAdvertsInteractorImpl groupingAdvertsInteractorImpl, TypedResult typedResult) {
        Objects.requireNonNull(groupingAdvertsInteractorImpl);
        if (typedResult instanceof TypedResult.OfResult) {
            return new LoadingState.Loaded(((TypedResult.OfResult) typedResult).getResult());
        }
        if (typedResult instanceof TypedResult.OfError) {
            return new LoadingState.Error(((TypedResult.OfError) typedResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }
}
