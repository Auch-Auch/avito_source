package ru.sravni.android.bankproduct.repository.auth;

import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.auth.entity.RegisterInfoRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/repository/auth/IAuthWebClient;", "", "", "phone", "Lio/reactivex/Observable;", "Lru/sravni/android/bankproduct/repository/auth/entity/RegisterInfoRepo;", "registerUser", "(Ljava/lang/String;)Lio/reactivex/Observable;", "smsCode", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "sendSmsCode", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IAuthWebClient {
    @NotNull
    Observable<RegisterInfoRepo> registerUser(@NotNull String str);

    @NotNull
    Observable<TokenData> sendSmsCode(@NotNull String str, @NotNull String str2);
}
