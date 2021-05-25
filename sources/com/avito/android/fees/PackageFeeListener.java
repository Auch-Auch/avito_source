package com.avito.android.fees;

import com.avito.android.remote.model.AdvertFeesEntity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/fees/PackageFeeListener;", "", "", "onActivationDone", "()V", "Lcom/avito/android/remote/model/AdvertFeesEntity;", "location", "", "restrictions", "onPackageSelected", "(Lcom/avito/android/remote/model/AdvertFeesEntity;Ljava/util/List;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface PackageFeeListener {
    void onActivationDone();

    void onPackageSelected(@NotNull AdvertFeesEntity advertFeesEntity, @NotNull List<AdvertFeesEntity> list);
}
