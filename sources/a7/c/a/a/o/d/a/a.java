package a7.c.a.a.o.d.a;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, String> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        String string;
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        Bundle arguments = ((DialogFragment) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<DialogFragment>() { // from class: ru.sravni.android.bankproduct.presentation.dialogerror.di.PresentationDialogErrorProviderKt$presentationDialogErrorKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).getArguments();
        return (arguments == null || (string = arguments.getString("MESSAGE")) == null) ? "Ошибка" : string;
    }
}
