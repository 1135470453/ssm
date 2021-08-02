package com.repository;

import com.entity.WebUser;

import java.util.List;

public interface WebUserRepository {
    public Integer getPriviegeByIdAndPwd(String id,String password);
    public String getIdById(String id);
    public void insetWebUser(WebUser webUser);
    public List<WebUser> getWebuser();
    public List<WebUser> getWebuserByID(String id);
    public void deleteUserById(String id);
    public void updataUser(String id,String password,String privilege,String id_p);
}
