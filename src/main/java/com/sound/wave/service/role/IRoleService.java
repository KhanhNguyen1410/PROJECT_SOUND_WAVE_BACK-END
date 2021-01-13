package com.sound.wave.service.role;

import com.sound.wave.model.Role;
import com.sound.wave.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findRoleByName(String name);
}
