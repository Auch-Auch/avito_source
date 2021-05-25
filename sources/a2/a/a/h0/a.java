package a2.a.a.h0;

import com.avito.android.contact_access.ContactAccessPackagePresenterImpl;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<ContactAccessPackage> {
    public final /* synthetic */ ContactAccessPackagePresenterImpl a;

    public a(ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl) {
        this.a = contactAccessPackagePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ContactAccessPackage contactAccessPackage) {
        ContactAccessPackage contactAccessPackage2 = contactAccessPackage;
        this.a.e = null;
        this.a.c = contactAccessPackage2;
        ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(contactAccessPackage2, "it");
        ContactAccessPackagePresenterImpl.access$finishLoading(contactAccessPackagePresenterImpl, contactAccessPackage2);
    }
}
