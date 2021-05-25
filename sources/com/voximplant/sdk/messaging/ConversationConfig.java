package com.voximplant.sdk.messaging;

import java.util.List;
import java.util.Map;
public class ConversationConfig {
    public String a;
    public boolean b;
    public boolean c;
    public Map<String, Object> d;
    public List<ConversationParticipant> e;
    public boolean f;

    public class ConversationConfigBuilder {
        public ConversationConfigBuilder(a aVar) {
        }

        public ConversationConfig build() {
            return ConversationConfig.this;
        }

        public ConversationConfigBuilder setCustomData(Map<String, Object> map) {
            ConversationConfig.this.d = map;
            return this;
        }

        public ConversationConfigBuilder setDirect(boolean z) {
            ConversationConfig.this.b = z;
            return this;
        }

        public ConversationConfigBuilder setParticipants(List<ConversationParticipant> list) {
            ConversationConfig.this.e = list;
            return this;
        }

        public ConversationConfigBuilder setPublicJoin(boolean z) {
            ConversationConfig.this.c = z;
            return this;
        }

        public ConversationConfigBuilder setTitle(String str) {
            ConversationConfig.this.a = str;
            return this;
        }

        public ConversationConfigBuilder setUber(boolean z) {
            ConversationConfig.this.f = z;
            return this;
        }
    }

    public static ConversationConfigBuilder createBuilder() {
        return new ConversationConfigBuilder(null);
    }

    public Map<String, Object> getCustomData() {
        return this.d;
    }

    public List<ConversationParticipant> getParticipants() {
        return this.e;
    }

    public String getTitle() {
        return this.a;
    }

    public boolean isDirect() {
        return this.b;
    }

    public boolean isPublicJoin() {
        return this.c;
    }

    public boolean isUber() {
        return this.f;
    }
}
