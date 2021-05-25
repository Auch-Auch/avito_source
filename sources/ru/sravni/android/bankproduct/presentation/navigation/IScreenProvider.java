package ru.sravni.android.bankproduct.presentation.navigation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.terrakok.cicerone.Screen;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/presentation/navigation/IScreenProvider;", "", "", "screenId", "", "jsonParameter", "Lru/terrakok/cicerone/Screen;", "provideScreen", "(ILjava/lang/String;)Lru/terrakok/cicerone/Screen;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IScreenProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ Screen provideScreen$default(IScreenProvider iScreenProvider, int i, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                return iScreenProvider.provideScreen(i, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: provideScreen");
        }
    }

    @NotNull
    Screen provideScreen(int i, @Nullable String str);
}
