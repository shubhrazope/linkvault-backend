package com.example.LinkVault.service;

import com.example.LinkVault.model.Bookmark;

import java.util.List;

public interface BookmarkService {
    Bookmark createBookmark(Bookmark bookmark, Long userId);
    Bookmark getBookmarkById(Long id);
    Bookmark updateBookmark(Long id, Bookmark updatedBookmark);
    void deleteBookmark(Long id);
    List<Bookmark> getBookmarksByUserId(Long userId);
}
