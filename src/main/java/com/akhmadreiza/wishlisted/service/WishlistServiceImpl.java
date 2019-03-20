package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import com.akhmadreiza.wishlisted.repository.WishlistRepository;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private GeneralUtil arautil = new GeneralUtil();
    private static List<Wishlists> staticList = new ArrayList<>();
    private static Wishlists staticWishlist =  new Wishlists();

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public List<Wishlists> getAllWishlist() {
        List<Wishlists> allWishlists = new ArrayList<>();
        wishlistRepository.findAll().forEach(wishliststbl -> allWishlists.add(new Wishlists(wishliststbl)));
        return allWishlists;
    }

    @Override
    public Wishlists getWishlistById(String id) {
        return new Wishlists(wishlistRepository.findById(id).get());
    }

    @Override
    public Wishlists addWishlist(Wishlists wishlists) {
        Wishliststbl wishliststbl = new Wishliststbl();
        wishliststbl.setId(wishlists.getId());
        wishliststbl.setDtCreated(wishlists.getDtCreated());
        wishliststbl.setCreatedBy(wishlists.getCreatedBy());
        wishliststbl.setName(wishlists.getName());
        wishliststbl.setDtUpdated(wishlists.getDtUpdated());
        wishliststbl.setUpdatedBy(wishlists.getUpdatedBy());
        wishlistRepository.save(wishliststbl);
        return new Wishlists(wishlists.getId(), wishlists.getName());
    }

    @Override
    public Wishlists updateWishlists(Wishlists wishlists) {
        return addWishlist(wishlists);
    }

    @Override
    public void deleteWishlists(String id) {
        wishlistRepository.deleteById(id);
    }

    static {
        GeneralUtil arautil = new GeneralUtil();

        Wishlists wishlists1 = new Wishlists();
        wishlists1.setId(arautil.getUUID());
        wishlists1.setName("static wishlist for starter 1");
        wishlists1.setCreatedBy("SYSTEM");
        wishlists1.setDtCreated(arautil.getCurrentLocalDateTime());

        Wishlists wishlists2 = new Wishlists();
        wishlists2.setId(arautil.getUUID());
        wishlists2.setName("static wishlist for starter 2");
        wishlists2.setCreatedBy("SYSTEM");
        wishlists2.setDtCreated(arautil.getCurrentLocalDateTime());

        staticList.add(wishlists1);
        staticList.add(wishlists2);
    }
}
