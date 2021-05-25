package com.avito.android.remote.model.category_parameters;

import android.os.Parcelable;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.konveyor.data_source.IterableDataSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000e*\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/konveyor/data_source/IterableDataSource;", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Landroid/os/Parcelable;", "", "id", "findParameter", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "Lcom/avito/android/remote/model/PretendErrorValue;", "pretendResult", "", "applyPretendResult", "(Ljava/util/Map;)Z", "T", "Ljava/lang/Class;", "type", "getFirstParameterOfType", "(Ljava/lang/Class;)Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "getParametersExceptOwnedBySlots", "()Ljava/util/List;", "api_release"}, k = 1, mv = {1, 4, 2})
public interface ParametersTree extends IterableDataSource<ParameterSlot>, Parcelable {
    boolean applyPretendResult(@Nullable Map<String, ? extends PretendErrorValue> map);

    @Nullable
    ParameterSlot findParameter(@NotNull String str);

    @Nullable
    <T extends ParameterSlot> T getFirstParameterOfType(@NotNull Class<T> cls);

    @NotNull
    List<ParameterSlot> getParametersExceptOwnedBySlots();
}
