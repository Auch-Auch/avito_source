package com.avito.android.public_profile.di;

import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.AdvertItemModule;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.ui_components.R;
import com.avito.android.util.preferences.GeoContract;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\bH\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsAdapterModule;", "", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$public_profile_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "provideSpanProvider$public_profile_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", "provideGridPositionProvider$public_profile_release", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DateTimeFormatterModule.class, AdvertItemModule.class})
public final class ProfileAdvertsAdapterModule {
    public final Resources a;

    public ProfileAdvertsAdapterModule(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Provides
    @PerFragment
    @NotNull
    public final SpannedGridPositionProvider provideGridPositionProvider$public_profile_release() {
        return new GridPositionProviderImpl(this.a.getInteger(R.integer.profile_adverts_columns));
    }

    @Provides
    @PerFragment
    @NotNull
    public final GridLayoutManager.SpanSizeLookup provideSpanLookup$public_profile_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final SerpSpanProvider provideSpanProvider$public_profile_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        return new SerpSpanProviderImpl(this.a.getInteger(R.integer.profile_adverts_columns), spannedGridPositionProvider);
    }
}
