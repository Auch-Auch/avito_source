package a7.c.a.a.l.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgSimpleBindingKodein;
import ru.sravni.android.bankproduct.domain.profile.IProfileRepository;
import ru.sravni.android.bankproduct.domain.profile.ProfileInteractor;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenRepository;
public final class a extends Lambda implements Function1<NoArgSimpleBindingKodein<? extends Object>, ProfileInteractor> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ProfileInteractor invoke(NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein) {
        NoArgSimpleBindingKodein<? extends Object> noArgSimpleBindingKodein2 = noArgSimpleBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgSimpleBindingKodein2, "$receiver");
        return new ProfileInteractor((IProfileRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IProfileRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$10$$special$$inlined$instance$1
        }), null), (ITokenRepository) noArgSimpleBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<ITokenRepository>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$10$$special$$inlined$instance$2
        }), null), (IThrowableWrapper) noArgSimpleBindingKodein2.getDkodein().Factory(TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$10$$special$$inlined$instance$3
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.domain.di.InteractorProviderKt$interactorKodeinModule$1$10$$special$$inlined$instance$4
        }), null).invoke("domain"));
    }
}
