package ru.sravni.android.bankproduct.di;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import ru.sravni.android.bankproduct.analytic.di.AnalyticProviderKt;
import ru.sravni.android.bankproduct.domain.di.InteractorProviderKt;
import ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt;
import ru.sravni.android.bankproduct.storage.di.StorageClientProviderKt;
import ru.sravni.android.bankproduct.utils.di.UtilProviderKt;
import ru.sravni.android.bankproduct.utils.extlib.di.LibKodeinProviderKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lorg/kodein/di/Kodein$Module;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/Kodein$Module;", "getBankLibraryKodeinModule", "()Lorg/kodein/di/Kodein$Module;", "bankLibraryKodeinModule", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BankLibraryProviderKt {
    @NotNull
    public static final Kodein.Module a = new Kodein.Module("bankLibraryKodeinModule", false, null, a.a, 6, null);

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
            Kodein.Builder.DefaultImpls.import$default(builder2, LibKodeinProviderKt.getLibKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, RepositoryProviderKt.getRepositoryKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, InteractorProviderKt.getInteractorKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, StorageClientProviderKt.getStorageKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, AnalyticProviderKt.getAnalyticKodeinModule(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, AnalyticProviderKt.getAnalyticKodeinModuleV2(), false, 2, null);
            Kodein.Builder.DefaultImpls.import$default(builder2, UtilProviderKt.getUtilKodeinModule(), false, 2, null);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public static final Kodein.Module getBankLibraryKodeinModule() {
        return a;
    }
}
