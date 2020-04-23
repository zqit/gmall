package com.atguigu.gamll.user.service.impl;

import com.atguigu.gamll.user.bean.UmsMember;
import com.atguigu.gamll.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gamll.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gamll.user.mapper.UserMapper;
import com.atguigu.gamll.user.service.UserService;
import com.sun.deploy.panel.IProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;


    @Override
    public List<UmsMember> getAllUser() {

        List<UmsMember> umsMememberList= userMapper.selectAll();//userMapper.selectAllUser();
        return umsMememberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {

        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);
//        Example e = new Example(UmsMemberReceiveAddress.class);
//        e.createCriteria().andEqualTo("memberId",memberId);
//        umsMemberReceiveAddressMapper.selectByExample(e);

        return umsMemberReceiveAddresses;
    }
}
