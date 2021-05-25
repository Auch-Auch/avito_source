package com.avito.android.shared_providers;

import android.content.res.Resources;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.resource_providers.R;
import com.avito.android.util.BuildInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/shared_providers/SupportEmailResourceProviderImpl;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "", "getUserEmail", "()Ljava/lang/String;", "userEmail", "Lcom/avito/android/profile/ProfileInfoStorage;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "getSupportEmailText", "supportEmailText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getSupportEmailAddress", "supportEmailAddress", "Lcom/avito/android/util/BuildInfo;", "c", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/util/BuildInfo;)V", "resource-providers_release"}, k = 1, mv = {1, 4, 2})
public final class SupportEmailResourceProviderImpl implements SupportEmailResourceProvider {
    public final Resources a;
    public final ProfileInfoStorage b;
    public final BuildInfo c;

    @Inject
    public SupportEmailResourceProviderImpl(@NotNull Resources resources, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.a = resources;
        this.b = profileInfoStorage;
        this.c = buildInfo;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailAddress() {
        String string = this.a.getString(R.string.support_email_address);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ng.support_email_address)");
        return string;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @NotNull
    public String getSupportEmailText() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n_______\n");
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder()\n            .append(\"\\n_______\\n\")");
        sb.append(this.a.getString(R.string.support_email_disclaimer));
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        StringBuilder appendln = i.appendln(sb);
        appendln.append(this.a.getString(R.string.support_email_device_model, this.c.getModel()));
        Intrinsics.checkNotNullExpressionValue(appendln, "append(value)");
        StringBuilder appendln2 = i.appendln(appendln);
        appendln2.append(this.a.getString(R.string.support_email_os_version, this.c.getVersion()));
        Intrinsics.checkNotNullExpressionValue(appendln2, "append(value)");
        StringBuilder appendln3 = i.appendln(appendln2);
        appendln3.append(this.a.getString(R.string.support_email_app_version, this.c.getVersionName()));
        Intrinsics.checkNotNullExpressionValue(appendln3, "append(value)");
        StringBuilder appendln4 = i.appendln(appendln3);
        if (getUserEmail() != null) {
            appendln4.append(this.a.getString(R.string.support_email_user, getUserEmail()));
            Intrinsics.checkNotNullExpressionValue(appendln4, "append(value)");
            i.appendln(appendln4);
        }
        appendln4.append("_______");
        Intrinsics.checkNotNullExpressionValue(appendln4, "append(value)");
        String sb2 = i.appendln(appendln4).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "text.appendln(\"_______\")\n            .toString()");
        return sb2;
    }

    @Override // com.avito.android.shared_providers.SupportEmailResourceProvider
    @Nullable
    public String getUserEmail() {
        return this.b.getProfileInfo().getEmail();
    }
}
