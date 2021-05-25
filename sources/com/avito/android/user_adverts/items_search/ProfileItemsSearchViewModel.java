package com.avito.android.user_adverts.items_search;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.component.user_advert.UserAdvertItemClickListener;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.user_adverts.items_search.advert_list.suggests.SuggestItem;
import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import com.avito.konveyor.data_source.DataSource;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001a\u001bJ!\u0010\t\u001a\u00020\b2\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH&¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\rH&¢\u0006\u0004\b\u0014\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH&¢\u0006\u0004\b\u0019\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", "Lcom/avito/android/user_adverts/items_search/SearchBarInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemAction;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/UserAdvertItemActionObservable;", "itemActions", "", "subscribeToItemActions", "(Lio/reactivex/Observable;)V", "unsubscribeFromItemActions", "()V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "itemsState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$Suggests;", "suggestsState", "Lcom/avito/android/deep_linking/links/DeepLink;", "advertClicks", "", "userIntent", "refreshResults", "(Z)V", "retryOnError", "ItemsState", "Suggests", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileItemsSearchViewModel extends UserAdvertItemClickListener, ShortcutBannerItemListener, SearchBarInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void refreshResults$default(ProfileItemsSearchViewModel profileItemsSearchViewModel, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                profileItemsSearchViewModel.refreshResults(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshResults");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "", "<init>", "()V", "Error", "Loaded", "LoadedEmpty", "Loading", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Loading;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Error;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$LoadedEmpty;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Loaded;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class ItemsState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Error;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends ItemsState {
            @NotNull
            public static final Error INSTANCE = new Error();

            public Error() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ0\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Loaded;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "component1", "()Lcom/avito/konveyor/data_source/DataSource;", "", "", "component2", "()Ljava/util/List;", "dataSource", "spaceIndices", "copy", "(Lcom/avito/konveyor/data_source/DataSource;Ljava/util/List;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Loaded;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getSpaceIndices", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/data_source/DataSource;", "getDataSource", "<init>", "(Lcom/avito/konveyor/data_source/DataSource;Ljava/util/List;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loaded extends ItemsState {
            @NotNull
            public final DataSource<SpannedItem> a;
            @NotNull
            public final List<Integer> b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Loaded(@NotNull DataSource<SpannedItem> dataSource, @NotNull List<Integer> list) {
                super(null);
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Intrinsics.checkNotNullParameter(list, "spaceIndices");
                this.a = dataSource;
                this.b = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel$ItemsState$Loaded */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, DataSource dataSource, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    dataSource = loaded.a;
                }
                if ((i & 2) != 0) {
                    list = loaded.b;
                }
                return loaded.copy(dataSource, list);
            }

            @NotNull
            public final DataSource<SpannedItem> component1() {
                return this.a;
            }

            @NotNull
            public final List<Integer> component2() {
                return this.b;
            }

            @NotNull
            public final Loaded copy(@NotNull DataSource<SpannedItem> dataSource, @NotNull List<Integer> list) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Intrinsics.checkNotNullParameter(list, "spaceIndices");
                return new Loaded(dataSource, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) obj;
                return Intrinsics.areEqual(this.a, loaded.a) && Intrinsics.areEqual(this.b, loaded.b);
            }

            @NotNull
            public final DataSource<SpannedItem> getDataSource() {
                return this.a;
            }

            @NotNull
            public final List<Integer> getSpaceIndices() {
                return this.b;
            }

            public int hashCode() {
                DataSource<SpannedItem> dataSource = this.a;
                int i = 0;
                int hashCode = (dataSource != null ? dataSource.hashCode() : 0) * 31;
                List<Integer> list = this.b;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Loaded(dataSource=");
                L.append(this.a);
                L.append(", spaceIndices=");
                return a.w(L, this.b, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$LoadedEmpty;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "", "component1", "()Ljava/lang/String;", "query", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$LoadedEmpty;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getQuery", "<init>", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class LoadedEmpty extends ItemsState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LoadedEmpty(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "query");
                this.a = str;
            }

            public static /* synthetic */ LoadedEmpty copy$default(LoadedEmpty loadedEmpty, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loadedEmpty.a;
                }
                return loadedEmpty.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final LoadedEmpty copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "query");
                return new LoadedEmpty(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof LoadedEmpty) && Intrinsics.areEqual(this.a, ((LoadedEmpty) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getQuery() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("LoadedEmpty(query="), this.a, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState$Loading;", "Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$ItemsState;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ItemsState {
            @NotNull
            public static final Loading INSTANCE = new Loading();

            public Loading() {
                super(null);
            }
        }

        public ItemsState() {
        }

        public ItemsState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$Suggests;", "", "", "Lcom/avito/android/user_adverts/items_search/advert_list/suggests/SuggestItem;", "component1", "()Ljava/util/List;", "suggests", "copy", "(Ljava/util/List;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchViewModel$Suggests;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getSuggests", "<init>", "(Ljava/util/List;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Suggests {
        @NotNull
        public final List<SuggestItem> a;

        public Suggests(@NotNull List<SuggestItem> list) {
            Intrinsics.checkNotNullParameter(list, "suggests");
            this.a = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModel$Suggests */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Suggests copy$default(Suggests suggests, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = suggests.a;
            }
            return suggests.copy(list);
        }

        @NotNull
        public final List<SuggestItem> component1() {
            return this.a;
        }

        @NotNull
        public final Suggests copy(@NotNull List<SuggestItem> list) {
            Intrinsics.checkNotNullParameter(list, "suggests");
            return new Suggests(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Suggests) && Intrinsics.areEqual(this.a, ((Suggests) obj).a);
            }
            return true;
        }

        @NotNull
        public final List<SuggestItem> getSuggests() {
            return this.a;
        }

        public int hashCode() {
            List<SuggestItem> list = this.a;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.w(a.L("Suggests(suggests="), this.a, ")");
        }
    }

    @NotNull
    LiveData<DeepLink> advertClicks();

    @NotNull
    LiveData<ItemsState> itemsState();

    void refreshResults(boolean z);

    void retryOnError();

    void subscribeToItemActions(@NotNull Observable<UserAdvertItemAction> observable);

    @NotNull
    LiveData<Suggests> suggestsState();

    void unsubscribeFromItemActions();
}
