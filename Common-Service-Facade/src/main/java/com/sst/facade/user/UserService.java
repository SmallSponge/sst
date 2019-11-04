package com.sst.facade.user;

import com.sst.entity.user.*;
import com.sst.req.BatchReq;
import com.sst.req.user.*;

import java.util.List;

/**
 * @author 大闲人柴毛毛
 * @date 2017/11/1 上午10:06
 * @description
 */
public interface UserService {

    public UserEntity login(LoginReq loginReq);

    public List<UserEntity> findUsers(UserQueryReq userQueryReq);

    UserEntity register(RegisterReq registerReq);

    void batchUpdateUserState(BatchReq<UserStateReq> userStateReqs);

    void createAdminUser(AdminCreateReq adminCreateReq);

    List<RoleEntity> findRoles();

    void deleteRole(String roleId);

    void updateMenuOfRole(RoleMenuReq roleMenuReq);

    void updatePermissionOfRole(RolePermissionReq rolePermissionReq);

    List<PermissionEntity> findPermissions();

    List<MenuEntity> findMenus();

    List<LocationEntity> findLocations(String userId);

    String createLocation(LocationCreateReq locationCreateReq, String userId);

    void deleteLocation(String locationId, String userId);

    void modifyLocation(LocationUpdateReq locationUpdateReq, String userId);
}
