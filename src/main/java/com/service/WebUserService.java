package com.service;

import com.entity.WebUser;

import java.util.List;
import java.util.Map;

public interface WebUserService {
    public Map<String,String> login(String id, String password);
    public String regist(WebUser webUser);
    public List<WebUser> getWebuser();
    public List<WebUser> getWebuserByID(String id);
    public void deleteUserById(String id);
    public String updateUser(WebUser webUser,String id_p);
}
