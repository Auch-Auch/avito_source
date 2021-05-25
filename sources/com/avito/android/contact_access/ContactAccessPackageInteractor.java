package com.avito.android.contact_access;

import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", "loadPackage", "()Lio/reactivex/Observable;", "", "url", "Lcom/avito/android/remote/model/SuccessResult;", "applyPackage", "(Ljava/lang/String;)Lio/reactivex/Observable;", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface ContactAccessPackageInteractor {
    @NotNull
    Observable<SuccessResult> applyPackage(@NotNull String str);

    @NotNull
    Observable<ContactAccessPackage> loadPackage();
}
