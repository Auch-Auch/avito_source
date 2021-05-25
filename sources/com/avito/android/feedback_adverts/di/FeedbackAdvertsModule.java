package com.avito.android.feedback_adverts.di;

import a2.b.a.a.a;
import com.avito.android.di.PerActivity;
import com.avito.android.feedback_adverts.FeedbackAdvertsInteractor;
import com.avito.android.feedback_adverts.FeedbackAdvertsInteractorImpl;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemBluePrint;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenter;
import com.avito.android.feedback_adverts.FeedbackAdvertsItemPresenterImpl;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenter;
import com.avito.android.feedback_adverts.FeedbackAdvertsPresenterImpl;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsModule;", "", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$feedback_adverts_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemBluePrint;", "feedbackAdvertsItemBluePrint", "provideVHFactory$feedback_adverts_release", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemBluePrint;)Lcom/avito/konveyor/ItemBinder;", "provideVHFactory", "Ljava/util/Locale;", "locale", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "provideAdvertPriceFormatter$feedback_adverts_release", "(Ljava/util/Locale;)Lcom/avito/android/util/Formatter;", "provideAdvertPriceFormatter", "<init>", "()V", "Declarations", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class FeedbackAdvertsModule {
    @NotNull
    public static final FeedbackAdvertsModule INSTANCE = new FeedbackAdvertsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\bH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/feedback_adverts/di/FeedbackAdvertsModule$Declarations;", "", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractorImpl;", "implementation", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;", "feedbackAdvertsInteractor", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractorImpl;)Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "feedbackAdvertsPresenter", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterImpl;)Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenterImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter;", "feedbackAdvertsItemPresenter", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenterImpl;)Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter$Listener;", "itemListener", "(Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenter;)Lcom/avito/android/feedback_adverts/FeedbackAdvertsItemPresenter$Listener;", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        FeedbackAdvertsInteractor feedbackAdvertsInteractor(@NotNull FeedbackAdvertsInteractorImpl feedbackAdvertsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        FeedbackAdvertsItemPresenter feedbackAdvertsItemPresenter(@NotNull FeedbackAdvertsItemPresenterImpl feedbackAdvertsItemPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        FeedbackAdvertsPresenter feedbackAdvertsPresenter(@NotNull FeedbackAdvertsPresenterImpl feedbackAdvertsPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        FeedbackAdvertsItemPresenter.Listener itemListener(@NotNull FeedbackAdvertsPresenter feedbackAdvertsPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final AdapterPresenter provideAdapterPresenter$feedback_adverts_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Formatter<AdvertPrice> provideAdvertPriceFormatter$feedback_adverts_release(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return new AdvertPriceFormatter(locale);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ItemBinder provideVHFactory$feedback_adverts_release(@NotNull FeedbackAdvertsItemBluePrint feedbackAdvertsItemBluePrint) {
        Intrinsics.checkNotNullParameter(feedbackAdvertsItemBluePrint, "feedbackAdvertsItemBluePrint");
        return new ItemBinder.Builder().registerItem(feedbackAdvertsItemBluePrint).build();
    }
}
