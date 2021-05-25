package com.avito.android.payment.di.module;

import android.app.Activity;
import android.content.res.Resources;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.Features;
import com.avito.android.di.PerActivity;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.top_up.form.TopUpFormInteractor;
import com.avito.android.payment.top_up.form.TopUpFormInteractorImpl;
import com.avito.android.payment.top_up.form.TopUpFormItemConverter;
import com.avito.android.payment.top_up.form.TopUpFormItemConverterImpl;
import com.avito.android.payment.top_up.form.TopUpFormPresenter;
import com.avito.android.payment.top_up.form.TopUpFormPresenterImpl;
import com.avito.android.payment.top_up.form.TopUpFormResourceProvider;
import com.avito.android.payment.top_up.form.TopUpFormResourceProviderImpl;
import com.avito.android.payment.top_up.form.items.TopUpFormItemsComparator;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItem;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemBlueprint;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemPresenter;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItemPresenterImpl;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItemBlueprint;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItemPresenter;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItemPresenterImpl;
import com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionBlueprint;
import com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.LocalPretendInteractorImpl;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorImpl;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ParametersValidatorResourceProviderImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonItemPresenter;
import ru.avito.component.info_label.InfoLabelBlueprint;
import ru.avito.component.info_label.InfoLabelItemPresenter;
import ru.avito.component.info_label.InfoLabelItemPresenterImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001B3\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010$\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#J-\u0010-\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010 \u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b+\u0010,J\u001f\u00102\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u00020(2\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020.H\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u001d2\u0006\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u000209H\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020&2\u0006\u0010@\u001a\u00020?H\u0007¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020?2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00104\u001a\u000203H\u0007¢\u0006\u0004\bC\u0010DJ/\u0010O\u001a\u0002032\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020I2\u0006\u0010L\u001a\u00020KH\u0001¢\u0006\u0004\bM\u0010NJ\u0017\u0010T\u001a\u00020E2\u0006\u0010Q\u001a\u00020PH\u0001¢\u0006\u0004\bR\u0010SJ\u001d\u0010W\u001a\u00020P2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0%H\u0001¢\u0006\u0004\bU\u0010VJ\u0017\u0010[\u001a\u00020G2\u0006\u0010Q\u001a\u00020XH\u0001¢\u0006\u0004\bY\u0010ZJ\u001d\u0010^\u001a\u00020X2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0%H\u0001¢\u0006\u0004\b\\\u0010]J!\u0010c\u001a\u00020I2\u0006\u0010Q\u001a\u00020_2\b\b\u0001\u0010`\u001a\u00020?H\u0001¢\u0006\u0004\ba\u0010bJ\u0017\u0010h\u001a\u00020e2\u0006\u0010Q\u001a\u00020dH\u0001¢\u0006\u0004\bf\u0010gJ\u001d\u0010k\u001a\u00020d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020!0%H\u0001¢\u0006\u0004\bi\u0010jJ\u0017\u0010o\u001a\u00020K2\u0006\u0010Q\u001a\u00020lH\u0001¢\u0006\u0004\bm\u0010nJ\u000f\u0010r\u001a\u00020lH\u0001¢\u0006\u0004\bp\u0010qJ\u0019\u0010u\u001a\u00020_2\b\b\u0001\u0010 \u001a\u00020(H\u0001¢\u0006\u0004\bs\u0010tJ\u0019\u0010w\u001a\u00020(2\b\b\u0001\u00104\u001a\u000203H\u0001¢\u0006\u0004\bv\u00106J#\u0010z\u001a\u00020?2\b\b\u0001\u0010 \u001a\u00020(2\b\b\u0001\u00104\u001a\u000203H\u0001¢\u0006\u0004\bx\u0010yJ\u0017\u0010~\u001a\u0002032\u0006\u0010{\u001a\u00020eH\u0001¢\u0006\u0004\b|\u0010}R\u001b\u0010\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u000108\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/payment/di/module/TopUpFormModule;", "", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "provideTopUpFormInteractor$payment_release", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;", "provideTopUpFormInteractor", "Lcom/avito/android/validation/ParametersValidator;", "validator", "provideLocalPretendInteractor", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "provideParametersValidator", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideLocalPretendInteractorResourceProvider", "()Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "interactor", "Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "topUpFormItemConverter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "providePaymentGenericFormPresenter$payment_release", "(Lcom/avito/android/payment/top_up/form/TopUpFormInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)Lcom/avito/android/payment/top_up/form/TopUpFormPresenter;", "providePaymentGenericFormPresenter", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "provideDataAwareAdapterPresenter$payment_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/payment/top_up/form/items/TopUpFormItemsComparator;", "contentsComparator", "provideDiffCalculator$payment_release", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/top_up/form/items/TopUpFormItemsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideContentsComparator", "()Lcom/avito/android/payment/top_up/form/items/TopUpFormItemsComparator;", "Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;", "topUpFormResourceProvider", "provideTopUpFormItemConverter", "(Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;)Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "provideTopUpFormResourceProvider", "()Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/payment/SubmitButtonBlueprint;", "submitButtonBlueprint", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemBlueprint;", "topUpInputItemBlueprint", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionBlueprint;", "shortcutSectionBlueprint", "Lru/avito/component/info_label/InfoLabelBlueprint;", "infoLabelBlueprint", "provideItemBinder$payment_release", "(Lcom/avito/android/payment/SubmitButtonBlueprint;Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemBlueprint;Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionBlueprint;Lru/avito/component/info_label/InfoLabelBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lru/avito/component/button/ButtonItemPresenter;", "presenter", "provideSubmitButtonBlueprint$payment_release", "(Lru/avito/component/button/ButtonItemPresenter;)Lcom/avito/android/payment/SubmitButtonBlueprint;", "provideSubmitButtonBlueprint", "provideRaisedButtonItemPresenter$payment_release", "(Ldagger/Lazy;)Lru/avito/component/button/ButtonItemPresenter;", "provideRaisedButtonItemPresenter", "Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemPresenter;", "provideTopUpInputItemBlueprint$payment_release", "(Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemPresenter;)Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemBlueprint;", "provideTopUpInputItemBlueprint", "provideTopUpInputItemPresenter$payment_release", "(Ldagger/Lazy;)Lcom/avito/android/payment/top_up/form/items/input/TopUpInputItemPresenter;", "provideTopUpInputItemPresenter", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", "simpleRecyclerAdapter", "provideShortcutSectionBlueprint$payment_release", "(Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionBlueprint;", "provideShortcutSectionBlueprint", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemPresenter;", "Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemBlueprint;", "provideBubbleItemBlueprint$payment_release", "(Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemPresenter;)Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemBlueprint;", "provideBubbleItemBlueprint", "provideBubbleItemPresenter$payment_release", "(Ldagger/Lazy;)Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemPresenter;", "provideBubbleItemPresenter", "Lru/avito/component/info_label/InfoLabelItemPresenter;", "provideInfoLabelBlueprint$payment_release", "(Lru/avito/component/info_label/InfoLabelItemPresenter;)Lru/avito/component/info_label/InfoLabelBlueprint;", "provideInfoLabelBlueprint", "provideInfoLabelItemPresenter$payment_release", "()Lru/avito/component/info_label/InfoLabelItemPresenter;", "provideInfoLabelItemPresenter", "provideShortcutSectionPresenter$payment_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", "provideShortcutSectionPresenter", "provideShortcutSectionAdapterPresenter$payment_release", "provideShortcutSectionAdapterPresenter", "provideSimpleRecyclerAdapter$payment_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "bubbleItemBlueprint", "provideRecommendationSectionItemBinder$payment_release", "(Lcom/avito/android/payment/top_up/form/items/bubble/BubbleItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideRecommendationSectionItemBinder", "Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Kundle;", "interactorState", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "activity", AuthSource.BOOKING_ORDER, "presenterState", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", "<init>", "(Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Landroid/content/res/Resources;Landroid/app/Activity;)V", "ShortcutSectionAdapterPresenter", "ShortcutSectionItemBinder", "ShortcutSectionRecyclerAdapter", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class TopUpFormModule {
    public final Kundle a;
    public final Kundle b;
    public final Resources c;
    public final Activity d;

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/di/module/TopUpFormModule$ShortcutSectionAdapterPresenter;", "", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ShortcutSectionAdapterPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/di/module/TopUpFormModule$ShortcutSectionItemBinder;", "", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ShortcutSectionItemBinder {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/di/module/TopUpFormModule$ShortcutSectionRecyclerAdapter;", "", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface ShortcutSectionRecyclerAdapter {
    }

    public static final class a extends Lambda implements Function1<BubbleItem, Unit> {
        public final /* synthetic */ Lazy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Lazy lazy) {
            super(1);
            this.a = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BubbleItem bubbleItem) {
            BubbleItem bubbleItem2 = bubbleItem;
            Intrinsics.checkNotNullParameter(bubbleItem2, "bubbleItem");
            ((TopUpFormPresenter) this.a.get()).getBubbleItemListener().invoke(bubbleItem2);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Lazy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Lazy lazy) {
            super(1);
            this.a = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            ((TopUpFormPresenter) this.a.get()).getSubmitButtonListener().invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function2<TopUpInputItem, String, Unit> {
        public final /* synthetic */ Lazy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Lazy lazy) {
            super(2);
            this.a = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(TopUpInputItem topUpInputItem, String str) {
            TopUpInputItem topUpInputItem2 = topUpInputItem;
            String str2 = str;
            Intrinsics.checkNotNullParameter(topUpInputItem2, "item");
            Intrinsics.checkNotNullParameter(str2, "value");
            ((TopUpFormPresenter) this.a.get()).getInputListener().invoke(topUpInputItem2, str2);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Lazy a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Lazy lazy) {
            super(0);
            this.a = lazy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((TopUpFormPresenter) this.a.get()).getSubmitButtonListener().invoke();
            return Unit.INSTANCE;
        }
    }

    public TopUpFormModule(@Nullable Kundle kundle, @Nullable Kundle kundle2, @NotNull Resources resources, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = kundle;
        this.b = kundle2;
        this.c = resources;
        this.d = activity;
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final BubbleItemBlueprint provideBubbleItemBlueprint$payment_release(@NotNull BubbleItemPresenter bubbleItemPresenter) {
        Intrinsics.checkNotNullParameter(bubbleItemPresenter, "presenter");
        return new BubbleItemBlueprint(bubbleItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final BubbleItemPresenter provideBubbleItemPresenter$payment_release(@NotNull Lazy<TopUpFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new BubbleItemPresenterImpl(new a(lazy));
    }

    @Provides
    @PerActivity
    @NotNull
    public final TopUpFormItemsComparator provideContentsComparator() {
        return new TopUpFormItemsComparator();
    }

    @Provides
    @NotNull
    @PerActivity
    public final DataAwareAdapterPresenter provideDataAwareAdapterPresenter$payment_release(@NotNull Lazy<ListUpdateCallback> lazy, @NotNull AdapterPresenter adapterPresenter, @NotNull DiffCalculator diffCalculator) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(diffCalculator, "diffCalculator");
        return new DataAwareAdapterPresenterImpl(lazy, adapterPresenter, diffCalculator);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DiffCalculator provideDiffCalculator$payment_release(@NotNull SchedulersFactory schedulersFactory, @NotNull TopUpFormItemsComparator topUpFormItemsComparator) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(topUpFormItemsComparator, "contentsComparator");
        return new SimpleDiffCalculator(topUpFormItemsComparator, new SimpleEqualityComparator(), true, null, 8, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final InfoLabelBlueprint provideInfoLabelBlueprint$payment_release(@NotNull InfoLabelItemPresenter infoLabelItemPresenter) {
        Intrinsics.checkNotNullParameter(infoLabelItemPresenter, "presenter");
        return new InfoLabelBlueprint(infoLabelItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final InfoLabelItemPresenter provideInfoLabelItemPresenter$payment_release() {
        return new InfoLabelItemPresenterImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final ItemBinder provideItemBinder$payment_release(@NotNull SubmitButtonBlueprint submitButtonBlueprint, @NotNull TopUpInputItemBlueprint topUpInputItemBlueprint, @NotNull ShortcutSectionBlueprint shortcutSectionBlueprint, @NotNull InfoLabelBlueprint infoLabelBlueprint) {
        Intrinsics.checkNotNullParameter(submitButtonBlueprint, "submitButtonBlueprint");
        Intrinsics.checkNotNullParameter(topUpInputItemBlueprint, "topUpInputItemBlueprint");
        Intrinsics.checkNotNullParameter(shortcutSectionBlueprint, "shortcutSectionBlueprint");
        Intrinsics.checkNotNullParameter(infoLabelBlueprint, "infoLabelBlueprint");
        return new ItemBinder.Builder().registerItem(infoLabelBlueprint).registerItem(submitButtonBlueprint).registerItem(topUpInputItemBlueprint).registerItem(shortcutSectionBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final ListUpdateCallback provideListUpdateListener(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        return simpleRecyclerAdapter;
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
    public final ParametersValidatorResourceProvider provideLocalPretendInteractorResourceProvider() {
        return new ParametersValidatorResourceProviderImpl(this.c);
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
    public final TopUpFormPresenter providePaymentGenericFormPresenter$payment_release(@NotNull TopUpFormInteractor topUpFormInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull TopUpFormItemConverter topUpFormItemConverter, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(topUpFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(topUpFormItemConverter, "topUpFormItemConverter");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        return new TopUpFormPresenterImpl(topUpFormInteractor, dataAwareAdapterPresenter, schedulersFactory, topUpFormItemConverter, this.b);
    }

    @Provides
    @NotNull
    @PerActivity
    public final ButtonItemPresenter provideRaisedButtonItemPresenter$payment_release(@NotNull Lazy<TopUpFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenter(new b(lazy));
    }

    @Provides
    @ShortcutSectionItemBinder
    @NotNull
    @PerActivity
    public final ItemBinder provideRecommendationSectionItemBinder$payment_release(@NotNull BubbleItemBlueprint bubbleItemBlueprint) {
        Intrinsics.checkNotNullParameter(bubbleItemBlueprint, "bubbleItemBlueprint");
        return new ItemBinder.Builder().registerItem(bubbleItemBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final SimpleRecyclerAdapter provideRecyclerAdapter(@NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new SimpleRecyclerAdapter(dataAwareAdapterPresenter, itemBinder);
    }

    @Provides
    @NotNull
    @PerActivity
    @ShortcutSectionAdapterPresenter
    public final AdapterPresenter provideShortcutSectionAdapterPresenter$payment_release(@ShortcutSectionItemBinder @NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShortcutSectionBlueprint provideShortcutSectionBlueprint$payment_release(@NotNull ShortcutSectionPresenter shortcutSectionPresenter, @ShortcutSectionRecyclerAdapter @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(shortcutSectionPresenter, "presenter");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "simpleRecyclerAdapter");
        return new ShortcutSectionBlueprint(shortcutSectionPresenter, simpleRecyclerAdapter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShortcutSectionPresenter provideShortcutSectionPresenter$payment_release(@ShortcutSectionAdapterPresenter @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        return new ShortcutSectionPresenter(adapterPresenter);
    }

    @Provides
    @ShortcutSectionRecyclerAdapter
    @NotNull
    @PerActivity
    public final SimpleRecyclerAdapter provideSimpleRecyclerAdapter$payment_release(@ShortcutSectionAdapterPresenter @NotNull AdapterPresenter adapterPresenter, @ShortcutSectionItemBinder @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerActivity
    @NotNull
    public final SubmitButtonBlueprint provideSubmitButtonBlueprint$payment_release(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "presenter");
        return new SubmitButtonBlueprint(buttonItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TopUpFormInteractor provideTopUpFormInteractor$payment_release(@NotNull PaymentApi paymentApi, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new TopUpFormInteractorImpl(paymentApi, schedulersFactory, localPretendInteractor, this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TopUpFormItemConverter provideTopUpFormItemConverter(@NotNull TopUpFormResourceProvider topUpFormResourceProvider) {
        Intrinsics.checkNotNullParameter(topUpFormResourceProvider, "topUpFormResourceProvider");
        return new TopUpFormItemConverterImpl(topUpFormResourceProvider);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TopUpFormResourceProvider provideTopUpFormResourceProvider() {
        return new TopUpFormResourceProviderImpl(this.d);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TopUpInputItemBlueprint provideTopUpInputItemBlueprint$payment_release(@NotNull TopUpInputItemPresenter topUpInputItemPresenter) {
        Intrinsics.checkNotNullParameter(topUpInputItemPresenter, "presenter");
        return new TopUpInputItemBlueprint(topUpInputItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final TopUpInputItemPresenter provideTopUpInputItemPresenter$payment_release(@NotNull Lazy<TopUpFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new TopUpInputItemPresenterImpl(new c(lazy), new d(lazy));
    }
}
