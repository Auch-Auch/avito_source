package a7.c.a.a.o.c.a;

import a2.b.a.a.a;
import android.os.Bundle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
public final class g extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, ChatInfo> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ChatInfo invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        ChatInfo chatInfo;
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        String str = null;
        Bundle arguments = ((CommonFragment) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.chat.di.PresentationChatProviderKt$presentationChatKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).getArguments();
        if (arguments != null) {
            str = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME);
        }
        return (str == null || (chatInfo = (ChatInfo) a.i2(str, ChatInfo.class)) == null) ? new ChatInfo("UnknownChat", null, null, null, null, false, 56, null) : chatInfo;
    }
}
