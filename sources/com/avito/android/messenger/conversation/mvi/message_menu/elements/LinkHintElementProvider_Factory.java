package com.avito.android.messenger.conversation.mvi.message_menu.elements;

import dagger.internal.Factory;
public final class LinkHintElementProvider_Factory implements Factory<LinkHintElementProvider> {

    public static final class a {
        public static final LinkHintElementProvider_Factory a = new LinkHintElementProvider_Factory();
    }

    public static LinkHintElementProvider_Factory create() {
        return a.a;
    }

    public static LinkHintElementProvider newInstance() {
        return new LinkHintElementProvider();
    }

    @Override // javax.inject.Provider
    public LinkHintElementProvider get() {
        return newInstance();
    }
}
