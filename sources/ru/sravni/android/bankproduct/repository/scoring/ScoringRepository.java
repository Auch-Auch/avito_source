package ru.sravni.android.bankproduct.repository.scoring;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.scoring.IScoringRepository;
import ru.sravni.android.bankproduct.domain.scoring.entity.ScoringDomain;
import ru.sravni.android.bankproduct.domain.scoring.entity.ScoringStatus;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.repository.scoring.entity.ScoringInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/sravni/android/bankproduct/repository/scoring/ScoringRepository;", "Lru/sravni/android/bankproduct/domain/scoring/IScoringRepository;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringDomain;", "getScoring", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "c", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/repository/scoring/IScoringWebClient;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/repository/scoring/IScoringWebClient;", "scoringWebClient", "<init>", "(Lru/sravni/android/bankproduct/repository/scoring/IScoringWebClient;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringRepository implements IScoringRepository {
    public final IScoringWebClient a;
    public final IErrorLogger b;
    public final IThrowableWrapper c;

    public static final class a<T, R> implements Function<T, R> {
        public final /* synthetic */ ScoringRepository a;

        public a(ScoringRepository scoringRepository) {
            this.a = scoringRepository;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            ScoringInfoRepo scoringInfoRepo = (ScoringInfoRepo) obj;
            Intrinsics.checkParameterIsNotNull(scoringInfoRepo, "it");
            return new ScoringDomain(ScoringRepository.access$getStatus(this.a, scoringInfoRepo.getScoreStatus()), scoringInfoRepo.getScore(), scoringInfoRepo.getProviderTitle(), scoringInfoRepo.getPercentage(), scoringInfoRepo.getMessage(), scoringInfoRepo.getScoreUnitText());
        }
    }

    public ScoringRepository(@NotNull IScoringWebClient iScoringWebClient, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(iScoringWebClient, "scoringWebClient");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        this.a = iScoringWebClient;
        this.b = iErrorLogger;
        this.c = iThrowableWrapper;
    }

    public static final ScoringStatus access$getStatus(ScoringRepository scoringRepository, String str) {
        Objects.requireNonNull(scoringRepository);
        switch (str.hashCode()) {
            case -1867169789:
                if (str.equals("success")) {
                    return ScoringStatus.SUCCESS;
                }
                break;
            case 3079315:
                if (str.equals("debt")) {
                    return ScoringStatus.DEBT;
                }
                break;
            case 1553320047:
                if (str.equals("notFound")) {
                    return ScoringStatus.NOT_FOUND;
                }
                break;
            case 2095695089:
                if (str.equals("notCalculated")) {
                    return ScoringStatus.NOT_CALCULATED;
                }
                break;
        }
        scoringRepository.b.logError(MessagePriority.ERROR, scoringRepository.c.wrap(new StatusStringNotFoundError(str)));
        return ScoringStatus.UNEXPECTED;
    }

    @Override // ru.sravni.android.bankproduct.domain.scoring.IScoringRepository
    @NotNull
    public Observable<ScoringDomain> getScoring() {
        Observable<R> map = this.a.getScoring().map(new a(this));
        Intrinsics.checkExpressionValueIsNotNull(map, "scoringWebClient\n       …          )\n            }");
        return map;
    }
}
