package com.lengyan.lybbs.elastic;

import com.lengyan.lybbs.model.Topic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TopicRepository extends ElasticsearchRepository<Topic, Integer> {

    /**
     * @Description:根据id区间查询
     * @Param id1
     * @Param id2
     */
    List<Topic> findByIdBetweenOrderByIdDesc(double id1, double id2);

    /**
     * @Description:根据标题查询
     * @Param title
     */
    List<Topic> findByTitle(String title);

}