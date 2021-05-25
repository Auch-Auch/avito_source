package ru.sravni.android.bankproduct.presentation.main.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/presentation/main/viewmodel/IErrorViewModel;", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "Landroidx/lifecycle/LiveData;", "", "getShowDialogError", "()Landroidx/lifecycle/LiveData;", "showDialogError", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "getShowSnackBarError", "showSnackBarError", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IErrorViewModel extends IErrorHandlerWithShow {
    @NotNull
    LiveData<String> getShowDialogError();

    @NotNull
    LiveData<SravniError> getShowSnackBarError();
}
