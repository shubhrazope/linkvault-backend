package com.example.LinkVault.repo;

import com.example.LinkVault.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepo extends JpaRepository<Bookmark, Long> {
}
