package com.akhmadreiza.wishlisted.service;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import com.akhmadreiza.wishlisted.repository.WishlistRepository;
import com.ara27.arautil.general.GeneralUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class WishlistServiceImplTest {

    @InjectMocks
    private WishlistServiceImpl wishlistService;

    @Mock
    private WishlistRepository wishlistRepository;

    private GeneralUtil generalUtil = new GeneralUtil();
    private String wishlistsId = "";
    private String wishlistsName = "";

    @Before
    public void initTestSetup() {
        wishlistsId = generalUtil.getUUID();
        wishlistsName = "My first Wishlists test";
    }

    @Test
    public void getAllWishlists_test_success() {
        //mock objects and prepare data
        Wishliststbl wishliststbl = new Wishliststbl();
        wishliststbl.setId(wishlistsId);
        wishliststbl.setName(wishlistsName);
        List<Wishliststbl> wishliststblList = new ArrayList<>();
        wishliststblList.add(wishliststbl);

        Mockito.when(wishlistRepository.findAll()).thenReturn(wishliststblList);

        Wishlists wishlists = new Wishlists();
        wishlists.setId(wishlistsId);
        wishlists.setName(wishlistsName);
        List<Wishlists> expectedWishlists = new ArrayList<>();
        expectedWishlists.add(wishlists);

        //do test
        List<Wishlists> actualWishlists = wishlistService.getAllWishlist();

        //assertion
        Assert.assertEquals(expectedWishlists.get(0).getId(), actualWishlists.get(0).getId());
        Assert.assertEquals(expectedWishlists.get(0).getName(), actualWishlists.get(0).getName());
    }
}
