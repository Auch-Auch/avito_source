package com.avito.android.advert.item.similars;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProviderImpl;", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "", "getSpanCount", "()I", "spanCount", "getSimilarColumns", "similarColumns", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertSimilarPresenterResourceProviderImpl implements AdvertSimilarPresenterResourceProvider {
    public final Resources a;

    @Inject
    public AdvertSimilarPresenterResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider
    public int getSimilarColumns() {
        return this.a.getInteger(R.integer.similar_adverts_columns);
    }

    @Override // com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider
    public int getSpanCount() {
        return this.a.getInteger(R.integer.serp_columns);
    }
}
