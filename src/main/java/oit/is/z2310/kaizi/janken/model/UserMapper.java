package oit.is.z2310.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM users")
  ArrayList<User> selectAllUsers();

  @Select("SELECT userName FROM users WHERE id = #{id}")
  String selectById(Integer id);
}
