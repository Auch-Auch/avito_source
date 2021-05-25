package com.avito.android.messenger.di;

import com.avito.android.messenger.conversation.adapter.app_call.IncomingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.app_call.OutgoingAppCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.IncomingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.call.OutgoingCallMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.IncomingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.deleted.OutgoingDeletedMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.file.IncomingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.file.OutgoingFileMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.IncomingImageMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.image.OutgoingImageMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.item.IncomingItemMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.item.OutgoingItemMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.link.IncomingLinkSnippetMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.link.OutgoingLinkSnippetMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.location.IncomingLocationMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.location.OutgoingLocationMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.new_messages_divider.NewMessagesDividerBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_error.PaginationErrorBlueprint;
import com.avito.android.messenger.conversation.adapter.pagination_in_progress.PaginationInProgressBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.geo.PlatformGeoMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.image.PlatformImageMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.item.PlatformItemMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_avito.text.PlatformTextMessageFromAvitoBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.IncomingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.item.OutgoingPlatformItemMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.IncomingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.platform.from_user.text.OutgoingPlatformTextMessageFromUserBlueprint;
import com.avito.android.messenger.conversation.adapter.spam_actions.SpamActionsBlueprint;
import com.avito.android.messenger.conversation.adapter.system.SystemTextBlueprint;
import com.avito.android.messenger.conversation.adapter.text.IncomingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.text.OutgoingTextMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.typing.TypingIndicatorBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.IncomingUnknownMessageBlueprint;
import com.avito.android.messenger.conversation.adapter.unknown.OutgoingUnknownMessageBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class MessageAdapterModule_ProvideMessageItemBinderFactory implements Factory<ItemBinder> {
    public final Provider<SpamActionsBlueprint> A;
    public final Provider<PlatformGeoMessageFromAvitoBlueprint> B;
    public final Provider<PlatformImageMessageFromAvitoBlueprint> C;
    public final Provider<PlatformItemMessageFromAvitoBlueprint> D;
    public final Provider<PlatformTextMessageFromAvitoBlueprint> E;
    public final Provider<IncomingPlatformTextMessageFromUserBlueprint> F;
    public final Provider<OutgoingPlatformTextMessageFromUserBlueprint> G;
    public final Provider<IncomingPlatformItemMessageFromUserBlueprint> H;
    public final Provider<OutgoingPlatformItemMessageFromUserBlueprint> I;
    public final MessageAdapterModule a;
    public final Provider<IncomingItemMessageBlueprint> b;
    public final Provider<OutgoingItemMessageBlueprint> c;
    public final Provider<IncomingImageMessageBlueprint> d;
    public final Provider<OutgoingImageMessageBlueprint> e;
    public final Provider<IncomingTextMessageBlueprint> f;
    public final Provider<OutgoingTextMessageBlueprint> g;
    public final Provider<IncomingUnknownMessageBlueprint> h;
    public final Provider<OutgoingUnknownMessageBlueprint> i;
    public final Provider<SystemTextBlueprint> j;
    public final Provider<NewMessagesDividerBlueprint> k;
    public final Provider<PaginationErrorBlueprint> l;
    public final Provider<PaginationInProgressBlueprint> m;
    public final Provider<IncomingCallMessageBlueprint> n;
    public final Provider<OutgoingCallMessageBlueprint> o;
    public final Provider<TypingIndicatorBlueprint> p;
    public final Provider<IncomingLinkSnippetMessageBlueprint> q;
    public final Provider<OutgoingLinkSnippetMessageBlueprint> r;
    public final Provider<IncomingLocationMessageBlueprint> s;
    public final Provider<OutgoingLocationMessageBlueprint> t;
    public final Provider<IncomingFileMessageBlueprint> u;
    public final Provider<OutgoingFileMessageBlueprint> v;
    public final Provider<IncomingDeletedMessageBlueprint> w;
    public final Provider<OutgoingDeletedMessageBlueprint> x;
    public final Provider<IncomingAppCallMessageBlueprint> y;
    public final Provider<OutgoingAppCallMessageBlueprint> z;

    public MessageAdapterModule_ProvideMessageItemBinderFactory(MessageAdapterModule messageAdapterModule, Provider<IncomingItemMessageBlueprint> provider, Provider<OutgoingItemMessageBlueprint> provider2, Provider<IncomingImageMessageBlueprint> provider3, Provider<OutgoingImageMessageBlueprint> provider4, Provider<IncomingTextMessageBlueprint> provider5, Provider<OutgoingTextMessageBlueprint> provider6, Provider<IncomingUnknownMessageBlueprint> provider7, Provider<OutgoingUnknownMessageBlueprint> provider8, Provider<SystemTextBlueprint> provider9, Provider<NewMessagesDividerBlueprint> provider10, Provider<PaginationErrorBlueprint> provider11, Provider<PaginationInProgressBlueprint> provider12, Provider<IncomingCallMessageBlueprint> provider13, Provider<OutgoingCallMessageBlueprint> provider14, Provider<TypingIndicatorBlueprint> provider15, Provider<IncomingLinkSnippetMessageBlueprint> provider16, Provider<OutgoingLinkSnippetMessageBlueprint> provider17, Provider<IncomingLocationMessageBlueprint> provider18, Provider<OutgoingLocationMessageBlueprint> provider19, Provider<IncomingFileMessageBlueprint> provider20, Provider<OutgoingFileMessageBlueprint> provider21, Provider<IncomingDeletedMessageBlueprint> provider22, Provider<OutgoingDeletedMessageBlueprint> provider23, Provider<IncomingAppCallMessageBlueprint> provider24, Provider<OutgoingAppCallMessageBlueprint> provider25, Provider<SpamActionsBlueprint> provider26, Provider<PlatformGeoMessageFromAvitoBlueprint> provider27, Provider<PlatformImageMessageFromAvitoBlueprint> provider28, Provider<PlatformItemMessageFromAvitoBlueprint> provider29, Provider<PlatformTextMessageFromAvitoBlueprint> provider30, Provider<IncomingPlatformTextMessageFromUserBlueprint> provider31, Provider<OutgoingPlatformTextMessageFromUserBlueprint> provider32, Provider<IncomingPlatformItemMessageFromUserBlueprint> provider33, Provider<OutgoingPlatformItemMessageFromUserBlueprint> provider34) {
        this.a = messageAdapterModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
        this.j = provider9;
        this.k = provider10;
        this.l = provider11;
        this.m = provider12;
        this.n = provider13;
        this.o = provider14;
        this.p = provider15;
        this.q = provider16;
        this.r = provider17;
        this.s = provider18;
        this.t = provider19;
        this.u = provider20;
        this.v = provider21;
        this.w = provider22;
        this.x = provider23;
        this.y = provider24;
        this.z = provider25;
        this.A = provider26;
        this.B = provider27;
        this.C = provider28;
        this.D = provider29;
        this.E = provider30;
        this.F = provider31;
        this.G = provider32;
        this.H = provider33;
        this.I = provider34;
    }

    public static MessageAdapterModule_ProvideMessageItemBinderFactory create(MessageAdapterModule messageAdapterModule, Provider<IncomingItemMessageBlueprint> provider, Provider<OutgoingItemMessageBlueprint> provider2, Provider<IncomingImageMessageBlueprint> provider3, Provider<OutgoingImageMessageBlueprint> provider4, Provider<IncomingTextMessageBlueprint> provider5, Provider<OutgoingTextMessageBlueprint> provider6, Provider<IncomingUnknownMessageBlueprint> provider7, Provider<OutgoingUnknownMessageBlueprint> provider8, Provider<SystemTextBlueprint> provider9, Provider<NewMessagesDividerBlueprint> provider10, Provider<PaginationErrorBlueprint> provider11, Provider<PaginationInProgressBlueprint> provider12, Provider<IncomingCallMessageBlueprint> provider13, Provider<OutgoingCallMessageBlueprint> provider14, Provider<TypingIndicatorBlueprint> provider15, Provider<IncomingLinkSnippetMessageBlueprint> provider16, Provider<OutgoingLinkSnippetMessageBlueprint> provider17, Provider<IncomingLocationMessageBlueprint> provider18, Provider<OutgoingLocationMessageBlueprint> provider19, Provider<IncomingFileMessageBlueprint> provider20, Provider<OutgoingFileMessageBlueprint> provider21, Provider<IncomingDeletedMessageBlueprint> provider22, Provider<OutgoingDeletedMessageBlueprint> provider23, Provider<IncomingAppCallMessageBlueprint> provider24, Provider<OutgoingAppCallMessageBlueprint> provider25, Provider<SpamActionsBlueprint> provider26, Provider<PlatformGeoMessageFromAvitoBlueprint> provider27, Provider<PlatformImageMessageFromAvitoBlueprint> provider28, Provider<PlatformItemMessageFromAvitoBlueprint> provider29, Provider<PlatformTextMessageFromAvitoBlueprint> provider30, Provider<IncomingPlatformTextMessageFromUserBlueprint> provider31, Provider<OutgoingPlatformTextMessageFromUserBlueprint> provider32, Provider<IncomingPlatformItemMessageFromUserBlueprint> provider33, Provider<OutgoingPlatformItemMessageFromUserBlueprint> provider34) {
        return new MessageAdapterModule_ProvideMessageItemBinderFactory(messageAdapterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23, provider24, provider25, provider26, provider27, provider28, provider29, provider30, provider31, provider32, provider33, provider34);
    }

    public static ItemBinder provideMessageItemBinder(MessageAdapterModule messageAdapterModule, IncomingItemMessageBlueprint incomingItemMessageBlueprint, OutgoingItemMessageBlueprint outgoingItemMessageBlueprint, IncomingImageMessageBlueprint incomingImageMessageBlueprint, OutgoingImageMessageBlueprint outgoingImageMessageBlueprint, IncomingTextMessageBlueprint incomingTextMessageBlueprint, OutgoingTextMessageBlueprint outgoingTextMessageBlueprint, IncomingUnknownMessageBlueprint incomingUnknownMessageBlueprint, OutgoingUnknownMessageBlueprint outgoingUnknownMessageBlueprint, SystemTextBlueprint systemTextBlueprint, NewMessagesDividerBlueprint newMessagesDividerBlueprint, PaginationErrorBlueprint paginationErrorBlueprint, PaginationInProgressBlueprint paginationInProgressBlueprint, IncomingCallMessageBlueprint incomingCallMessageBlueprint, OutgoingCallMessageBlueprint outgoingCallMessageBlueprint, TypingIndicatorBlueprint typingIndicatorBlueprint, IncomingLinkSnippetMessageBlueprint incomingLinkSnippetMessageBlueprint, OutgoingLinkSnippetMessageBlueprint outgoingLinkSnippetMessageBlueprint, IncomingLocationMessageBlueprint incomingLocationMessageBlueprint, OutgoingLocationMessageBlueprint outgoingLocationMessageBlueprint, IncomingFileMessageBlueprint incomingFileMessageBlueprint, OutgoingFileMessageBlueprint outgoingFileMessageBlueprint, IncomingDeletedMessageBlueprint incomingDeletedMessageBlueprint, OutgoingDeletedMessageBlueprint outgoingDeletedMessageBlueprint, IncomingAppCallMessageBlueprint incomingAppCallMessageBlueprint, OutgoingAppCallMessageBlueprint outgoingAppCallMessageBlueprint, SpamActionsBlueprint spamActionsBlueprint, PlatformGeoMessageFromAvitoBlueprint platformGeoMessageFromAvitoBlueprint, PlatformImageMessageFromAvitoBlueprint platformImageMessageFromAvitoBlueprint, PlatformItemMessageFromAvitoBlueprint platformItemMessageFromAvitoBlueprint, PlatformTextMessageFromAvitoBlueprint platformTextMessageFromAvitoBlueprint, IncomingPlatformTextMessageFromUserBlueprint incomingPlatformTextMessageFromUserBlueprint, OutgoingPlatformTextMessageFromUserBlueprint outgoingPlatformTextMessageFromUserBlueprint, IncomingPlatformItemMessageFromUserBlueprint incomingPlatformItemMessageFromUserBlueprint, OutgoingPlatformItemMessageFromUserBlueprint outgoingPlatformItemMessageFromUserBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(messageAdapterModule.provideMessageItemBinder(incomingItemMessageBlueprint, outgoingItemMessageBlueprint, incomingImageMessageBlueprint, outgoingImageMessageBlueprint, incomingTextMessageBlueprint, outgoingTextMessageBlueprint, incomingUnknownMessageBlueprint, outgoingUnknownMessageBlueprint, systemTextBlueprint, newMessagesDividerBlueprint, paginationErrorBlueprint, paginationInProgressBlueprint, incomingCallMessageBlueprint, outgoingCallMessageBlueprint, typingIndicatorBlueprint, incomingLinkSnippetMessageBlueprint, outgoingLinkSnippetMessageBlueprint, incomingLocationMessageBlueprint, outgoingLocationMessageBlueprint, incomingFileMessageBlueprint, outgoingFileMessageBlueprint, incomingDeletedMessageBlueprint, outgoingDeletedMessageBlueprint, incomingAppCallMessageBlueprint, outgoingAppCallMessageBlueprint, spamActionsBlueprint, platformGeoMessageFromAvitoBlueprint, platformImageMessageFromAvitoBlueprint, platformItemMessageFromAvitoBlueprint, platformTextMessageFromAvitoBlueprint, incomingPlatformTextMessageFromUserBlueprint, outgoingPlatformTextMessageFromUserBlueprint, incomingPlatformItemMessageFromUserBlueprint, outgoingPlatformItemMessageFromUserBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideMessageItemBinder(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get(), this.h.get(), this.i.get(), this.j.get(), this.k.get(), this.l.get(), this.m.get(), this.n.get(), this.o.get(), this.p.get(), this.q.get(), this.r.get(), this.s.get(), this.t.get(), this.u.get(), this.v.get(), this.w.get(), this.x.get(), this.y.get(), this.z.get(), this.A.get(), this.B.get(), this.C.get(), this.D.get(), this.E.get(), this.F.get(), this.G.get(), this.H.get(), this.I.get());
    }
}
