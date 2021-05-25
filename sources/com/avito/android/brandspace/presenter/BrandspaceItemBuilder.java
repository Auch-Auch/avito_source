package com.avito.android.brandspace.presenter;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.brandspace.remote.model.Brandspace;
import io.reactivex.rxjava3.core.Single;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015R,\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceItemBuilder;", "", "Lcom/avito/android/brandspace/remote/model/Brandspace;", ScreenPublicConstsKt.CONTENT_TYPE_BRANDSPACE, "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "build", "(Lcom/avito/android/brandspace/remote/model/Brandspace;)Lio/reactivex/rxjava3/core/Single;", "items", "refresh", "(Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "brandspaceAdverts", "addFilteredAdverts", "(Lcom/avito/android/brandspace/remote/model/Brandspace;Ljava/util/List;Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;)Ljava/util/List;", "removeFilteredAdverts", "(Ljava/util/List;)Ljava/util/List;", "item", "", "isLastItemInBlock", "(Lcom/avito/android/brandspace/presenter/BrandspaceItem;)Z", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getLastBlockItemIds", "()Ljava/util/HashSet;", "setLastBlockItemIds", "(Ljava/util/HashSet;)V", "lastBlockItemIds", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceItemBuilder {
    @NotNull
    List<BrandspaceItem> addFilteredAdverts(@NotNull Brandspace brandspace, @NotNull List<? extends BrandspaceItem> list, @NotNull BrandspaceAdverts brandspaceAdverts);

    @NotNull
    Single<List<BrandspaceItem>> build(@NotNull Brandspace brandspace);

    @NotNull
    HashSet<Long> getLastBlockItemIds();

    boolean isLastItemInBlock(@NotNull BrandspaceItem brandspaceItem);

    @NotNull
    Single<List<BrandspaceItem>> refresh(@NotNull List<? extends BrandspaceItem> list);

    @NotNull
    List<BrandspaceItem> removeFilteredAdverts(@NotNull List<? extends BrandspaceItem> list);

    void setLastBlockItemIds(@NotNull HashSet<Long> hashSet);
}
