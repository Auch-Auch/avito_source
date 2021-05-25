package ru.sravni.android.bankproduct.presentation.chat.controller;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.chat.entity.ChatAnalyticInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/controller/ChatAnalyticController;", "Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;", "", "subscribeAnalyticInfoChannel", "()V", "clearAnalyticInfoSubscribe", "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", g.a, "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "productAnalytic", "Lio/reactivex/disposables/Disposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/Disposable;", "subscriptionConversation", AuthSource.SEND_ABUSE, "subscriptionAnalytics", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "d", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "chatInfo", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "f", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "", "c", "Ljava/lang/String;", "conversationID", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "e", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatAnalyticController implements IChatAnalyticController {
    public Disposable a;
    public Disposable b;
    public String c;
    public final ChatInfo d;
    public final IChatInteractor e;
    public final IPreviousModuleInfo f;
    public final IProductAnalytic g;

    public static final class a<T> implements Consumer<DataContainer<? extends ConversationDomain>> {
        public final /* synthetic */ ChatAnalyticController a;

        public a(ChatAnalyticController chatAnalyticController) {
            this.a = chatAnalyticController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends ConversationDomain> dataContainer) {
            DataContainer<? extends ConversationDomain> dataContainer2 = dataContainer;
            if (dataContainer2.getValue() != null) {
                this.a.c = ((ConversationDomain) dataContainer2.getValue()).getId();
            }
        }
    }

    public static final class b<T> implements Consumer<ChatAnalyticInfoDomain> {
        public final /* synthetic */ ChatAnalyticController a;

        public b(ChatAnalyticController chatAnalyticController) {
            this.a = chatAnalyticController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChatAnalyticInfoDomain chatAnalyticInfoDomain) {
            ChatAnalyticInfoDomain chatAnalyticInfoDomain2 = chatAnalyticInfoDomain;
            this.a.g.sendChatEvent(chatAnalyticInfoDomain2.getProductName(), chatAnalyticInfoDomain2.getStep(), this.a.c, this.a.d.isPush(), chatAnalyticInfoDomain2.isProlongation(), this.a.f.getPreviousModuleName());
        }
    }

    public ChatAnalyticController(@NotNull ChatInfo chatInfo, @NotNull IChatInteractor iChatInteractor, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IProductAnalytic iProductAnalytic) {
        Intrinsics.checkParameterIsNotNull(chatInfo, "chatInfo");
        Intrinsics.checkParameterIsNotNull(iChatInteractor, "chatInteractor");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iProductAnalytic, "productAnalytic");
        this.d = chatInfo;
        this.e = iChatInteractor;
        this.f = iPreviousModuleInfo;
        this.g = iProductAnalytic;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.controller.IChatAnalyticController
    public void clearAnalyticInfoSubscribe() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.a;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.controller.IChatAnalyticController
    public void subscribeAnalyticInfoChannel() {
        Disposable disposable = this.a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.d.getConversationID();
        this.b = this.e.getConversationChannel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        this.a = this.e.getAnalyticsInfoChannel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
    }
}
