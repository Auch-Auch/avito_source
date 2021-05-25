package com.avito.android.brandspace.data;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J%\u0010\b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "T", "", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;)Lio/reactivex/rxjava3/core/Single;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertRepository<T extends AdvertSource> {
    @NotNull
    Single<? extends List<BrandspaceItem>> getAdverts(@NotNull T t);
}
