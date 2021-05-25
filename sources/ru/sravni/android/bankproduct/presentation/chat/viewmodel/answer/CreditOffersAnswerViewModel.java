package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.ICreditOffersContentCardDomain;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.presentation.chat.NullNavInfoCreditError;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.ProductNavOffersInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/CreditOffersAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ICreditOffersAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "nextContentCard", "clickShowResult", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errWrapper", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "f", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "e", "Ljava/lang/String;", AnalyticFieldsName.productName, "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "c", "Lru/sravni/android/bankproduct/utils/navigation/entity/ProductNavOffersInfo;", "productOffersInfo", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "d", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "h", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class CreditOffersAnswerViewModel extends ViewModel implements ICreditOffersAnswerViewModel {
    public ProductNavOffersInfo c;
    public final INavigator d;
    public final String e;
    public final IErrorHandlerWithShow f;
    public final IThrowableWrapper g;
    public final IFeatureToggleRouterDomain h;

    public CreditOffersAnswerViewModel(@NotNull INavigator iNavigator, @NotNull String str, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.productName);
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errWrapper");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.d = iNavigator;
        this.e = str;
        this.f = iErrorHandlerWithShow;
        this.g = iThrowableWrapper;
        this.h = iFeatureToggleRouterDomain;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ICreditOffersAnswerViewModel
    public void clickShowResult(@NotNull INextContentCard iNextContentCard) {
        NavOptions.Builder builder;
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "nextContentCard");
        if (this.c != null) {
            if (this.h.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
                builder = new NavOptions.Builder();
            } else {
                builder = new NavOptions.Builder().setPopUpTo(R.id.chatFragment, true).setLaunchSingleTop(true);
                Intrinsics.checkExpressionValueIsNotNull(builder, "NavOptions.Builder().set….setLaunchSingleTop(true)");
            }
            if (this.h.featureIsEnabled(FeaturesToToggle.creditDeposit)) {
                iNextContentCard.waitUserAnswer();
            }
            this.d.route(R.id.action_chatFragment_to_offerProductListFragment, UtilFunctionsKt.toSravniJson(this.c), builder);
            return;
        }
        this.f.handleError(this.g.wrap(new NullNavInfoCreditError()));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof ICreditOffersContentCardDomain)) {
            iContentCardDomain = null;
        }
        ICreditOffersContentCardDomain iCreditOffersContentCardDomain = (ICreditOffersContentCardDomain) iContentCardDomain;
        if (iCreditOffersContentCardDomain != null) {
            this.c = new ProductNavOffersInfo(iCreditOffersContentCardDomain.getSavedSearchID(), this.e, false, str, Integer.valueOf(iCreditOffersContentCardDomain.getOrderId()), 4, null);
        }
    }
}
