package com.avito.android.advert.actions;

import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\n\u001a\u00020\u00052\u0018\b\u0002\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/actions/HiddenAdvertItemPresenter;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", "", "label", "hideItem", "(Ljava/lang/String;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public interface HiddenAdvertItemPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.advert.actions.HiddenAdvertItemPresenter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onSecondaryDataSourcesChanged$default(HiddenAdvertItemPresenter hiddenAdvertItemPresenter, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    list = null;
                }
                hiddenAdvertItemPresenter.onSecondaryDataSourcesChanged(list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSecondaryDataSourcesChanged");
        }
    }

    void hideItem(@NotNull String str);

    void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource);

    void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list);
}
