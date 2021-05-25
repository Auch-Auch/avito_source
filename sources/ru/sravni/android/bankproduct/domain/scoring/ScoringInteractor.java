package ru.sravni.android.bankproduct.domain.scoring;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.scoring.entity.ScoringDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/domain/scoring/ScoringInteractor;", "Lru/sravni/android/bankproduct/domain/scoring/IScoringInteractor;", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringDomain;", "getScoring", "()Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/domain/scoring/IScoringRepository;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/scoring/IScoringRepository;", "scoringRepository", "<init>", "(Lru/sravni/android/bankproduct/domain/scoring/IScoringRepository;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScoringInteractor implements IScoringInteractor {
    public final IScoringRepository a;

    public ScoringInteractor(@NotNull IScoringRepository iScoringRepository) {
        Intrinsics.checkParameterIsNotNull(iScoringRepository, "scoringRepository");
        this.a = iScoringRepository;
    }

    @Override // ru.sravni.android.bankproduct.domain.scoring.IScoringInteractor
    @NotNull
    public Observable<ScoringDomain> getScoring() {
        return this.a.getScoring();
    }
}
