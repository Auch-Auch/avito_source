package ru.sravni.android.bankproduct.storage.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.domain.token.entity.TokenData;
import ru.sravni.android.bankproduct.repository.token.ITokenDataStorage;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.encryption.IEncryptionUtil;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/storage/token/TokenDataSharedPreferenceStorage;", "Lru/sravni/android/bankproduct/repository/token/ITokenDataStorage;", "Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "value", "", "setTokenData", "(Lru/sravni/android/bankproduct/domain/token/entity/TokenData;)V", "getTokenData", "()Lru/sravni/android/bankproduct/domain/token/entity/TokenData;", "clear", "()V", "Lru/sravni/android/bankproduct/utils/encryption/IEncryptionUtil;", "d", "Lru/sravni/android/bankproduct/utils/encryption/IEncryptionUtil;", "encryptionUtil", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "e", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "c", "Landroid/content/SharedPreferences;", "prefs", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "prefsName", AuthSource.BOOKING_ORDER, "countFieldName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lru/sravni/android/bankproduct/utils/encryption/IEncryptionUtil;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TokenDataSharedPreferenceStorage implements ITokenDataStorage {
    public final String a = "SravniTokenSP";
    public final String b = "tokenDataField";
    public final SharedPreferences c;
    public final IEncryptionUtil d;
    public final IErrorLogger e;

    public TokenDataSharedPreferenceStorage(@NotNull Context context, @NotNull IEncryptionUtil iEncryptionUtil, @NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(iEncryptionUtil, "encryptionUtil");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        this.d = iEncryptionUtil;
        this.e = iErrorLogger;
        this.c = context.getSharedPreferences("SravniTokenSP", 0);
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenDataStorage
    public void clear() {
        this.c.edit().clear().apply();
    }

    @Override // ru.sravni.android.bankproduct.domain.token.ITokenDataGetter
    @Nullable
    public TokenData getTokenData() {
        String string = this.c.getString(this.b, "");
        if (string == null) {
            return null;
        }
        try {
            return (TokenData) new Gson().fromJson(this.d.decrypt(string), (Class<Object>) TokenData.class);
        } catch (Throwable th) {
            this.e.logError(MessagePriority.ERROR, new SravniError("ST", TokenDataSharedPreferenceStorageKt.access$getDecryptErrorDescription$p(), th, (SravniError) null, 8, (j) null));
            return null;
        }
    }

    @Override // ru.sravni.android.bankproduct.repository.token.ITokenDataStorage
    public void setTokenData(@NotNull TokenData tokenData) {
        Intrinsics.checkParameterIsNotNull(tokenData, "value");
        String sravniJson = UtilFunctionsKt.toSravniJson(tokenData);
        IEncryptionUtil iEncryptionUtil = this.d;
        Intrinsics.checkExpressionValueIsNotNull(sravniJson, "tokenJson");
        try {
            this.c.edit().putString(this.b, iEncryptionUtil.encrypt(sravniJson)).apply();
        } catch (Throwable th) {
            this.e.logError(MessagePriority.ERROR, new SravniError("ST", TokenDataSharedPreferenceStorageKt.access$getEncryptErrorDescription$p(), th, (SravniError) null, 8, (j) null));
        }
    }
}
