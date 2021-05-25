package com.avito.android.messenger.di;

import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessorListener;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessorListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListenerViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor>> b;
    public final Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> c;
    public final Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> d;
    public final Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> e;
    public final Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> f;
    public final Provider<RequestReviewLinkProcessorListener> g;
    public final Provider<AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor>> h;
    public final Provider<UpdateFolderTagsLinkProcessorListener> i;

    public ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListenerViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor>> provider, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider2, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider3, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider4, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider5, Provider<RequestReviewLinkProcessorListener> provider6, Provider<AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor>> provider7, Provider<UpdateFolderTagsLinkProcessorListener> provider8) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    public static ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListenerViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor>> provider, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider2, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider3, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider4, Provider<AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor>> provider5, Provider<RequestReviewLinkProcessorListener> provider6, Provider<AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor>> provider7, Provider<UpdateFolderTagsLinkProcessorListener> provider8) {
        return new ChannelFragmentModule_ProvideCompositeDeeplinkProcessorListenerViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ViewModel provideCompositeDeeplinkProcessorListenerViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> abstractDeeplinkProcessorListener, AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener2, AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener3, AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener4, AbstractDeeplinkProcessorListener<PayoutInitLinkProcessor> abstractDeeplinkProcessorListener5, RequestReviewLinkProcessorListener requestReviewLinkProcessorListener, AbstractDeeplinkProcessorListener<DeliveryOrderCancelLinkProcessor> abstractDeeplinkProcessorListener6, UpdateFolderTagsLinkProcessorListener updateFolderTagsLinkProcessorListener) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideCompositeDeeplinkProcessorListenerViewModel$messenger_release(abstractDeeplinkProcessorListener, abstractDeeplinkProcessorListener2, abstractDeeplinkProcessorListener3, abstractDeeplinkProcessorListener4, abstractDeeplinkProcessorListener5, requestReviewLinkProcessorListener, abstractDeeplinkProcessorListener6, updateFolderTagsLinkProcessorListener));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideCompositeDeeplinkProcessorListenerViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get());
    }
}
