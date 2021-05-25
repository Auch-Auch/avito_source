package com.avito.android.contact_access;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ContactAccessService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/contact_access/PresentationAccessServiceModelImpl;", "Lcom/avito/android/contact_access/PresentationAccessServiceModel;", "", "getServiceTitle", "()Ljava/lang/String;", "getServiceSubtitle", "getName", "getPrice", "Lcom/avito/android/remote/model/ContactAccessService$Service;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/ContactAccessService$Service;", NotificationCompat.CATEGORY_SERVICE, "Lcom/avito/android/remote/model/ContactAccessService;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ContactAccessService;", "domainModel", "<init>", "(Lcom/avito/android/remote/model/ContactAccessService;)V", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public final class PresentationAccessServiceModelImpl implements PresentationAccessServiceModel {
    public final ContactAccessService.Service a;
    public final ContactAccessService b;

    public PresentationAccessServiceModelImpl(@NotNull ContactAccessService contactAccessService) {
        Intrinsics.checkNotNullParameter(contactAccessService, "domainModel");
        this.b = contactAccessService;
        this.a = contactAccessService.getService();
    }

    @Override // com.avito.android.contact_access.PresentationAccessServiceModel
    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override // com.avito.android.contact_access.PresentationAccessServiceModel
    @NotNull
    public String getPrice() {
        return this.a.getPrice();
    }

    @Override // com.avito.android.contact_access.PresentationAccessServiceModel
    @Nullable
    public String getServiceSubtitle() {
        return this.a.getSubtitle();
    }

    @Override // com.avito.android.contact_access.PresentationAccessServiceModel
    @NotNull
    public String getServiceTitle() {
        return this.a.getTitle();
    }
}
