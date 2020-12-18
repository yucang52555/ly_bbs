///**
// * Copyright (C), 2019, XXX有限公司
// * FileName: ElasticSearchTest
// * Author:   kangtiancheng
// * Date:     2019/12/11 11:08
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.lengyan.lybbs;
//
//import com.lengyan.lybbs.elastic.TopicRepository;
//import com.lengyan.lybbs.model.Topic;
//import com.lengyan.lybbs.service.TopicService;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.sort.SortBuilder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * 〈es测试〉
// * @author kangtiancheng
// * @create 2019/12/11
// * @since 1.0.0
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ElasticSearchTest {
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    @Autowired
//    private TopicRepository topicRepository;
//
//    @Autowired
//    TopicService topicService;
//
//    @Test
//    public void createIndex() {
//        elasticsearchTemplate.createIndex(Topic.class);
//    }
//
//    @Test
//    public void deleteIndex() {
//        elasticsearchTemplate.deleteIndex(Topic.class);
//    }
//
//    @Test
//    public void insertDoc() {
//        Topic topic = topicService.selectById(1);
//        topicRepository.save(topic);
//    }
//
//    @Test
//    public void deleteDoc() {
//        Topic topic = topicService.selectById(1);
//        topicRepository.delete(topic);
//    }
//
//    @Test
//    public void saveAll() {
////        List<Topic> topicList = new ArrayList<>();
////        topicList.add(topicService.selectById(1));
////        topicList.add(topicService.selectById(2));
////        topicList.add(topicService.selectById(3));
////        topicList.add(topicService.selectById(4));
////        topicList.add(topicService.selectById(5));
////        topicList.add(topicService.selectById(6));
////        topicList.add(topicService.selectById(7));
////        topicList.add(topicService.selectById(8));
////        topicList.add(topicService.selectById(9));
////        topicList.add(topicService.selectById(10));
////        topicList.add(topicService.selectById(11));
////        topicList.add(topicService.selectById(12));
//        List<Topic> topicList = topicService.selectAllForElastic();
//        topicRepository.saveAll(topicList);
//    }
//
//    @Test
//    public void deleteAll() {
//        topicRepository.deleteAll();
//    }
//
//    @Test
//    public void testQuery() {
////        Iterable<Topic> topicList = topicRepository.findAll(Sort.by("id").ascending());
//        List<Topic> topicList = topicRepository.findByIdBetweenOrderByIdDesc(3,7);
////        List<Topic> topicList = topicRepository.findByTitle("老年人吃早餐不应该太早");
//        for (Topic topic : topicList) {
//            System.out.println(topic);
//        }
//    }
//
//    @Test
//    public void testUserDefineQuery() {
//        // 构建查询条件
//        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
//        // 添加基本分词查询
////        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "老年人"));
//        queryBuilder.withQuery(QueryBuilders.commonTermsQuery("title", "老年人"));
//        // 搜索，获取结果
//        Page<Topic> topicList = this.topicRepository.search(queryBuilder.build());
//        // 总条数
//        long total = topicList.getTotalElements();
//        System.out.println("total = " + total);
//        for (Topic topic : topicList) {
//            System.out.println(topic);
//        }
//    }
//}
