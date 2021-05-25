package ru.sravni.android.bankproduct.utils.svg;

import com.bumptech.glide.load.engine.GlideException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.di.UtilProviderKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "", "Lcom/bumptech/glide/load/engine/GlideException;", OkListener.KEY_EXCEPTION, "", "url", "", "onError", "(Lcom/bumptech/glide/load/engine/GlideException;Ljava/lang/String;)V", "onSuccess", "()V", "Companion", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface ILogoLoadCallback {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback$Companion;", "", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "createDefaultCallback", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        public static /* synthetic */ ILogoLoadCallback createDefaultCallback$default(Companion companion, IErrorLogger iErrorLogger, IThrowableWrapper iThrowableWrapper, int i, Object obj) {
            if ((i & 2) != 0) {
                iThrowableWrapper = UtilProviderKt.throwableWrapperFactoryMethod("util");
            }
            return companion.createDefaultCallback(iErrorLogger, iThrowableWrapper);
        }

        @NotNull
        public final ILogoLoadCallback createDefaultCallback(@NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
            Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
            Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
            return new ILogoLoadCallback$Companion$createDefaultCallback$1(iThrowableWrapper, iErrorLogger);
        }
    }

    void onError(@Nullable GlideException glideException, @NotNull String str);

    void onSuccess();
}
