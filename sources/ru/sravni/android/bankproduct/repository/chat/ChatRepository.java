package ru.sravni.android.bankproduct.repository.chat;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.DataContainerKt;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.chat.IChatRepository;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerSuggestionDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ChatAnalyticInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentCardElementRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentCardRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationMessageParamsRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationMessageRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.NextConversationInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010F\u001a\u00020C¢\u0006\u0004\bN\u0010OJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JA\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c0\u001b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J#\u0010$\u001a\u00020\u00042\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001b0!H\u0002¢\u0006\u0004\b$\u0010%J-\u0010*\u001a\u00020\u00022\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001d2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\"H\u0002¢\u0006\u0004\b-\u0010.R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R2\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020403j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u000204`58\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u00106R*\u0010>\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010909088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR6\u0010M\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020K :*\n\u0012\u0004\u0012\u00020K\u0018\u00010\u001c0\u001c088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010;\u001a\u0004\bL\u0010=¨\u0006P"}, d2 = {"Lru/sravni/android/bankproduct/repository/chat/ChatRepository;", "Lru/sravni/android/bankproduct/domain/chat/IChatRepository;", "", "chatName", "", "startChat", "(Ljava/lang/String;)V", "conversationID", "continueChat", AnalyticFieldsName.conversationID, "restartChat", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answer", "sendAnswer", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", "", "currentOrder", "targetOrder", "rollBack", "(Ljava/lang/String;II)V", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)V", "cardId", "elementName", "userText", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerSuggestionDomain;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lkotlin/Function0;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "webClientAction", "c", "(Lkotlin/jvm/functions/Function0;)V", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "contentElements", "messageOrderId", "id", AuthSource.BOOKING_ORDER, "(Ljava/util/List;ILjava/lang/String;)Ljava/lang/String;", "conversationRepo", AuthSource.SEND_ABUSE, "(Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;)Ljava/lang/String;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "f", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Ljava/util/LinkedHashMap;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "lastChatMessages", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "kotlin.jvm.PlatformType", "Lio/reactivex/subjects/PublishSubject;", "getAnalyticsInfoChannel", "()Lio/reactivex/subjects/PublishSubject;", "analyticsInfoChannel", "Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;", "e", "Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;", "webClient", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", a2.g.r.g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lio/reactivex/disposables/CompositeDisposable;", "d", "Lio/reactivex/disposables/CompositeDisposable;", "subscription", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationDomain;", "getConversationChannel", "conversationChannel", "<init>", "(Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatRepository implements IChatRepository {
    @NotNull
    public final PublishSubject<DataContainer<ConversationDomain>> a;
    @NotNull
    public final PublishSubject<ChatAnalyticInfoDomain> b;
    public LinkedHashMap<Integer, ConversationMessageRepo> c = new LinkedHashMap<>();
    public CompositeDisposable d = new CompositeDisposable();
    public final IChatWebClient e;
    public final IErrorLogger f;
    public final IThrowableWrapper g;

    public static final class a extends Lambda implements Function0<Observable<ConversationRepo>> {
        public final /* synthetic */ ChatRepository a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChatRepository chatRepository, String str) {
            super(0);
            this.a = chatRepository;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<ConversationRepo> invoke() {
            return this.a.e.continueChat(this.b);
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            List<T> list = (List) obj;
            Intrinsics.checkParameterIsNotNull(list, "it");
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(t.toAnswerSuggestionDomain());
            }
            return DataContainerKt.toDataContainer(arrayList);
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends DataContainer<? extends List<? extends AnswerSuggestionDomain>>>> {
        public final /* synthetic */ ChatRepository a;

        public c(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends DataContainer<? extends List<? extends AnswerSuggestionDomain>>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "error");
            return Observable.just(new DataContainer(null, this.a.g.wrap(th2)));
        }
    }

    public static final class d<T> implements Consumer<ConversationRepo> {
        public final /* synthetic */ ChatRepository a;

        public d(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ConversationRepo conversationRepo) {
            ConversationRepo conversationRepo2 = conversationRepo;
            ChatRepository chatRepository = this.a;
            Intrinsics.checkExpressionValueIsNotNull(conversationRepo2, "it");
            ChatRepository.access$checkAnalyticsInfo(chatRepository, conversationRepo2);
            this.a.getConversationChannel().onNext(DataContainerKt.toDataContainer(ChatRepository.access$convertToConversationDomainAndUpdate(this.a, conversationRepo2)));
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatRepository a;

        public e(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getConversationChannel().onNext(new DataContainer<>(null, this.a.g.wrap(th)));
        }
    }

    public static final class f extends Lambda implements Function0<Observable<ConversationRepo>> {
        public final /* synthetic */ ChatRepository a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ChatRepository chatRepository, String str) {
            super(0);
            this.a = chatRepository;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<ConversationRepo> invoke() {
            return this.a.e.restartChat(this.b);
        }
    }

    public static final class g<T> implements Consumer<ConversationRepo> {
        public final /* synthetic */ ChatRepository a;

        public g(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ConversationRepo conversationRepo) {
            ConversationRepo conversationRepo2 = conversationRepo;
            ChatRepository chatRepository = this.a;
            Intrinsics.checkExpressionValueIsNotNull(conversationRepo2, "it");
            ChatRepository.access$checkAnalyticsInfo(chatRepository, conversationRepo2);
            this.a.getConversationChannel().onNext(DataContainerKt.toDataContainer(ChatRepository.access$convertToConversationDomainAndUpdate(this.a, conversationRepo2)));
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatRepository a;

        public h(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getConversationChannel().onNext(new DataContainer<>(null, this.a.g.wrap(th)));
        }
    }

    public static final class i<T> implements Consumer<ConversationRepo> {
        public final /* synthetic */ ChatRepository a;

        public i(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ConversationRepo conversationRepo) {
            ConversationRepo conversationRepo2 = conversationRepo;
            ChatRepository chatRepository = this.a;
            Intrinsics.checkExpressionValueIsNotNull(conversationRepo2, "it");
            ChatRepository.access$checkAnalyticsInfo(chatRepository, conversationRepo2);
            this.a.getConversationChannel().onNext(DataContainerKt.toDataContainer(ChatRepository.access$convertToConversationDomainAndUpdate(this.a, conversationRepo2)));
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatRepository a;

        public j(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getConversationChannel().onNext(new DataContainer<>(null, this.a.g.wrap(th)));
        }
    }

    public static final class k<T> implements Consumer<ConversationRepo> {
        public final /* synthetic */ ChatRepository a;

        public k(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ConversationRepo conversationRepo) {
            ConversationRepo conversationRepo2 = conversationRepo;
            ChatRepository chatRepository = this.a;
            Intrinsics.checkExpressionValueIsNotNull(conversationRepo2, "it");
            ChatRepository.access$checkAnalyticsInfo(chatRepository, conversationRepo2);
            this.a.getConversationChannel().onNext(DataContainerKt.toDataContainer(ChatRepository.access$convertToConversationDomainAndUpdate(this.a, conversationRepo2)));
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public final /* synthetic */ ChatRepository a;

        public l(ChatRepository chatRepository) {
            this.a = chatRepository;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getConversationChannel().onNext(new DataContainer<>(null, this.a.g.wrap(th)));
        }
    }

    public static final class m extends Lambda implements Function0<Observable<ConversationRepo>> {
        public final /* synthetic */ ChatRepository a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(ChatRepository chatRepository, String str) {
            super(0);
            this.a = chatRepository;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Observable<ConversationRepo> invoke() {
            return this.a.e.startChat(this.b);
        }
    }

    public ChatRepository(@NotNull IChatWebClient iChatWebClient, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iChatWebClient, "webClient");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.e = iChatWebClient;
        this.f = iErrorLogger;
        this.g = iThrowableWrapper;
        PublishSubject<DataContainer<ConversationDomain>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Da…er<ConversationDomain>>()");
        this.a = create;
        PublishSubject<ChatAnalyticInfoDomain> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<ChatAnalyticInfoDomain>()");
        this.b = create2;
    }

    public static final void access$checkAnalyticsInfo(ChatRepository chatRepository, ConversationRepo conversationRepo) {
        ConversationMessageParamsRepo.AnalyticsInfoRepo analyticsInfo;
        Objects.requireNonNull(chatRepository);
        ConversationMessageParamsRepo messageParams = ((ConversationMessageRepo) CollectionsKt___CollectionsKt.last((List<? extends Object>) conversationRepo.getDiffMessages())).getMessageParams();
        if (messageParams != null && (analyticsInfo = messageParams.getAnalyticsInfo()) != null) {
            chatRepository.getAnalyticsInfoChannel().onNext(analyticsInfo.toChatAnalyticInfoDomain());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:246:0x028b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.ArrayList] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x04ca A[Catch:{ all -> 0x04d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x050a  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x054a  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x05c2  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x05f4  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0623  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x062c  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x06cf  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x06d2  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x06f5  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x06fc  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain access$convertToConversationDomainAndUpdate(ru.sravni.android.bankproduct.repository.chat.ChatRepository r39, ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo r40) {
        /*
        // Method dump skipped, instructions count: 1814
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.repository.chat.ChatRepository.access$convertToConversationDomainAndUpdate(ru.sravni.android.bankproduct.repository.chat.ChatRepository, ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo):ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain");
    }

    public final String a(ConversationRepo conversationRepo) {
        List<ContentCardElementRepo> contentElements;
        ConversationMessageRepo conversationMessageRepo = (ConversationMessageRepo) CollectionsKt___CollectionsKt.last((List<? extends Object>) conversationRepo.getDiffMessages());
        ContentCardRepo contentCard = conversationMessageRepo.getContentCard();
        String str = null;
        ContentCardElementRepo contentCardElementRepo = (contentCard == null || (contentElements = contentCard.getContentElements()) == null) ? null : (ContentCardElementRepo) CollectionsKt___CollectionsKt.first((List<? extends Object>) contentElements);
        if (contentCardElementRepo != null) {
            str = contentCardElementRepo.getName();
        }
        if (str != null) {
            return str;
        }
        this.f.logError(MessagePriority.WARN, this.g.wrap(new NullNameInContentCard(conversationMessageRepo.getMessageOrderId(), conversationRepo.getId())));
        return "stubRepoNameNull";
    }

    public final String b(List<ContentCardElementRepo> list, int i2, String str) {
        for (T t : list) {
            if (Intrinsics.areEqual(t.getName(), "savedSearch")) {
                String text = t.getText();
                if (text != null) {
                    return text;
                }
                this.f.logError(MessagePriority.ERROR, this.g.wrap(new NullSavedSearchInContentCard(i2, str)));
                return "";
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final void c(Function0<? extends Observable<ConversationRepo>> function0) {
        this.d.dispose();
        this.d = new CompositeDisposable();
        this.c.clear();
        this.d.addAll(((Observable) function0.invoke()).subscribeOn(Schedulers.io()).subscribe(new d(this), new e(this)));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void continueChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        c(new a(this, str));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    @NotNull
    public Observable<DataContainer<List<AnswerSuggestionDomain>>> getSuggestion(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, AnalyticFieldsName.conversationID, str2, "elementName", str3, "userText");
        Observable<R> onErrorResumeNext = this.e.getSuggestion(str, i2, str2, str3).map(b.a).onErrorResumeNext(new c(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "webClient\n            .g…ap(error)))\n            }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void restartChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        c(new f(this, str));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void restoreChat(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(map, "fields");
        this.d.addAll(this.e.restoreChat(str, map).subscribeOn(Schedulers.io()).subscribe(new g(this), new h(this)));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void rollBack(@NotNull String str, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        this.d.addAll(this.e.rollBack(str, i2, i3).subscribeOn(Schedulers.io()).subscribe(new i(this), new j(this)));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void sendAnswer(@NotNull AnswerInfoDomain answerInfoDomain) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answer");
        this.d.addAll(this.e.next(new NextConversationInfoRepo(answerInfoDomain)).subscribeOn(Schedulers.io()).subscribe(new k(this), new l(this)));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    public void startChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        c(new m(this, str));
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    @NotNull
    public PublishSubject<ChatAnalyticInfoDomain> getAnalyticsInfoChannel() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatRepository
    @NotNull
    public PublishSubject<DataContainer<ConversationDomain>> getConversationChannel() {
        return this.a;
    }
}
