package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 아이템_등록() throws Exception {
        //given
        Album album = new Album();
        album.setName("앨범");

        //when
        Long albumId = itemService.saveItem(album);

        //then
        assertEquals(album, itemRepository.findOne(albumId));
    }

    @Test
    public void 아이템_수정() throws Exception {
        //given
        Album album = new Album();
        album.setName("앨범");
        itemService.saveItem(album);

        //when
        album.setName("수정앨범");
        Long albumId = itemService.saveItem(album);

        //then
        assertEquals(album.getName(), itemRepository.findOne(albumId).getName());

    }

}