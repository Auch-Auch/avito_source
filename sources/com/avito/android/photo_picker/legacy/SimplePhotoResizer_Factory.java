package com.avito.android.photo_picker.legacy;

import dagger.internal.Factory;
public final class SimplePhotoResizer_Factory implements Factory<SimplePhotoResizer> {

    public static final class a {
        public static final SimplePhotoResizer_Factory a = new SimplePhotoResizer_Factory();
    }

    public static SimplePhotoResizer_Factory create() {
        return a.a;
    }

    public static SimplePhotoResizer newInstance() {
        return new SimplePhotoResizer();
    }

    @Override // javax.inject.Provider
    public SimplePhotoResizer get() {
        return newInstance();
    }
}
