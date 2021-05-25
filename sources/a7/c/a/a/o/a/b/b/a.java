package a7.c.a.a.o.a.b.b;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.dictionary.entity.ProductDictionaryInfoDomain;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.StateEnum;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.ProfileSmsViewModel;
import ru.sravni.android.bankproduct.presentation.chat.entity.ChatInfo;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.product.ProductUtilKt;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ ProfileSmsViewModel a;

    public a(ProfileSmsViewModel profileSmsViewModel) {
        this.a = profileSmsViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.getEditSmsStatus().setValue(StateEnum.STATE_SUCCESS);
        this.a.n.hideKeyboard();
        INavigator.DefaultImpls.route$default(this.a.l, R.id.action_avitoSmsFragment_to_chatFragment, UtilFunctionsKt.toSravniJson(new ChatInfo(((ProductDictionaryInfoDomain) this.a.t.get(ProductUtilKt.getCREDIT_AVITO_CHAT_NAME())).getChatName(), null, ((ProductDictionaryInfoDomain) this.a.t.get(ProductUtilKt.getCREDIT_AVITO_CHAT_NAME())).getTitle(), null, null, false, 48, null)), null, 4, null);
    }
}
