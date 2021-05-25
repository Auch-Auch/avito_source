package com.yandex.mapkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.bindings.Archive;
import com.yandex.runtime.bindings.Serializable;
public class Attribution implements Serializable {
    private Author author;
    private Link link;

    public Attribution(@Nullable Author author2, @Nullable Link link2) {
        this.author = author2;
        this.link = link2;
    }

    @Nullable
    public Author getAuthor() {
        return this.author;
    }

    @Nullable
    public Link getLink() {
        return this.link;
    }

    @Override // com.yandex.runtime.bindings.Serializable
    public void serialize(Archive archive) {
        this.author = (Author) archive.add((Archive) this.author, true, (Class<Archive>) Author.class);
        this.link = (Link) archive.add((Archive) this.link, true, (Class<Archive>) Link.class);
    }

    public static class Link implements Serializable {
        private String href;

        public Link(@NonNull String str) {
            if (str != null) {
                this.href = str;
                return;
            }
            throw new IllegalArgumentException("Required field \"href\" cannot be null");
        }

        @NonNull
        public String getHref() {
            return this.href;
        }

        @Override // com.yandex.runtime.bindings.Serializable
        public void serialize(Archive archive) {
            this.href = archive.add(this.href, false);
        }

        public Link() {
        }
    }

    public Attribution() {
    }

    public static class Author implements Serializable {
        private String email;
        private String name;
        private String uri;

        public Author(@NonNull String str, @Nullable String str2, @Nullable String str3) {
            if (str != null) {
                this.name = str;
                this.uri = str2;
                this.email = str3;
                return;
            }
            throw new IllegalArgumentException("Required field \"name\" cannot be null");
        }

        @Nullable
        public String getEmail() {
            return this.email;
        }

        @NonNull
        public String getName() {
            return this.name;
        }

        @Nullable
        public String getUri() {
            return this.uri;
        }

        @Override // com.yandex.runtime.bindings.Serializable
        public void serialize(Archive archive) {
            this.name = archive.add(this.name, false);
            this.uri = archive.add(this.uri, true);
            this.email = archive.add(this.email, true);
        }

        public Author() {
        }
    }
}
