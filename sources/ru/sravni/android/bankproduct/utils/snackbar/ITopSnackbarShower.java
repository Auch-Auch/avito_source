package ru.sravni.android.bankproduct.utils.snackbar;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/utils/snackbar/ITopSnackbarShower;", "", "", "duration", "", "text", "", "showTopSnackbar", "(ILjava/lang/String;)V", "removeTopSnackbar", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ITopSnackbarShower {
    void removeTopSnackbar();

    void showTopSnackbar(int i, @NotNull String str);
}
