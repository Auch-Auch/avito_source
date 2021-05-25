package ru.sravni.android.bankproduct.utils.extlib.di;

import a7.c.a.a.r.d.c.b;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.Provider;
import ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\"\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0016\u0010\u000e\u001a\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errLogger", "", "setExternalLogger", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;)V", "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "analyticLogger", "setExternalAnalyticLogger", "(Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;)V", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/analytic/IAnalyticEventLogger;", "additionalAnalyticLogger", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "additionalLogger", "Lorg/kodein/di/Kodein$Module;", "c", "Lorg/kodein/di/Kodein$Module;", "getLibKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "libKodeinModule", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class LibKodeinProviderKt {
    public static IErrorLogger a = new IErrorLogger() { // from class: ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt$additionalLogger$1
        @Override // ru.sravni.android.bankproduct.domain.analytic.IErrorLogger
        public void logError(@NotNull MessagePriority messagePriority, @NotNull SravniError sravniError) {
            Intrinsics.checkParameterIsNotNull(messagePriority, Constants.FirelogAnalytics.PARAM_PRIORITY);
            Intrinsics.checkParameterIsNotNull(sravniError, "error");
        }
    };
    public static IAnalyticEventLogger b = new IAnalyticEventLogger() { // from class: ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt$additionalAnalyticLogger$1
        @Override // ru.sravni.android.bankproduct.domain.analytic.IAnalyticEventLogger
        public void logEvent(@NotNull AnalyticEvent analyticEvent) {
            Intrinsics.checkParameterIsNotNull(analyticEvent, "event");
        }
    };
    @NotNull
    public static final Kodein.Module c = new Kodein.Module("libKodeinModule", false, null, a.a, 6, null);

    public static final class a extends Lambda implements Function1<Kodein.Builder, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Kodein.Builder builder) {
            Kodein.Builder builder2 = builder;
            Intrinsics.checkParameterIsNotNull(builder2, "$receiver");
            builder2.Bind(TypesKt.TT(new LibKodeinProviderKt$libKodeinModule$1$$special$$inlined$bind$1()), "externalErrorLogger", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new LibKodeinProviderKt$libKodeinModule$1$$special$$inlined$provider$1()), a7.c.a.a.r.d.c.a.a));
            builder2.Bind(TypesKt.TT(new LibKodeinProviderKt$libKodeinModule$1$$special$$inlined$bind$2()), "externalAnalyticLogger", null).with(new Provider(builder2.getContextType(), TypesKt.TT(new LibKodeinProviderKt$libKodeinModule$1$$special$$inlined$provider$2()), b.a));
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module getLibKodeinModule() {
        return c;
    }

    public static final void setExternalAnalyticLogger(@NotNull IAnalyticEventLogger iAnalyticEventLogger) {
        Intrinsics.checkParameterIsNotNull(iAnalyticEventLogger, "analyticLogger");
        b = iAnalyticEventLogger;
    }

    public static final void setExternalLogger(@NotNull IErrorLogger iErrorLogger) {
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errLogger");
        a = iErrorLogger;
    }
}
