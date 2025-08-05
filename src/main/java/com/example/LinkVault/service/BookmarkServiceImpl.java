package com.example.LinkVault.service;

import com.example.LinkVault.model.Bookmark;
import com.example.LinkVault.model.User;
import com.example.LinkVault.repo.BookmarkRepo;
import com.example.LinkVault.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookmarkServiceImpl implements  BookmarkService{

    @Autowired
    BookmarkRepo bookmarkRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public Bookmark createBookmark(Bookmark bookmark, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        bookmark.setUser(user);
        return bookmarkRepo.save(bookmark);
    }


    @Override
    public Bookmark getBookmarkById(Long id) {
        Optional<Bookmark> bookmark = bookmarkRepo.findById(id);
        if(bookmark==null)
            throw new RuntimeException("Bookmark not found");
        return bookmark.get();
    }

    @Override
    public Bookmark updateBookmark(Long id, Bookmark updatedBookmark) {
        Bookmark bookmark = bookmarkRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookmark not found"));
        bookmark.setUrl(updatedBookmark.getUrl());
        bookmark.setCategory(updatedBookmark.getCategory());
        bookmark.setDescription(updatedBookmark.getDescription());
        bookmark.setTitle(updatedBookmark.getTitle());

        return bookmarkRepo.save(bookmark);
    }

    @Override
    public void deleteBookmark(Long id) {
        bookmarkRepo.deleteById(id);
    }

    @Override
    public List<Bookmark> getBookmarksByUserId(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getBookmarkList();
    }

}
