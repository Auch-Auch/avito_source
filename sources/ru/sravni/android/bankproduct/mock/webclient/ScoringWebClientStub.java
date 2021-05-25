package ru.sravni.android.bankproduct.mock.webclient;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.network.scoring.response.ScoringResponse;
import ru.sravni.android.bankproduct.repository.scoring.IScoringWebClient;
import ru.sravni.android.bankproduct.repository.scoring.entity.ScoringInfoRepo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStub;", "Lru/sravni/android/bankproduct/repository/scoring/IScoringWebClient;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/scoring/entity/ScoringInfoRepo;", "getScoring", "()Lio/reactivex/Observable;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "", AuthSource.BOOKING_ORDER, "J", "delay", "Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStubInfo;", "d", "Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStubInfo;", "scoringStubInfo", "", AuthSource.SEND_ABUSE, "I", "inc", "<init>", "(JLandroid/content/Context;Lru/sravni/android/bankproduct/mock/webclient/ScoringWebClientStubInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringWebClientStub implements IScoringWebClient {
    public int a;
    public final long b;
    public final Context c;
    public final ScoringWebClientStubInfo d;

    public ScoringWebClientStub(long j, @NotNull Context context, @NotNull ScoringWebClientStubInfo scoringWebClientStubInfo) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(scoringWebClientStubInfo, "scoringStubInfo");
        this.b = j;
        this.c = context;
        this.d = scoringWebClientStubInfo;
    }

    @Override // ru.sravni.android.bankproduct.repository.scoring.IScoringWebClient
    @NotNull
    public Observable<ScoringInfoRepo> getScoring() {
        Observable observable;
        List list = (List) new Gson().fromJson(UtilFunctionsKt.readStringFromAsset(this.c, this.d.getScoringListPath()), new TypeToken<List<? extends ScoringResponse>>() { // from class: ru.sravni.android.bankproduct.mock.webclient.ScoringWebClientStub$getScoring$$inlined$readListFromAsset$1
        }.getType());
        int size = this.a % (list.size() + 1);
        if (size < list.size()) {
            observable = Observable.just(((ScoringResponse) list.get(size)).getItem().toScoringRepo());
            Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.just(scoringL…on].item.toScoringRepo())");
        } else {
            observable = Observable.error(new Exception("TestMockException"));
            Intrinsics.checkExpressionValueIsNotNull(observable, "Observable.error(Exception(\"TestMockException\"))");
        }
        this.a++;
        Observable<ScoringInfoRepo> delay = observable.delay(this.b, TimeUnit.SECONDS);
        Intrinsics.checkExpressionValueIsNotNull(delay, "result.delay(delay, TimeUnit.SECONDS)");
        return delay;
    }
}
