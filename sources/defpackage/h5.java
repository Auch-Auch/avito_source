package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.repository.analytic.AnalyticRepository;
/* compiled from: kotlin-style lambda group */
/* renamed from: h5  reason: default package */
public final class h5 extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, AnalyticRepository> {
    public static final h5 b = new h5(0);
    public static final h5 c = new h5(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h5(int i) {
        super(1);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final AnalyticRepository invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        int i = this.a;
        if (i == 0) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
            return (AnalyticRepository) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<AnalyticRepository>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$2$$special$$inlined$instance$1
            }), null);
        } else if (i == 1) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein3 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein3, "$receiver");
            return (AnalyticRepository) noArgBindingKodein3.getDkodein().Instance(TypesKt.TT(new TypeReference<AnalyticRepository>() { // from class: ru.sravni.android.bankproduct.repository.di.RepositoryProviderKt$repositoryKodeinModule$1$3$$special$$inlined$instance$1
            }), null);
        } else {
            throw null;
        }
    }
}
