package ru.sravni.android.bankproduct.utils.encryption;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/utils/encryption/ICryptParamsFormer;", "", "", "passSize", "ivSize", "saltSize", "Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "getCryptParams", "(III)Lru/sravni/android/bankproduct/utils/encryption/CryptParams;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ICryptParamsFormer {
    @NotNull
    CryptParams getCryptParams(int i, int i2, int i3);
}
