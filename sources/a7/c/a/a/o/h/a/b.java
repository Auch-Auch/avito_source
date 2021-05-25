package a7.c.a.a.o.h.a;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import org.kodein.di.bindings.NoArgBindingKodein;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.WebViewViewModel;
import ru.sravni.android.bankproduct.presentation.webview.viewmodel.WebViewViewModelFactory;
import ru.sravni.android.bankproduct.utils.CommonFragment;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.entity.WebViewNavInfo;
public final class b extends Lambda implements Function1<NoArgBindingKodein<? extends Object>, WebViewViewModel> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public WebViewViewModel invoke(NoArgBindingKodein<? extends Object> noArgBindingKodein) {
        NoArgBindingKodein<? extends Object> noArgBindingKodein2 = noArgBindingKodein;
        Intrinsics.checkParameterIsNotNull(noArgBindingKodein2, "$receiver");
        return (WebViewViewModel) new ViewModelProvider((ViewModelStoreOwner) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<CommonFragment>() { // from class: ru.sravni.android.bankproduct.presentation.webview.di.PresentationWebViewKodeinModuleKt$presentationWebViewKodeinModule$1$2$$special$$inlined$instance$1
        }), null), new WebViewViewModelFactory((WebViewNavInfo) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<WebViewNavInfo>() { // from class: ru.sravni.android.bankproduct.presentation.webview.di.PresentationWebViewKodeinModuleKt$presentationWebViewKodeinModule$1$2$$special$$inlined$instance$2
        }), null), (INavigator) noArgBindingKodein2.getDkodein().Instance(TypesKt.TT(new TypeReference<INavigator>() { // from class: ru.sravni.android.bankproduct.presentation.webview.di.PresentationWebViewKodeinModuleKt$presentationWebViewKodeinModule$1$2$$special$$inlined$instance$3
        }), null))).get(WebViewViewModel.class);
    }
}
