package com.avito.android.photo_picker.camera;

import dagger.internal.Factory;
public final class FourByThreePhotoResizer_Factory implements Factory<FourByThreePhotoResizer> {

    public static final class a {
        public static final FourByThreePhotoResizer_Factory a = new FourByThreePhotoResizer_Factory();
    }

    public static FourByThreePhotoResizer_Factory create() {
        return a.a;
    }

    public static FourByThreePhotoResizer newInstance() {
        return new FourByThreePhotoResizer();
    }

    @Override // javax.inject.Provider
    public FourByThreePhotoResizer get() {
        return newInstance();
    }
}
