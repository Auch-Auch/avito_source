package com.avito.android.payment.di.module;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextWatcher;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.Features;
import com.avito.android.blueprints.InputItemBlueprint;
import com.avito.android.blueprints.InputItemPresenter;
import com.avito.android.blueprints.InputItemPresenterImpl;
import com.avito.android.blueprints.publish.PrimaryParametersListener;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemBlueprint;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenter;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItemPresenterImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.di.module.InputItemFormatterProviderModule;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.payment.SubmitButtonBlueprint;
import com.avito.android.payment.form.DefaultItemConverter;
import com.avito.android.payment.form.DelegateItemConverter;
import com.avito.android.payment.form.PaymentGenericFormInteractor;
import com.avito.android.payment.form.PaymentGenericFormInteractorImpl;
import com.avito.android.payment.form.PaymentGenericFormItemConverter;
import com.avito.android.payment.form.PaymentGenericFormItemConverterImpl;
import com.avito.android.payment.form.PaymentGenericFormItemsComparator;
import com.avito.android.payment.form.PaymentGenericFormPresenter;
import com.avito.android.payment.form.PaymentGenericFormPresenterImpl;
import com.avito.android.payment.form.PaymentStatusProcessingPresenter;
import com.avito.android.payment.form.PaymentStatusProcessingPresenterImpl;
import com.avito.android.payment.items.PaymentInfoTextBlueprint;
import com.avito.android.payment.items.TextItemPresenter;
import com.avito.android.payment.items.TextItemPresenterImpl;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.payment.remote.PaymentSessionTypeMarker;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenterImpl;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.SimpleDiffCalculator;
import com.avito.android.recycler.data_aware.SimpleEqualityComparator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
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
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonItemPresenter;
import ru.avito.component.info_label.InfoLabelBlueprint;
import ru.avito.component.info_label.InfoLabelItemPresenter;
import ru.avito.component.info_label.InfoLabelItemPresenterImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BG\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0007\u0010 \u0001\u001a\u000208\u0012\u0007\u0010\u0001\u001a\u000208\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¢\u0001\u001a\u00030¡\u0001¢\u0006\u0006\b£\u0001\u0010¤\u0001J7\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010&\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0001¢\u0006\u0004\b$\u0010%J\u000f\u0010*\u001a\u00020'H\u0001¢\u0006\u0004\b(\u0010)J\u001f\u00101\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b/\u00100J\u0017\u00106\u001a\u00020+2\u0006\u00103\u001a\u000202H\u0001¢\u0006\u0004\b4\u00105JG\u0010@\u001a\u0002022\u000e\b\u0001\u00109\u001a\b\u0012\u0004\u0012\u000208072\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010?\u001a\u00020>H\u0007¢\u0006\u0004\b@\u0010AJ-\u0010J\u001a\u00020!2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020C0B2\u0006\u0010\"\u001a\u00020E2\u0006\u0010G\u001a\u00020FH\u0001¢\u0006\u0004\bH\u0010IJ\u0017\u0010O\u001a\u00020F2\u0006\u0010L\u001a\u00020KH\u0001¢\u0006\u0004\bM\u0010NJ\u0017\u0010R\u001a\u00020E2\u0006\u0010Q\u001a\u00020PH\u0007¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020KH\u0007¢\u0006\u0004\bT\u0010UJ\u0017\u0010X\u001a\u00020C2\u0006\u0010W\u001a\u00020VH\u0007¢\u0006\u0004\bX\u0010YJ\u001f\u0010Z\u001a\u00020V2\u0006\u0010\"\u001a\u00020!2\u0006\u0010Q\u001a\u00020PH\u0007¢\u0006\u0004\bZ\u0010[J/\u0010f\u001a\u00020P2\u0006\u0010]\u001a\u00020\\2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020bH\u0001¢\u0006\u0004\bd\u0010eJ\u0017\u0010j\u001a\u00020i2\u0006\u0010h\u001a\u00020gH\u0007¢\u0006\u0004\bj\u0010kJ/\u0010q\u001a\u00020g2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020l0B2\b\b\u0001\u0010n\u001a\u00020m2\u0006\u0010p\u001a\u00020oH\u0007¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020l2\u0006\u0010s\u001a\u00020#H\u0007¢\u0006\u0004\bt\u0010uJ\u0017\u0010y\u001a\u00020\\2\u0006\u0010s\u001a\u00020vH\u0001¢\u0006\u0004\bw\u0010xJ\u001d\u0010|\u001a\u00020v2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020#0BH\u0001¢\u0006\u0004\bz\u0010{J\u0018\u0010\u0001\u001a\u00020^2\u0006\u0010s\u001a\u00020}H\u0001¢\u0006\u0004\b~\u0010J \u0010\u0001\u001a\u00020}2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020#0BH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020`2\u0007\u0010s\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020b2\u0007\u0010s\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010 \u0001\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/avito/android/payment/di/module/PaymentGenericFormModule;", "", "Lcom/avito/android/payment/remote/PaymentApi;", "api", "Lcom/avito/android/validation/LocalPretendInteractor;", "localPretendInteractor", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;", "paymentSessionTypeMarker", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "providePaymentGenericFormInteractor$payment_release", "(Lcom/avito/android/payment/remote/PaymentApi;Lcom/avito/android/validation/LocalPretendInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/remote/PaymentSessionTypeMarker;Lcom/avito/android/Features;)Lcom/avito/android/payment/form/PaymentGenericFormInteractor;", "providePaymentGenericFormInteractor", "Lcom/avito/android/validation/ParametersValidator;", "validator", "provideLocalPretendInteractor", "(Lcom/avito/android/validation/ParametersValidator;)Lcom/avito/android/validation/LocalPretendInteractor;", "Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "resourceProvider", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "provideParametersValidator", "(Lcom/avito/android/validation/ParametersValidatorResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlRenderer;Lcom/avito/android/html_formatter/HtmlCleaner;)Lcom/avito/android/validation/ParametersValidator;", "provideLocalPretendInteractorResourceProvider", "()Lcom/avito/android/validation/ParametersValidatorResourceProvider;", "interactor", "Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", "itemConverter", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "providePaymentGenericFormPresenter$payment_release", "(Lcom/avito/android/payment/form/PaymentGenericFormInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;)Lcom/avito/android/payment/form/PaymentGenericFormPresenter;", "providePaymentGenericFormPresenter", "Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "providePaymentStatusProcessingPresenter$payment_release", "()Lcom/avito/android/payment/form/PaymentStatusProcessingPresenter;", "providePaymentStatusProcessingPresenter", "Lcom/avito/android/payment/form/DelegateItemConverter;", "delegateItemConverter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "provideItemConverter$payment_release", "(Lcom/avito/android/payment/form/DelegateItemConverter;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", "provideItemConverter", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "categoryParametersElementConverter", "provideDelegateItemConverter$payment_release", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;)Lcom/avito/android/payment/form/DelegateItemConverter;", "provideDelegateItemConverter", "Lcom/avito/android/util/Formatter;", "", "phoneNumberTextWatcher", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "provideCategoryParametersElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Ldagger/Lazy;", "Landroidx/recyclerview/widget/ListUpdateCallback;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "diffCalculator", "provideDataAwareAdapterPresenter$payment_release", "(Ldagger/Lazy;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/data_aware/DiffCalculator;)Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "provideDataAwareAdapterPresenter", "Lcom/avito/android/payment/form/PaymentGenericFormItemsComparator;", "contentsComparator", "provideDiffCalculator$payment_release", "(Lcom/avito/android/payment/form/PaymentGenericFormItemsComparator;)Lcom/avito/android/recycler/data_aware/DiffCalculator;", "provideDiffCalculator", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideContentsComparator", "()Lcom/avito/android/payment/form/PaymentGenericFormItemsComparator;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "provideListUpdateListener", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/ListUpdateCallback;", "provideRecyclerAdapter", "(Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/payment/SubmitButtonBlueprint;", "submitButtonBlueprint", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;", "phoneInputItemBlueprint", "Lru/avito/component/info_label/InfoLabelBlueprint;", "infoLabelBlueprint", "Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;", "paymentInfoTextBlueprint", "provideItemBinder$payment_release", "(Lcom/avito/android/payment/SubmitButtonBlueprint;Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;Lru/avito/component/info_label/InfoLabelBlueprint;Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/blueprints/InputItemPresenter;", "inputItemPresenter", "Lcom/avito/android/blueprints/InputItemBlueprint;", "provideInputItemBluePrint", "(Lcom/avito/android/blueprints/InputItemPresenter;)Lcom/avito/android/blueprints/InputItemBlueprint;", "Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "Landroid/text/TextWatcher;", "phoneTextWatcher", "Lcom/avito/android/provider/InputItemFormatterProvider;", "formatterProvider", "provideInputItemPresenter", "(Ldagger/Lazy;Landroid/text/TextWatcher;Lcom/avito/android/provider/InputItemFormatterProvider;)Lcom/avito/android/blueprints/InputItemPresenter;", "presenter", "providePrimaryParametersElementListener", "(Lcom/avito/android/payment/form/PaymentGenericFormPresenter;)Lcom/avito/android/blueprints/publish/PrimaryParametersListener;", "Lru/avito/component/button/ButtonItemPresenter;", "provideSubmitButtonBlueprint$payment_release", "(Lru/avito/component/button/ButtonItemPresenter;)Lcom/avito/android/payment/SubmitButtonBlueprint;", "provideSubmitButtonBlueprint", "provideRaisedButtonItemPresenter$payment_release", "(Ldagger/Lazy;)Lru/avito/component/button/ButtonItemPresenter;", "provideRaisedButtonItemPresenter", "Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;", "providePhoneInputItemBlueprint$payment_release", "(Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;)Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemBlueprint;", "providePhoneInputItemBlueprint", "providePhoneInputItemPresenter$payment_release", "(Ldagger/Lazy;)Lcom/avito/android/conveyor_shared_item/phone_item/PhoneInputItemPresenter;", "providePhoneInputItemPresenter", "Lru/avito/component/info_label/InfoLabelItemPresenter;", "provideInfoLabelBlueprint$payment_release", "(Lru/avito/component/info_label/InfoLabelItemPresenter;)Lru/avito/component/info_label/InfoLabelBlueprint;", "provideInfoLabelBlueprint", "provideInfoLabelItemPresenter$payment_release", "()Lru/avito/component/info_label/InfoLabelItemPresenter;", "provideInfoLabelItemPresenter", "Lcom/avito/android/payment/items/TextItemPresenter;", "providePaymentInfoTextBlueprint$payment_release", "(Lcom/avito/android/payment/items/TextItemPresenter;)Lcom/avito/android/payment/items/PaymentInfoTextBlueprint;", "providePaymentInfoTextBlueprint", "provideTextItemPresenter$payment_release", "()Lcom/avito/android/payment/items/TextItemPresenter;", "provideTextItemPresenter", "Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Kundle;", "interactorState", AuthSource.BOOKING_ORDER, "presenterState", "Landroid/content/res/Resources;", "e", "Landroid/content/res/Resources;", "resources", "d", "Ljava/lang/String;", "methodSignature", "c", "sessionId", "Landroid/app/Activity;", "activity", "<init>", "(Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Ljava/lang/String;Ljava/lang/String;Landroid/content/res/Resources;Landroid/app/Activity;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, AttributedTextFormatterModule.class, InputItemFormatterProviderModule.class})
public final class PaymentGenericFormModule {
    public final Kundle a;
    public final Kundle b;
    public final String c;
    public final String d;
    public final Resources e;

