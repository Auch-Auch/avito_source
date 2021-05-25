package com.avito.android.advert.viewed;

import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0010\u001a\u00020\u00042\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/advert/viewed/ViewedAdvertsView;)V", "detachView", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedAdvertsPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.advert.viewed.ViewedAdvertsPresenter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onSecondaryDataSourcesChanged$default(ViewedAdvertsPresenter viewedAdvertsPresenter, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    list = null;
                }
                viewedAdvertsPresenter.onSecondaryDataSourcesChanged(list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSecondaryDataSourcesChanged");
        }
    }

    void attachView(@NotNull ViewedAdvertsView viewedAdvertsView);

    void detachView();

    void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource);

    void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list);
}
