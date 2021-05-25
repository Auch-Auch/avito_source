package ru.sravni.android.bankproduct.domain.sravnierror;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/domain/sravnierror/ThrowableWrapper;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "", "throwable", "Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "wrap", "(Ljava/lang/Throwable;)Lru/sravni/android/bankproduct/domain/sravnierror/entity/SravniError;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;", "errorMapper", "<init>", "(Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableErrorDescriptionMapper;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ThrowableWrapper implements IThrowableWrapper {
    public final IThrowableErrorDescriptionMapper a;

    public ThrowableWrapper(@NotNull IThrowableErrorDescriptionMapper iThrowableErrorDescriptionMapper) {
        Intrinsics.checkParameterIsNotNull(iThrowableErrorDescriptionMapper, "errorMapper");
        this.a = iThrowableErrorDescriptionMapper;
    }

    @Override // ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper
    @NotNull
    public SravniError wrap(@Nullable Throwable th) {
        if (th == null) {
            return new SravniError(this.a.getDomain(), ThrowableWrapperKt.getNULL_THROWABLE_ERROR(), new Throwable(ThrowableWrapperKt.getNULL_THROWABLE_ERROR().getDescription()), null);
        }
        if (th instanceof SravniError) {
            String domain = this.a.getDomain();
            ErrorDescription mapToError = this.a.mapToError(th);
            if (mapToError == null) {
                mapToError = ThrowableWrapperKt.getDEFAULT_SRAVNI_ERROR();
            }
            SravniError sravniError = (SravniError) th;
            return new SravniError(domain, mapToError, sravniError.getError(), sravniError);
        }
        String domain2 = this.a.getDomain();
        ErrorDescription mapToError2 = this.a.mapToError(th);
        if (mapToError2 == null) {
            mapToError2 = ThrowableWrapperKt.getDEFAULT_THROWABLE_ERROR();
        }
        return new SravniError(domain2, mapToError2, th, null);
    }
}
