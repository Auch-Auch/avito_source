package com.vk.sdk.api;

import com.vk.sdk.api.methods.VKApiAudio;
import com.vk.sdk.api.methods.VKApiDocs;
import com.vk.sdk.api.methods.VKApiFriends;
import com.vk.sdk.api.methods.VKApiGroups;
import com.vk.sdk.api.methods.VKApiMessages;
import com.vk.sdk.api.methods.VKApiPhotos;
import com.vk.sdk.api.methods.VKApiUsers;
import com.vk.sdk.api.methods.VKApiVideo;
import com.vk.sdk.api.methods.VKApiWall;
import com.vk.sdk.api.photo.VKUploadAlbumPhotoRequest;
import com.vk.sdk.api.photo.VKUploadImage;
import com.vk.sdk.api.photo.VKUploadMessagesPhotoRequest;
import com.vk.sdk.api.photo.VKUploadWallPhotoRequest;
import java.io.File;
public class VKApi {
    public static VKApiAudio audio() {
        return new VKApiAudio();
    }

    public static VKApiDocs docs() {
        return new VKApiDocs();
    }

    public static VKApiFriends friends() {
        return new VKApiFriends();
    }

    public static VKApiGroups groups() {
        return new VKApiGroups();
    }

    public static VKApiMessages messages() {
        return new VKApiMessages();
    }

    public static VKApiPhotos photos() {
        return new VKApiPhotos();
    }

    public static VKRequest uploadAlbumPhotoRequest(File file, long j, int i) {
        return new VKUploadAlbumPhotoRequest(file, j, (long) i);
    }

    public static VKRequest uploadMessagesPhotoRequest(File file) {
        return new VKUploadMessagesPhotoRequest(file);
    }

    public static VKRequest uploadWallPhotoRequest(File file, long j, int i) {
        return new VKUploadWallPhotoRequest(file, j, i);
    }

    public static VKApiUsers users() {
        return new VKApiUsers();
    }

    public static VKApiVideo video() {
        return new VKApiVideo();
    }

    public static VKApiWall wall() {
        return new VKApiWall();
    }

    public static VKRequest uploadAlbumPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        return new VKUploadAlbumPhotoRequest(vKUploadImage, j, (long) i);
    }

    public static VKRequest uploadMessagesPhotoRequest(VKUploadImage vKUploadImage) {
        return new VKUploadMessagesPhotoRequest(vKUploadImage);
    }

    public static VKRequest uploadWallPhotoRequest(VKUploadImage vKUploadImage, long j, int i) {
        return new VKUploadWallPhotoRequest(vKUploadImage, j, i);
    }
}
