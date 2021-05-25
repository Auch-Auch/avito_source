package ru.sravni.android.bankproduct.domain.scoring.entity;

import com.avito.android.payment.SberbankOnlineKt;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/sravni/android/bankproduct/domain/scoring/entity/ScoringStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DEBT", "NOT_CALCULATED", "NOT_FOUND", SberbankOnlineKt.RESULT_SUCCESS, "UNEXPECTED", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public enum ScoringStatus {
    DEBT,
    NOT_CALCULATED,
    NOT_FOUND,
    SUCCESS,
    UNEXPECTED
}
