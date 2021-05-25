package ru.sravni.android.bankproduct.utils.sms;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;", "", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/utils/sms/SmsInfo;", "getSmsChannel", "()Lio/reactivex/Observable;", "smsChannel", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ISmsChannel {
    @NotNull
    Observable<SmsInfo> getSmsChannel();
}
