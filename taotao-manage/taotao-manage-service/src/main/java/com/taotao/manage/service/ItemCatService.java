package com.taotao.manage.service;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zb on 2017/9/29.
 */
@Service
public class ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * 根据父节点id查询商品列表
     * @param parentId
     * @return
     */
    public List<ItemCat> queryItemCatListByParentId(Long parentId) {
        ItemCat record = new ItemCat();
        record.setParentId(parentId);
        return this.itemCatMapper.select(record);
    }
}
