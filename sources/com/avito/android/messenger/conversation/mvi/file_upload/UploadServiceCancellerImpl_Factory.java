package com.avito.android.messenger.conversation.mvi.file_upload;

import dagger.internal.Factory;
public final class UploadServiceCancellerImpl_Factory implements Factory<UploadServiceCancellerImpl> {

    public static final class a {
        public static final UploadServiceCancellerImpl_Factory a = new UploadServiceCancellerImpl_Factory();
    }

    public static UploadServiceCancellerImpl_Factory create() {
        return a.a;
    }

    public static UploadServiceCancellerImpl newInstance() {
        return new UploadServiceCancellerImpl();
    }

    @Override // javax.inject.Provider
    public UploadServiceCancellerImpl get() {
        return newInstance();
    }
}
