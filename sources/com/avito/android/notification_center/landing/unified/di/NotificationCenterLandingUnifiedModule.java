package com.avito.android.notification_center.landing.unified.di;

import a2.b.a.a.a;
import com.avito.android.di.PerActivity;
import com.avito.android.di.ViewedAdvertsModule;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractor;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedInteractorImpl;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenter;
import com.avito.android.notification_center.landing.unified.NotificationCenterLandingUnifiedPresenterImpl;
import com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverter;
import com.avito.android.notification_center.landing.unified.NotificationsCenterLandingUnifiedConverterImpl;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertBlueprint;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItem;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertItemView;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenter;
import com.avito.android.notification_center.landing.unified.advert.UnifiedAdvertPresenterImpl;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonBlueprint;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonItem;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonPresenter;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonPresenterImpl;
import com.avito.android.notification_center.landing.unified.button.UnifiedButtonView;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionBlueprint;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionItem;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionPresenter;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionPresenterImpl;
import com.avito.android.notification_center.landing.unified.description.UnifiedDescriptionView;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerBlueprint;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerItem;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerPresenter;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerPresenterImpl;
import com.avito.android.notification_center.landing.unified.divider.UnifiedDividerView;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageBlueprint;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageItem;
import com.avito.android.notification_center.landing.unified.image.UnifiedImagePresenter;
import com.avito.android.notification_center.landing.unified.image.UnifiedImagePresenterImpl;
import com.avito.android.notification_center.landing.unified.image.UnifiedImageView;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonBlueprint;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonItem;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonPresenter;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonPresenterImpl;
import com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceBlueprint;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceItem;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpacePresenter;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpacePresenterImpl;
import com.avito.android.notification_center.landing.unified.space.UnifiedSpaceView;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleBlueprint;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItem;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItemView;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitlePresenter;
import com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitlePresenterImpl;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleBlueprint;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleItem;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitlePresenter;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitlePresenterImpl;
import com.avito.android.notification_center.landing.unified.title.UnifiedTitleView;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.FavoriteStatusResolverImpl;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006JW\u0010\u001c\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedModule;", "", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$notification_center_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertBlueprint;", "advertBlueprint", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonBlueprint;", "buttonBlueprint", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionBlueprint;", "descriptionBlueprint", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerBlueprint;", "dividerBlueprint", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageBlueprint;", "imageBlueprint", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonBlueprint;", "pairButtonBlueprint", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceBlueprint;", "spaceBlueprint", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleBlueprint;", "subtitleBlueprint", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleBlueprint;", "titleBlueprint", "provideItemBinder$notification_center_release", "(Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertBlueprint;Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonBlueprint;Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionBlueprint;Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerBlueprint;Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageBlueprint;Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonBlueprint;Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceBlueprint;Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleBlueprint;Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "notification-center_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsModule.class, Declarations.class})
public final class NotificationCenterLandingUnifiedModule {
    @NotNull
    public static final NotificationCenterLandingUnifiedModule INSTANCE = new NotificationCenterLandingUnifiedModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\b\u001a\u00020\u001bH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\b\u001a\u00020$H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J#\u00100\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0\t2\u0006\u0010\b\u001a\u00020-H'¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u0002032\u0006\u0010\u0003\u001a\u000202H'¢\u0006\u0004\b4\u00105J#\u00109\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080\t2\u0006\u0010\b\u001a\u000206H'¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020;H'¢\u0006\u0004\b=\u0010>J#\u0010B\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0\t2\u0006\u0010\b\u001a\u00020?H'¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020E2\u0006\u0010\u0003\u001a\u00020DH'¢\u0006\u0004\bF\u0010GJ#\u0010K\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0\t2\u0006\u0010\b\u001a\u00020HH'¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020N2\u0006\u0010\u0003\u001a\u00020MH'¢\u0006\u0004\bO\u0010PJ#\u0010T\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020S0\t2\u0006\u0010\b\u001a\u00020QH'¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020W2\u0006\u0010\u0003\u001a\u00020VH'¢\u0006\u0004\bX\u0010YJ\u0017\u0010]\u001a\u00020\\2\u0006\u0010[\u001a\u00020ZH'¢\u0006\u0004\b]\u0010^J\u0017\u0010b\u001a\u00020a2\u0006\u0010`\u001a\u00020_H'¢\u0006\u0004\bb\u0010cJ\u0017\u0010g\u001a\u00020f2\u0006\u0010e\u001a\u00020dH'¢\u0006\u0004\bg\u0010hJ\u0017\u0010l\u001a\u00020k2\u0006\u0010j\u001a\u00020iH'¢\u0006\u0004\bl\u0010mJ\u0017\u0010p\u001a\u00020o2\u0006\u0010\u0003\u001a\u00020nH'¢\u0006\u0004\bp\u0010q¨\u0006r"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/di/NotificationCenterLandingUnifiedModule$Declarations;", "", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenterImpl;", "presenter", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "bindUnifiedAdvertPresenter", "(Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertPresenter;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItemView;", "Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertItem;", "bindUnifiedAdvertBlueprint", "(Lcom/avito/android/notification_center/landing/unified/advert/UnifiedAdvertBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonPresenter;", "bindUnifiedButtonPresenter", "(Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonPresenter;", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonBlueprint;", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonView;", "Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonItem;", "bindUnifiedButtonBlueprint", "(Lcom/avito/android/notification_center/landing/unified/button/UnifiedButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenter;", "bindUnifiedDescriptionPresenter", "(Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenter;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionBlueprint;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionView;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionItem;", "bindUnifiedDescriptionBlueprint", "(Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerPresenter;", "bindUnifiedDividerPresenter", "(Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerPresenter;", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerBlueprint;", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerView;", "Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerItem;", "bindUnifiedDividerBlueprint", "(Lcom/avito/android/notification_center/landing/unified/divider/UnifiedDividerBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImagePresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImagePresenter;", "bindUnifiedImagePresenter", "(Lcom/avito/android/notification_center/landing/unified/image/UnifiedImagePresenterImpl;)Lcom/avito/android/notification_center/landing/unified/image/UnifiedImagePresenter;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageBlueprint;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageView;", "Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageItem;", "bindUnifiedImageBlueprint", "(Lcom/avito/android/notification_center/landing/unified/image/UnifiedImageBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenter;", "bindUnifiedPairButtonPresenter", "(Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonPresenter;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonBlueprint;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonView;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonItem;", "bindUnifiedPairButtonBlueprint", "(Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpacePresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpacePresenter;", "bindUnifiedSpacePresenter", "(Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpacePresenterImpl;)Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpacePresenter;", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceBlueprint;", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceView;", "Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceItem;", "bindUnifiedSpaceBlueprint", "(Lcom/avito/android/notification_center/landing/unified/space/UnifiedSpaceBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitlePresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitlePresenter;", "bindUnifiedSubtitlePresenter", "(Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitlePresenterImpl;)Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitlePresenter;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleBlueprint;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItemView;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItem;", "bindUnifiedSubtitleBlueprint", "(Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitlePresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitlePresenter;", "bindUnifiedTitlePresenter", "(Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitlePresenterImpl;)Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitlePresenter;", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleBlueprint;", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleView;", "Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleItem;", "bindUnifiedTitleBlueprint", "(Lcom/avito/android/notification_center/landing/unified/title/UnifiedTitleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "bindFavoriteAdvertsPresenter", "(Lcom/avito/android/favorite/FavoriteAdvertsPresenterImpl;)Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "bindFavoriteAdvertsResourceProvider", "(Lcom/avito/android/favorite/FavoriteAdvertsResourceProviderImpl;)Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;", "resolver", "Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "bindFavoriteStatusResolver", "(Lcom/avito/android/serp/adapter/FavoriteStatusResolverImpl;)Lcom/avito/android/serp/adapter/FavoriteStatusResolver;", "Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverterImpl;", "converter", "Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", "bindNotificationsCenterLandingUnifiedConverter", "(Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverterImpl;)Lcom/avito/android/notification_center/landing/unified/NotificationsCenterLandingUnifiedConverter;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractorImpl;", "interactor", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;", "bindNotificationCenterLandingUnifiedInteractor", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractorImpl;)Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedInteractor;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "bindNotificationCenterLandingUnifiedPresenter", "(Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenterImpl;)Lcom/avito/android/notification_center/landing/unified/NotificationCenterLandingUnifiedPresenter;", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        FavoriteAdvertsPresenter bindFavoriteAdvertsPresenter(@NotNull FavoriteAdvertsPresenterImpl favoriteAdvertsPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        FavoriteAdvertsResourceProvider bindFavoriteAdvertsResourceProvider(@NotNull FavoriteAdvertsResourceProviderImpl favoriteAdvertsResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        FavoriteStatusResolver bindFavoriteStatusResolver(@NotNull FavoriteStatusResolverImpl favoriteStatusResolverImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterLandingUnifiedInteractor bindNotificationCenterLandingUnifiedInteractor(@NotNull NotificationCenterLandingUnifiedInteractorImpl notificationCenterLandingUnifiedInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationCenterLandingUnifiedPresenter bindNotificationCenterLandingUnifiedPresenter(@NotNull NotificationCenterLandingUnifiedPresenterImpl notificationCenterLandingUnifiedPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        NotificationsCenterLandingUnifiedConverter bindNotificationsCenterLandingUnifiedConverter(@NotNull NotificationsCenterLandingUnifiedConverterImpl notificationsCenterLandingUnifiedConverterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedAdvertItemView, UnifiedAdvertItem> bindUnifiedAdvertBlueprint(@NotNull UnifiedAdvertBlueprint unifiedAdvertBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedAdvertPresenter bindUnifiedAdvertPresenter(@NotNull UnifiedAdvertPresenterImpl unifiedAdvertPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedButtonView, UnifiedButtonItem> bindUnifiedButtonBlueprint(@NotNull UnifiedButtonBlueprint unifiedButtonBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedButtonPresenter bindUnifiedButtonPresenter(@NotNull UnifiedButtonPresenterImpl unifiedButtonPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedDescriptionView, UnifiedDescriptionItem> bindUnifiedDescriptionBlueprint(@NotNull UnifiedDescriptionBlueprint unifiedDescriptionBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedDescriptionPresenter bindUnifiedDescriptionPresenter(@NotNull UnifiedDescriptionPresenterImpl unifiedDescriptionPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedDividerView, UnifiedDividerItem> bindUnifiedDividerBlueprint(@NotNull UnifiedDividerBlueprint unifiedDividerBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedDividerPresenter bindUnifiedDividerPresenter(@NotNull UnifiedDividerPresenterImpl unifiedDividerPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedImageView, UnifiedImageItem> bindUnifiedImageBlueprint(@NotNull UnifiedImageBlueprint unifiedImageBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedImagePresenter bindUnifiedImagePresenter(@NotNull UnifiedImagePresenterImpl unifiedImagePresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedPairButtonView, UnifiedPairButtonItem> bindUnifiedPairButtonBlueprint(@NotNull UnifiedPairButtonBlueprint unifiedPairButtonBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedPairButtonPresenter bindUnifiedPairButtonPresenter(@NotNull UnifiedPairButtonPresenterImpl unifiedPairButtonPresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedSpaceView, UnifiedSpaceItem> bindUnifiedSpaceBlueprint(@NotNull UnifiedSpaceBlueprint unifiedSpaceBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedSpacePresenter bindUnifiedSpacePresenter(@NotNull UnifiedSpacePresenterImpl unifiedSpacePresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedSubtitleItemView, UnifiedSubtitleItem> bindUnifiedSubtitleBlueprint(@NotNull UnifiedSubtitleBlueprint unifiedSubtitleBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedSubtitlePresenter bindUnifiedSubtitlePresenter(@NotNull UnifiedSubtitlePresenterImpl unifiedSubtitlePresenterImpl);

