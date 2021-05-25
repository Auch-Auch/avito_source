package com.avito.android.contact_access;

import com.avito.android.contact_access.remote.ContactAccessApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessPackageInteractorImpl;", "Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "loadPackage", "()Lio/reactivex/Observable;", "", "url", "Lcom/avito/android/remote/model/SuccessResult;", "applyPackage", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/avito/android/contact_access/remote/ContactAccessApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/contact_access/remote/ContactAccessApi;", "api", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "itemId", "<init>", "(Lcom/avito/android/contact_access/remote/ContactAccessApi;Ljava/lang/String;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class ContactAccessPackageInteractorImpl implements ContactAccessPackageInteractor {
    public final ContactAccessApi a;
    public final String b;

    @Inject
    public ContactAccessPackageInteractorImpl(@NotNull ContactAccessApi contactAccessApi, @NotNull String str) {
        Intrinsics.checkNotNullParameter(contactAccessApi, "api");
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.a = contactAccessApi;
        this.b = str;
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageInteractor
    @NotNull
    public Observable<SuccessResult> applyPackage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return InteropKt.toV2(this.a.applyPackage(str));
    }

    @Override // com.avito.android.contact_access.ContactAccessPackageInteractor
    @NotNull
    public Observable<ContactAccessPackage> loadPackage() {
        return InteropKt.toV2(this.a.getContactAccessPackage(this.b));
    }
}
