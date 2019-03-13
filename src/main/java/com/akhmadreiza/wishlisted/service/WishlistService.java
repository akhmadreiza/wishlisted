package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishlistService {
    List<Wishlists> getAllWishlist();
}
