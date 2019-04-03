package com.akhmadreiza.wishlisted.converter;

import com.akhmadreiza.wishlisted.apis.Wishlists;
import com.akhmadreiza.wishlisted.entity.Wishliststbl;
import org.springframework.stereotype.Service;

@Service
public class WishlistConverter {
    public void convert(Object src, Object dest) {
        if (src instanceof Wishlists && dest instanceof Wishliststbl) {
            Wishlists source = (Wishlists) src;
            Wishliststbl destination = (Wishliststbl) dest;
            destination.setId(source.getId() == null || source.getId().isEmpty() ? destination.getId() : source.getId());
            destination.setCompleted(source.isCompleted());
            destination.setCreatedBy(source.getCreatedBy() == null || source.getCreatedBy().isEmpty() ? destination.getCreatedBy() : source.getCreatedBy());
            destination.setDtCreated(source.getDtCreated() == null || source.getDtCreated().isEmpty() ? destination.getDtCreated() : source.getDtCreated());
            destination.setDtUpdated(source.getDtUpdated() == null || source.getDtUpdated().isEmpty() ? destination.getDtUpdated() : source.getDtUpdated());
            destination.setName(source.getName() == null || source.getName().isEmpty() ? destination.getName() : source.getName());
            destination.setUpdatedBy(source.getUpdatedBy() == null || source.getUpdatedBy().isEmpty() ? destination.getUpdatedBy() : source.getUpdatedBy());
        }
    }
}
