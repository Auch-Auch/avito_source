package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.IErrorViewModel;
/* compiled from: kotlin-style lambda group */
/* renamed from: r5  reason: default package */
public final class r5 extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, IErrorViewModel> {
    public static final r5 b = new r5(0);
    public static final r5 c = new r5(1);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r5(int i) {
        super(1);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final IErrorViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        int i = this.a;
        if (i == 0) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
            return (IErrorViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$4$$special$$inlined$instance$1
            }), null);
        } else if (i == 1) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein3 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein3, "$receiver");
            return (IErrorViewModel) noArgBindingKodein3.getDkodein().Instance(TypesKt.TT(new TypeReference<IErrorViewModel>() { // from class: ru.sravni.android.bankproduct.presentation.main.di.PresentationMainProviderKt$presentationMainKodeinModule$1$5$$special$$inlined$instance$1
            }), null);
        } else {
            throw null;
        }
    }
}
