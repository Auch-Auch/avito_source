package com.avito.android.publish_limits_info.history.tab.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemListBlueprint;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemPresenter;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItemPresenterImpl;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemBlueprint;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemPresenter;
import com.avito.android.publish_limits_info.history.tab.info.InfoItemPresenterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/di/HistoryAdvertsListModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$publish_limits_info_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "adapterPresenter", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemListBlueprint;", "historyAdvertItemListBlueprint", "Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemBlueprint;", "infoItemListBlueprint", "provideItemBinder$publish_limits_info_release", "(Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemListBlueprint;Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemPresenter;", "provideItemPresenter$publish_limits_info_release", "()Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemPresenter;", "provideItemPresenter", "<init>", "()V", "Declarations", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class HistoryAdvertsListModule {
    @NotNull
    public static final HistoryAdvertsListModule INSTANCE = new HistoryAdvertsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/di/HistoryAdvertsListModule$Declarations;", "", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenterImpl;", "presenter", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenter;", "provideHistoryAdvertPresenter", "(Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenterImpl;)Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenter;", "Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemPresenter;", "itemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideInfoItemPresenter", "(Lcom/avito/android/publish_limits_info/history/tab/info/InfoItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        HistoryAdvertItemPresenter provideHistoryAdvertPresenter(@NotNull HistoryAdvertItemPresenterImpl historyAdvertItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideInfoItemPresenter(@NotNull InfoItemPresenter infoItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter provideAdapterPresenter$publish_limits_info_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$publish_limits_info_release(@NotNull HistoryAdvertItemListBlueprint historyAdvertItemListBlueprint, @NotNull InfoItemBlueprint infoItemBlueprint) {
        Intrinsics.checkNotNullParameter(historyAdvertItemListBlueprint, "historyAdvertItemListBlueprint");
        Intrinsics.checkNotNullParameter(infoItemBlueprint, "infoItemListBlueprint");
        return new ItemBinder.Builder().registerItem(historyAdvertItemListBlueprint).registerItem(infoItemBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final InfoItemPresenter provideItemPresenter$publish_limits_info_release() {
        return new InfoItemPresenterImpl();
    }
}
