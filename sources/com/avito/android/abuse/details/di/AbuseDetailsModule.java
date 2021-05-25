package com.avito.android.abuse.details.di;

import com.avito.android.abuse.details.AbuseDetailsInteractor;
import com.avito.android.abuse.details.AbuseDetailsInteractorImpl;
import com.avito.android.abuse.details.AbuseDetailsPresenter;
import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import com.avito.android.abuse.details.AbuseDetailsResourceProvider;
import com.avito.android.abuse.details.AbuseDetailsResourceProviderImpl;
import com.avito.android.abuse.details.adapter.AbuseField;
import com.avito.android.abuse.details.adapter.CommentItemBlueprint;
import com.avito.android.abuse.details.adapter.CommentItemPresenter;
import com.avito.android.abuse.details.adapter.CommentItemPresenterImpl;
import com.avito.android.abuse.details.adapter.EmotionItemBlueprint;
import com.avito.android.abuse.details.adapter.EmotionItemPresenter;
import com.avito.android.abuse.details.adapter.EmotionItemPresenterImpl;
import com.avito.android.abuse.details.adapter.ErrorLabelItemBlueprint;
import com.avito.android.abuse.details.adapter.ErrorLabelItemPresenter;
import com.avito.android.abuse.details.adapter.ErrorLabelItemPresenterImpl;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemBlueprint;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemPresenter;
import com.avito.android.abuse.details.adapter.PrimaryButtonItemPresenterImpl;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemBlueprint;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemPresenter;
import com.avito.android.abuse.details.adapter.SecondaryButtonItemPresenterImpl;
import com.avito.android.abuse.details.adapter.SendingSuccessItemBlueprint;
import com.avito.android.abuse.details.adapter.SendingSuccessItemPresenter;
import com.avito.android.abuse.details.adapter.SendingSuccessItemPresenterImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.PerActivity;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\b\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020&H'¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010\b\u001a\u00020)H'¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020-H'¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u0010\b\u001a\u000200H'¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u000204H'¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u0010\b\u001a\u000207H'¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001a\u00020;H'¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020?2\u0006\u0010\b\u001a\u00020>H'¢\u0006\u0004\b@\u0010AJ%\u0010F\u001a\b\u0012\u0004\u0012\u00020C0E2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020C0BH'¢\u0006\u0004\bF\u0010GJ%\u0010I\u001a\b\u0012\u0004\u0012\u00020C0H2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020C0BH'¢\u0006\u0004\bI\u0010JJ%\u0010L\u001a\b\u0012\u0004\u0012\u00020K0E2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020K0BH'¢\u0006\u0004\bL\u0010GJ%\u0010M\u001a\b\u0012\u0004\u0012\u00020K0H2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020K0BH'¢\u0006\u0004\bM\u0010JJ%\u0010N\u001a\b\u0012\u0004\u0012\u00020K0E2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020K0BH'¢\u0006\u0004\bN\u0010GJ%\u0010O\u001a\b\u0012\u0004\u0012\u00020K0H2\u000e\b\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020K0BH'¢\u0006\u0004\bO\u0010J¨\u0006P"}, d2 = {"Lcom/avito/android/abuse/details/di/AbuseDetailsModule;", "", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/abuse/details/AbuseDetailsPresenterImpl;", "presenter", "Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "bindPresenter", "(Lcom/avito/android/abuse/details/AbuseDetailsPresenterImpl;)Lcom/avito/android/abuse/details/AbuseDetailsPresenter;", "Lcom/avito/android/abuse/details/AbuseDetailsInteractorImpl;", "interactor", "Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "bindInteractor", "(Lcom/avito/android/abuse/details/AbuseDetailsInteractorImpl;)Lcom/avito/android/abuse/details/AbuseDetailsInteractor;", "Lcom/avito/android/abuse/details/AbuseDetailsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/abuse/details/AbuseDetailsResourceProviderImpl;)Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;", "Lcom/avito/android/abuse/details/adapter/CommentItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindCommentItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/CommentItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/CommentItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/CommentItemPresenter;", "bindCommentItemPresenter", "(Lcom/avito/android/abuse/details/adapter/CommentItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/CommentItemPresenter;", "Lcom/avito/android/abuse/details/adapter/EmotionItemBlueprint;", "bindEmotionItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/EmotionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/EmotionItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/EmotionItemPresenter;", "bindEmotionItemPresenter", "(Lcom/avito/android/abuse/details/adapter/EmotionItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/EmotionItemPresenter;", "Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemBlueprint;", "bindPrimaryButtonItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemPresenter;", "bindPrimaryButtonItemPresenter", "(Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/PrimaryButtonItemPresenter;", "Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemBlueprint;", "bindSecondaryButtonItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemPresenter;", "bindSecondaryButtonItemPresenter", "(Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/SecondaryButtonItemPresenter;", "Lcom/avito/android/abuse/details/adapter/SendingSuccessItemBlueprint;", "bindSendingSuccessItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/SendingSuccessItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/SendingSuccessItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/SendingSuccessItemPresenter;", "bindSendingSuccessItemPresenter", "(Lcom/avito/android/abuse/details/adapter/SendingSuccessItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/SendingSuccessItemPresenter;", "Lcom/avito/android/abuse/details/adapter/ErrorLabelItemBlueprint;", "bindErrorLabelItemBlueprint", "(Lcom/avito/android/abuse/details/adapter/ErrorLabelItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenterImpl;", "Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenter;", "bindErrorLabelItemPresenter", "(Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenterImpl;)Lcom/avito/android/abuse/details/adapter/ErrorLabelItemPresenter;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindClickedRelay", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindClickedConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "bindChangedRelay", "bindChangedConsumer", "bindFocusedRelay", "bindFocusedConsumer", "abuse_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AbuseDetailsModule {
    @Binds
    @Named("changed")
    @NotNull
    Consumer<AbuseField> bindChangedConsumer(@Named("changed") @NotNull PublishRelay<AbuseField> publishRelay);

    @Binds
    @Named("changed")
    @NotNull
    Observable<AbuseField> bindChangedRelay(@Named("changed") @NotNull PublishRelay<AbuseField> publishRelay);

    @Binds
    @Named("clicked")
    @NotNull
    Consumer<DeepLink> bindClickedConsumer(@Named("clicked") @NotNull PublishRelay<DeepLink> publishRelay);

    @Binds
    @Named("clicked")
    @NotNull
    Observable<DeepLink> bindClickedRelay(@Named("clicked") @NotNull PublishRelay<DeepLink> publishRelay);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindCommentItemBlueprint(@NotNull CommentItemBlueprint commentItemBlueprint);

    @Binds
    @NotNull
    CommentItemPresenter bindCommentItemPresenter(@NotNull CommentItemPresenterImpl commentItemPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindEmotionItemBlueprint(@NotNull EmotionItemBlueprint emotionItemBlueprint);

    @Binds
    @NotNull
    EmotionItemPresenter bindEmotionItemPresenter(@NotNull EmotionItemPresenterImpl emotionItemPresenterImpl);

    @PerActivity
    @Binds
    @NotNull
    ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindErrorLabelItemBlueprint(@NotNull ErrorLabelItemBlueprint errorLabelItemBlueprint);

    @Binds
    @NotNull
    ErrorLabelItemPresenter bindErrorLabelItemPresenter(@NotNull ErrorLabelItemPresenterImpl errorLabelItemPresenterImpl);

    @Binds
    @Named("focused")
    @NotNull
    Consumer<AbuseField> bindFocusedConsumer(@Named("focused") @NotNull PublishRelay<AbuseField> publishRelay);

    @Binds
    @Named("focused")
    @NotNull
    Observable<AbuseField> bindFocusedRelay(@Named("focused") @NotNull PublishRelay<AbuseField> publishRelay);

    @Binds
    @NotNull
    AbuseDetailsInteractor bindInteractor(@NotNull AbuseDetailsInteractorImpl abuseDetailsInteractorImpl);

    @Binds
    @NotNull
    AbuseDetailsPresenter bindPresenter(@NotNull AbuseDetailsPresenterImpl abuseDetailsPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindPrimaryButtonItemBlueprint(@NotNull PrimaryButtonItemBlueprint primaryButtonItemBlueprint);

    @Binds
    @NotNull
    PrimaryButtonItemPresenter bindPrimaryButtonItemPresenter(@NotNull PrimaryButtonItemPresenterImpl primaryButtonItemPresenterImpl);

    @Binds
    @NotNull
    AbuseDetailsResourceProvider bindResourceProvider(@NotNull AbuseDetailsResourceProviderImpl abuseDetailsResourceProviderImpl);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindSecondaryButtonItemBlueprint(@NotNull SecondaryButtonItemBlueprint secondaryButtonItemBlueprint);

    @Binds
    @NotNull
    SecondaryButtonItemPresenter bindSecondaryButtonItemPresenter(@NotNull SecondaryButtonItemPresenterImpl secondaryButtonItemPresenterImpl);

    @Binds
    @IntoSet
    @NotNull
    ItemBlueprint<?, ?> bindSendingSuccessItemBlueprint(@NotNull SendingSuccessItemBlueprint sendingSuccessItemBlueprint);

    @Binds
    @NotNull
    SendingSuccessItemPresenter bindSendingSuccessItemPresenter(@NotNull SendingSuccessItemPresenterImpl sendingSuccessItemPresenterImpl);
}
