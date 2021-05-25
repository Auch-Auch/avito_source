package com.avito.android.contact_access;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.parse.adapter.ContactAccessPackage;
import com.avito.android.ui_components.R;
import com.google.firebase.iid.MessengerIpcClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/contact_access/PresentationCvPackageImpl;", "Lcom/avito/android/contact_access/PresentationCvPackage;", "", "getCountDetails", "()Ljava/lang/String;", "getDetails", "", "getProgressDrawable", "()I", "getMaxValue", "getProgress", "getDescription", "getName", "getTitle", "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;", MessengerIpcClient.KEY_PACKAGE, "<init>", "(Lcom/avito/android/remote/parse/adapter/ContactAccessPackage;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class PresentationCvPackageImpl implements PresentationCvPackage {
    public final ContactAccessPackage a;

    public PresentationCvPackageImpl(@NotNull ContactAccessPackage contactAccessPackage) {
        Intrinsics.checkNotNullParameter(contactAccessPackage, MessengerIpcClient.KEY_PACKAGE);
        this.a = contactAccessPackage;
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    @NotNull
    public String getCountDetails() {
        return this.a.getCountDetails();
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    @NotNull
    public String getDescription() {
        return this.a.getDescription();
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    @NotNull
    public String getDetails() {
        return this.a.getDetails();
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    public int getMaxValue() {
        return 100;
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    public int getProgress() {
        return this.a.getCountPercentage();
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    public int getProgressDrawable() {
        int countPercentage = this.a.getCountPercentage();
        if (countPercentage >= 0 && 20 >= countPercentage) {
            return R.drawable.fees_progress_red;
        }
        if (21 <= countPercentage && 50 >= countPercentage) {
            return R.drawable.fees_progress_orange;
        }
        return R.drawable.fees_progress_green;
    }

    @Override // com.avito.android.contact_access.PresentationCvPackage
    @NotNull
    public String getTitle() {
        return this.a.getTitle();
    }
}
