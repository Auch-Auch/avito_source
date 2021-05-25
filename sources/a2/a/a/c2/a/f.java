package a2.a.a.c2.a;

import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<String> {
    public final /* synthetic */ AddPhoneFragment a;

    public f(AddPhoneFragment addPhoneFragment) {
        this.a = addPhoneFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(String str) {
        String str2 = str;
        AddPhoneViewModel access$getViewModel$p = AddPhoneFragment.access$getViewModel$p(this.a);
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        access$getViewModel$p.onContinueClicked(str2);
    }
}
