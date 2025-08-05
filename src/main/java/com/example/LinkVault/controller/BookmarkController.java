package com.example.LinkVault.controller;

import com.example.LinkVault.model.Bookmark;
import com.example.LinkVault.service.BookmarkService;
import com.example.LinkVault.service.BookmarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmark")
@CrossOrigin(origins = "*")
public class BookmarkController {

    @Autowired
    BookmarkServiceImpl bookmarkService;

    //Create bookmark
    @PostMapping
    public ResponseEntity<Bookmark> createBookmark (@RequestBody Bookmark bookmark, @RequestParam("userId") Long userId) {
        Bookmark saved = bookmarkService.createBookmark(bookmark, userId);
        return ResponseEntity.ok(saved);
    }

    //Get Bookmark
    @GetMapping("{bookmarkId}")
    public ResponseEntity<Bookmark> getBookmarkById(@PathVariable("bookmarkId") Long id) {
        Bookmark bookmark = bookmarkService.getBookmarkById(id);
        return ResponseEntity.ok(bookmark);
    }

    //Update Bookmark
    @PutMapping("{bookmarkId}")
    public ResponseEntity<Bookmark> updateBookmark (@PathVariable("bookmarkId") Long id, @RequestBody Bookmark updatedBookmark) {
        Bookmark bookmark = bookmarkService.updateBookmark(id, updatedBookmark);
        return ResponseEntity.ok(bookmark);
    }

    //Delete Bookmark
    @DeleteMapping("{bookmarkId}")
    public String deleteBookmark (@PathVariable("bookmarkId") Long id) {
        bookmarkService.deleteBookmark(id);
        return ("Bookmark with ID - " + id + " is deleted");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bookmark>> getBookmarksByUserId(@PathVariable("userId") Long userId) {
        List<Bookmark> bookmarks = bookmarkService.getBookmarksByUserId(userId);
        return ResponseEntity.ok(bookmarks);
    }

}
