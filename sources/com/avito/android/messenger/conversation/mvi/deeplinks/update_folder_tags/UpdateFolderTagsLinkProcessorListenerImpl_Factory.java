package com.avito.android.messenger.conversation.mvi.deeplinks.update_folder_tags;

import dagger.internal.Factory;
public final class UpdateFolderTagsLinkProcessorListenerImpl_Factory implements Factory<UpdateFolderTagsLinkProcessorListenerImpl> {

    public static final class a {
        public static final UpdateFolderTagsLinkProcessorListenerImpl_Factory a = new UpdateFolderTagsLinkProcessorListenerImpl_Factory();
    }

    public static UpdateFolderTagsLinkProcessorListenerImpl_Factory create() {
        return a.a;
    }

    public static UpdateFolderTagsLinkProcessorListenerImpl newInstance() {
        return new UpdateFolderTagsLinkProcessorListenerImpl();
    }

    @Override // javax.inject.Provider
    public UpdateFolderTagsLinkProcessorListenerImpl get() {
        return newInstance();
    }
}
