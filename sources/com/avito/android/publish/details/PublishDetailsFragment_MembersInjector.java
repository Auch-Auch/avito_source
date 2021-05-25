package com.avito.android.publish.details;

import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.SelectItemBaseFragment_MembersInjector;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.view.ItemDetailsBaseFragment_MembersInjector;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.validation.ParametersListPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PublishDetailsFragment_MembersInjector implements MembersInjector<PublishDetailsFragment> {
    public final Provider<ItemDetailsSelectResultHandler> a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<Features> d;
    public final Provider<PublishDetailsPresenter> e;
    public final Provider<Analytics> f;
    public final Provider<DeepLinkIntentFactory> g;
    public final Provider<ImageListPresenter> h;
    public final Provider<UploadingInteractor> i;
    public final Provider<ParametersListPresenter> j;
    public final Provider<RecyclerView.Adapter<?>> k;
    public final Provider<PublishInputsAnalyticTracker> l;
    public final Provider<PublishTagsViewModel> m;
    public final Provider<PublishEventTracker> n;
    public final Provider<ContactsDataSource> o;
    public final Provider<DialogRouter> p;
    public final Provider<PublishDetailsTracker> q;
    public final Provider<HtmlEditorViewModel> r;

    public PublishDetailsFragment_MembersInjector(Provider<ItemDetailsSelectResultHandler> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4, Provider<PublishDetailsPresenter> provider5, Provider<Analytics> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<ImageListPresenter> provider8, Provider<UploadingInteractor> provider9, Provider<ParametersListPresenter> provider10, Provider<RecyclerView.Adapter<?>> provider11, Provider<PublishInputsAnalyticTracker> provider12, Provider<PublishTagsViewModel> provider13, Provider<PublishEventTracker> provider14, Provider<ContactsDataSource> provider15, Provider<DialogRouter> provider16, Provider<PublishDetailsTracker> provider17, Provider<HtmlEditorViewModel> provider18) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
        this.i = provider9;
        this.j = provider10;
        this.k = provider11;
        this.l = provider12;
        this.m = provider13;
        this.n = provider14;
        this.o = provider15;
        this.p = provider16;
        this.q = provider17;
        this.r = provider18;
    }

    public static MembersInjector<PublishDetailsFragment> create(Provider<ItemDetailsSelectResultHandler> provider, Provider<ActivityIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<Features> provider4, Provider<PublishDetailsPresenter> provider5, Provider<Analytics> provider6, Provider<DeepLinkIntentFactory> provider7, Provider<ImageListPresenter> provider8, Provider<UploadingInteractor> provider9, Provider<ParametersListPresenter> provider10, Provider<RecyclerView.Adapter<?>> provider11, Provider<PublishInputsAnalyticTracker> provider12, Provider<PublishTagsViewModel> provider13, Provider<PublishEventTracker> provider14, Provider<ContactsDataSource> provider15, Provider<DialogRouter> provider16, Provider<PublishDetailsTracker> provider17, Provider<HtmlEditorViewModel> provider18) {
        return new PublishDetailsFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.adapter")
    public static void injectAdapter(PublishDetailsFragment publishDetailsFragment, RecyclerView.Adapter<?> adapter) {
        publishDetailsFragment.adapter = adapter;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.analytics")
    public static void injectAnalytics(PublishDetailsFragment publishDetailsFragment, Analytics analytics) {
        publishDetailsFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.contactsDataSource")
    public static void injectContactsDataSource(PublishDetailsFragment publishDetailsFragment, ContactsDataSource contactsDataSource) {
        publishDetailsFragment.contactsDataSource = contactsDataSource;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(PublishDetailsFragment publishDetailsFragment, DeepLinkIntentFactory deepLinkIntentFactory) {
        publishDetailsFragment.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.dialogRouter")
    public static void injectDialogRouter(PublishDetailsFragment publishDetailsFragment, DialogRouter dialogRouter) {
        publishDetailsFragment.dialogRouter = dialogRouter;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.eventTracker")
    public static void injectEventTracker(PublishDetailsFragment publishDetailsFragment, PublishEventTracker publishEventTracker) {
        publishDetailsFragment.eventTracker = publishEventTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.htmlEditorViewModel")
    public static void injectHtmlEditorViewModel(PublishDetailsFragment publishDetailsFragment, HtmlEditorViewModel htmlEditorViewModel) {
        publishDetailsFragment.htmlEditorViewModel = htmlEditorViewModel;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.imageListPresenter")
    public static void injectImageListPresenter(PublishDetailsFragment publishDetailsFragment, ImageListPresenter imageListPresenter) {
        publishDetailsFragment.imageListPresenter = imageListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.inputsAnalyticTracker")
    public static void injectInputsAnalyticTracker(PublishDetailsFragment publishDetailsFragment, PublishInputsAnalyticTracker publishInputsAnalyticTracker) {
        publishDetailsFragment.inputsAnalyticTracker = publishInputsAnalyticTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.paramsPresenter")
    public static void injectParamsPresenter(PublishDetailsFragment publishDetailsFragment, ParametersListPresenter parametersListPresenter) {
        publishDetailsFragment.paramsPresenter = parametersListPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.presenter")
    public static void injectPresenter(PublishDetailsFragment publishDetailsFragment, PublishDetailsPresenter publishDetailsPresenter) {
        publishDetailsFragment.presenter = publishDetailsPresenter;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.tagsViewModel")
    public static void injectTagsViewModel(PublishDetailsFragment publishDetailsFragment, PublishTagsViewModel publishTagsViewModel) {
        publishDetailsFragment.tagsViewModel = publishTagsViewModel;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.tracker")
    public static void injectTracker(PublishDetailsFragment publishDetailsFragment, PublishDetailsTracker publishDetailsTracker) {
        publishDetailsFragment.tracker = publishDetailsTracker;
    }

    @InjectedFieldSignature("com.avito.android.publish.details.PublishDetailsFragment.uploadingInteractor")
    public static void injectUploadingInteractor(PublishDetailsFragment publishDetailsFragment, UploadingInteractor uploadingInteractor) {
        publishDetailsFragment.uploadingInteractor = uploadingInteractor;
    }

    public void injectMembers(PublishDetailsFragment publishDetailsFragment) {
        SelectItemBaseFragment_MembersInjector.injectResultHandler(publishDetailsFragment, this.a.get());
        ItemDetailsBaseFragment_MembersInjector.injectActivityIntentFactory(publishDetailsFragment, this.b.get());
        ItemDetailsBaseFragment_MembersInjector.injectImplicitIntentFactory(publishDetailsFragment, this.c.get());
        ItemDetailsBaseFragment_MembersInjector.injectFeatures(publishDetailsFragment, this.d.get());
        injectPresenter(publishDetailsFragment, this.e.get());
        injectAnalytics(publishDetailsFragment, this.f.get());
        injectDeepLinkIntentFactory(publishDetailsFragment, this.g.get());
        injectImageListPresenter(publishDetailsFragment, this.h.get());
        injectUploadingInteractor(publishDetailsFragment, this.i.get());
        injectParamsPresenter(publishDetailsFragment, this.j.get());
        injectAdapter(publishDetailsFragment, this.k.get());
        injectInputsAnalyticTracker(publishDetailsFragment, this.l.get());
        injectTagsViewModel(publishDetailsFragment, this.m.get());
        injectEventTracker(publishDetailsFragment, this.n.get());
        injectContactsDataSource(publishDetailsFragment, this.o.get());
        injectDialogRouter(publishDetailsFragment, this.p.get());
        injectTracker(publishDetailsFragment, this.q.get());
        injectHtmlEditorViewModel(publishDetailsFragment, this.r.get());
    }
}
