package com.avito.android.fees.refactor;

import com.avito.android.remote.model.AdvertFeesEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/fees/refactor/PackageSelectionListener;", "", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "restrictions", "", "onPackageSelected", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface PackageSelectionListener {
    void onPackageSelected(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list);
}
