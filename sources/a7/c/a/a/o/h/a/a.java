package a7.c.a.a.o.h.a;

import android.os.Bundle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.WebViewViewModelKt;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
public final class a extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, WebViewNavInfo> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public WebViewNavInfo invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        WebViewNavInfo webViewNavInfo;
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        String str = null;
        Bundle arguments = ((CommonFragment) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.webview.di.PresentationWebViewKodeinModuleKt$presentationWebViewKodeinModule$1$1$$special$$inlined$instance$1
        }), null)).getArguments();
        if (arguments != null) {
            str = arguments.getString(INavigatorKt.NAV_PARAMETER_NAME);
        }
        return (str == null || (webViewNavInfo = (WebViewNavInfo) a2.b.a.a.a.i2(str, WebViewNavInfo.class)) == null) ? WebViewViewModelKt.getWebViewNavInfoError() : webViewNavInfo;
    }
}
