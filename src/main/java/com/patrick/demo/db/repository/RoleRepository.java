package com.patrick.demo.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.patrick.demo.db.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
