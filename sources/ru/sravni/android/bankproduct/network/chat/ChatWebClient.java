package ru.sravni.android.bankproduct.network.chat;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.network.chat.IChatApi;
import ru.sravni.android.bankproduct.network.chat.request.NextConversationRequest;
import ru.sravni.android.bankproduct.network.chat.request.RestoreChatRequest;
import ru.sravni.android.bankproduct.network.chat.request.RollbackRequest;
import ru.sravni.android.bankproduct.network.chat.request.StartConversationRequest;
import ru.sravni.android.bankproduct.network.chat.response.ConversationItemResponse;
import ru.sravni.android.bankproduct.network.chat.response.ConversationMessageResponseKt;
import ru.sravni.android.bankproduct.network.chat.response.SuggestResponse;
import ru.sravni.android.bankproduct.repository.chat.IChatWebClient;
import ru.sravni.android.bankproduct.repository.chat.entity.AnswerSuggestionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.NextConversationInfoRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b,\u0010-J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lru/sravni/android/bankproduct/network/chat/ChatWebClient;", "Lru/sravni/android/bankproduct/repository/chat/IChatWebClient;", "", "chatName", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "startChat", "(Ljava/lang/String;)Lio/reactivex/Observable;", "conversationID", "continueChat", AnalyticFieldsName.conversationID, "restartChat", "Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;", "nextInfoRepo", "next", "(Lru/sravni/android/bankproduct/repository/chat/entity/NextConversationInfoRepo;)Lio/reactivex/Observable;", "", "cardId", "elementName", "userText", "", "Lru/sravni/android/bankproduct/repository/chat/entity/AnswerSuggestionRepo;", "getSuggestion", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "currentOrder", "targetOrder", "rollBack", "(Ljava/lang/String;II)Lio/reactivex/Observable;", "", "fields", "restoreChat", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/network/chat/IChatApi;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/network/chat/IChatApi;", "api", "<init>", "(Lru/sravni/android/bankproduct/network/chat/IChatApi;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ChatWebClient implements IChatWebClient {
    public final IChatApi a;
    public final IThrowableWrapper b;
    public final ITokenRefresher c;

    public static final class a extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ChatWebClient chatWebClient, String str) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.continueChat(tokenData2.getAccess_token(), this.b);
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public static final b a = new b();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class c<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public c(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class d extends Lambda implements Function1<TokenData, Observable<SuggestResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChatWebClient chatWebClient, String str, int i, String str2, String str3) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
            this.c = i;
            this.d = str2;
            this.e = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<SuggestResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return IChatApi.DefaultImpls.getSuggestion$default(this.a.a, tokenData2.getAccess_token(), this.b, this.c, this.d, this.e, 0, 32, null);
        }
    }

    public static final class e<T, R> implements Function<T, R> {
        public static final e a = new e();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            SuggestResponse suggestResponse = (SuggestResponse) obj;
            Intrinsics.checkParameterIsNotNull(suggestResponse, "suggestResponse");
            List<SuggestResponse.SuggestItem> items = suggestResponse.getItems();
            if (items == null) {
                items = CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(items, 10));
            for (T t : items) {
                arrayList.add(new AnswerSuggestionRepo(t.getText(), t.getSubText(), t.getOptionalFields(), t.isComplete()));
            }
            return arrayList;
        }
    }

    public static final class f<T, R> implements Function<Throwable, ObservableSource<? extends List<? extends AnswerSuggestionRepo>>> {
        public final /* synthetic */ ChatWebClient a;

        public f(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends List<? extends AnswerSuggestionRepo>> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class g extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ NextConversationInfoRepo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ChatWebClient chatWebClient, NextConversationInfoRepo nextConversationInfoRepo) {
            super(1);
            this.a = chatWebClient;
            this.b = nextConversationInfoRepo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            IChatApi iChatApi = this.a.a;
            String access_token = tokenData2.getAccess_token();
            String conversationId = this.b.getConversationId();
            int cardId = this.b.getCardId();
            Map<String, String> fields = this.b.getFields();
            if (fields == null) {
                fields = t6.n.r.emptyMap();
            }
            String actionCode = this.b.getActionCode();
            String str = "";
            if (actionCode == null) {
                actionCode = str;
            }
            String text = this.b.getText();
            if (text != null) {
                str = text;
            }
            return iChatApi.sendAnswer(access_token, conversationId, new NextConversationRequest(cardId, fields, actionCode, str));
        }
    }

    public static final class h<T, R> implements Function<T, R> {
        public static final h a = new h();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class i<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public i(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class j extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ChatWebClient chatWebClient, String str) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.restartChat(tokenData2.getAccess_token(), this.b);
        }
    }

    public static final class k<T, R> implements Function<T, R> {
        public static final k a = new k();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class l<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public l(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class m extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(ChatWebClient chatWebClient, String str, Map map) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
            this.c = map;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.restoreChat(tokenData2.getAccess_token(), this.b, new RestoreChatRequest(this.c));
        }
    }

    public static final class n<T, R> implements Function<T, R> {
        public static final n a = new n();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class o<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public o(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class p extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(ChatWebClient chatWebClient, String str, int i, int i2) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
            this.c = i;
            this.d = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.rollbackChat(tokenData2.getAccess_token(), this.b, new RollbackRequest(this.c, this.d));
        }
    }

    public static final class q<T, R> implements Function<T, R> {
        public static final q a = new q();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class r<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public r(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public static final class s extends Lambda implements Function1<TokenData, Observable<ConversationItemResponse>> {
        public final /* synthetic */ ChatWebClient a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(ChatWebClient chatWebClient, String str) {
            super(1);
            this.a = chatWebClient;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ConversationItemResponse> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, "tokenData");
            return this.a.a.startChat(tokenData2.getAccess_token(), new StartConversationRequest(this.b));
        }
    }

    public static final class t<T, R> implements Function<T, R> {
        public static final t a = new t();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ConversationItemResponse conversationItemResponse = (ConversationItemResponse) obj;
            Intrinsics.checkParameterIsNotNull(conversationItemResponse, "it");
            return ConversationMessageResponseKt.toConversationRepo(conversationItemResponse.getItem());
        }
    }

    public static final class u<T, R> implements Function<Throwable, ObservableSource<? extends ConversationRepo>> {
        public final /* synthetic */ ChatWebClient a;

        public u(ChatWebClient chatWebClient) {
            this.a = chatWebClient;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ConversationRepo> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkParameterIsNotNull(th2, "it");
            return UtilFunctionsKt.typeObservable(this.a.b.wrap(th2));
        }
    }

    public ChatWebClient(@NotNull IChatApi iChatApi, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ITokenRefresher iTokenRefresher) {
        Intrinsics.checkParameterIsNotNull(iChatApi, "api");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        this.a = iChatApi;
        this.b = iThrowableWrapper;
        this.c = iTokenRefresher;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> continueChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Observable<ConversationRepo> onErrorResumeNext = this.c.sendAuthorizedOrUnauthorizedQuery(new a(this, str), this.a.continueChat(str)).map(b.a).onErrorResumeNext(new c(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<List<AnswerSuggestionRepo>> getSuggestion(@NotNull String str, int i2, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.a1(str, AnalyticFieldsName.conversationID, str2, "elementName", str3, "userText");
        Observable<List<AnswerSuggestionRepo>> onErrorResumeNext = this.c.sendAuthorizedOrUnauthorizedQuery(new d(this, str, i2, str2, str3), IChatApi.DefaultImpls.getSuggestion$default(this.a, str, i2, str2, str3, 0, 16, null)).map(e.a).onErrorResumeNext(new f(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> next(@NotNull NextConversationInfoRepo nextConversationInfoRepo) {
        Intrinsics.checkParameterIsNotNull(nextConversationInfoRepo, "nextInfoRepo");
        ITokenRefresher iTokenRefresher = this.c;
        g gVar = new g(this, nextConversationInfoRepo);
        IChatApi iChatApi = this.a;
        String conversationId = nextConversationInfoRepo.getConversationId();
        int cardId = nextConversationInfoRepo.getCardId();
        Map<String, String> fields = nextConversationInfoRepo.getFields();
        if (fields == null) {
            fields = t6.n.r.emptyMap();
        }
        String actionCode = nextConversationInfoRepo.getActionCode();
        String str = "";
        if (actionCode == null) {
            actionCode = str;
        }
        String text = nextConversationInfoRepo.getText();
        if (text != null) {
            str = text;
        }
        Observable<ConversationRepo> onErrorResumeNext = iTokenRefresher.sendAuthorizedOrUnauthorizedQuery(gVar, iChatApi.sendAnswer(conversationId, new NextConversationRequest(cardId, fields, actionCode, str))).map(h.a).onErrorResumeNext(new i(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> restartChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Observable<ConversationRepo> onErrorResumeNext = this.c.sendAuthorizedOrUnauthorizedQuery(new j(this, str), this.a.restartChat(str)).map(k.a).onErrorResumeNext(new l(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> restoreChat(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(map, "fields");
        Observable<ConversationRepo> onErrorResumeNext = this.c.wrapWithTokenRefresh(new m(this, str, map)).map(n.a).onErrorResumeNext(new o(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.wrapWithT…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> rollBack(@NotNull String str, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Observable<ConversationRepo> onErrorResumeNext = this.c.sendAuthorizedOrUnauthorizedQuery(new p(this, str, i2, i3), this.a.rollbackChat(str, new RollbackRequest(i2, i3))).map(q.a).onErrorResumeNext(new r(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }

    @Override // ru.sravni.android.bankproduct.repository.chat.IChatWebClient
    @NotNull
    public Observable<ConversationRepo> startChat(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "chatName");
        Observable<ConversationRepo> onErrorResumeNext = this.c.sendAuthorizedOrUnauthorizedQuery(new s(this, str), this.a.startChat(new StartConversationRequest(str))).map(t.a).onErrorResumeNext(new u(this));
        Intrinsics.checkExpressionValueIsNotNull(onErrorResumeNext, "tokenRefresher.sendAutho…ap(it).typeObservable() }");
        return onErrorResumeNext;
    }
}
