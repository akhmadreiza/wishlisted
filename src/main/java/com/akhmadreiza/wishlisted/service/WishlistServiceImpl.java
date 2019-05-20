package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.converter.WishlistConverter;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import com.akhmadreiza.wishlisted.repository.WishlistRepository;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WishlistServiceImpl implements WishlistService {

    private GeneralUtil arautil = new GeneralUtil();
    private static List<Wishlists> staticList = new ArrayList<>();
    private static Wishlists staticWishlist =  new Wishlists();

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistConverter wishlistConverter;

    @Override
    public List<Wishlists> getAllWishlist() {
        List<Wishlists> allWishlists = new ArrayList<>();
        wishlistRepository.findAll().forEach(wishliststbl -> allWishlists.add(new Wishlists(wishliststbl)));
        return allWishlists;
    }

    @Override
    public List<Wishlists> getAllWishlistByUserName(String userName) {
        List<Wishlists> allUserWishlists = new ArrayList<>();
        List<Wishliststbl> wishliststbls = wishlistRepository.findAll();
        for (Wishliststbl wishliststbl : wishliststbls) {
            if (wishliststbl.getUserName().equals(userName)) {
                allUserWishlists.add(new Wishlists(wishliststbl));
            }
        }
        return allUserWishlists;
    }

    @Override
    public Wishlists getWishlistById(String id) {
        return new Wishlists(wishlistRepository.findById(id).get());
    }

    @Override
    public Wishlists getWishlistByIdAndUserName(String id, String userName) {
        Wishliststbl wishliststbl = wishlistRepository.findById(id).get();
        if (!wishliststbl.getUserName().equals(userName)) {
            throw new NoSuchElementException("No value present");
        }
        return new Wishlists(wishliststbl);
    }

    @Override
    public Wishlists addWishlist(Wishlists wishlists) {
        Wishliststbl wishliststbl = new Wishliststbl();
        wishlistConverter.convert(wishlists, wishliststbl);
        wishlistRepository.save(wishliststbl);
        return new Wishlists(wishlists.getId(), wishlists.getName(), wishlists.isCompleted());
    }

    @Override
    public Wishlists addWishlist(Wishlists wishlists, String userName) {
        Wishliststbl wishliststbl = new Wishliststbl();
        wishlistConverter.convert(wishlists, wishliststbl);
        wishliststbl.setUserName(userName);
        wishlistRepository.save(wishliststbl);
        return new Wishlists(wishlists.getId(), wishlists.getName(), wishlists.isCompleted());
    }

    @Override
    public Wishlists updateWishlists(Wishlists wishlists, String id) {
        Wishliststbl wishliststbl = wishlistRepository.findById(id).get();
        wishlistConverter.convert(wishlists, wishliststbl);
        wishlistRepository.save(wishliststbl);
        return new Wishlists(wishlists.getId(), wishlists.getName(), wishlists.isCompleted());
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
