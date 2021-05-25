package com.avito.android.public_profile.ui;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileResourceProviderImpl;", "Lcom/avito/android/public_profile/ui/PublicProfileResourceProvider;", "Lcom/avito/android/public_profile/ui/SubscriptionsResourceProvider;", "", "phoneConfirmed", "()Ljava/lang/String;", "emailConfirmed", "phoneAndEmailConfirmed", "delimiter", "subscribe", "unsubscribe", "notificationSettings", "notificationsEnabled", "notificationsDisabled", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileResourceProviderImpl implements PublicProfileResourceProvider, SubscriptionsResourceProvider {
    public final Resources a;

    @Inject
    public PublicProfileResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileResourceProvider
    @NotNull
    public String delimiter() {
        StringBuilder I = a.I(' ');
        I.append(this.a.getString(R.string.tab_delimiter));
        I.append(' ');
        return I.toString();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileResourceProvider
    @NotNull
    public String emailConfirmed() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.connection_confirmed_email);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…nnection_confirmed_email)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationSettings() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.notification_settings_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ification_settings_title)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationsDisabled() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.public_profile_notifications_disabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…e_notifications_disabled)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String notificationsEnabled() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.public_profile_notifications_enabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…le_notifications_enabled)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileResourceProvider
    @NotNull
    public String phoneAndEmailConfirmed() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.connection_confirmed_phone_and_email);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…onfirmed_phone_and_email)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileResourceProvider
    @NotNull
    public String phoneConfirmed() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.connection_confirmed_phone);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…nnection_confirmed_phone)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String subscribe() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.public_profile_subscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…public_profile_subscribe)");
        return string;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsResourceProvider
    @NotNull
    public String unsubscribe() {
        String string = this.a.getString(com.avito.android.public_profile_stuff.R.string.public_profile_unsubscribe);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…blic_profile_unsubscribe)");
        return string;
    }
}
