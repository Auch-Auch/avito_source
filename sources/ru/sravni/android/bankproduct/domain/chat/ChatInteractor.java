package ru.sravni.android.bankproduct.domain.chat;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.AnswerSuggestionDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ChatAnalyticInfoDomain;
import ru.sravni.android.bankproduct.domain.chat.entity.ConversationDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010?\u001a\u00020<¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\u001c2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R6\u0010/\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020* +*\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001d0\u001d0)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010,\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00102R*\u00108\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\t0\t0)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u0010.R*\u0010;\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u000109090)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010,\u001a\u0004\b:\u0010.R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/ChatInteractor;", "Lru/sravni/android/bankproduct/domain/chat/IChatInteractor;", "", "chatName", "", "startChat", "(Ljava/lang/String;)V", "conversationID", "continueChat", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;", "answer", "setAnswerInfo", "(Lru/sravni/android/bankproduct/domain/chat/entity/AnswerInfoDomain;)V", AnalyticFieldsName.conversationID, "restartChat", "sendAnswer", "", "currentOrder", "targetOrder", "rollBack", "(Ljava/lang/String;II)V", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)V", "cardId", "elementName", "userText", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "", "Lru/sravni/android/bankproduct/domain/chat/entity/AnswerSuggestionDomain;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/chat/IChatRepository;", "f", "Lru/sravni/android/bankproduct/domain/chat/IChatRepository;", "chatRepository", "Lio/reactivex/subjects/PublishSubject;", "Lru/sravni/android/bankproduct/domain/chat/entity/ConversationDomain;", "kotlin.jvm.PlatformType", "Lio/reactivex/subjects/PublishSubject;", "getConversationChannel", "()Lio/reactivex/subjects/PublishSubject;", "conversationChannel", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "subscriptionAnalyticInfo", "d", "subscription", "c", "getUserAnswerChannel", "userAnswerChannel", "Lru/sravni/android/bankproduct/domain/chat/entity/ChatAnalyticInfoDomain;", "getAnalyticsInfoChannel", "analyticsInfoChannel", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", g.a, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "<init>", "(Lru/sravni/android/bankproduct/domain/chat/IChatRepository;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatInteractor implements IChatInteractor {
    @NotNull
    public final PublishSubject<DataContainer<ConversationDomain>> a;
    @NotNull
    public final PublishSubject<ChatAnalyticInfoDomain> b;
    @NotNull
    public final PublishSubject<AnswerInfoDomain> c;
    public Disposable d;
    public Disposable e;
    public final IChatRepository f;
    public final IThrowableWrapper g;

    public static final class a<T, R> implements Function<Throwable, ObservableSource<? extends DataContainer<? extends List<? extends AnswerSuggestionDomain>>>> {
        public final /* synthetic */ ChatInteractor a;

        public a(ChatInteractor chatInteractor) {
            this.a = chatInteractor;
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

    public static final class b<T> implements Consumer<ChatAnalyticInfoDomain> {
        public final /* synthetic */ ChatInteractor a;

        public b(ChatInteractor chatInteractor) {
            this.a = chatInteractor;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ChatAnalyticInfoDomain chatAnalyticInfoDomain) {
            this.a.getAnalyticsInfoChannel().onNext(chatAnalyticInfoDomain);
        }
    }

    public ChatInteractor(@NotNull IChatRepository iChatRepository, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iChatRepository, "chatRepository");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        this.f = iChatRepository;
        this.g = iThrowableWrapper;
        PublishSubject<DataContainer<ConversationDomain>> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Da…er<ConversationDomain>>()");
        this.a = create;
        PublishSubject<ChatAnalyticInfoDomain> create2 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create2, "PublishSubject.create<ChatAnalyticInfoDomain>()");
        this.b = create2;
        PublishSubject<AnswerInfoDomain> create3 = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create3, "PublishSubject.create<AnswerInfoDomain>()");
        this.c = create3;
    }

    public final void a() {
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = this.f.getAnalyticsInfoChannel().subscribe(new b(this));
    }

    public final void b() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = UtilFunctionsKt.makeSravniSubscription(this.f.getConversationChannel(), getConversationChannel(), this.g);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void continueChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        b();
        a();
        this.f.continueChat(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    @NotNull
    public Observable<DataContainer<List<AnswerSuggestionDomain>>> getSuggestion(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, AnalyticFieldsName.conversationID, str2, "elementName", str3, "userText");
        Observable<DataContainer<List<AnswerSuggestionDomain>>> onErrorResumeNext = this.f.getSuggestion(str, i, str2, str3).onErrorResumeNext(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "chatRepository.getSugges…          )\n            }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void restartChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        this.f.restartChat(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void restoreChat(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(map, "fields");
        b();
        a();
        this.f.restoreChat(str, map);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void rollBack(@NotNull String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        this.f.rollBack(str, i, i2);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void sendAnswer(@NotNull AnswerInfoDomain answerInfoDomain) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answer");
        this.f.sendAnswer(answerInfoDomain);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.ISelectUserAnswer
    public void setAnswerInfo(@NotNull AnswerInfoDomain answerInfoDomain) {
        Intrinsics.checkParameterIsNotNull(answerInfoDomain, "answer");
        getUserAnswerChannel().onNext(answerInfoDomain);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    public void startChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        b();
        a();
        this.f.startChat(str);
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    @NotNull
    public PublishSubject<ChatAnalyticInfoDomain> getAnalyticsInfoChannel() {
        return this.b;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    @NotNull
    public PublishSubject<DataContainer<ConversationDomain>> getConversationChannel() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.chat.IChatInteractor
    @NotNull
    public PublishSubject<AnswerInfoDomain> getUserAnswerChannel() {
        return this.c;
    }
}
