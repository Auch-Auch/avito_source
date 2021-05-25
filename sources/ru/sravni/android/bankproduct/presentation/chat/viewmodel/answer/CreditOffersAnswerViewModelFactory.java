package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/CreditOffersAnswerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", AnalyticFieldsName.productName, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "e", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "d", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errWrapper", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CreditOffersAnswerViewModelFactory implements ViewModelProvider.Factory {
    public final INavigator a;
    public final String b;
    public final IErrorHandlerWithShow c;
    public final IThrowableWrapper d;
    public final IFeatureToggleRouterDomain e;

    public CreditOffersAnswerViewModelFactory(@NotNull INavigator iNavigator, @NotNull String str, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errWrapper");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.a = iNavigator;
        this.b = str;
        this.c = iErrorHandlerWithShow;
        this.d = iThrowableWrapper;
        this.e = iFeatureToggleRouterDomain;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new CreditOffersAnswerViewModel(this.a, this.b, this.c, this.d, this.e);
    }
}
