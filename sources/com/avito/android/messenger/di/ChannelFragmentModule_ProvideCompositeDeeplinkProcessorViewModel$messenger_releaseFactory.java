package com.avito.android.messenger.di;

import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.cancel_order.DeliveryOrderCancelLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.delete_channel.DeleteChannelDeeplinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.payout.PayoutInitLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.review.RequestReviewLinkProcessor;
import com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags.UpdateFolderTagsLinkProcessor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideCompositeDeeplinkProcessorViewModel$messenger_releaseFactory implements Factory<ViewModel> {
    public final ChannelFragmentModule a;
    public final Provider<DefaultDeeplinkProcessor> b;
    public final Provider<PayoutInitLinkProcessor> c;
    public final Provider<PayoutInitLinkProcessor> d;
    public final Provider<PayoutInitLinkProcessor> e;
    public final Provider<PayoutInitLinkProcessor> f;
    public final Provider<DeliveryOrderCancelLinkProcessor> g;
    public final Provider<RequestReviewLinkProcessor> h;
    public final Provider<DeleteChannelDeeplinkProcessor> i;
    public final Provider<UpdateFolderTagsLinkProcessor> j;

    public ChannelFragmentModule_ProvideCompositeDeeplinkProcessorViewModel$messenger_releaseFactory(ChannelFragmentModule channelFragmentModule, Provider<DefaultDeeplinkProcessor> provider, Provider<PayoutInitLinkProcessor> provider2, Provider<PayoutInitLinkProcessor> provider3, Provider<PayoutInitLinkProcessor> provider4, Provider<PayoutInitLinkProcessor> provider5, Provider<DeliveryOrderCancelLinkProcessor> provider6, Provider<RequestReviewLinkProcessor> provider7, Provider<DeleteChannelDeeplinkProcessor> provider8, Provider<UpdateFolderTagsLinkProcessor> provider9) {
        this.a = channelFragmentModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
    }

    public static ChannelFragmentModule_ProvideCompositeDeeplinkProcessorViewModel$messenger_releaseFactory create(ChannelFragmentModule channelFragmentModule, Provider<DefaultDeeplinkProcessor> provider, Provider<PayoutInitLinkProcessor> provider2, Provider<PayoutInitLinkProcessor> provider3, Provider<PayoutInitLinkProcessor> provider4, Provider<PayoutInitLinkProcessor> provider5, Provider<DeliveryOrderCancelLinkProcessor> provider6, Provider<RequestReviewLinkProcessor> provider7, Provider<DeleteChannelDeeplinkProcessor> provider8, Provider<UpdateFolderTagsLinkProcessor> provider9) {
        return new ChannelFragmentModule_ProvideCompositeDeeplinkProcessorViewModel$messenger_releaseFactory(channelFragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static ViewModel provideCompositeDeeplinkProcessorViewModel$messenger_release(ChannelFragmentModule channelFragmentModule, DefaultDeeplinkProcessor defaultDeeplinkProcessor, PayoutInitLinkProcessor payoutInitLinkProcessor, PayoutInitLinkProcessor payoutInitLinkProcessor2, PayoutInitLinkProcessor payoutInitLinkProcessor3, PayoutInitLinkProcessor payoutInitLinkProcessor4, DeliveryOrderCancelLinkProcessor deliveryOrderCancelLinkProcessor, RequestReviewLinkProcessor requestReviewLinkProcessor, DeleteChannelDeeplinkProcessor deleteChannelDeeplinkProcessor, UpdateFolderTagsLinkProcessor updateFolderTagsLinkProcessor) {
        return (ViewModel) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideCompositeDeeplinkProcessorViewModel$messenger_release(defaultDeeplinkProcessor, payoutInitLinkProcessor, payoutInitLinkProcessor2, payoutInitLinkProcessor3, payoutInitLinkProcessor4, deliveryOrderCancelLinkProcessor, requestReviewLinkProcessor, deleteChannelDeeplinkProcessor, updateFolderTagsLinkProcessor));
    }

    @Override // javax.inject.Provider
    public ViewModel get() {
        return provideCompositeDeeplinkProcessorViewModel$messenger_release(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get());
    }
}
