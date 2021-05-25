package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.OsagoOrderContentCardDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.OsagoNavOrderInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/OsagoOrderAnswerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/IOsagoOrderAnswerViewModel;", "", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;", "contentCard", "", "init", "(Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/IContentCardDomain;)V", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;", "nextContentCard", "clickShowOsagoOrder", "(Lru/sravni/android/bankproduct/presentation/chat/viewmodel/INextContentCard;)V", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "d", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "f", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "c", "Lru/sravni/android/bankproduct/utils/navigation/entity/OsagoNavOrderInfo;", "osagoNavOrderInfo", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", g.a, "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OsagoOrderAnswerViewModel extends ViewModel implements IOsagoOrderAnswerViewModel {
    public OsagoNavOrderInfo c;
    public final INavigator d;
    public final IErrorHandlerWithShow e;
    public final IThrowableWrapper f;
    public final IResourceProvider g;

    public OsagoOrderAnswerViewModel(@NotNull INavigator iNavigator, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.d = iNavigator;
        this.e = iErrorHandlerWithShow;
        this.f = iThrowableWrapper;
        this.g = iResourceProvider;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel
    public void clickShowOsagoOrder(@NotNull INextContentCard iNextContentCard) {
        Unit unit;
        Intrinsics.checkParameterIsNotNull(iNextContentCard, "nextContentCard");
        OsagoNavOrderInfo osagoNavOrderInfo = this.c;
        if (osagoNavOrderInfo != null) {
            iNextContentCard.nextCard(new AnswerInfoDomain(osagoNavOrderInfo.getCardID(), osagoNavOrderInfo.getConversationID(), this.g.getString(R.string.go_to_payment), null, null, 24, null));
            INavigator.DefaultImpls.route$default(this.d, R.id.action_chatFragment_to_offerOsagoOrderFragment, UtilFunctionsKt.toSravniJson(this.c), null, 4, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.e.handleError(this.f.wrap(new NullNavInfoOsagoOrderError()));
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize
    public void init(@NotNull String str, @Nullable IContentCardDomain iContentCardDomain) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        if (!(iContentCardDomain instanceof OsagoOrderContentCardDomain)) {
            iContentCardDomain = null;
        }
        OsagoOrderContentCardDomain osagoOrderContentCardDomain = (OsagoOrderContentCardDomain) iContentCardDomain;
        if (osagoOrderContentCardDomain != null) {
            this.c = new OsagoNavOrderInfo(str, osagoOrderContentCardDomain.getOrderId(), osagoOrderContentCardDomain.getSavedSearchID());
        }
    }
}