        @Binds
        @NotNull
        @PerActivity
        ItemBlueprint<UnifiedTitleView, UnifiedTitleItem> bindUnifiedTitleBlueprint(@NotNull UnifiedTitleBlueprint unifiedTitleBlueprint);

        @PerActivity
        @Binds
        @NotNull
        UnifiedTitlePresenter bindUnifiedTitlePresenter(@NotNull UnifiedTitlePresenterImpl unifiedTitlePresenterImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$notification_center_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ItemBinder provideItemBinder$notification_center_release(@NotNull UnifiedAdvertBlueprint unifiedAdvertBlueprint, @NotNull UnifiedButtonBlueprint unifiedButtonBlueprint, @NotNull UnifiedDescriptionBlueprint unifiedDescriptionBlueprint, @NotNull UnifiedDividerBlueprint unifiedDividerBlueprint, @NotNull UnifiedImageBlueprint unifiedImageBlueprint, @NotNull UnifiedPairButtonBlueprint unifiedPairButtonBlueprint, @NotNull UnifiedSpaceBlueprint unifiedSpaceBlueprint, @NotNull UnifiedSubtitleBlueprint unifiedSubtitleBlueprint, @NotNull UnifiedTitleBlueprint unifiedTitleBlueprint) {
        Intrinsics.checkNotNullParameter(unifiedAdvertBlueprint, "advertBlueprint");
        Intrinsics.checkNotNullParameter(unifiedButtonBlueprint, "buttonBlueprint");
        Intrinsics.checkNotNullParameter(unifiedDescriptionBlueprint, "descriptionBlueprint");
        Intrinsics.checkNotNullParameter(unifiedDividerBlueprint, "dividerBlueprint");
        Intrinsics.checkNotNullParameter(unifiedImageBlueprint, "imageBlueprint");
        Intrinsics.checkNotNullParameter(unifiedPairButtonBlueprint, "pairButtonBlueprint");
        Intrinsics.checkNotNullParameter(unifiedSpaceBlueprint, "spaceBlueprint");
        Intrinsics.checkNotNullParameter(unifiedSubtitleBlueprint, "subtitleBlueprint");
        Intrinsics.checkNotNullParameter(unifiedTitleBlueprint, "titleBlueprint");
        return new ItemBinder.Builder().registerItem(unifiedAdvertBlueprint).registerItem(unifiedButtonBlueprint).registerItem(unifiedDescriptionBlueprint).registerItem(unifiedDividerBlueprint).registerItem(unifiedImageBlueprint).registerItem(unifiedPairButtonBlueprint).registerItem(unifiedSpaceBlueprint).registerItem(unifiedSubtitleBlueprint).registerItem(unifiedTitleBlueprint).build();
    }
}