    public static final class a<T> implements Consumer<PhoneInputItem> {
        public final /* synthetic */ Lazy a;

        public a(Lazy lazy) {
            this.a = lazy;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PhoneInputItem phoneInputItem) {
            PhoneInputItem phoneInputItem2 = phoneInputItem;
            Function1<PhoneInputItem, Unit> phoneInputListener = ((PaymentGenericFormPresenter) this.a.get()).getPhoneInputListener();
            Intrinsics.checkNotNullExpressionValue(phoneInputItem2, "phoneInputItem");
            phoneInputListener.invoke(phoneInputItem2);
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
            ((PaymentGenericFormPresenter) this.a.get()).getSubmitButtonListener().invoke();
            return Unit.INSTANCE;
        }
    }

    public PaymentGenericFormModule(@Nullable Kundle kundle, @Nullable Kundle kundle2, @NotNull String str, @NotNull String str2, @NotNull Resources resources, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "methodSignature");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = kundle;
        this.b = kundle2;
        this.c = str;
        this.d = str2;
        this.e = resources;
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a2.b.a.a.a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    @PerActivity
    public final CategoryParametersElementConverter provideCategoryParametersElementConverter(@PhoneNumberFormatterModule.PhoneNumberFormatter @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberTextWatcher");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, this.e, timeSource, true, false, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 976, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentGenericFormItemsComparator provideContentsComparator() {
        return new PaymentGenericFormItemsComparator();
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
    public final DelegateItemConverter provideDelegateItemConverter$payment_release(@NotNull CategoryParametersElementConverter categoryParametersElementConverter) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "categoryParametersElementConverter");
        return new DefaultItemConverter(categoryParametersElementConverter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DiffCalculator provideDiffCalculator$payment_release(@NotNull PaymentGenericFormItemsComparator paymentGenericFormItemsComparator) {
        Intrinsics.checkNotNullParameter(paymentGenericFormItemsComparator, "contentsComparator");
        return new SimpleDiffCalculator(paymentGenericFormItemsComparator, new SimpleEqualityComparator(), true, null, 8, null);
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
    public final InputItemBlueprint provideInputItemBluePrint(@NotNull InputItemPresenter inputItemPresenter) {
        Intrinsics.checkNotNullParameter(inputItemPresenter, "inputItemPresenter");
        return new InputItemBlueprint(inputItemPresenter, null, 2, null);
    }

    @Provides
    @NotNull
    @PerActivity
    public final InputItemPresenter provideInputItemPresenter(@NotNull Lazy<PrimaryParametersListener> lazy, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull TextWatcher textWatcher, @NotNull InputItemFormatterProvider inputItemFormatterProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(textWatcher, "phoneTextWatcher");
        Intrinsics.checkNotNullParameter(inputItemFormatterProvider, "formatterProvider");
        return new InputItemPresenterImpl(lazy, textWatcher, inputItemFormatterProvider);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ItemBinder provideItemBinder$payment_release(@NotNull SubmitButtonBlueprint submitButtonBlueprint, @NotNull PhoneInputItemBlueprint phoneInputItemBlueprint, @NotNull InfoLabelBlueprint infoLabelBlueprint, @NotNull PaymentInfoTextBlueprint paymentInfoTextBlueprint) {
        Intrinsics.checkNotNullParameter(submitButtonBlueprint, "submitButtonBlueprint");
        Intrinsics.checkNotNullParameter(phoneInputItemBlueprint, "phoneInputItemBlueprint");
        Intrinsics.checkNotNullParameter(infoLabelBlueprint, "infoLabelBlueprint");
        Intrinsics.checkNotNullParameter(paymentInfoTextBlueprint, "paymentInfoTextBlueprint");
        return new ItemBinder.Builder().registerItem(submitButtonBlueprint).registerItem(phoneInputItemBlueprint).registerItem(infoLabelBlueprint).registerItem(paymentInfoTextBlueprint).build();
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentGenericFormItemConverter provideItemConverter$payment_release(@NotNull DelegateItemConverter delegateItemConverter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(delegateItemConverter, "delegateItemConverter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new PaymentGenericFormItemConverterImpl(delegateItemConverter, attributedTextFormatter);
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
        return new ParametersValidatorResourceProviderImpl(this.e);
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
    public final PaymentGenericFormInteractor providePaymentGenericFormInteractor$payment_release(@NotNull PaymentApi paymentApi, @NotNull LocalPretendInteractor localPretendInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PaymentSessionTypeMarker paymentSessionTypeMarker, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(paymentApi, "api");
        Intrinsics.checkNotNullParameter(localPretendInteractor, "localPretendInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(paymentSessionTypeMarker, "paymentSessionTypeMarker");
        Intrinsics.checkNotNullParameter(features, "features");
        return new PaymentGenericFormInteractorImpl(paymentApi, localPretendInteractor, this.c, this.d, schedulersFactory, features, paymentSessionTypeMarker, this.a);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentGenericFormPresenter providePaymentGenericFormPresenter$payment_release(@NotNull PaymentGenericFormInteractor paymentGenericFormInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PaymentGenericFormItemConverter paymentGenericFormItemConverter, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter) {
        Intrinsics.checkNotNullParameter(paymentGenericFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(paymentGenericFormItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        return new PaymentGenericFormPresenterImpl(dataAwareAdapterPresenter, paymentGenericFormInteractor, paymentGenericFormItemConverter, schedulersFactory, this.b);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentInfoTextBlueprint providePaymentInfoTextBlueprint$payment_release(@NotNull TextItemPresenter textItemPresenter) {
        Intrinsics.checkNotNullParameter(textItemPresenter, "presenter");
        return new PaymentInfoTextBlueprint(textItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PaymentStatusProcessingPresenter providePaymentStatusProcessingPresenter$payment_release() {
        return new PaymentStatusProcessingPresenterImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhoneInputItemBlueprint providePhoneInputItemBlueprint$payment_release(@NotNull PhoneInputItemPresenter phoneInputItemPresenter) {
        Intrinsics.checkNotNullParameter(phoneInputItemPresenter, "presenter");
        return new PhoneInputItemBlueprint(phoneInputItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final PhoneInputItemPresenter providePhoneInputItemPresenter$payment_release(@NotNull Lazy<PaymentGenericFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new PhoneInputItemPresenterImpl(new a(lazy));
    }

    @Provides
    @PerActivity
    @NotNull
    public final PrimaryParametersListener providePrimaryParametersElementListener(@NotNull PaymentGenericFormPresenter paymentGenericFormPresenter) {
        Intrinsics.checkNotNullParameter(paymentGenericFormPresenter, "presenter");
        return paymentGenericFormPresenter;
    }

    @Provides
    @NotNull
    @PerActivity
    public final ButtonItemPresenter provideRaisedButtonItemPresenter$payment_release(@NotNull Lazy<PaymentGenericFormPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenter(new b(lazy));
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
    @PerActivity
    @NotNull
    public final SubmitButtonBlueprint provideSubmitButtonBlueprint$payment_release(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "presenter");
        return new SubmitButtonBlueprint(buttonItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final TextItemPresenter provideTextItemPresenter$payment_release() {
        return new TextItemPresenterImpl();
    }
}
