package a2.a.a.c2.a;

import android.text.Editable;
import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class d<T, R> implements Function<Unit, String> {
    public final /* synthetic */ AddPhoneFragment a;

    public d(AddPhoneFragment addPhoneFragment) {
        this.a = addPhoneFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public String apply(Unit unit) {
        String obj;
        Editable text = AddPhoneFragment.access$getPhoneInput$p(this.a).m90getText();
        return (text == null || (obj = text.toString()) == null) ? "" : obj;
    }
}
