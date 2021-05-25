package ru.sravni.android.bankproduct.storage.token;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/storage/token/TokenDataInMemoryStorage;", "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "value", "", "setTokenData", "(Lru/sravni/android/bankproduct/domain/token/entity/TokenData;)V", "getTokenData", "()Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "clear", "()V", "Ljava/util/concurrent/atomic/AtomicReference;", AuthSource.SEND_ABUSE, "Ljava/util/concurrent/atomic/AtomicReference;", "lastToken", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenDataInMemoryStorage implements ITokenDataStorage {
    public static final TokenDataInMemoryStorage INSTANCE = new TokenDataInMemoryStorage();
    public static final AtomicReference<TokenData> a = new AtomicReference<>();

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenDataStorage
    public void clear() {
        a.set(null);
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenDataGetter
    @Nullable
    public TokenData getTokenData() {
        return a.get();
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenDataStorage
    public void setTokenData(@NotNull TokenData tokenData) {
        Intrinsics.checkParameterIsNotNull(tokenData, "value");
        a.set(tokenData);
    }
}
