package ru.sravni.android.bankproduct.presentation.chat.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.product.IProductAnalytic;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.chat.IChatInteractor;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerCardTypeDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationMessageDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.IContentCardDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.SenderTypeDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.card.FinishedContentCardDomain;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandlerWithShow;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ChatViewCard;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageContainer;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.RequestStateEnum;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageEnum;
import ru.sravni.android.bankproduct.presentation.chat.adapter.message.ViewHolderMessageStatusEnum;
import ru.sravni.android.bankproduct.presentation.chat.controller.IChatAnalyticController;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001lB]\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010b\u001a\u00020_\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010H\u001a\u00020E\u0012\u0006\u0010i\u001a\u00020f\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\bj\u0010kJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\tR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00101\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00109\u001a\b\u0012\u0004\u0012\u0002060&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010)\u001a\u0004\b8\u0010+R\u0016\u0010<\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010D\u001a\b\u0012\u0004\u0012\u00020A0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bB\u0010)\u001a\u0004\bC\u0010+R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0&8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010)\u001a\u0004\bY\u0010+R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006m"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatViewModel;", "", "targetOrder", "", "d", "(I)V", "e", "()V", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answer", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;", "answerSendStatus", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "c", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ViewHolderMessageStatusEnum;)Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "restartChat", "nextCard", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "chatViewCard", "itemClicked", "(Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;)V", "waitUserAnswer", "onCleared", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "botPrintDelaySubscription", "subscriptionUserAnswer", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "u", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/IChatAnswerInitialize;", "x", "Ljava/util/List;", "listChatInitialize", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "getRestartChatActive", "()Landroidx/lifecycle/MutableLiveData;", "restartChatActive", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "r", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "subscriptionMessage", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/ChatViewModel$a;", "n", "Lru/sravni/android/bankproduct/presentation/chat/viewmodel/ChatViewModel$a;", "currentConversationInfo", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerCardTypeDomain;", g.a, "getTypeAnswer", "typeAnswer", "j", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/ChatViewCard;", "firstWaitingCard", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", VKApiConst.Q, "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "chatInteractor", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageContainer;", "f", "getMessagesContainer", "messagesContainer", "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;", "productAnalytic", "k", "Lru/sravni/android/bankproduct/presentation/chat/adapter/message/MessageContainer;", "startMessageContainer", "Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;", "p", "Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;", "chatAnalyticController", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "t", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Integer;", "activeViewCardId", "", "h", "getTitleChat", "titleChat", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "o", "Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;", "chatInfo", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "s", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;", "errorHandler", "l", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "lastAnswer", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "w", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productNameDictionary", "<init>", "(Lru/sravni/android/bankproduct/presentation/chat/entity/ChatInfo;Lru/sravni/android/bankproduct/presentation/chat/controller/IChatAnalyticController;Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandlerWithShow;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/product/IProductAnalytic;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Ljava/util/List;)V", AuthSource.SEND_ABUSE, "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatViewModel extends ViewModel implements IChatViewModel {
    public Disposable c;
    public Disposable d;
    public Disposable e;
    @NotNull
    public final MutableLiveData<MessageContainer> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<AnswerCardTypeDomain> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Boolean> i = new MutableLiveData<>();
    public final ChatViewCard j;
    public final MessageContainer k;
    public AnswerInfoDomain l;
    public Integer m;
    public a n;
    public final ChatInfo o;
    public final IChatAnalyticController p;
    public final IChatInteractor q;
    public final IKeyboardHider r;
    public final IErrorHandlerWithShow s;
    public final IThrowableWrapper t;
    public final IPreviousModuleInfo u;
    public final IProductAnalytic v;
    public final IProductNameDictionary w;
    public final List<IChatAnswerInitialize> x;

    public static final class a {
        @NotNull
        public final String a;
        public final int b;

        public a(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
            this.a = str;
            this.b = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            String str = this.a;
            return ((str != null ? str.hashCode() : 0) * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ConversationInfo(conversationId=");
            L.append(this.a);
            L.append(", lastSravniMessageOrder=");
            return a2.b.a.a.a.j(L, this.b, ")");
        }
    }

    public static final class b<T> implements Consumer<DataContainer<? extends ConversationDomain>> {
        public final /* synthetic */ ChatViewModel a;

        public b(ChatViewModel chatViewModel) {
            this.a = chatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DataContainer<? extends ConversationDomain> dataContainer) {
            DataContainer<? extends ConversationDomain> dataContainer2 = dataContainer;
            MessageContainer messageContainer = null;
            if (dataContainer2.getValue() != null) {
                this.a.getTypeAnswer().setValue(AnswerCardTypeDomain.HIDE);
                ConversationDomain conversationDomain = (ConversationDomain) dataContainer2.getValue();
                ChatViewModel.access$setCurrentConversationInfo(this.a, conversationDomain);
                ChatViewModel.access$initAnswerViewModel(this.a, conversationDomain.getId(), conversationDomain.getContentCard());
                if (conversationDomain.getContentCard() instanceof FinishedContentCardDomain) {
                    this.a.getRestartChatActive().setValue(Boolean.FALSE);
                }
                IContentCardDomain contentCard = conversationDomain.getContentCard();
                if ((contentCard != null ? contentCard.getType() : null) == AnswerCardTypeDomain.EMPTY) {
                    ChatViewModel.access$sendEmptyAnswer(this.a, new AnswerInfoDomain(conversationDomain.getContentCard().getOrderId(), conversationDomain.getId(), null, null, null, 28, null));
                } else {
                    MessageContainer access$countNewMessageContainer = ChatViewModel.access$countNewMessageContainer(this.a, conversationDomain);
                    this.a.getMessagesContainer().setValue(access$countNewMessageContainer);
                    ChatViewCard chatViewCard = (ChatViewCard) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) access$countNewMessageContainer.getChatDiff().getAddedToEnd());
                    if ((chatViewCard != null ? chatViewCard.getStatus() : null) == ViewHolderMessageStatusEnum.WAITING && chatViewCard.getType() == ViewHolderMessageEnum.SRAVNI) {
                        this.a.e = Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a7.c.a.a.o.c.c.a(this, access$countNewMessageContainer, chatViewCard, conversationDomain));
                    } else {
                        MutableLiveData<AnswerCardTypeDomain> typeAnswer = this.a.getTypeAnswer();
                        IContentCardDomain contentCard2 = conversationDomain.getContentCard();
                        typeAnswer.setValue(contentCard2 != null ? contentCard2.getType() : null);
                    }
                }
            }
            if (dataContainer2.getError() != null) {
                if (this.a.m != null) {
                    MessageContainer value = this.a.getMessagesContainer().getValue();
                    ChatViewCard findChatViewCrad = value != null ? value.findChatViewCrad(this.a.m) : null;
                    MutableLiveData<MessageContainer> messagesContainer = this.a.getMessagesContainer();
                    if (value != null) {
                        if (findChatViewCrad == null) {
                            Intrinsics.throwNpe();
                        }
                        messageContainer = value.formContainer(ChatViewCard.copy$default(findChatViewCrad, null, 0, null, null, ViewHolderMessageStatusEnum.ERROR, null, false, null, 239, null));
                    }
                    messagesContainer.setValue(messageContainer);
                }
                ChatViewModel.access$failAction(this.a, dataContainer2.getError());
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatViewModel a;

        public c(ChatViewModel chatViewModel) {
            this.a = chatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ChatViewModel.access$failAction(this.a, th);
        }
    }

    public static final class d<T> implements Consumer<AnswerInfoDomain> {
        public final /* synthetic */ ChatViewModel a;

        public d(ChatViewModel chatViewModel) {
            this.a = chatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(AnswerInfoDomain answerInfoDomain) {
            AnswerInfoDomain answerInfoDomain2 = answerInfoDomain;
            ChatViewModel chatViewModel = this.a;
            Intrinsics.checkExpressionValueIsNotNull(answerInfoDomain2, "it");
            chatViewModel.nextCard(answerInfoDomain2);
            Disposable disposable = this.a.d;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatViewModel a;

        public e(ChatViewModel chatViewModel) {
            this.a = chatViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            ChatViewModel.access$failAction(this.a, th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r32v0, resolved type: java.util.List<? extends ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatAnswerInitialize> */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatViewModel(@NotNull ChatInfo chatInfo, @NotNull IChatAnalyticController iChatAnalyticController, @NotNull IChatInteractor iChatInteractor, @NotNull IKeyboardHider iKeyboardHider, @NotNull IErrorHandlerWithShow iErrorHandlerWithShow, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IProductAnalytic iProductAnalytic, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull List<? extends IChatAnswerInitialize> list) {
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
        this.o = chatInfo;
        this.p = iChatAnalyticController;
        this.q = iChatInteractor;
        this.r = iKeyboardHider;
        this.s = iErrorHandlerWithShow;
        this.t = iThrowableWrapper;
        this.u = iPreviousModuleInfo;
        this.v = iProductAnalytic;
        this.w = iProductNameDictionary;
        this.x = list;
        ChatViewCard chatViewCard = new ChatViewCard(ViewHolderMessageEnum.SRAVNI, -1, null, CollectionsKt__CollectionsKt.emptyList(), ViewHolderMessageStatusEnum.WAITING, null, false, null, 224, null);
        this.j = chatViewCard;
        boolean z = false;
        MessageContainer messageContainer = new MessageContainer(CollectionsKt__CollectionsKt.listOf((Object[]) new ChatViewCard[]{new ChatViewCard(ViewHolderMessageEnum.BOT_FACE, -2, null, CollectionsKt__CollectionsKt.emptyList(), ViewHolderMessageStatusEnum.SUCCESS, null, false, null, 224, null), chatViewCard}), null, 2, null);
        this.k = messageContainer;
        this.n = null;
        getRestartChatActive().setValue(Boolean.FALSE);
        getMessagesContainer().setValue(messageContainer);
        iProductAnalytic.sendOpenEvent(iPreviousModuleInfo.getPreviousModuleName(), ((ProductDictionaryInfoDomain) iProductNameDictionary.get(chatInfo.getChatName())).getAnalyticProductName(), chatInfo.getDraft(), chatInfo.isPush());
        e();
        iChatAnalyticController.subscribeAnalyticInfoChannel();
        getTitleChat().setValue(chatInfo.getTitle());
        String conversationID = chatInfo.getConversationID();
        if ((conversationID == null || conversationID.length() == 0) ? true : z) {
            iChatInteractor.startChat(chatInfo.getChatName());
        } else if (chatInfo.getRequestParams() != null) {
            iChatInteractor.restoreChat(chatInfo.getConversationID(), chatInfo.getRequestParams());
        } else {
            iChatInteractor.continueChat(chatInfo.getConversationID());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x01fe */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageContainer access$countNewMessageContainer(ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModel r22, ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain r23) {
        /*
        // Method dump skipped, instructions count: 525
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModel.access$countNewMessageContainer(ru.sravni.android.bankproduct.presentation.chat.viewmodel.ChatViewModel, ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain):ru.sravni.android.bankproduct.presentation.chat.adapter.message.MessageContainer");
    }

    public static final void access$failAction(ChatViewModel chatViewModel, Throwable th) {
        if (chatViewModel.n == null) {
            chatViewModel.v.sendFailEvent(BaseAnalyticKt.ANALYTIC_FAIL_SERVER, chatViewModel.u.getPreviousModuleName(), ((ProductDictionaryInfoDomain) chatViewModel.w.get(chatViewModel.o.getChatName())).getAnalyticProductName());
        }
        chatViewModel.s.handleError(chatViewModel.t.wrap(th));
    }

    public static final void access$initAnswerViewModel(ChatViewModel chatViewModel, String str, IContentCardDomain iContentCardDomain) {
        Iterator<T> it = chatViewModel.x.iterator();
        while (it.hasNext()) {
            it.next().init(str, iContentCardDomain);
        }
    }

    public static final void access$sendEmptyAnswer(ChatViewModel chatViewModel, AnswerInfoDomain answerInfoDomain) {
        chatViewModel.l = answerInfoDomain;
        chatViewModel.q.sendAnswer(answerInfoDomain);
        chatViewModel.getTypeAnswer().setValue(AnswerCardTypeDomain.HIDE);
        chatViewModel.r.hideKeyboard();
    }

    public static final void access$setCurrentConversationInfo(ChatViewModel chatViewModel, ConversationDomain conversationDomain) {
        Integer num;
        ConversationMessageDomain conversationMessageDomain;
        boolean z;
        Objects.requireNonNull(chatViewModel);
        String id = conversationDomain.getId();
        List<ConversationMessageDomain> messages = conversationDomain.getMessages();
        ListIterator<ConversationMessageDomain> listIterator = messages.listIterator(messages.size());
        while (true) {
            num = null;
            if (!listIterator.hasPrevious()) {
                conversationMessageDomain = null;
                break;
            }
            conversationMessageDomain = listIterator.previous();
            if (conversationMessageDomain.getSender() == SenderTypeDomain.SRAVNI) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ConversationMessageDomain conversationMessageDomain2 = conversationMessageDomain;
        if (conversationMessageDomain2 != null) {
            num = Integer.valueOf(conversationMessageDomain2.getMessageOrderId());
        }
        if (num == null) {
            chatViewModel.s.handleError(chatViewModel.t.wrap(new NoMessagesFromSravniInChatWarn()));
            num = -1;
        }
        chatViewModel.n = new a(id, num.intValue());
        chatViewModel.getRestartChatActive().setValue(Boolean.TRUE);
    }

    public final ChatViewCard c(AnswerInfoDomain answerInfoDomain, ViewHolderMessageStatusEnum viewHolderMessageStatusEnum) {
        return new ChatViewCard(answerInfoDomain.getAnswerText() != null ? ViewHolderMessageEnum.USER : ViewHolderMessageEnum.SRAVNI, answerInfoDomain.getCardOrderId() + 1, answerInfoDomain.getAnswerText(), CollectionsKt__CollectionsKt.emptyList(), viewHolderMessageStatusEnum, RequestStateEnum.ANSWER, false, null, 192, null);
    }

    public final void d(int i2) {
        a aVar = this.n;
        if (aVar != null) {
            this.q.rollBack(aVar.a, aVar.b, i2 - 1);
            getTypeAnswer().setValue(AnswerCardTypeDomain.HIDE);
            MessageContainer value = getMessagesContainer().getValue();
            MessageContainer messageContainer = null;
            ChatViewCard findChatViewCrad = value != null ? value.findChatViewCrad(Integer.valueOf(i2)) : null;
            if (findChatViewCrad != null) {
                MutableLiveData<MessageContainer> messagesContainer = getMessagesContainer();
                MessageContainer value2 = getMessagesContainer().getValue();
                if (value2 != null) {
                    messageContainer = value2.formContainer(ChatViewCard.copy$default(findChatViewCrad, null, 0, null, null, ViewHolderMessageStatusEnum.WAITING, RequestStateEnum.ROLLBACK, false, null, 207, null));
                }
                messagesContainer.setValue(messageContainer);
                return;
            }
            return;
        }
        this.s.handleError(this.t.wrap(new TryEditWithNullConversationInfoError()));
    }

    public final void e() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.q.getConversationChannel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatMessageClickListener
    public void itemClicked(@NotNull ChatViewCard chatViewCard) {
        Intrinsics.checkParameterIsNotNull(chatViewCard, "chatViewCard");
        this.r.hideKeyboard();
        if (chatViewCard.getStatus() == ViewHolderMessageStatusEnum.ERROR) {
            if (chatViewCard.getRequestState() == RequestStateEnum.ANSWER) {
                AnswerInfoDomain answerInfoDomain = this.l;
                if (answerInfoDomain == null) {
                    this.s.handleError(this.t.wrap(new TryResentNullAnswerError()));
                } else {
                    this.q.sendAnswer(answerInfoDomain);
                    ChatViewCard c2 = c(answerInfoDomain, ViewHolderMessageStatusEnum.WAITING);
                    MutableLiveData<MessageContainer> messagesContainer = getMessagesContainer();
                    MessageContainer value = getMessagesContainer().getValue();
                    messagesContainer.setValue(value != null ? value.formContainer(c2) : null);
                }
                this.m = Integer.valueOf(chatViewCard.getOrderId());
            }
            if (chatViewCard.getRequestState() == RequestStateEnum.ROLLBACK) {
                d(chatViewCard.getOrderId());
                this.m = Integer.valueOf(chatViewCard.getOrderId());
            }
        }
        if (chatViewCard.getStatus() == ViewHolderMessageStatusEnum.ALLOW_EDIT) {
            d(chatViewCard.getOrderId());
            this.m = Integer.valueOf(chatViewCard.getOrderId());
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard
    public void nextCard(@NotNull AnswerInfoDomain answerInfoDomain) {
        Map map;
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answer");
        String answerText = answerInfoDomain.getAnswerText();
        MessageContainer messageContainer = null;
        String obj = answerText != null ? StringsKt__StringsKt.trim(answerText).toString() : null;
        Map<String, String> fields = answerInfoDomain.getFields();
        if (fields != null) {
            ArrayList arrayList = new ArrayList(fields.size());
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value != null) {
                    arrayList.add(TuplesKt.to(key, StringsKt__StringsKt.trim(value).toString()));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            map = r.toMap(arrayList);
        } else {
            map = null;
        }
        AnswerInfoDomain copy$default = AnswerInfoDomain.copy$default(answerInfoDomain, 0, null, obj, map, null, 19, null);
        this.l = copy$default;
        this.q.sendAnswer(copy$default);
        MessageContainer value2 = getMessagesContainer().getValue();
        ChatViewCard c2 = c(copy$default, ViewHolderMessageStatusEnum.WAITING);
        this.m = Integer.valueOf(c2.getOrderId());
        MutableLiveData<MessageContainer> messagesContainer = getMessagesContainer();
        if (value2 != null) {
            messageContainer = value2.formContainer(c2);
        }
        messagesContainer.setValue(messageContainer);
        getTypeAnswer().setValue(AnswerCardTypeDomain.HIDE);
        this.r.hideKeyboard();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.p.clearAnalyticInfoSubscribe();
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel
    public void restartChat() {
        a aVar = this.n;
        String str = aVar != null ? aVar.a : null;
        if (str != null) {
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            getMessagesContainer().setValue(this.k);
            e();
            this.p.subscribeAnalyticInfoChannel();
            getTypeAnswer().setValue(AnswerCardTypeDomain.HIDE);
            this.r.hideKeyboard();
            this.q.restartChat(str);
            this.n = null;
            getRestartChatActive().setValue(Boolean.FALSE);
            this.m = null;
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard
    public void waitUserAnswer() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = this.q.getUserAnswerChannel().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel
    @NotNull
    public MutableLiveData<MessageContainer> getMessagesContainer() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel
    @NotNull
    public MutableLiveData<Boolean> getRestartChatActive() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel
    @NotNull
    public MutableLiveData<String> getTitleChat() {
        return this.h;
    }

    @Override // ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel
    @NotNull
    public MutableLiveData<AnswerCardTypeDomain> getTypeAnswer() {
        return this.g;
    }
}
