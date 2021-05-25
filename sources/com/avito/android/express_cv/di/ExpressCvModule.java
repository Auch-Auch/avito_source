package com.avito.android.express_cv.di;

import android.app.Activity;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.blueprints.publish.SelectItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.epress_cv.remote.ExpressCvApi;
import com.avito.android.express_cv.ExistedCvDataProvider;
import com.avito.android.express_cv.ExpressCvDataConverter;
import com.avito.android.express_cv.ExpressCvDataConverterImpl;
import com.avito.android.express_cv.ExpressCvRepository;
import com.avito.android.express_cv.ExpressCvRepositoryImpl;
import com.avito.android.express_cv.ExpressCvResourceProvider;
import com.avito.android.express_cv.ExpressCvResourceProviderImpl;
import com.avito.android.express_cv.ExpressCvViewModel;
import com.avito.android.express_cv.ExpressCvViewModelFactory;
import com.avito.android.express_cv.ExpressCvViewModelImpl;
import com.avito.android.express_cv.NewCvDataProvider;
import com.avito.android.express_cv.ParametersConverter;
import com.avito.android.express_cv.ParametersConverterImpl;
import com.avito.android.express_cv.existed_cv.item.CvItemClickListener;
import com.avito.android.express_cv.existed_cv.item.DisclaimerBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonBlueprint;
import com.avito.android.express_cv.existed_cv.item.FlatButtonPresenter;
import com.avito.android.express_cv.existed_cv.item.TextItemBlueprint;
import com.avito.android.express_cv.existed_cv.item.TextItemPresenter;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.CvTabLayoutAdapter;
import com.avito.android.express_cv.tabs.TabPagerAdapter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.LocalPretendInteractorImpl;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorImpl;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ParametersValidatorResourceProviderImpl;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0012\u0012\u0007\u0010\u0001\u001a\u00020a¢\u0006\u0006\b\u0001\u0010\u0001JW\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J/\u00106\u001a\u00020,2\u0006\u00101\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u0002002\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020<2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020?2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020B2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001a\u00020E2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020H2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00102\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\"2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bM\u0010NJ\u000f\u0010R\u001a\u00020OH\u0001¢\u0006\u0004\bP\u0010QJ\u0017\u0010V\u001a\u00020S2\u0006\u0010\u001b\u001a\u00020OH\u0001¢\u0006\u0004\bT\u0010UJ\u001d\u0010Z\u001a\u00020Y2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020E0WH\u0007¢\u0006\u0004\bZ\u0010[J\u0017\u0010^\u001a\u00020]2\u0006\u0010\\\u001a\u00020YH\u0007¢\u0006\u0004\b^\u0010_JO\u0010j\u001a\u00020i2\u000e\b\u0001\u0010b\u001a\b\u0012\u0004\u0012\u00020a0`2\u0006\u0010d\u001a\u00020c2\u0006\u0010f\u001a\u00020e2\u0006\u00109\u001a\u0002082\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00105\u001a\u0002042\u0006\u0010h\u001a\u00020gH\u0007¢\u0006\u0004\bj\u0010kJ\u001f\u0010m\u001a\u00020'2\u0006\u0010l\u001a\u00020\u00142\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001a\u00020o2\u0006\u0010(\u001a\u00020'H\u0007¢\u0006\u0004\bp\u0010qJ\u001f\u0010s\u001a\u00020\u00062\u0006\u0010r\u001a\u00020i2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\bs\u0010tJ'\u0010y\u001a\u00020\u00042\u0006\u0010v\u001a\u00020u2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010x\u001a\u00020wH\u0007¢\u0006\u0004\by\u0010zJ1\u0010\u0001\u001a\u00030\u00012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020|0{2\u0006\u0010\u001a\u00020~2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J)\u0010\u0001\u001a\u00030\u00012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020|0{2\u0006\u00109\u001a\u000208H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020|0{H\u0007¢\u0006\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/express_cv/di/ExpressCvModule;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/express_cv/ExpressCvRepository;", "repository", "Lcom/avito/android/express_cv/ExpressCvDataConverter;", "expressCvDataConverter", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/express_cv/ParametersConverter;", "categoryParametersConverter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/express_cv/ExpressCvResourceProvider;", "expressCvResourceProvider", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/express_cv/ExpressCvViewModelFactory;", "providerViewModelFactory", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/express_cv/ExpressCvRepository;Lcom/avito/android/express_cv/ExpressCvDataConverter;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/express_cv/ParametersConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/express_cv/ExpressCvResourceProvider;Lcom/avito/android/Features;)Lcom/avito/android/express_cv/ExpressCvViewModelFactory;", "provideCategoryParametersConverter$express_cv_release", "()Lcom/avito/android/express_cv/ParametersConverter;", "provideCategoryParametersConverter", "Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "itemPresenter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "provideDisclaimerBlueprint$express_cv_release", "(Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/express_cv/existed_cv/item/DisclaimerBlueprint;", "provideDisclaimerBlueprint", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "onDeepLinkClickListener", "provideDisclaimerItemPresenter$express_cv_release", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)Lcom/avito/android/component/disclaimer/DisclaimerItemPresenter;", "provideDisclaimerItemPresenter", "Lcom/avito/android/express_cv/ExpressCvViewModelImpl;", "viewModel", "Lcom/avito/android/express_cv/ExistedCvDataProvider;", "provideCvData", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/express_cv/ExistedCvDataProvider;", "Lcom/avito/android/validation/ParametersValidator;", "validator", "provideLocalPretendInteractor", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "provideParametersValidator", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "Landroid/app/Activity;", "activity", "provideLocalPretendInteractorResourceProvider", "(Landroid/app/Activity;)Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", "provideSelectItemPresenterListener", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/blueprints/publish/SelectItemPresenter$ClickListener;", "Lcom/avito/android/express_cv/NewCvDataProvider;", "provideNewCvDataProvider", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/express_cv/NewCvDataProvider;", "Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", "provideCvItemClickListener", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/express_cv/existed_cv/item/CvItemClickListener;", "Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "proviveButtonItemPresenterListener", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/blueprints/ButtonItemPresenter$Listener;", "Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "providePrimaryParametersListener", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "provideExpressCvResourceProviderImpl", "(Landroid/app/Activity;)Lcom/avito/android/express_cv/ExpressCvResourceProvider;", "provideDeepLinkClickListener", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/express_cv/existed_cv/item/TextItemPresenter;", "provideTextItemPresenter$express_cv_release", "()Lcom/avito/android/express_cv/existed_cv/item/TextItemPresenter;", "provideTextItemPresenter", "Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "provideTextItemBlueprint$express_cv_release", "(Lcom/avito/android/express_cv/existed_cv/item/TextItemPresenter;)Lcom/avito/android/express_cv/existed_cv/item/TextItemBlueprint;", "provideTextItemBlueprint", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonPresenter;", "provideFlatButtonPresenter", "(Ldagger/Lazy;)Lcom/avito/android/express_cv/existed_cv/item/FlatButtonPresenter;", "presenter", "Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "provideFlatButtonBlueprint", "(Lcom/avito/android/express_cv/existed_cv/item/FlatButtonPresenter;)Lcom/avito/android/express_cv/existed_cv/item/FlatButtonBlueprint;", "Lcom/avito/android/util/Formatter;", "", "phoneFormatter", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "provideElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/app/Activity;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "factory", "provideViewModelImpl", "(Lcom/avito/android/express_cv/ExpressCvViewModelFactory;Landroid/app/Activity;)Lcom/avito/android/express_cv/ExpressCvViewModelImpl;", "Lcom/avito/android/express_cv/ExpressCvViewModel;", "provideViewModel", "(Lcom/avito/android/express_cv/ExpressCvViewModelImpl;)Lcom/avito/android/express_cv/ExpressCvViewModel;", "elementConverter", "provideExpressCvDataConverter", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/Features;)Lcom/avito/android/express_cv/ExpressCvDataConverter;", "Lcom/avito/android/epress_cv/remote/ExpressCvApi;", "api", "Lru/avito/messenger/api/AvitoMessengerApi;", "messengerApi", "provideRepository", "(Lcom/avito/android/epress_cv/remote/ExpressCvApi;Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/api/AvitoMessengerApi;)Lcom/avito/android/express_cv/ExpressCvRepository;", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "tabsDataProvider", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "provideTabLayoutAdapterProvider", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/android/util/DeviceMetrics;Landroid/app/Activity;)Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "Lcom/avito/android/express_cv/tabs/TabPagerAdapter;", "provideTabPagerAdapterProvider", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/app/Activity;)Lcom/avito/android/express_cv/tabs/TabPagerAdapter;", "provideTabsDataProvider", "()Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "context", "<init>", "(Ljava/lang/String;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, DialogRouterModule.class, AttributedTextFormatterModule.class})
public final class ExpressCvModule {
    public final String a;

