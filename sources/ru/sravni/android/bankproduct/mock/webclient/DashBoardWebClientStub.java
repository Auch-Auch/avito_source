package ru.sravni.android.bankproduct.mock.webclient;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.mock.auth.IAuthAccessData;
import ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponse;
import ru.sravni.android.bankproduct.network.dashboard.response.ChatProgressResponseKt;
import ru.sravni.android.bankproduct.network.dashboard.response.Draft;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationItem;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponse;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponseKt;
import ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.OfferCalculationElementRepo;
import ru.sravni.android.bankproduct.repository.token.ITokenRefresher;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStub;", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;", "Lio/reactivex/Observable;", "", "Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "getOfferCalculatedList", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/ChatProgressRepo;", "getChatProgress", "", AuthSource.SEND_ABUSE, "I", "getProgress", "()I", "setProgress", "(I)V", "progress", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "c", "Lru/sravni/android/bankproduct/repository/token/ITokenRefresher;", "tokenRefresher", "Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;", "d", "Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;", "authAccessData", "", AuthSource.BOOKING_ORDER, "J", "delay", "Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStubInfo;", "f", "Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStubInfo;", "dashBoardWebClientStubInfo", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "<init>", "(JLru/sravni/android/bankproduct/repository/token/ITokenRefresher;Lru/sravni/android/bankproduct/mock/auth/IAuthAccessData;Landroid/content/Context;Lru/sravni/android/bankproduct/mock/webclient/DashBoardWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardWebClientStub implements IDashBoardWebClient {
    public int a = 30;
    public final long b;
    public final ITokenRefresher c;
    public final IAuthAccessData d;
    public final Context e;
    public final DashBoardWebClientStubInfo f;

    public static final class a extends Lambda implements Function1<TokenData, Observable<ChatProgressRepo>> {
        public final /* synthetic */ DashBoardWebClientStub a;
        public final /* synthetic */ Observable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DashBoardWebClientStub dashBoardWebClientStub, Observable observable) {
            super(1);
            this.a = dashBoardWebClientStub;
            this.b = observable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<ChatProgressRepo> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            IAuthAccessData iAuthAccessData = this.a.d;
            Observable observable = this.b;
            Intrinsics.checkExpressionValueIsNotNull(observable, "requestObservable");
            return iAuthAccessData.getAccessedData(observable, tokenData2.getAccess_token());
        }
    }

    public static final class b extends Lambda implements Function1<TokenData, Observable<List<? extends OfferCalculationElementRepo>>> {
        public final /* synthetic */ DashBoardWebClientStub a;
        public final /* synthetic */ Observable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DashBoardWebClientStub dashBoardWebClientStub, Observable observable) {
            super(1);
            this.a = dashBoardWebClientStub;
            this.b = observable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Observable<List<? extends OfferCalculationElementRepo>> invoke(TokenData tokenData) {
            TokenData tokenData2 = tokenData;
            Intrinsics.checkParameterIsNotNull(tokenData2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
            IAuthAccessData iAuthAccessData = this.a.d;
            Observable observable = this.b;
            Intrinsics.checkExpressionValueIsNotNull(observable, "requestObservable");
            return iAuthAccessData.getAccessedData(observable, tokenData2.getAccess_token());
        }
    }

    public DashBoardWebClientStub(long j, @NotNull ITokenRefresher iTokenRefresher, @NotNull IAuthAccessData iAuthAccessData, @NotNull Context context, @NotNull DashBoardWebClientStubInfo dashBoardWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(iTokenRefresher, "tokenRefresher");
        Intrinsics.checkParameterIsNotNull(iAuthAccessData, "authAccessData");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dashBoardWebClientStubInfo, "dashBoardWebClientStubInfo");
        this.b = j;
        this.c = iTokenRefresher;
        this.d = iAuthAccessData;
        this.e = context;
        this.f = dashBoardWebClientStubInfo;
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient
    @NotNull
    public Observable<ChatProgressRepo> getChatProgress() {
        ChatProgressResponse chatProgressResponse = (ChatProgressResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getProgressPath()), ChatProgressResponse.class);
        List<Draft> finance = chatProgressResponse.getFinance();
        if (finance == null) {
            finance = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(finance, 10));
        for (T t : finance) {
            int i = this.a;
            this.a = i + 1;
            arrayList.add(Draft.copy$default(t, null, null, i, 3, null));
        }
        return this.c.wrapWithTokenRefresh(new a(this, Observable.just(ChatProgressResponseKt.toChatProgressRepo(ChatProgressResponse.copy$default(chatProgressResponse, arrayList, null, 2, null))).delay(this.b, TimeUnit.SECONDS)));
    }

    @Override // ru.sravni.android.bankproduct.repository.dashboard.IDashBoardWebClient
    @NotNull
    public Observable<List<OfferCalculationElementRepo>> getOfferCalculatedList() {
        List<OfferCalculationItem> items = ((OfferCalculationListResponse) a2.b.a.a.a.i2(UtilFunctionsKt.readStringFromAsset(this.e, this.f.getCalculationListPath()), OfferCalculationListResponse.class)).getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(OfferCalculationListResponseKt.toOfferCalculatedElementRepo(it.next()));
        }
        return this.c.wrapWithTokenRefresh(new b(this, Observable.just(arrayList).delay(this.b, TimeUnit.SECONDS)));
    }

    public final int getProgress() {
        return this.a;
    }

    public final void setProgress(int i) {
        this.a = i;
    }
}
