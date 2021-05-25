package com.avito.android.fees;

import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.OwnedPackage;
import com.avito.android.remote.model.SingleFee;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/avito/android/fees/FeesView;", "", "", "onLoadingStart", "()V", "", "Lcom/avito/android/remote/model/OwnedPackage;", "packages", "", "message", "onPackageFeeAvailable", "(Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/remote/model/SingleFee;", "singleFee", "Lcom/avito/android/remote/model/Action;", "action", "onSingleFeeAvailable", "(Lcom/avito/android/remote/model/SingleFee;Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "onLoadingError", "(Ljava/lang/String;)V", "fees_release"}, k = 1, mv = {1, 4, 2})
public interface FeesView {
    void onLoadingError();

    void onLoadingError(@NotNull String str);

    void onLoadingStart();

    void onPackageFeeAvailable(@NotNull List<OwnedPackage> list, @Nullable String str);

    void onSingleFeeAvailable(@NotNull SingleFee singleFee, @Nullable String str, @NotNull Action action);
}