    public ExpressCvModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "context");
        this.a = str;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ParametersConverter provideCategoryParametersConverter$express_cv_release() {
        return new ParametersConverterImpl(null, 1, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExistedCvDataProvider provideCvData(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final CvItemClickListener provideCvItemClickListener(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final OnDeepLinkClickListener provideDeepLinkClickListener(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final DisclaimerBlueprint provideDisclaimerBlueprint$express_cv_release(@NotNull DisclaimerItemPresenter disclaimerItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(disclaimerItemPresenter, "itemPresenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new DisclaimerBlueprint(disclaimerItemPresenter, attributedTextFormatter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DisclaimerItemPresenter provideDisclaimerItemPresenter$express_cv_release(@NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, "onDeepLinkClickListener");
        return new DisclaimerItemPresenter(onDeepLinkClickListener);
    }

    @Provides
    @NotNull
    @PerActivity
    public final CategoryParametersElementConverter provideElementConverter(@PhoneNumberFormatterModule.NationalPhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Activity activity, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return new CategoryParametersElementConverter(formatter, resources, timeSource, false, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 984, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvDataConverter provideExpressCvDataConverter(@NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ExpressCvDataConverterImpl(categoryParametersElementConverter, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvResourceProvider provideExpressCvResourceProviderImpl(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return new ExpressCvResourceProviderImpl(resources);
    }

    @Provides
    @PerActivity
    @NotNull
    public final FlatButtonBlueprint provideFlatButtonBlueprint(@NotNull FlatButtonPresenter flatButtonPresenter) {
        Intrinsics.checkNotNullParameter(flatButtonPresenter, "presenter");
        return new FlatButtonBlueprint(flatButtonPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final FlatButtonPresenter provideFlatButtonPresenter(@NotNull Lazy<ButtonItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new FlatButtonPresenter(lazy);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LocalPretendInteractor provideLocalPretendInteractor(@NotNull ParametersValidator parametersValidator) {
        Intrinsics.checkNotNullParameter(parametersValidator, "validator");
        return new LocalPretendInteractorImpl(parametersValidator);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Resources resources = activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return new ParametersValidatorResourceProviderImpl(resources);
    }

    @Provides
    @PerActivity
    @NotNull
    public final NewCvDataProvider provideNewCvDataProvider(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ParametersValidator provideParametersValidator(@NotNull ParametersValidatorResourceProvider parametersValidatorResourceProvider, @NotNull Features features, @NotNull HtmlRenderer htmlRenderer, @NotNull HtmlCleaner htmlCleaner) {
        Intrinsics.checkNotNullParameter(parametersValidatorResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlRenderer, "htmlRenderer");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        return new ParametersValidatorImpl(parametersValidatorResourceProvider, features, htmlRenderer, htmlCleaner);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PrimaryParametersListener providePrimaryParametersListener(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvRepository provideRepository(@NotNull ExpressCvApi expressCvApi, @NotNull SchedulersFactory schedulersFactory, @NotNull AvitoMessengerApi avitoMessengerApi) {
        Intrinsics.checkNotNullParameter(expressCvApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(avitoMessengerApi, "messengerApi");
        return new ExpressCvRepositoryImpl(this.a, expressCvApi, avitoMessengerApi, schedulersFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SelectItemPresenter.ClickListener provideSelectItemPresenterListener(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @NotNull
    @PerActivity
    public final CvTabLayoutAdapter provideTabLayoutAdapterProvider(@NotNull TabsDataProvider<CvTabItem> tabsDataProvider, @NotNull DeviceMetrics deviceMetrics, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new CvTabLayoutAdapter(tabsDataProvider, activity, deviceMetrics);
    }

    @Provides
    @NotNull
    @PerActivity
    public final TabPagerAdapter provideTabPagerAdapterProvider(@NotNull TabsDataProvider<CvTabItem> tabsDataProvider, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabsDataProvider");
        Intrinsics.checkNotNullParameter(activity, "activity");
        FragmentManager supportFragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "(activity as AppCompatAc…y).supportFragmentManager");
        return new TabPagerAdapter(supportFragmentManager, tabsDataProvider);
    }

    @Provides
    @NotNull
    @PerActivity
    public final TabsDataProvider<CvTabItem> provideTabsDataProvider() {
        return new TabsDataProvider<>();
    }

    @Provides
    @PerActivity
    @NotNull
    public final TextItemBlueprint provideTextItemBlueprint$express_cv_release(@NotNull TextItemPresenter textItemPresenter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "itemPresenter");
        return new TextItemBlueprint(textItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TextItemPresenter provideTextItemPresenter$express_cv_release() {
        return new TextItemPresenter();
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvViewModel provideViewModel(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvViewModelImpl provideViewModelImpl(@NotNull ExpressCvViewModelFactory expressCvViewModelFactory, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(expressCvViewModelFactory, "factory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = ViewModelProviders.of((AppCompatActivity) activity, expressCvViewModelFactory).get(ExpressCvViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (ExpressCvViewModelImpl) viewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final ExpressCvViewModelFactory providerViewModelFactory(@NotNull SchedulersFactory schedulersFactory, @NotNull ExpressCvRepository expressCvRepository, @NotNull ExpressCvDataConverter expressCvDataConverter, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull ParametersConverter parametersConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ExpressCvResourceProvider expressCvResourceProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(expressCvRepository, "repository");
        Intrinsics.checkNotNullParameter(expressCvDataConverter, "expressCvDataConverter");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(parametersConverter, "categoryParametersConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deeplinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(expressCvResourceProvider, "expressCvResourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ExpressCvViewModelFactory(this.a, schedulersFactory, expressCvRepository, expressCvDataConverter, localPretendInteractor, parametersConverter, deepLinkIntentFactory, activityIntentFactory, expressCvResourceProvider, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ButtonItemPresenter.Listener proviveButtonItemPresenterListener(@NotNull ExpressCvViewModelImpl expressCvViewModelImpl) {
        Intrinsics.checkNotNullParameter(expressCvViewModelImpl, "viewModel");
        return expressCvViewModelImpl;
    }
}
