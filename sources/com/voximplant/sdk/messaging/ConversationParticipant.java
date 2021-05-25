package com.voximplant.sdk.messaging;
public class ConversationParticipant {
    public long a;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public long i;

    public ConversationParticipant(long j) {
        this.a = j;
    }

    public boolean canEditAllMessages() {
        return this.e;
    }

    public boolean canEditMessages() {
        return this.c;
    }

    public boolean canManageParticipants() {
        return this.g;
    }

    public boolean canRemoveAllMessages() {
        return this.f;
    }

    public boolean canRemoveMessages() {
        return this.d;
    }

    public boolean canWrite() {
        return this.b;
    }

    public long getIMUserId() {
        return this.a;
    }

    public long getLastReadEventSequence() {
        return this.i;
    }

    public boolean isOwner() {
        return this.h;
    }

    public ConversationParticipant setCanEditAllMessages(boolean z) {
        this.e = z;
        return this;
    }

    public ConversationParticipant setCanEditMessages(boolean z) {
        this.c = z;
        return this;
    }

    public ConversationParticipant setCanManageParticipants(boolean z) {
        this.g = z;
        return this;
    }

    public ConversationParticipant setCanRemoveAllMessages(boolean z) {
        this.f = z;
        return this;
    }

    public ConversationParticipant setCanRemoveMessages(boolean z) {
        this.d = z;
        return this;
    }

    public ConversationParticipant setCanWrite(boolean z) {
        this.b = z;
        return this;
    }

    public ConversationParticipant setOwner(boolean z) {
        this.h = z;
        return this;
    }

    public ConversationParticipant(long j, long j2) {
        this.a = j;
        this.i = j2;
    }
}
