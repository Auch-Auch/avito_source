package ru.sravni.android.bankproduct.mock.webclient;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.IAuthAccessData;
import ru.sravni.android.bankproduct.repository.chat.IChatWebClient;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.NextConversationInfoRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b4\u00105J-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J;\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/ChatWebClientStub;", "Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;", "", AnalyticFieldsName.conversationID, "", "currentOrder", "targetOrder", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "rollBack", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "conversationID", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;", "nextInfoRepo", "next", "(Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;)Lio/reactivex/Observable;", "chatName", "startChat", "(Ljava/lang/String;)Lio/reactivex/Observable;", "continueChat", "restartChat", "cardId", "elementName", "userText", "", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/lang/String;", "", AuthSource.BOOKING_ORDER, "J", "delay", "I", "count", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "d", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;", "e", "Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;", "authAccessData", "Lru/sravni/android/bankproduct/mock/webclient/IConversationRepoMockController;", "c", "Lru/sravni/android/bankproduct/mock/webclient/IConversationRepoMockController;", "mockController", "<init>", "(JLru/sravni/android/bankproduct/mock/webclient/IConversationRepoMockController;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatWebClientStub implements IChatWebClient {
    public int a;
    public final long b;
    public final IConversationRepoMockController c;
    public final ITokenRefresher d;
    public final IAuthAccessData e;

    public static final class a<T, R> implements Function<T, ObservableSource<? extends R>> {
        public final /* synthetic */ Observable a;

        public a(Observable observable) {
            this.a = observable;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a;
        }
    }

    public static final class b<T, R> implements Function<T, ObservableSource<? extends R>> {
        public final /* synthetic */ Observable a;

        public b(Observable observable) {
            this.a = observable;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            Intrinsics.checkParameterIsNotNull((Unit) obj, "it");
            return this.a;
        }
    }

    public static final class c extends Lambda implements Function1<TokenData, Observable<ConversationRepo>> {
        public final /* synthetic */ ChatWebClientStub a;
        public final /* synthetic */ Observable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ChatWebClientStub chatWebClientStub, Observable observable) {
            super(1);
            this.a = chatWebClientStub;
            this.b = observable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            IAuthAccessData iAuthAccessData = this.a.e;
            Observable observable = this.b;
            Intrinsics.checkExpressionValueIsNotNull(observable, "startChatResponse");
            return iAuthAccessData.getAccessedData(observable, tokenData2.getAccess_token());
        }
    }

    public ChatWebClientStub(long j, @NotNull IConversationRepoMockController iConversationRepoMockController, @NotNull ITokenRefresher iTokenRefresher, @NotNull IAuthAccessData iAuthAccessData) {
        Intrinsics.checkParameterIsNotNull(iConversationRepoMockController, "mockController");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        Intrinsics.checkParameterIsNotNull(iAuthAccessData, "authAccessData");
        this.b = j;
        this.c = iConversationRepoMockController;
        this.d = iTokenRefresher;
        this.e = iAuthAccessData;
    }

    public final String a(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -2120005519) {
            str.equals("chatCredit");
            return PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT;
        } else if (hashCode == -191728030 && str.equals("chatInsurance")) {
            return "osago";
        } else {
            return PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_CREDIT;
        }
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> continueChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        return startChat(a(str));
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<List<AnswerSuggestionRepo>> getSuggestion(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, AnalyticFieldsName.conversationID, str2, "elementName", str3, "userText");
        Observable<List<AnswerSuggestionRepo>> delay = Observable.just(this.c.getSuggestion(0)).delay(this.b, TimeUnit.SECONDS);
        Intrinsics.checkExpressionValueIsNotNull(delay, "Observable.just(mockCont…(delay, TimeUnit.SECONDS)");
        return delay;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> next(@NotNull NextConversationInfoRepo nextConversationInfoRepo) {
        Observable observable;
        Intrinsics.checkParameterIsNotNull(nextConversationInfoRepo, "nextInfoRepo");
        int i = this.a + 1;
        this.a = i;
        if (i < 300) {
            observable = Observable.just(this.c.getMock(a(nextConversationInfoRepo.getConversationId()), this.a));
        } else {
            observable = Observable.error(new Throwable("test"));
        }
        Intrinsics.checkExpressionValueIsNotNull(observable, "if (count < 300)\n       …nRepo>(Throwable(\"test\"))");
        Observable<ConversationRepo> flatMap = Observable.just(Unit.INSTANCE).delay(1500, TimeUnit.MILLISECONDS).flatMap(new a(observable));
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "Observable.just(Unit).de…versationRepoObservable }");
        return flatMap;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> restartChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        return startChat(a(str));
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> restoreChat(@NotNull String str, @NotNull Map<String, String> map) {
        Observable observable;
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(map, "fields");
        int i = this.a + 1;
        this.a = i;
        if (i % 5 != 0) {
            observable = Observable.just(this.c.getMock(a(str), this.a));
        } else {
            observable = Observable.error(new Throwable("test"));
        }
        Intrinsics.checkExpressionValueIsNotNull(observable, "if (count % 5 != 0) {\n  …owable(\"test\"))\n        }");
        Observable<ConversationRepo> flatMap = Observable.just(Unit.INSTANCE).delay(this.b, TimeUnit.MILLISECONDS).flatMap(new b(observable));
        Intrinsics.checkExpressionValueIsNotNull(flatMap, "Observable.just(Unit).de…versationRepoObservable }");
        return flatMap;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> rollBack(@NotNull String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Observable<ConversationRepo> error = Observable.error(new Throwable("test"));
        Intrinsics.checkExpressionValueIsNotNull(error, "Observable.error<Convers…nRepo>(Throwable(\"test\"))");
        return error;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> startChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        this.a = 0;
        return this.d.wrapWithTokenRefresh(new c(this, Observable.just(this.c.getMock(str, 0)).delay(this.b, TimeUnit.SECONDS)));
    }
}
