package com.avito.android.brandspace.presenter.virtualitems.extraloading;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/ExtraLoadingListItems;", "", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getResult", "()Ljava/util/List;", "items", "", "addItems", "(Ljava/util/List;)V", "errorLoading", "()V", "", "isLoaded", "()Z", "oldItem", "newItem", "replaceItem", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;Lcom/avito/android/brandspace/presenter/BrandspaceItem;)V", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "getAdvertSource", "()Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "advertSource", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface ExtraLoadingListItems {
    void addItems(@NotNull List<? extends BrandspaceItem> list) throws IllegalStateException;

    void errorLoading();

    @NotNull
    AdvertSource getAdvertSource();

    @NotNull
    List<BrandspaceItem> getResult() throws IllegalStateException;

    boolean isLoaded();

    void replaceItem(@NotNull BrandspaceItem brandspaceItem, @NotNull BrandspaceItem brandspaceItem2);
}
