package a2.a.a.h3.a.h1;

import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.user_advert.advert.MyAdvertDetailsItem;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockViewModelImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
public final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<MyAdvertDetailsItem, MyAdvertDetails.Switcher> {
    public a(SwitcherBlockViewModelImpl switcherBlockViewModelImpl) {
        super(1, switcherBlockViewModelImpl, SwitcherBlockViewModelImpl.class, "getSwitcher", "getSwitcher(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public MyAdvertDetails.Switcher invoke(MyAdvertDetailsItem myAdvertDetailsItem) {
        MyAdvertDetailsItem myAdvertDetailsItem2 = myAdvertDetailsItem;
        Intrinsics.checkNotNullParameter(myAdvertDetailsItem2, "p1");
        return ((SwitcherBlockViewModelImpl) this.receiver).getSwitcher(myAdvertDetailsItem2);
    }
}
