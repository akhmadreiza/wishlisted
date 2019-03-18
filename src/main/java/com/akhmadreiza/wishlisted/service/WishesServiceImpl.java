package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishes;
import com.akhmadreiza.wishlisted.entity.Wishestbl;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import com.akhmadreiza.wishlisted.repository.WishesRepository;
import com.akhmadreiza.wishlisted.repository.WishlistRepository;
import com.ara27.arautil.general.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishesServiceImpl implements WishesService {

    @Autowired
    private WishesRepository wishesRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public List<Wishes> getAllWishes(String wishlistId) {
        List<Wishes> result = new ArrayList<>();

        Wishliststbl wishliststbl = wishlistRepository.getOne(wishlistId);
        List<Wishestbl> listWishestbl = wishliststbl.getWishestbl();
        for (Wishestbl wishestbl : listWishestbl) {
            Wishes wishes = new Wishes();
            wishes.setName(wishestbl.getName());
            wishes.setChecked(wishestbl.isChecked());
            wishes.setDtCreated(wishestbl.getDtCreated());
            wishes.setDtUpdated(wishestbl.getDtUpdated());
            result.add(wishes);
        }

        return result;
    }

    @Override
    public Wishes getWish(String wishlistsId, String wishId) {
        return null;
    }

    @Override
    public Wishes addWish(String wishlistId, Wishes wishes) {
        GeneralUtil generalUtil = new GeneralUtil();

        Wishliststbl wishliststbl = wishlistRepository.getOne(wishlistId);

        Wishestbl wishestbl = new Wishestbl();
        wishestbl.setId(generalUtil.getUUID());
        wishestbl.setDtCreated(generalUtil.getCurrentLocalDateTime());
        wishestbl.setName(wishes.getName());
        wishestbl.setChecked(wishes.isChecked());
        wishestbl.setWishliststbl(wishliststbl);
        wishesRepository.save(wishestbl);

        return wishes;
    }

    @Override
    public Wishes updateWish(String wishlistId) {
        return null;
    }
}
