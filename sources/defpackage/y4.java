package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardViewModel;
/* compiled from: kotlin-style lambda group */
/* renamed from: y4  reason: default package */
public final class y4 extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, IKeyboardViewModel> {
    public static final y4 b = new y4(0);
    public static final y4 c = new y4(1);
    public static final y4 d = new y4(2);
    public static final y4 e = new y4(3);
    public static final y4 f = new y4(4);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y4(int i) {
        super(1);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final IKeyboardViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        int i = this.a;
        if (i == 0) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
            return (IKeyboardViewModel) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$24$$special$$inlined$instance$1
            }), null);
        } else if (i == 1) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein3 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein3, "$receiver");
            return (IKeyboardViewModel) noArgBindingKodein3.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$25$$special$$inlined$instance$1
            }), null);
        } else if (i == 2) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein4 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein4, "$receiver");
            return (IKeyboardViewModel) noArgBindingKodein4.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$26$$special$$inlined$instance$1
            }), null);
        } else if (i == 3) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein5 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein5, "$receiver");
            return (IKeyboardViewModel) noArgBindingKodein5.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$27$$special$$inlined$instance$1
            }), null);
        } else if (i == 4) {
            NoArgBindingKodein<? extends Object> noArgBindingKodein6 = noArgBindingKodein;
            Intrinsics.checkParameterIsNotNull(noArgBindingKodein6, "$receiver");
            return (IKeyboardViewModel) noArgBindingKodein6.getDkodein().Instance(TypesKt.TT(new TypeReference<IKeyboardViewModel>() { // from class: ru.sravni.android.bankproduct.utils.di.UtilProviderKt$utilKodeinModule$1$28$$special$$inlined$instance$1
            }), null);
        } else {
            throw null;
        }
    }
}
