package com.avito.android.app.task;

import dagger.internal.Factory;
public final class DeleteOldClickstreamStorageTask_Factory implements Factory<DeleteOldClickstreamStorageTask> {

    public static final class a {
        public static final DeleteOldClickstreamStorageTask_Factory a = new DeleteOldClickstreamStorageTask_Factory();
    }

    public static DeleteOldClickstreamStorageTask_Factory create() {
        return a.a;
    }

    public static DeleteOldClickstreamStorageTask newInstance() {
        return new DeleteOldClickstreamStorageTask();
    }

    @Override // javax.inject.Provider
    public DeleteOldClickstreamStorageTask get() {
        return newInstance();
    }
}
