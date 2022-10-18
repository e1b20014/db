package oit.is.lec4.table1.db.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ChamberMapper {

  @Select("SELECT id,userName,chamberName from chamber where id = #{id}")
  Chamber selectById(int id);

  @Insert("INSERT INTO chamber (userName,chamberName) VALUES (#{userName},#{chamberName});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(Chamber chamber);

  @Select("SELECT * from chamber where chamberName = #{chamberName}")
  ArrayList<Chamber> selectAllByChamberName(String chamberName);
}
