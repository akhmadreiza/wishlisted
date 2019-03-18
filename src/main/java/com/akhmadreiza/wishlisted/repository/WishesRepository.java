package com.akhmadreiza.wishlisted.repository;

import com.akhmadreiza.wishlisted.entity.Wishestbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishesRepository extends JpaRepository<Wishestbl, String> {
}
