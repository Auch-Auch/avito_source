package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/GoToDashboardAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IGoToDashboardAnswerViewModel;", "", "closeChat", "()V", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "c", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class GoToDashboardAnswerViewModel extends ViewModel implements IGoToDashboardAnswerViewModel {
    public final INavigator c;

    public GoToDashboardAnswerViewModel(@NotNull INavigator iNavigator) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        this.c = iNavigator;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IGoToDashboardAnswerViewModel
    public void closeChat() {
        this.c.popBack();
    }
}
