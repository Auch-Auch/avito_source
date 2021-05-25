package com.avito.android.publish.view;

import dagger.internal.Factory;
public final class LocationParameterClickListenerImpl_Factory implements Factory<LocationParameterClickListenerImpl> {

    public static final class a {
        public static final LocationParameterClickListenerImpl_Factory a = new LocationParameterClickListenerImpl_Factory();
    }

    public static LocationParameterClickListenerImpl_Factory create() {
        return a.a;
    }

    public static LocationParameterClickListenerImpl newInstance() {
        return new LocationParameterClickListenerImpl();
    }

    @Override // javax.inject.Provider
    public LocationParameterClickListenerImpl get() {
        return newInstance();
    }
}
