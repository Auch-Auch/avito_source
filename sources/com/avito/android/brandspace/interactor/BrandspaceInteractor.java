package com.avito.android.brandspace.interactor;

import com.avito.android.brandspace.presenter.BrandspaceAdverts;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.model.Brandspace;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/brandspace/remote/model/Brandspace;", "loadBrandspace", "()Lio/reactivex/rxjava3/core/Observable;", "", "", "searchParams", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "loadFilteredAdverts", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "loadAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;)Lio/reactivex/rxjava3/core/Single;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface BrandspaceInteractor {
    @NotNull
    Single<? extends List<BrandspaceItem>> loadAdverts(@NotNull AdvertSource advertSource);

    @NotNull
    Observable<Brandspace> loadBrandspace();

    @NotNull
    Observable<BrandspaceAdverts> loadFilteredAdverts(@NotNull Map<String, String> map);
}
