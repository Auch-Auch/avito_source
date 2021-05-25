package ru.sravni.android.bankproduct.utils.svg;

import com.bumptech.glide.load.engine.GlideException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.ErrorDescription;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"ru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback$Companion$createDefaultCallback$1", "Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "Lcom/bumptech/glide/load/engine/GlideException;", OkListener.KEY_EXCEPTION, "", "url", "", "onError", "(Lcom/bumptech/glide/load/engine/GlideException;Ljava/lang/String;)V", "onSuccess", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ILogoLoadCallback$Companion$createDefaultCallback$1 implements ILogoLoadCallback {
    public final /* synthetic */ IThrowableWrapper a;
    public final /* synthetic */ IErrorLogger b;

    public ILogoLoadCallback$Companion$createDefaultCallback$1(IThrowableWrapper iThrowableWrapper, IErrorLogger iErrorLogger) {
        this.a = iThrowableWrapper;
        this.b = iErrorLogger;
    }

    @Override // ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback
    public void onError(@Nullable GlideException glideException, @NotNull String str) {
        SravniError sravniError;
        Intrinsics.checkParameterIsNotNull(str, "url");
        if (glideException == null) {
            sravniError = this.a.wrap(new NullGlideExceptionError(str));
        } else {
            SravniError wrap = this.a.wrap(glideException);
            ErrorDescription errDescription = wrap.getErrDescription();
            sravniError = SravniError.copy$default(wrap, null, ErrorDescription.copy$default(errDescription, 0, null, wrap.getErrDescription().getDescription() + " for url " + str, null, 11, null), null, null, 13, null);
        }
        this.b.logError(MessagePriority.WARN, sravniError);
    }

    @Override // ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback
    public void onSuccess() {
    }
}
