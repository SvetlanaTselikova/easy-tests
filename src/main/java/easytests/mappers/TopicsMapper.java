package easytests.mappers;

import easytests.entities.TopicEntity;
import java.util.List;
import org.apache.ibatis.annotations.*;


/**
 * @author malinink
 */
public interface TopicsMapper {
    @Results(
        id = "Topic",
        value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "subjectId", column = "subject_id")
        })
    @Select("SELECT * FROM topics")
    List<TopicEntity> findAll();

    @Select("SELECT * FROM topics where id=#{id}")
    @ResultMap("Topic")
    TopicEntity find(Integer id);

    @Insert("INSERT INTO topics (name, subject_id) VALUES(#{name}, #{subjectId})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(TopicEntity topic);

    @Update("UPDATE topics SET name=#{name}, subject_id=#{subjectId} WHERE id=#{id}")
    void update(TopicEntity topic);

    @Delete("DELETE FROM topics WHERE id=#{id}")
    void delete(TopicEntity topic);
}
