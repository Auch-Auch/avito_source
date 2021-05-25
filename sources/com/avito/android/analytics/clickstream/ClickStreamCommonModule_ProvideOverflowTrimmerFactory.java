package com.avito.android.analytics.clickstream;

import com.avito.android.analytics.inhouse_transport.OverflowTrimmer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import proto.events.apps.EventOuterClass;
public final class ClickStreamCommonModule_ProvideOverflowTrimmerFactory implements Factory<OverflowTrimmer<EventOuterClass.Event>> {

    public static final class a {
        public static final ClickStreamCommonModule_ProvideOverflowTrimmerFactory a = new ClickStreamCommonModule_ProvideOverflowTrimmerFactory();
    }

    public static ClickStreamCommonModule_ProvideOverflowTrimmerFactory create() {
        return a.a;
    }

    public static OverflowTrimmer<EventOuterClass.Event> provideOverflowTrimmer() {
        return (OverflowTrimmer) Preconditions.checkNotNullFromProvides(ClickStreamCommonModule.provideOverflowTrimmer());
    }

    @Override // javax.inject.Provider
    public OverflowTrimmer<EventOuterClass.Event> get() {
        return provideOverflowTrimmer();
    }
}
