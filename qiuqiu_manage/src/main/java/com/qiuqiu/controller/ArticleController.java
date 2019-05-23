package com.qiuqiu.controller;

import com.qiuqiu.service.QiuQiuUserArticleService;
import com.qiuqiu.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 帖子管理
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {
    @Autowired
    private QiuQiuUserArticleService qiuQiuUserArticleService;

    /**
     * 被封禁的文章
     * @param pageCurrent
     * @return
     */
    @RequestMapping("baned")
    @ResponseBody
    public JsonResult hasBanedArticle(Integer pageCurrent){
        return  qiuQiuUserArticleService.findHasBanedArticle(pageCurrent);
    }
    /**
     * 待审核的文章
     */
    @RequestMapping("wait")
    @ResponseBody
    public JsonResult witeExamineArticle(Integer pageCurrent){
        return qiuQiuUserArticleService.findWiteExamineArticle(pageCurrent);
    }
    /**
     * 通过审核的文章
     */
    @RequestMapping("adopt")
    @ResponseBody
    public JsonResult adoptExamineArticle(Integer pageCurrent){
        return qiuQiuUserArticleService.findAdoptExamineArticle(pageCurrent);
    }
    /**
     * 封禁帖子,被封禁的帖子类型为待审核和审核通过的帖子。
     */
    @RequestMapping("ban")
    @ResponseBody
    public JsonResult banArticle(Integer[] ids){
        return qiuQiuUserArticleService.banArticleByIds(ids);
    }
    /**
     * 解封帖子
     */
    @RequestMapping("unsealing")
    @ResponseBody
    public JsonResult UnsealingArticle(Integer[] ids){
        return qiuQiuUserArticleService.UnsealingArticleByIds(ids);
    }
}