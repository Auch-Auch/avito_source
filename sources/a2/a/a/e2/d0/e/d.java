package a2.a.a.e2.d0.e;

import a2.b.a.a.a;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.model.Session;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.EmailParameter;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.slot.contact_info.ContactInfoSlotConfig;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Session, ObservableSource<? extends Unit>> {
    public final /* synthetic */ ContactInfoSlotWrapper a;

    public d(ContactInfoSlotWrapper contactInfoSlotWrapper) {
        this.a = contactInfoSlotWrapper;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends Unit> apply(Session session) {
        String str;
        T t;
        T t2;
        T t3;
        String str2;
        ProfileApi access$getProfileApi$p = ContactInfoSlotWrapper.access$getProfileApi$p(this.a);
        String session2 = session.getSession();
        Iterator<T> it = this.a.getSlot().getParameters().iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof EmailParameter) {
                break;
            }
        }
        T t4 = t;
        String str3 = t4 != null ? (String) t4.getValue() : null;
        if (str3 == null) {
            str3 = "";
        }
        ContactInfoSlotWrapper contactInfoSlotWrapper = this.a;
        Iterator<T> it2 = contactInfoSlotWrapper.getSlot().getParameters().iterator();
        while (true) {
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (t2 instanceof PhoneParameter) {
                break;
            }
        }
        T t5 = t2;
        String access$cleanFormatting = ContactInfoSlotWrapper.access$cleanFormatting(contactInfoSlotWrapper, t5 != null ? (String) t5.getValue() : null);
        Iterator<T> it3 = this.a.getSlot().getParameters().iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            String id = t3.getId();
            CharParameter nameField = ((ContactInfoSlotConfig) a.C1(this.a)).getNameField();
            if (Intrinsics.areEqual(id, nameField != null ? nameField.getId() : null)) {
                break;
            }
        }
        if (!(t3 instanceof CharParameter)) {
            t3 = null;
        }
        T t7 = t3;
        if (t7 != null) {
            str = (String) t7.getValue();
        }
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        return access$getProfileApi$p.registerSocial(session2, str3, access$cleanFormatting, str2, true, null, null, null).flatMap(new b(this)).observeOn(ContactInfoSlotWrapper.access$getSchedulers$p(this.a).mainThread()).map(new c(this));
    }
}
