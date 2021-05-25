package com.avito.android.profile.sessions.list;

import com.avito.android.deep_linking.links.SessionDeleteLink;
import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.profile.sessions.adapter.session.SessionItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"profile_release"}, k = 2, mv = {1, 4, 2})
public final class SessionsListPresenterKt {
    public static final boolean access$isCorrespondsTo(SessionsListItem sessionsListItem, SessionDeleteLink sessionDeleteLink) {
        String sessionIdHash = sessionDeleteLink.getSessionIdHash();
        if (sessionIdHash == null) {
            sessionIdHash = sessionDeleteLink.getDeviceId();
        }
        return (sessionsListItem instanceof SessionItem) && Intrinsics.areEqual(sessionsListItem.getStringId(), sessionIdHash);
    }
}
