package com.avito.android.user_advert.advert.feature_teasers;

import android.content.res.Resources;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserResourceProvider;", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "", "isTablet", "()Z", "isLandscape", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsFeatureTeaserResourceProvider implements FeatureTeaserResourceProvider {
    public final Resources a;

    @Inject
    public MyAdvertDetailsFeatureTeaserResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider
    public boolean isLandscape() {
        return this.a.getConfiguration().orientation == 2;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider
    public boolean isTablet() {
        return this.a.getBoolean(R.bool.is_tablet);
    }
}
