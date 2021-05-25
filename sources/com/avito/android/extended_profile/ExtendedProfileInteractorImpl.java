package com.avito.android.extended_profile;

import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemKt;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItem;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItem;
import com.avito.android.extended_profile.adapter.gallery.GalleryItemKt;
import com.avito.android.extended_profile.adapter.info.InfoItem;
import com.avito.android.extended_profile.adapter.title.TitleItem;
import com.avito.android.extended_profile.data.CategoryData;
import com.avito.android.extended_profile.data.CategoryDataContainer;
import com.avito.android.extended_profile.data.ExtendedProfileDataItem;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.PublicProfileResult;
import com.avito.android.public_profile.remote.model.PublicUserProfile;
import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.ExtendedProfileAdvertsNextPage;
import com.avito.android.remote.model.ExtendedProfileAdvertsNextPageResult;
import com.avito.android.remote.model.ExtendedProfileBadgeBar;
import com.avito.android.remote.model.ExtendedProfileCategory;
import com.avito.android.remote.model.ExtendedProfileCategoryAdverts;
import com.avito.android.remote.model.ExtendedProfileElement;
import com.avito.android.remote.model.ExtendedProfileGallery;
import com.avito.android.remote.model.ExtendedProfileInfo;
import com.avito.android.remote.model.ExtendedProfileItemGroups;
import com.avito.android.remote.model.ExtendedProfileResult;
import com.avito.android.remote.model.ExtendedProfileTitle;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u000278BI\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b5\u00106J-\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\tJ+\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00069"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileInteractorImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "", "userKey", "contextId", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "loadPublicUserProfile", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/extended_profile/data/ExtendedProfileDataItem;", "loadExtendedProfile", ShareConstants.MEDIA_URI, "Lcom/avito/android/extended_profile/data/CategoryData;", "category", "loadNextPage", "(Ljava/lang/String;Lcom/avito/android/extended_profile/data/CategoryData;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/SerpAdvert;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/SerpAdvert;)Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "Lcom/avito/android/remote/ExtendedProfileApi;", "Lcom/avito/android/remote/ExtendedProfileApi;", "api", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "publicProfileApi", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", a2.g.r.g.a, "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "h", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "performanceTracker", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "c", "Lcom/avito/android/db/favorites/FavoritesSyncDao;", "favoritesSyncDao", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "d", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "viewedAdvertsDao", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "f", "Lcom/avito/android/serp/adapter/SerpAdvertConverter;", "serpAdvertConverter", "<init>", "(Lcom/avito/android/remote/ExtendedProfileApi;Lcom/avito/android/public_profile/remote/PublicProfileApi;Lcom/avito/android/db/favorites/FavoritesSyncDao;Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/adapter/SerpAdvertConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;)V", "UserBannedError", "UserRemovedError", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileInteractorImpl implements ExtendedProfileInteractor {
    public final ExtendedProfileApi a;
    public final PublicProfileApi b;
    public final FavoritesSyncDao c;
    public final ViewedAdvertsDao d;
    public final SchedulersFactory3 e;
    public final SerpAdvertConverter f;
    public final TypedErrorThrowableConverter g;
    public final ExtendedProfileTracker h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileInteractorImpl$UserBannedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserBannedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserBannedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileInteractorImpl$UserRemovedError;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserRemovedError implements ErrorWithMessage {
        @NotNull
        public final String a;

        public UserRemovedError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.a;
        }
    }

    public static final class a<T> implements Consumer<ExtendedProfileResult> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public a(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ExtendedProfileResult extendedProfileResult) {
            this.a.h.trackExtendedProfileLoaded();
            this.a.h.startExtendedProfilePreparing();
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public b(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.h.trackExtendedProfileLoadError();
            this.a.h.startExtendedProfilePreparing();
        }
    }

    public static final class c<T, R> implements Function<ExtendedProfileResult, LoadingState<? super List<? extends ExtendedProfileDataItem>>> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public c(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super List<? extends ExtendedProfileDataItem>> apply(ExtendedProfileResult extendedProfileResult) {
            return new LoadingState.Loaded(ExtendedProfileInteractorImpl.access$convertToExtendedProfileData(this.a, extendedProfileResult.getBlocks()));
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super List<? extends ExtendedProfileDataItem>>> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public d(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super List<? extends ExtendedProfileDataItem>> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class e<T, R> implements Function<ExtendedProfileAdvertsNextPageResult, LoadingState<? super CategoryData>> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;
        public final /* synthetic */ CategoryData b;

        public e(ExtendedProfileInteractorImpl extendedProfileInteractorImpl, CategoryData categoryData) {
            this.a = extendedProfileInteractorImpl;
            this.b = categoryData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super CategoryData> apply(ExtendedProfileAdvertsNextPageResult extendedProfileAdvertsNextPageResult) {
            ExtendedProfileAdvertsNextPageResult extendedProfileAdvertsNextPageResult2 = extendedProfileAdvertsNextPageResult;
            ExtendedProfileInteractorImpl extendedProfileInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(extendedProfileAdvertsNextPageResult2, "it");
            return new LoadingState.Loaded(ExtendedProfileInteractorImpl.access$createCategoryForAppend(extendedProfileInteractorImpl, extendedProfileAdvertsNextPageResult2, this.b));
        }
    }

    public static final class f<T, R> implements Function<Throwable, LoadingState<? super CategoryData>> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public f(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super CategoryData> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    public static final class g<T, R> implements Function<PublicProfileResult, LoadingState<? super PublicUserProfile>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super PublicUserProfile> apply(PublicProfileResult publicProfileResult) {
            PublicProfileResult publicProfileResult2 = publicProfileResult;
            if (publicProfileResult2 instanceof PublicProfileResult.Ok) {
                return new LoadingState.Loaded(((PublicProfileResult.Ok) publicProfileResult2).getProfile());
            }
            if (publicProfileResult2 instanceof PublicProfileResult.UserBanned) {
                return new LoadingState.Error(new UserBannedError(((PublicProfileResult.UserBanned) publicProfileResult2).getMessage()));
            }
            if (publicProfileResult2 instanceof PublicProfileResult.UserRemoved) {
                return new LoadingState.Error(new UserRemovedError(((PublicProfileResult.UserRemoved) publicProfileResult2).getMessage()));
            }
            if (publicProfileResult2 instanceof PublicProfileResult.FailedWithMessage) {
                return new LoadingState.Error(new ErrorWithMessage.SimpleMessageError(((PublicProfileResult.FailedWithMessage) publicProfileResult2).getMessage()));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class h<T, R> implements Function<Throwable, LoadingState<? super PublicUserProfile>> {
        public final /* synthetic */ ExtendedProfileInteractorImpl a;

        public h(ExtendedProfileInteractorImpl extendedProfileInteractorImpl) {
            this.a = extendedProfileInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super PublicUserProfile> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.g;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public ExtendedProfileInteractorImpl(@NotNull ExtendedProfileApi extendedProfileApi, @NotNull PublicProfileApi publicProfileApi, @NotNull FavoritesSyncDao favoritesSyncDao, @NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SerpAdvertConverter serpAdvertConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull ExtendedProfileTracker extendedProfileTracker) {
        Intrinsics.checkNotNullParameter(extendedProfileApi, "api");
        Intrinsics.checkNotNullParameter(publicProfileApi, "publicProfileApi");
        Intrinsics.checkNotNullParameter(favoritesSyncDao, "favoritesSyncDao");
        Intrinsics.checkNotNullParameter(viewedAdvertsDao, "viewedAdvertsDao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(serpAdvertConverter, "serpAdvertConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(extendedProfileTracker, "performanceTracker");
        this.a = extendedProfileApi;
        this.b = publicProfileApi;
        this.c = favoritesSyncDao;
        this.d = viewedAdvertsDao;
        this.e = schedulersFactory3;
        this.f = serpAdvertConverter;
        this.g = typedErrorThrowableConverter;
        this.h = extendedProfileTracker;
    }

    public static final List access$convertToExtendedProfileData(ExtendedProfileInteractorImpl extendedProfileInteractorImpl, List list) {
        String str;
        ArrayList arrayList;
        CategoryButtonItem categoryButtonItem;
        ExtendedProfileAdvertsNextPage nextPage;
        ExtendedProfileAdvertsNextPage nextPage2;
        List<SerpElement> adverts;
        ExtendedProfileAdvertsNextPage nextPage3;
        Objects.requireNonNull(extendedProfileInteractorImpl);
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ExtendedProfileElement extendedProfileElement = (ExtendedProfileElement) it.next();
                boolean z = false;
                if (extendedProfileElement instanceof ExtendedProfileTitle) {
                    ExtendedProfileTitle extendedProfileTitle = (ExtendedProfileTitle) extendedProfileElement;
                    String text = extendedProfileTitle.getText();
                    if (text != null) {
                        if (text.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        String text2 = extendedProfileTitle.getText();
                        Intrinsics.checkNotNull(text2);
                        arrayList2.add(new TitleItem(null, null, text2, 3, null));
                    }
                } else if (extendedProfileElement instanceof ExtendedProfileInfo) {
                    ExtendedProfileInfo extendedProfileInfo = (ExtendedProfileInfo) extendedProfileElement;
                    String text3 = extendedProfileInfo.getText();
                    if (text3 != null) {
                        if (text3.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        String text4 = extendedProfileInfo.getText();
                        Intrinsics.checkNotNull(text4);
                        Objects.requireNonNull(text4, "null cannot be cast to non-null type kotlin.CharSequence");
                        arrayList2.add(new InfoItem(null, null, StringsKt__StringsKt.trim(text4).toString(), false, 11, null));
                    }
                } else if (extendedProfileElement instanceof ExtendedProfileBadgeBar) {
                    arrayList2.add(BadgeBarItemKt.toBadgeBarItem((ExtendedProfileBadgeBar) extendedProfileElement));
                } else if (extendedProfileElement instanceof ExtendedProfileGallery) {
                    arrayList2.add(GalleryItemKt.toGalleryItem((ExtendedProfileGallery) extendedProfileElement));
                } else if (extendedProfileElement instanceof ExtendedProfileItemGroups) {
                    CategoryDataContainer categoryDataContainer = new CategoryDataContainer(null, 1, null);
                    List<ExtendedProfileCategory> categories = ((ExtendedProfileItemGroups) extendedProfileElement).getCategories();
                    if (categories != null) {
                        for (T t : categories) {
                            List<CategoryData> categories2 = categoryDataContainer.getCategories();
                            ExtendedProfileCategoryAdverts items = t.getItems();
                            if (items == null || (nextPage3 = items.getNextPage()) == null || (str = nextPage3.getUri()) == null) {
                                str = t.getLoadUri();
                            }
                            CategoryData categoryData = new CategoryData(null, null, null, str, 7, null);
                            String title = t.getTitle();
                            Boolean isCollapsed = t.isCollapsed();
                            boolean booleanValue = isCollapsed != null ? isCollapsed.booleanValue() : true;
                            Boolean isCollapsible = t.isCollapsible();
                            CategoryHeaderItem categoryHeaderItem = new CategoryHeaderItem(null, null, title, booleanValue, isCollapsible != null ? isCollapsible.booleanValue() : true, false, categoryData, false, 163, null);
                            ExtendedProfileCategoryAdverts items2 = t.getItems();
                            if (items2 == null || (adverts = items2.getAdverts()) == null) {
                                arrayList = CollectionsKt__CollectionsKt.emptyList();
                            } else {
                                ArrayList arrayList3 = new ArrayList();
                                for (T t2 : adverts) {
                                    if (t2 instanceof SerpAdvert) {
                                        arrayList3.add(t2);
                                    }
                                }
                                ArrayList arrayList4 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList3, 10));
                                Iterator it2 = arrayList3.iterator();
                                while (it2.hasNext()) {
                                    arrayList4.add(extendedProfileInteractorImpl.a((SerpAdvert) it2.next()));
                                }
                                arrayList = arrayList4;
                            }
                            ExtendedProfileCategoryAdverts items3 = t.getItems();
                            if (items3 == null || (nextPage = items3.getNextPage()) == null || nextPage.getUri() == null) {
                                categoryButtonItem = null;
                            } else {
                                ExtendedProfileCategoryAdverts items4 = t.getItems();
                                categoryButtonItem = new CategoryButtonItem(null, null, (items4 == null || (nextPage2 = items4.getNextPage()) == null) ? null : nextPage2.getTitle(), false, categoryData, 3, null);
                            }
                            categoryData.setHeaderItem(categoryHeaderItem);
                            categoryData.getAdvertItems().addAll(arrayList);
                            categoryData.setButtonItem(categoryButtonItem);
                            categories2.add(categoryData);
                        }
                    }
                    arrayList2.add(categoryDataContainer);
                }
            }
        }
        return arrayList2;
    }

    public static final CategoryData access$createCategoryForAppend(ExtendedProfileInteractorImpl extendedProfileInteractorImpl, ExtendedProfileAdvertsNextPageResult extendedProfileAdvertsNextPageResult, CategoryData categoryData) {
        Objects.requireNonNull(extendedProfileInteractorImpl);
        CategoryButtonItem categoryButtonItem = null;
        String str = null;
        categoryButtonItem = null;
        CategoryData categoryData2 = new CategoryData(null, null, null, null, 15, null);
        ExtendedProfileAdvertsNextPage nextPage = extendedProfileAdvertsNextPageResult.getItems().getNextPage();
        categoryData2.setLoadMoreUri(nextPage != null ? nextPage.getUri() : null);
        List<SerpElement> adverts = extendedProfileAdvertsNextPageResult.getItems().getAdverts();
        if (adverts != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : adverts) {
                if (t instanceof SerpAdvert) {
                    arrayList.add(t);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                categoryData2.getAdvertItems().add(extendedProfileInteractorImpl.a((SerpAdvert) it.next()));
            }
        }
        ExtendedProfileAdvertsNextPage nextPage2 = extendedProfileAdvertsNextPageResult.getItems().getNextPage();
        if (!(nextPage2 == null || nextPage2.getUri() == null)) {
            ExtendedProfileAdvertsNextPage nextPage3 = extendedProfileAdvertsNextPageResult.getItems().getNextPage();
            if (nextPage3 != null) {
                str = nextPage3.getTitle();
            }
            categoryButtonItem = new CategoryButtonItem(null, null, str, false, categoryData, 3, null);
        }
        categoryData2.setButtonItem(categoryButtonItem);
        return categoryData2;
    }

    public final CategoryAdvertItem a(SerpAdvert serpAdvert) {
        AdvertItem convert$default = SerpAdvertConverter.DefaultImpls.convert$default(this.f, serpAdvert, false, SerpDisplayType.List, 2, null);
        convert$default.setFavorite(this.c.isFavorite(convert$default.getStringId(), convert$default.isFavorite()));
        convert$default.setViewed(this.d.isViewed(convert$default.getStringId()));
        return new CategoryAdvertItem(null, null, convert$default, null, 11, null);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileInteractor
    @NotNull
    public Observable<LoadingState<List<? extends ExtendedProfileDataItem>>> loadExtendedProfile(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<LoadingState<List<? extends ExtendedProfileDataItem>>> onErrorReturn = TypedObservablesKt.toTyped(this.a.getExtendedProfile(str, str2)).subscribeOn(this.e.io()).observeOn(this.e.mainThread()).doOnNext(new a(this)).doOnError(new b(this)).observeOn(this.e.io()).map(new c(this)).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new d(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getExtendedProfile(u…eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileInteractor
    @NotNull
    public Observable<LoadingState<CategoryData>> loadNextPage(@NotNull String str, @NotNull CategoryData categoryData) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(categoryData, "category");
        Observable<LoadingState<CategoryData>> onErrorReturn = TypedObservablesKt.toTyped(this.a.getNextPage(str)).subscribeOn(this.e.io()).map(new e(this, categoryData)).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new f(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "api.getNextPage(uri)\n   …eConverter.convert(it)) }");
        return onErrorReturn;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileInteractor
    @NotNull
    public Observable<LoadingState<PublicUserProfile>> loadPublicUserProfile(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Observable<LoadingState<PublicUserProfile>> onErrorReturn = TypedObservablesKt.toTyped(this.b.getPublicUserProfile(str, str2)).map(g.a).subscribeOn(this.e.io()).startWithItem(LoadingState.Loading.INSTANCE).onErrorReturn(new h(this));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "publicProfileApi.getPubl…eConverter.convert(it)) }");
        return onErrorReturn;
    }
}
