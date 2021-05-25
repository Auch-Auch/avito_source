package com.avito.android.profile.edit;

import android.content.res.Resources;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/profile/edit/LocationInteractorResourceProviderImpl;", "Lcom/avito/android/profile/edit/LocationInteractorResourceProvider;", "", "getDistricts", "()Ljava/lang/String;", "districts", "getDirection", "direction", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getMetro", "metro", "<init>", "(Landroid/content/res/Resources;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class LocationInteractorResourceProviderImpl implements LocationInteractorResourceProvider {
    public final Resources a;

    public LocationInteractorResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.profile.edit.LocationInteractorResourceProvider
    @NotNull
    public String getDirection() {
        String string = this.a.getString(R.string.direction);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.direction)");
        return string;
    }

    @Override // com.avito.android.profile.edit.LocationInteractorResourceProvider
    @NotNull
    public String getDistricts() {
        String string = this.a.getString(R.string.districts);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.districts)");
        return string;
    }

    @Override // com.avito.android.profile.edit.LocationInteractorResourceProvider
    @NotNull
    public String getMetro() {
        String string = this.a.getString(R.string.metro);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.metro)");
        return string;
    }
}
