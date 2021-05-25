package com.avito.android.di.module;

import android.content.res.Resources;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpItemAligner;
import com.avito.android.serp.adapter.SerpItemAlignerImpl;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.ui_components.R;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/module/SpanAdapterModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideSpannedGridPositionProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSerpSpanProvider", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroid/content/res/Resources;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "<init>", "()V", "Declarations", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SpanAdapterModule {
    @NotNull
    public static final SpanAdapterModule INSTANCE = new SpanAdapterModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/di/module/SpanAdapterModule$Declarations;", "", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Lcom/avito/android/serp/adapter/SpanProvider;", "bindSpanProvider", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Lcom/avito/android/serp/adapter/SpanProvider;", "Lcom/avito/android/serp/adapter/SpanLookup;", "lookup", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "bindSpanLookup", "(Lcom/avito/android/serp/adapter/SpanLookup;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "Lcom/avito/android/serp/adapter/SerpItemAlignerImpl;", "aligner", "Lcom/avito/android/serp/adapter/SerpItemAligner;", "bindSerpItemAligner", "(Lcom/avito/android/serp/adapter/SerpItemAlignerImpl;)Lcom/avito/android/serp/adapter/SerpItemAligner;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Reusable
        @Binds
        @NotNull
        SerpItemAligner bindSerpItemAligner(@NotNull SerpItemAlignerImpl serpItemAlignerImpl);

        @Reusable
        @Binds
        @NotNull
        GridLayoutManager.SpanSizeLookup bindSpanLookup(@NotNull SpanLookup spanLookup);

        @Reusable
        @Binds
        @NotNull
        SpanProvider bindSpanProvider(@NotNull SerpSpanProvider serpSpanProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SerpSpanProvider provideSerpSpanProvider(@NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SerpSpanProviderImpl(resources.getInteger(R.integer.serp_columns), spannedGridPositionProvider);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final SpannedGridPositionProvider provideSpannedGridPositionProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new GridPositionProviderImpl(resources.getInteger(R.integer.serp_columns));
    }
}
