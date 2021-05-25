package ru.sravni.android.bankproduct.domain.sravnierror;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "wrap", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IThrowableWrapper {
    @NotNull
    SravniError wrap(@Nullable Throwable th);
}
