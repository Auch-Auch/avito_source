package com.avito.android.publish.details;

import a2.a.a.e2.r.c;
import a2.a.a.e2.r.d;
import a2.a.a.e2.r.e;
import a2.g.r.g;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.PhoneConfirmationIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.EditParametersScreen;
import com.avito.android.analytics.screens.PublishParametersScreen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.analytics.screens.tracker.ScreenTransferKt;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetButton;
import com.avito.android.deep_linking.links.DetailsSheetLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.ImageListRouter;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ContactsDataSourceImpl;
import com.avito.android.publish.PublishActivity;
import com.avito.android.publish.PublishActivityKt;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.R;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.details.di.DaggerPublishDetailsComponent;
import com.avito.android.publish.details.di.PublishDetailsAnalyticsModule;
import com.avito.android.publish.details.di.PublishDetailsComponent;
import com.avito.android.publish.details.di.PublishDetailsModule;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.drafts.db.LocalDraftTypeAdapterKt;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.publish.residential_complex_search.ResidentialComplexActivityKt;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.publish.view.ItemDetailsBaseFragment;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.publish.view.ItemDetailsViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.select.SelectListener;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Keyboards;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.net.URL;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ¸\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¸\u0001B\b¢\u0006\u0005\b·\u0001\u0010\u001bJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J)\u0010'\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0014¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b,\u0010\u001bJ\u0019\u0010-\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020\bH\u0016¢\u0006\u0004\b.\u0010\u001bJ\u000f\u0010/\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u001bJ\u000f\u00102\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u0010\u001bJ\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u001bJ!\u00107\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u00106\u001a\u00020\"H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\u001bJ\u0017\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u000204H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\"H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\b@\u0010\u001bJ\u0017\u0010A\u001a\u00020\b2\u0006\u0010:\u001a\u000204H\u0016¢\u0006\u0004\bA\u0010<J\u0017\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010c\u001a\u00020b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010j\u001a\u00020i8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u0002048\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R*\u0010ª\u0001\u001a\u00030©\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001R.\u0010±\u0001\u001a\u0007\u0012\u0002\b\u00030°\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001¨\u0006¹\u0001"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsFragment;", "Lcom/avito/android/publish/view/ItemDetailsBaseFragment;", "Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;", "Lcom/avito/android/select/SelectListener;", "Lcom/avito/android/photo_view/ImageListRouter;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "onDetach", "Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;", "phoneVerificationData", "showPhoneVerificationScreen", "(Lcom/avito/android/publish/slots/contact_info/ContactInfoSlotWrapper$PhoneVerificationData;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "handleActivityResult", "(IILandroid/content/Intent;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "onCreate", "onDestroy", "onBackPressed", "()Z", "navigateToAuth", "onEditClicked", "leaveScreen", "", "selectedPhotoId", "currentPhotoCount", "openPhotoPicker", "(Ljava/lang/String;I)V", "openVideoPicker", "url", "showHelpCenterScreen", "(Ljava/lang/String;)V", "categoryId", "showCpaTariffRequestScreen", "(I)V", "showResidentialComplexSuggestScreen", "openWebUrl", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "tagsViewModel", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "getTagsViewModel", "()Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "setTagsViewModel", "(Lcom/avito/android/publish/details/tags/PublishTagsViewModel;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/validation/ParametersListPresenter;", "paramsPresenter", "Lcom/avito/android/validation/ParametersListPresenter;", "getParamsPresenter", "()Lcom/avito/android/validation/ParametersListPresenter;", "setParamsPresenter", "(Lcom/avito/android/validation/ParametersListPresenter;)V", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "tracker", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "getTracker", "()Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "setTracker", "(Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)V", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "uploadingInteractor", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "getUploadingInteractor", "()Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "setUploadingInteractor", "(Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;)V", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "htmlEditorViewModel", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "getHtmlEditorViewModel", "()Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "setHtmlEditorViewModel", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;)V", "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", "Lcom/avito/android/photo_view/ImageListPresenter;", "getImageListPresenter", "()Lcom/avito/android/photo_view/ImageListPresenter;", "setImageListPresenter", "(Lcom/avito/android/photo_view/ImageListPresenter;)V", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "getEventTracker", "()Lcom/avito/android/publish/analytics/PublishEventTracker;", "setEventTracker", "(Lcom/avito/android/publish/analytics/PublishEventTracker;)V", "Lio/reactivex/disposables/CompositeDisposable;", "h", "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/publish/ContactsDataSource;", "contactsDataSource", "Lcom/avito/android/publish/ContactsDataSource;", "getContactsDataSource", "()Lcom/avito/android/publish/ContactsDataSource;", "setContactsDataSource", "(Lcom/avito/android/publish/ContactsDataSource;)V", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "inputsAnalyticTracker", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "getInputsAnalyticTracker", "()Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "setInputsAnalyticTracker", "(Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;)V", "i", "Ljava/lang/String;", "draftId", "Lcom/avito/android/publish/PublishViewModel;", g.a, "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "j", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "router", "Lcom/avito/android/publish/details/PublishDetailsPresenter;", "presenter", "Lcom/avito/android/publish/details/PublishDetailsPresenter;", "getPresenter", "()Lcom/avito/android/publish/details/PublishDetailsPresenter;", "setPresenter", "(Lcom/avito/android/publish/details/PublishDetailsPresenter;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "<init>", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDetailsFragment extends ItemDetailsBaseFragment implements PublishDetailsPresenter.Router, SelectListener, ImageListRouter, OnBackPressedListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Inject
    public RecyclerView.Adapter<?> adapter;
    @Inject
    public Analytics analytics;
    @Inject
    public ContactsDataSource contactsDataSource;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public PublishEventTracker eventTracker;
    public PublishViewModel g;
    public final CompositeDisposable h = new CompositeDisposable();
    @Inject
    public HtmlEditorViewModel htmlEditorViewModel;
    public String i;
    @Inject
    public ImageListPresenter imageListPresenter;
    @Inject
    public PublishInputsAnalyticTracker inputsAnalyticTracker;
    public PublishDetailsRouter j;
    @Inject
    public ParametersListPresenter paramsPresenter;
    @Inject
    public PublishDetailsPresenter presenter;
    @Inject
    public PublishTagsViewModel tagsViewModel;
    @Inject
    public PublishDetailsTracker tracker;
    @Inject
    public UploadingInteractor uploadingInteractor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsFragment$Companion;", "", "", "draftId", "", "isEditing", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "Lcom/avito/android/publish/details/PublishDetailsFragment;", "newInstance", "(Ljava/lang/String;ZLcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Lcom/avito/android/publish/details/PublishDetailsFragment;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ PublishDetailsFragment newInstance$default(Companion companion, String str, boolean z, ScreenTransfer screenTransfer, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(str, z, screenTransfer);
        }

        @JvmStatic
        @NotNull
        public final PublishDetailsFragment newInstance(@NotNull String str, boolean z, @Nullable ScreenTransfer screenTransfer) {
            Intrinsics.checkNotNullParameter(str, "draftId");
            PublishDetailsFragment publishDetailsFragment = new PublishDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(LocalDraftTypeAdapterKt.DRAFT_ID, str);
            bundle.putBoolean("key_is_editing", z);
            bundle.putParcelable(ScreenTransferKt.SCREEN_TRANSFER_KEY, screenTransfer);
            Unit unit = Unit.INSTANCE;
            publishDetailsFragment.setArguments(bundle);
            return publishDetailsFragment;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<ContactsData> {
        public final /* synthetic */ PublishDetailsFragment a;
        public final /* synthetic */ Bundle b;

        public a(PublishDetailsFragment publishDetailsFragment, Bundle bundle) {
            this.a = publishDetailsFragment;
            this.b = bundle;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(ContactsData contactsData) {
            PublishDetailsPresenter.DefaultImpls.showParameters$default(this.a.getPresenter(), null, false, this.b == null, null, 11, null);
        }
    }

    public static final class b extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ PublishDetailsFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PublishDetailsFragment publishDetailsFragment) {
            super(1);
            this.a = publishDetailsFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.getPresenter().handleKeyboard(bool.booleanValue());
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    @NotNull
    public static final PublishDetailsFragment newInstance(@NotNull String str, boolean z, @Nullable ScreenTransfer screenTransfer) {
        return Companion.newInstance(str, z, screenTransfer);
    }

    @NotNull
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final ContactsDataSource getContactsDataSource() {
        ContactsDataSource contactsDataSource2 = this.contactsDataSource;
        if (contactsDataSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsDataSource");
        }
        return contactsDataSource2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final PublishEventTracker getEventTracker() {
        PublishEventTracker publishEventTracker = this.eventTracker;
        if (publishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return publishEventTracker;
    }

    @NotNull
    public final HtmlEditorViewModel getHtmlEditorViewModel() {
        HtmlEditorViewModel htmlEditorViewModel2 = this.htmlEditorViewModel;
        if (htmlEditorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("htmlEditorViewModel");
        }
        return htmlEditorViewModel2;
    }

    @NotNull
    public final ImageListPresenter getImageListPresenter() {
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        return imageListPresenter2;
    }

    @NotNull
    public final PublishInputsAnalyticTracker getInputsAnalyticTracker() {
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        return publishInputsAnalyticTracker;
    }

    @NotNull
    public final ParametersListPresenter getParamsPresenter() {
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        return parametersListPresenter;
    }

    @NotNull
    public final PublishDetailsPresenter getPresenter() {
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return publishDetailsPresenter;
    }

    @NotNull
    public final PublishTagsViewModel getTagsViewModel() {
        PublishTagsViewModel publishTagsViewModel = this.tagsViewModel;
        if (publishTagsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsViewModel");
        }
        return publishTagsViewModel;
    }

    @NotNull
    public final PublishDetailsTracker getTracker() {
        PublishDetailsTracker publishDetailsTracker = this.tracker;
        if (publishDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return publishDetailsTracker;
    }

    @NotNull
    public final UploadingInteractor getUploadingInteractor() {
        UploadingInteractor uploadingInteractor2 = this.uploadingInteractor;
        if (uploadingInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uploadingInteractor");
        }
        return uploadingInteractor2;
    }

    @Override // com.avito.android.publish.view.ItemDetailsBaseFragment
    public void handleActivityResult(int i2, int i3, @Nullable Intent intent) {
        Bundle extras;
        SelectParameter.Value value;
        if (i3 == -1) {
            boolean z = true;
            if (i2 == 1) {
                PublishDetailsPresenter publishDetailsPresenter = this.presenter;
                if (publishDetailsPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                publishDetailsPresenter.onAuthResult(i3);
            } else if (i2 == 2) {
                ImageListPresenter imageListPresenter2 = this.imageListPresenter;
                if (imageListPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
                }
                if (i3 != -1) {
                    z = false;
                }
                imageListPresenter2.onPhotoPickerResult(z);
            } else if (i2 != 5) {
                if (i2 == 6 && i3 == -1 && intent != null && (extras = intent.getExtras()) != null && (value = (SelectParameter.Value) extras.getParcelable(ResidentialComplexActivityKt.EXTRA_SUGGEST_VALUE)) != null) {
                    PublishDetailsPresenter publishDetailsPresenter2 = this.presenter;
                    if (publishDetailsPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "it");
                    publishDetailsPresenter2.onResidentialComplexResult(value);
                }
            } else if (i3 == -1) {
                PublishDetailsPresenter publishDetailsPresenter3 = this.presenter;
                if (publishDetailsPresenter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("presenter");
                }
                publishDetailsPresenter3.onMainButtonClicked();
            }
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void leaveScreen() {
        PublishActivity publishActivity = (PublishActivity) getActivity();
        if (publishActivity != null) {
            publishActivity.leavePublish();
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void navigateToAuth() {
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(getActivityIntentFactory(), null, AuthSource.CREATE_ADVERT, null, 5, null), 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.j = (PublishDetailsRouter) context;
    }

    @Override // com.avito.android.ui.fragments.OnBackPressedListener
    public boolean onBackPressed() {
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        ItemDetailsView.Presenter.DefaultImpls.onCancelClicked$default(publishDetailsPresenter, false, 1, null);
        return true;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        publishInputsAnalyticTracker.subscribe();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PublishDetailsTracker publishDetailsTracker = this.tracker;
        if (publishDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publishDetailsTracker.startInit();
        return layoutInflater.inflate(R.layout.publish_details, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        publishInputsAnalyticTracker.unsubscribe();
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter.onDestroy();
        super.onDestroy();
    }

    @Override // com.avito.android.item_legacy.details.SelectItemBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter.detachView();
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter2.detachView();
        ImageListPresenter imageListPresenter3 = this.imageListPresenter;
        if (imageListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter3.detachRouter();
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        parametersListPresenter.unsubscribe();
        this.h.clear();
        super.onDestroyView();
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        this.j = null;
        super.onDetach();
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener.Router
    public void onEditClicked() {
        Keyboards.hideKeyboard(this);
        PublishDetailsRouter publishDetailsRouter = this.j;
        if (publishDetailsRouter != null) {
            publishDetailsRouter.showEditWizard();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.putBundle("key_presenter", publishDetailsPresenter.onSaveState());
        String str = this.i;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftId");
        }
        bundle.putString(LocalDraftTypeAdapterKt.DRAFT_ID, str);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter.attachRouter(this);
        PublishDetailsPresenter publishDetailsPresenter2 = this.presenter;
        if (publishDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter2.attachPublishRouter(this.j);
    }

    @Override // com.avito.android.publish.view.ItemDetailsBaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter.detachRouter();
        PublishDetailsPresenter publishDetailsPresenter2 = this.presenter;
        if (publishDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter2.detachPublishRouter();
        super.onStop();
    }

    @Override // com.avito.android.item_legacy.details.SelectItemBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ViewModel viewModel = ViewModelProviders.of(requireActivity()).get(PublishViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(re…ishViewModel::class.java)");
        this.g = (PublishViewModel) viewModel;
        ViewGroup viewGroup = (ViewGroup) view;
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        ItemDetailsViewImpl itemDetailsViewImpl = new ItemDetailsViewImpl(viewGroup, publishDetailsPresenter, analytics2, 150, adapter2, dialogRouter2, publishViewModel.getShouldSaveDraft());
        ContactsDataSource contactsDataSource2 = this.contactsDataSource;
        if (contactsDataSource2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsDataSource");
        }
        if (!(contactsDataSource2 instanceof ContactsDataSourceImpl)) {
            contactsDataSource2 = null;
        }
        ContactsDataSourceImpl contactsDataSourceImpl = (ContactsDataSourceImpl) contactsDataSource2;
        if (contactsDataSourceImpl != null) {
            PublishViewModel publishViewModel2 = this.g;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            contactsDataSourceImpl.setPublishViewModel(publishViewModel2);
        }
        PublishInputsAnalyticTracker publishInputsAnalyticTracker = this.inputsAnalyticTracker;
        if (publishInputsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputsAnalyticTracker");
        }
        PublishViewModel publishViewModel3 = this.g;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishInputsAnalyticTracker.setNavigationProvider(publishViewModel3);
        PublishViewModel publishViewModel4 = this.g;
        if (publishViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel4.contactDataLoaded().observe(getViewLifecycleOwner(), new a(this, bundle));
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = itemDetailsViewImpl.getHtmlPanelStateFlags().subscribe(new a2.a.a.e2.r.a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "detailsView.htmlPanelSta…rmatClicked(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.h;
        Disposable subscribe2 = itemDetailsViewImpl.getHtmlPanelNavigationEvent().subscribe(new a2.a.a.e2.r.b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "detailsView.htmlPanelNav…tionClicked(it)\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        HtmlEditorViewModel htmlEditorViewModel2 = this.htmlEditorViewModel;
        if (htmlEditorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("htmlEditorViewModel");
        }
        htmlEditorViewModel2.getStateLiveData().observe(getViewLifecycleOwner(), new c(itemDetailsViewImpl));
        HtmlEditorViewModel htmlEditorViewModel3 = this.htmlEditorViewModel;
        if (htmlEditorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("htmlEditorViewModel");
        }
        htmlEditorViewModel3.getFormatStateLiveData().observe(getViewLifecycleOwner(), new d(itemDetailsViewImpl));
        HtmlEditorViewModel htmlEditorViewModel4 = this.htmlEditorViewModel;
        if (htmlEditorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("htmlEditorViewModel");
        }
        htmlEditorViewModel4.getNavigationStateLiveData().observe(getViewLifecycleOwner(), new e(itemDetailsViewImpl));
        PublishDetailsPresenter publishDetailsPresenter2 = this.presenter;
        if (publishDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PublishViewModel publishViewModel5 = this.g;
        if (publishViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishDetailsPresenter2.setPublishViewModel(publishViewModel5);
        PublishDetailsPresenter publishDetailsPresenter3 = this.presenter;
        if (publishDetailsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        PublishTagsViewModel publishTagsViewModel = this.tagsViewModel;
        if (publishTagsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsViewModel");
        }
        publishDetailsPresenter3.setTagsViewModel(publishTagsViewModel);
        PublishDetailsPresenter publishDetailsPresenter4 = this.presenter;
        if (publishDetailsPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter4.attachView(itemDetailsViewImpl, bundle == null);
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        imageListPresenter2.attachRouter(this);
        ParametersListPresenter parametersListPresenter = this.paramsPresenter;
        if (parametersListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paramsPresenter");
        }
        parametersListPresenter.subscribe();
        CompositeDisposable compositeDisposable3 = this.h;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DisposableKt.plusAssign(compositeDisposable3, Keyboards.addSoftKeyboardVisibilityListener$default((Activity) requireActivity, false, (Function1) new b(this), 1, (Object) null));
        PublishDetailsTracker publishDetailsTracker = this.tracker;
        if (publishDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        publishDetailsTracker.trackInit();
    }

    @Override // com.avito.android.publish.view.BasicParameterClickListener.Router
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.photo_view.ImageListRouter
    public void openPhotoPicker(@Nullable String str, int i2) {
        PublishIntentFactory.PhotoPickerMode photoPickerMode;
        PublishEventTracker publishEventTracker = this.eventTracker;
        if (publishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        publishEventTracker.trackPhotoPickerOpen();
        PublishDetailsPresenter publishDetailsPresenter = this.presenter;
        if (publishDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        publishDetailsPresenter.enableComputerVisionIfNeeded();
        if (str == null) {
            photoPickerMode = PublishIntentFactory.PhotoPickerMode.MODE_ADD;
        } else {
            photoPickerMode = PublishIntentFactory.PhotoPickerMode.MODE_EDIT;
        }
        ActivityIntentFactory activityIntentFactory = getActivityIntentFactory();
        String str2 = this.i;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("draftId");
        }
        ImageListPresenter imageListPresenter2 = this.imageListPresenter;
        if (imageListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageListPresenter");
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.createPhotoPickerIntentForPublish$default(activityIntentFactory, str2, imageListPresenter2.getMaxImageCount(), 0, str, photoPickerMode, 4, null), 2);
    }

    @Override // com.avito.android.photo_view.ImageListRouter
    public void openVideoPicker() {
        PublishEventTracker publishEventTracker = this.eventTracker;
        if (publishEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        publishEventTracker.trackVideoUploadingClicked();
        String string = getString(R.string.video_dummy_title);
        String string2 = getString(R.string.video_dummy_description);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.video_dummy_description)");
        AttributedText attributedText = new AttributedText(string2, CollectionsKt__CollectionsKt.emptyList());
        String string3 = getString(R.string.video_dummy_action);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.video_dummy_action)");
        DetailsSheetLink detailsSheetLink = new DetailsSheetLink(new DetailsSheetLinkBody(string, attributedText, null, new DetailsSheetButton(string3, "primary", null, null, 12, null), null, null, null, null, 208, null));
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(detailsSheetLink);
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void openWebUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        ImplicitIntentFactory implicitIntentFactory = getImplicitIntentFactory();
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(url)");
        startActivity(implicitIntentFactory.uriIntent(parse));
    }

    public final void setAdapter(@NotNull RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "<set-?>");
        this.adapter = adapter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setContactsDataSource(@NotNull ContactsDataSource contactsDataSource2) {
        Intrinsics.checkNotNullParameter(contactsDataSource2, "<set-?>");
        this.contactsDataSource = contactsDataSource2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setEventTracker(@NotNull PublishEventTracker publishEventTracker) {
        Intrinsics.checkNotNullParameter(publishEventTracker, "<set-?>");
        this.eventTracker = publishEventTracker;
    }

    public final void setHtmlEditorViewModel(@NotNull HtmlEditorViewModel htmlEditorViewModel2) {
        Intrinsics.checkNotNullParameter(htmlEditorViewModel2, "<set-?>");
        this.htmlEditorViewModel = htmlEditorViewModel2;
    }

    public final void setImageListPresenter(@NotNull ImageListPresenter imageListPresenter2) {
        Intrinsics.checkNotNullParameter(imageListPresenter2, "<set-?>");
        this.imageListPresenter = imageListPresenter2;
    }

    public final void setInputsAnalyticTracker(@NotNull PublishInputsAnalyticTracker publishInputsAnalyticTracker) {
        Intrinsics.checkNotNullParameter(publishInputsAnalyticTracker, "<set-?>");
        this.inputsAnalyticTracker = publishInputsAnalyticTracker;
    }

    public final void setParamsPresenter(@NotNull ParametersListPresenter parametersListPresenter) {
        Intrinsics.checkNotNullParameter(parametersListPresenter, "<set-?>");
        this.paramsPresenter = parametersListPresenter;
    }

    public final void setPresenter(@NotNull PublishDetailsPresenter publishDetailsPresenter) {
        Intrinsics.checkNotNullParameter(publishDetailsPresenter, "<set-?>");
        this.presenter = publishDetailsPresenter;
    }

    public final void setTagsViewModel(@NotNull PublishTagsViewModel publishTagsViewModel) {
        Intrinsics.checkNotNullParameter(publishTagsViewModel, "<set-?>");
        this.tagsViewModel = publishTagsViewModel;
    }

    public final void setTracker(@NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "<set-?>");
        this.tracker = publishDetailsTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        String string;
        ScreenTransfer screenTransfer;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(LocalDraftTypeAdapterKt.DRAFT_ID)) == null) {
            throw new RuntimeException("draft_id was not passed to " + this);
        }
        this.i = string;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            int i2 = arguments2.getInt(PublishActivityKt.KEY_STEP_INDEX);
            Bundle bundle2 = bundle != null ? bundle.getBundle("key_presenter") : null;
            Bundle arguments3 = getArguments();
            boolean z = arguments3 != null ? arguments3.getBoolean("key_is_editing") : false;
            Timer B1 = a2.b.a.a.a.B1();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            String str = this.i;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draftId");
            }
            ImageUploadModule imageUploadModule = new ImageUploadModule(requireActivity, str);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            String str2 = this.i;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("draftId");
            }
            PublishDetailsModule publishDetailsModule = new PublishDetailsModule(bundle2, resources, i2, str2, z, this);
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            ParametersListModule parametersListModule = new ParametersListModule(resources2, 150, null, this, 4, null);
            PublishDetailsAnalyticsModule publishDetailsAnalyticsModule = new PublishDetailsAnalyticsModule(z);
            PublishDetailsComponent.Builder imageUploadModule2 = DaggerPublishDetailsComponent.builder().publishComponent((PublishComponent) FragmentsKt.activityComponent(this)).imageUploadModule(imageUploadModule);
            Resources resources3 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources3, "resources");
            imageUploadModule2.resources(resources3).withMinValuesForSearch(8).publishDetailsModule(publishDetailsModule).parametersListModule(parametersListModule).publishDetailsAnalyticsModule(publishDetailsAnalyticsModule).build().inject(this);
            PublishDetailsTracker publishDetailsTracker = this.tracker;
            if (publishDetailsTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            publishDetailsTracker.trackDiInject(B1.elapsed());
            Bundle arguments4 = getArguments();
            if (arguments4 == null || (screenTransfer = (ScreenTransfer) arguments4.getParcelable(ScreenTransferKt.SCREEN_TRANSFER_KEY)) == null) {
                return true;
            }
            PublishDetailsTracker publishDetailsTracker2 = this.tracker;
            if (publishDetailsTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            Intrinsics.checkNotNullExpressionValue(screenTransfer, "it");
            publishDetailsTracker2.recover(screenTransfer, z ? EditParametersScreen.INSTANCE : PublishParametersScreen.INSTANCE);
            return true;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setUploadingInteractor(@NotNull UploadingInteractor uploadingInteractor2) {
        Intrinsics.checkNotNullParameter(uploadingInteractor2, "<set-?>");
        this.uploadingInteractor = uploadingInteractor2;
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void showCpaTariffRequestScreen(int i2) {
        startActivity(getActivityIntentFactory().createCpaTariffActivity(i2));
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void showHelpCenterScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String path = new URL(str).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URL(url).path");
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        String substring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        startActivity(getActivityIntentFactory().helpCenterIntent(substring));
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void showPhoneVerificationScreen(@NotNull ContactInfoSlotWrapper.PhoneVerificationData phoneVerificationData) {
        Intrinsics.checkNotNullParameter(phoneVerificationData, "phoneVerificationData");
        startActivityForResult(PhoneConfirmationIntentFactory.DefaultImpls.phoneVerificationIntent$default(getActivityIntentFactory(), phoneVerificationData.getPhone(), phoneVerificationData.getManager(), phoneVerificationData.isCompany(), false, 8, null), 5);
    }

    @Override // com.avito.android.publish.view.ItemDetailsParameterClickListener.Router, com.avito.android.publish.details.PublishDetailsPresenter.Router
    public void showResidentialComplexSuggestScreen() {
        AddressParameter.Value value;
        AddressParameter.Value value2;
        PublishViewModel publishViewModel = this.g;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        Double d = null;
        AddressParameter addressParameter = categoryParameters != null ? (AddressParameter) categoryParameters.getFirstParameterOfType(AddressParameter.class) : null;
        ActivityIntentFactory activityIntentFactory = getActivityIntentFactory();
        Double valueOf = (addressParameter == null || (value2 = (AddressParameter.Value) addressParameter.getValue()) == null) ? null : Double.valueOf(value2.getLat());
        if (!(addressParameter == null || (value = (AddressParameter.Value) addressParameter.getValue()) == null)) {
            d = Double.valueOf(value.getLng());
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.createResidentialComplexSuggestActivity$default(activityIntentFactory, valueOf, d, null, 4, null), 6);
    }
}
