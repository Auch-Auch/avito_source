package com.avito.android.rating.di;

import com.avito.android.di.PerActivity;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/rating/di/RatingsTnsGalleryClicksModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "providesTnsImageGalleryClicksRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "rating_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class RatingsTnsGalleryClicksModule {
    @NotNull
    public static final RatingsTnsGalleryClicksModule INSTANCE = new RatingsTnsGalleryClicksModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/rating/di/RatingsTnsGalleryClicksModule$Declarations;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindTnsGalleryClicksObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindTnsGalleryClicksConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        Consumer<TnsGalleryItemClickAction> bindTnsGalleryClicksConsumer(@NotNull PublishRelay<TnsGalleryItemClickAction> publishRelay);

        @Binds
        @NotNull
        Observable<TnsGalleryItemClickAction> bindTnsGalleryClicksObservable(@NotNull PublishRelay<TnsGalleryItemClickAction> publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final PublishRelay<TnsGalleryItemClickAction> providesTnsImageGalleryClicksRelay() {
        PublishRelay<TnsGalleryItemClickAction> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
