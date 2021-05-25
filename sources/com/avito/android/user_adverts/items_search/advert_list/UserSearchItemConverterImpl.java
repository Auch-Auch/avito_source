package com.avito.android.user_adverts.items_search.advert_list;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleItem;
import com.avito.android.user_adverts.tab_screens.converters.UserItemConverter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverterImpl;", "Lcom/avito/android/user_adverts/items_search/advert_list/UserSearchItemConverter;", "", "totalCount", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "Lio/reactivex/Observable;", "Lcom/avito/android/serp/adapter/SpannedItem;", "convert", "(ILjava/util/List;)Lio/reactivex/Observable;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;", "itemConverter", "<init>", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserItemConverter;Landroid/content/res/Resources;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserSearchItemConverterImpl implements UserSearchItemConverter {
    public final UserItemConverter a;
    public final Resources b;

    public static final class a<T, R> implements Function<List<? extends SerpItem>, List<? extends SerpItem>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SerpItem> apply(List<? extends SerpItem> list) {
            List<? extends SerpItem> list2 = list;
            ArrayList i0 = a2.b.a.a.a.i0(list2, "items");
            for (T t : list2) {
                if (!(t instanceof ShortcutTitleItem)) {
                    i0.add(t);
                }
            }
            return i0;
        }
    }

    public static final class b<T, R> implements Function<List<? extends SerpItem>, List<? extends SpannedItem>> {
        public final /* synthetic */ UserSearchItemConverterImpl a;
        public final /* synthetic */ int b;

        public b(UserSearchItemConverterImpl userSearchItemConverterImpl, int i) {
            this.a = userSearchItemConverterImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends SpannedItem> apply(List<? extends SerpItem> list) {
            List<? extends SerpItem> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "items");
            return CollectionsKt___CollectionsKt.plus((Collection) UserSearchItemConverterImpl.access$getCountItem(this.a, this.b), (Iterable) list2);
        }
    }

    @Inject
    public UserSearchItemConverterImpl(@NotNull UserItemConverter userItemConverter, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(userItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = userItemConverter;
        this.b = resources;
    }

    public static final List access$getCountItem(UserSearchItemConverterImpl userSearchItemConverterImpl, int i) {
        Objects.requireNonNull(userSearchItemConverterImpl);
        if (i <= 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        String quantityString = userSearchItemConverterImpl.b.getQuantityString(R.plurals.my_advert_search_counter, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…, totalCount, totalCount)");
        return d.listOf(new SearchCountItem(quantityString));
    }

    @Override // com.avito.android.user_adverts.items_search.advert_list.UserSearchItemConverter
    @NotNull
    public Observable<List<SpannedItem>> convert(int i, @NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        Observable<R> map = this.a.convert(list).map(a.a).map(new b(this, i));
        Intrinsics.checkNotNullExpressionValue(map, "itemConverter.convert(li…tem(totalCount) + items }");
        return map;
    }
}
