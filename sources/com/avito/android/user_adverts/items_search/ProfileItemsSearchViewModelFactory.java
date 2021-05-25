package com.avito.android.user_adverts.items_search;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestsItemConverter;
import com.avito.android.user_adverts.items_search.analytics.ProfileItemsSearchTracker;
import com.avito.android.user_adverts.items_search.di.ProfileItemsSearchModule;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b$\u0010%J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;", "tracker", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "d", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "itemConverter", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "", g.a, "Ljava/lang/String;", "shortcut", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;", "interactor", "Lcom/avito/android/analytics/Analytics;", "f", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "e", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;", "suggestConverter", "<init>", "(Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchInteractor;Lcom/avito/android/user_adverts/items_search/analytics/ProfileItemsSearchTracker;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestsItemConverter;Lcom/avito/android/analytics/Analytics;Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchViewModelFactory implements ViewModelProvider.Factory {
    public final ProfileItemsSearchInteractor a;
    public final ProfileItemsSearchTracker b;
    public final SchedulersFactory c;
    public final UserSearchItemConverter d;
    public final SuggestsItemConverter e;
    public final Analytics f;
    public final String g;

    @Inject
    public ProfileItemsSearchViewModelFactory(@NotNull ProfileItemsSearchInteractor profileItemsSearchInteractor, @NotNull ProfileItemsSearchTracker profileItemsSearchTracker, @NotNull SchedulersFactory schedulersFactory, @NotNull UserSearchItemConverter userSearchItemConverter, @NotNull SuggestsItemConverter suggestsItemConverter, @NotNull Analytics analytics, @ProfileItemsSearchModule.Shortcut @NotNull String str) {
        Intrinsics.checkNotNullParameter(profileItemsSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(profileItemsSearchTracker, "tracker");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(userSearchItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(suggestsItemConverter, "suggestConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(str, "shortcut");
        this.a = profileItemsSearchInteractor;
        this.b = profileItemsSearchTracker;
        this.c = schedulersFactory;
        this.d = userSearchItemConverter;
        this.e = suggestsItemConverter;
        this.f = analytics;
        this.g = str;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(ProfileItemsSearchViewModelImpl.class)) {
            return new ProfileItemsSearchViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
