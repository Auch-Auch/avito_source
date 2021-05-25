package com.avito.konveyor.adapter;

import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "Lcom/avito/konveyor/blueprint/ItemView;", "view", "", VKApiConst.POSITION, "", "payloads", "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;ILjava/util/List;)V", "getCount", "()I", "getViewType", "(I)I", "", "getItemId", "(I)J", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "isEmpty", "()Z", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public interface AdapterPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.konveyor.adapter.AdapterPresenter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void bindView$default(AdapterPresenter adapterPresenter, ItemView itemView, int i, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                adapterPresenter.bindView(itemView, i, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindView");
        }

        public static boolean isEmpty(@NotNull AdapterPresenter adapterPresenter) {
            return adapterPresenter.getCount() == 0;
        }
    }

    void bindView(@NotNull ItemView itemView, int i, @NotNull List<? extends Object> list);

    int getCount();

    long getItemId(int i);

    int getViewType(int i);

    boolean isEmpty();

    void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource);
}
