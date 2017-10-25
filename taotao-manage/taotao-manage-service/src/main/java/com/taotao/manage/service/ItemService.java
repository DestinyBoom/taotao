package com.taotao.manage.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zb on 2017/10/24.
 */
@Service
public class ItemService extends BaseService<Item>{

    @Autowired
    private ItemDescService itemDescService;

    @Autowired
    private ItemMapper itemMapper;

    public void saveItem(Item item, String desc) {
        //保存商品基本数据
        item.setStatus(1);
        item.setId(null);//强制设置id为null
        super.save(item);

        //保存商品描述
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        this.itemDescService.save(itemDesc);
    }

    public PageInfo<Item> queryPageList(Integer page, Integer rows) {
        Example example = new Example(Item.class);
        example.setOrderByClause("updated Desc");

        //设置分页数
        PageHelper.startPage(page, rows);

        List<Item> list =this.itemMapper.selectByExample(example);

        return new PageInfo<Item>(list);
    }
}
