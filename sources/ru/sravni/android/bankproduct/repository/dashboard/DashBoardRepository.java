package ru.sravni.android.bankproduct.repository.dashboard;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.DataContainer;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository;
import ru.sravni.android.bankproduct.domain.dashboard.entity.ChatProgressDomain;
import ru.sravni.android.bankproduct.domain.dashboard.entity.HelloMessageInfo;
import ru.sravni.android.bankproduct.domain.dashboard.entity.OfferCalculationElementDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.ChatProgressRepoKt;
import ru.sravni.android.bankproduct.repository.dashboard.entity.HelloMessageInfoRepo;
import ru.sravni.android.bankproduct.repository.dashboard.entity.OfferCalculationElementRepo;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\nR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/DashBoardRepository;", "Lru/sravni/android/bankproduct/domain/dashboard/IDashBoardRepository;", "", "Lru/sravni/android/bankproduct/domain/dashboard/entity/HelloMessageInfo;", "getListHelloMessages", "()Ljava/util/List;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/DataContainer;", "", "getNameUser", "()Lio/reactivex/Observable;", "", "getHourNow", "()I", "", "nextIcon", "()V", "Lru/sravni/android/bankproduct/domain/dashboard/entity/OfferCalculationElementDomain;", "getOfferCalculatedList", "Lru/sravni/android/bankproduct/domain/dashboard/entity/ChatProgressDomain;", "getChatProgress", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;", "c", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;", "webClient", AuthSource.SEND_ABUSE, "Lio/reactivex/Observable;", "getIconNumChannel", "iconNumChannel", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardStorage;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardStorage;", "storage", "<init>", "(Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardStorage;Lru/sravni/android/bankproduct/repository/dashboard/IDashBoardWebClient;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DashBoardRepository implements IDashBoardRepository {
    @NotNull
    public final Observable<Integer> a;
    public final IDashBoardStorage b;
    public final IDashBoardWebClient c;
    public final IErrorLogger d;
    public final IThrowableWrapper e;

    public static final class a<T, R> implements Function<T, R> {
        public static final a a = new a();

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ChatProgressRepo chatProgressRepo = (ChatProgressRepo) obj;
            Intrinsics.checkParameterIsNotNull(chatProgressRepo, "it");
            return ChatProgressRepoKt.toChatProgressDomain(chatProgressRepo);
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public final /* synthetic */ DashBoardRepository a;

        public b(DashBoardRepository dashBoardRepository) {
            this.a = dashBoardRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            List<T> list = (List) obj;
            Intrinsics.checkParameterIsNotNull(list, "it");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(DashBoardRepository.access$toOfferCalculationElementDomain(this.a, t));
            }
            return arrayList;
        }
    }

    public DashBoardRepository(@NotNull IDashBoardStorage iDashBoardStorage, @NotNull IDashBoardWebClient iDashBoardWebClient, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iDashBoardStorage, "storage");
        Intrinsics.checkParameterIsNotNull(iDashBoardWebClient, "webClient");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.b = iDashBoardStorage;
        this.c = iDashBoardWebClient;
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
        this.a = iDashBoardStorage.getIconSourceChannel();
    }

    public static final OfferCalculationElementDomain access$toOfferCalculationElementDomain(DashBoardRepository dashBoardRepository, OfferCalculationElementRepo offerCalculationElementRepo) {
        Date date;
        Objects.requireNonNull(dashBoardRepository);
        try {
            date = new SimpleDateFormat(DateUtilKt.serverFormat, Locale.getDefault()).parse(offerCalculationElementRepo.getDate());
        } catch (Exception e2) {
            dashBoardRepository.d.logError(MessagePriority.ERROR, dashBoardRepository.e.wrap(e2));
            date = new Date();
        }
        String conversationId = offerCalculationElementRepo.getConversationId();
        Intrinsics.checkExpressionValueIsNotNull(date, Sort.DATE);
        return new OfferCalculationElementDomain(conversationId, date, offerCalculationElementRepo.getCreditName(), offerCalculationElementRepo.getProductName(), offerCalculationElementRepo.getCreditTitle(), offerCalculationElementRepo.getOfferCount(), offerCalculationElementRepo.getRequestSend(), offerCalculationElementRepo.getOfferCountTitle(), offerCalculationElementRepo.getRequestCountTitle(), offerCalculationElementRepo.getSavedSearchID());
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    @NotNull
    public Observable<ChatProgressDomain> getChatProgress() {
        Observable<R> map = this.c.getChatProgress().map(a.a);
        Intrinsics.checkExpressionValueIsNotNull(map, "webClient.getChatProgres….toChatProgressDomain() }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    public int getHourNow() {
        return Calendar.getInstance().get(11);
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    @NotNull
    public Observable<Integer> getIconNumChannel() {
        return this.a;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    @NotNull
    public List<HelloMessageInfo> getListHelloMessages() {
        List<HelloMessageInfoRepo> listHelloMessages = this.b.getListHelloMessages();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(listHelloMessages, 10));
        for (T t : listHelloMessages) {
            arrayList.add(new HelloMessageInfo(t.getBefore(), t.getAfter(), t.getMessageID()));
        }
        return arrayList;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    @NotNull
    public Observable<DataContainer<String>> getNameUser() {
        Observable<DataContainer<String>> just = Observable.just(new DataContainer(null, this.e.wrap(new NotImplementedError(null, 1, null))));
        Intrinsics.checkExpressionValueIsNotNull(just, "Observable.just(\n       …mplementedError()))\n    )");
        return just;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    @NotNull
    public Observable<List<OfferCalculationElementDomain>> getOfferCalculatedList() {
        Observable<R> map = this.c.getOfferCalculatedList().map(new b(this));
        Intrinsics.checkExpressionValueIsNotNull(map, "webClient.getOfferCalcul…)\n            }\n        }");
        return map;
    }

    @Override // ru.sravni.android.bankproduct.domain.dashboard.IDashBoardRepository
    public void nextIcon() {
        this.b.nextIcon();
    }
}
