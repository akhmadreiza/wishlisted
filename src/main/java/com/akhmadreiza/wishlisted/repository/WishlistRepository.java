package com.akhmadreiza.wishlisted.repository;

import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends JpaRepository<Wishliststbl, String> {
}
