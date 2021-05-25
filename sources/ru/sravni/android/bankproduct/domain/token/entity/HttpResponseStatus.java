package ru.sravni.android.bankproduct.domain.token.entity;

import com.avito.android.payment.SberbankOnlineKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.r;
import t6.n.y;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "", "", "code", "I", "getCode", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", SberbankOnlineKt.RESULT_SUCCESS, "TOKEN_EXPIRE", "UNAUTHORIZED_401", "UNAUTHORIZED_410", "UNAUTHORIZED_404", "SERVICE_UNAVAILABLE_403", "SERVICE_UNAVAILABLE_405", "SERVICE_UNAVAILABLE_408", "SERVICE_UNAVAILABLE_500", "UNKNOWN_STATUS", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public enum HttpResponseStatus {
    SUCCESS(200),
    TOKEN_EXPIRE(440),
    UNAUTHORIZED_401(401),
    UNAUTHORIZED_410(410),
    UNAUTHORIZED_404(404),
    SERVICE_UNAVAILABLE_403(403),
    SERVICE_UNAVAILABLE_405(405),
    SERVICE_UNAVAILABLE_408(408),
    SERVICE_UNAVAILABLE_500(500),
    UNKNOWN_STATUS(-1);
    
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, HttpResponseStatus> codeValueMap;
    @NotNull
    private static final List<Integer> unauthorizedCodes;
    @NotNull
    private static final Set<HttpResponseStatus> unauthorizedSet;
    @NotNull
    private static final List<Integer> unavailableCodes;
    @NotNull
    private static final Set<HttpResponseStatus> unavailableSet = y.setOf((Object[]) new HttpResponseStatus[]{SERVICE_UNAVAILABLE_403, SERVICE_UNAVAILABLE_405, SERVICE_UNAVAILABLE_408, SERVICE_UNAVAILABLE_500});
    private final int code;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus$Companion;", "", "", "code", "Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "fromCode", "(I)Lru/sravni/android/bankproduct/domain/token/entity/HttpResponseStatus;", "", "unavailableSet", "Ljava/util/Set;", "getUnavailableSet", "()Ljava/util/Set;", "", "unavailableCodes", "Ljava/util/List;", "getUnavailableCodes", "()Ljava/util/List;", "unauthorizedSet", "getUnauthorizedSet", "unauthorizedCodes", "getUnauthorizedCodes", "", "codeValueMap", "Ljava/util/Map;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final HttpResponseStatus fromCode(int i) {
            HttpResponseStatus httpResponseStatus = (HttpResponseStatus) HttpResponseStatus.codeValueMap.get(Integer.valueOf(i));
            return httpResponseStatus != null ? httpResponseStatus : HttpResponseStatus.UNKNOWN_STATUS;
        }

        @NotNull
        public final List<Integer> getUnauthorizedCodes() {
            return HttpResponseStatus.unauthorizedCodes;
        }

        @NotNull
        public final Set<HttpResponseStatus> getUnauthorizedSet() {
            return HttpResponseStatus.unauthorizedSet;
        }

        @NotNull
        public final List<Integer> getUnavailableCodes() {
            return HttpResponseStatus.unavailableCodes;
        }

        @NotNull
        public final Set<HttpResponseStatus> getUnavailableSet() {
            return HttpResponseStatus.unavailableSet;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    static {
        HttpResponseStatus[] values = values();
        ArrayList arrayList = new ArrayList(10);
        for (HttpResponseStatus httpResponseStatus : values) {
            arrayList.add(TuplesKt.to(Integer.valueOf(httpResponseStatus.code), httpResponseStatus));
        }
        codeValueMap = r.toMap(arrayList);
        Set<HttpResponseStatus> of = y.setOf((Object[]) new HttpResponseStatus[]{UNAUTHORIZED_401, UNAUTHORIZED_410, UNAUTHORIZED_404});
        unauthorizedSet = of;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(of, 10));
        Iterator<T> it = of.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((HttpResponseStatus) it.next()).code));
        }
        unauthorizedCodes = arrayList2;
        Set<HttpResponseStatus> set = unavailableSet;
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(set, 10));
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(((HttpResponseStatus) it2.next()).code));
        }
        unavailableCodes = arrayList3;
    }

    private HttpResponseStatus(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
