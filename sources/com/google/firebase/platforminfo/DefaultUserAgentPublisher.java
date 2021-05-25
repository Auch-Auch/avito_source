package com.google.firebase.platforminfo;

import a2.j.e.k.b;
import a2.j.e.k.c;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
public class DefaultUserAgentPublisher implements UserAgentPublisher {
    public final String a;
    public final GlobalLibraryVersionRegistrar b;

    public DefaultUserAgentPublisher(Set<c> set, GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar) {
        this.a = a(set);
        this.b = globalLibraryVersionRegistrar;
    }

    public static String a(Set<c> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<c> it = set.iterator();
        while (it.hasNext()) {
            c next = it.next();
            sb.append(next.a());
            sb.append('/');
            sb.append(next.b());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static Component<UserAgentPublisher> component() {
        return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(c.class)).factory(b.a).build();
    }

    @Override // com.google.firebase.platforminfo.UserAgentPublisher
    public String getUserAgent() {
        Set unmodifiableSet;
        Set unmodifiableSet2;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = this.b;
        synchronized (globalLibraryVersionRegistrar.a) {
            unmodifiableSet = Collections.unmodifiableSet(globalLibraryVersionRegistrar.a);
        }
        if (unmodifiableSet.isEmpty()) {
            return this.a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(' ');
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = this.b;
        synchronized (globalLibraryVersionRegistrar2.a) {
            unmodifiableSet2 = Collections.unmodifiableSet(globalLibraryVersionRegistrar2.a);
        }
        sb.append(a(unmodifiableSet2));
        return sb.toString();
    }
}
