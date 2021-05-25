package ru.sravni.android.bankproduct.presentation.chat.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.controller.IChatAnalyticController;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B]\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b1\u00102J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/ChatViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "f", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "c", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "j", "Ljava/util/List;", "listChatInitialize", "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "h", "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "productAnalytic", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "i", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;", "chatAnalyticController", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", g.a, "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "d", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "chatInfo", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatViewModelFactory implements ViewModelProvider.Factory {
    public final ChatInfo a;
    public final IChatAnalyticController b;
    public final IChatInteractor c;
    public final IKeyboardHider d;
    public final IErrorHandlerWithShow e;
    public final IThrowableWrapper f;
    public final IPreviousModuleInfo g;
    public final IProductAnalytic h;
    public final IProductNameDictionary i;
    public final List<IChatAnswerInitialize> j;

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatViewModelFactory(@NotNull ChatInfo chatInfo, @NotNull IChatAnalyticController iChatAnalyticController, @NotNull IChatInteractor iChatInteractor, @NotNull IKeyboardHider iKeyboardHider, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IProductAnalytic iProductAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull List<? extends IChatAnswerInitialize> list) {
        Intrinsics.checkParameterIsNotNull(chatInfo, "chatInfo");
        Intrinsics.checkParameterIsNotNull(iChatAnalyticController, "chatAnalyticController");
        Intrinsics.checkParameterIsNotNull(iChatInteractor, "chatInteractor");
        Intrinsics.checkParameterIsNotNull(iKeyboardHider, "keyboardHider");
        Intrinsics.checkParameterIsNotNull(iErrorHandlerWithShow, "errorHandler");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iProductAnalytic, "productAnalytic");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productNameDictionary");
        Intrinsics.checkParameterIsNotNull(list, "listChatInitialize");
        this.a = chatInfo;
        this.b = iChatAnalyticController;
        this.c = iChatInteractor;
        this.d = iKeyboardHider;
        this.e = iErrorHandlerWithShow;
        this.f = iThrowableWrapper;
        this.g = iPreviousModuleInfo;
        this.h = iProductAnalytic;
        this.i = iProductNameDictionary;
        this.j = list;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "modelClass");
        return new ChatViewModel(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }
}
