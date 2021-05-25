package com.avito.android.publish.slots.profile_info;

import android.content.res.Resources;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProviderImpl;", "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "", "getShopSubtitle", "()Ljava/lang/String;", "getCompanySubtitle", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishContactsStringProviderImpl implements PublishContactsStringProvider {
    public final Resources a;

    public PublishContactsStringProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.publish.slots.profile_info.PublishContactsStringProvider
    @NotNull
    public String getCompanySubtitle() {
        String string = this.a.getString(R.string.reg_company);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.reg_company)");
        return string;
    }

    @Override // com.avito.android.publish.slots.profile_info.PublishContactsStringProvider
    @NotNull
    public String getShopSubtitle() {
        String string = this.a.getString(R.string.publish_contacts_shop_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…lish_contacts_shop_title)");
        return string;
    }
}
